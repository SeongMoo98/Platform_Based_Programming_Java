package JDBCTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerRowMapper implements RowMapper<List<Player>>{
    @Override
    public List<Player> mapRow(ResultSet rs) throws SQLException {
        List<Player> players = new ArrayList<>();
        while(rs.next()){
            int id = rs.getInt("ID");
            String name = rs.getString("SHORT_NAME");
            int height = rs.getInt("height_cm");
            String countryName = rs.getString("country_name");
            String clubName = rs.getString("club_name");
            int overall = rs.getInt("overall");
            String positions = rs.getString("Player_Positions");

            Player player= new Player(id, name, height, countryName, clubName, overall,
                    Arrays.asList(positions.split(",")));
            players.add(player);
        }
        return players;

    }
}
