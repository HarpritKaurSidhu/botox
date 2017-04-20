package io.itmatic.botox.Provider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.LinearLayout;

import butterknife.BindView;
import io.itmatic.botox.R;

public class ScheduleActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.schedule));
    } @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
            {
                onBackPressed();
                return true;
            }
        }
        return onOptionsItemSelected(item);
    }
}



