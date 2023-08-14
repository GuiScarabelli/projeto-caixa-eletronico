package DataAcessObject;
import conexao.Conexao;
import entidades.Usuario;
import java.sql.PreparedStatement;
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
}
