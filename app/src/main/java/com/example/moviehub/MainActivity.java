
package com.androidglide;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    String IMAGE_URL = "https://www.thecrazyprogrammer.com/wp-content/uploads/2015/09/Neeraj-Mishra.png";
    Button button;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        val articleAdapter = ArticleAdapter(this, articles)
        articlesRecyclerView.adapter = articleAdapter
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        image = (ImageView)findViewById(R.id.image);

        //load image on button click
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Glide.with(MainActivity.this).load(IMAGE_URL).into(image);
            }
        });
    }
}