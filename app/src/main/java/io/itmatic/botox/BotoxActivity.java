package io.itmatic.botox;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.itmatic.botox.Patient.LoginAsPatientActivity;
import io.itmatic.botox.Provider.MyAppointmentActivity;
import io.itmatic.botox.Provider.ProviderLoginActivity;

public class BotoxActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.txt_provider)
    TextView textViewProvider;
    @BindView(R.id.txt_login)
    TextView textViewLogin;
    @BindView(R.id.btn_my_appointments)
    Button buttonMyAppoinments;
    @BindView(R.id.btn_book_an_appointment)
    Button buttonBookAnAppointment;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botox__app);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.botox_App));
        preferences = getSharedPreferences(getPackageName(), MODE_PRIVATE);

        buttonMyAppoinments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (preferences.contains("patient_token")) {
                    Intent intent = new Intent(BotoxActivity.this, MyAppointmentActivity.class);
                    startActivity(intent);

                } else {
                    Intent intent = new Intent(BotoxActivity.this, LoginAsPatientActivity.class);
                    startActivity(intent);
                }


            }
        });

        buttonBookAnAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(BotoxActivity.this, PostcodeActivity.class);
                startActivity(intent);


            }
        });

        textViewProvider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(BotoxActivity.this,ProviderLoginActivity.class);
                startActivity(intent);



            }
        });

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
