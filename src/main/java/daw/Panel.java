/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw;

import conexion_http.ConexionHTTP;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import modelos2.Joke;
import modelos2.ListaChistes;
import serviciojson.JsonService;

/**
 *
 * @author tomas
 */
public class Panel extends JPanel {

    // Tamaño del panel. Constantes
    public static final int ANCHO_PANEL = 600;
    public static final int ALTO_PANEL = 200;
    public static final String URL_BASE = "https://v2.jokeapi.dev/joke/";

    // Atributos del panel
    private JLabel txtLang, txtCat, txtCant;
    private JComboBox<String> idioma, categoria, cantidad;
    private JButton btnPedir, btnCerrar;

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
        idioma = new JComboBox<>(lenguajes);
        this.add(idioma);
//*********************************Categoria************************************
        String[] categorias = {"Any", "Programming", "Miscellaneous", "Dark", "Pun", "Spooky", "Christmas"};
        txtCat = new JLabel("Categorias:");
        this.add(txtCat);
        categoria = new JComboBox<>(categorias);
        this.add(categoria);
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
                // 1 -> Creamos la url
                String urlfinal = crearURL(idioma, categoria, cantidad);
                System.out.println("URLFINAL --> " + urlfinal);
                // 2 ->
                if (Integer.parseInt(cantidad.getSelectedItem().toString()) > 1) {
                    try {
                        // Llama al metodo que muestra una lista de chistes
                        chistesssssConsola(urlfinal);
                    } catch (IOException ex) {
                        Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {
                        // Llama al metodo que muestra un chiste
                        chisteConsola(urlfinal);
                    } catch (IOException ex) {
                        Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
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

    // Método que me devuelve la url Final
    public static String crearURL(JComboBox<String> lang, JComboBox<String> categorias, JComboBox<String> cantidad) {
//        String tipoPArtes = "single";
//        if (categorias.getSelectedItem().toString().equals("Programming")) {
//            tipoPArtes = "twopart";
//        }
        String cantidadChistes = "&amount=";
        if (Integer.parseInt(cantidad.getSelectedItem().toString()) >= 2) {
            cantidadChistes = cantidadChistes + cantidad.getSelectedItem().toString();
        } else {
            cantidadChistes = "";
        }
        String urlfinal
                = URL_BASE
                + categorias.getSelectedItem().toString()
                + "?lang=" + lang.getSelectedItem().toString()
                + cantidadChistes;
        return urlfinal;
    }

// Método que hace la conexion y me devuelve por consola el json con el chiste o los chistes
    public static void chisteConsola(String urlfinal) throws IOException {
        String fichero = ConexionHTTP.peticionHttpGet(urlfinal);
        modelos.Joke chiste =(modelos.Joke) JsonService.stringToPojo(fichero, modelos.Joke.class);
        System.out.println(chiste.toString());
    }
    
    public static void chistesssssConsola(String urlfinal) throws IOException {
        String fichero2 = ConexionHTTP.peticionHttpGet(urlfinal);
        ListaChistes lista = (ListaChistes) JsonService.stringToPojo(fichero2, ListaChistes.class);
        lista.getJokes().forEach(System.out::println);
    }
    
}
