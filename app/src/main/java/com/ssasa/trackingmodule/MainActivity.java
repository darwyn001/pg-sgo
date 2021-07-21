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
                        new Gestion("Comercial", "Creación de solicitúd", 1, 0),
                        new Gestion("Legal", "Creación de entidad legal", 2, 1),
                        new Gestion("Legal", "Registro tributario", 3, 2),
                        new Gestion("Legal", "Registro de patente", 3, 2),
                        new Gestion("Lógistica", "Envio de mobiliario", 4, 3),
                        new Gestion("It", "Creación de usuarios y permisos", 5, 4),
                        new Gestion("It", "Creación de almacenes", 5, 4),
                        new Gestion("It", "Instalación de infraestructura", 5, 4),
                        new Gestion("It", "Instalación de equipo de computo", 5, 4),
                        new Gestion("It", "Instalación de CCTV", 5, 4)
                )
        );


        ConfigTracking.Companion.getInstance()
                .addMainItems(mainData)
                .setActiveDetailClickListener(view -> Toast.makeText(getApplicationContext(), "HOLA", Toast.LENGTH_SHORT).show());

        return new TrackingMain();
    }


}