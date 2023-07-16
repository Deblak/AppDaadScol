package fr.doranco.flash.ui.quiz.lire;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.doranco.flash.MainActivity;
import fr.doranco.flash.R;
import fr.doranco.flash.databinding.ActivityMainBinding;
import fr.doranco.flash.databinding.ActivityQuizLireBinding;


public class QuizLireActivity extends AppCompatActivity {
    private ActivityQuizLireBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityQuizLireBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
    public void startEasyGame(View view) {
        Intent intent = new Intent(QuizLireActivity.this, StartLireFacile.class);
        startActivity(intent);
        finish();
    }
}