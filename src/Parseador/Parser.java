/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parseador;

import Game.Carta;
import java.util.HashMap;

/**
 *
 * @author rauldiego
 */
public class Parser {
    /*este parser se encarga de:
     * -Se le llama desde la GUI cuaan se inica el programa
       -Elabora una map con todas las cartas de la baraja
       -Y lo guarda en un atributo para pasarselo al controller cuando sea necesario*/
    HashMap<String,Carta> cartasBaraja = new HashMap<>();
    
    public Parser(){
        //eleabora un hashmap con todas las cartas de la baraja;
    }
    
    public HashMap<String,Carta> getCartas(){
        return cartasBaraja;
    }
}
