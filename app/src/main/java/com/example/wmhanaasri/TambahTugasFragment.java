package com.example.wmhanaasri;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TambahTugasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TambahTugasFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Spinner spinner;
    private Spinner spinner2;
    private SpinnerAdapter adapter;
    private EditText tenggat;
    private DatePickerDialog picker;

    public TambahTugasFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TambahTugasFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TambahTugasFragment newInstance(String param1, String param2) {
        TambahTugasFragment fragment = new TambahTugasFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_tambah_tugas, container, false);
//        spinner = view.findViewById(R.id.spinDivisi);
//        spinner2 = view.findViewById(R.id.spinKepada);
//
//        ArrayAdapter<String> adapterDivisi = new ArrayAdapter<String>(requireActivity(), android.R.layout.simple_spinner_item);
//        adapterDivisi.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//        ArrayAdapter<String> adapterKepada = new ArrayAdapter<String>(requireActivity(), android.R.layout.simple_spinner_item);
//        adapterKepada.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//        adapterDivisi.add("Pilih Divisi");
//        adapterDivisi.add("Mobile App Developer");
//        adapterDivisi.add("Marketing");
//
//        adapterKepada.add("Pilih Tujuan");
//        adapterKepada.add("Gilang Rizqi");
//        adapterKepada.add("Gilang Arjuna");
//
//        spinner.setAdapter(adapterDivisi); // Mengatur adapter ke Spinner
//        spinner.setSelection(0); // Memilih item "Pilih Divisi" sebagai item default
//
//        spinner2.setAdapter(adapterKepada); // Mengatur adapter ke Spinner
//        spinner2.setSelection(0); // Memilih item "Pilih Tujuan" sebagai item default

        tenggat = view.findViewById(R.id.tenggat);
        tenggat.setInputType(InputType.TYPE_NULL);

        tenggat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(requireContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth){
                                tenggat.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

        return view;
    }
}