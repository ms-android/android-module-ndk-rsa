package com.ms.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.ms.module.ndk.rsa.RSA;

import java.security.PrivateKey;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RSA rsa = new RSA();
        String s = rsa.GetAPrivateKey();

        PrivateKey privateKey = null;
        try {
            privateKey = RSA.loadPrivateKey(s);
            String algorithm = privateKey.getAlgorithm();
            Log.e(TAG, "onCreate: " + algorithm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}