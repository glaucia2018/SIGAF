/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logico;

/**
 *
 * @author GUSTAVO
 */
import java.security.MessageDigest;      
import java.security.NoSuchAlgorithmException;      
  
import sun.misc.BASE64Encoder;            
  
/**     
 * @author jarbas     
 */      
public class EncriptaSenha {     
  
     public static String encripta (String senha) {     
          try {     
               MessageDigest digest = MessageDigest.getInstance("MD5");      
               digest.update(senha.getBytes());      
               BASE64Encoder encoder = new BASE64Encoder ();      
               return encoder.encode (digest.digest ());      
          } catch (NoSuchAlgorithmException ns) {     
               return senha;      
          }      
     }      
}