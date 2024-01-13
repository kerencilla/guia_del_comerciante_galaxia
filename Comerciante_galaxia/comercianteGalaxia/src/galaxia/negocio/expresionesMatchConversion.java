/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package galaxia.negocio;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Keren
 */
public class expresionesMatchConversion {
    
     // Crear una lista para almacenar expresiones regulares
    ArrayList<String> expresionesRegulares;

    public expresionesMatchConversion() {
      this.expresionesRegulares = new ArrayList<>();
    }
    
    
    public int getTipoLista(String texto){
        
        int tipoLista = -1;
       
        // Agregar expresiones regulares a la lista
        this.expresionesRegulares.add("^([A-Za-z]+) is ([I|V|X|L|C|D|M])$");  // ASSIGNED
        this.expresionesRegulares.add("^([A-Za-z]+)([A-Za-z\\s]*) is ([0-9]+) ([c|C]redits)$"); //CREDITS
        this.expresionesRegulares.add("^how much is (([A-Za-z\\s])+)\\?$");  //QUESTION_HOW_MUCH
        this.expresionesRegulares.add("^how many [c|C]redits is (([A-Za-z\\s])+)\\?$");  //QUESTION_HOW_MANY

        // Imprimir las expresiones regulares almacenadas en la lista
        for (int i = 0; i < expresionesRegulares.size(); i++) {
        
            Pattern pat = Pattern.compile(expresionesRegulares.get(i));
            Matcher mat = pat.matcher(texto.trim());            
            
            if (mat.matches()) {
                return tipoLista = i;
            }
           
        }
        
        return tipoLista;
        
    }

    
}
