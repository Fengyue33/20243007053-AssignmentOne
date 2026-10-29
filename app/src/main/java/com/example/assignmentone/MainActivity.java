package com.example.assignmentone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
/** Displays the CampusLife home screen and opens the selected topic. */
public class MainActivity extends AppCompatActivity {
    // Topic order matches arrays.xml: Facilities=0, Events=1, Clubs=2, Support=3.
    public static final String EXTRA_TOPIC_INDEX =
            "com.example.assignmentone.TOPIC_INDEX";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onFacilitiesClick(View view) {
        Toast.makeText(this, R.string.facilities_clicked, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(EXTRA_TOPIC_INDEX, 0);
        startActivity(intent);
    }

    public void onEventsClick(View view) {
        Toast.makeText(this, R.string.events_clicked, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(EXTRA_TOPIC_INDEX, 1);
        startActivity(intent);
    }

    public void onClubsClick(View view) {
        Toast.makeText(this, R.string.clubs_clicked, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(EXTRA_TOPIC_INDEX, 2);
        startActivity(intent);
    }

    public void onSupportClick(View view) {
        Toast.makeText(this, R.string.support_clicked, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(EXTRA_TOPIC_INDEX, 3);
        startActivity(intent);
    }
}