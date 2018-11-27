/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Game.Carta;
import Game.Jugador;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author rauldiego
 */
public class Controller {
    
    HashMap<String,Carta> cartasDisponibles = new HashMap<>();//Map de cartas disponibles que buscan si la carta esta disponible a traves de la clave
    ArrayList<Jugador>  jugadores = new ArrayList<>();//Lista con los jugadores 
    int numPlayer;//Numero de jugadores en la mesa
    char fasePartida;//Se indica que fase del juego estan
    int total; //Numero totales de combos que pueden salir teniendo en cuenta las cartas  y huecos disponibles
    
    public Controller(int num){
        
    }
}
