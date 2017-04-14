package io.itmatic.botox;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.itmatic.botox.CommonClasses.BaseActivity;
import io.itmatic.botox.CommonClasses.Resource;
import io.itmatic.botox.Retrofit.Helper;
import io.itmatic.botox.model.Error;
import io.itmatic.botox.model.Provider;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

                String result=checkValidity(email,password);
                if(result.equals("Success"))
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

    public String checkValidity(EditText cemail,EditText cpassword) {



        if ((cemail.getText().toString() == null) || cemail.getText().toString().equals("")) {
            cemail.requestFocus();
            buildDialog(R.style.DialogTheme, getResources().getString(R.string.enter_email));
            return "unsuccess";
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(cemail.getText().toString()).matches()) {
            cemail.requestFocus();
            buildDialog(R.style.DialogTheme, getResources().getString(R.string.enter_valid_email));
            return "unsuccess";
        }

        if ((cpassword.getText().toString() == null) || cpassword.getText().toString().equals("")) {
            cpassword.requestFocus();
            buildDialog(R.style.DialogTheme, getResources().getString(R.string.enter_password));
            return "unsuccess";
        }



        return "Success";
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

                    Resource.providerToken = Resource.provider.getAccess_token();

                    addInSharedPrefrences(Resource.providerToken);

                    Intent intent = new Intent(ProviderLoginActivity.this, ProviderProfileActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();

                }else {
                    JSONObject error= null;
                    String message="";
                    try {
                        error = new JSONObject(response.errorBody().toString());
                        message=error.getString("message");

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    showerror(message);



                }



                // addInSharedPrefrences(user.getAccess_token(), user.getName(), user.getEmail(), user.getDp(), user.getCover());


            }

            @Override
            public void onFailure(Call<Provider> call, Throwable t) {
                t.toString();
                dialog.dismiss();
            }


        });
    }

    private void buildDialog(int animationSource, String type) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Error");
        builder.setMessage(type);
        builder.setNegativeButton("OK", null);
        AlertDialog dialog = builder.create();
        dialog.getWindow().getAttributes().windowAnimations = animationSource;
        dialog.show();
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