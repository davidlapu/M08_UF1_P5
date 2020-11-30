package cat.itb.m08_uf1_p5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.List;

import cat.itb.m08_uf1_p5.R;
import cat.itb.m08_uf1_p5.adapters.PuntuacioAdapter;
import cat.itb.m08_uf1_p5.database.AppDatabase;
import cat.itb.m08_uf1_p5.database.Puntuacio;
import cat.itb.m08_uf1_p5.database.PuntuacioRepository;

public class StatsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Button buttonTornar;
    private List<Puntuacio> puntuacioList;
    private PuntuacioAdapter puntuacioAdapter;
    private PuntuacioRepository puntuacioRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        puntuacioRepository = new PuntuacioRepository(AppDatabase.getInstance(this.getApplicationContext()).puntuacioDao());
        puntuacioList = puntuacioRepository.getPuntuacions();

        buttonTornar = findViewById(R.id.buttonTornarStats);
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        puntuacioAdapter = new PuntuacioAdapter(puntuacioList);
        recyclerView.setAdapter(puntuacioAdapter);


        buttonTornar.setOnClickListener(this::buttonTornarClicked);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.stats_action_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.item_delete_all) {

            puntuacioRepository.nuke();
            puntuacioList = puntuacioRepository.getPuntuacions();
            puntuacioAdapter.notifyDataSetChanged();

            recreate();
        }

        return super.onOptionsItemSelected(item);
    }

    private void buttonTornarClicked(View view) {
        Intent i = new Intent(StatsActivity.this, MainActivity.class);
        startActivity(i);
    }
}