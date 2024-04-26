/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author tomas
 */
public class Panel extends JPanel {

    // Tamaño del panel. Constantes
    public static final int ANCHO_PANEL = 600;
    public static final int ALTO_PANEL = 200;

    // Atributos del panel
    private JLabel txtLang, txtCat, txtCant;
    private JComboBox<String> lang, categorias, cantidad;
    private JButton btnPedir,btnCerrar;
    

    // Constructor 
    public Panel() {
        // Establece el layout del panel
        this.setLayout(new FlowLayout());
        // Establece el color del fondo del panel
        this.setBackground(Color.ORANGE);
        // Establece el tamaño del panel
        this.setSize(ANCHO_PANEL, ALTO_PANEL);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
//*********************************Lenguaje*************************************
        String[] lenguajes = {"cs", "de", "es", "fr", "pt"};
        txtLang = new JLabel("Lenguaje:");
            
        this.add(txtLang);
        lang = new JComboBox<>(lenguajes);
        this.add(lang);
//*********************************Categoria************************************
        String[] categoria = {"Programming", "Miscellaneous", "Dark", "Pun", "Spooky", "Christmas"};
        txtCat = new JLabel("Categorias:");
        this.add(txtCat);
        categorias = new JComboBox<>(categoria);
        this.add(categorias);
//*********************************Cantidad************************************        
        String[] numeros = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        txtCant = new JLabel("Cantidad:");
        this.add(txtCant);
        cantidad = new JComboBox<>(numeros);
        this.add(cantidad);

//******************************************************************************
        // Añade el botón generar
        btnPedir = new JButton("Generar chistes");
        this.add(btnPedir);
        // Comportamiento del botón generar 
          // Comportamiento del botón generar 
        btnPedir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // SE abre la nueva ventana con el chiste o los chiestes
            }
        });

        // Añade botón cerrar
        btnCerrar = new JButton("Salir");
        this.add(btnCerrar);
        btnCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        
        

    }

}
