package fr.doranco.flash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.google.android.material.navigation.NavigationView;

import fr.doranco.flash.databinding.ActivityMainBinding;
import fr.doranco.flash.databinding.FragmentAccueilBinding;
import fr.doranco.flash.fragments.AccueilFragment;

public class MainActivity extends AppCompatActivity {
    private ActionBarDrawerToggle toggle;
    private ActivityMainBinding binding;
    private FragmentAccueilBinding fragmentAccueilBinding;
    private AppBarConfiguration appBarConfiguration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.topAppBar);

        //ajouter le toggler sur le toolbar
        toggle = new ActionBarDrawerToggle(this, binding.drawerLayout, binding.topAppBar, R.string.openDrawer, R.string.closeDrawer);
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.getDrawerArrowDrawable().setColor(getColor(R.color.white));//mettre à jour la couleur
        toggle.syncState();
    }


}