/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.bean.Usuario;
import model.dao.UsuarioDAO;


public class usuarioController {
    
    public void create(String usuario, String senha){
        Usuario user = new Usuario();
        user.setUsuario(usuario);
        user.setSenha(senha);
        
        UsuarioDAO userDAO = new UsuarioDAO();
        userDAO.create(user);
    }
    
    public boolean verificaLogin(String usu, String senha){
        UsuarioDAO userDAO = new UsuarioDAO();
        
        Usuario user = new Usuario();
        user.setUsuario(usu);
        user.setSenha(senha);
        
        return userDAO.verificaLogin(user);
    }
    
}
