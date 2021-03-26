package com.ssasa.trackingmodule;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.ssasa.tracking.ConfigTracking;
import com.ssasa.tracking.fragment.TrackingMain;
import com.ssasa.tracking.pojo.Gestion;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, getTrackingFragment())
                .commit();
    }

    private Fragment getTrackingFragment() {
        ArrayList<Gestion> mainData = new ArrayList<>(
                Arrays.asList(
                        new Gestion("Amigo 1", "HOLAAAAA", 1, 0),
                        new Gestion("Amigo 2", "HOLAAAAA", 2, 1),
                        new Gestion("Amigo 3", "HOLAAAAA", 3, 2),
                        new Gestion("Amigo 4", "HOLAAAAA", 4, 3),
                        new Gestion("Amigo 5", "HOLAAAAA", 5, 4)
                )
        );


        ConfigTracking.Companion.getInstance()
                .addMainItems(mainData)
                .setActiveDetailClickListener(view -> Toast.makeText(getApplicationContext(), "HOLA", Toast.LENGTH_SHORT).show());

        return new TrackingMain();
    }


}