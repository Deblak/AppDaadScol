package fr.doranco.flash.ui.contact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.doranco.flash.MainActivity;
import fr.doranco.flash.R;
import fr.doranco.flash.databinding.ActivityContactBinding;


public class ContactActivity extends AppCompatActivity {

    private ActivityContactBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContactBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        configureBackButton();

        configureForm();
    }

    private void configureBackButton(){
        ImageButton backHomeButton = findViewById(R.id.button_backQuiz);
        backHomeButton.setOnClickListener(view -> startActivity(new Intent(ContactActivity.this, MainActivity.class)));
    }

    /**
     * Envoi du formulaire grace au Intent.
     * Les informations sont réccupérées dans la boîte mail de l'utilisateur.
     */

    public void configureForm() {
        final EditText form_name = binding.editTextName;
        final EditText form_email = binding.editTextEmail;
        final EditText form_message = binding.editTextMessage;
        Button email = binding.buttonEnvoyer;
        email.setOnClickListener(v -> {
            String name = form_name.getText().toString();
            String email1 = form_email.getText().toString();
            String message = form_message.getText().toString();

            if (TextUtils.isEmpty(name)) {
                form_name.setError("Indiquez votre nom, svp.");
                form_name.requestFocus();
                return;
            }

            Boolean onError = false;
            if (!isValidEmail(email1)) {
                onError = true;
                form_email.setError("Adresse invalide");
                return;
            }

            if (TextUtils.isEmpty(message)) {
                form_message.setError("Entrez un message, svp.");
                form_message.requestFocus();
                return;
            }
            Intent sendEmail = new Intent(Intent.ACTION_SEND);

            /* Fill it with Data */
            sendEmail.setType("plain/text");
            sendEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{"monmail@gmail.com"});
            sendEmail.putExtra(Intent.EXTRA_TEXT,
                    "name:" + name + '\n' + "Email ID:" + email1 + '\n' + "Message:" + '\n' + message);
            /* Send it off to the Activity-Chooser */
            startActivity(Intent.createChooser(sendEmail, "En cours d'envoi..."));
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        //Get a Tracker (should auto-report)
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    // validation email
    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
