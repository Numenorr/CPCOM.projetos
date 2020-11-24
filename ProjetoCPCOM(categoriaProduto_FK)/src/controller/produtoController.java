/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.bean.Categoria;
import model.bean.Produto;
import model.dao.ProdutoDAO;

/**
 *
 * @author filip
 */
public class produtoController {
    
    public boolean create(String descricao, int qtd, double valor, Categoria categoria){
        Produto produto = new Produto();
        produto.setDescricao(descricao);
        produto.setQtd(qtd);
        produto.setValor(valor);
        produto.setCategoria(categoria);
        
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.create(produto);
    }
    
    public ArrayList<Produto> read(){
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.read();
    }
    
    public boolean update(int id, String descricao, int qtd, double valor, Categoria categoria){
        Produto produto = new Produto();
        produto.setId(id);
        produto.setDescricao(descricao);
        produto.setQtd(qtd);
        produto.setValor(valor);
        produto.setCategoria(categoria);
        
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.update(produto);
    }
    
    public boolean delete(int id){
        Produto produto = new Produto();
        produto.setId(id);
        
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.delete(produto);
    }
    
}
