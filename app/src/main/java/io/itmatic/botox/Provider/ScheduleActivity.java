package io.itmatic.botox.Provider;

import android.app.Dialog;
import android.app.TimePickerDialog;


import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
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

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.itmatic.botox.Common.BaseActivity;
import io.itmatic.botox.Model.WorkingTime;
import io.itmatic.botox.R;

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
    ArrayList<WorkingTime> workingTimes=new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.schedule));
        if(workingTimes.size()==0)
        {
            for(int i=0;i<7;i++)
            {
                WorkingTime workingTime=new WorkingTime();
                workingTimes.add(workingTime);
            }
        }


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

                JSONArray jsonArray=new JSONArray();

                if(workingTimes.size()==0)
                {
                    buildDialog(R.style.DialogTheme,getResources().getString(R.string.select_you_working_time));
                }else {
                    for(int i=0;i<workingTimes.size();i++)
                    {
                        JSONObject time=new JSONObject();
                        try {
                            time.put("from",workingTimes.get(i).getFromTime());
                            time.put("to",workingTimes.get(i).getToTime());
                            jsonArray.put(i,time);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    jsonArray.toString();

                }
            }
        });

        textViewSetTimeFromMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                setTime(textViewSetTimeFromMon,1,"from");


            }
        }); getTextViewSetTimeToMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTime(getTextViewSetTimeToMon,1,"to");
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


                setTime(textViewSetTimeFromTue,2,"from");

            }
        }); getTextViewSetTimeToTue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTime(getTextViewSetTimeToTue,2,"to");
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


                setTime(textViewSetTimeFromWed,3,"from");

            }
        });
        getTextViewSetTimeToWed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTime(getTextViewSetTimeToWed,3,"to");
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


                setTime(textViewSetTimeFromThu,4,"from");

            }
        });
        getTextViewSetTimeToThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTime(getTextViewSetTimeToThu,4,"to");
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


                setTime(textViewSetTimeFromFri,5,"from");

            }
        });
        getTextViewSetTimeToFri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTime(getTextViewSetTimeToFri,5,"to");
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


                setTime(textViewSetTimeFromSat,6,"from");

            }
        });
        getTextViewSetTimeToSat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTime(getTextViewSetTimeToSat,6,"to");
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


                setTime(textViewSetTimeFromSun,0,"from");

            }
        });
        getTextViewSetTimeToSun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTime(getTextViewSetTimeToSun,0,"to");
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

    private void setTime(final TextView textView,final int day,final String fromTo) {

        Calendar currentTime = Calendar.getInstance();
        int hour = currentTime.get(Calendar.HOUR_OF_DAY);
        int minute = currentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker = new TimePickerDialog(ScheduleActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                String time24="AM";

                WorkingTime workingTime=workingTimes.get(day);
                if(workingTime!=null)
                {
                    if(fromTo.equals("from"))
                    {
                        workingTime.setFromTime(selectedHour+":"+selectedMinute);
                    }else if(fromTo.equals("to"))
                    {
                        workingTime.setToTime(selectedHour+":"+selectedMinute);
                    }
                }else
                {
                    workingTime=new WorkingTime();
                    if(fromTo.equals("from"))
                    {
                        workingTime.setFromTime(selectedHour+":"+selectedMinute);
                    }else if(fromTo.equals("to"))
                    {
                        workingTime.setToTime(selectedHour+":"+selectedMinute);
                    }

                }
                workingTimes.add(day,workingTime);

               /* String weekDay="";
               switch (day)
               {
                   case 0:  weekDay = "sunday";
                       break;
                   case 1:  weekDay="monday";
                       break;
                   case 2:  weekDay="tuesday";
                       break;
                   case 3: weekDay="wednesday";
                       break;
                   case 4: weekDay="thursday";
                       break;
                   case 5: weekDay="friday";
                       break;
                   case 6: weekDay="saturday";
                       break;

               }*/

                if(selectedHour>12)
                {
                    time24="PM";
                    selectedHour=selectedHour-12;
                }else if(selectedHour==12 )
                {
                    time24="PM";
                }
                if(selectedMinute<10)
                {
                    textView.setText( selectedHour + ":" +"0"+ selectedMinute+time24);
                }else
                {
                    textView.setText( selectedHour + ":" + selectedMinute+time24);
                }

            }
        }, hour, minute, false);//Yes 24 hour time
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();
    }


}