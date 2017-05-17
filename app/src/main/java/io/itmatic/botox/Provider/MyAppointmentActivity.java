package io.itmatic.botox.Provider;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.itmatic.botox.Adapter.PatientAdapter;
import io.itmatic.botox.Model.Patient;
import io.itmatic.botox.R;

public class MyAppointmentActivity extends AppCompatActivity {
    @BindView(R.id.rv_appointment)
    RecyclerView recyclerView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.btn_new_appointment)
    Button buttonNewAppointment;
    @BindView(R.id.btn_old_appointment)
    Button buttonOldAppointment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_appointment);
        ButterKnife.bind(this);
        final ArrayList<Patient> newPatients = new ArrayList<>();
        final ArrayList<Patient> oldPatients = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            Patient patient = new Patient();
            patient.setFullName("name" + " " + i);
            patient.setDob(new Date().toString());
            newPatients.add(patient);
        }
        for (int i = 0; i < 5; i++) {
            Patient patient = new Patient();
            patient.setFullName("name" + " " + i);
            patient.setDob(new Date().toString());
            oldPatients.add(patient);
        }
        PatientAdapter patientAdapter = new PatientAdapter(getApplicationContext(),newPatients);
        recyclerView.setLayoutManager(new LinearLayoutManager(MyAppointmentActivity.this));
        recyclerView.setAdapter(patientAdapter);
        buttonNewAppointment.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                buttonNewAppointment.setBackground(getResources().getDrawable(R.drawable.round_left_corners));
                // buttonNewAppointment.setBackground(getResources().getDrawable(R.drawable.round_left_corners));
                buttonOldAppointment.setBackground(getResources().getDrawable(R.drawable.round_right_corners));

                PatientAdapter patientAdapter = new PatientAdapter(getApplicationContext(),newPatients);
                recyclerView.setLayoutManager(new LinearLayoutManager(MyAppointmentActivity.this));
                recyclerView.setAdapter(patientAdapter);

            }
        });

        buttonOldAppointment.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {

                buttonNewAppointment.setBackground(getResources().getDrawable(R.drawable.round_old_right_corners));
                // buttonNewAppointment.setBackground(getResources().getDrawable(R.drawable.round_left_corners));
                buttonOldAppointment.setBackground(getResources().getDrawable(R.drawable.round_old_left_corners));


                PatientAdapter patientAdapter = new PatientAdapter(getApplicationContext(),oldPatients);
                recyclerView.setLayoutManager(new LinearLayoutManager(MyAppointmentActivity.this));
                recyclerView.setAdapter(patientAdapter);



            }
        });

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.my_appointment));

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                onBackPressed();
                return true;
            }
        }
        return onOptionsItemSelected(item);
    }
}

