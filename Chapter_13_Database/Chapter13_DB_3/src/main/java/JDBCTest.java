/**
 * JDBC ( Java DataBase Connectivity)
 * Java application과 Database 사이에 communication
 *
 * 1. Establishing a connection
 * 2. Create a statement
 * 3. Execute a Query
 * 4. Process the ResultSet Object
 * 5. Close the Connection
 *
 * 1)
 * Connection
 * Connection with data source
 * DataBase file path -> String 으로 해서
 * Connection connection = DriverManager.getConnection(String url);
 *
 * 2)
 * Statement
 * SQL Statement를 나타내는 interface
 * Statement를 execute하면 ResultSet Object를 만들어서 return
 * Statement statement  = connection.createStatement();
 *
 * 3)
 * Query
 * Statement의 execute 메소드로 Query를 execute
 * * execute() - Query에 대한 ResultSet이 존재하면 true return
 * * executeQuery() - Query에 대한 ResultSet return
 * * executeUpdate() - SQL의 INSERT, DELETE, UPDATE를 사용할 때, table의 row중 바뀐 row의 수 return
 *
 * 4)
 * ResultSet
 * Database result set을 나타내는 table of data
 * cursor : indicate one row of data
 * resultset.next() - cursor를 next row로 이동, 마지막 row가 되면 false return
 * ResultSet resultSet = statement.executeQuery(String SQL);
 *
 * 5)
 * Auto Close가 지원된다
 * connection.close();
 * statement.close();
 * resultSet.close();
 *
 */

import java.sql.*;
import java.sql.SQLException;
public class JDBCTest {

    public static void main(String[] args){
//        String sql = "SELECT B.ID, B.SHORT_NAME, A.CLUB_NAME, B.PLAYER_POSITIONS\n" +
//                "FROM CLUB A INNER JOIN PLAYER B ON A.ID = B.CLUB_ID\n" +
//                "WHERE A.CLUB_NAME = 'FC Barcelona';";
//
//        String url = "jdbc:h2:file:C:/Users/rudnf/IdeaProjects/Chapter13_DB_3/src/main/resources/db";
//        try (Connection conn = DriverManager.getConnection(url);
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery(sql);) {
//            while(rs.next()){
//                int Id= rs.getInt("ID");
//                String playerName = rs.getString("SHORT_NAME");
//                String clubName = rs.getString("CLUB_NAME");
//                String positions= rs.getString("PLAYER_POSITIONS");
//                System.out.printf("%d, %s, %s, %s%n", Id, playerName, clubName, positions);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        String sql1 = "SELECT B.*\n"+
                "FROM CLUB A, PLAYER B\n"+
                "WHERE A.CLUB_NAME ='FC Barcelona' AND A.ID = B.CLUB_ID ;";
                String url1 =  "jdbc:h2:file:C:/Users/rudnf/IdeaProjects/Chapter13_DB_3/src/main/resources/db";
                try(Connection conn = DriverManager.getConnection(url1);
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(sql1);){
                    while(rs.next()){
                        int id = rs.getInt("ID");
                        int soFifaId = rs.getInt("SOFIFA_ID");
                        String playerName = rs.getString("SHORT_NAME");
                        int height = rs.getInt("HEIGHT_CM");
                        int countryId = rs.getInt("COUNTRY_ID");
                        int clubID = rs.getInt("CLUB_ID");
                        String positions = rs.getString("PLAYER_POSITIONS");
             System.out.printf("%d, %d, %s, %d, %d, %d, %s%n", id, soFifaId,playerName, height,countryId,clubID,positions);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }


//    public static void printSQLException(SQLException ex){
//        for(Throwable e : ex){
//            if(e instanceof  SQLException){
//                if((ignoreSQLException(((SQLException)e).getSQLState())==false){
//                    e.printStackTrace(System.err);
//                    System.err.println("SQLState : " + ((SQLException) e).getSQLState());
//                    System.err.println("Error Code: " + ((SQLException)e).getErrorCode());
//                    System.err.println("Message: " + e.getMessage());
//                    Throwable t = ex.getCause();
//                    while(t!=null){
//                        System.out.println("Cause : "+t);
//                        t=t.getCause();
//                    }}}}}



}
