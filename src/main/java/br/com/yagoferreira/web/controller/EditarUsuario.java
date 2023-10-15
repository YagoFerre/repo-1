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

@WebServlet("/editar")
public class EditarUsuario extends HttpServlet {
    ConnectionPostgres con = new ConnectionPostgres();
    Usuario usuario = new Usuario();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        usuario.setId(Integer.parseInt(req.getParameter("id")));
        usuario.setNome(req.getParameter("nome"));
        usuario.setProfissao(req.getParameter("profissao"));
        usuario.setIdade(Integer.parseInt(req.getParameter("idade")));

        con.updateUser(usuario);
        resp.sendRedirect("listar");
    }
}
