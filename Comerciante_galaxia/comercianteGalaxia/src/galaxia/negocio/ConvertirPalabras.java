/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package galaxia.negocio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;


/**
 *
 * @author Keren
 */
public class ConvertirPalabras {
    
    private HashMap<String, String> asignacion;
    private HashMap<String, String> credito;
    private ArrayList<String> salidaPantalla;
    private ArrayList<String> listaPalabras;
    private expresionesMatchConversion matchConv;
    private NumerosRomanos numeroRomanos;
    private ErrorMensaje eMessage;

    public ConvertirPalabras(ArrayList<String> palabras) {
        this.asignacion = new HashMap<String, String>();
        this.credito = new HashMap<String, String>();
        this.salidaPantalla = new ArrayList<String>();
        this.listaPalabras = palabras;
        this.matchConv = new expresionesMatchConversion();
        this.numeroRomanos = new NumerosRomanos();
        this.eMessage = new ErrorMensaje();
    }

    public ArrayList<String> IniciarConvercion(){
        try {
            llenarListas();
        } catch (Exception e) {
             this.eMessage.printMessage(ErrorCodigo.INCORRECT_LINE_TYPE);
             System.out.println(e.getMessage());            
        }
 
        return this.salidaPantalla;
    }
    
    
    public void llenarListas(){
        
        String texto ;
        int tipList = 0;
        ErrorMensaje error = new ErrorMensaje();
       
         for (int i = 0; i < listaPalabras.size(); i++) {
             
             texto = listaPalabras.get(i);
             tipList = matchConv.getTipoLista(texto);
             
             switch (tipList) {
                
                 case 0:
                     addListaAsignar(texto);
                    break;
                 case 1:
                     addListaCred(texto);
                     break;
                 case 2:
                     addListaCuantoCuesta(texto);
                     break;
                 case 3:
                     addListaCuantoCreditos(texto);
                     break;
                 default:
                    this.salidaPantalla.add(error.getMessage(ErrorCodigo.NO_IDEA)); break;
             
             }
             
             
         }
 
    }
    
    
    public void addListaAsignar(String texto){
       
        String[] splited = texto.trim().split("\\s+");
        
        try
        {
           this.asignacion.put(splited[0], splited[2]);
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
             this.eMessage.printMessage(ErrorCodigo.INCORRECT_LINE_TYPE);
             System.out.println(e.getMessage());
        }
        
    }
   
    public void addListaCred(String texto){
        try
        {
                String formatted = texto.replaceAll("(is\\s+)|([c|C]redits\\s*)","").trim();

                String[] keys = formatted.split("\\s");

                String toBeComputed = keys[keys.length-2];
                float value = Float.parseFloat(keys[keys.length-1]);


                String roman="";

                for(int i=0;i<keys.length-2;i++)
                {
                    roman += asignacion.get(keys[i]);
                }

                int romanNumber = Integer.parseInt(numeroRomanos.romanToArabic(roman));
                float credit = (float)(value/romanNumber);


                credito.put(toBeComputed, credit+"");
        }
        catch(Exception e)
        {
             this.eMessage.printMessage(ErrorCodigo.INCORRECT_LINE_TYPE);
             System.out.println(e.getMessage());

        }
    }
    
    public void addListaCuantoCuesta(String texto){
        try
        {

            String formatted = texto.split("\\sis\\s")[1].trim();

            formatted = formatted.replace("?","").trim();

            String keys[] = formatted.split("\\s+");

            String romanResult="";
            String completeResult = null;
            boolean errorOccured = false;

            for(String key : keys)
            {
                String romanValue = asignacion.get(key);
                if(romanValue==null)
                {
                    completeResult = this.eMessage.getMessage(ErrorCodigo.NO_IDEA);
                    errorOccured = true;
                    break;
                }
                romanResult += romanValue;
            }

            if(!errorOccured)
            {
                    romanResult = numeroRomanos.romanToArabic(romanResult);
                    completeResult = formatted+" is "+romanResult;
            }

            salidaPantalla.add(completeResult);

        }
        catch(Exception e)
        {
             this.eMessage.printMessage(ErrorCodigo.INCORRECT_LINE_TYPE);
             System.out.println(e.getMessage());

        }
    }
    
    public void addListaCuantoCreditos(String texto){
       
        try
        {

            String formatted = texto.split("(\\sis\\s)")[1];

            formatted = formatted.replace("?","").trim();

            String[] keys = formatted.split("\\s");

            boolean found = false;
            String roman = "";
            String outputResult = null;
            Stack<Float> cvalues = new Stack<Float>();

            for(String key : keys)
            {
                    found = false;

                    String romanValue = asignacion.get(key);
                    if(romanValue!=null)
                    {
                            roman += romanValue;
                            found = true;
                    }

                    String computedValue = credito.get(key);
                    if(!found && computedValue!=null)
                    {
                            cvalues.push(Float.parseFloat(computedValue));
                            found = true;
                    }

                    if(!found)
                    {
                            //outputResult = this.eMessage.getMessage(ErrorCodes.NO_IDEA);
                            break;
                    }
            }

            if(found)
            {
                    float res=1;
                    for(int i =0;i<cvalues.size();i++)
                    res *= cvalues.get(i);

                    int finalres= (int) res;
                    if(roman.length()>0)
                    finalres = (int)(Integer.parseInt(numeroRomanos.romanToArabic(roman))*res);
                    outputResult = formatted +" is "+ finalres +" Credits";
            }

            this.salidaPantalla.add(outputResult);

        }
        catch(Exception e)
        {
             this.eMessage.printMessage(ErrorCodigo.INCORRECT_LINE_TYPE);
             System.out.println(e.getMessage());
        }
        
    }
    
}
