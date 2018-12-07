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
    private int total = 0;
    
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
    
    public Jugador[] calcularEquity(int a){
        combinatoria(0, k);
        return jugadores;
    }
    
    public void combinatoria(int a, int b){
      /*Combinaciones de N elementos tomados en grupos de K. */  
        if (b == 0) {
           comprobar(combination);
           System.out.println(combination.toString());
            return;
         }
        for (int i = a; i < cartas.size()-b; ++i) {
            combination.add(cartas.get(i));
            combinatoria(i+1, b - 1);
            combination.remove(combination.size()-1);
        }
        

    }
    
    public void comprobar(ArrayList<Carta> cartas){
        total++;
        try {
            ArrayList<BestHand>  arrayJugadores = new ArrayList<>();
            for(int i = 0; i < 6 ; i++){
                MejorManoJugador juego;
                juego = new MejorManoJugador(cartas, jugadores[i].getCartas());
                juego.mejorMano();
                BestHand mejormano = new BestHand(juego.getGanadoras(), juego.getValorMano());
                arrayJugadores.add(mejormano);
            }
            int pos = 0, sizeEmpates = 0;
            int [] empates = new int[6]; 
            boolean empate = false;
            for(int i = 1; i < 6; i++){

                if(arrayJugadores.get(pos).getValorMano().getCalidad() < arrayJugadores.get(i).getValorMano().getCalidad()){
                    pos = i;
                    empate = false;
                    sizeEmpates = 0;
    
                }
                else if(arrayJugadores.get(pos).getValorMano().getCalidad() > arrayJugadores.get(i).getValorMano().getCalidad()){
                    empate = false;
                    sizeEmpates = 0;
                }
                else if(arrayJugadores.get(pos).getValorMano().getCalidad() == arrayJugadores.get(i).getValorMano().getCalidad()){
                   if(arrayJugadores.get(pos).getGanadora().get(0).getValor() < arrayJugadores.get(i).getGanadora().get(0).getValor()){
                        pos = i;
                        empate = false;
                        sizeEmpates = 0;
    
                    }
                    else if(arrayJugadores.get(pos).getGanadora().get(0).getValor() > arrayJugadores.get(i).getGanadora().get(0).getValor()){
                        empate = false;
                        sizeEmpates = 0;
                    }
                    else if(arrayJugadores.get(pos).getGanadora().get(0).getValor() == arrayJugadores.get(i).getGanadora().get(0).getValor()){
                        empate = true;
                        if(sizeEmpates == 0){
                            empates[sizeEmpates] = pos;
                            sizeEmpates++;
                            empates[sizeEmpates] = i;
                            sizeEmpates++;
                        }
                        else{
                            empates[sizeEmpates] = i;
                            sizeEmpates++;
                        }
                    }
                }
            }
            if(!empate){
                jugadores[pos].win(1);
            }
            else{
               for(int i = 0; i < sizeEmpates; i++){
                   jugadores[i].win(1/sizeEmpates);
               }
            }

        } catch (MyExceptions ex) {
                Logger.getLogger(Calculadora.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public int getTotal(){
        return total;
    }
}
