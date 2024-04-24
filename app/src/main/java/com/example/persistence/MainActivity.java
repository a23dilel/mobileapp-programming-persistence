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
    private TextView tvData;

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
        tvData = findViewById(R.id.textView_data);
        writeButton = findViewById(R.id.write_button);
        readButton = findViewById(R.id.read_button);
        deleteButton = findViewById(R.id.delete_button);

        databaseHelper = new DatabaseHelper(MainActivity.this);

        // Grab data from editTexts and add these data to the database
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
        // Read all data from database and print to views
        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // select all data from database and grab these to store i a variable
                List<Data> all = databaseHelper.SelectAllData();

                // if data is empty then print massage "Read data is empty" otherwise "Read data was successful!"
                if(all.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Read data is empty", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Read data was successful!", Toast.LENGTH_SHORT).show();
                }

                StringBuilder stringBuilder = new StringBuilder();

                // print each data item in a new line
                for (int i = 0; i < all.size(); i++) {
                    stringBuilder.append(all.get(i)).append("\n");
                }

                // print all data items on textView
                tvData.setText(stringBuilder.toString());
            }
        });
        // delete all data from database
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // return true if data is deleted
                boolean deleteSuccess = databaseHelper.DropTable();

                // if delete data was successful then print "Table is deleted" otherwise "Cannot delete table, because there is no table"
                if (deleteSuccess)
                {
                    Toast.makeText(MainActivity.this, "Table is deleted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Cannot delete table, because there is no table", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
