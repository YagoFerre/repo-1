<%--
  Created by IntelliJ IDEA.
  User: yago.ferreira
  Date: 10/10/2023
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="br.com.yagoferreira.web.model.Usuario" %>
<%@ page import="java.util.List" %>
<% List<Usuario> users = (List<Usuario>) request.getAttribute("usuario"); %>
<html>
<head>
    <title>Lista de Usuários</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="style.css">
</head>
<body>
<main id="main-wrapper">
<div class="container">

    <% for (int i = 0; i < users.size(); i++) {
    %>
    <div class="box">
        <div class="infoBox">
            <strong class="label">Nome</strong>
            <p class="user-info"><%=users.get(i).getNome()%>
            </p>
        </div>

        <div class="infoBox">
            <strong class="label">Profissao</strong>
            <p class="user-info"><%=users.get(i).getProfissao()%>
            </p>
        </div>

        <div class="infoBox">
            <strong class="label">Idade</strong>
            <p class="user-info"><%=users.get(i).getIdade()%>
            </p>
        </div>

        <a href="delete?id=<%=users.get(i).getId()%>" class="buttonSend">Excluir</a>
        <a href="selecionar?id=<%=users.get(i).getId()%>" class="buttonList">Editar</a>
    </div>
    <%
        }
    %>

    <a href="index.jsp" class="buttonSend">Cadastrar</a>
</div>
</main>

<script src="scripts/confirm.js"></script>
</body>
</html>
