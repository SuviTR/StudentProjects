/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veikkaus_projekti;
/**
 *
 * @strann
 */
public class Pelatutpelit {
    
    private int pelatutpelit;

    public void setPelatut(int uusiPelatut){
        this.pelatutpelit = uusiPelatut;
    }
    
    public void lisaaPelatut (int uusiPelatut){
        this.pelatutpelit = pelatutpelit + 1;
    }
    
    public int getPelatut(){
        return pelatutpelit;
    }
}
