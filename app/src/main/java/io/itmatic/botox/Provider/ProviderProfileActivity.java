package io.itmatic.botox.Provider;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.itmatic.botox.Common.BaseActivity;
import io.itmatic.botox.Common.Resource;
import io.itmatic.botox.R;

public class ProviderProfileActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.img_user)
    ImageView userImage;
    @BindView(R.id.txt_name)
    TextView userName;
    @BindView(R.id.btn_schedule)
    Button   buttonSchedule;
    @BindView(R.id.btn_my_appoinments)
    Button buttonMyAppointment;
    @BindView(R.id.btn_my_payments)
    Button buttonMyPayment;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.profile));
        userName.setText(Resource.provider.getFullName());
        Glide.with(this).load(Resource.provider.getImage_url()).placeholder(R.drawable.ic_demmy_user).dontAnimate().into(userImage);

        buttonSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(ProviderProfileActivity.this,ScheduleActivity.class);
                startActivity(intent);
            }
        });
        buttonMyAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ProviderProfileActivity.this,MyAppointmentActivity.class);
                startActivity(intent);
            }
        });




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
