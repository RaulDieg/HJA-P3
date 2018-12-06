/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Exceptions.MyExceptions;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Calculadora {
    private ArrayList<Carta> cartas = new ArrayList<>();
    Jugador[] jugadores = new Jugador[6];
    private ArrayList<Carta> combination = new ArrayList<>();
    private int k;
    
    public Calculadora(ArrayList<Carta> cartas, Jugador[] aux, ArrayList<Carta> cartasBoard){
        this.cartas= new ArrayList(cartas);
        combination.addAll(cartasBoard);
        jugadores = aux;
        switch(cartasBoard.size()){
            case 0:
                this.k=5;
                break;
            case 3:
                this.k=2;
                break;
             case 4:
                this.k=1;
                break; 
             case 5:
                this.k=0;
                break;
        }
    }
    
    public void combinatoria(int a, int b){
      /*Combinaciones de N elementos tomados en grupos de K. */  
        if (b == 0) {
            calcularEquityCaso(combination);
            return;
         }
        for (int i = a; i < cartas.size(); ++i) {
            combination.add(cartas.get(i));
            combinatoria(i+1, b - 1);
            combination.remove(combination.size()-1);
        }
    }
    
    public void calcularEquityCaso(ArrayList<Carta> cartas){
        try {
            for(int i = 0; i < 6 ; i++){
                MejorManoJugador juego;
                juego = new MejorManoJugador(cartas, jugadores[i].getCartas());
                juego.mejorMano();
                ArrayList<BestHand>  aux = new ArrayList<>();
                BestHand mejormano = new BestHand(juego.getGanadoras(), juego.getValorMano());
                aux.add(mejormano);
            }
            
            //Aqui se compara quien gano o empato
        } catch (MyExceptions ex) {
                Logger.getLogger(Calculadora.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}
