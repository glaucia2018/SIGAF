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
public class BotaoAcao {

    TelaUsuario tela;

    public BotaoAcao(TelaUsuario tela) {
        this.tela = tela;
    }

    public void setEdicao() {
        this.AtivaCampos();
        tela.getjTabbedPane1().setSelectedIndex(1);
        tela.getjBCancelar().setEnabled(true);
        tela.getjBAnterior().setEnabled(false);
        tela.getjBEditar().setEnabled(false);
        tela.getjBIncluir().setEnabled(false);
        tela.getjBPrimeiro().setEnabled(false);
        tela.getjBProximo().setEnabled(false);
        tela.getjBSalvar().setEnabled(true);
        tela.getjBUltimo().setEnabled(false);

    }

    public void setNavegacao() {
        this.DesativaCampos();
        if (this.tela.getjTTabela().getRowCount() != 0) {

            tela.getjTabbedPane1().setSelectedIndex(0);
            tela.getjBCancelar().setEnabled(false);
            tela.getjBAnterior().setEnabled(true);
            tela.getjBEditar().setEnabled(true);
            tela.getjBIncluir().setEnabled(true);
            tela.getjBPrimeiro().setEnabled(true);
            tela.getjBProximo().setEnabled(true);
            tela.getjBSalvar().setEnabled(false);
            tela.getjBUltimo().setEnabled(true);
        }else{
            tela.getjTabbedPane1().setSelectedIndex(0);
            tela.getjBCancelar().setEnabled(true);
            tela.getjBAnterior().setEnabled(false);
            tela.getjBEditar().setEnabled(false);
            tela.getjBIncluir().setEnabled(true);
            tela.getjBPrimeiro().setEnabled(false);
            tela.getjBProximo().setEnabled(false);
            tela.getjBSalvar().setEnabled(false);
            tela.getjBUltimo().setEnabled(false);
            
        }
    }

    public void AtivaCampos() {
        for (Component c : tela.getjPFicha().getComponents()) {
            if (c instanceof JComboBox) {
                ((JComboBox) c).setEnabled(true);
            }
            if (c instanceof JCheckBox) {
                ((JCheckBox) c).setEnabled(true);
            }
            if (c instanceof JTextField) {
                ((JTextField) c).setEnabled(true);
            }
            if (c instanceof JDateChooser) {
                ((JDateChooser) c).setEnabled(true);
            }
            if (c instanceof JScrollPane) {
                for (Component co : ((JScrollPane) c).getComponents()) {
                    if (co instanceof JViewport) {
                        for (Component com : ((JViewport) co).getComponents()) {
                            if (com instanceof JTextArea) {
                                ((JTextArea) com).setEnabled(true);
                            }
                        }
                    }
                }
            }
        }
    }

    public void DesativaCampos() {
        for (Component c : tela.getjPFicha().getComponents()) {
            if (c instanceof JComboBox) {
                ((JComboBox) c).setEnabled(false);
            }
            if (c instanceof JCheckBox) {
                ((JCheckBox) c).setEnabled(false);
            }
            if (c instanceof JTextField) {
                ((JTextField) c).setEnabled(false);
            }
            if (c instanceof JDateChooser) {
                ((JDateChooser) c).setEnabled(false);
            }
            if (c instanceof JScrollPane) {
                for (Component co : ((JScrollPane) c).getComponents()) {
                    if (co instanceof JViewport) {
                        for (Component com : ((JViewport) co).getComponents()) {
                            if (com instanceof JTextArea) {
                                ((JTextArea) com).setEnabled(false);
                            }
                        }
                    }
                }
            }
        }
    }

    public void LimpaCampos() {
        for(Component c: tela.getjPFicha().getComponents()){
            if (c instanceof JComboBox){
                ((JComboBox)c).setSelectedIndex(-1);
            }
            if(c instanceof JCheckBox){
                ((JCheckBox) c).setSelected(false);
            }
            if(c instanceof JTextField){
                ((JTextField) c).setText(null);
            }
            if(c instanceof JDateChooser){
                ((JDateChooser) c).setDate(null);
            }
            if( c instanceof JScrollPane){
                for(Component co: ((JScrollPane) c).getComponents()){
                    if(co instanceof JViewport){
                        for(Component com:((JViewport)co).getComponents()){
                            if(com instanceof JTextArea){
                                ((JTextArea)com).setText(null);
                            }
                        }
                    }
                }
            }
        }
    }

}
