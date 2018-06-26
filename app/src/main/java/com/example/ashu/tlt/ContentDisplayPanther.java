package com.example.ashu.tlt;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.print.PrintHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ContentDisplayPanther extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_display_panther);

        button = (Button) findViewById(R.id.panther_call);

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:09839855154"));

                if(ActivityCompat.checkSelfPermission(ContentDisplayPanther.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(ContentDisplayPanther.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                    return;
                }
                startActivity(callIntent);
            }
        });

    }
}
