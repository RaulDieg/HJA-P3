/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.util.ArrayList;



public class Jugador {
    private ArrayList<Carta> cartasJugador = new ArrayList<>();
    private double numOfWins = 0;
    
    
    public Jugador(ArrayList<Carta> aux){
        
    }
    
    public void addCarta(Carta aux){
        cartasJugador.add(aux);
    }
    
    public void win(double a){
        numOfWins += a;
    }
    public ArrayList<Carta> getCartas(){
        return cartasJugador;
    }
}
