package io.itmatic.botox.Provider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.itmatic.botox.Adapter.PatientAdapter;
import io.itmatic.botox.Model.Patient;
import io.itmatic.botox.R;

public class MyAppointmentActivity extends AppCompatActivity {
    @BindView(R.id.recycle_view)
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_appointment);
        ButterKnife.bind(this);
        ArrayList<Patient> patients=new ArrayList<>();
        for(int i=0;i<5;i++)
        {
            Patient patient=new Patient();
            patient.setFullName("name"+" "+i);
            patient.setDob(new Date().toString());
            patients.add(patient);
        }
        PatientAdapter patientAdapter=new PatientAdapter(this,patients);
        GridLayoutManager mLayoutManager = new GridLayoutManager(MyAppointmentActivity.this, 1);
        mLayoutManager.getPaddingLeft();
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(patientAdapter);




    }
}
