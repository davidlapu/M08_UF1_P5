package cat.itb.m08_uf1_p5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.Authenticator;
import java.util.List;

import cat.itb.m08_uf1_p5.database.AppDatabase;
import cat.itb.m08_uf1_p5.database.Pregunta;
import cat.itb.m08_uf1_p5.database.PreguntaDao;
import cat.itb.m08_uf1_p5.database.PreguntaRepository;
import cat.itb.m08_uf1_p5.database.Puntuacio;
import cat.itb.m08_uf1_p5.database.PuntuacioRepository;

public class QuestionaryActivity extends AppCompatActivity {

    private EditText editTextAnswer;
    private TextView textViewSecondsRemaining, textViewCounterAnswers, textViewQuestion;
    private List<Pregunta> preguntas;
    private int questionCounter = -1, score = 0;
    static AppDatabase db;
    static PreguntaRepository preguntaRepository;

    //TODO timer
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionary);

        editTextAnswer = findViewById(R.id.editTextAnswer);
        textViewSecondsRemaining = findViewById(R.id.textViewSecondsRemainingNum);
        textViewCounterAnswers = findViewById(R.id.textViewContador);
        textViewQuestion = findViewById(R.id.textViewPregunta);

        initializeDatabase();
        setNextQuestion();

        editTextAnswer.setOnKeyListener(this::editTextAnswer);
    }

    private void setNextQuestion() {
        questionCounter++;
        if (questionCounter == 5) {
            finish();
        } else {
            textViewCounterAnswers.setText(getString(R.string.counter_answer, questionCounter + 1));
            textViewQuestion.setText(preguntas.get(questionCounter).getEnunciat());
        }
    }

    private boolean editTextAnswer(View view, int i, KeyEvent keyEvent) {
        if (i == 66 && keyEvent.getAction() == KeyEvent.ACTION_UP) {
            answerGiven(editTextAnswer.getText().toString());
            editTextAnswer.setText("");
        }
        return false;
    }

    private void answerGiven(String answer) {
        if (answer.equalsIgnoreCase(preguntas.get(questionCounter).getResposta())) {
            score++;
        }

        setNextQuestion();
    }

    private void initializeDatabase() {
        db = AppDatabase.getInstance(this.getApplicationContext());
        preguntaRepository = new PreguntaRepository(db.preguntaDao());

        preguntas = preguntaRepository.get5Rand();
    }

    public void finish() {
        score = score * 2;

        PuntuacioRepository puntuacioRepository= new PuntuacioRepository(db.puntuacioDao());
        puntuacioRepository.insert(new Puntuacio(getIntent().getExtras().getString("name"), score));

        Intent intent = new Intent(QuestionaryActivity.this, PuntuacioActivity.class);
        intent.putExtra("score", score);
        startActivity(intent);
    }


}