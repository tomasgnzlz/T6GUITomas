/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import conexion_http.ConexionHTTP;
import java.io.IOException;
import modelos2.Joke;
import modelos2.ListaChistes;
import serviciojson.JsonService;

/**
 *
 * @author tomas
 */
public class MainTomas {
    public static void main(String[] args) throws IOException {
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
//        String urlBase = "https://v2.jokeapi.dev/joke/Programming?lang=es";
//        String urlBase2 = "https://v2.jokeapi.dev/joke/Any?lang=es&amount=5";
//        String fichero = ConexionHTTP.peticionHttpGet(urlBase);
//        String fichero2 = ConexionHTTP.peticionHttpGet(urlBase2);
//
//        Joke chiste = (Joke) JsonService.stringToPojo(fichero, Joke.class);
//        System.out.println(chiste);
//        System.out.println("-------------");
//        ListaChistes lista = (ListaChistes) JsonService.stringToPojo(fichero2, ListaChistes.class);
//        lista.getJokes().forEach(System.out::println);
    }
}
