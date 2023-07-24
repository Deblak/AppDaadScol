package fr.doranco.flash.ui.quiz.classer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fr.doranco.flash.R;
import fr.doranco.flash.databinding.ActivityQuizClasserBinding;

public class QuizClasserActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityQuizClasserBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuizClasserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Button quizClasser_btnCommencer = binding.quizClasserBtnCommencer;

        quizClasser_btnCommencer.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.quizClasser_btnCommencer) {
            startQuizClasser();
        }
    }

    private void startQuizClasser() {
        Intent intent = new Intent(QuizClasserActivity.this, StartClasser.class);
        startActivity(intent);
        finish();
    }
}