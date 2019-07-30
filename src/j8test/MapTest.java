/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j8test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tnagel
 */
public class MapTest implements Runnable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new MapTest().run();
    }

    public MapTest() {
    }

    
    void showList(List<?> liste) {
        liste.stream().forEach(System.out::println);
    }
    
    
    @Override
    public void run() {
        
        Map<String,String> mymap = new HashMap<>();
    
        mymap.put("Meier", "update");
        mymap.put("Müller", "new");
        mymap.put("Schulze", null);
        mymap.put("Schmitz", "update");
        mymap.put("Wolke", null);
        mymap.put("Xylophon", null);
        mymap.put("Zoo", "new");

        // old style to work
        System.out.println("Old Style");
        List<String> result = new ArrayList<>();
        for(String key : mymap.keySet()) {
            String value = mymap.get(key);
            if("update".equals(value)) {
                result.add(value + " " + key);
            } else if ("new".equals(value)) {
                result.add(value + " " + key);
            }
        }
        // print it
        showList(result);
        
        // new style, aber nur mit forEach(), nicht in einem stream!
        System.out.println("New Style");
        List<String> result2 = new ArrayList<>();
        mymap.forEach((key,value) -> { 
            if("update".equals(value)) {
                result2.add(value + " " + key);
            } else if ("new".equals(value)) {
                result2.add(value + " " + key);
            }
        });
        // print it
        showList(result2);
        
        
    }
    
}
