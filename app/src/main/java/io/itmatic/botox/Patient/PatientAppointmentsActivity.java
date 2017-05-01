package io.itmatic.botox.Patient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import io.itmatic.botox.Model.Provider;
import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.itmatic.botox.Adapter.ProviderAdapter;
import io.itmatic.botox.Model.Provider;
import io.itmatic.botox.Patient.PatientAppointmentsActivity;

import io.itmatic.botox.R;

public class PatientAppointmentsActivity extends AppCompatActivity {
    @BindView(R.id.rv_patient_appointment)
    RecyclerView recyclerViewPatientAppiontment;
    /* @BindView(R.id.txt_provider_name)
     TextView textViewProviderName;
    */ @BindView(R.id.toolbar)
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_appointments);
        ButterKnife.bind(this);
        ArrayList<Provider> providers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Provider provider = new Provider();
            provider.setFullName("name" + " " + i);
            provider.setDob(new Date().toString());
            providers.add(provider);
        }
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.patient_appointments));
        ProviderAdapter providerAdapter = new ProviderAdapter(this,providers);
        recyclerViewPatientAppiontment.setLayoutManager(new LinearLayoutManager(PatientAppointmentsActivity.this));
        recyclerViewPatientAppiontment.setAdapter(providerAdapter);
        recyclerViewPatientAppiontment.setLayoutManager(new LinearLayoutManager(PatientAppointmentsActivity.this));
        recyclerViewPatientAppiontment.setAdapter(providerAdapter);
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

