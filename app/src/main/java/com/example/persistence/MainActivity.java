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

        writeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // take all data from editText and store all the data on contractor
                data = new Data(etID.getText().toString(), etName.getText().toString(), etLocation.getText().toString());

                // return if insertData successful or not
                boolean success = databaseHelper.AddData(data);

                // checking if success for adding a data
                if (success)
                {
                    Toast.makeText(MainActivity.this, "Success for adding a data!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String message = "Failed for adding a data, because primary key ID: " + data.getID() + " has already applied?";
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                }
            }
        });
        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Data> all = databaseHelper.SelectAllData();

                TextView tvData = findViewById(R.id.textView_data);

                StringBuilder stringBuilder = new StringBuilder();

                // print each data item in a new line
                for (int i = 0; i < all.size(); i++) {
                    stringBuilder.append(all.get(i)).append("\n");
                }

                // print all data items on textView
                tvData.setText(stringBuilder.toString());
            }
        });

    }
}
