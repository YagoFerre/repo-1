package br.com.yagoferreira.web.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ConnectionPostgres {
    // Criando variáveis para os parâmetros de conexão.
    private final String driver = "org.postgresql.Driver";
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "123456";

    // Método de conexão.
    private Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    // Teste de conexão.
    public void connectionTest() {
        try {
            Connection con = getConnection();
            System.out.println(con);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Criar usuário.
    public void createUser(Usuario userData) {
        try {
            Connection con = getConnection();
            PreparedStatement st = con.prepareStatement("INSERT INTO usuario (nome, profissao, idade) VALUES (?, ?, ?);");

            st.setString(1, userData.getNome());
            st.setString(2, userData.getProfissao());
            st.setInt(3, userData.getIdade());

            st.execute();
            st.close();

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Listar todos os usuário no PostgreSQL.
    public ArrayList<Usuario> listAllUser() {
        ArrayList<Usuario> users = new ArrayList<>();
        try {
            Connection con = getConnection();
            PreparedStatement st = con.prepareStatement("SELECT * FROM usuario"); // Talvez um ; pode resolver
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt(1);
                String nome = rs.getString(2);
                String profissao = rs.getString(3);
                Integer idade = rs.getInt(4);

                users.add(new Usuario(id, nome, profissao, idade));
            }
            con.close();
            return users;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public void deleteUser(Integer id) {
        try {
            Connection con = getConnection();
            PreparedStatement st = con.prepareStatement("DELETE FROM usuario WHERE id = ?");
            st.setInt(1, id);
            st.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
