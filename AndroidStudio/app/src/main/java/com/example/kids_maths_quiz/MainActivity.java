package com.example.kids_maths_quiz;

import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

    EditText txtUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        txtUsername = findViewById(R.id.txtUsername);
        Button btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(v -> {
            String username = txtUsername.getText().toString().trim();

            if (isValidUsername(username)) {
                Intent intent = new Intent(MainActivity.this, LevelSelectorMenue.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }

        Button btnExit = findViewById(R.id.btnExit);
        btnExit.setOnClickListener( s -> {
            finishAffinity();
        });




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (a, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    });
};

    private boolean isValidUsername(String username) {
        if (username.isEmpty()) {
            txtUsername.setError("Username cannot be empty");
            return false;
        }
        if (username.length() < 3) {
            txtUsername.setError("Username must be at least 3 characters");
            return false;
        }
        if (username.length() > 20) {
            txtUsername.setError("Username cannot exceed 20 characters");
            return false;
        }
        if (!username.matches("^[a-zA-Z0-9_]+$")) {
            txtUsername.setError("Username can only contain letters, numbers and underscores");
            return false;
        }
        return true;
    }
}