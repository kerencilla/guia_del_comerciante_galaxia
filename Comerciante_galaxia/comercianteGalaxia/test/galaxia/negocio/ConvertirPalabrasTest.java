/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package galaxia.negocio;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author Keren
 */
public class ConvertirPalabrasTest {

    
    public ConvertirPalabrasTest() {
    }

    // #test 1
    @Test
    public void test1IniciarConvercion() {
        System.out.println("Test 1");
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> palabras = new ArrayList<>();
         palabras.add("glob is I");
         palabras.add("pish is X");
         palabras.add("prok is V");
         palabras.add("tegj is L");
         palabras.add("glob glob Silver is 34 Credits");
         palabras.add("glob prok Gold is 57800 Credits");
         palabras.add("pish pish Iron is 3910 Credits");
         palabras.add("how much is pish tegj glob glob ?");
         palabras.add("how many Credits is glob prok Silver ?");
         palabras.add("how many Credits is glob prok Gold ?");
         palabras.add("how many Credits is glob prok Iron ?");
         palabras.add("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?");
         
        ConvertirPalabras instance = new ConvertirPalabras(palabras);
        result = instance.IniciarConvercion();
   
         for (int j = 0; j < result.size(); j++) {
              System.out.println(result.get(j)) ;
        }
        //fail("The test case is a prototype.");
    }

    // #test 2
    @Test
    public void test2IniciarConvercion() {
        System.out.println("Test 2");
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> palabras = new ArrayList<>();
         palabras.add("glob is I");
         palabras.add("pish is X");
         palabras.add("prok is V");
         palabras.add("how much is pish prok glob ?");
         palabras.add("tegj is L");
         palabras.add("how much is pish tegj glob glob ?");
         palabras.add("glob glob Silver is 34 Credits");
         palabras.add("glob prok Gold is 57800 Credits");
         palabras.add("how many Credits is glob prok Gold ?");
         
         
        ConvertirPalabras instance = new ConvertirPalabras(palabras);
        result = instance.IniciarConvercion();
   
         for (int j = 0; j < result.size(); j++) {
              System.out.println(result.get(j)) ;
        }
        //fail("The test case is a prototype.");
    }

    // #test 3
    @Test
    public void test3IniciarConvercion() {
        System.out.println("Test 3");
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> palabras = new ArrayList<>();
         palabras.add("prok is I");
         palabras.add("how much is glob ?");
         palabras.add("how much is prok ?");
         palabras.add("glob is V");
         palabras.add("how much is glob ?");
         
         
        ConvertirPalabras instance = new ConvertirPalabras(palabras);
        result = instance.IniciarConvercion();
   
         for (int j = 0; j < result.size(); j++) {
              System.out.println(result.get(j)) ;
        }
        //fail("The test case is a prototype.");
    }

    // #test 4
    @Test
    public void test4IniciarConvercion() {
        System.out.println("Test 4");
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> palabras = new ArrayList<>();
         palabras.add("prok is I");
         palabras.add("glob is V");
         palabras.add("pish is X");
         palabras.add("how much is prok glob pish ?");
         palabras.add("how much is pish glob prok ?");
         palabras.add("how much is ?");
         
         
        ConvertirPalabras instance = new ConvertirPalabras(palabras);
        result = instance.IniciarConvercion();
   
         for (int j = 0; j < result.size(); j++) {
              System.out.println(result.get(j)) ;
        }
        //fail("The test case is a prototype.");
    }

    // #test 5
    @Test
    public void test5IniciarConvercion() {
        System.out.println("Test 5");
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> palabras = new ArrayList<>();
         palabras.add("glob is I");
         palabras.add("prok is V");
         palabras.add("glob glob Silver is 34 Credits");
         palabras.add("glob prok Gold is 57800 Credits");
         palabras.add("how many Credits is Silver Gold ?");

         
        ConvertirPalabras instance = new ConvertirPalabras(palabras);
        result = instance.IniciarConvercion();
   
         for (int j = 0; j < result.size(); j++) {
              System.out.println(result.get(j)) ;
        }
        //fail("The test case is a prototype.");
    }

}
