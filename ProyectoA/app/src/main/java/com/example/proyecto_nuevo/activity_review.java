package com.example.proyecto_nuevo;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class activity_review extends AppCompatActivity {

    TextView textView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);

        activity_review.MyAsyncTask asyncTask = new activity_review.MyAsyncTask();
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

    public void verMapa(View view){
        Intent intent = new Intent(this, activity_mapa.class);
        startActivity(intent);
    }

    public void verVideo(View view){
        Intent intent = new Intent(this, activity_video.class);
        startActivity(intent);
    }
}
