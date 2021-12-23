package JDBCTemplate;

import java.util.List;

public class JDBCTemplateTest {
    public static void main(String[] args){
        //String sql = "SELECT * FROM PLAYER_VIEW";
        String sql = "SELECT *\n" +
                "FROM PLAYER_VIEW\n" +
                "WHERE SHORT_NAME = 'L. Messi'";
        JdbcTemplate template = new JdbcTemplate();
        List<Player> players =  template.query(sql, new PlayerRowMapper());
        players.stream().forEach(System.out::println);
    }
}
