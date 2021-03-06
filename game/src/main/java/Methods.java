import java.util.Random;
import java.util.Scanner;

public class Methods {


    public static boolean isGameFinished(char[][] board) {

        if (whoHasWon(board, 'X')) {
            printBoard(board);
            System.out.println();
            System.out.println("Congratulations, You WON!");
            return true;
        }
        if (whoHasWon(board, 'O')) {
            printBoard(board);
            System.out.println();
            System.out.println("Sorry, You lost! Try again!");
            return true;
        }


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        printBoard(board);
        System.out.println("The game ended in a tie!");
        return true;
    }

    public static boolean whoHasWon(char[][] board, char symbol) {
        if ((board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) || // rows check
                (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) ||
                (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) || //column check
                (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol) ||
                (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) || //diagonal check
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)) {
            return true;
        }
        return false;
    }

    public static void computerTurn(char[][] board) {
        Random rand = new Random();
        int computerMove;
        while (true) {
            computerMove = rand.nextInt(9) + 1;
            if (isValidMove(board, Integer.toString(computerMove))) {
                break;
            }
        }
        System.out.println();
        System.out.println("----------------");
        System.out.println("Computer chose - " + computerMove);
        placeMove(board, computerMove, 'O');
        printBoard(board);
    }


    public static boolean isValidMove(char[][] board, String position) {
        if ("1".equals(position)) {
            return (board[0][0] == ' ');
        } else if ("2".equals(position)) {
            return (board[0][1] == ' ');
        } else if ("3".equals(position)) {
            return (board[0][2] == ' ');
        } else if ("4".equals(position)) {
            return (board[1][0] == ' ');
        } else if ("5".equals(position)) {
            return (board[1][1] == ' ');
        } else if ("6".equals(position)) {
            return (board[1][2] == ' ');
        } else if ("7".equals(position)) {
            return (board[2][0] == ' ');
        } else if ("8".equals(position)) {
            return (board[2][1] == ' ');
        } else if ("9".equals(position)) {
            return (board[2][2] == ' ');
        }
        return false;
    }


    public static void playerMove(Scanner scanner, char[][] board, String playerName) {
        String playerInput;
        while (true) {
            System.out.println();
            System.out.println(playerName + ", what will be Your move (1-9)?");
            playerInput = scanner.next();
            if (isValidMove(board, playerInput)) {
                break;
            } else {
                System.out.println(playerName + ", Your input " + playerInput + " is not valid move.");
            }
        }
        placeMove(board, Integer.parseInt(playerInput), 'X');
    }

    public static void placeMove(char[][] board, int position, char symbol) {
        switch (position) {
            case 1:
                board[0][0] = symbol;
                break;
            case 2:
                board[0][1] = symbol;
                break;
            case 3:
                board[0][2] = symbol;
                break;
            case 4:
                board[1][0] = symbol;
                break;
            case 5:
                board[1][1] = symbol;
                break;
            case 6:
                board[1][2] = symbol;
                break;
            case 7:
                board[2][0] = symbol;
                break;
            case 8:
                board[2][1] = symbol;
                break;
            case 9:
                board[2][2] = symbol;
                break;
            default:
                System.out.println("Invalid input!");

        }
    }

    public static void printBoard(char[][] board) {
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
    }

}
