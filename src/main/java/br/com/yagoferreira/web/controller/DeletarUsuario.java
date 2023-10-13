package br.com.yagoferreira.web.controller;

import br.com.yagoferreira.web.model.ConnectionPostgres;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/delete")
public class DeletarUsuario extends HttpServlet {
    ConnectionPostgres con = new ConnectionPostgres();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        System.out.println(req.getParameter("id"));
        con.deleteUser(id);
        resp.sendRedirect("listar");
    }
}
