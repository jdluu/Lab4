package edu.ucsd.cse110.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    String name = "";
    String status = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        loadProfile();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveProfile();
    }

    public void loadProfile() {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        // Get the string of the keys below using the second parameter, if none is given
        name = preferences.getString("name", "Nameless");
        TextView nameView = findViewById(R.id.name_textView);
        nameView.setText(name);

        status = preferences.getString("status", "Nothing");
        TextView statusView = findViewById(R.id.status_textview);
        statusView.setText(status);

    }

    public void saveProfile() {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        TextView nameView = findViewById(R.id.name_textView);
        editor.putString("name", nameView.getText().toString());
        editor.apply();

        TextView statusView = findViewById(R.id.status_textview);
        editor.putString("status", statusView.getText().toString());
        editor.apply();

    }

    public void onExitClicked(View view) {
        finish();
    }
}