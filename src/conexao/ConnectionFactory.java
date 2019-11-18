package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ayumi, Cecília, Fátima e Kallyne
 */

public class ConnectionFactory {
    
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/BigPaper";
    private static final String user = "root";
    private static final String pass = "root";
    
    public static Connection getConnection(){
        
        try {
            Class.forName(driver);
            
            return DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("Erro na conexão", ex);
        } catch (SQLException ex) {
            throw new RuntimeException("Erro na conexão", ex);
        }
    }
    
    public static void CloseConnection(Connection con){
        
        if(con != null){
            
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println("Erro: " + ex);
            }
        }
    }
    public static void CloseConnection(Connection con, PreparedStatement stmt){
        
        if(stmt != null){
            
            try {
                stmt.close();
            } catch (SQLException ex) {
                System.err.println("Erro: " + ex);            
            }
        }
        
        CloseConnection(con);
    }
    
    public static void CloseConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        
        if(rs != null){
            
            try {
                rs.close();
            } catch (SQLException ex) {
                System.err.println("Erro: " + ex);
            }
        }
        
        CloseConnection(con, stmt);
    }
   
}
