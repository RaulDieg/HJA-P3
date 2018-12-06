/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Game.Carta;
import Game.Jugador;
import Game.Calculadora;
import java.util.ArrayList;


public class Controller {
    
    Carta[][] cartasDisponibles = new Carta[13][4];//Map de cartas disponibles que buscan si la carta esta disponible a traves de la clave
    ArrayList<Carta> cartasBoard = new ArrayList<>();
    Jugador[] jugadores = new Jugador[6];//Lista con los jugadores 
    char fasePartida;//Se indica que fase del juego estan
    int total; //Numero totales de combos que pueden salir teniendo en cuenta las cartas  y huecos disponibles
    
    
    public Controller(Carta[][] map, char fase){
        cartasDisponibles = map;
        fasePartida = fase;
    }
    
    public String generoCartaAleatorio(int num){
        int numero;
        numero = (int) (Math.random() * 51) + 1;
        
        while(cartasDisponibles[numero/4][numero%4].getElegida()){
            numero = (int) (Math.random() * 51) + 1;
        }
        
        cartasDisponibles[numero/4][numero%4].setElegida(true);
        jugadores[num/2].addCarta(cartasDisponibles[numero/4][numero%4]);
        
        return cartasDisponibles[numero/4][numero%4].toString();
    }  
    
    public String generoCarta(int num, String carta){
        
        Carta c = new Carta(carta.charAt(0), carta.charAt(1));
        
        if(!cartasDisponibles[c.getValor() - 2][c.paloToNumber()].getElegida()){
            cartasDisponibles[c.getValor() - 2][c.paloToNumber()].setElegida(true);
            jugadores[num/2].addCarta(cartasDisponibles[c.getValor() - 2][c.paloToNumber()]);
            return cartasDisponibles[c.getValor() - 2][c.paloToNumber()].toString();
        }
        else
            return null;
    }
    
    public String generoCartaAleatorioPostFlop(int num){
        int numero;
        numero = (int) (Math.random() * 51) + 1;
        
        while(cartasDisponibles[numero/4][numero%4].getElegida()){
            numero = (int) (Math.random() * 51) + 1;
        }
        
        cartasDisponibles[numero/4][numero%4].setElegida(true);
        cartasBoard.add(cartasDisponibles[numero/4][numero%4]);
        
        return cartasDisponibles[numero/4][numero%4].toString();
    }  
    
    public String generoCartaPostFlop(int num, String carta){
        
        Carta c = new Carta(carta.charAt(0), carta.charAt(1));
        
        if(!cartasDisponibles[c.getValor() - 2][c.paloToNumber()].getElegida()){
            cartasDisponibles[c.getValor() - 2][c.paloToNumber()].setElegida(true);
            cartasBoard.add(cartasDisponibles[c.getValor() - 2][c.paloToNumber()]);
            return cartasDisponibles[c.getValor() - 2][c.paloToNumber()].toString();
        }
        else
            return null;
    }
    
    public int[] calcularEquity(){
        //Aqui se inicializa el array de cartas no elegidas
        ArrayList<Carta> cartasNoDisponibles=new ArrayList();
        Calculadora calculadora;
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                if(!cartasDisponibles[i][j].getElegida()){
                    cartasNoDisponibles.add(cartasDisponibles[i][j]);
                }   
            }    
        }  
        //y se llama a la calculadora donde estara el metodo de combinatoria y el de comprobar quien gana
        calculadora=new Calculadora(cartasNoDisponibles, jugadores , cartasBoard);
     
        //En este se debe comprobar si estamos en preflop o postflop(y cuantas cartas hay)
        //se calcula el porcentaje de equity y se pasa un array de int o un string con la equity de cada uno
        return null;
    }
    
}
