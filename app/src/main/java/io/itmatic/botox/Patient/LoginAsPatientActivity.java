package io.itmatic.botox.Patient;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.basgeekball.awesomevalidation.AwesomeValidation;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.itmatic.botox.BotoxActivity;
import io.itmatic.botox.BotoxApplication;
import io.itmatic.botox.Common.BaseActivity;

import io.itmatic.botox.R;
import io.itmatic.botox.Retrofit.Helper;
import io.itmatic.botox.Model.Patient;
import io.itmatic.botox.Splash;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.basgeekball.awesomevalidation.ValidationStyle.BASIC;

public class LoginAsPatientActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.edt_email)
    EditText email;
    @BindView(R.id.edt_password)
    EditText password;
    @BindView(R.id.btn_log_in)
    Button loginButton;
    @BindView(R.id.txt_forget_password)
    TextView forgetPassword;
    private  AwesomeValidation mAwesomeValidation=new AwesomeValidation(BASIC);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_as_patient);
        ButterKnife.bind(this);


        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.login_as_patient));

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*Intent intent=new Intent(LoginAsPatientActivity.this,PatientProfileActivity.class);
                startActivity(intent);
*/
               checkValidity();
                if (mAwesomeValidation.validate()) {
                    loginPatient();
                }
            }
        });

        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(LoginAsPatientActivity.this,SignUpAsPatient.class);
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

    private void loginPatient() {
        final ProgressDialog dialog = ShowConstantProgressNOTCAN(this, "", getResources().getString(R.string.sign_in));
        dialog.show();

        String mail = email.getText().toString();
        String pass = password.getText().toString();

        Call<Patient> call = Helper.getBotoxApiService().loginPatient(mail, pass);
        call.enqueue(new Callback<Patient>() {


            @Override
            public void onResponse(Call<Patient> call, Response<Patient> response) {
                dialog.dismiss();
                int statusCode = response.code();
                if (statusCode == 200) {
                    ((BotoxApplication)getApplication()).setPatient(response.body());

                    addPatientTokenInSharedPreferences(((BotoxApplication)getApplication()).getPatientToken());
                    Intent intent = new Intent(LoginAsPatientActivity.this,PatientProfileActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();

                } else {
                    JSONObject error;
                    String message = "";
                    try {
                        error = new JSONObject(response.errorBody().string());
                        message = error.getString("message");

                    } catch (JSONException | IOException e) {
                        e.printStackTrace();
                    }

                    showError(message);


                }





            }

            @Override
            public void onFailure(Call<Patient> call, Throwable t) {
                dialog.dismiss();
            }


        });
    }

    private void checkValidity() {
        mAwesomeValidation.addValidation(this, R.id.edt_email, Patterns.EMAIL_ADDRESS, R.string.enter_valid_email);
        mAwesomeValidation.addValidation(this, R.id.edt_password, "[0-9a-zA-Z]+",R.string.enter_valid_password);



    }


}
