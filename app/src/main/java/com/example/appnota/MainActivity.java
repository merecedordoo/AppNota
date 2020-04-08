package com.example.appnota;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText notas = (EditText) findViewById(R.id.edNotas);
        Button gravar  = (Button) findViewById(R.id.btGravar);
        Button mostrar = (Button) findViewById(R.id.btMostrar);

        gravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs     = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
                SharedPreferences.Editor ed = prefs.edit();

                ed.putFloat("notas", Float.parseFloat(notas.getText().toString()));
                ed.apply();

                Toast.makeText(getBaseContext(), "Gravado com sucesso", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
