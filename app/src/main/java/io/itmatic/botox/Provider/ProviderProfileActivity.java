package io.itmatic.botox.Provider;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.itmatic.botox.BotoxActivity;
import io.itmatic.botox.BotoxApplication;
import io.itmatic.botox.Common.BaseActivity;
import io.itmatic.botox.Common.Resource;
import io.itmatic.botox.Model.Patient;
import io.itmatic.botox.Model.Provider;
import io.itmatic.botox.R;
import io.itmatic.botox.Retrofit.Helper;
import io.itmatic.botox.Splash;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProviderProfileActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.img_user)
    ImageView userImage;
    @BindView(R.id.txt_name)
    TextView userName;
    @BindView(R.id.btn_schedule)
    Button   buttonSchedule;
    @BindView(R.id.btn_my_appoinments)
    Button buttonMyAppointment;
    @BindView(R.id.btn_my_payments)
    Button buttonMyPayment;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.profile));
       getProviderProfile(((BotoxApplication)getApplication()).getProvider().getAccessToken());







        buttonSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(ProviderProfileActivity.this,ScheduleActivity.class);
                startActivity(intent);
            }
        });
        buttonMyAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ProviderProfileActivity.this,MyAppointmentActivity.class);
                startActivity(intent);
            }
        });




    } @Override
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


    private void getProviderProfile(String token)
    {
        Call<Provider> call = Helper.getBotoxApiService().providerProfile(token);
        call.enqueue(new Callback<Provider>() {


            @Override
            public void onResponse(Call<Provider> call, Response<Provider> response) {
                int statusCode = response.code();
                if (statusCode == 200) {
                    ((BotoxApplication)getApplication()).setProvider(response.body());
                    userName.setText(((BotoxApplication)getApplication()).getProvider().getFullName());
                    Glide.with(ProviderProfileActivity.this).load(((BotoxApplication)getApplication()).getProvider().getImage_url()).placeholder(R.drawable.ic_dummy_user).dontAnimate().into(userImage);



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
}
