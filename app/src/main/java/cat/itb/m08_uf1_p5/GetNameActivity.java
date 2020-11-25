package cat.itb.m08_uf1_p5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GetNameActivity extends AppCompatActivity {

    private EditText editTextName;
    private Button buttonStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_name);

        editTextName = findViewById(R.id.editTextName);
        buttonStart = findViewById(R.id.buttonStart);

        buttonStart.setOnClickListener(this::startClicked);
    }

    private void startClicked(View view) {
        String name = editTextName.getText().toString();
        if (!name.isEmpty()) {
            Intent intent = new Intent(GetNameActivity.this, QuestionaryActivity.class);
            intent.putExtra("name", name);
            startActivity(intent);
        } else {
            Toast.makeText(this, R.string.must_put_name, Toast.LENGTH_LONG).show();
        }
    }
}