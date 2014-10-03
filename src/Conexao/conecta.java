/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 *
 * @author GUSTAVO
 */
public class conecta {
    
 public static Connection getConexao() throws Exception{
     try{
         Class.forName("com.mysql.jdbc.Driver");
         System.out.println("conectei");
         return (DriverManager.getConnection("jdbc:mysql://localhost/sigaf", "root", "123456"));
         
     }catch(ClassNotFoundException e){
         throw new SQLException(e.getMessage());
         
     }
}
}

