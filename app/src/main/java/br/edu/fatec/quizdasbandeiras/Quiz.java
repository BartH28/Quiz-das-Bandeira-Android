package br.edu.fatec.quizdasbandeiras;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Quiz extends AppCompatActivity {

    private RadioGroup rdgMain;
    private RadioButton rdbFourth;
    private Button btnAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quiz);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        rdgMain = findViewById(R.id.rdgMain);
        rdbFourth = findViewById(R.id.rdbFourth);
        btnAnswer = findViewById(R.id.btnAnswer);

       rdgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(RadioGroup radioGroup, int checkeId) {
                btnAnswer.setEnabled(true);
           }
       });

       btnAnswer.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               btnAnswer.setEnabled(false);
               Intent it = new Intent(getApplicationContext(), Quiz2.class);
               if (rdbFourth.isChecked())
                  Score.getInstance().setScorePoints(1);
               finish();
               startActivity(it);
           }
       });


    }

    @Override
    public void onBackPressed() {}
}