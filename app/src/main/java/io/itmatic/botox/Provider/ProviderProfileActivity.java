package io.itmatic.botox.Provider;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.itmatic.botox.BotoxActivity;
import io.itmatic.botox.BotoxApplication;
import io.itmatic.botox.Patient.LoginAsPatientActivity;
import io.itmatic.botox.Patient.MedicalHistoryActivity;
import io.itmatic.botox.Patient.SignUpAsPatient;
import io.itmatic.botox.PostcodeActivity;
import io.itmatic.botox.R;

public class ProviderProfileActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;;
    @BindView(R.id.img_user)
    ImageView imageUser;
    @BindView(R.id.txt_unchecked)
    TextView textViewUnchecked;
    @BindView(R.id.txt_checked)
    TextView textViewChecked;
    @BindView(R.id.txt_provider_name)
    TextView textViewProviderName;
    @BindView(R.id.btn_consultation)
    Button buttonConsultation;
    @BindView(R.id.txt_patients_in_month)
    TextView textViewPatientInMonth;
    @BindView(R.id.txt_all_patients_value)
    TextView  textViewAllPatients;
    @BindView(R.id.qualification)
    TextView textViewQualifications;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_profile);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.provider_profile));
        textViewProviderName.setText(BotoxApplication.selectedProvider.getFullName());
        Glide.with(ProviderProfileActivity.this).load((BotoxApplication.selectedProvider.getImageUrl())).placeholder(R.drawable.ic_dummy_user).dontAnimate().into(imageUser);
        if(BotoxApplication.selectedProvider.isDrivingLicence()){
            textViewChecked.setVisibility(View.VISIBLE);
            textViewUnchecked.setVisibility(View.GONE);
        }else {
            textViewUnchecked.setVisibility(View.VISIBLE);
            textViewChecked.setVisibility(View.GONE);
        }

        String qualification = BotoxApplication.selectedProvider.getInfo().getQualification();


        // String  qualification=BotoxApplication.selectedProvider.getQualification();


        textViewQualifications.setText(qualification);

        buttonConsultation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences preferences = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);

                if(preferences.contains("patient_token")) {
                    Intent intent = new Intent(ProviderProfileActivity.this,MedicalHistoryActivity.class);
                    startActivity(intent);
                }else
                {
                    Intent intent = new Intent(ProviderProfileActivity.this,SignUpAsPatient.class);
                    startActivity(intent);
                }
            }
        });

      //  textViewChecked.setText((BotoxApplication.selectedProvider.);
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

