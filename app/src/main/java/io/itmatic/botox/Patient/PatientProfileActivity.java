package io.itmatic.botox.Patient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.itmatic.botox.BotoxApplication;
import io.itmatic.botox.Common.BaseActivity;
import io.itmatic.botox.R;

public class PatientProfileActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.edt_name)
    EditText editTextName;
    @BindView(R.id.edt_address)
    EditText editTextAddress;
    @BindView(R.id.edt_email)
    EditText editTextEmail;
    @BindView(R.id.edt_phone)
    EditText editTextPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_profile);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.patient_profile));
        editTextName.setText(((BotoxApplication) getApplication()).getPatient().getFullName());
        editTextAddress.setText(((BotoxApplication) getApplication()).getPatient().getAddress());


    }
}
