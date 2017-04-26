package io.itmatic.botox.Provider;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.itmatic.botox.BotoxApplication;
import io.itmatic.botox.Common.BaseActivity;
import io.itmatic.botox.Common.RealPathUtil;
import io.itmatic.botox.Model.Education;
import io.itmatic.botox.Model.Provider;
import io.itmatic.botox.R;
import io.itmatic.botox.Retrofit.Helper;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UploadDocumentFirstActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.btn_next)
    Button buttonNext;
    @BindView(R.id.lout_qualification)
    LinearLayout loutQualification;
  /*  @BindView(R.id.edt_cv)
    EditText cv;
    @BindView(R.id.edt_proof)
    EditText proof;
    @BindView(R.id.edt_photo_in)
    EditText photoIn;
    @BindView(R.id.edt_qualification_certificate)
    EditText qualificationCertificate;
    @BindView(R.id.edt_other)
    EditText other;*/
    int REQUEST_CODE_CV=1;
    int REQUEST_CODE_CERTIFICAT=0;
  //  TextView[] textViews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploads_documents_first);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.uploads_documents));

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(UploadDocumentFirstActivity.this,WorkingConditionsActivity.class);
                startActivity(intent);
            }
        });


        loutQualification.setOrientation(LinearLayout.VERTICAL);
        final ArrayList<Education> educations=((BotoxApplication)getApplication()).getEducations();
        ArrayList<Education> selectedEducations= new ArrayList<>();

        for(int i=0;i<educations.size();i++)
        {
            if (educations.get(i).isSelectCourse()) {
                selectedEducations.add(educations.get(i));
            }
        }
      //  textViews=new TextView[selectedEducations.size()];
        for(int i = 0; i <  selectedEducations.size(); i++ ) {

                LinearLayout layout=new LinearLayout(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

                layoutParams.setMargins(0, 20, 0, 0);
                layout.setLayoutParams(layoutParams);
                layout.setBackgroundColor(getResources().getColor(R.color.gray));
                layout.setOrientation(LinearLayout.VERTICAL);
            TextView textView=new TextView(this);
            textView.setId(2000+i);
            textView.setText(selectedEducations.get(i).getTitle());

            textView.setBackgroundColor(getResources().getColor(R.color.White));
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_add_box_blue_grey_300_36dp, 0);
                TableLayout.LayoutParams params = new TableLayout.LayoutParams();
                params.setMargins(2, 2, 2, 2);
            textView.setLayoutParams(params);
            textView.setGravity(Gravity.CENTER_VERTICAL);
            textView.setPadding(10,0,0,0);

            textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        REQUEST_CODE_CERTIFICAT=view.getId();

                        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                        intent.addCategory(Intent.CATEGORY_OPENABLE);
                        intent.setType("*/*");
                        String[] mimetypes = {"application/vnd.openxmlformats-officedocument.wordprocessingml.document", "application/msword"};
                        intent.putExtra(Intent.EXTRA_MIME_TYPES, mimetypes);
                        startActivityForResult(intent,REQUEST_CODE_CERTIFICAT);


                    }
                });
                layout.addView(textView);
                loutQualification.addView(layout);
            }





    }



    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {

        if ((requestCode == REQUEST_CODE_CERTIFICAT || requestCode == 65542 || requestCode == 131078 || requestCode == 393222 || requestCode == 393222 || requestCode == 262150) && resultCode == RESULT_OK) {
            String realPath;
            // SDK < API11
            if (Build.VERSION.SDK_INT < 11)
                realPath = RealPathUtil.getRealPathFromURI_BelowAPI11(this, data.getData());

                // SDK >= 11 && SDK < 19
            else if (Build.VERSION.SDK_INT < 19)
                realPath = RealPathUtil.getRealPathFromURI_API11to18(this, data.getData());

                // SDK > 19 (Android 4.4)
            else
                realPath = RealPathUtil.getPath(this, data.getData());


            //Uri selectedImageUri = data.getData();
            final File file = new File(realPath);

            if (file.exists()) {


               uploadProviderDocument(REQUEST_CODE_CERTIFICAT,"Education",file);


            }

        }
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


    private void uploadProviderDocument(int requestCode, String type, final File file) {
        final ProgressDialog dialog = ShowConstantProgressNOTCAN(this, "", getResources().getString(R.string.registering));
        dialog.show();

        RequestBody fileType = RequestBody.create(MediaType.parse("text/plain"),type);
        RequestBody reqFile = RequestBody.create(MediaType.parse("image/*"), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("file", file.getName(), reqFile);
        SharedPreferences preferences = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
        String providerToken = preferences.getString("provider_token", "");
        RequestBody token = RequestBody.create(MediaType.parse("text/plain"),providerToken);
        Call<Provider> call = Helper.getBotoxApiService().uploadProviderDocument(token,fileType, body);
        call.enqueue(new Callback<Provider>() {


            @Override
            public void onResponse(Call<Provider> call, Response<Provider> response) {
                dialog.dismiss();
                int statusCode = response.code();
                if (statusCode == 200) {
                    Provider provider = response.body();
                    provider.getAccessToken();
                 TextView textView=(TextView) findViewById(REQUEST_CODE_CERTIFICAT);
                    textView.setText(file.getName());
                    textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_clear_teal_300_36dp, 0);


                } else {

                    JSONObject error= null;
                    String message="";
                    try {
                        error = new JSONObject(response.errorBody().string());
                        message=error.getString("message");

                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    showError(message);


                }




            }

            @Override
            public void onFailure(Call<Provider> call, Throwable t) {
                t.toString();
                dialog.dismiss();
            }


        });
    }
}
