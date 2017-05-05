package io.itmatic.botox.Patient;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import devs.mulham.horizontalcalendar.HorizontalCalendar;
import io.itmatic.botox.BotoxApplication;
import io.itmatic.botox.Common.BaseActivity;
import io.itmatic.botox.Model.Provider;
import io.itmatic.botox.PostcodeActivity;
import io.itmatic.botox.R;
import io.itmatic.botox.Retrofit.Helper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        final HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(this, R.id.calendarView)
                .startDate(startDate.getTime())
                .endDate(endDate.getTime())
                .textColor(Color.BLACK, Color.BLUE)    // Text color for none selected Dates, Text color for selected Date.
                .selectedDateBackground(Color.LTGRAY)  // Background color of the selected date cell.
                .selectorColor(Color.RED)
                .build();

        //  Date date=horizontalCalendar.getSelectedDate();


        lout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime1.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                String time24Hours=timeFormatChange(time);
                getProviders(date,time24Hours);
            }
        });
        lout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime1.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);
            }
        });
        lout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime1.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);     }
        });
        lout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime4.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);     }
        });

        lout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime5.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);
            }
        });
        lout6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime6.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);
            }
        }); lout7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime7.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);
            }
        });
        lout8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime8.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);
            }
        });
        lout9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime9.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);
            }
        });
        lout10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime10.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);
            }
        });
        lout11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime11.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);
            }
        });
        lout12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime12.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);
            }
        });
        lout13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime13.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);
            }
        });
        lout14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime14.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);
            }
        });
        lout15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime15.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);
            }
        });
        lout16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime16.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);
            }
        });
        lout17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime17.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);
            }
        });
        lout18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime18.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);
            }
        });
        lout19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime19.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);
            }
        });
        lout20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime20.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);
            }
        });
        lout21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime21.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);
            }
        });
        lout22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime22.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);
            }
        });
        lout23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime23.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);
            }
        });
        lout24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime24.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);
            }
        });
        lout25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime25.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);
            }
        });
        lout26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime26.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);
            }
        });
        lout27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime27.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);
            }
        });
        lout28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime28.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);
            }
        });
        lout29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime29.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);
            }
        });
        lout30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime30.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);
            }
        });
        lout31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime31.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);
            }
        });
        lout32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime32.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);
            }
        }); lout33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime33.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);
            }
        });
        lout34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime34.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);
            }
        });
        lout35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime35.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);
            }
        });
        lout36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime36.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);
            }
        });
        lout37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime37.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);
            }
        });
        lout38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime38.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);
            }
        });
        lout39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime39.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);
            }
        });
        lout40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime40.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);
            }
        });
        lout41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime41.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);
            }

        });
        lout42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime42.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);
            }
        });
        lout43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime43.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);
            }
        });
        lout44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime44.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);
            }
        });
        lout45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime45.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);
            }
        });
        lout46.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime46.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);
            }
        });

        lout47.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime47.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);
            }
        });
        lout48.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time=textViewTime48.getText().toString();
                Date formatDate=horizontalCalendar.getSelectedDate();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date=df.format(formatDate);
                getProviders(date,time);
            }
        });



    }



    private void getProviders(String date,String time){
        String postCode=((BotoxApplication) getApplication()).getPostCode();
        final ProgressDialog dialog = ShowConstantProgressNOTCAN(this, "", getResources().getString(R.string.processing));
        dialog.show();


       // String token=((BotoxApplication)getApplication()).getPatientToken();
        Call<List<Provider>> call = Helper.getBotoxApiService().getAvailableProvider(postCode,date,time);
        call.enqueue(new Callback<List<Provider>>() {


            @Override
            public void onResponse(Call<List<Provider>> call, Response<List<Provider>> response) {
                dialog.dismiss();
                int statusCode = response.code();
                ((BotoxApplication) getApplication()).setAvailableProviders(response.body());
                if (statusCode == 200) {
                    if(((BotoxApplication) getApplication()).getAvailableProviders().size()==0)
                    {
                        showDialogForEmptyProviders();
                    }
                    else
                    {
                        Intent intent=new Intent(AppointmentTime.this,BookAnAppointmentActivity.class);
                        startActivity(intent);
                    }
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


    private void showDialogForEmptyProviders()
    {




        final Dialog dialog = new Dialog(AppointmentTime.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.empty_providers_list_msg_dialog);
        dialog.show();

        Button buttonChoose=(Button) dialog.findViewById(R.id.btn_choose_another);

        buttonChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

    }



}
