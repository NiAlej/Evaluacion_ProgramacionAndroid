package com.example.proyecto_nuevo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class activity_principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    public void VerCategorias(View view){
        Intent intent = new Intent(this, activity_catalogo.class);
        startActivity(intent);
    }
}
