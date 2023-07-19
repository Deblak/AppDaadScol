package fr.doranco.flash.ui.quiz.intru;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fr.doranco.flash.R;
import fr.doranco.flash.databinding.ActivityQuizIntruBinding;
import fr.doranco.flash.databinding.ActivityQuizLireBinding;
import fr.doranco.flash.ui.quiz.lire.QuizLireActivity;
import fr.doranco.flash.ui.quiz.lire.StartLireFacile;

public class QuizIntruActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityQuizIntruBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuizIntruBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Button quizIntru_btnFacile = binding.quizIntruBtnFacile;
        Button quizIntru_btnNormal = binding.quizIntruBtnNormal;
        Button quizIntru_btnExpert = binding.quizIntruBtnExpert;

        quizIntru_btnFacile.setOnClickListener(this);
        quizIntru_btnNormal.setOnClickListener(this);
        quizIntru_btnExpert.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.quizIntru_btnFacile) {
            startQuizIntruFacile();
        } else if (view.getId() == R.id.quizIntru_btnNormal) {
            startQuizIntruNormal();
        } else if (view.getId() == R.id.quizIntru_btnExpert) {
            startQuizIntruExpert();
        }
    }

    private void startQuizIntruFacile(){
        Intent intent = new Intent(QuizIntruActivity.this, StartIntruFacile.class);
        startActivity(intent);
        finish();
    }

    private void startQuizIntruNormal(){
        Intent intent = new Intent(QuizIntruActivity.this, StartIntruFacile.class);
        startActivity(intent);
        finish();
    }
    private void startQuizIntruExpert(){
        Intent intent = new Intent(QuizIntruActivity.this, StartIntruFacile.class);
        startActivity(intent);
        finish();
    }
}