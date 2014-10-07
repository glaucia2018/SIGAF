/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Conexao.Conexao;
import Interface.IDao;
import Logico.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GUSTAVO
 */
public class DaoUsuario implements IDao<Usuario> {
    private Connection conexao;

    
    
    public DaoUsuario(){
        try {
            this.conexao = Conexao.getConexao();
        } catch (Exception ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public void incluir(Usuario objeto) throws SQLException {
        String sql = "INSERT INTO usuario (nome, dtcadastro, dtnascimento, senha,email,"
                + "sexo, observacao, estado) VALUES (?,?,?,?,?,?,?,?)";
        
        try{
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setString(1, objeto.getNome());
                stmt.setDate(2, Anulavel.getData(objeto.getDtcadastro()));
                stmt.setDate(3, Anulavel.getData(objeto.getDtnascimento()));
                stmt.setString(4, objeto.getSenha());
                stmt.setString(5,objeto.getEmail());
                stmt.setString(6,objeto.getSexo());
                stmt.setString(7, objeto.getObservacao());
                stmt.setBoolean(8, objeto.isEstado());
                
                stmt.execute();
            }
        }catch(SQLException e){
            System.out.println("Erro "+e);
        }
        
        
    }

    @Override
    public void editar(Usuario objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> pesquisar(Usuario objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
