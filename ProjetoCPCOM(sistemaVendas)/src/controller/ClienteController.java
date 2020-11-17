/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.bean.Cliente;
import model.dao.ClienteDAO;


public class ClienteController {
    
    public void create(String nome, String email, String telefone) {
        
        Cliente cliente = new Cliente();
        ClienteDAO clienteDAO = new ClienteDAO();
        
        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setTelefone(telefone);
        
        clienteDAO.create(cliente);
        
    }
    
    public void update(int idcliente, String nome, String email, String telefone){
        
        Cliente cliente = new Cliente();
        ClienteDAO clienteDAO = new ClienteDAO();
        
        cliente.setIdcliente(idcliente);
        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setTelefone(telefone);
        
        clienteDAO.update(cliente);
    }
    
    public void delete (int idcliente){
        
        Cliente cliente = new Cliente();
        ClienteDAO clienteDAO = new ClienteDAO();
        
        cliente.setIdcliente(idcliente);
        
        clienteDAO.delete(cliente);
        
    }
    
    public ArrayList<Cliente> read(){
        
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.read();
       
    }
    
}
