package io.itmatic.botox.Patient;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.itmatic.botox.BotoxApplication;
import io.itmatic.botox.Common.BaseActivity;
import io.itmatic.botox.Model.Area;
import io.itmatic.botox.R;
import io.itmatic.botox.Retrofit.Helper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChooseAreaActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.txt_forehead)
    TextView textViewForehead;
    @BindView(R.id.txt_chin)
    TextView textViewCheen;
    @BindView(R.id.txt_left_cheek)
    TextView textViewLeftCheek;
    @BindView(R.id.txt_right_cheek)
    TextView textViewRightCheek;
    @BindView(R.id.txt_price)
    TextView textViewPrice;
    @BindView(R.id.btn_submit)
    Button buttonSubmit;
    List<Area> areas;
    private float price;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_area);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.choose_area));

        getPatientArea();

        textViewForehead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i=0;i<areas.size();i++)
                {
                    if(areas.get(i).getId()==1)
                    {
                        if(areas.get(i).isSelected())
                        {
                            textViewForehead.setBackgroundResource(R.drawable.round_text);
                            areas.get(i).setSelected(false);
                            price=price-areas.get(i).getPrice();
                            textViewPrice.setText("$"+price);
                        }
                        else
                        {
                            textViewForehead.setBackgroundResource(R.drawable.round_active_text);
                            areas.get(i).setSelected(true);
                            price=price+areas.get(i).getPrice();
                            textViewPrice.setText("$"+price);
                        }
                    }
                }


            }
        });
        textViewLeftCheek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                for(int i=0;i<areas.size();i++)
                {
                    if(areas.get(i).getId()==2)
                    {
                        if(areas.get(i).isSelected())
                        {
                            textViewLeftCheek.setBackgroundResource(R.drawable.round_text);
                            areas.get(i).setSelected(false);
                            price=price-areas.get(i).getPrice();
                            textViewPrice.setText("$"+price);
                        }
                        else
                        {
                            textViewLeftCheek.setBackgroundResource(R.drawable.round_active_text);
                            areas.get(i).setSelected(true);
                            price=price+areas.get(i).getPrice();
                            textViewPrice.setText("$"+price);
                        }
                    }
                }

            }
        });

        textViewRightCheek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                for(int i=0;i<areas.size();i++)
                {
                    if(areas.get(i).getId()==4)
                    {
                        if(areas.get(i).isSelected())
                        {
                            textViewRightCheek.setBackgroundResource(R.drawable.round_text);
                            areas.get(i).setSelected(false);
                            price=price-areas.get(i).getPrice();
                            textViewPrice.setText("$"+price);
                        }
                        else
                        {
                            textViewRightCheek.setBackgroundResource(R.drawable.round_active_text);
                            areas.get(i).setSelected(true);
                            price=price+areas.get(i).getPrice();
                            textViewPrice.setText("$"+price);
                        }
                    }
                }
            }
        });
        textViewCheen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                for(int i=0;i<areas.size();i++)
                {
                    if(areas.get(i).getId()==3)
                    {
                        if(areas.get(i).isSelected())
                        {
                            textViewCheen.setBackgroundResource(R.drawable.round_text);
                            areas.get(i).setSelected(false);
                            price=price-areas.get(i).getPrice();
                            textViewPrice.setText("$"+price);
                        }
                        else
                        {
                            textViewCheen.setBackgroundResource(R.drawable.round_active_text);
                            areas.get(i).setSelected(true);
                            price=price+areas.get(i).getPrice();
                            textViewPrice.setText("$"+price);
                        }
                    }
                }
            }
        });


        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((BotoxApplication) getApplication()).setAreas(areas);
                Intent intent=new Intent(ChooseAreaActivity.this,PriceActivity.class);
                startActivity(intent);
            }
        });




    }
    @Override
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


    private void getPatientArea()
    {
       // String token=((BotoxApplication)getApplication()).getPatientToken();
        Call<List<Area>> call = Helper.getBotoxApiService().getPatientArea();
        call.enqueue(new Callback<List<Area>>() {


            @Override
            public void onResponse(Call<List<Area>> call, Response<List<Area>> response) {
                int statusCode = response.code();
                if (statusCode == 200) {
                areas=response.body();


                } else {
                    JSONObject error;
                    String message = "";
                    try {
                        error = new JSONObject(response.errorBody().string());
                        message = error.getString("message");

                    } catch (JSONException | IOException e) {
                        e.printStackTrace();
                    }

                    showError(message);


                }

            }


            @Override
            public void onFailure(Call<List<Area>> call, Throwable t) {

            }


        });
    }
}
