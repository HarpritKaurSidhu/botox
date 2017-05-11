package io.itmatic.botox.Patient;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.itmatic.botox.Adapter.QualificationAdapter;
import io.itmatic.botox.Adapter.QuestionAdapter;
import io.itmatic.botox.BotoxApplication;
import io.itmatic.botox.Common.BaseActivity;
import io.itmatic.botox.Model.Education;
import io.itmatic.botox.Model.Patient;
import io.itmatic.botox.Model.Question;
import io.itmatic.botox.Provider.QualificationsActivity;
import io.itmatic.botox.R;
import io.itmatic.botox.Retrofit.Helper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MedicalHistoryActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rv_question)
    RecyclerView recyclerView;
    @BindView(R.id.btn_submit)
    Button buttonSubmit;
    private List<Question> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_history);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.medical_history));
        getQuestions(((BotoxApplication) getApplication()).getPatient().getAccessToken());

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                JSONArray jsonArray=new JSONArray();


                for(int i=0;i<questions.size();i++)
                {
                    Question question=questions.get(i);
                    if(!question.isYes() && !question.isNo())
                    {
                        buildDialog(R.style.DialogTheme,getResources().getString(R.string.give_the_answer));
                        return;
                    }else
                    {
                        JSONObject jsonObject=new JSONObject();
                        try {
                            jsonObject.put("id",question.getId());
                            String answer;
                            if(question.isNo())
                            {
                                answer="No";
                            }else
                            {
                                answer="Yes";
                            }
                            jsonObject.put("answer",answer);
                            jsonArray.put(jsonObject);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }

               createAnAppointment(jsonArray.toString());


            }
        });
    }





    private void getQuestions(String token) {

        final ProgressDialog dialog = ShowConstantProgressNOTCAN(this, "", getResources().getString(R.string.processing));
        dialog.show();
        Call<ArrayList<Question>> call = Helper.getBotoxApiService().questionList(token);

        call.enqueue(new Callback<ArrayList<Question>>() {
            @Override
            public void onResponse(Call<ArrayList<Question>> call, Response<ArrayList<Question>> response) {

                dialog.dismiss();
                int statusCode = response.code();
                if (statusCode == 200) {

                    questions=response.body();
                    QuestionAdapter questionAdapter = new QuestionAdapter(response.body());
                    GridLayoutManager mLayoutManager = new GridLayoutManager(MedicalHistoryActivity.this, 1);
                    mLayoutManager.getPaddingLeft();
                    recyclerView.setLayoutManager(mLayoutManager);
                    recyclerView.setAdapter(questionAdapter);


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
            public void onFailure(Call<ArrayList<Question>> call, Throwable t) {

                dialog.dismiss();
            }


        });
    }

    private void createAnAppointment(String medicalHistory)
    {

        final ProgressDialog dialog = ShowConstantProgressNOTCAN(this, "", getResources().getString(R.string.sign_in));
        dialog.show();


           int selectedProviderId=BotoxApplication.selectedProvider.getId();
           String time=((BotoxApplication) getApplication()).getTime();
           String date=((BotoxApplication) getApplication()).getDate();
           String area=((BotoxApplication) getApplication()).getSelectedArea();

           String token=((BotoxApplication) getApplication()).getPatientToken();
        Call<Patient> call = Helper.getBotoxApiService().createAppointment(selectedProviderId,date,time,area,medicalHistory,token);
        call.enqueue(new Callback<Patient>() {


            @Override
            public void onResponse(Call<Patient> call, Response<Patient> response) {
                dialog.dismiss();
                int statusCode = response.code();
                if (statusCode == 200) {
                    ((BotoxApplication)getApplication()).setPatient(response.body());

                    addPatientTokenInSharedPreferences(((BotoxApplication)getApplication()).getPatientToken());
                   Intent intent = new Intent(MedicalHistoryActivity.this,ConfirmBookingActivity.class);
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

}
