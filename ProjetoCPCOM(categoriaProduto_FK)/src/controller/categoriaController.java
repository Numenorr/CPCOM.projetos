/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.bean.Categoria;
import model.dao.categoriaDAO;

/**
 *
 * @author filip
 */
public class categoriaController {
    
    public boolean create(String descricao){
        Categoria categoria = new Categoria();
        categoria.setDescricao(descricao);
        
        categoriaDAO catDAO = new categoriaDAO();
        return catDAO.create(categoria);
    }
    
    public boolean update(int id, String descricao){
        Categoria categoria = new Categoria();
        categoria.setId(id);
        categoria.setDescricao(descricao);
        
        categoriaDAO catDAO = new categoriaDAO();
        return catDAO.update(categoria);
    }
    
    public ArrayList<Categoria> read(){
        categoriaDAO catDAO = new categoriaDAO();
        return catDAO.read();
    }
    
    public boolean delete(int id){
        Categoria categoria = new Categoria();
        categoria.setId(id);
        //produtoDAO prodDAO = new produtoDAO();
        
        categoriaDAO catDAO = new categoriaDAO();
        return catDAO.delete(categoria);
    }
    
    public ArrayList<Categoria> getListCategorias_porDescricao(String descricao){
        categoriaDAO catDAO = new categoriaDAO();
        return catDAO.getListaCategorias_porDescricao(descricao);
    }
    
}
