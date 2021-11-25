<%@ page import="java.util.ArrayList, com.bruna.atp53.models.Categoria" %>

<%
    Categoria model = (Categoria)request.getAttribute("model");
%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Categoria - Alterando</title>
    <link rel="stylesheet" href="../css/styles.css">
    <link rel="stylesheet" href="../css/styles.css">
</head>
<body>
    <h1>Categoria - Alterando</h1>
    <form action="/atp53-1/categoria/alterar" method="post">
        Id: <input type="text" name="id" id="id" value="<%=model.getId() %>"><br />
        Nome: <input type="text" name="nome" id="nome" value="<%=model.getNome() %>"> <br />
        <input type="submit" value="Alterar">
    </form>
</body>
</html>