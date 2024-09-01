package br.edu.fatec.quizdasbandeiras;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;


public class Ranking extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ranking);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ListView mlist      = findViewById(R.id.listView);
        Button btnReplay    = findViewById(R.id.btnReplay);
        Button btnMainPage  = findViewById(R.id.btnMainPage) ;

        PlayerListAdapter adapter = new PlayerListAdapter(this, R.layout.layout_list_item,
                                                            Score.getInstance().getPlayersList() );
        mlist.setAdapter(adapter);


        btnReplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), Quiz.class);
                Score.getInstance().setScorePoints(0);
                finish();

                startActivity(it);
            }
        });

        btnMainPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), MainActivity.class);
                finish();
                startActivity(it);
            }
        });
    }

    @Override
    public void onBackPressed() {}
}