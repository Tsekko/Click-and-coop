
package com.example.clickncoop;

import androidx.lifecycle.ViewModel;

public class CountViewModel extends ViewModel {
    private int compte = 0;

    public CountViewModel(){}

    public int getCompte(){
        return compte;
    }

    public void setCompte(int compte){
        this.compte = compte;
    }
}