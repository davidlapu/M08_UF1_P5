package cat.itb.m08_uf1_p5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cat.itb.m08_uf1_p5.database.Puntuacio;

public class PuntuacioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntuacio);

        TextView textViewPuntuacio = findViewById(R.id.textViewPuntiacio);
        Button buttonTornar = findViewById(R.id.buttonTornar);

        textViewPuntuacio.setText(getString(R.string.puntuacio_final,
                getIntent().getExtras().getInt("score")));
        buttonTornar.setOnClickListener(this::buttonPressed);
    }

    private void buttonPressed(View view) {
        Intent intent = new Intent(PuntuacioActivity.this, MainActivity.class);
        startActivity(intent);
    }
}