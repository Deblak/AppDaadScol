package fr.doranco.flash.ui.quiz.classer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import fr.doranco.flash.databinding.ActivityGameOverBinding;

public class GameOver extends AppCompatActivity {

    private TextView tvPoints_classer, tvHighScore_classer;
    private  int pointsClasser;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityGameOverBinding binding = ActivityGameOverBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        pointsClasser = getIntent().getExtras().getInt("points");
        tvPoints_classer = binding.tvPointsClasser;
        tvHighScore_classer = binding.tvHighScoreClasser;

        //Nombre de points
        tvPoints_classer.setText("Points :" + pointsClasser);
        sharedPreferences = getSharedPreferences("pref", 0);
        int pointsClasserSP = sharedPreferences.getInt("pointsClasserSP", 0);

        SharedPreferences.Editor  editor = sharedPreferences.edit();
        if (pointsClasser > pointsClasserSP) {
            pointsClasserSP = pointsClasser;
            editor.putInt("pointsClasserSP", pointsClasserSP);
            editor.apply();
        }
        tvHighScore_classer.setText("" + pointsClasserSP);

    }

    public void backClasser(View view) {
        Intent intent = new Intent(GameOver.this, QuizClasserActivity.class);
        startActivity(intent);


        finish();
    }
}