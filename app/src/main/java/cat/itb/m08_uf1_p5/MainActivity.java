package cat.itb.m08_uf1_p5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cat.itb.m08_uf1_p5.database.AppDatabase;
import cat.itb.m08_uf1_p5.database.Pregunta;
import cat.itb.m08_uf1_p5.database.PreguntaDao;
import cat.itb.m08_uf1_p5.database.PreguntaRepository;

public class MainActivity extends AppCompatActivity {

    private Button buttonPlay, buttonStats;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonPlay = findViewById(R.id.buttonPlay);
        buttonStats = findViewById(R.id.buttonStart);

        initializeDatabase();

        buttonPlay.setOnClickListener(this::playClicked);
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
                    new Pregunta("¿Capital de Madagascar?", "Antananativo"),
                    new Pregunta("¿Cuál es el lugar más frío de la tierra?", "La Antártida"),
                    new Pregunta("¿Quién escribió La Odisea?", "Homero"),
                    new Pregunta("¿Cuál es el río más largo del mundo?", "Amazonas"),
                    new Pregunta("¿Qué cantidad de huesos en el cuerpo humano?", "206"),
                    new Pregunta("¿Cuál es el disco más vendido de la historia?", "Thriller"),
                    new Pregunta("¿En qué se especializa la cartografía?", "Mapas"),
                    new Pregunta("¿Cuál es el país más grande del mundo?", "Rusia"),
                    new Pregunta("Si 50 es el 100%, ¿cuánto es el 90%?", "45"),
                    new Pregunta("¿Qué país tiene forma de bota?", "Italia"),
                    new Pregunta("¿En qué lugar del cuerpo se produce la insulina?", "Páncreas"),
                    new Pregunta("¿Cómo se llama el himno nacional de Francia?", "La Marsellesa"),
                    new Pregunta("¿Cuántas patas tiene la araña?", "8"),
                    new Pregunta("¿A qué país pertenecen los cariocas?", "Brasil"),
                    new Pregunta("¿Cuál es el nombre de la lengua oficial en china?", "Mandarín"),
                    new Pregunta("¿Cómo se llama la estación espacial rusa?", "Mir"),
                    new Pregunta("¿Cuál es el primero de la lista de los números primos?", "2"),
                    new Pregunta("¿Cuál es el libro sagrado del Islam?", "Corán"),
                    new Pregunta("¿A qué país pertenece la ciudad de Varsovia?", "Polonia"),
                    new Pregunta("¿A quién le crecía la nariz cuando mentía?", "Pinocho")};


            for (Pregunta p :
                    preguntas) {
                preguntaRepository.insert(p);
            }

        }

    }
}