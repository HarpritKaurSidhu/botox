package io.itmatic.botox.Provider;

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
import io.itmatic.botox.Model.Provider;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.basgeekball.awesomevalidation.ValidationStyle.BASIC;

public class ProviderLoginActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.btn_login)
    Button loginButton;
    @BindView(R.id.btn_register)
    Button registerButton;
    @BindView(R.id.txt_forget_password)
    TextView forgetPassword;
    @BindView(R.id.edt_email)
    EditText email;
    @BindView(R.id.edt_password)
    EditText password;
    private AwesomeValidation mAwesomeValidation=new AwesomeValidation(BASIC);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.provider));

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               checkValidity();
                if(mAwesomeValidation.validate())
                {
                      loginProvider();
                }

            }
        });
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ProviderLoginActivity.this,SignUpAsDoctorActivity.class);
                startActivity(intent);
            }
        });

        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ProviderLoginActivity.this,ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });

    }

    private void checkValidity() {
        mAwesomeValidation.addValidation(this, R.id.edt_email, Patterns.EMAIL_ADDRESS, R.string.enter_valid_email);
        mAwesomeValidation.addValidation(this, R.id.edt_password, "[0-9a-zA-Z]+",R.string.enter_valid_password);

    }

    private void loginProvider() {
        final ProgressDialog dialog = ShowConstantProgressNOTCAN(this, "", getResources().getString(R.string.sign_in));
        dialog.show();

        String mail = email.getText().toString();
        String pass = password.getText().toString();

        Call<Provider> call = Helper.getBotoxApiService().loginProvider(mail, pass);
        call.enqueue(new Callback<Provider>() {


            @Override
            public void onResponse(Call<Provider> call, Response<Provider> response) {
                dialog.dismiss();
                int statusCode = response.code();
                if (statusCode==200) {
                    Resource.provider = response.body();

                    Resource.providerToken = Resource.provider.getAccessToken();

                    addProviderTokenInSharedPreferences(Resource.providerToken);

                    Intent intent = new Intent(ProviderLoginActivity.this, ProviderProfileActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();

                }else {
                    JSONObject error;
                    String message="";
                    try {
                        error = new JSONObject(response.errorBody().string());
                        message=error.getString("message");

                    } catch (JSONException | IOException e) {
                        e.printStackTrace();
                    }

                    showError(message);



                }






            }

            @Override
            public void onFailure(Call<Provider> call, Throwable t) {
                dialog.dismiss();
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