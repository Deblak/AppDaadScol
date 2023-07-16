package fr.doranco.flash.ui.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import fr.doranco.flash.R;
import fr.doranco.flash.databinding.FragmentQuizBinding;
import fr.doranco.flash.ui.quiz.lire.QuizLireActivity;
import fr.doranco.flash.ui.quiz.lire.StartLireFacile;


public class QuizFragment extends Fragment {
    private FragmentQuizBinding binding;
    private Button alphabetButtonFacile;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentQuizBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        alphabetButtonFacile = root.findViewById(R.id.alphabet_buttonFacile);
        alphabetButtonFacile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLireFacileGame();
            }
        });

        return root;
    }

    private void startLireFacileGame() {
        Intent intent = new Intent(getActivity(), StartLireFacile.class);
        startActivity(intent);
        getActivity().finish();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
