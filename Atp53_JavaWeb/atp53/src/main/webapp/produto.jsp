<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Produto - Cadastro</title>
</head>
<body>
    <h1>Cadastro de Produto</h1>
    <form action="/atp53-1/produto">
        Nome: <input type="text" name="nome" id="nome">
        Valor: <input type="number" name="valor" id="valor" min="0.00" step="0.01">
        Id descricao: <input type="number" name="id_categoria" id="id_categoria">
        <input type="submit" value="Salvar">
    </form>
</body>
</html>