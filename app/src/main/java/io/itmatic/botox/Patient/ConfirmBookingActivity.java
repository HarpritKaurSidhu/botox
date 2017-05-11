package io.itmatic.botox.Patient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.itmatic.botox.BotoxApplication;
import io.itmatic.botox.Common.BaseActivity;
import io.itmatic.botox.Model.Area;
import io.itmatic.botox.R;

public class ConfirmBookingActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.txt_area_no)
    TextView treatAreaTextView;
    @BindView(R.id.lout_areas)
    LinearLayout areasLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_booking);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.confirm_booking));

        for(int i=0;i<((BotoxApplication) getApplication()).getAreas().size();i++) {
            Area area = ((BotoxApplication) getApplication()).getAreas().get(i);
            if (area.isSelected()) {


                LinearLayout layout = new LinearLayout(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

                layoutParams.setMargins(0, 0, 0, 0);
                layout.setLayoutParams(layoutParams);
                layout.setOrientation(LinearLayout.HORIZONTAL);
                final TextView textView = new TextView(this);

                textView.setText(".");
                textView.setTextSize(50);
                textView.setTextColor(getResources().getColor(R.color.White));
                textView.setGravity(Gravity.CENTER_VERTICAL);
                textView.setPadding(5, 5, 5, 5);
                final TextView textView1=new TextView(this);
                textView1.setTextColor(getResources().getColor(R.color.White));
                textView1.setGravity(Gravity.CENTER_VERTICAL);
                textView1.setText(area.getTitle());
                LinearLayout.LayoutParams textViewParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

                layoutParams.setMargins(10, 0, 0, 0);
                textView1.setLayoutParams(textViewParams);
                layout.addView(textView);
                layout.addView(textView1);
                areasLayout.addView(layout);

            }
        }
    }
}
