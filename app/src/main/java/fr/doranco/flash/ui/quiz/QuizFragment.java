package fr.doranco.flash.ui.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import fr.doranco.flash.databinding.FragmentQuizBinding;
import fr.doranco.flash.ui.quiz.lire.QuizLireActivity;


public class QuizFragment extends Fragment {
    private FragmentQuizBinding binding;
    private Button btn_quizLire;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentQuizBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        btn_quizLire = binding.btnQuizLire;
        btn_quizLire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLireGame();
            }
        });

        return root;
    }

    private void startLireGame() {
        Intent intent = new Intent(getActivity(), QuizLireActivity.class);
        startActivity(intent);
        getActivity().finish();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
