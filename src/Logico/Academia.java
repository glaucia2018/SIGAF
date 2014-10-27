/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logico;

/**
 *
 * @author Glaucia
 */
public class Academia {
    
    
   private int id_academia;
   
   private String nome,endereco,bairro,cidade,cep,estado,telefone,email,site,contato;

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getid_academia() {
        return id_academia;
    }

    public void setid_academia(int id_academia) {
        this.id_academia = id_academia;
    }

    public String getnome() {
        return nome;
    }

    public void setnome(String nome) {
        this.nome = nome;
    }
    
    public String getEndereco() {
        return endereco;
    }

    public void setendereco(String endereco) {
        this.endereco = endereco;
    }
    
    public String getbairro() {
        return bairro;
    }

    public void setbairro(String bairro) {
        this.bairro = bairro;
    }
    
    public String getcidade() {
        return cidade;
    }

    public void setcidade(String cidade) {
        this.cidade = cidade;
    }    
       
    public String getcep() {
        return cep;
    }

    public void setcep(String cep) {
        this.cep = cep;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String gettelefone() {
        return telefone;
    }

    public void settelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String getcontato() {
        return contato;
    }

    public void setcontato(String contato) {
        this.contato = contato;
    }
    
}
