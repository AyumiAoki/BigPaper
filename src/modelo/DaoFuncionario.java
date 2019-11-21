package modelo;

import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ayumi, Cecília, Fátima e Kallyne
 */

public class DaoFuncionario {
    
    public int i = 0;
    public boolean aux = true;
    private Connection con = null;
    
    public DaoFuncionario(){
        
        con = ConnectionFactory.getConnection();
    }
    
    public boolean inserirFuncionario(Funcionario fun){
        
        String sql = "insert into Funcionario VALUES (?,?,?,?)";
        
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, fun.getNome());
            stmt.setString(2, fun.getCpf());
            stmt.setString(3, fun.getUsuario());
            stmt.setString(4, fun.getSenha());
            stmt.executeUpdate();
            stmt.close();
            con.close();
            return true;
            
        } catch (SQLException ex) {
            return false;
            
        }finally{
            ConnectionFactory.CloseConnection(con, stmt);
        }
    }
    
    
    public List<Funcionario> listaFuncionario(){
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        i = 0;
        
        List<Funcionario> fun = new ArrayList<Funcionario>();        
        
        try {
            stmt = con.prepareStatement("select * from Funcionario");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Funcionario funcionario = new Funcionario();
                
                funcionario.setNome(rs.getString("Nome"));
                funcionario.setCpf(rs.getString("Cpf"));
                funcionario.setUsuario(rs.getString("Usuario"));
                fun.add(funcionario);
                i++;
            }
           
        } catch (SQLException ex) {
            aux = false;
        }finally{
            
            ConnectionFactory.CloseConnection(con, stmt, rs);
        }
        return fun;    
    }
    
    public boolean buscarFuncionario(String nome, String senha){
        
        String sql = "select * from Funcionario where usuario = ? and senha = ?";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean encontrou = false;
                
        try {
            System.out.println("1");
            stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, senha);
            System.out.println("2");
            rs = stmt.executeQuery();
            System.out.println("3");
            
            while(rs.next()){
                encontrou = true;
            }
        } catch (SQLException ex) {
        }finally{
            ConnectionFactory.CloseConnection(con, stmt, rs);
        }
        
        return encontrou;       
    }
    
    public boolean atualizarFuncionario(Funcionario f, String cpf){
        
        String sql = "update Funcionario set nome = ?, cpf = ?, usuario = ? where cpf = ?";
        
        PreparedStatement stmt = null;
        try {
            
            stmt = con.prepareStatement(sql);
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getCpf());
            stmt.setString(3, f.getUsuario());
            stmt.setString(4, cpf);
            stmt.executeUpdate();
            
            return true;
                  
        } catch (SQLException ex) {
            return false;
            
        }finally{
            ConnectionFactory.CloseConnection(con, stmt);
        }
    }
    
    public boolean excluirFuncionario(Funcionario f){
        
        String sql = "delete from Funcionario where cpf = ?";
        
        PreparedStatement stmt = null;
        try {
            
            stmt = con.prepareStatement(sql);
            stmt.setString(1, f.getCpf());
            stmt.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            return false;
            
        }finally{
            ConnectionFactory.CloseConnection(con, stmt);
        }
    }
}
