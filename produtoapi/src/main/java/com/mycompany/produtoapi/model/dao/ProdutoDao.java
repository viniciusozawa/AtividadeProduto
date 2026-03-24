/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.produtoapi.model.dao;
import com.mycompany.produtoapi.model.entity.Produto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author yuji
 */
public class ProdutoDao extends GenericoDAO<Produto>{
    public void salvar(Produto objProduto){
        String sql = "INSERT INTO PRODUTO(descricao, precoVenda, precoCompra, quantidadeEstoque) VALUES(?,?,?,?)";
        save(sql,objProduto.getDescricao(), objProduto.getPrecoVenda(), objProduto.getPrecoCompra(), objProduto.getQuantidadeEstoque());
    }
    
    public void alterar(Produto objProduto){
        String sql = "UPDATE PRODUTO SET descricao = ?, precoVenda = ?, precoCompra = ?, quantidadeEstoque = ?   WHERE CODIGO=?";
        
        save(sql, objProduto.getDescricao(), objProduto.getPrecoVenda(), objProduto.getPrecoCompra(), objProduto.getQuantidadeEstoque(), objProduto.getCodigo());
        
    }
    public void excluir(Produto objProduto){
        String sql = "DELETE FROM produto WHERE CODIGO=?";
        save(sql, objProduto.getCodigo());
        
    }
    
    private static class ProdutoRowMapper implements RowMapper<Produto>{

        @Override
        public Produto mapRow(ResultSet rs) throws SQLException {
           Produto objProduto = new Produto();
           objProduto.setCodigo(rs.getInt("codigo"));
           objProduto.setDescricao(rs.getString("descricao"));
           objProduto.setPrecoVenda(rs.getDouble("precoVenda"));
           objProduto.setPrecoCompra(rs.getDouble("precoCompra"));
           objProduto.setQuantidadeEstoque(rs.getInt("quantidadeEstoque"));
           
           System.out.println("Mapeando o objeto cidade"+objProduto.toString());
           return objProduto;
        }
        
    }
    
    public List<Produto> buscarTodasCidade(){
        String sql = "SELECT * FROM PRODUTO";
        return buscarTodos(sql, new ProdutoRowMapper());
    }
    
    public Produto buscarCidadePorId(int id){
        String sql = "SELECT * FROM PRODUTO WHERE CODIGO=? ";
        return buscarPorId(sql, new ProdutoRowMapper(), id);
    }
}
