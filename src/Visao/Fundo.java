/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Visao;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author GUSTAVO
 */
public class Fundo extends javax.swing.JPanel {
    
    BufferedImage b;
    Rectangle2D rect;
    
    public Fundo(){
        try{
            b = ImageIO.read(new File("C://SIGAF//fundo.jpg"));
            rect = new Rectangle(0, 0, 2000, 1024);
        }catch(IOException e){
            e.printStackTrace(System.err);
        }
    }
    
    public void paintComponent(Graphics g){
        TexturePaint p = new TexturePaint(b, rect);
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(p);
        g2.fillRect(0, 0,this.getWidth(), this.getHeight());
    }
    
}
