package com.example.proyecto_nuevo;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class cargando extends AppCompatActivity {

    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);

        MyAsyncTask asyncTask = new MyAsyncTask();
        asyncTask.execute();
    }

    public  class MyAsyncTask extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... voids){
            try{
                Thread.sleep(3000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return "Iphone 14 Pro";
        }

        @Override
        protected void onPostExecute(String result){
            textView.setText(result);
            imageView.setVisibility(imageView.VISIBLE);
        }
    }

}
