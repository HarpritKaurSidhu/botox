package io.itmatic.botox;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.basgeekball.awesomevalidation.AwesomeValidation;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.itmatic.botox.Common.BaseActivity;
import io.itmatic.botox.Retrofit.Helper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.basgeekball.awesomevalidation.ValidationStyle.BASIC;

public class ForgotPasswordActivity extends BaseActivity {


    @BindView(R.id.edt_email)
    EditText email;
    @BindView(R.id.btn_send)
    Button send;
    private AwesomeValidation mAwesomeValidation=new AwesomeValidation(BASIC);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.forgot_password));
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checkValidity();
                if (mAwesomeValidation.validate()) {
                    resetPassword();
                } else {

                }
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

    public void checkValidity() {


        mAwesomeValidation.addValidation(this, R.id.edt_email, Patterns.EMAIL_ADDRESS, R.string.enter_valid_email);



    }


    public void resetPassword() {

        final ProgressDialog dialog = ShowConstantProgressNOTCAN(this, "", getResources().getString(R.string.processing));
        dialog.show();

        String mail = email.getText().toString();


        Call<String> call = Helper.getBotoxApiService().resetProviderPassword(mail);
        call.enqueue(new Callback<String>() {


            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                dialog.dismiss();
                int statusCode = response.code();
                if (statusCode == 200) {
                    showMessage(response.body());


                } else {

                    JSONObject error= null;
                    String message="";
                    try {
                        error = new JSONObject(response.errorBody().string());
                        message=error.getString("message");

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
            public void onFailure(Call<String> call, Throwable t) {
                t.toString();
                dialog.dismiss();
            }


        });
    }

}


