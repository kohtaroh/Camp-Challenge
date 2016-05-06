/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author kotaroh
 */
public class OhguchiServletJSPrenkeikadaiResultData implements Serializable  {
    private Date d;
    private String Luck;
    
    public OhguchiServletJSPrenkeikadaiResultData(){}
    /**
     * `return the d
     */
    public Date getD(){
        return d;
    }
    /**
     *  @param d the d to set
     */
    public void setD(Date d){
        this.d = d;
    }
    /**
     * `return the Luck
     */
    public String getLuck(){
        return Luck;
    }
    /**
     *  @param Luck the luck to set
     */
    public void setLuck(String Luck){
        this.Luck = Luck;
    }}