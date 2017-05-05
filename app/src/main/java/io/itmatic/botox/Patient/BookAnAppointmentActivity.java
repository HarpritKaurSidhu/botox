package io.itmatic.botox.Patient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.itmatic.botox.Adapter.BookProviderAdapter;
import io.itmatic.botox.BotoxApplication;
import io.itmatic.botox.Common.BaseActivity;
import io.itmatic.botox.Model.Provider;
import io.itmatic.botox.R;
import io.itmatic.botox.Retrofit.BotoxApiInterface;

public class BookAnAppointmentActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rv_book_an_appointment)
    RecyclerView recyclerViewBookAnAppointment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_an_appointment);
        ButterKnife.bind(this);
        ArrayList<Provider> providers = (ArrayList<Provider>) ((BotoxApplication) getApplication()).getAvailableProviders();


        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.patient_book_an_appointment));
        BookProviderAdapter providerAdapter = new BookProviderAdapter(this,providers);
        recyclerViewBookAnAppointment.setLayoutManager(new LinearLayoutManager(BookAnAppointmentActivity.this));
        recyclerViewBookAnAppointment.setAdapter(providerAdapter);
        recyclerViewBookAnAppointment.setLayoutManager(new LinearLayoutManager(BookAnAppointmentActivity.this));
        recyclerViewBookAnAppointment.setAdapter(providerAdapter);


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
}
