package io.itmatic.botox.Patient;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import devs.mulham.horizontalcalendar.HorizontalCalendar;
import io.itmatic.botox.Common.BaseActivity;
import io.itmatic.botox.R;

public class AppointmentTime extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.lout1)
    LinearLayout lout1;

    @BindView(R.id.lout2)
    LinearLayout lout2;

    @BindView(R.id.lout3)
    LinearLayout lout3;

    @BindView(R.id.lout4)
    LinearLayout lout4;

    @BindView(R.id.lout5)
    LinearLayout lout5;

    @BindView(R.id.lout6)
    LinearLayout lout6;

    @BindView(R.id.lout7)
    LinearLayout lout7;

    @BindView(R.id.lout8)
    LinearLayout lout8;
    @BindView(R.id.lout9)
    LinearLayout lout9;
    @BindView(R.id.lout10)
    LinearLayout lout10;
    @BindView(R.id.lout11)
    LinearLayout lout11;
    @BindView(R.id.lout12)
    LinearLayout lout12;
    @BindView(R.id.lout13)
    LinearLayout lout13;
    @BindView(R.id.lout14)
    LinearLayout lout14;
    @BindView(R.id.lout15)
    LinearLayout lout15;
    @BindView(R.id.lout16)
    LinearLayout lout16;
    @BindView(R.id.lout17)
    LinearLayout lout17;
    @BindView(R.id.lout18)
    LinearLayout lout18;
    @BindView(R.id.lout19)
    LinearLayout lout19;
    @BindView(R.id.lout20)
    LinearLayout lout20;
    @BindView(R.id.lout21)
    LinearLayout lout21;
    @BindView(R.id.lout22)
    LinearLayout lout22;
    @BindView(R.id.lout23)
    LinearLayout lout23;
    @BindView(R.id.lout24)
    LinearLayout lout24;
    @BindView(R.id.lout25)
    LinearLayout lout25;
    @BindView(R.id.lout26)
    LinearLayout lout26;
    @BindView(R.id.lout27)
    LinearLayout lout27;
    @BindView(R.id.lout28)
    LinearLayout lout28;
    @BindView(R.id.lout29)
    LinearLayout lout29;
    @BindView(R.id.lout30)
    LinearLayout lout30;
    @BindView(R.id.lout31)
    LinearLayout lout31;
    @BindView(R.id.lout32)
    LinearLayout lout32;
    @BindView(R.id.lout33)
    LinearLayout lout33;
    @BindView(R.id.lout34)
    LinearLayout lout34;
    @BindView(R.id.lout35)
    LinearLayout lout35;
    @BindView(R.id.lout36)
    LinearLayout lout36;
    @BindView(R.id.lout37)
    LinearLayout lout37;
    @BindView(R.id.lout38)
    LinearLayout lout38;
    @BindView(R.id.lout39)
    LinearLayout lout39;
    @BindView(R.id.lout40)
    LinearLayout lout40;
    @BindView(R.id.lout41)
    LinearLayout lout41;
    @BindView(R.id.lout42)
    LinearLayout lout42;
    @BindView(R.id.lout43)
    LinearLayout lout43;
    @BindView(R.id.lout44)
    LinearLayout lout44;
    @BindView(R.id.lout45)
    LinearLayout lout45;
    @BindView(R.id.lout46)
    LinearLayout lout46;
    @BindView(R.id.lout47)
    LinearLayout lout47;
    @BindView(R.id.lout48)
    LinearLayout lout48;
    @BindView(R.id.txt_time1)
    TextView textViewTime1;
    @BindView(R.id.txt_time2)
    TextView textViewTime2;
    @BindView(R.id.txt_time3)
    TextView textViewTime3;
    @BindView(R.id.txt_time4)
    TextView textViewTime4;
    @BindView(R.id.txt_time5)
    TextView textViewTime5;
    @BindView(R.id.txt_time6)
    TextView textViewTime6; @BindView(R.id.txt_time7)
    TextView textViewTime7; @BindView(R.id.txt_time8)
    TextView textViewTime8; @BindView(R.id.txt_time9)
    TextView textViewTime9; @BindView(R.id.txt_time10)
    TextView textViewTime10; @BindView(R.id.txt_time11)
    TextView textViewTime11; @BindView(R.id.txt_time12)
    TextView textViewTime12; @BindView(R.id.txt_time13)
    TextView textViewTime13; @BindView(R.id.txt_time14)
    TextView textViewTime14; @BindView(R.id.txt_time15)
    TextView textViewTime15; @BindView(R.id.txt_time16)
    TextView textViewTime16; @BindView(R.id.txt_time17)
    TextView textViewTime17; @BindView(R.id.txt_time18)
    TextView textViewTime18; @BindView(R.id.txt_time19)
    TextView textViewTime19; @BindView(R.id.txt_time20)
    TextView textViewTime20; @BindView(R.id.txt_time21)
    TextView textViewTime21; @BindView(R.id.txt_time22)
    TextView textViewTime22;
    @BindView(R.id.txt_time23)
    TextView textViewTime23;
    @BindView(R.id.txt_time24)
    TextView textViewTime24; @BindView(R.id.txt_time25)
    TextView textViewTime25; @BindView(R.id.txt_time26)
    TextView textViewTime26;
    @BindView(R.id.txt_time27)
    TextView textViewTime27;
    @BindView(R.id.txt_time28)
    TextView textViewTime28;
    @BindView(R.id.txt_time29)
    TextView textViewTime29;
    @BindView(R.id.txt_time30)
    TextView textViewTime30;
    @BindView(R.id.txt_time31)
    TextView textViewTime31;
    @BindView(R.id.txt_time32)
    TextView textViewTime32;
    @BindView(R.id.txt_time33)
    TextView textViewTime33;
    @BindView(R.id.txt_time34)
    TextView textViewTime34;
    @BindView(R.id.txt_time35)
    TextView textViewTime35;
    @BindView(R.id.txt_time36)
    TextView textViewTime36;
    @BindView(R.id.txt_time37)
    TextView textViewTime37;
    @BindView(R.id.txt_time38)
    TextView textViewTime38;
    @BindView(R.id.txt_time39)
    TextView textViewTime39;
    @BindView(R.id.txt_time40)
    TextView textViewTime40;
    @BindView(R.id.txt_time41)
    TextView textViewTime41;
    @BindView(R.id.txt_time42)
    TextView textViewTime42;
    @BindView(R.id.txt_time43)
    TextView textViewTime43;
    @BindView(R.id.txt_time44)
    TextView textViewTime44;
    @BindView(R.id.txt_time45)
    TextView textViewTime45;
    @BindView(R.id.txt_time46)
    TextView textViewTime46;
    @BindView(R.id.txt_time47)
    TextView textViewTime47;
    @BindView(R.id.txt_time48)
    TextView textViewTime48;























    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_time);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.appointment_time));
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);

/** start before 1 month from now */
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -1);

        HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(this, R.id.calendarView)
                .startDate(startDate.getTime())
                .endDate(endDate.getTime())
                .textColor(Color.BLACK, Color.BLUE)    // Text color for none selected Dates, Text color for selected Date.
                .selectedDateBackground(Color.LTGRAY)  // Background color of the selected date cell.
                .selectorColor(Color.RED)
                .build();


        lout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime1.getText().toString();
                getProviders(time);
            }
        });
        lout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime2.getText().toString();
                getProviders(time);
            }
        });
        lout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime3.getText().toString();
                getProviders(time);
            }
        });
        lout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime4.getText().toString();
                getProviders(time);
            }
        });
        lout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime5.getText().toString();
                getProviders(time);
            }
        });
        lout6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime6.getText().toString();
                getProviders(time);
            }
        }); lout7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime7.getText().toString();
                getProviders(time);
            }
        });
        lout8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime8.getText().toString();
                getProviders(time);
            }
        });
        lout9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime9.getText().toString();
                getProviders(time);
            }
        });
        lout10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime10.getText().toString();
                getProviders(time);
            }
        });
        lout11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime11.getText().toString();
                getProviders(time);
            }
        });
        lout12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime12.getText().toString();
                getProviders(time);
            }
        });
        lout13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime13.getText().toString();
                getProviders(time);
            }
        });
        lout14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime14.getText().toString();
                getProviders(time);
            }
        });
        lout15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime15.getText().toString();
                getProviders(time);
            }
        });
        lout16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime16.getText().toString();
                getProviders(time);
            }
        });
        lout17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime17.getText().toString();
                getProviders(time);
            }
        });
        lout18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime18.getText().toString();
                getProviders(time);
            }
        });
        lout19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime19.getText().toString();
                getProviders(time);
            }
        });
        lout20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime20.getText().toString();
                getProviders(time);
            }
        });
        lout21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime21.getText().toString();
                getProviders(time);
            }
        });
        lout22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime22.getText().toString();
                getProviders(time);
            }
        });
        lout23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime23.getText().toString();
                getProviders(time);
            }
        });
        lout24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime24.getText().toString();
                getProviders(time);
            }
        });
        lout25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime25.getText().toString();
                getProviders(time);
            }
        });
        lout26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime26.getText().toString();
                getProviders(time);
            }
        });
        lout27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime27.getText().toString();
                getProviders(time);
            }
        });
        lout28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime28.getText().toString();
                getProviders(time);
            }
        });
        lout29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime29.getText().toString();
                getProviders(time);
            }
        });
        lout30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime30.getText().toString();
                getProviders(time);
            }
        });
        lout31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime31.getText().toString();
                getProviders(time);
            }
        });
        lout32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime32.getText().toString();
                getProviders(time);
            }
        }); lout33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime33.getText().toString();
                getProviders(time);
            }
        });
        lout34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime34.getText().toString();
                getProviders(time);
            }
        });
        lout35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime35.getText().toString();
                getProviders(time);
            }
        });
        lout36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime36.getText().toString();
                getProviders(time);
            }
        });
        lout37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime37.getText().toString();
                getProviders(time);
            }
        });
        lout38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime38.getText().toString();
                getProviders(time);
            }
        });
        lout39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime39.getText().toString();
                getProviders(time);
            }
        });
        lout40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime40.getText().toString();
                getProviders(time);
            }
        });
        lout41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime41.getText().toString();
                getProviders(time);
            }

        });
        lout42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime42.getText().toString();
                getProviders(time);
            }
        });
        lout43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime43.getText().toString();
                getProviders(time);
            }
        });
        lout44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime44.getText().toString();
                getProviders(time);
            }
        });
        lout45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime45.getText().toString();
                getProviders(time);
            }
        });
        lout46.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime46.getText().toString();
                getProviders(time);
            }
        });

        lout47.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime47.getText().toString();
                getProviders(time);
            }
        });
        lout48.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime48.getText().toString();
                getProviders(time);
            }
        });



    }



    private void getProviders(String time){
        Intent intent=new Intent(AppointmentTime.this,BookAnAppointmentActivity.class);
        startActivity(intent);

    }


}
