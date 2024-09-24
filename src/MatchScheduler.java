import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;

public class MatchScheduler {

    public static void scheduleMatch() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Available teams: ");
        displayTeams(); // Função para listar times cadastrados

        System.out.print("Enter the ID of the first team: ");
        int team1Id = scanner.nextInt();

        System.out.print("Enter the ID of the second team: ");
        int team2Id = scanner.nextInt();

        scanner.nextLine();  // Consumir o restante da linha

        System.out.print("Enter match location: ");
        String location = scanner.nextLine();

        System.out.print("Enter match date (YYYY-MM-DD): ");
        String matchDate = scanner.nextLine();

        String query = "INSERT INTO matches (team1_id, team2_id, match_date, location) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, team1Id);
            ps.setInt(2, team2Id);
            ps.setString(3, matchDate);
            ps.setString(4, location);
            ps.executeUpdate();
            System.out.println("Match scheduled successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void displayTeams() {
        String query = "SELECT * FROM teams";
        try (Connection conn = DatabaseConnection.getConnection(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println("Team ID: " + rs.getInt("id") + ", Team Name: " + rs.getString("team_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        scheduleMatch();
    }
}
