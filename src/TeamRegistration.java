import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TeamRegistration {

    public static void registerTeam() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter team name: ");
        String teamName = scanner.nextLine();
        System.out.print("Enter city: ");
        String city = scanner.nextLine();
        System.out.print("Enter number of players: ");
        int playersCount = scanner.nextInt();

        String query = "INSERT INTO teams (team_name, city, players_count) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, teamName);
            ps.setString(2, city);
            ps.setInt(3, playersCount);
            ps.executeUpdate();
            System.out.println("Team registered successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        registerTeam();
    }
}
