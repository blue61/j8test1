/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j8test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 *
 * @author tnagel
 */
public class LambdaTest implements Runnable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new LambdaTest().run();
    }

    
    List<String> find1(List<String> liste, String prefix) {
        List<String> result = new ArrayList<>();
        for(String st : liste) {
            if(st.startsWith(prefix))
                result.add(st);
        }
        return result;
    }
    
    /**
     * find2 zeigt das gleiche wie find1, nur flexibler, 
     * weil die Suchkriterien keine Parameter mehr sein müssen,
     * sondern an der Aufrufstelle ein Lambda formuliert wird.
     * Die Kriterien könn sich also ändern, ohne dass diese Methode sich ändert.
     * @param liste
     * @param predicate
     * @return 
     */
    List<String> find2(List<String> liste, Predicate<String> predicate) {
        List<String> result = new ArrayList<>();
        for(String st : liste) {
            if(predicate.test(st))
                result.add(st);
        }
        return result;
    }
    
    
    /**
     * diese Methode zeigt, wie ein Consumer als Lambda benutzt wird
     * @param liste
     * @param wohin 
     */
    void testAus(List<String> liste, Consumer<String> wohin) {
        liste.stream().forEach(wohin);
    }
    
    
    @Override
    public void run() {
        List<String> daten = new ArrayList<>();
        daten.add("Schmidt");
        daten.add("Meier"); 
        daten.add("Müller");
        daten.add("Poltergeist");
        daten.add("Schulze");
        daten.add("Chris");
        daten.add("sonstige");
        daten.add("Zeisig");
        System.out.println("Ausgangsdaten");
        System.out.println("--");
        testAus(daten,System.out::println);
        System.out.println("--");

        List<String> result1 = find1(daten,"M");
        System.out.println("Find1: suche fest Strings mit gegebenem Start");
        System.out.println("--");
        testAus(result1,System.out::println);
        System.out.println("--");
        
        List<String> result2 = find2(daten,(st)->st.toLowerCase().startsWith("s"));
        System.out.println("Find2: suche Strings die einem dynamischen Kriterium entsprechen");
        System.out.println("--");
        testAus(result2,System.out::println);
        System.out.println("--");
    }
    
}
