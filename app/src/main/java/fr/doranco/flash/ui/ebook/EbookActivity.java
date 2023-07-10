package fr.doranco.flash.ui.ebook;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.ImageView;

import android.widget.ListView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import fr.doranco.flash.R;
import fr.doranco.flash.databinding.ActivityEbookBinding;
import fr.doranco.flash.ui.ebook.adapter.LivreAdapter;
import fr.doranco.flash.ui.ebook.entity.Livre;

public class EbookActivity extends AppCompatActivity {

    private ActivityEbookBinding binding;

    private ArrayList<Livre> livresList;
    private LivreAdapter mLivreAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEbookBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Livre livre1 = new Livre("114 exercices pour apprendre à lire l’arabe!"
                ,"msid"
                ,"TELLI BELDJOUDI Zineb DaadScol Lorem ipsum  "
                ,29.99);

        livresList = new ArrayList<>();
        livresList.add(livre1);

        final ListView listViewCatalog = (ListView) findViewById(R.id.listView);
        mLivreAdapter = new LivreAdapter(livresList, getLayoutInflater());
        listViewCatalog.setAdapter(mLivreAdapter);


    }

}