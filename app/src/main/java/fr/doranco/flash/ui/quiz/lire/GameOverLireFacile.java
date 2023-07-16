package fr.doranco.flash.ui.quiz.lire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import fr.doranco.flash.R;
import fr.doranco.flash.databinding.ActivityGameOverLireFacileBinding;
import fr.doranco.flash.databinding.ActivityLireFacileBinding;

public class GameOverLireFacile extends AppCompatActivity {
    private TextView tvPoints, tvHighScore;
    private Button btnReplay, btnExit;
    private int points;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityGameOverLireFacileBinding binding = ActivityGameOverLireFacileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        points = getIntent().getExtras().getInt("points");
        tvPoints = binding.tvPoints;
        tvHighScore = binding.tvHighScore;

        // Afficher le nombre de points
        tvPoints.setText("Points : " + points);
        sharedPreferences = getSharedPreferences("pref", 0);
        int pointsSP = sharedPreferences.getInt("pointsSP", 0);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        if(points > pointsSP){
            pointsSP = points;
            editor.putInt("pointsSP", pointsSP);
            editor.commit();
        }
        tvHighScore.setText("" + pointsSP);
    }
    public void restart(View view) {
        Intent intent = new Intent(GameOverLireFacile.this, StartLireFacile.class);
        startActivity(intent);
        finish();
    }

    public void exit(View view) {
        Intent intent = new Intent(GameOverLireFacile.this, QuizLireActivity.class);
        startActivity(intent);
        finish();
    }
}