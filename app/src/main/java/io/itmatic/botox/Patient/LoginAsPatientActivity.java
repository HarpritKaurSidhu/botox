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
import io.itmatic.botox.Common.BaseActivity;
import io.itmatic.botox.Common.Resource;
import io.itmatic.botox.ForgotPasswordActivity;
import io.itmatic.botox.R;
import io.itmatic.botox.Retrofit.Helper;
import io.itmatic.botox.Model.Patient;
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
    private AwesomeValidation mAwesomeValidation=new AwesomeValidation(BASIC);


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
                    Resource.patient = response.body();

                    Resource.patientToken = Resource.patient.getAccessToken();

                    addPatientTokenInSharedPreferences(Resource.patientToken);


                } else {
                    JSONObject error = null;
                    String message = "";
                    try {
                        error = new JSONObject(response.errorBody().string());
                        message = error.getString("message");

                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    showError(message);


                }


                // addInSharedPrefrences(user.getAccess_token(), user.getName(), user.getEmail(), user.getDp(), user.getCover());


            }

            @Override
            public void onFailure(Call<Patient> call, Throwable t) {
                t.toString();
                dialog.dismiss();
            }


        });
    }

    public void checkValidity() {
        mAwesomeValidation.addValidation(this, R.id.edt_email, Patterns.EMAIL_ADDRESS, R.string.enter_valid_email);
        mAwesomeValidation.addValidation(this, R.id.edt_password, "[0-9a-zA-Z]+",R.string.enter_valid_password);



    }


}
