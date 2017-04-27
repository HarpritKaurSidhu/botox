package io.itmatic.botox.Provider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.itmatic.botox.Adapter.PatientAdapter;
import io.itmatic.botox.Model.Patient;
import io.itmatic.botox.R;

public class MyAppointmentActivity extends AppCompatActivity {
    @BindView(R.id.rv_new_appointment)
    RecyclerView recyclerViewNew;
    @BindView(R.id.rv_old_appointment)
    RecyclerView recyclerViewOld;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_appointment);
        ButterKnife.bind(this);
        ArrayList<Patient> patients = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Patient patient = new Patient();
            patient.setFullName("name" + " " + i);
            patient.setDob(new Date().toString());
            patients.add(patient);
        }
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.my_appointment));
        PatientAdapter patientAdapter = new PatientAdapter(this, patients);
        recyclerViewNew.setLayoutManager(new LinearLayoutManager(MyAppointmentActivity.this));
        recyclerViewNew.setAdapter(patientAdapter);
        recyclerViewOld.setLayoutManager(new LinearLayoutManager(MyAppointmentActivity.this));
        recyclerViewOld.setAdapter(patientAdapter);
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

