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

import com.example.clickncoop.CountViewModel;
import com.example.clickncoop.R;

import java.util.Locale;


public class SecondFragment extends Fragment {
    private int count = 0;
    private int count2 = 0;
    private CountViewModel model;
    private CountViewModel model2;

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
        //test
        TextView textView = (TextView) view.findViewById(R.id.text_view);

        CountDownTimer countDownTimer = new CountDownTimer(10000, 1000) {
            public void onTick(long millisUntilFinished) {
                textView.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
            }

            public void onFinish() {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        }.start();

        view.findViewById(R.id.button_second).setOnClickListener(view1 -> NavHostFragment.findNavController(SecondFragment.this)
                .navigate(R.id.action_SecondFragment_to_FirstFragment));

        view.findViewById(R.id.button_joueur2).setOnClickListener(view2 -> plusCount2());
        view.findViewById(R.id.button_joueur1).setOnClickListener(view1 -> plusCount());

        model = new ViewModelProvider(requireActivity()).get(CountViewModel.class);
        count = model.getCompte();
        modifyTextView(count);

        model2 = new ViewModelProvider(requireActivity()).get(CountViewModel.class);
        count2 = model2.getCompte();
        modifyTextView2(count2);
    }


    private void plusCount(){
        count++;
        model.setCompte(count);
        modifyTextView(count);
    }

    private void plusCount2(){
        count2++;
        model2.setCompte(count2);
        modifyTextView2(count2);
    }

    private void modifyTextView(int count){
        TextView t = getView().findViewById(R.id.countText);
        t.setText(String.valueOf(count));
    }

    private void modifyTextView2(int count2){
        TextView t = getView().findViewById(R.id.countText2);
        t.setText(String.valueOf(count2));
    }
}