import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class ViewScheduledMatches {

    public static void viewMatches() {
        String query = "SELECT m.id, t1.team_name AS team1, t2.team_name AS team2, m.match_date, m.location " +
                "FROM matches m " +
                "JOIN teams t1 ON m.team1_id = t1.id " +
                "JOIN teams t2 ON m.team2_id = t2.id";

        try (Connection conn = DatabaseConnection.getConnection(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println("Match ID: " + rs.getInt("id") +
                        ", " + rs.getString("team1") + " vs " + rs.getString("team2") +
                        ", Date: " + rs.getDate("match_date") +
                        ", Location: " + rs.getString("location"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        viewMatches();
    }
}
