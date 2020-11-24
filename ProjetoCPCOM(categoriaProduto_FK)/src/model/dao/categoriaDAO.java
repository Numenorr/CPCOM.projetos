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

/**
 *
 * @author filip
 */
public class categoriaDAO {
    
    
    
    public boolean create(Categoria categoria){
        java.sql.Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        String sql = "INSERT INTO categoria (descricao) VALUES (?)";
        try{
            stmt = con.prepareStatement(sql);
            stmt.setString(1, categoria.getDescricao());
            stmt.executeUpdate();
            return true;
        }catch(SQLException ex){
            System.out.println("Erro: " + ex);
            return false;
        }         
    }
    
    public ArrayList<Categoria> read(){
        java.sql.Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Categoria> listaCategoria = new ArrayList<>();
        
        String sql = "SELECT * FROM categoria";
        
        try{
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Categoria cat = new Categoria();
                cat.setId(rs.getInt("id"));
                cat.setDescricao(rs.getString("descricao"));
                listaCategoria.add(cat);
            }
        }catch(SQLException ex){
            System.out.println("Erro: "+ ex);
        }
        return listaCategoria;
    }
    
    public boolean update(Categoria categoria){
        java.sql.Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        String sql = "UPDATE categoria SET descricao = ? WHERE id = ?";
        try{
            stmt = con.prepareStatement(sql);
            stmt.setString(1, categoria.getDescricao());
            stmt.setInt(2, categoria.getId());
            stmt.executeQuery();
            return true;
            
        }catch (SQLException ex){
            System.out.println("Erro: " + ex);
            return false;
        }
    }
    
    public boolean delete(Categoria categoria){
        java.sql.Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        String sql = "DELETE FROM categoria WHERE id = ?";
        try{
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, categoria.getId());
            stmt.executeUpdate();
            return true;
            
        }catch(SQLException ex){
            System.out.println("Erro: " + ex);
            return false;
        }
    }
    
    public ArrayList<Categoria> getListaCategorias_porDescricao (String descricao){
        java.sql.Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Categoria> listaCategorias = new ArrayList<>();
        try{
            stmt = con.prepareStatement("SELECT * FROM categoria WHERE descricao"
                                        + "LIKE ? ORDER by id");
            stmt.setString(1, "%" + descricao + "%");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Categoria cat = new Categoria();
                cat.setId(rs.getInt("id"));
                cat.setDescricao(rs.getString("descricao"));
                
                listaCategorias.add(cat);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao ler categorias","Erro",
                                          JOptionPane.ERROR_MESSAGE);
        }
        
        return listaCategorias;
    }
    
}
