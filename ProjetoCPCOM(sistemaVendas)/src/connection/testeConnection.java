/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;



/**
 *
 * @author filip
 */
public class testeConnection {
    
    public static void main (String args[]){
        var con = ConnectionFactory.getConnection();
        
        if(con != null){
            System.out.println("beleuza");
            System.out.println(con);
        }
    }
    
}
