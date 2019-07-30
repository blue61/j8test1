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
public class Ques02 {
    
    public static void main(String[] args) {

        Thread inactive = new Thread(new InactiveThread());
        inactive.start();
        
        Thread active = new Thread(new ActiveThread());
        active.start();        
    }
    
}


class ActiveThread implements Runnable {
    @Override
    public void run() {
        System.out.println("Active Thread");
    }    
}

class InactiveThread implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(4 * 1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Inactive Thread");
    }
}
