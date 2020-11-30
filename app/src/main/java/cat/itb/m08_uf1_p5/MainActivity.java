package cat.itb.m08_uf1_p5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import cat.itb.m08_uf1_p5.database.AppDatabase;
import cat.itb.m08_uf1_p5.database.Pregunta;
import cat.itb.m08_uf1_p5.database.PreguntaDao;
import cat.itb.m08_uf1_p5.database.PreguntaRepository;
import cat.itb.m08_uf1_p5.database.Puntuacio;
import cat.itb.m08_uf1_p5.database.PuntuacioRepository;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonPlay = findViewById(R.id.buttonPlay);
        Button buttonStats = findViewById(R.id.buttonStats);

        initializeDatabase();

        buttonPlay.setOnClickListener(this::playClicked);
        buttonStats.setOnClickListener(this::statsClicked);
    }

    private void statsClicked(View view) {
        Intent intent = new Intent(MainActivity.this, StatsActivity.class);
        startActivity(intent);
    }

    private void playClicked(View v) {
        Intent intent = new Intent(MainActivity.this, GetNameActivity.class);
        startActivity(intent);
    }

    private void initializeDatabase() {
        AppDatabase db = AppDatabase.getInstance(this.getApplicationContext());
        PreguntaRepository preguntaRepository = new PreguntaRepository(db.preguntaDao());

        if (preguntaRepository.getAll().size() == 0) {
            Pregunta[] preguntas = {
                    new Pregunta("¿Quién fue el primer presidente de la democracia española tras el franquismo?", "Adolfo Suárez"),
                    new Pregunta("¿La invasión de qué fortaleza por parte de los revolucionarios es considerada como el punto de inicio de la Revolución Francesa?", "Bastilla"),
                    new Pregunta("¿En qué año el hombre pisó la Luna por primera vez?", "1969"),
                    new Pregunta("¿De qué se alimentan los koalas?", "Plantas"),
                    new Pregunta("¿Cuál es el río más largo del mundo?", "Nilo"),
                    new Pregunta("¿Dónde originaron los juegos olímpicos?", "Grecia"),
                    new Pregunta("¿Qué tipo de animal es la ballena?", "mamífero"),
                    new Pregunta("¿Cuál es el país más grande del mundo?", "Rusia"),
                    new Pregunta("¿Quién es el autor de el Quijote?", " Miguel de Cervantes"),
                    new Pregunta("¿En qué país se encuentra la torre de Pisa?", "Italia"),
                    new Pregunta("¿Cómo se denomina el resultado de la multiplicación?", "producto"),
                    new Pregunta("¿Qué año llegó Cristóbal Colón a América?", "1492"),
                    new Pregunta("¿Cuál es el país más grande del mundo?", "russia"),
                    new Pregunta("¿En qué año comenzó la II Guerra Mundial?", "1939"),
                    new Pregunta("¿Cual es país más poblado de la Tierra?", "china"),
                    new Pregunta("¿Qué rama de la Biología estudia los animales?", "zoología"),
                    new Pregunta("¿Cuál es la capital de Dinamarca?", "Copenhague"),
                    new Pregunta("¿Cómo se llama el proceso por el cual las plantas obtienen alimento?", "Fotosíntesis"),
                    new Pregunta("¿Cuánto vale el número pi?", "3,14"),
                    new Pregunta("¿Cuál es la capital de Croacia?", "Zagreb")};


            for (Pregunta p :
                    preguntas) {
                preguntaRepository.insert(p);
            }

        }

    }
}