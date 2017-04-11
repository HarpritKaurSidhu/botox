package io.itmatic.botox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class QualificationsActivity extends AppCompatActivity {

    Toolbar toolbar;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qualifications);
        toolbar = (Toolbar) findViewById(R.id.toolbarId);
        button = (Button) findViewById(R.id.Idnext);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QualificationsActivity.this, Uploads_DocumentsActivity.class);
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
