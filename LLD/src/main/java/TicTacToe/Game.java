package TicTacToe;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Game {
    Deque<Player> players;
    Board board;
    Scanner input;

    Game() {
        init();
    }

    private void init() {
        players = new LinkedList<>();
        input = new Scanner(System.in);

        char symbol;
        do {
            System.out.println("Choose valid piece for player 1 : ");
            symbol = input.next().charAt(0);
        } while (PieceType.fromSymbol(symbol) == PieceType.EMPTY);

        Player p1 = new Player("p1", new Piece(PieceType.fromSymbol(symbol)));
        do {
            System.out.println("Choose valid piece for player 2 : ");
            symbol = input.next().charAt(0);
        } while (PieceType.fromSymbol(symbol) == PieceType.EMPTY ||
                PieceType.fromSymbol(symbol) == p1.getPiece().pieceType);
        Player p2 = new Player("p2", new Piece(PieceType.fromSymbol(symbol)));

        players.add(p1);
        players.add(p2);

        System.out.println("Choose size for nxn board : ");
        board = new Board(input.nextInt());
        board.printBoard();
    }

    public String start() {
        while (true) {
            Player currentPlayer = players.poll();

            //get free cells
            if (!board.hasFreeCells()) {
                break;
            }
            System.out.println("Player turn : " + currentPlayer.getName());

            //add piece to cell
            input = new Scanner(System.in);
            System.out.print("Enter position where you want to place your piece [row,column] : ");
            String inputCell = input.nextLine();
            String[] inputCellValues = inputCell.split(",");
            int row = Integer.parseInt(inputCellValues[0]);
            int col = Integer.parseInt(inputCellValues[1]);
            if (!board.addPiece(row, col, currentPlayer.getPiece())) {
                System.out.println("Incorrect cell. Please choose an empty and valid cell");
                players.addFirst(currentPlayer);
                continue;
            }
            board.printBoard();
            players.addLast(currentPlayer);

            //check for winner
            if (board.isWinner(row, col, currentPlayer.getPiece().pieceType)) {
                return currentPlayer.getName();
            }
        }
        return "tie";
    }
}
