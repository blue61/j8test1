/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kovartest;

/**
 *
 * @author tnagel
 */
public class TestChild1 extends TestParent1 {

    public TestChild1() {
        super.wert1 = new String("bla");
    }

    @Override
    protected String getWert1() {
        return (String)super.getWert1();
    }
    
    
    
    public void work() {
        System.out.println(getWert1().toUpperCase());
    }
    
    
}
