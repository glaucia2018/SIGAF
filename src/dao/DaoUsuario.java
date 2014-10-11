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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GUSTAVO
 */
public class DaoUsuario implements IDao<Usuario> {

    private Connection conexao;

    public DaoUsuario() {
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

        try {
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setString(1, objeto.getNome());
                stmt.setDate(2, Anulavel.getData(objeto.getDtcadastro()));
                stmt.setDate(3, Anulavel.getData(objeto.getDtnascimento()));
                stmt.setString(4, objeto.getSenha());
                stmt.setString(5, objeto.getEmail());
                stmt.setString(6, objeto.getSexo());
                stmt.setString(7, objeto.getObservacao());
                stmt.setBoolean(8, objeto.isEstado());

                stmt.execute();
            }
        } catch (SQLException e) {
            System.out.println("Erro " + e);
        }

    }

    @Override
    public void editar(Usuario objeto) throws SQLException {
       String sql = "UPDATE usuario SET nome =?, dtcadastro = ?, dtnascimento =?, senha =?"
               + ",email = ?,sexo = ?, observacao = ?, estado =? WHERE idusuario = ? ";
       try{
           try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
               stmt.setString(1, objeto.getNome());
               stmt.setDate(2, Anulavel.getData(objeto.getDtcadastro()));
               stmt.setDate(3, Anulavel.getData(objeto.getDtnascimento()));
               stmt.setString(4, objeto.getSenha());
               stmt.setString(5, objeto.getEmail());
               stmt.setString(6, objeto.getSexo());
               stmt.setString(7, objeto.getObservacao());
               stmt.setBoolean(8, objeto.isEstado());
               stmt.setInt(9, objeto.getIdusuario());
               
               stmt.execute();
           }
       }catch(SQLException e){
           System.out.println("Erro ao gravar "+e);
           
       }
       
    }

    @Override
    public List<Usuario> pesquisar(Usuario objeto) throws SQLException {
        List<Usuario> l = new ArrayList<Usuario>();
        try {
            String sql = "SELECT * FROM usuario WHERE nome LIKE ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setString(1, objeto.getNome());
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        Usuario usuario = new Usuario();
                        usuario.setDtcadastro(rs.getDate("dtcadastro"));
                        usuario.setDtnascimento(rs.getDate("dtnascimento"));
                        usuario.setEmail(rs.getString("email"));
                        usuario.setEstado(rs.getBoolean("estado"));
                        usuario.setIdusuario(rs.getInt("idusuario"));
                        usuario.setNome(rs.getString("nome"));
                        usuario.setObservacao(rs.getString("observacao"));
                        usuario.setSenha(rs.getString("senha"));
                        usuario.setSexo(rs.getString("sexo"));

                        l.add(usuario);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro na pesquisa " + e);

        }
        return l;
    }

}
