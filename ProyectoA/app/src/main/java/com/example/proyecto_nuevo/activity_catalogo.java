package com.example.proyecto_nuevo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class activity_catalogo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);
    }

    public void CatalogoSmartphone(View view){
        Intent intent = new Intent(this, activity_dispositivos.class);
        startActivity(intent);
    }

    public void Crud(View view){
        Intent intent = new Intent(this, activity_agregar_dispositivos.class);
        startActivity(intent);
    }
}
