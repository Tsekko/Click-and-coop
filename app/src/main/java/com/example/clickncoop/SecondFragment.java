package com.example.clickncoop;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import java.util.Locale;


public class SecondFragment extends Fragment {
    private int count = 0;
    private int count2 = 0;
    private CountViewModel model;
    private boolean timerStart = false;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView textView = (TextView) view.findViewById(R.id.text_view);
        TextView textView2 = (TextView) view.findViewById(R.id.text_view2) ;

        //création du compte à rebours
        CountDownTimer Timer = new CountDownTimer(10000, 1000) {
            public void onTick(long millisUntilFinished) {
                textView.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                textView2.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
            }

            public void onFinish() {
                //Vérification du fragment sur lequel on se trouve
                if(NavHostFragment.findNavController(SecondFragment.this).getCurrentDestination().getId()==R.id.SecondFragment){
                    //Déplacement sur le fragment de score
                    NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_ScoreFragment);
                }
            }



        };


        view.findViewById(R.id.button_joueur1).setOnClickListener(view1 -> plusCount(Timer));

        model = new ViewModelProvider(requireActivity()).get(CountViewModel.class);
        model.setCompte(0);
        count = model.getCompte();
        modifyTextView(count);


        view.findViewById(R.id.button_joueur2).setOnClickListener(view2 -> plusCount2(Timer));

        model.setCompte2(0);
        count2 = model.getCompte2();
        modifyTextView2(count2);

    }

    //Incrémentation du compteur 1
    private void plusCount(CountDownTimer Timer){
        count++;
        model.setCompte(count);
        modifyTextView(count);
        if(count2 == 1 && count == 1) {
            Timer.start();
            timerStart = true;
        } else if (!timerStart && count>=1){
            count=1;
            model.setCompte(1);
            modifyTextView(count);
        }
    }

    //Implémentation du compteur 2
    private void plusCount2(CountDownTimer Timer){
        count2++;
        model.setCompte2(count2);
        modifyTextView2(count2);
        if(count == 1 && count2 == 1) {
            Timer.start();
            timerStart = true;
        } else if(!timerStart && count2>=1){
            count2 = 1;
            model.setCompte2(1);
            modifyTextView2(count2);
        }
    }

    //Modification du TextView du compteur 1
    private void modifyTextView(int count){
        TextView t = getView().findViewById(R.id.countText);
        t.setText(String.valueOf(count));
    }

    //Modification du TextView du compteur 2
    private void modifyTextView2(int count2){
        TextView t = getView().findViewById(R.id.countText2);
        t.setText(String.valueOf(count2));
    }

}
