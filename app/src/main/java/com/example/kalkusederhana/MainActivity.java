package com.example.kalkusederhana;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etPanjang, etLebar;
    private TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        etPanjang = findViewById(R.id.etPanjang);
        etLebar = findViewById(R.id.etLebar);
        tvHasil = findViewById(R.id.tvHasil);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void hitungLuas(View v) {
        String inputPanjang = etPanjang.getText().toString();
        String inputLebar = etLebar.getText().toString();

        if (inputPanjang.isEmpty() || inputLebar.isEmpty()) {
            Toast.makeText(this, "Isi dulu panjang dan lebarnya", Toast.LENGTH_SHORT).show();
            return;
        }

        double panjang = Double.parseDouble(inputPanjang);
        double lebar = Double.parseDouble(inputLebar);
        double luas = panjang * lebar;

        tvHasil.setText("Luas = " + luas + " cm²");
    }
}