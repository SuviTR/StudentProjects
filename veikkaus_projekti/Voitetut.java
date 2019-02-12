/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veikkaus_projekti;

public class Voitetut {
    
    private double voitetturaha;
    
    public void lisaaVoitetut (double uusiVoitetut){
       this.voitetturaha = voitetturaha + uusiVoitetut;
    }
    
    public void setVoitettu (double uusiVoitetut){
        this.voitetturaha = uusiVoitetut;
    }
    
    public double getVoitetut(){
        return voitetturaha;
    }
}
