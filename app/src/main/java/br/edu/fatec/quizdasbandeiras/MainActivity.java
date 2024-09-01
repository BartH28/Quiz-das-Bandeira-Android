package br.edu.fatec.quizdasbandeiras;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private EditText edtNome;
    private Button btnIniciar;
    private Button btnSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        edtNome = findViewById(R.id.edtNome);
        btnSair = findViewById(R.id.btnSair);
        edtNome.addTextChangedListener(inicioWatcher);
        btnIniciar = findViewById(R.id.btnIniciar);

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Score.getInstance().setPlayerName(edtNome.getText().toString());
                    Score.getInstance().setScorePoints(0);
                    Intent it =  new Intent(getApplicationContext(), Quiz.class);
                    finish();
                    startActivity(it);
            }
        });
    }

    TextWatcher inicioWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String nome = edtNome.getText().toString();
                btnIniciar.setEnabled(!nome.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

}