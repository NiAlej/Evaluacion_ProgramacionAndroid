package com.example.proyecto_nuevo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class activity_agregar_dispositivos extends AppCompatActivity {

    Spinner spTipo,spMarca;

    String[] tipo = new String[]{"Smartphone", "Notebook", "Electrodomesticos"};
    String[] marcas = new String[]{"Iphone", "Samsumg", "Xiaomi", "Motorola"};

    EditText edtUsuario, edtId, edtModelo;
    ListView lista;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_agregar_dispositivos);
        
        edtId = (EditText) findViewById(R.id.edtId);
        edtUsuario = (EditText) findViewById(R.id.edtUsuario);
        edtModelo = (EditText) findViewById(R.id.edtModelo);
        spTipo = (Spinner) findViewById(R.id.spTipo);
        spMarca = (Spinner) findViewById(R.id.spMarca);
        lista = (ListView) findViewById(R.id.lstLista);

        ArrayAdapter<String> spinnerMarcas = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, marcas);
        ArrayAdapter<String> spinnerTipo = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tipo);
        spMarca.setAdapter(spinnerMarcas);
        spTipo.setAdapter(spinnerTipo);
    }

    public void Agregar(View view){
        DataHelper dh = new DataHelper(this, "dispositivos.db", null, 1);
        SQLiteDatabase bd = dh.getWritableDatabase();
        ContentValues reg = new ContentValues();
        reg.put("id",edtId.getText().toString());
        reg.put("usuario",edtUsuario.getText().toString());
        reg.put("modelo",edtModelo.getText().toString());
        reg.put("tipo",spTipo.getSelectedItem().toString());
        reg.put("marca",spMarca.getSelectedItem().toString());

        long resp = bd.insert("dispositivos",null,reg);
        bd.close();

        if (resp == -1){
            Toast.makeText(this, "No se pudo ingresar el registro", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Registtro agregado", Toast.LENGTH_LONG).show();
        }
        Limpiar();
        CargarLista();

    }

    public void Limpiar(){
        edtId.setText("");
        edtUsuario.setText("");
        edtModelo.setText("");
    }

    public void CargarLista() {
        DataHelper dh = new DataHelper(this, "dispositivos.db", null, 1);
        SQLiteDatabase bd = dh.getReadableDatabase();
        Cursor c = bd.rawQuery("Select id,usuario, modelo,marca,tipo from dispositivos", null);

        String[] arr = new String[c.getCount()];

        if (c.moveToFirst() == true) {
            int i = 0;
            do {
                String linea = "||" + c.getInt(0) + "||" + c.getString(1)
                        + "||" + c.getString(2) + "||" + c.getString(3) + "||" + c.getString(4) + "||";
                arr[i] = linea;
                i++;
            }
            while (c.moveToNext() == true);
            ArrayAdapter<String> adaptador = new ArrayAdapter<String>
                    (this, android.R.layout.simple_list_item_1, arr);
            lista.setAdapter(adaptador);
            bd.close();
        }
    }

    public void Eliminar(View view){
        DataHelper dh = new DataHelper(this, "dispositivos.db", null, 1);
        SQLiteDatabase bd = dh.getWritableDatabase();

        String bId = edtId.getText().toString();
        long resp = bd.delete("dispositivos", "id=" + bId, null);
        bd.close();

        if (resp == -1){
            Toast.makeText(this, "Registro no encontrado", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Registro eliminado", Toast.LENGTH_LONG).show();
        }

        Limpiar();
        CargarLista();
    }

    public void Modificar(View view){
        DataHelper dh = new DataHelper(this, "dispositivos.db", null, 1);
        SQLiteDatabase bd = dh.getWritableDatabase();

        ContentValues reg = new ContentValues();

        reg.put("id",edtId.getText().toString());
        reg.put("usuario",edtUsuario.getText().toString());
        reg.put("modelo",edtModelo.getText().toString());
        reg.put("tipo",spTipo.getSelectedItem().toString());
        reg.put("marca",spMarca.getSelectedItem().toString());

        long resp = bd.update("dispositivos", reg, "id=?", new String[]{edtId.getText().toString()});
        bd.close();

        if (resp == -1){
            Toast.makeText(this, "No se pudo modificar el registrp", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this, "Registro modificado", Toast.LENGTH_LONG).show();
        }

        Limpiar();
        CargarLista();
    }
}
