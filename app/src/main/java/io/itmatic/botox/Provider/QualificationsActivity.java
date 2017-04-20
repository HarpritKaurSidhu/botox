package io.itmatic.botox.Provider;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.itmatic.botox.Adapter.Qualification;
import io.itmatic.botox.Common.BaseActivity;
import io.itmatic.botox.Model.Education;
import io.itmatic.botox.Model.Provider;
import io.itmatic.botox.R;
import io.itmatic.botox.Retrofit.Helper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QualificationsActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.btn_next)
    Button button;
    @BindView(R.id.recycle_view)
    RecyclerView listQuailification;
    @BindView(R.id.edt_other)
    EditText other;
    ArrayList<Education> educations = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qualifications);
        ButterKnife.bind(this);
        getQualification();

        /*ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice,conts_list);
        my_contacts_list.setAdapter(adapter);*/


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean check = false;
                String courses = "";

                for (int i = 0; i < educations.size(); i++) {
                    if (educations.get(i).isSelectCourse() != true) {

                    } else {
                        check = true;
                        courses = courses + educations.get(i).getTitle() + ",";
                    }
                }

                if (other.getText().toString() != null && !other.getText().toString().equals("")) {
                    if (check) {
                        courses = courses + "," + other.getText().toString();
                        uploadQualification(courses);

                    } else {
                        courses = other.getText().toString();
                        uploadQualification(courses);
                    }
                } else {
                    if (check) {
                        uploadQualification(courses);

                    } else {
                        buildDialog(R.style.DialogTheme, getResources().getString(R.string.you_did_not_specify));
                    }

                }


              /*  Intent intent = new Intent(QualificationsActivity.this, UploadsDocumentsActivity.class);
                startActivity(intent);*/
            }
        });
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.qualification));
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

    protected void getQualification() {

        final ProgressDialog dialog = ShowConstantProgressNOTCAN(this, "", getResources().getString(R.string.processing));
        dialog.show();
        Call<ArrayList<Education>> call = Helper.getBotoxApiService().qualificationList();

        call.enqueue(new Callback<ArrayList<Education>>() {
            @Override
            public void onResponse(Call<ArrayList<Education>> call, Response<ArrayList<Education>> response) {

                dialog.dismiss();
                int statusCode = response.code();
                if (statusCode == 200) {

                    educations = response.body();

                    Qualification qualificationAdapter = new Qualification(educations);
                    GridLayoutManager mLayoutManager = new GridLayoutManager(QualificationsActivity.this, 1);
                    mLayoutManager.getPaddingLeft();
                    listQuailification.setLayoutManager(mLayoutManager);
                    listQuailification.setAdapter(qualificationAdapter);


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


            }

            @Override
            public void onFailure(Call<ArrayList<Education>> call, Throwable t) {
                t.toString();
                dialog.dismiss();
            }


        });
    }


    private void uploadQualification(String cousers) {
        final ProgressDialog dialog = ShowConstantProgressNOTCAN(this, "", getResources().getString(R.string.processing));
        dialog.show();


        SharedPreferences preferences = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
        String token = preferences.getString("token", "");
        Call<Provider> call = Helper.getBotoxApiService().setQualification(token, cousers);
        call.enqueue(new Callback<Provider>() {


            @Override
            public void onResponse(Call<Provider> call, Response<Provider> response) {
                dialog.dismiss();
                int statusCode = response.code();
                if (statusCode == 200) {


                    Intent intent = new Intent(QualificationsActivity.this, UploadsDocumentsActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();

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

            }

            @Override
            public void onFailure(Call<Provider> call, Throwable t) {
                t.toString();
                dialog.dismiss();
            }


        });
    }
}