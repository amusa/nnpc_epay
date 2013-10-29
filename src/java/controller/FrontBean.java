/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Ayemi
 */
@ManagedBean
@RequestScoped
public class FrontBean implements Serializable{

    private String userId;
    private String payperiod;
    private boolean display = false;

    /** Creates a new instance of FrontBean */
    public FrontBean() {
    }

    
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPayperiod() {
        return payperiod;
    }

    public void setPayperiod(String payperiod) {
        this.payperiod = payperiod;
    }

    public boolean isDisplay() {
        return display;
    }

    public void setDisplay(boolean display) {
        this.display = display;
    }

    public String display() {
        setDisplay(true);
        return null;
    }
}
