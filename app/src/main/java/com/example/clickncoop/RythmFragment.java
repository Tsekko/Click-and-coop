package com.example.clickncoop;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import org.w3c.dom.Text;

import java.util.Locale;


public class RythmFragment extends Fragment {
    private int count = 0;
    private CountViewModel model;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rythm, container, false);
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
                NavHostFragment.findNavController(RythmFragment.this)
                        .navigate(R.id.action_rythmFragment_to_FirstFragment);
            }

        };



        view.findViewById(R.id.button1).setOnClickListener(view1 -> bouton1(Timer, view));
        view.findViewById(R.id.button2).setOnClickListener(view1 -> bouton2(Timer, view));
        view.findViewById(R.id.button3).setOnClickListener(view1 -> bouton3(Timer, view));
        view.findViewById(R.id.button4).setOnClickListener(view1 -> bouton4(Timer, view));
        view.findViewById(R.id.button1).setBackgroundColor(Color.BLUE);

        view.findViewById(R.id.button1).setEnabled(true);
        view.findViewById(R.id.button2).setEnabled(false);
        view.findViewById(R.id.button3).setEnabled(false);
        view.findViewById(R.id.button4).setEnabled(false);

        view.findViewById(R.id.button1).setBackgroundColor(Color.CYAN);
        view.findViewById(R.id.button2).setBackgroundColor(Color.BLUE);
        view.findViewById(R.id.button3).setBackgroundColor(Color.BLUE);
        view.findViewById(R.id.button4).setBackgroundColor(Color.BLUE);


        model = new ViewModelProvider(requireActivity()).get(CountViewModel.class);
        model.setCompte(0);
        count = model.getCompte();
        modifyTextView(count);


    }

    private void bouton1(CountDownTimer Timer, View view){
        view.findViewById(R.id.button1).setEnabled(false);
        view.findViewById(R.id.button2).setEnabled(true);
        view.findViewById(R.id.button3).setEnabled(false);
        view.findViewById(R.id.button4).setEnabled(false);
        view.findViewById(R.id.button2).setBackgroundColor(Color.CYAN);
        view.findViewById(R.id.button1).setBackgroundColor(Color.BLUE);
        count++;
        model.setCompte(count);
        modifyTextView(count);
        if(count == 1) {
            Timer.start();
        }
    }

    private void bouton2(CountDownTimer Timer, View view){
        view.findViewById(R.id.button1).setEnabled(false);
        view.findViewById(R.id.button2).setEnabled(false);
        view.findViewById(R.id.button3).setEnabled(true);
        view.findViewById(R.id.button4).setEnabled(false);
        view.findViewById(R.id.button3).setBackgroundColor(Color.CYAN);
        view.findViewById(R.id.button2).setBackgroundColor(Color.BLUE);
        count++;
        model.setCompte(count);
        modifyTextView(count);
    }

    private void bouton3(CountDownTimer Timer, View view){
        view.findViewById(R.id.button1).setEnabled(false);
        view.findViewById(R.id.button2).setEnabled(false);
        view.findViewById(R.id.button3).setEnabled(false);
        view.findViewById(R.id.button4).setEnabled(true);
        view.findViewById(R.id.button4).setBackgroundColor(Color.CYAN);
        view.findViewById(R.id.button3).setBackgroundColor(Color.BLUE);
        count++;
        model.setCompte(count);
        modifyTextView(count);
    }

    private void bouton4(CountDownTimer Timer, View view){
        view.findViewById(R.id.button1).setEnabled(true);
        view.findViewById(R.id.button2).setEnabled(false);
        view.findViewById(R.id.button3).setEnabled(false);
        view.findViewById(R.id.button4).setEnabled(false);
        view.findViewById(R.id.button1).setBackgroundColor(Color.CYAN);
        view.findViewById(R.id.button4).setBackgroundColor(Color.BLUE);
        count++;
        model.setCompte(count);
        modifyTextView(count);
    }



    private void modifyTextView(int count){
        TextView t = getView().findViewById(R.id.countText);
        TextView t2 = getView().findViewById(R.id.countText2);
        t.setText(String.valueOf(count));
        t2.setText(String.valueOf(count));
    }

}