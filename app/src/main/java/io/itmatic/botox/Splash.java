package io.itmatic.botox;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import io.itmatic.botox.Common.BaseActivity;
import io.itmatic.botox.Model.Patient;
import io.itmatic.botox.Model.Provider;
import io.itmatic.botox.Provider.MyAppointmentActivity;
import io.itmatic.botox.Provider.ProviderProfileActivity;
import io.itmatic.botox.Provider.QualificationsActivity;
import io.itmatic.botox.Provider.UploadDocumentFirstActivity;
import io.itmatic.botox.Retrofit.Helper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Splash extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread thread = new Thread() {
            public void run() {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {

                    SharedPreferences preferences = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
                 //   String ProviderToken = preferences.getString("provider_token", "");
                    if (!preferences.contains("provider_token")) {

                        if (!preferences.contains("patient_token")) {
                            Intent intent = new Intent(Splash.this, BotoxActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                            finish();
                        } else {
                            String patientToken = preferences.getString("patient_token", "");
                            getPatientProfile(patientToken);

                        }
                    } else {
                        String providerToken = preferences.getString("provider_token", "");
                       getProviderProfile(providerToken);
                    }


                }
            }
        };
        thread.start();
    }

    private void getProviderProfile(String token)
    {
        Call<Provider> call = Helper.getBotoxApiService().providerProfile(token);
        call.enqueue(new Callback<Provider>() {


            @Override
            public void onResponse(Call<Provider> call, Response<Provider> response) {
                int statusCode = response.code();
                if (statusCode == 200) {

                    ((BotoxApplication)getApplication()).setProvider(response.body());
                    Intent intent = new Intent(Splash.this,ProviderProfileActivity.class);
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
            public void onFailure(Call<Provider> call, Throwable t) {

            }


        });
    }

    private void getPatientProfile(String token)
    {
        Call<Patient> call = Helper.getBotoxApiService().patientProfile(token);
        call.enqueue(new Callback<Patient>() {


            @Override
            public void onResponse(Call<Patient> call, Response<Patient> response) {
                int statusCode = response.code();
                if (statusCode == 200) {

                    ((BotoxApplication)getApplication()).setPatient(response.body());
                    Intent intent = new Intent(Splash.this, BotoxActivity.class);
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

            }


        });
    }
}
