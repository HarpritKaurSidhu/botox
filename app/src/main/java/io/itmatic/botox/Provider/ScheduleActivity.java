package io.itmatic.botox.Provider;

import android.app.TimePickerDialog;


import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.itmatic.botox.R;

public class ScheduleActivity extends AppCompatActivity {
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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.schedule));


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

        textViewSetTimeFromMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                setTime(textViewSetTimeFromMon);


            }
        }); getTextViewSetTimeToMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTime(getTextViewSetTimeToMon);
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


                setTime(textViewSetTimeFromTue);

            }
        }); getTextViewSetTimeToTue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTime(getTextViewSetTimeToTue);
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


                setTime(textViewSetTimeFromWed);

            }
        });
        getTextViewSetTimeToWed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTime(getTextViewSetTimeToWed);
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


                setTime(textViewSetTimeFromThu);

            }
        });
        getTextViewSetTimeToThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTime(getTextViewSetTimeToThu);
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


                setTime(textViewSetTimeFromFri);

            }
        });
        getTextViewSetTimeToFri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTime(getTextViewSetTimeToFri);
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


                setTime(textViewSetTimeFromSat);

            }
        });
        getTextViewSetTimeToSat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTime(getTextViewSetTimeToSat);
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


                setTime(textViewSetTimeFromSun);

            }
        });
        getTextViewSetTimeToSun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTime(getTextViewSetTimeToSun);
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

    private void setTime(final TextView textView) {

        Calendar currentTime = Calendar.getInstance();
        int hour = currentTime.get(Calendar.HOUR_OF_DAY);
        int minute = currentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker = new TimePickerDialog(ScheduleActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                String time24="AM";

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