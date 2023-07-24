package fr.doranco.flash.ui.quiz.intru;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import fr.doranco.flash.R;
import fr.doranco.flash.databinding.ActivityGameOverIntruBinding;
import fr.doranco.flash.databinding.ActivityGameOverLireBinding;
import fr.doranco.flash.ui.quiz.lire.GameOverLireActivity;
import fr.doranco.flash.ui.quiz.lire.QuizLireActivity;

public class GameOverIntruActivity extends AppCompatActivity {
    private TextView tvPoints_intru, tvHighScore_intru;
    private int pointsIntru;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityGameOverIntruBinding binding = ActivityGameOverIntruBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        pointsIntru = getIntent().getExtras().getInt("points");
        tvPoints_intru = binding.tvPointsIntru;
        tvHighScore_intru = binding.tvHighScoreIntru;

        // Afficher le nombre de points
        tvPoints_intru.setText("Points : " + pointsIntru);
        sharedPreferences = getSharedPreferences("pref", 0);
        int pointsIntruSP = sharedPreferences.getInt("pointsIntruSP", 0);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (pointsIntru > pointsIntruSP) {
            pointsIntruSP = pointsIntru;
            editor.putInt("pointsIntruSP", pointsIntruSP);
            editor.commit();
        }
        tvHighScore_intru.setText("" + pointsIntruSP);
    }

    public void retourIntru(View view) {
        Intent intent = new Intent(GameOverIntruActivity.this, QuizIntruActivity.class);
        startActivity(intent);
        finish();
    }
}