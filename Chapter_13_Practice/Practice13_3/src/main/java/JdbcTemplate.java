import java.sql.*;


public class JdbcTemplate {
    public <T> T execute(StatementCallback<T> action) {
        T result  = null;

        //Connection에서 계속 NullException이 났는데
        //Library에 ProgramFilex(x86)에 있는 H2/bin/.jar를 import하니 실행되었다
        //Driver가 연결이 안되었는데 포함시켜줌
        String url = "jdbc:h2:file:C:/Users/rudnf/IdeaProjects/Practice13_3/src/main/resources/db";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();){
            result = action.doInStatement(stmt);
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println(ex);
        }
        return result;
    }

    public <T> T query(final String sql, RowMapper<T> mapper){
        class QueryStatementCallback implements StatementCallback<T>{
            @Override
            public T doInStatement(Statement stmt) throws SQLException {
                T result = null;
                try(ResultSet rs = stmt.executeQuery(sql);){
                    result = mapper.mapRow(rs);
                }
                return result;
            }
        }
        return execute(new QueryStatementCallback());
    }

    public static interface StatementCallback <T>{
        T doInStatement(Statement stmt) throws SQLException;
    }

    public static interface RowMapper <T>{
        T mapRow(ResultSet rs) throws SQLException;
    }





}


