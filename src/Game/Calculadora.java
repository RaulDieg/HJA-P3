/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.util.ArrayList;

public class Calculadora {
    public ArrayList<Carta> cartas;
    ArrayList<Carta> combination;
    public int k;
    
    public Calculadora(ArrayList<Carta> cartas,int a){
        this.cartas= new ArrayList(cartas);
        switch(a){
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
        if (k == 0) {
         imprimir(combination);
         return;
         }
        for (int i = a; i <= cartas.size() - k; ++i) {
        combination.add(cartas.get(i));
        combinatoria(i+1, k-1);
        combination.remove(combination.size()-1);
        }
    }
    
    void imprimir(ArrayList<Carta> cartas){
        
    }
    
}
