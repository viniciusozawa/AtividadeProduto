<%-- 
    Document   : CadastroProduto
    Created on : 24 de mar. de 2026, 16:22:52
    Author     : yuji
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="Latin1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=Latin1">
        <title>Produtos API</title>
        <link rel="stylesheet" href="styles/cadastroproduto.css"/>
    </head>
    <body>

        <h1>Cadastro Produto</h1>
        <form type="hidden" name="cadastro" method="get" 
              action="${pageContext.request.contextPath}${URL_BASE}/ProdutoController">
            <input type="hidden" id="opcao" name="opcao" value="${opcao}">
            <p>${opcao}</p>
            <input type="hidden" name="codigo" value="${codigo}">
            <p><label>Nome:</label> <input type="text" name="descricao" required="" value="${descricao}" size="40"></p>
            <p><label>Preço de Venda:</label> <input type="number" name="precoVenda" required="" value="${precoVenda}" size="5"></p>
            <p><label>Preço de Compra:</label> <input type="number" name="precoCompra" required="" value="${precoCompra}" size="5"></p>
            <p><label>Quantidade Estoque:</label> <input type="number" name="quantidadeEstoque" required="" value="${quantidadeEstoque}" size="5"></p>

            <input type="submit" value="Salvar" name="Salvar" style="float:left; margin-right: 3px">
        </form>

        <form id="cadastroForm" name="cadastro" method="get" action="${pageContext.request.contextPath}${URL_BASE}/CidadeControlador">
            <input type="submit" value="Cancelar" name="btnCancelar">
            <input type="hidden" name="opcao" value="cancelar">

        </form>    

        <h3>${mensagem}</h3>
        <table border="1">
            <caption style="padding:10px; font-size:20px; font-weight:bold;">
                Produtos
            </caption>
            <c:if test="${not empty produtos}">
                <tr>
                    <th>CÓDIGO </th>
                    <th>NOME/DESCRIÇÃO</th>
                    <th>PREÇO VENDA</th>
                    <th>PREÇO COMPRA</th>
                    <th>QUANTIDADE ESTOQUE</th>
                    <th>ALTERAR</th>
                    <th>EXCLUIR</th>
                </tr>
            </c:if>

            <c:forEach var="produtos" items="${produtos}">
                <tr>
                    <td>${produtos.codigo}</td>
                    <td>${produtos.descricao}</td>
                    <td><span>R$</span>${produtos.precoVenda}</td>
                    <td>${produtos.precoCompra}</td>
                    <td>${produtos.quantidadeEstoque}</td>
                    <td>
                        <form type="hidden" name="cadastro" method="get" action="${pageContext.request.contextPath}${URL_BASE}/ProdutoController">
                            <input type="hidden" name="codigo" value="${produtos.codigo}">
                            <input type="hidden" name="descricao" value="${produtos.descricao}">
                            <input type="hidden" name="precoVenda" value="${produtos.precoVenda}">
                            <input type="hidden" name="precoCompra" value="${produtos.precoCompra}">
                            <input type="hidden" name="quantidadeEstoque" value="${produtos.quantidadeEstoque}">

                            <input type="hidden" name="opcao" value="enviarAlterar">
                            <button type="submit">Alterar</button>
                        </form>
                    </td>
                    <td>
                        <form type="hidden" name="cadastro" method="get" action="${pageContext.request.contextPath}${URL_BASE}/ProdutoController">
                            <input type="hidden" name="codigo" value="${produtos.codigo}">
                            <input type="hidden" name="descricao" value="${produtos.descricao}">
                            <input type="hidden" name="precoVenda" value="${produtos.precoVenda}">
                            <input type="hidden" name="precoCompra" value="${produtos.precoCompra}">
                            <input type="hidden" name="quantidadeEstoque" value="${produtos.quantidadeEstoque}">
                            <input type="hidden" name="opcao" value="enviarExcluir">
                            <button type="submit">Excluir</button>
                        </form>
                    </td>
                </tr>

            </c:forEach>
        </table>
    </body>
</html>
