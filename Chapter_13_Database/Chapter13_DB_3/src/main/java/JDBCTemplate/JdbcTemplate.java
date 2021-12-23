package JDBCTemplate;


import java.sql.*;

public class JdbcTemplate {
    public <T> T execute(StatementCallback<T> action){
        T result = null;
        String  url = "jdbc:h2:file:C:/Users/rudnf/IdeaProjects/Chapter13_DB_3/src/main/resources/db";
        try(Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();){
            result = action.doInStatement(stmt);
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        return result;
    }

    public <T> T query(final String sql, RowMapper<T> mapper) {
        class QueryStatementCallBack implements StatementCallback<T> {
            @Override
            public T doInStatement(Statement stmt) throws SQLException {
                T result = null;
                try (ResultSet rs = stmt.executeQuery(sql)) {
                    result = mapper.mapRow(rs);
                }
                return result;

            }
        }
        return execute(new QueryStatementCallBack());
    }
}
