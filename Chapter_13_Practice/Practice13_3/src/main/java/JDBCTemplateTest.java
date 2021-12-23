

import java.util.List;

public class JDBCTemplateTest {

    public static void main(String[] args){
        try{
            String sql = "SELECT* FROM CLUB";
            JdbcTemplate template = new JdbcTemplate();
            List<Club> players = template.query(sql, new ClubRowMapper());
            players.stream().forEach(System.out::println);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}