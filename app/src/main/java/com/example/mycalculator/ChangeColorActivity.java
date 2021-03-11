package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ChangeColorActivity extends AppCompatActivity implements Constants {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_color);

        Button btn_Theme_1 = findViewById(R.id.btn_theme_1);
        Button btn_Theme_2 = findViewById(R.id.btn_theme_2);
        String text = getIntent().getExtras().getString(CURRENT_THEME);
        EditText editTheme = findViewById(R.id.text_Theme);
        editTheme.setText(text);

        btn_Theme_1.setOnClickListener(v -> {
            Intent intentResult = new Intent();
            intentResult.putExtra(CURRENT_THEME, 1);
            setResult(1,intentResult);
            finish();
        });
        btn_Theme_2.setOnClickListener(v -> {
            Intent intentResult = new Intent();
            intentResult.putExtra(CURRENT_THEME, 2);
            setResult(0,intentResult);
            finish();
        });

    }
}