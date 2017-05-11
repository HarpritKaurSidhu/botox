package io.itmatic.botox.Patient;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.itmatic.botox.BotoxApplication;
import io.itmatic.botox.Model.Area;
import io.itmatic.botox.R;

public class PriceActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.txt_total)
    TextView textViewTotal;
    @BindView(R.id.btn_confirm)
    Button buttonConfirm;
    @BindView(R.id.lout_price)
    LinearLayout loutPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.price));
        List<Area> areas = ((BotoxApplication) getApplication()).getAreas();
        float total = 0;
        JSONArray jsonArray=new JSONArray();
        for (int i = 0; i < areas.size(); i++) {
            if (areas.get(i).isSelected())
            {
                JSONObject jsonObject=new JSONObject();
                try {
                    jsonObject.put("id",areas.get(i).getId());
                    jsonArray.put(jsonObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                TextView textView = new TextView(this);
            textView.setText("Area:" + i + " " + "$" + areas.get(i).getPrice());
            // LinearLayout layout=new LinearLayout(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            textView.setLayoutParams(layoutParams);
            layoutParams.setMargins(50, 0, 20, 20);
            textView.setTextColor(Color.BLACK);
            textView.setTextSize(17);
            total = total + areas.get(i).getPrice();
            loutPrice.addView(textView);
        }
    }

        ((BotoxApplication) getApplication()).setSelectedArea(jsonArray.toString());

        textViewTotal.setText("Total:"+" "+"$"+total);
        textViewTotal.setTextSize(25);
        textViewTotal.setTextColor(Color.BLACK);

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(PriceActivity.this,AppointmentTime.class);
                startActivity(intent);
            }
        });

    }
}
