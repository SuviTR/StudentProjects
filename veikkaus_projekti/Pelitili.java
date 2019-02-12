/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veikkaus_projekti;

/**
 *
 * @author Käyttäjä
 */
public class Pelitili {
    
    private double tili;
    
    public Pelitili(){  
    }
    
    public void setTili(double uusiRaha){
        this.tili = uusiRaha;
    }
    public double getTili(){
        return tili;
    }
    
    public void lisaa(double uusiRaha){
        this.tili = tili + uusiRaha;
    }
    public boolean vahenna(double uusiRaha){
        if(tili >= uusiRaha && tili > 0) {
            this.tili = getTili() - uusiRaha;
            return true;
        }
        else {
            System.out.println("Vähennys epäonnistui.");
            return false;
        }
    }
    
}

