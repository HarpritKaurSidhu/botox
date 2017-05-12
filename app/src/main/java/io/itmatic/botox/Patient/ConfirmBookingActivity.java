package io.itmatic.botox.Patient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.itmatic.botox.BotoxActivity;
import io.itmatic.botox.BotoxApplication;
import io.itmatic.botox.Common.BaseActivity;
import io.itmatic.botox.Model.Area;
import io.itmatic.botox.R;
import io.itmatic.botox.Splash;

public class ConfirmBookingActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.txt_area_no)
    TextView textViewTreatAreas;
    @BindView(R.id.txt_date)
    TextView textViewDate;
    @BindView(R.id.txt_time)
    TextView textViewTime;
    @BindView(R.id.txt_clinician_name)
    TextView textViewClinicianName;
    @BindView(R.id.lout_areas)
    LinearLayout areasLayout;
    @BindView(R.id.btn_confirm)
    Button buttonConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_booking);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.confirm_booking));

        int j=0;

        for(int i=0;i<((BotoxApplication) getApplication()).getAreas().size();i++) {
            Area area = ((BotoxApplication) getApplication()).getAreas().get(i);
            if (area.isSelected()) {
                j++;

                LinearLayout layout = new LinearLayout(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

                layoutParams.setMargins(0, 0, 0, 0);
                layout.setLayoutParams(layoutParams);
                layout.setOrientation(LinearLayout.HORIZONTAL);
                layout.setGravity(Gravity.CENTER_VERTICAL);
                final ImageView imageView=new ImageView(this);
                LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams(
                        10,10);
                imageView.setLayoutParams(imageParams);
                imageView.setBackgroundColor(getResources().getColor(R.color.White));



                final TextView textView1=new TextView(this);
                textView1.setTextColor(getResources().getColor(R.color.White));
                textView1.setGravity(Gravity.CENTER_VERTICAL);
                textView1.setText(area.getTitle());
                LinearLayout.LayoutParams textViewParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

                textViewParams.setMargins(20, 0, 0, 0);
                textView1.setLayoutParams(textViewParams);
                layout.addView(imageView);
                layout.addView(textView1);
                areasLayout.addView(layout);

            }
        }
        textViewTreatAreas.setText(""+j);
        textViewTime.setText(((BotoxApplication) getApplication()).getTime());
        textViewDate.setText(((BotoxApplication) getApplication()).getDate());
        textViewClinicianName.setText((BotoxApplication.selectedProvider.getFullName()));

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ConfirmBookingActivity.this, PaymentDetailsActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();

            }
        });
    }
}
