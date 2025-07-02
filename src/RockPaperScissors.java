import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String playAgain;

        do {
            String playerA = getPlayerMove(input, "Player A");
            String playerB = getPlayerMove(input, "Player B");

            determineWinner(playerA, playerB);

            System.out.print("Do you wan to play again? Y/N: ");
            playAgain = input.nextLine();

        } while (playAgain.equalsIgnoreCase("Y"));

        System.out.println("Thank you for playing!");
    }

    public static String getPlayerMove(Scanner input, String playerName) {
        String move;
        while (true) {
            System.out.print(playerName + ", enter your move R, P, or S: ");
            move = input.nextLine();
            if (move.equalsIgnoreCase("R") || move.equalsIgnoreCase("P") || move.equalsIgnoreCase("S")) {
                break;
            } else {
                System.out.println("Invalid input. Please enter R, P, or S.");
            }
        }
        return move.toUpperCase();
    }

    public static void determineWinner(String a, String b) {
        System.out.print("Player A chose " + convertToWord(a) + ", Player B chose " + convertToWord(b) + " – ");

        if (a.equals(b)) {
            System.out.println("It's a Tie!");
        } else if ((a.equals("R") && b.equals("S")) ||
                (a.equals("P") && b.equals("R")) ||
                (a.equals("S") && b.equals("P"))) {
            System.out.println(getResult(a, b) + " – Player A wins!");
        } else {
            System.out.println(getResult(b, a) + " – Player B wins!");
        }
    }

    public static String convertToWord(String move) {
        switch (move) {
            case "R": return "Rock";
            case "P": return "Paper";
            case "S": return "Scissors";
            default: return "";
        }
    }

    public static String getResult(String winner, String loser) {
        if (winner.equals("R") && loser.equals("S")) {
            return "Rock breaks Scissors";
        } else if (winner.equals("P") && loser.equals("R")) {
            return "Paper covers Rock";
        } else if (winner.equals("S") && loser.equals("P")) {
            return "Scissors cuts Paper";
        }
        return "";
    }
}
