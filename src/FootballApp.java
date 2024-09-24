import java.util.Scanner;

public class FootballApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Register Team");
            System.out.println("2. Schedule Match");
            System.out.println("3. View Scheduled Matches");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    TeamRegistration.registerTeam();
                    break;
                case 2:
                    MatchScheduler.scheduleMatch();
                    break;
                case 3:
                    ViewScheduledMatches.viewMatches();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
