package io.itmatic.botox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Botox_AppActivity extends AppCompatActivity {

    TextView provider,login;
    Toolbar toolbar;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botox__app);
        provider=(TextView)findViewById(R.id.providerId);
        button=(Button)findViewById(R.id.bookanappointmentId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Botox_AppActivity.this,Enter_your_postcodeActivity.class);
                startActivity(intent);
            }
        });
        provider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Botox_AppActivity.this,ProviderActivity.class);
                startActivity(intent);
            }
        });
        toolbar=(Toolbar)findViewById(R.id.toolbarBotox) ;
        login=(TextView)findViewById(R.id.loginId);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Botox_AppActivity.this,Login_as_patientActivity.class);
                startActivity(intent);
            }
        });
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.botox_App));
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
