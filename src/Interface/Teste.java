/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

import Conexao.conecta;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GUSTAVO
 */
public class Teste {
    
    public static void main(String args[]){
        try {
            conecta.getConexao();
        } catch (Exception ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
          
    
}
