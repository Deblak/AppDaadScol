package fr.doranco.flash.ui.quiz.lire;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import fr.doranco.flash.MainActivity;
import fr.doranco.flash.R;
import fr.doranco.flash.databinding.ActivityQuizLireBinding;
import fr.doranco.flash.ui.quiz.intru.QuizIntruActivity;


public class QuizLireActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityQuizLireBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuizLireBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ImageButton buttonLire_backQuiz = binding.buttonLireBackQuiz;
        Button quizLire_btnFacile = binding.quizLireBtnFacile;
        Button quizLire_btnNormal = binding.quizLireBtnNormal;
        Button quizLire_BtnExpert = binding.quizLireBtnExpert;

        quizLire_btnFacile.setOnClickListener(this);
        quizLire_btnNormal.setOnClickListener(this);
        quizLire_BtnExpert.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonLire_backQuiz) {
            lireBackQuiz();
        } else if (view.getId() == R.id.quizLire_btnFacile) {
            startQuizFacile();
        } else if (view.getId() == R.id.quizLire_btnNormal) {
            startQuizNormal();
        } else if (view.getId() == R.id.quizLire_BtnExpert) {
            startQuizExpert();
        }
    }

    private void  lireBackQuiz(){
        Intent intent = new Intent(QuizLireActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    private void startQuizFacile() {
        Intent intent = new Intent(QuizLireActivity.this, StartLireFacile.class);
        startActivity(intent);
        finish();
    }

    private void startQuizNormal() {
        Intent intent = new Intent(QuizLireActivity.this, StartLireNormal.class);
        startActivity(intent);
        finish();
    }

    private void startQuizExpert() {
        Intent intent = new Intent(QuizLireActivity.this, StartLireExpert.class);
        startActivity(intent);
        finish();
    }
}
