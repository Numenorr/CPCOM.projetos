/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.Cliente;

public class ClienteDAO {
    
    public void create(Cliente cliente){//CREATE
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
         
            stmt = con.prepareStatement( "INSERT INTO cliente (nome,email,telefone) VALUES (?,?,?)" );
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getTelefone());
            
            //Setando o autoCommit pra falso, pois por padrao ja vem como true
            con.setAutoCommit(false);
            
            stmt.executeUpdate();
            con.commit();//Executa as alteracoes no BD
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar" + ex);
            
            try{
                //Em caso de erro, ele desfaz as operacoes realizadas
                con.rollback();
            }catch (SQLException ex1){
                System.out.println("Erro ao salvar!");
            }
        } finally{
            }
                try{
                    con.setAutoCommit(true);
                }catch(SQLException ex){
                    //o .getLogger e o SEVERE marcam erro, não sei o motivo :(
                    //Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    
    public ArrayList<Cliente> read(){//READ
        
       Connection con = ConnectionFactory.getConnection();
       PreparedStatement stmt = null;
       ResultSet rs = null;
        
       ArrayList<Cliente> listaClientes = new ArrayList<>();
       try {
           
           stmt = con.prepareStatement("SELECT * FROM cliente ORDER BY idcliente");
           rs = stmt.executeQuery();
           
           while (rs.next()) {
               
               Cliente cliente = new Cliente();
               cliente.setIdcliente(rs.getInt("idcliente"));
               cliente.setNome(rs.getString("nome"));
               cliente.setEmail(rs.getString("email"));
               cliente.setTelefone(rs.getString("telefone"));
               
               listaClientes.add(cliente);
               
           }
     
       }catch (SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao ler dados" + ex);
                }
     
      return listaClientes;
    }
    
    public void update(Cliente cliente){//UPDATE
        
       Connection con = ConnectionFactory.getConnection();
       PreparedStatement stmt = null;
        
        try {
           
          stmt = con.prepareStatement("UPDATE cliente set nome = ?, email = ?, telefone = ? "
                                        + "WHERE idcliente = ?");  
          
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getTelefone());
            stmt.setInt(4, cliente.getIdcliente());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            
        }catch (SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao atualizar dados" + ex);
                }
    }
    
    public void delete(Cliente cliente) {//DELETE
        
       Connection con = ConnectionFactory.getConnection();
       PreparedStatement stmt = null;
        
        try {
            
            stmt = con.prepareStatement("DELETE FROM cliente WHERE idcliente = ?");
            stmt.setInt(0, cliente.getIdcliente());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        
        }catch (SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao excluir dados" + ex);
                } 
    }
    
}
