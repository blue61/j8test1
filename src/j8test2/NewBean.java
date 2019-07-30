/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j8test2;

import java.util.Optional;
import java.util.function.Supplier;

/**
 *
 * @author ktnagel
 */
public class NewBean {
    
    private String st;
    private int i;
    private Long longVar;
    private Optional<Long> longOpt;

    /**
     * @return the st
     */
    public Supplier<String> getSt() {
        return () -> st;
    }

    /**
     * @param st the st to set
     */
    public void setSt(Supplier<String> sts) {
        this.st = sts.get();
    }

    /**
     * @return the i
     */
    public int getI() {
        return i;
    }

    /**
     * @param i the i to set
     */
    public void setI(int i) {
        this.i = i;
    }

    /**
     * @return the longOpt
     */
    public Optional<Long> getLongOpt() {
        return longOpt;
    }

    /**
     * @param longOpt the longOpt to set
     */
    public void setLongOpt(Optional<Long> longOpt) {
        this.longOpt = longOpt;
    }

    /**
     * @return the longVar
     */
    public Supplier<Long> getLongVar() {
        return () -> longVar;
    }

    public void setLongVar(Supplier<Long> lvs) {
        this.longVar = lvs.get();
    }
    
    
    
    
}
