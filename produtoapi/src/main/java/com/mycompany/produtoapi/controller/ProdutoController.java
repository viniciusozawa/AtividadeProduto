/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.produtoapi.controller;

import com.mycompany.produtoapi.model.dao.ProdutoDao;
import com.mycompany.produtoapi.model.entity.Produto;
import com.mycompany.produtoapi.service.WebConstante;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author yuji
 */
@WebServlet(WebConstante.BASE_PATH + "/ProdutoController")
public class ProdutoController extends HttpServlet{
    
    Produto objProduto = new Produto();
    ProdutoDao objProdutoDAO = new ProdutoDao();
    
    String opcao = "";
    String codigoIn = "";
    String descricaoIn = "";
    String precoVendaIn = "";
    String precoCompraIn = "";
    String quantEstoqueIn = "";
    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            opcao = request.getParameter("opcao");
            if (opcao == null || opcao.isEmpty()) {
                opcao = "cadastrar";
            }
            codigoIn = request.getParameter("codigo");
            descricaoIn = request.getParameter("descricao");
            precoVendaIn = request.getParameter("precoVenda");
            precoCompraIn = request.getParameter("precoCompra");
            quantEstoqueIn = request.getParameter("quantidadeEstoque");
            
            switch (opcao) {
                case "cadastrar":
                    cadastrar(request, response);

                    break;
                case "enviarAlterar":
                    enviarAlterar(request, response);
                    break;
                case "confirmarAlterar":
                    confirmarAlterar(request, response);
                    break;
                case "cancelar":
                    cancelar(request, response);
                    break;
                case "enviarExcluir":
                    enviarExcluir(request, response);
                    break;
                case "confirmarExcluir":
                    confirmarExcluir(request, response);
                    break;
                default:
                    throw new IllegalArgumentException("Opçãop invalida" + opcao);
            }

        } catch (NumberFormatException e) {
            response.getWriter().println("Erro: um ou mais parametros não são número válido" + e.getMessage());
        } catch (IllegalArgumentException ex) {
            response.getWriter().println("Erro: " + ex.getMessage());
        }
    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        objProduto.setDescricao(descricaoIn);
        objProduto.setPrecoCompra(Double.parseDouble(precoCompraIn));
        objProduto.setPrecoVenda(Double.parseDouble(precoVendaIn));
        objProduto.setQuantidadeEstoque(Integer.valueOf(quantEstoqueIn));
        
        System.out.println("chegou");
        objProdutoDAO.salvar(objProduto);
        request.setAttribute("mensagem", "Produto cadastrada com sucesso!");
        encaminharParaPagina(request, response);
    }

    private void enviarAlterar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("codigo", codigoIn);
        request.setAttribute("descricao", descricaoIn);
        request.setAttribute("precoVenda", precoVendaIn);
        request.setAttribute("precoCompra",precoCompraIn );
        request.setAttribute("quantidadeEstoque",quantEstoqueIn);
        request.setAttribute("opcao", "confirmarAlterar");
        request.setAttribute("mensagem", "edite");
        encaminharParaPagina(request, response);
    }

    private void confirmarAlterar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        objProduto.setCodigo(Integer.valueOf(codigoIn));
        objProduto.setDescricao(descricaoIn);
        objProduto.setPrecoVenda(Double.parseDouble(precoVendaIn));
        objProduto.setPrecoCompra(Double.parseDouble(precoCompraIn));
        objProduto.setQuantidadeEstoque(Integer.valueOf(quantEstoqueIn));
        objProdutoDAO.alterar(objProduto);
        
        encaminharParaPagina(request, response);

    }

    private void encaminharParaPagina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Produto> produtos = objProdutoDAO.buscarTodasCidade();
        request.setAttribute("produtos", produtos);
        RequestDispatcher dispather = request.getRequestDispatcher("/CadastroProduto.jsp");
        dispather.forward(request, response);
    }

    private void cancelar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("codigo", 0);
        request.setAttribute("descricao", "");
        request.setAttribute("precoVenda", 0);
        request.setAttribute("precoCompra",0 );
        request.setAttribute("quantidadeEstoque",0);
        request.setAttribute("opcao", "cadastrar");
        encaminharParaPagina(request, response);
    }
    
    private void enviarExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("codigo", codigoIn);
        request.setAttribute("descricao", descricaoIn);
        request.setAttribute("precoVenda", precoVendaIn);
        request.setAttribute("precoCompra",precoCompraIn );
        request.setAttribute("quantidadeEstoque",quantEstoqueIn);
        request.setAttribute("opcao", "confirmarExcluir");
        request.setAttribute("mensagem", "Confirmar os dados e clique em salvar");
        encaminharParaPagina(request, response);
    }
    
    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        objProduto.setCodigo(Integer.valueOf(codigoIn));
        
        objProdutoDAO.excluir(objProduto);
        encaminharParaPagina(request, response);

    }
}
