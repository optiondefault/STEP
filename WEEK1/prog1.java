import java.util.Random;
import java.util.Scanner;

public class prog1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] options = {"Rock", "Paper", "Scissors"};
        
        int rounds = 5;
        String[] playerMoves = new String[rounds];
        String[] computerMoves = new String[rounds];
        String[] results = new String[rounds];
        
        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.println("Welcome to Rock-Paper-Scissors!");
        
        for (int i = 0; i < rounds; i++) {
            System.out.print("Round " + (i + 1) + " - Enter your move (Rock, Paper, Scissors): ");
            String playerMove = scanner.nextLine();
            
            // For live demo without user input, we could use predefined or random, 
            // but we'll accept input for interactive play or just randomly generate if empty.
            if (playerMove.isEmpty()) {
                playerMove = options[random.nextInt(3)];
                System.out.println("Auto-selected: " + playerMove);
            }
            
            String computerMove = options[random.nextInt(3)];
            
            playerMoves[i] = playerMove;
            computerMoves[i] = computerMove;
            results[i] = playRound(playerMove, computerMove);
            
            if (results[i].equals("Player Wins")) {
                wins++;
            } else if (results[i].equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
            
            System.out.println("Round " + (i + 1) + " — Player: " + playerMove + ", Computer: " + computerMove + " -> " + results[i]);
        }
        
        System.out.println("\nSummary Table:");
        System.out.println("Round | Player Move | Computer Move | Result");
        for (int i = 0; i < rounds; i++) {
            System.out.printf("%5d | %11s | %13s | %s\n", (i + 1), playerMoves[i], computerMoves[i], results[i]);
        }
        
        double winPercentage = ((double) wins / rounds) * 100;
        System.out.println("\nFinal Summary (after " + rounds + " rounds)");
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%\n", wins, losses, draws, winPercentage);
        
        scanner.close();
    }

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        
        if (playerMove.equalsIgnoreCase("Rock")) {
            return computerMove.equalsIgnoreCase("Scissors") ? "Player Wins" : "Computer Wins";
        } else if (playerMove.equalsIgnoreCase("Paper")) {
            return computerMove.equalsIgnoreCase("Rock") ? "Player Wins" : "Computer Wins";
        } else if (playerMove.equalsIgnoreCase("Scissors")) {
            return computerMove.equalsIgnoreCase("Paper") ? "Player Wins" : "Computer Wins";
        }
        
        return "Invalid Move";
    }
}
