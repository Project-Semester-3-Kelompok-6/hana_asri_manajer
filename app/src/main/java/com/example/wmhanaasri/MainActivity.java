package com.example.wmhanaasri;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private HomeFragment homeFragment = new HomeFragment();
    private TugasFragment tugasFragment = new TugasFragment();
    private RekapFragment rekapFragment = new RekapFragment();
    private KaryawanFragment karyawanFragment = new KaryawanFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavbar);
        bottomNavigationView.setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.home) {
            getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, homeFragment).commit();
            return true;
        } else if (itemId == R.id.tugas) {
            getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, tugasFragment).commit();
            return true;
        } else if (itemId == R.id.rekap) {
            getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, rekapFragment).commit();
            return true;
        } else if (itemId == R.id.karyawan) {
            getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, karyawanFragment).commit();
            return true;
        }
        return false;
    }
}