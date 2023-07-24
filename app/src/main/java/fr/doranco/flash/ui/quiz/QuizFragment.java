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
import fr.doranco.flash.ui.quiz.classer.QuizClasserActivity;
import fr.doranco.flash.ui.quiz.intru.QuizIntruActivity;
import fr.doranco.flash.ui.quiz.lire.QuizLireActivity;

public class QuizFragment extends Fragment implements View.OnClickListener {
    private FragmentQuizBinding binding;
    private Button btn_quizLire, btn_quizIntrus, btn_quizClasser;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentQuizBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        btn_quizLire = binding.btnQuizLire;
        btn_quizIntrus = binding.btnQuizIntrus;
        btn_quizClasser = binding.btnQuizClasser;

        btn_quizLire.setOnClickListener(this);
        btn_quizIntrus.setOnClickListener(this);
        btn_quizClasser.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.btn_quizLire) {
            startLireGame();
        } else if (id == R.id.btn_quizIntrus) {
            startIntruGame();
        } else if (id == R.id.btn_quizClasser) {
            startClasserGame();
        }
    }

    private void startClasserGame() {
        Intent intent = new Intent(getActivity(), QuizClasserActivity.class);
        startActivity(intent);
        getActivity().finish();
    }

    private void startLireGame() {
        Intent intent = new Intent(getActivity(), QuizLireActivity.class);
        startActivity(intent);
        getActivity().finish();
    }

    private void startIntruGame() {
        Intent intent = new Intent(getActivity(), QuizIntruActivity.class);
        startActivity(intent);
        getActivity().finish();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

