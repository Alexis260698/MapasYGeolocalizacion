package net.ivanvega.misubicacionesymapasp87a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewAnimator;

import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsStates;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.security.Permission;

public class MainActivity extends AppCompatActivity implements MapasFragment.OnFragmentInteractionListener {
    private static final int REQUEST_CHECK_SETTINGS = 1001;
    LocationRequest locationRequest;
    private FusedLocationProviderClient fusedLocationClient;
    LocationSettingsRequest.Builder builder;
    TextView txt;
    final private int REQUEST_CODE_ASK_PERMISSION = 0;
    private boolean requestingLocationUpdates = true;

    public void click(View v) {
        startActivity(new Intent(getApplicationContext(), MapsActivity.class));
    }

    private LocationCallback locationCallback = new LocationCallback() {
        @Override
        public void onLocationResult(LocationResult locationResult) {
            if (locationResult == null) {
                return;
            }
            for (Location location : locationResult.getLocations()) {
                // Update UI with location data
                // ...
                String msj = "Latitud: " + String.valueOf(location.getLatitude())
                        + "\nLongitud: " + location.getLongitude();
                Toast.makeText(MainActivity.this, msj,
                        Toast.LENGTH_LONG).show();
                Log.i("POSICION", msj);
                txt.setText(msj);


            }
        }

        ;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Fragment fragmento = new MapasFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, fragmento).commit();


    }



/*
    public void solicitarPermiso() {
        int permisoFineLocation = ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        int permisoInternet=ActivityCompat.checkSelfPermission(this, Manifest.permission.INTERNET);
        int permisoCoarse = ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);
        int permisoBackground = ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_BACKGROUND_LOCATION);

        if (  permisoBackground != PackageManager.PERMISSION_GRANTED && permisoFineLocation != PackageManager.PERMISSION_GRANTED &&
                permisoCoarse != PackageManager.PERMISSION_GRANTED &&
                permisoInternet != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.INTERNET,Manifest.permission.ACCESS_BACKGROUND_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION,
                        }, REQUEST_CODE_ASK_PERMISSION);
            }


        }


    }

}
 */

}