package TicTacToe;

public class Board {
    int size;
    Piece[][] board;

    Board(int size) {
        this.size = size;
        board = new Piece[size][size];
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            System.out.print(" |   ");
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].pieceType.name() + "  ");
                }
                else {
                    System.out.print("   ");
                }
                System.out.print(" |   ");
            }
            System.out.println();
        }
    }

    public boolean hasFreeCells() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) return true;
            }
        }
        return false;
    }

    public boolean addPiece(int row, int col, Piece piece) {
        if (row < 0 || row >= size || col < 0 || col >= size || board[row][col] != null) return false;
        board[row][col] = piece;
        return true;
    }

    public boolean isWinner(int row, int col, PieceType pieceType) {
        boolean rowMatch = true, colMatch = true;
        for (int i = 0; i < size; i++) {
            if (board[row][i] == null || board[row][i].pieceType != pieceType) {
                rowMatch = false;
                break;
            }
        }
        for (int i = 0; i < size; i++) {
            if (board[i][col] == null || board[i][col].pieceType != pieceType) {
                colMatch = false;
                break;
            }
        }
        if (rowMatch || colMatch) {
            return true;
        }
        if (row != col) return false;
        boolean diagonalMatch = true, antiDiagonalMatch = true;
        for (int i = 0, j = 0; i < size; i++, j++) {
            if (board[i][j] == null || board[i][j].pieceType != pieceType) {
                diagonalMatch = false;
                break;
            }
        }
        for (int i = size - 1, j = 0; i >= 0; i--, j++) {
            if (board[i][j] == null || board[i][j].pieceType != pieceType) {
                antiDiagonalMatch = false;
                break;
            }
        }
        return diagonalMatch || antiDiagonalMatch;
    }
}
