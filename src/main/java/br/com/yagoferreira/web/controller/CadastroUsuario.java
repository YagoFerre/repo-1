package br.com.yagoferreira.web.controller;

import br.com.yagoferreira.web.model.ConnectionPostgres;
import br.com.yagoferreira.web.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cadastro")
public class CadastroUsuario extends HttpServlet {
    ConnectionPostgres con = new ConnectionPostgres();
    Usuario usuario = new Usuario();

    // Criar novo usuário.
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var nome = request.getParameter("nome");
        var profissao = request.getParameter("profissao");
        var idade = request.getParameter("idade");

        // Setar as variáveis no Usuario.
        usuario.setNome(nome);
        usuario.setProfissao(profissao);
        usuario.setIdade(Integer.valueOf(idade));

        // Adicionar ao banco de dados.
        con.createUser(usuario);
        response.sendRedirect("editar.jsp");
    }
}
