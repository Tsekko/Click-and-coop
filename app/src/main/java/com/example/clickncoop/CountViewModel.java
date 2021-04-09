
package com.example.clickncoop;

import androidx.lifecycle.ViewModel;

public class CountViewModel extends ViewModel {
    private int compte = 0;
    private int compte2 = 0;
    private int total = 0;

    public CountViewModel(){}

    public int getCompte(){
        return compte;
    }

    public void setCompte(int compte){
        this.compte = compte;
    }

    public int getCompte2(){
        return compte2;
    }

    public void setCompte2(int compte2){
        this.compte2 = compte2;
    }

    public int getTotal(){
        return total;
    }

    public void addition(){
        total = compte + compte2;
    }
}