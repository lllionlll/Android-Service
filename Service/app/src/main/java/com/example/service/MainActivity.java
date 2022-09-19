package com.example.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.service.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.create.setOnClickListener(v -> {
            create_Service();
        });

        binding.stop.setOnClickListener(v -> {
            stop_Service();
        });
    }

    private void create_Service() {
        Intent intent = new Intent(this, MyService.class);
        intent.putExtra("Content", binding.content.getText().toString().trim());
        startService(intent);
    }

    private void stop_Service() {
        Intent intent = new Intent(this, MyService.class);
        stopService(intent);
    }
}