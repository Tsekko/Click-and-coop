package com.example.clickncoop;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ScoreFragment extends Fragment {
    private CountViewModel model;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_score, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        //Récupération du score total du jeu Mash
        model = new ViewModelProvider(requireActivity()).get(CountViewModel.class);
        model.addition();
        modifyCurrentScore(model.getTotal());

        //Déplacement vers le Menu principal
        view.findViewById(R.id.menuButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(ScoreFragment.this).navigate(R.id.action_ScoreFragment_to_FirstFragment);
            }
        });

        //Retour au jeu Mash
        view.findViewById(R.id.replayButton).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                NavHostFragment.findNavController(ScoreFragment.this).navigate(R.id.action_ScoreFragment_to_SecondFragment);
            }
        });
    }

    private void modifyCurrentScore(int count){
        TextView t = getView().findViewById(R.id.currentScore);
        t.setText(String.valueOf(count));
    }
}