package com.example.wmhanaasri;

import static com.example.wmhanaasri.R.id.btnTugas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import adapter.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private HomeFragment homeFragment = new HomeFragment();
    private TugasFragment tugasFragment = new TugasFragment();
    private RekapFragment rekapFragment = new RekapFragment();
    private KaryawanFragment karyawanFragment = new KaryawanFragment();
    private ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavbar);
        bottomNavigationView.setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);

        ImageButton btnTugas = findViewById(R.id.btnTugas);

        btnTugas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ganti tampilan fragmen ke fragment_tugas
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.flFragment, new TugasFragment())
                        .commit();

                // Setel item navigasi bawah ke "Tugas"
                bottomNavigationView.setSelectedItemId(R.id.tugas);
            }
        });


    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.home) {
            // Ganti tampilan fragmen tanpa menekan tombol navigasi
            getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, homeFragment).commit();
            return true;
        } else if (itemId == R.id.tugas) {
            // Ganti tampilan fragmen tanpa menekan tombol navigasi
            getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, tugasFragment).commit();
            return true;
        } else if (itemId == R.id.rekap) {
            // Ganti tampilan fragmen tanpa menekan tombol navigasi
            getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, rekapFragment).commit();
            return true;
        } else if (itemId == R.id.karyawan) {
            // Ganti tampilan fragmen tanpa menekan tombol navigasi
            getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, karyawanFragment).commit();
            return true;
        }
        return false;
    }

}