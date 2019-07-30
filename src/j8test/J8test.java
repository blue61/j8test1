/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package j8test;

/**
 *
 * @author tnagel
 */
public class J8test {

    public static void main(String... args) {
        Runnable r2 = () -> System.out.println("Howdy, world!");
        r2.run();
    } 


    
}
