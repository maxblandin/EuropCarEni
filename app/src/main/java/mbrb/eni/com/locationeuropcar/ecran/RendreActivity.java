package mbrb.eni.com.locationeuropcar.ecran;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import mbrb.eni.com.locationeuropcar.R;
import mbrb.eni.com.locationeuropcar.model.Reservation;
import mbrb.eni.com.locationeuropcar.model.Vehicule;
import mbrb.eni.com.locationeuropcar.service.LocationSvc;

public class RendreActivity extends AppCompatActivity implements RendreFragment.OnRendreListener {

    LocationSvc locationSvc = new LocationSvc();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rendre);

        // Vérifier les permissions
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            // La permission doit être demandée
            ActivityCompat.requestPermissions(this,
                    new String[] {
                            Manifest.permission.CAMERA,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.READ_EXTERNAL_STORAGE
                    },
                    42);
        }

        Button prendrePhoto = findViewById(R.id.btn_ajouter_photo);
        prendrePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takePicture();
            }
        });
    }


    @Override
    public Reservation recupererReservation() {
        Intent intent = getIntent();
        return locationSvc.recupererReservation(intent.getStringExtra("idReservation"));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 42) {
            if (grantResults.length >= 3
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED
                    && grantResults[1] == PackageManager.PERMISSION_GRANTED
                    && grantResults[2] == PackageManager.PERMISSION_GRANTED) {
                // La permission a déjà été donnée, lancer l'appareil photo
                takePicture();
            } else {
                Toast.makeText(this,
                        "Impossible d'obtenir les permissions nécessaires, veuillez réessayer",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    private Uri file;

    public void takePicture() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        // Préparation du fichier qui recevra la photo
        // Récupération du répertoire "Album" de l'appareil
        File mediaStorageDir = new File(
                Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_PICTURES), "VehiculePhoto"
        );
        // Si le répertoire "LiveCoding" n'existe pas, le créer
        if (!mediaStorageDir.exists()) {
            mediaStorageDir.mkdirs();
        }
        // Création d'un nom de fichier unique
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                .format(new Date());

        // Création du fichier dans le répertoire
        file = Uri.fromFile(new File(mediaStorageDir.getPath()
                + File.separator +
                timestamp + ".jpg"));

        // Désactiver la sécurité sur les URI
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

        // Lancement de l'activité de prise de vue
        intent.putExtra(MediaStore.EXTRA_OUTPUT, file);
        startActivityForResult(intent, 42);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 42) {
            if (resultCode == RESULT_OK) {
                ImageView image = findViewById(R.id.img_photo);
                image.setImageURI(file);
            } else {
                Toast.makeText(this,
                        "La photo n'a pas été prise, veuillez réessayer",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
}
