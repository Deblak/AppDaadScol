package fr.doranco.flash.ui.quiz.intru;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.doranco.flash.R;
import fr.doranco.flash.databinding.ActivityStartIntruBaseBinding;
import fr.doranco.flash.ui.quiz.lire.GameOverLireActivity;
import fr.doranco.flash.ui.quiz.lire.StartLireBaseActivity;

public abstract class StartIntruBaseActivity extends AppCompatActivity {
    protected int points;
    protected TextView quizIntru_tvResult, intru_tvPoints;
    protected ImageButton imgBtn_Intru1, imgBtn_Intru2, imgBtn_Intru3, imgBtn_Intru4;
    //listes
    protected final ArrayList<Integer> intruList = new ArrayList<>();
    protected final ArrayList<Integer> optionList = new ArrayList<>();
    protected int index;
    // protected int totalQuestions;
    // protected int correctAnswerIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityStartIntruBaseBinding binding = ActivityStartIntruBaseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        quizIntru_tvResult = binding.quizIntruTvResult;
        intru_tvPoints = binding.intruTvPoints;
        imgBtn_Intru1 = binding.imgBtnIntru1;
        imgBtn_Intru2 = binding.imgBtnIntru2;
        imgBtn_Intru3 = binding.imgBtnIntru3;
        imgBtn_Intru4 = binding.imgBtnIntru4;

        // Initialiser l'index de la question à 0
        index = 0;

        // Générer la liste des intrus et des options (vraies lettres)
        generateIntruList();
        generateOptionList();
        Collections.shuffle(optionList);

        // Initialiser les points à 0
        points = 0;

        // Appel de la méthode startGame() responsable du démarrage du quiz.
        startIntruQuiz();
    }

    /**
     * Génère et mélange la liste des intrus
     */
    protected ArrayList<Integer> generateIntruList() {
        intruList.add(R.drawable.letter_01_alif_intru);
        intruList.add(R.drawable.letter_02_ba_intru);
        intruList.add(R.drawable.letter_03_ta_intru);
        intruList.add(R.drawable.letter_04_tha_intru);
        intruList.add(R.drawable.letter_05_jim_intrus);
        intruList.add(R.drawable.letter_06_hha_intru);
        intruList.add(R.drawable.letter_07_kha_intru);
        intruList.add(R.drawable.letter_08_del_intru);
        intruList.add(R.drawable.letter_09_dhel_intru);
        intruList.add(R.drawable.letter_10_ra_intru);
        intruList.add(R.drawable.letter_11_zay_intru);
        intruList.add(R.drawable.letter_12_sin_intru);
        intruList.add(R.drawable.letter_13_shin_intru);
        intruList.add(R.drawable.letter_14_sad_intru);
        intruList.add(R.drawable.letter_15_dad_intru);
        intruList.add(R.drawable.letter_16_taa_intru);
        intruList.add(R.drawable.letter_17_zha_intru);
        intruList.add(R.drawable.letter_18_ayin_intru);
        intruList.add(R.drawable.letter_19_ghayin_intru);
        intruList.add(R.drawable.letter_20_fa_intru);
        intruList.add(R.drawable.letter_21_qaf_intru);
        intruList.add(R.drawable.letter_22_kaf_intru);
        intruList.add(R.drawable.letter_23_lam_intru);
        intruList.add(R.drawable.letter_24_mim_intru);
        intruList.add(R.drawable.letter_25_noun_intru);
        intruList.add(R.drawable.letter_26_ha_intru);
        intruList.add(R.drawable.letter_27_waw_intru);
        intruList.add(R.drawable.letter_28_ya_intru);
        Collections.shuffle(intruList);
        return intruList;
    }

    /**
     * Génère et mélange la liste des options
     */
    protected ArrayList<Integer> generateOptionList() {
        optionList.add(R.drawable.letter_01_alif);
        optionList.add(R.drawable.letter_02_ba);
        optionList.add(R.drawable.letter_03_ta);
        optionList.add(R.drawable.letter_04_tha);
        optionList.add(R.drawable.letter_05_jim);
        optionList.add(R.drawable.letter_06_hha);
        optionList.add(R.drawable.letter_07_kha);
        optionList.add(R.drawable.letter_08_del);
        optionList.add(R.drawable.letter_09_dhel);
        optionList.add(R.drawable.letter_10_ra);
        optionList.add(R.drawable.letter_11_zay);
        optionList.add(R.drawable.letter_12_sin);
        optionList.add(R.drawable.letter_13_shin);
        optionList.add(R.drawable.letter_14_sad);
        optionList.add(R.drawable.letter_15_dad);
        optionList.add(R.drawable.letter_16_taa);
        optionList.add(R.drawable.letter_17_zha);
        optionList.add(R.drawable.letter_18_ayin);
        optionList.add(R.drawable.letter_19_ghayin);
        optionList.add(R.drawable.letter_20_fa);
        optionList.add(R.drawable.letter_21_qaf);
        optionList.add(R.drawable.letter_22_kaf);
        optionList.add(R.drawable.letter_23_lam);
        optionList.add(R.drawable.letter_24_mim);
        optionList.add(R.drawable.letter_25_noun);
        optionList.add(R.drawable.letter_26_ha);
        optionList.add(R.drawable.letter_27_waw);
        optionList.add(R.drawable.letter_28_ya);
        Collections.shuffle(optionList);
        return optionList;
    }

    /**
     * Méthode qui lance le jeu
     */
    protected void startIntruQuiz() {
        // Lier le texteView des points au comptage de points.
        intru_tvPoints.setText(points + " / 07");
        // générer la question
        generateIntruQuiz(index);
    }

    /**
     * Affiche la question et les options pour l'index donné
     */
    protected void generateIntruQuiz(int index) {

        // Mémoriser l'ID de la bonne réponse avant de mélanger la liste
        int correctAnswerId = intruList.get(0);

        Collections.shuffle(intruList);
        Collections.shuffle(optionList);

        ArrayList<Integer> answerList = new ArrayList<>();
        answerList.add(intruList.get(0));
        answerList.add(optionList.get(0));
        answerList.add(optionList.get(1));
        answerList.add(optionList.get(2));
        Collections.shuffle(answerList);

        imgBtn_Intru1.setImageResource(answerList.get(0));
        imgBtn_Intru2.setImageResource(answerList.get(1));
        imgBtn_Intru3.setImageResource(answerList.get(2));
        imgBtn_Intru4.setImageResource(answerList.get(3));

        // Stocker l'ID de la bonne réponse dans les tags des boutons pour la récupérer plus tard
        imgBtn_Intru1.setTag(answerList.get(0));
        imgBtn_Intru2.setTag(answerList.get(1));
        imgBtn_Intru3.setTag(answerList.get(2));
        imgBtn_Intru4.setTag(answerList.get(3));

        // Rétablir la couleur d'origine des boutons
        imgBtn_Intru1.setBackgroundResource(R.drawable.round_image_btn);
        imgBtn_Intru2.setBackgroundResource(R.drawable.round_image_btn);
        imgBtn_Intru3.setBackgroundResource(R.drawable.round_image_btn);
        imgBtn_Intru4.setBackgroundResource(R.drawable.round_image_btn);

        // Réactiver les boutons
        imgBtn_Intru1.setEnabled(true);
        imgBtn_Intru2.setEnabled(true);
        imgBtn_Intru3.setEnabled(true);
        imgBtn_Intru4.setEnabled(true);

        // Réinitialiser le texte de réponse
        quizIntru_tvResult.setText("");
    }

    /**
     * Methode qui s'applique lorsque le bouton Suivant ('Altaali') est appuyé.
     *
     * @param view change de couleur et de visibilité.
     */
    public void nextQuestionIntru(View view) {
        imgBtn_Intru1.setBackgroundResource(R.drawable.round_image_btn);
        imgBtn_Intru2.setBackgroundResource(R.drawable.round_image_btn);
        imgBtn_Intru3.setBackgroundResource(R.drawable.round_image_btn);
        imgBtn_Intru4.setBackgroundResource(R.drawable.round_image_btn);
        // Activer les bouttons
        imgBtn_Intru1.setEnabled(true);
        imgBtn_Intru2.setEnabled(true);
        imgBtn_Intru3.setEnabled(true);
        imgBtn_Intru4.setEnabled(true);

        index++;
        // vérifier si toutes les questions ont été posées
        if (index > 6) {
            // If true, cacher le ImageView et les Bouttons.
            imgBtn_Intru1.setVisibility(View.GONE);
            imgBtn_Intru2.setVisibility(View.GONE);
            imgBtn_Intru3.setVisibility(View.GONE);
            imgBtn_Intru4.setVisibility(View.GONE);
            // Aller à l'écran GameOver avec les points
            Intent intent = new Intent(StartIntruBaseActivity.this, GameOverIntruActivity.class);
            intent.putExtra("points", points);
            startActivity(intent);
            finish();
        } else {
            // Sinon appeler startIntruQuiz()
            startIntruQuiz();
        }
    }

    /**
     * Change la couleur au clic du ImageButton et vérifie la réponse sélectionnée
     */
    public void answerIntruSelected(View view) {
        // Change la couleur background des Button cliqués
        view.setBackgroundResource(R.drawable.round_image_btn_true);
        // Désactive les 4 boutons.
        imgBtn_Intru1.setEnabled(false);
        imgBtn_Intru2.setEnabled(false);
        imgBtn_Intru3.setEnabled(false);
        imgBtn_Intru4.setEnabled(false);
        // Au clic du boutton afficher le texte de réponse à l'utilisateur
        int selectedImageId = (int) view.getTag();
        int correctAnswerId = intruList.get(0);
        if (selectedImageId == correctAnswerId) {
            points++;
            intru_tvPoints.setText(points + " / 07");
            quizIntru_tvResult.setText("Bonne réponse !");
        } else {
            quizIntru_tvResult.setText("Mauvaise réponse.");
            view.setBackgroundResource(R.drawable.round_image_btn_false);
        }
    }

    public void exitQuizIntru(View view) {
        Intent intent = new Intent(StartIntruBaseActivity.this, QuizIntruActivity.class);
        startActivity(intent);

        finish();
    }
}
