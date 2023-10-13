<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro de usuário</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="style.css">
</head>
<body>
<form action="cadastro" method="post" class="form">

    <div class="inputBox">
        <label for="nome" class="label">Nome</label>
        <input id="nome" name="nome" type="text" placeholder="Digite seu nome" class="input"/>
    </div>

    <%--    <br/>--%>

    <div class="inputBox">
        <label for="profissao">Profissao</label>
        <input id="profissao" name="profissao" type="text" placeholder="Ex: Medico" class="input"/>
    </div>
    <%--    <br/>--%>

    <div class="inputBox">
        <label for="idade">Idade</label>
        <input id="idade" name="idade" type="number" placeholder="Ex: 20" class="input"/>
    </div>

    <%--    <br/>--%>

    <div class="buttonBox">
        <input type="submit" value="Enviar" class="buttonSend"/>
        <a href="listar" class="buttonList">Listar</a>
    </div>
</form>
</body>
</html>
