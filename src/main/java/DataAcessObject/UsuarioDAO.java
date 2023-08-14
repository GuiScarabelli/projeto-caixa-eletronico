package DataAcessObject;
import conexao.Conexao;
import entidades.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// A classe vai servir para criar metodos que fazem conexao com o banco
public class UsuarioDAO {
    public boolean cadastrarUsuario (Usuario usuario){
        String sql = "INSERT INTO USUARIO (nome, login, senha) VALUES (?, ?, ?)";
        PreparedStatement ps = null;
        try{
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getLogin());
            ps.setString(3, usuario.getSenha());

            ps.execute();
        } catch (SQLException e ){
            e.printStackTrace();
        }
        return false;
    }

    public String selectUsuario (){
        String sql = "SELECT * FROM USUARIO";
        PreparedStatement ps = null;
        ResultSet rs = null; // ResultSet é uma classe utilizada para poder realizar os selects
        try{
            ps = Conexao.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();
            System.out.println("Id\t\tName\t\tAge ");

            while(rs.next()) { // o  next é para ele mover ara a prox. linha
                System.out.print(rs.getInt(1)); //os metódos get... servem para obter os valores de uma determinada linha
                System.out.print("\t\t"+rs.getString(2));
                System.out.print("\t\t"+rs.getString(3));
                System.out.println();
            }
            ps.execute();
        } catch (SQLException e ){
            e.printStackTrace();
        }
        return sql;
    }
}
