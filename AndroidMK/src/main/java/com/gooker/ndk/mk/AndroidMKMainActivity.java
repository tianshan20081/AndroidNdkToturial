package com.gooker.ndk.mk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.gooker.ndk.mk.jni.NdkHelper;

public class AndroidMKMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_mkmain);


        TextView helloTv = findViewById(R.id.helloTv);

        helloTv.setOnClickListener(v -> {
            int test = NdkHelper.test();
            helloTv.setText("tis is from ndk:" + test);
        });

    }
    
}