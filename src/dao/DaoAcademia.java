/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import Conexao.Conexao;
import Interface.IDao;
import Logico.Academia;
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
 * @author Glaucia
 */
public class DaoAcademia implements IDao<Academia> {
   
    public class DaoAcademia implements IDao<Academia> {

    private Connection conexao;

    public DaoAcademia() {
        try {
            this.conexao = Conexao.getConexao();
        } catch (Exception ex) {
            Logger.getLogger(DaoAcademia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void incluir(Academia objeto) throws SQLException {
        String sql = "INSERT INTO academia (nome,endereco,bairro,cidade,cep,estado,telefone,email,site,contato) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?)";

        try {
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setString(1, objeto.getnome());                
                stmt.setString(2, objeto.getendereco());
                stmt.setString(3, objeto.getbairro());
                stmt.setString(4, objeto.getcidade());
                stmt.setString(5, objeto.getcep());
                stmt.setBoolean(6, objeto.isEstado());
                stmt.setString(7, objeto.gettelefone());
                stmt.setString(8, objeto.getemail());
                stmt.setString(9, objeto.getsite());
                stmt.setString(10 objeto.getcontato());

                stmt.execute();
            } 
        } catch (SQLException e) {
            System.out.println("Erro " + e);
        }

    }

    @Override
    public void editar(Academia objeto) throws SQLException {
       String sql = "UPDATE usuario SET nome =?, endereco = ?, bairro =?, cidade =?, cep =?"
               + ",estado = ?,telefone = ?, email = ?, site =?, contato =? WHERE id_academia = ? ";
       try{
           try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
               stmt.setString(1, objeto.getnome());                
               stmt.setString(2, objeto.getendereco());
               stmt.setString(3, objeto.getbairro());
               stmt.setString(4, objeto.getcidade());
               stmt.setString(5, objeto.getcep());
               stmt.setBoolean(6, objeto.isEstado());
               stmt.setString(7, objeto.gettelefone());
               stmt.setString(8, objeto.getemail());
               stmt.setString(9, objeto.getsite());
               stmt.setString(10 objeto.getcontato());
               stmt.setInt(11, objeto.getid_academia());
               
               stmt.execute();
           }
       }catch(SQLException e){
           System.out.println("Erro ao gravar "+e);
           
       }
       
    }

    @Override
    public List<Academia> pesquisar(Academia objeto) throws SQLException {
        List<Academia> l = new ArrayList<Academia>();
        try {
            String sql = "SELECT * FROM academia WHERE nome LIKE ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setString(1, objeto.getnome());
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        Academia academia = new Academia();
                        academia.setid_academia(rs.getInt("id_academia"));
                        academia.setnome(rs.getString("nome"));
                        academia.setendereco(rs.getString("endereco"));
                        academia.setbairro(rs.getString("bairro"));
                        academia.setcidade(rs.getString("cidade"));
                        academia.setcep(rs.getString("cep"));
                        academia.setEstado(rs.getBoolean("estado"));
                        academia.settelefone(rs.getString("telefone"));                        
                        academia.setEmail(rs.getString("email"));
                        academia.setsite(rs.getString("site"));
                        academia.setcontato(rs.getString("contato"));

                        l.add(academia);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro na pesquisa " + e);

        }
        return l;
    }
    
    public List<Academia> pesquisarAcademia(Academia objeto) throws SQLException{
        List<Academia> l = new ArrayList<Academia>();
        try{
            String sql = "SELECT id_academia, Nome FROM academia WHERE id_academia = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, objeto.getid_academia());
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Academia academia = new Academia();
                academia.setid_academia(rs.getInt("id_academia"));
                academia.setNome(rs.getString("nome"));
                l.add(academia);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        
        return l;
    }

}
