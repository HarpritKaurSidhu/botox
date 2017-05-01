package io.itmatic.botox.Provider;

import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.itmatic.botox.Common.BaseActivity;
import io.itmatic.botox.Model.Provider;
import io.itmatic.botox.R;
import io.itmatic.botox.Retrofit.Helper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScheduleActivity extends BaseActivity {
    Calendar calendar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.lout_tue)
    LinearLayout linearLayoutTue;
    @BindView(R.id.lout_mon)
    LinearLayout linearLayoutMon;
    @BindView(R.id.lout_wed)
    LinearLayout linearLayoutWed;
    @BindView(R.id.lout_thu)
    LinearLayout linearLayoutThu;
    @BindView(R.id.lout_fri)
    LinearLayout linearLayoutFri;
    @BindView(R.id.lout_sat)
    LinearLayout linearLayoutSat;
    @BindView(R.id.lout_sun)
    LinearLayout linearLayoutSun;
    @BindView(R.id.sw_mon)
    Switch switchMon;
    @BindView(R.id.sw_tue)
    Switch switchTue;
    @BindView(R.id.sw_wed)
    Switch switchWed;
    @BindView(R.id.sw_thu)
    Switch switchThu;
    @BindView(R.id.sw_fri)
    Switch switchFri;
    @BindView(R.id.sw_sat)
    Switch switchSat;
    @BindView(R.id.sw_sun)
    Switch switchSun;
    @BindView(R.id.txt_set_time_from_mon)
    TextView textViewSetTimeFromMon;
    @BindView(R.id.txt_set_time_to_mon)
    TextView getTextViewSetTimeToMon;
    @BindView(R.id.txt_set_time_from_tue)
    TextView textViewSetTimeFromTue;
    @BindView(R.id.txt_set_time_to_tue)
    TextView getTextViewSetTimeToTue;
    @BindView(R.id.txt_set_time_from_wed)
    TextView textViewSetTimeFromWed;
    @BindView(R.id.txt_set_time_to_wed)
    TextView getTextViewSetTimeToWed;
    @BindView(R.id.txt_set_time_from_thu)
    TextView textViewSetTimeFromThu;
    @BindView(R.id.txt_set_time_to_thu)
    TextView getTextViewSetTimeToThu;
    @BindView(R.id.txt_set_time_from_fri)
    TextView textViewSetTimeFromFri;
    @BindView(R.id.txt_set_time_to_fri)
    TextView getTextViewSetTimeToFri;
    @BindView(R.id.txt_set_time_from_sat)
    TextView textViewSetTimeFromSat;
    @BindView(R.id.txt_set_time_to_sat)
    TextView getTextViewSetTimeToSat;
    @BindView(R.id.txt_set_time_from_sun)
    TextView textViewSetTimeFromSun;
    @BindView(R.id.txt_set_time_to_sun)
    TextView getTextViewSetTimeToSun;
    @BindView(R.id.btn_submit)
    Button buttonSumbit;
    //  ArrayList<WorkingTime> workingTimes=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.schedule));
      /*  if(workingTimes.size()==0)
        {
            for(int i=0;i<7;i++)
            {
                workingTimes.add(i,null);
            }
        }*/


        switchMon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    linearLayoutMon.setVisibility(View.VISIBLE);

                   /* timePicker.setIs24HourView(true);
                    textViewSettimeFrom.setText(getCurrentTime());

                    buttonChangeTime.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            textViewSettimeFrom.setText(getCurrentTime());
                        }
                    });
                }
            }public String getCurrentTime() {
                        String currentTime = "Current Time: " + timePicker.getCurrentHour() + ":" + timePicker.getCurrentMinute();
                        return currentTime;
                   */
                }
            }
        });


        buttonSumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                JSONArray jsonArray = new JSONArray();

                String fromMon = timeFormatChange(textViewSetTimeFromMon.getText().toString());
                String toMon = timeFormatChange(textViewSetTimeFromMon.getText().toString());
                if (fromMon != null && !fromMon.equals("") && toMon != null && !toMon.equals("")) {
                    JSONObject time = new JSONObject();
                    try {
                        time.put("from", fromMon);

                        time.put("to", toMon);
                        time.put("day", 1);

                        jsonArray.put(time);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                String fromTue = timeFormatChange(textViewSetTimeFromTue.getText().toString());
                String toTue = timeFormatChange(textViewSetTimeFromTue.getText().toString());
                if (fromTue != null && !fromTue.equals("") && toTue != null && !toTue.equals("")) {
                    JSONObject time = new JSONObject();
                    try {
                        time.put("from", fromTue);

                        time.put("to", toTue);
                        time.put("day", 2);

                        jsonArray.put(time);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                String fromWed = timeFormatChange(textViewSetTimeFromWed.getText().toString());
                String toWed = timeFormatChange(textViewSetTimeFromWed.getText().toString());
                if (fromWed != null && !fromWed.equals("") && toWed != null && !toWed.equals("")) {
                    JSONObject time = new JSONObject();
                    try {
                        time.put("from", fromWed);

                        time.put("to", toWed);
                        time.put("day", 3);

                        jsonArray.put(time);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                String fromThu = timeFormatChange(textViewSetTimeFromThu.getText().toString());
                String toThu = timeFormatChange(textViewSetTimeFromThu.getText().toString());
                if (fromThu != null && !fromThu.equals("") && toThu != null && !toThu.equals("")) {
                    JSONObject time = new JSONObject();
                    try {
                        time.put("from", fromThu);

                        time.put("to", toThu);
                        time.put("day", 4);

                        jsonArray.put(time);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                String fromFri = timeFormatChange(textViewSetTimeFromFri.getText().toString());
                String toFri = timeFormatChange(textViewSetTimeFromFri.getText().toString());
                if (fromFri != null && !fromFri.equals("") && toFri != null && !toFri.equals("")) {
                    JSONObject time = new JSONObject();
                    try {
                        time.put("from", fromFri);

                        time.put("to", toFri);
                        time.put("day", 5);

                        jsonArray.put(time);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                String fromSat = timeFormatChange(textViewSetTimeFromSat.getText().toString());
                String toSat = timeFormatChange(textViewSetTimeFromSat.getText().toString());
                if (fromSat != null && !fromSat.equals("") && toSat != null && !toSat.equals("")) {
                    JSONObject time = new JSONObject();
                    try {
                        time.put("from", fromSat);

                        time.put("to", toSat);
                        time.put("day", 6);

                        jsonArray.put(time);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                String fromSun = timeFormatChange(textViewSetTimeFromSun.getText().toString());
                String toSun = timeFormatChange(textViewSetTimeFromSun.getText().toString());

                if (fromSun != null && !fromSun.equals("") && toSun != null && !toSun.equals("")) {
                    JSONObject time = new JSONObject();
                    try {
                        time.put("from", fromSun);

                        time.put("to", toSun);
                        time.put("day", 0);

                        jsonArray.put(time);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                jsonArray.toString();
                setWorkingTime(jsonArray.toString());


            }
        });

        textViewSetTimeFromMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                setTime(textViewSetTimeFromMon, 1, "from");


            }
        });
        getTextViewSetTimeToMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTime(getTextViewSetTimeToMon, 1, "to");
            }
        });


        switchTue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()

        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    linearLayoutTue.setVisibility(View.VISIBLE);
                } else {
                    linearLayoutTue.setVisibility(View.GONE);
                }
            }
        });
        textViewSetTimeFromTue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                setTime(textViewSetTimeFromTue, 2, "from");

            }
        });
        getTextViewSetTimeToTue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTime(getTextViewSetTimeToTue, 2, "to");
            }
        });


        switchWed.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()

        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    linearLayoutWed.setVisibility(View.VISIBLE);
                } else {
                    linearLayoutWed.setVisibility(View.GONE);
                }
            }
        });
        textViewSetTimeFromWed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                setTime(textViewSetTimeFromWed, 3, "from");

            }
        });
        getTextViewSetTimeToWed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTime(getTextViewSetTimeToWed, 3, "to");
            }
        });


        switchThu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()

        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    linearLayoutThu.setVisibility(View.VISIBLE);
                } else {
                    linearLayoutThu.setVisibility(View.GONE);
                }
            }
        });
        textViewSetTimeFromThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                setTime(textViewSetTimeFromThu, 4, "from");

            }
        });
        getTextViewSetTimeToThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTime(getTextViewSetTimeToThu, 4, "to");
            }
        });


        switchFri.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()

        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    linearLayoutFri.setVisibility(View.VISIBLE);
                } else {
                    linearLayoutFri.setVisibility(View.GONE);
                }
            }
        });
        textViewSetTimeFromFri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                setTime(textViewSetTimeFromFri, 5, "from");

            }
        });
        getTextViewSetTimeToFri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTime(getTextViewSetTimeToFri, 5, "to");
            }
        });


        switchSat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()

        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    linearLayoutSat.setVisibility(View.VISIBLE);
                } else {
                    linearLayoutSat.setVisibility(View.GONE);
                }
            }
        });
        textViewSetTimeFromSat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                setTime(textViewSetTimeFromSat, 6, "from");

            }
        });
        getTextViewSetTimeToSat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTime(getTextViewSetTimeToSat, 6, "to");
            }
        });


        switchSun.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()

        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    linearLayoutSun.setVisibility(View.VISIBLE);
                } else {
                    linearLayoutSun.setVisibility(View.GONE);
                }
            }
        });
        textViewSetTimeFromSun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                setTime(textViewSetTimeFromSun, 0, "from");

            }
        });
        getTextViewSetTimeToSun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTime(getTextViewSetTimeToSun, 0, "to");
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

    private void setTime(final TextView textView, final int day, final String fromTo) {

        Calendar currentTime = Calendar.getInstance();
        int hour = currentTime.get(Calendar.HOUR_OF_DAY);
        int minute = currentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker = new TimePickerDialog(ScheduleActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                String time24 = "AM";


                if (selectedHour > 12) {
                    time24 = "PM";
                    selectedHour = selectedHour - 12;
                } else if (selectedHour == 12) {
                    time24 = "PM";
                }
                if (selectedMinute < 10) {
                    textView.setText(selectedHour + ":" + "0" + selectedMinute + " " + time24);
                } else {
                    textView.setText(selectedHour + ":" + selectedMinute + " " + time24);
                }

            }
        }, hour, minute, false);//Yes 24 hour time
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();
    }

    public String timeFormatChange(String time) {
        SimpleDateFormat date12Format = new SimpleDateFormat("hh:mm a");

        SimpleDateFormat date24Format = new SimpleDateFormat("HH:mm");

        String changedTime = null;
        try {
            changedTime = date24Format.format(date12Format.parse(time));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return changedTime;
    }


    private void setWorkingTime(String schedule) {
        final ProgressDialog dialog = ShowConstantProgressNOTCAN(this, "", getResources().getString(R.string.processing));
        dialog.show();


        SharedPreferences preferences = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
        String token = preferences.getString("provider_token", "");
        Call<Provider> call = Helper.getBotoxApiService().setWorkingTime(token, schedule);
        call.enqueue(new Callback<Provider>() {


            @Override
            public void onResponse(Call<Provider> call, Response<Provider> response) {
                dialog.dismiss();
                int statusCode = response.code();
                if (statusCode == 200) {

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
                dialog.dismiss();
            }


        });
    }


}