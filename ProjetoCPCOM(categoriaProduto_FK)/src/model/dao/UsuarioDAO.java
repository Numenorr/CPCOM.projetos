/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.bean.Usuario;
import com.sun.jdi.connect.spi.Connection;
import connection.ConnectionFactory;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;



public class UsuarioDAO {
    
    //Create
    public void create(Usuario usuario){
       java.sql.Connection con = ConnectionFactory.getConnection();
       PreparedStatement stmt = null; 
       
       try{
           //Criptografia
           MessageDigest md = MessageDigest.getInstance("SHA-256");
           byte messageDigest[] = md.digest(usuario.getSenha().getBytes("UTF-8"));
           
           StringBuilder sb = new StringBuilder();
            for(byte b : messageDigest){
                sb.append(String.format("%02X", 0xFF & b));
            }
            String senhaHex = sb.toString();
           
           //insercao dos dados na tabela
           stmt = con.prepareStatement("INSERT INTO usuario (usuario, senha)"
                                        + "VALUES (?, ?)");
           stmt.setString(1, usuario.getUsuario());
           stmt.setString(2, senhaHex);
           
           con.setAutoCommit(false);
           
           stmt.executeUpdate();
           con.commit();
           
           JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!");
           
       }catch(SQLException ex){//execao SQL
           System.out.println("Erro user: " + ex);
       }
       catch(NoSuchAlgorithmException ex){//execao Cripto
           System.out.println("Erro: "+ ex);
       }
       catch(UnsupportedEncodingException ex){//execao enconding
           System.out.println("Erro: "+ ex);
       }
        
    }
    
    
    //verificacao dos dados para realizar o login
    public boolean verificaLogin(Usuario usu){
       java.sql.Connection con = ConnectionFactory.getConnection();
       PreparedStatement stmt = null; 
       ResultSet rs = null;
       boolean check = false;
       
       try{
           //Criptografia
           MessageDigest md = MessageDigest.getInstance("SHA-256");
           byte messageDigest[] = md.digest(usu.getSenha().getBytes("UTF-8"));
           
           StringBuilder sb = new StringBuilder();
            for(byte b : messageDigest){
                sb.append(String.format("%02X", 0xFF & b));
            }
            String senhaHex = sb.toString();
           
           //comparacao dos dados com a tabela
           stmt = con.prepareStatement("SELECT * FROM usuario WHERE usuario = ?"
                                        + "AND senha = ?");
           stmt.setString(1, usu.getUsuario());
           stmt.setString(2, senhaHex);
           rs = stmt.executeQuery();
           
           if(rs.next()){
               check = true;
           }
           
       }catch(SQLException ex){//execao SQL
           System.out.println("Erro user: " + ex);
       }
       catch(NoSuchAlgorithmException ex){//execao Cripto
           System.out.println("Erro: "+ ex);
       }
       catch(UnsupportedEncodingException ex){//execao enconding
           System.out.println("Erro: "+ ex);
       }
      
      // caso true, os dados batem com um usuario existente na tabela
      //caso false, bem... é falso que os dados batem :D
      return check; 
    }
}
