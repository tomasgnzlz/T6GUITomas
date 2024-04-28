/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package daw;

import conexion_http.ConexionHTTP;
import java.io.IOException;
import modelos.Joke;
import modelos2.ListaChistes;
import serviciojson.JsonService;

/**
 *
 * @author carlos
 */
public class ChisteMain {

    public static void main(String[] args) throws IOException {
        String urlBase = "https://v2.jokeapi.dev/joke/Programming?lang=es";
        String urlBase2 = "https://v2.jokeapi.dev/joke/Any?lang=es&amount=8";
        String fichero = ConexionHTTP.peticionHttpGet(urlBase);
        String fichero2 = ConexionHTTP.peticionHttpGet(urlBase2);

        Joke chiste = (Joke) JsonService.stringToPojo(fichero, Joke.class);
        System.out.println(chiste.toString());
        
        System.out.println("\n-----------------------------------------\n");
        ListaChistes lista = (ListaChistes) JsonService.stringToPojo(fichero2, ListaChistes.class);
        lista.getJokes().forEach(System.out::println);
        
    }

    public static String singlePartJoke(Joke joke) {
        return joke.getType();
    }

    public static String twoPartJoke(Joke joke) {
        return joke.getSetup() + joke.getDelivery();
    }

}
