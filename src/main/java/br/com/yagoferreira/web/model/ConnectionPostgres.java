package br.com.yagoferreira.web.model;

import br.com.yagoferreira.web.conexoes.HibernateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            String result = (String) session.createNativeQuery("select version()").getSingleResult();
            System.out.println(result);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Criar usuário.
    public void createUser(Usuario userData) {
        try {
            // Connection con = getConnection();
            // PreparedStatement st = con.prepareStatement("INSERT INTO usuario (nome, profissao, idade) VALUES (?, ?, ?);");
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

            Session session = sessionFactory.openSession();

            Transaction transaction = session.beginTransaction();

            session.persist(userData);

            transaction.commit();
            session.close();

            // st.setString(1, userData.getNome());
            // st.setString(2, userData.getProfissao());
            // st.setInt(3, userData.getIdade());

            // st.execute();
            // st.close();

            // con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Listar todos os usuário no PostgreSQL.
    public List<Usuario> listAllUser() {
        List<Usuario> users = null;

        Session session = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try {
            // Connection con = getConnection();
            session = sessionFactory.openSession();
            // PreparedStatement st = con.prepareStatement("SELECT * FROM usuario"); // Talvez um ; pode resolver
            // ResultSet rs = st.executeQuery();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Usuario> criteriaQuery = builder.createQuery(Usuario.class);

            criteriaQuery.from(Usuario.class);

            users = session.createQuery(criteriaQuery).getResultList();



//            while (rs.next()) {
//                Integer id = rs.getInt(1);
//                String nome = rs.getString(2);
//                String profissao = rs.getString(3);
//                Integer idade = rs.getInt(4);
//
//                users.add(new Usuario(id, nome, profissao, idade));
//            }
//            con.close();
            session.close();
            return users;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public void deleteUser(Integer id) {
        Session session = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            Usuario usuario = session.get(Usuario.class, id);
            session.remove(usuario);

            transaction.commit();
            session.close();


//            Connection con = getConnection();
//            PreparedStatement st = con.prepareStatement("DELETE FROM usuario WHERE id = ?");
//            st.setInt(1, id);
//            st.executeUpdate();
//            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void selectUser(Usuario userData) {
        Session session = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            // Connection con = getConnection();
//            PreparedStatement pst = con.prepareStatement("SELECT * FROM usuario WHERE id = ?");
//            pst.setInt(1, userData.getId());
//            ResultSet rs = pst.executeQuery();

            Usuario usuario = session.find(Usuario.class, userData.getId());
            userData.setId(usuario.getId());
            userData.setNome(usuario.getNome());
            userData.setProfissao(usuario.getProfissao());
            userData.setIdade(usuario.getIdade());
            transaction.commit();
            session.close();

//
//            while (rs.next()) {
//                userData.setId(rs.getInt(1));
//                userData.setNome(rs.getString(2));
//                userData.setProfissao(rs.getString(3));
//                userData.setIdade(rs.getInt(4));
//            }
//            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateUser(Usuario userData) {
        Session session = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            Usuario usuario = session.find(Usuario.class, userData.getId());
            usuario.setId(userData.getId());
            usuario.setNome(userData.getNome());
            usuario.setProfissao(userData.getProfissao());
            usuario.setIdade(userData.getIdade());

            session.merge(userData);
            transaction.commit();
            session.close();



//            Connection con = getConnection();
//            PreparedStatement pst = con.prepareStatement("UPDATE usuario SET nome = ?, profissao = ?, idade = ? WHERE id = ?;");
//            pst.setString(1, userData.getNome());
//            pst.setString(2, userData.getProfissao());
//            pst.setInt(3, userData.getIdade());
//            pst.setInt(4, userData.getId());
//            pst.executeUpdate();
//
//            pst.close();
//            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
