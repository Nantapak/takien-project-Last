package suwuttipoj.nantapak.takienfloatingmarket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class TestActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;
    private String textString, imageString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        //Bind Widget
        imageView = (ImageView) findViewById(R.id.imageView13);
        textView = (TextView) findViewById(R.id.textView21);

        //Get Value From Intent
        textString = getIntent().getStringExtra("Name");
        imageString = getIntent().getStringExtra("Image");

        //Show View
        Picasso.with(TestActivity.this).load(imageString).into(imageView);
        textView.setText(textString);



    }
}
