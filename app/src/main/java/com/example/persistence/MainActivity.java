package com.example.persistence;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText etID;
    private EditText etName;
    private EditText etLocation;

    private Button writeButton;
    private Button readButton;
    private Button deleteButton;

    private Data data;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etID = findViewById(R.id.et_id);
        etName = findViewById(R.id.et_name);
        etLocation = findViewById(R.id.et_values);
        writeButton = findViewById(R.id.write_button);
        readButton = findViewById(R.id.read_button);
        deleteButton = findViewById(R.id.delete_button);

        databaseHelper = new DatabaseHelper(MainActivity.this);


    }
}
