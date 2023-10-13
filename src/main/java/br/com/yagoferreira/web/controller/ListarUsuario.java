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
import java.util.ArrayList;

@WebServlet("/listar")
public class ListarUsuario extends HttpServlet {
    ConnectionPostgres con = new ConnectionPostgres();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Usuario> usuario = con.listAllUser();
        req.setAttribute("usuario", usuario);
        RequestDispatcher rd = req.getRequestDispatcher("listagem.jsp");

        rd.forward(req, resp);
    }
}
