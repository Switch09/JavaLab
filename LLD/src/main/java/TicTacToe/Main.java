package TicTacToe;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        String res = game.start();
        if (res.equals("tie")) {
            System.out.println("draw");
        }
        else {
            System.out.println("Winner is : " + res);
        }
    }
}
