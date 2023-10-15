package br.com.yagoferreira.web.controller;

import br.com.yagoferreira.web.model.ConnectionPostgres;
import br.com.yagoferreira.web.model.Usuario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/selecionar")
public class SelecionarUsuario extends HttpServlet {
    ConnectionPostgres con = new ConnectionPostgres();
    Usuario usuario = new Usuario();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        System.out.println(id);
        usuario.setId(id);

        con.selectUser(usuario);
        req.setAttribute("id", usuario.getId());
        req.setAttribute("nome", usuario.getNome());
        req.setAttribute("profissao", usuario.getProfissao());
        req.setAttribute("idade", usuario.getIdade());

        RequestDispatcher rd = req.getRequestDispatcher("editar.jsp");
        rd.forward(req, resp);
    }
}
