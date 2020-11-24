/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import com.sun.jdi.connect.spi.Connection;
import connection.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.Categoria;
import model.bean.Produto;

/**
 *
 * @author filip
 */
public class ProdutoDAO{
        
    public boolean create(Produto produto){
        java.sql.Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        String sql = "INSERT INTO produtos (descricao, qtd, valor, idcategoria) "
                    + "VALUES (?,?,?,?)";
        try{
           stmt = con.prepareStatement(sql);
           stmt.setString(1, produto.getDescricao());
           stmt.setInt(2, produto.getQtd());
           stmt.setDouble(3, produto.getValor());
           stmt.setInt(4, produto.getCategoria().getId());
           
           stmt.executeQuery();
           
           return true;
           
        }catch(SQLException ex){
            System.out.println("Erro: " + ex);
            return false;
        }
    }
    
    public ArrayList<Produto> read(){
       java.sql.Connection con = ConnectionFactory.getConnection();
       PreparedStatement stmt = null;
       ResultSet rs = null;
       
       ArrayList<Produto> listaProdutos = new ArrayList<>();
       
       //Acabei fazendo formato do view aqui pois 
       //no pgAdmin dava erro (foto junto aos arquivos)
       String sql = "SELECT p.idproduto, p.descricao as pdesc, qtd, valor, p.idcategoria as pidcat,\n" +
                    "c.id as cidcat, c.descricao as cdesc\n" +
                    "FROM produtos p INNER JOIN categoria c ON c.id = p.idcategoria";
       
       try{
           stmt = con.prepareStatement(sql);
           rs = stmt.executeQuery();
           
           while(rs.next()){
               Produto prod = new Produto();
               prod.setId(rs.getInt("idproduto"));
               prod.setDescricao(rs.getString("pdesc"));
               prod.setQtd(rs.getInt("qtd"));
               prod.setValor(rs.getDouble("valor"));
               
               Categoria cat = new Categoria();
               cat.setId(rs.getInt("cidcat"));
               cat.setDescricao(rs.getString("cdesc"));
               prod.setCategoria(cat);
               
               listaProdutos.add(prod);
           }
           
       }catch(SQLException ex){
           System.out.println("Erro: " + ex);
       }
       return listaProdutos;
    }
    
    public boolean update(Produto produto){
       java.sql.Connection con = ConnectionFactory.getConnection();
       PreparedStatement stmt = null;
       
       String sql = "UPDATE produtos SET descricao = ?, qtd = ?, valor = ?, "
                   + "idcategoria = ? WHERE idproduto = ?";
       
       try{
           stmt = con.prepareStatement(sql);
           stmt.setString(1, produto.getDescricao());
           stmt.setInt(2, produto.getQtd());
           stmt.setDouble(3, produto.getValor());
           stmt.setInt(4, produto.getCategoria().getId());
           stmt.setInt(5, produto.getId());
           
           stmt.executeUpdate();
           return true;
       
       }catch(SQLException ex){
           System.out.println("Erro: "+ ex);
           return false;
       }
    }
    
    public boolean delete(Produto produto){
        java.sql.Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        String sql = "DELETE FROM produtos WHERE idproduto = ?";
        try{
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, produto.getId());
            stmt.executeUpdate();
            return true;
            
        }catch(SQLException ex){
            System.out.println("Erro: "+ ex);
            return false;
        }
    }
    
}
