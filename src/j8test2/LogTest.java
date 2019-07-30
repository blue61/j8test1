/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j8test2;

import java.util.logging.*;

        
/**
 *
 * @author ktnagel
 */
public class LogTest implements Runnable {

    private static final Logger LOG = Logger.getAnonymousLogger();
            
    public static void main(String[] args) {
        LogTest me = new LogTest();
        me.run();
    }
            

    public LogTest() {
    }

    @Override
    public void run() {
        long[] erg = new long[5];
        LOG.setLevel(Level.SEVERE);
        // 1. Durchlauf: kein Logging
        erg[0] = durchlauf(0);
        // 2. Durchlauf: 10% Logging
        erg[1] = durchlauf(10);
        // 3. Durchlauf: 20% Logging
        erg[2] = durchlauf(5);
        // 4. Durchlauf: 50% Logging
        erg[3] = durchlauf(2);
        
        // ergebnisse ausgeben
        LOG.severe("Dauer 0=" + erg[0] + " 1="+ erg[1] + " 2=" + erg[2] + " 3=" + erg[3]);
    }

    private long durchlauf(long mitLogZahl) {
        long anz = 0;
        long start = System.nanoTime();
        for(long i=0; i<10000; i++) {
            if(mitLogZahl > 0 && ((i % mitLogZahl) == 0)) {
                LOG.severe(() -> "es ist " + System.currentTimeMillis());
                anz ++;
            } else
                LOG.finer(() -> "es ist " + System.currentTimeMillis());
        }
        long dauer = (System.nanoTime() - start)/1000000L;
        LOG.severe("Anz=" + anz + " Dauer: " + dauer + "ms");
        return dauer;
    }
    
    
            

    
}
