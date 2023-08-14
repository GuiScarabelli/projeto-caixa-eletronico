import DataAcessObject.UsuarioDAO;
import entidades.Usuario;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        Usuario user = new Usuario();

        System.out.println("Digite seu nome");
        String nome = entrada.nextLine();
        user.setNome(nome);

        System.out.println("Digite um login");
        String login = entrada.nextLine();
        user.setLogin(login);

        System.out.println("Digite uma senha");
        String senha = entrada.nextLine();
        user.setSenha(senha);

        if(!new UsuarioDAO().cadastrarUsuario(user)){
            System.out.println("Usuario cadastrado com sucesso!");
        } else {


            System.out.println("Algo deu errado :(");
        }
    }
}
