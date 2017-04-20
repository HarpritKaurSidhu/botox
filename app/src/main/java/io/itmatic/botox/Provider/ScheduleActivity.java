package io.itmatic.botox.Provider;

import android.app.TimePickerDialog;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
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
    @BindView(R.id.linearlayout_tue)
    LinearLayout linearLayoutTue;
    @BindView(R.id.linearlayout_mon)
    LinearLayout linearLayoutMon;
    @BindView(R.id.linearlayout_wed)
    LinearLayout linearLayoutWed;
    @BindView(R.id.linearlayout_thu)
    LinearLayout linearLayoutThu;
    @BindView(R.id.linearlayout_fri)
    LinearLayout linearLayoutFri;
    @BindView(R.id.linearlayout_sat)
    LinearLayout linearLayoutSat;
    @BindView(R.id.linearlayout_sun)
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
    TextView textViewSettimeFromMon;
    @BindView(R.id.txt_set_time_to_mon)
    TextView getTextViewSettimeToMon;



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

        textViewSettimeFromMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                setTime(textViewSettimeFromMon);

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

    public void setTime(final TextView textView) {

        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);
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