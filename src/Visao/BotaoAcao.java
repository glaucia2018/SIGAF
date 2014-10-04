/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Visao;


import Visao.TelaUsuario;
import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JViewport;

/**
 *
 * @author GUSTAVO
 */
public class BotaoAcao{
    TelaUsuario tela;

    public BotaoAcao(TelaUsuario tela) {
        this.tela = tela;
    }
    
    

    
    
    public void setEdicao(){
        this.AtivaCampos();
        
        
    }
    public void AtivaCampos() {
        for(Component c: tela.getjPFicha().getComponents()){
            if(c instanceof JComboBox){
                ((JComboBox) c).setEnabled(true);
            }
            if(c instanceof JCheckBox){
                ((JCheckBox) c).setEnabled(true);
            }
            if(c instanceof JTextField){
                ((JTextField) c).setEnabled(true);
            }
            if(c instanceof JDateChooser){
                ((JDateChooser)c).setEnabled(true);
            }
            if(c instanceof JScrollPane){
                for (Component co: ((JScrollPane)c).getComponents() ){
                    if(co instanceof JViewport){
                        for(Component com :((JViewport) co).getComponents()){
                            if(com instanceof JTextArea){
                                ((JTextArea) com).setEnabled(true);
                            }
                        }
                    }
                }
            }
        }
    }

    
    public void LimpaCampos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
