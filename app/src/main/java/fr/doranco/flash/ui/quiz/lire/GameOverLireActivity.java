package fr.doranco.flash.ui.quiz.lire;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import fr.doranco.flash.databinding.ActivityGameOverLireBinding;

public class GameOverLireActivity extends AppCompatActivity {
    private TextView tvPoints, tvHighScore;
    private int points;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityGameOverLireBinding binding = ActivityGameOverLireBinding.inflate(getLayoutInflater());
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

    public void exitLire(View view) {
        Intent intent = new Intent(GameOverLireActivity.this, QuizLireActivity.class);
        startActivity(intent);
        finish();
    }
}