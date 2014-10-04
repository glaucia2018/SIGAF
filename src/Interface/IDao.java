/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author GUSTAVO
 */
public interface IDao <O> {
    public void incluir(O objeto) throws SQLException ;
    public void editar(O objeto) throws SQLException ;
    public List<O> pesquisar(O objeto) throws SQLException ;
      
    
}
