package io.itmatic.botox.Provider;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.itmatic.botox.Common.BaseActivity;
import io.itmatic.botox.R;

public class WorkingConditionsActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.btn_next)
    Button buttonSubmit;
    @BindView(R.id.txt_set_time_from)
    TextView textViewFrom;
    @BindView(R.id.txt_set_time_to)
    TextView textViewTo;
    @BindView(R.id.edt_distance)
    EditText editTextDistance;
    @BindView(R.id.cb_confirmation_one)
    CheckBox cbWorkInUk;
    @BindView(R.id.cb_confirmation_two)
    CheckBox cbSelfEmployee;
    @BindView(R.id.cb_confirmation_three)
    CheckBox cbResponsible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_working_conditions);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.working_condition));
        textViewFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                setTime(textViewFrom);

            }
        });
        textViewTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTime(textViewTo);
            }
        });
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                final Dialog dialog = new Dialog(WorkingConditionsActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

                dialog.setContentView(R.layout.confirm_layout);
                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.copyFrom(dialog.getWindow().getAttributes());
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                dialog.getWindow().setAttributes(lp);
                Button Ok = (Button) dialog.findViewById(R.id.btn_close);

                Ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();

                        Intent intent = new Intent(WorkingConditionsActivity.this, ProviderProfileActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();

                    }
                });
                dialog.show();





            }
        });

        textViewFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setTime(textViewFrom);

            }
        });
        textViewTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTime(textViewTo);
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
        TimePickerDialog mTimePicker = new TimePickerDialog(WorkingConditionsActivity.this, new TimePickerDialog.OnTimeSetListener() {
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
