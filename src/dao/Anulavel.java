/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

/**
 *
 * @author GUSTAVO
 */
public class Anulavel {
    /**
     * O método pega uma data java.util.Date e transforma ela em java.sql.Date
     * para poder inserir no banco se for preenchido, senao ele retorna null
     * @param data java.util.Date
     * @return java.sql.Date
     */
    
    public static java.sql.Date getData(java.util.Date data){
        try{
            return new java.sql.Date(data.getTime());
        }catch(NullPointerException e){
            return null;
            
        }
    }
    
}
