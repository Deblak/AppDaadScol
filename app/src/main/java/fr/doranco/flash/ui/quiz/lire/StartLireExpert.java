package fr.doranco.flash.ui.quiz.lire;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;

public class StartLireExpert extends StartLireBaseActivity {
    private static final long TIMER_DURATION = 5000; // Durée du timer en millisecondes


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        millisUntilFinished = TIMER_DURATION;
    }

    @Override
    protected void startGame() {
        // Initialiser le timer pour la question actuelle
        millisUntilFinished = TIMER_DURATION;
        // Vérifier si le countDownTimer existe déjà
        if (countDownTimer != null) {
            countDownTimer.cancel(); // Annuler le countDownTimer précédent s'il existe
        }
        countDownTimer = new CountDownTimer(millisUntilFinished, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // Mettre à jour le texte du timer toutes les secondes
                tvTimer.setText("" + (millisUntilFinished / 1000) + "s");
            }

            @Override
            public void onFinish() {
                // Incrémenter l'index pour passer à la prochaine question automatiquement
                index++;
                // Vérifier si toutes les questions ont été posées
                if (index > 6) {
                    // Si true, cacher l'ImageView et les boutons
                    iv_lire_showImage.setVisibility(View.GONE);
                    lire_btn1.setVisibility(View.GONE);
                    lire_btn2.setVisibility(View.GONE);
                    lire_btn3.setVisibility(View.GONE);
                    lire_btn4.setVisibility(View.GONE);
                    // Redirection vers l'écran GameOver
                    Intent intent = new Intent(StartLireExpert.this, GameOverLireActivity.class);
                    intent.putExtra("points", points);
                    startActivity(intent);
                    // Terminer l'activité StartLireNormal
                    finish();
                } else {
                    countDownTimer = null;
                    startGame();
                }
            }
        }.start();

        // Appel de la méthode héritée pour générer les questions
        super.generateQuestions(index);
    }
}

