package io.itmatic.botox;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
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
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.itmatic.botox.Common.BaseActivity;
import io.itmatic.botox.Model.Patient;
import io.itmatic.botox.Model.Provider;
import io.itmatic.botox.Patient.ChooseAreaActivity;
import io.itmatic.botox.Retrofit.Helper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.basgeekball.awesomevalidation.ValidationStyle.BASIC;

public class PostcodeActivity extends BaseActivity {
      @BindView(R.id.toolbar)
      Toolbar toolbar;
      @BindView(R.id.edt_postcode)
      EditText editTextPostCode;
      @BindView(R.id.btn_next)
      Button next;
    private AwesomeValidation mAwesomeValidation=new AwesomeValidation(BASIC);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_your_postcode);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.enter_your_postcode));

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                checkValidity();
                if (mAwesomeValidation.validate()) {
                    setPostCode();
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
            {
                onBackPressed();
                return true;
            }
        }
        return onOptionsItemSelected(item);
    }


    private void checkValidity() {
        mAwesomeValidation.addValidation(this, R.id.edt_postcode, "[0-9a-zA-Z]+",R.string.enter_your_postcode);



    }

    private void setPostCode() {
        final ProgressDialog dialog = ShowConstantProgressNOTCAN(this, "", getResources().getString(R.string.processing));
        dialog.show();

        String postcode = editTextPostCode.getText().toString();
        String token=((BotoxApplication)getApplication()).getPatientToken();
        Call<List<Provider>> call = Helper.getBotoxApiService().setPostCode(postcode,token);
        call.enqueue(new Callback<List<Provider>>() {


            @Override
            public void onResponse(Call<List<Provider>> call, Response<List<Provider>> response) {
                dialog.dismiss();
                int statusCode = response.code();
                if (statusCode == 200) {
                   // ((BotoxApplication)getApplication()).setPatient(response.body());

                    //addPatientTokenInSharedPreferences(((BotoxApplication)getApplication()).getPatientToken());
                    Intent intent = new Intent(PostcodeActivity.this, ChooseAreaActivity.class);
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
            public void onFailure(Call<List<Provider>> call, Throwable t) {

                dialog.dismiss();
            }


        });
    }
    }

