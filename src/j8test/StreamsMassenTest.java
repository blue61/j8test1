/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j8test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author tnagel
 */
public class StreamsMassenTest implements Runnable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new StreamsMassenTest().run();
    }

    public StreamsMassenTest() {
    }

    List<String> getText() {
        List<String> res = null;
        Path path = Paths.get("/Users/ktnagel/Documents/glocke.txt");
        System.out.println("Datei: " + path.normalize());
        try {
            res = Files.lines(path).collect(Collectors.toList());
        } catch (IOException iox) {
            Logger.getLogger("StreamsMassenTest").log(Level.SEVERE,"IOException",iox);
        }
        return res;
    }
    
    @Override
    public void run() {
        List<String> liste = getText();
        System.out.println("Zeilen: " + liste.size());
        
        Long start = java.time.Clock.systemDefaultZone().millis();
        
        liste.stream().sorted();
        
        Long done = java.time.Clock.systemDefaultZone().millis();
        
        System.out.println("Duration: " + (done-start) );
        
        
    }
    
}
