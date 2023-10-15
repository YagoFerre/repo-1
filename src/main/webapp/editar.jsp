<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edicao de usuário</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="style.css">
</head>
<body>
<main id="main-container">
<form action="editar" method="post" class="form">


    <input id="id" name="id" type="number" placeholder="Digite seu nome" readonly value="<%out.print(request.getAttribute("id"));%>" />


    <div class="inputBox">
        <label for="nome" class="label">Nome</label>
        <input id="nome" name="nome" type="text" placeholder="Digite seu nome" class="input" value="<%out.print(request.getAttribute("nome"));%>" />
    </div>

    <%--    <br/>--%>

    <div class="inputBox">
        <label for="profissao" class="label">Profissao</label>
        <input id="profissao" name="profissao" type="text" placeholder="Ex: Medico" class="input" value="<%out.print(request.getAttribute("profissao"));%>"/>
    </div>
    <%--    <br/>--%>

    <div class="inputBox">
        <label for="idade" class="label">Idade</label>
        <input id="idade" name="idade" type="number" placeholder="Ex: 20" class="input" value="<%out.print(request.getAttribute("idade"));%>"/>
    </div>

    <%--    <br/>--%>

    <div class="buttonBox">
        <input type="submit" value="Editar" class="buttonSend"/>
        <a href="listar" class="buttonList">Listar</a>
    </div>
</form>
</main>
</body>
</html>
