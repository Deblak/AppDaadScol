package fr.doranco.flash.ui.contact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import fr.doranco.flash.R;
import fr.doranco.flash.databinding.ActivityContactBinding;
import fr.doranco.flash.databinding.ActivityEbookBinding;

public class ContactActivity extends AppCompatActivity {

    private ActivityContactBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContactBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setContentView(R.layout.activity_contact);
    }
}