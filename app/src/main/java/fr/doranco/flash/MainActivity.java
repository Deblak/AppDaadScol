package fr.doranco.flash;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import android.os.Bundle;

import fr.doranco.flash.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActionBarDrawerToggle toggle;
    private ActivityMainBinding binding;
    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);
        setSupportActionBar(binding.topAppBar);

        //ajouter le toggler sur le toolbar
        toggle = new ActionBarDrawerToggle(this, binding.drawerLayout, binding.topAppBar, R.string.openDrawer, R.string.closeDrawer);
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.getDrawerArrowDrawable().setColor(getColor(R.color.white));//mettre à jour la couleur
        toggle.syncState();

    }
}