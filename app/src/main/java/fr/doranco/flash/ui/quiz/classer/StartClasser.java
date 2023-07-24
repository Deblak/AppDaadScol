package fr.doranco.flash.ui.quiz.classer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import fr.doranco.flash.MainActivity;
import fr.doranco.flash.R;
import fr.doranco.flash.databinding.ActivityStartClasserBinding;

public abstract class StartClasser extends AppCompatActivity {

    protected int points;
    protected TextView quizClasser_tvResult, classer_tvPoints;
    protected ImageButton imgBtn_Classer1, imgBtn_Classer2, imgBtn_Classer3,imgBtn_Classer4;
    protected ImageView img_Question;
    protected final ArrayList<Integer> list_ValiderLettre = new ArrayList<>();
    protected int index;

    protected final HashMap<Integer, Integer> map = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityStartClasserBinding binding = ActivityStartClasserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        quizClasser_tvResult = binding.quizClasserTvResult;
        classer_tvPoints = binding.tvClasserQuestion;
        imgBtn_Classer1 = binding.imgBtnClasser1;
        imgBtn_Classer2 = binding.imgBtnClasser2;
        imgBtn_Classer3 = binding.imgBtnClasser3;
        imgBtn_Classer4 = binding.imgBtnClassser4;
        img_Question = binding.imageQuestions;

        index = 0;

        list_ValiderLettre.add(R.drawable.carte_letter_01_alif);
        list_ValiderLettre.add(R.drawable.carte_letter_02_ba);
        list_ValiderLettre.add(R.drawable.carte_letter_03_ta);
        list_ValiderLettre.add(R.drawable.carte_letter_04_tha);
        list_ValiderLettre.add(R.drawable.carte_letter_05_jim);
        list_ValiderLettre.add(R.drawable.carte_letter_06_hha);
        list_ValiderLettre.add(R.drawable.carte_letter_07_kha);
        list_ValiderLettre.add(R.drawable.carte_letter_08_del);
        list_ValiderLettre.add(R.drawable.carte_letter_09_dhel);
        list_ValiderLettre.add(R.drawable.carte_letter_10_ra);
        list_ValiderLettre.add(R.drawable.carte_letter_11_zay);
        list_ValiderLettre.add(R.drawable.carte_letter_12_sin);
        list_ValiderLettre.add(R.drawable.carte_letter_13_shin);
        list_ValiderLettre.add(R.drawable.carte_letter_14_sad);
        list_ValiderLettre.add(R.drawable.carte_letter_15_dad);
        list_ValiderLettre.add(R.drawable.carte_letter_16_taa);
        list_ValiderLettre.add(R.drawable.carte_letter_17_zha);
        list_ValiderLettre.add(R.drawable.carte_letter_18_ayin);
        list_ValiderLettre.add(R.drawable.carte_letter_19_ghayin);
        list_ValiderLettre.add(R.drawable.carte_letter_20_fa);
        list_ValiderLettre.add(R.drawable.carte_letter_21_qaf);
        list_ValiderLettre.add(R.drawable.carte_letter_22_kaf);
        list_ValiderLettre.add(R.drawable.carte_letter_23_lam);
        list_ValiderLettre.add(R.drawable.carte_letter_24_mim);
        list_ValiderLettre.add(R.drawable.carte_letter_25_noun);
        list_ValiderLettre.add(R.drawable.carte_letter_26_ha);
        list_ValiderLettre.add(R.drawable.carte_letter_27_waw);
        list_ValiderLettre.add(R.drawable.carte_letter_28_ya);

        // Associer
        map.put(list_ValiderLettre.get(27), R.drawable.outline_letter_01_alif);
        map.put(list_ValiderLettre.get(0), R.drawable.outline_letter_02_ba);
        map.put(list_ValiderLettre.get(1), R.drawable.outline_letter_03_ta);
        map.put(list_ValiderLettre.get(2), R.drawable.outline_letter_04_tha);
        map.put(list_ValiderLettre.get(3), R.drawable.outline_letter_05_jim);
        map.put(list_ValiderLettre.get(4), R.drawable.outline_letter_06_hha);
        map.put(list_ValiderLettre.get(5), R.drawable.outline_letter_07_kha);
        map.put(list_ValiderLettre.get(6), R.drawable.outline_letter_08_del);
        map.put(list_ValiderLettre.get(7), R.drawable.outline_letter_09_dhel);
        map.put(list_ValiderLettre.get(8), R.drawable.outline_letter_10_ra);
        map.put(list_ValiderLettre.get(9), R.drawable.outline_letter_11_zay);
        map.put(list_ValiderLettre.get(10), R.drawable.outline_letter_12_sin);
        map.put(list_ValiderLettre.get(11), R.drawable.outline_letter_13_shin);
        map.put(list_ValiderLettre.get(12), R.drawable.outline_letter_14_sad);
        map.put(list_ValiderLettre.get(13), R.drawable.outline_letter_15_dad);
        map.put(list_ValiderLettre.get(14), R.drawable.outline_letter_16_taa);
        map.put(list_ValiderLettre.get(15), R.drawable.outline_letter_17_zha);
        map.put(list_ValiderLettre.get(16), R.drawable.outline_letter_18_ayin);
        map.put(list_ValiderLettre.get(17), R.drawable.outline_letter_19_ghayin);
        map.put(list_ValiderLettre.get(18), R.drawable.outline_letter_20_fa);
        map.put(list_ValiderLettre.get(19), R.drawable.outline_letter_21_qaf);
        map.put(list_ValiderLettre.get(20), R.drawable.outline_letter_22_kaf);
        map.put(list_ValiderLettre.get(21), R.drawable.outline_letter_23_lam);
        map.put(list_ValiderLettre.get(22), R.drawable.outline_letter_24_mim);
        map.put(list_ValiderLettre.get(23), R.drawable.outline_letter_25_noun);
        map.put(list_ValiderLettre.get(24), R.drawable.outline_letter_26_ha);
        map.put(list_ValiderLettre.get(25), R.drawable.outline_letter_27_waw);
        map.put(list_ValiderLettre.get(26), R.drawable.outline_letter_28_ya);


        Collections.shuffle(list_ValiderLettre);

        points = 0;

        startQuizClasser();

    }

    private void startQuizClasser() {
        classer_tvPoints.setText(points + " / 07");

        generateClasserQuiz(index);
    }

    private void generateClasserQuiz(int index) {

        ArrayList<Integer> letterlistTemp = (ArrayList<Integer>) list_ValiderLettre.clone();

        Integer correctAnswer= list_ValiderLettre.get(index);

        letterlistTemp.remove(correctAnswer);
        Collections.shuffle(letterlistTemp);

        ArrayList<Integer> newList = new ArrayList<>();

        newList.add(list_ValiderLettre.get(0));
        newList.add(list_ValiderLettre.get(1));
        newList.add(list_ValiderLettre.get(2));

        newList.add(correctAnswer);

        Collections.shuffle(newList);

        imgBtn_Classer1.setTag(newList.get(0));
        imgBtn_Classer1.setTag(newList.get(1));
        imgBtn_Classer1.setTag(newList.get(2));
        imgBtn_Classer1.setTag(newList.get(3));

        img_Question.setImageResource(map.get(list_ValiderLettre.get(index)));


    }


    public void nextQuestionClasser(View view) {

        imgBtn_Classer1.setEnabled(true);
        imgBtn_Classer2.setEnabled(true);
        imgBtn_Classer3.setEnabled(true);
        imgBtn_Classer4.setEnabled(true);

        index++;

        if (index > 6) {
            imgBtn_Classer1.setVisibility(View.GONE);
            imgBtn_Classer2.setVisibility(View.GONE);
            imgBtn_Classer3.setVisibility(View.GONE);
            imgBtn_Classer4.setVisibility(View.GONE);
            img_Question.setVisibility(View.GONE);
            Intent intent = new Intent(StartClasser.this, GameOver.class);
            intent.putExtra("points", points);
            startActivity(intent);

            finish();

        }else {
            startQuizClasser();
        }



    }

    public void answervalideSelected(View view) {
        view.setBackgroundResource(R.drawable.round_image_btn_true);

        imgBtn_Classer1.setEnabled(false);
        imgBtn_Classer2.setEnabled(false);
        imgBtn_Classer3.setEnabled(false);
        imgBtn_Classer4.setEnabled(false);

        Integer selectedImage = (int) view.getTag();
        Integer correctAnswer= list_ValiderLettre.get(index);
        if (selectedImage == correctAnswer) {
            points++;
            classer_tvPoints.setText(points + " /07");
            quizClasser_tvResult.setText("Bonne reponse");
        }else{
            quizClasser_tvResult.setText("Mauvaise reponse");
            view.setBackgroundResource(R.drawable.round_image_btn_false);

        }

    }

    public void exitQuizClasser(View view) {
        Intent intent = new Intent(StartClasser.this, MainActivity.class);
        startActivity(intent);

        finish();
    }
}