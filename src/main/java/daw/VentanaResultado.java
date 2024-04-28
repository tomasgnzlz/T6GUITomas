/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Usuario
 */
public class VentanaResultado extends JFrame {

    public static final int ANCHO_PANEL = 600;
    public static final int ALTO_PANEL = 200;
    private JLabel resultado;

    public VentanaResultado(String chistes) {
        this.setTitle("Chistes Tomas");
        this.setResizable(false);
        this.setSize(ANCHO_PANEL, ALTO_PANEL);
        resultado = new JLabel();
        resultado.setText(chistes);
        this.add(resultado);
        this.pack();
        this.setVisible(true);
    }
}
