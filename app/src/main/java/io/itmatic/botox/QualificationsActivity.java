package io.itmatic.botox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.itmatic.botox.Adapter.Qualification;
import io.itmatic.botox.CommonClasses.BaseActivity;
import io.itmatic.botox.model.Education;

public class QualificationsActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.btn_next)
    Button button;
    @BindView(R.id.sp_qualification)
    Spinner spinnerQuailification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qualifications);
        ButterKnife.bind(this);

        ArrayList<Education> educations=new ArrayList<>();
        Education education=new Education();
        for(int i=1;i<4;i++) {
            education.setId(i);
            education.setDisplayName("mbbs" + i);
            educations.add(education);
        }

        Qualification qualificationAdapter = new Qualification(this,R.layout.qualification_spinner_layout,educations);
        qualificationAdapter.setDropDownViewResource(R.layout.spinner_drop_down);
        spinnerQuailification.setAdapter(qualificationAdapter);

        /*ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice,conts_list);
        my_contacts_list.setAdapter(adapter);*/


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QualificationsActivity.this, UploadsDocumentsActivity.class);
                startActivity(intent);
            }
        });
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.qualification));
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
