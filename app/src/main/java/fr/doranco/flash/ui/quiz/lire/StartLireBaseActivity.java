package fr.doranco.flash.ui.quiz.lire;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import fr.doranco.flash.R;
import fr.doranco.flash.databinding.ActivityStartLireBaseBinding;

public abstract class StartLireBaseActivity extends AppCompatActivity {
    protected int points;
    protected TextView quizLire_tvResult, lire_tvPoints;
    protected ImageView iv_lire_showImage;
    protected Button lire_btn1, lire_btn2, lire_btn3, lire_btn4;
    protected final ArrayList<String> letterList = new ArrayList<>();
    protected final HashMap<String, Integer> map = new HashMap<>();
    protected int index;

    // pour le timer
    protected TextView tvTimer;
    CountDownTimer countDownTimer;
    long millisUntilFinished;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityStartLireBaseBinding binding = ActivityStartLireBaseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        quizLire_tvResult = binding.quizLireTvResult;
        lire_tvPoints = binding.lireTvPoints;
        iv_lire_showImage = binding.ivLireShowImage;
        lire_btn1 = binding.lireBtn1;
        lire_btn2 = binding.lireBtn2;
        lire_btn3 = binding.lireBtn3;
        lire_btn4 = binding.lireBtn4;
        tvTimer = binding.tvTimer;

        // Initialiser index à 0
        index = 0;

        // Nom des lettres :
        letterList.add("alif");
        letterList.add("ba");
        letterList.add("ta");
        letterList.add("tha");
        letterList.add("jim");
        letterList.add("haa");
        letterList.add("kha");
        letterList.add("del");
        letterList.add("dhel");
        letterList.add("ra");
        letterList.add("zay");
        letterList.add("sin");
        letterList.add("shin");
        letterList.add("sad");
        letterList.add("dad");
        letterList.add("taa");
        letterList.add("zha");
        letterList.add("ayin");
        letterList.add("ghayin");
        letterList.add("fa");
        letterList.add("qaf");
        letterList.add("kaf");
        letterList.add("lam");
        letterList.add("mim");
        letterList.add("noun");
        letterList.add("ha");
        letterList.add("waw");
        letterList.add("ya");

        // Associer le nom aux images sources
        map.put(letterList.get(0), R.drawable.carte_letter_01_alif);
        map.put(letterList.get(1), R.drawable.carte_letter_02_ba);
        map.put(letterList.get(2), R.drawable.carte_letter_03_ta);
        map.put(letterList.get(3), R.drawable.carte_letter_04_tha);
        map.put(letterList.get(4), R.drawable.carte_letter_05_jim);
        map.put(letterList.get(5), R.drawable.carte_letter_06_hha);
        map.put(letterList.get(6), R.drawable.carte_letter_07_kha);
        map.put(letterList.get(7), R.drawable.carte_letter_08_del);
        map.put(letterList.get(8), R.drawable.carte_letter_09_dhel);
        map.put(letterList.get(9), R.drawable.carte_letter_10_ra);
        map.put(letterList.get(10), R.drawable.carte_letter_11_zay);
        map.put(letterList.get(11), R.drawable.carte_letter_12_sin);
        map.put(letterList.get(12), R.drawable.carte_letter_13_shin);
        map.put(letterList.get(13), R.drawable.carte_letter_14_sad);
        map.put(letterList.get(14), R.drawable.carte_letter_15_dad);
        map.put(letterList.get(15), R.drawable.carte_letter_16_taa);
        map.put(letterList.get(16), R.drawable.carte_letter_17_zha);
        map.put(letterList.get(17), R.drawable.carte_letter_18_ayin);
        map.put(letterList.get(18), R.drawable.carte_letter_19_ghayin);
        map.put(letterList.get(19), R.drawable.carte_letter_20_fa);
        map.put(letterList.get(20), R.drawable.carte_letter_21_qaf);
        map.put(letterList.get(21), R.drawable.carte_letter_22_kaf);
        map.put(letterList.get(22), R.drawable.carte_letter_23_lam);
        map.put(letterList.get(23), R.drawable.carte_letter_24_mim);
        map.put(letterList.get(24), R.drawable.carte_letter_25_noun);
        map.put(letterList.get(25), R.drawable.carte_letter_26_ha);
        map.put(letterList.get(26), R.drawable.carte_letter_27_waw);
        map.put(letterList.get(27), R.drawable.carte_letter_28_ya);
        // Shuffle (Mélanger) letterList pour qu'à chaque fois que nous ouvrons l'application, elle commence par
        // une question au hasard
        Collections.shuffle(letterList);
        // Initialiser les points à 0
        points = 0;
        // Appel de la méthode startGame() responsable du démarrage du quiz.
        startGame();

    }

    protected void startGame() {
        // Lier le texteView des points au comptage de points.
        lire_tvPoints.setText(points + " / 07");
        // générer la question
        generateQuestions(index);
    }

    protected void generateQuestions(int index) {
        // Clone letterList dans un nouveau ArrayList appelé letterListTemp.
        ArrayList<String> letterListTemp = (ArrayList<String>) letterList.clone();
        // Donner la bonne réponse à la question en cours en utilisant l'index de letterList.
        String correctAnswer = letterList.get(index);
        // Il faut trouver 3 réponses incorrectes différentes de manière aléatoires.
        // 1 - Supprimer la bonne réponse de letterListTemp.
        // 2 - Mélanger et prendre les 3 premiers éléments de la liste.
        letterListTemp.remove(correctAnswer);
        Collections.shuffle(letterListTemp);

        // Créer un ArrayList temporaire pour enregistrer les 3 mauvaises réponses aléatoires
        // de letterListTemp et 1 réponse correcte.
        ArrayList<String> newList = new ArrayList<>();
        // Prendre les 3 premiers éléments de letterListTemp et les ajouter dans une newList.
        newList.add(letterListTemp.get(0));
        newList.add(letterListTemp.get(1));
        newList.add(letterListTemp.get(2));
        // Et bien entendu ajouter la réponse correcte dans une newList.
        newList.add(correctAnswer);

        // Mélanger newList pour que la réponse correcte soit placé sur l'un des 4 boutons aléatoirement.
        Collections.shuffle(newList);
        // Une fois que le shuffle newList est fait, appliquer le texte aux 4 boutons avec les éléments de newList
        lire_btn1.setText(newList.get(0));
        lire_btn2.setText(newList.get(1));
        lire_btn3.setText(newList.get(2));
        lire_btn4.setText(newList.get(3));
        // Aussi, appliquer ImageView à l'image actuelle de la map
        iv_lire_showImage.setImageResource(map.get(letterList.get(index)));
    }

    /**
     * Methode qui s'applique lorsque le bouton Suivant ('Altaali') est appuyé.
     *
     * @param view change de couleur et de visibilité.
     */
    public void nextQuestion(View view) {
        lire_btn1.setBackgroundColor(Color.parseColor("#341000"));
        lire_btn2.setBackgroundColor(Color.parseColor("#341000"));
        lire_btn3.setBackgroundColor(Color.parseColor("#341000"));
        lire_btn4.setBackgroundColor(Color.parseColor("#341000"));
        // Activer les bouttons
        lire_btn1.setEnabled(true);
        lire_btn2.setEnabled(true);
        lire_btn3.setEnabled(true);
        lire_btn4.setEnabled(true);

        index++;
        // vérifier si toutes les questions ont été posées
        if (index > 6) {
            // If true, cacher le ImageView et les Bouttons.
            iv_lire_showImage.setVisibility(View.GONE);
            lire_btn1.setVisibility(View.GONE);
            lire_btn2.setVisibility(View.GONE);
            lire_btn3.setVisibility(View.GONE);
            lire_btn4.setVisibility(View.GONE);
            // Aller à l'écran GameOver avec les points
            Intent intent = new Intent(StartLireBaseActivity.this, GameOverLireActivity.class);
            intent.putExtra("points", points);
            startActivity(intent);
            finish();
        } else {
            // Sinon appeler startGame()
            countDownTimer = null;
            startGame();
        }
    }

    public void answerSelected(View view) {
        // Change la couleur background des Button cliqués
        view.setBackgroundColor(Color.parseColor("#8EAB12"));
        // Désactive les 4 boutons.
        lire_btn1.setEnabled(false);
        lire_btn2.setEnabled(false);
        lire_btn3.setEnabled(false);
        lire_btn4.setEnabled(false);
        // Au clique du boutton afficher le texte de réponse à l'utilisateur
        String answer = ((Button) view).getText().toString().trim();
        // Et reccupérer la bonne réponse à la question actuelle de letterList en utilisant index
        // comme position.
        String correctAnswer = letterList.get(index);
        // Compare answer et correctAnswer, c'est-à-dire la réponse sélectionnée par l'utilisateur
        // et la bonne réponse à cette question.
        if (answer.equals(correctAnswer)) {
            // Si true, l'utilisateur a sélectionné la bonne réponse. Donc, augmenter les points :
            points++;
            // Ici, nous incrémentons les points de 1, mais vous pouvez incrémenter de n'importe quel nombre voulu.
            // Mettre à jour les TextViews pour les points et le résultat
            lire_tvPoints.setText(points + " / 07");
            quizLire_tvResult.setText("Bonne réponse !");
        } else {
            // Dans else, c'est-à-dire lorsque la réponse de l'utilisateur est incorrecte, affiche "Mauvaise réponse." dans tvResult.
            quizLire_tvResult.setText("Mauvaise réponse.");
            // Changer la couleur du boutton
            view.setBackgroundColor(Color.parseColor("#a94f61"));
        }
    }
}