package io.itmatic.botox.Provider;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.itmatic.botox.Common.BaseActivity;
import io.itmatic.botox.Common.RealPathUtil;
import io.itmatic.botox.Model.Provider;
import io.itmatic.botox.R;
import io.itmatic.botox.Retrofit.Helper;
import io.itmatic.botox.Retrofit.ProgressRequestBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UploadDocumentSecondActivity extends BaseActivity implements ProgressRequestBody.UploadCallbacks {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.txt_cv)
    TextView cv;
    @BindView(R.id.txt_proof)
    TextView proof;
    @BindView(R.id.txt_photo_in)
    TextView photoIn;
    @BindView(R.id.txt_crb_check)
    TextView crbCheck;
    @BindView(R.id.btn_next)
    Button buttonNext;
    private int REQUEST_CODE_CERTIFICATE=0;
  private String code;
   private Intent intent;
    int driverSwitch = 0;
    private String[] CAMERA_PERMS = {Manifest.permission.CAMERA};
   private int CAMERA_REQUEST = 1337;
    private final int GELLARY_REQUEST = 1340;
   private String[] GELLARY_PERMS = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

   private HashMap<Integer,Call> uploadRequests = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_document_second);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.uploads_proof_documents));

        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                code="CV";
                REQUEST_CODE_CERTIFICATE=view.getId();
                if(uploadRequests.containsKey(REQUEST_CODE_CERTIFICATE))
                {
                    Call call=uploadRequests.get(REQUEST_CODE_CERTIFICATE);
                    if(call.isExecuted())
                    {
                        uploadRequests.remove(REQUEST_CODE_CERTIFICATE);
                        TextView textView=(TextView) findViewById(REQUEST_CODE_CERTIFICATE);
                        textView.setText("");
                        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_add_box_blue_grey_300_36dp, 0);
                    }else
                    {
                        uploadRequests.get(REQUEST_CODE_CERTIFICATE).cancel();
                        uploadRequests.remove(REQUEST_CODE_CERTIFICATE);
                        TextView textView=(TextView) findViewById(REQUEST_CODE_CERTIFICATE);
                        textView.setText("");
                        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_add_box_blue_grey_300_36dp, 0);
                    }

                }else {
                    Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                    intent.addCategory(Intent.CATEGORY_OPENABLE);
                    intent.setType("*/*");
                    String[] mimetypes = {"application/vnd.openxmlformats-officedocument.wordprocessingml.document", "application/msword"};
                    intent.putExtra(Intent.EXTRA_MIME_TYPES, mimetypes);
                    startActivityForResult(intent, 6);
                }


            }
        });

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               if((cv.getText().toString()==null || cv.getText().toString().equals("")) || (proof.getText().toString()==null || proof.getText().toString().equals("")) ||(photoIn.getText().toString()==null || photoIn.getText().toString().equals("")) || (crbCheck.getText().toString()==null || crbCheck.getText().toString().equals("")) )
                {
                    buildDialog(R.style.DialogTheme,getResources().getString(R.string.select_your_document));
                }else{
                    Intent intent = new Intent(UploadDocumentSecondActivity.this, WorkingConditionsActivity.class);
                    startActivity(intent);
                }

               /* Intent intent = new Intent(UploadDocumentSecondActivity.this, WorkingConditionsActivity.class);
                startActivity(intent);*/
            }
        });


        proof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                code="Proof";
                REQUEST_CODE_CERTIFICATE=view.getId();
                if(uploadRequests.containsKey(REQUEST_CODE_CERTIFICATE))
                {
                    Call call=uploadRequests.get(REQUEST_CODE_CERTIFICATE);
                    if(call.isExecuted())
                    {
                        uploadRequests.remove(REQUEST_CODE_CERTIFICATE);
                        TextView textView=(TextView) findViewById(REQUEST_CODE_CERTIFICATE);
                        textView.setText("");
                        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_add_box_blue_grey_300_36dp, 0);
                    }else
                    {
                        uploadRequests.get(REQUEST_CODE_CERTIFICATE).cancel();
                        uploadRequests.remove(REQUEST_CODE_CERTIFICATE);
                        TextView textView=(TextView) findViewById(REQUEST_CODE_CERTIFICATE);
                        textView.setText("");
                        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_add_box_blue_grey_300_36dp, 0);
                    }

                }else {

                   showChooserDialog();


                }

            }
        });

        photoIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                code="Photo IN";
                REQUEST_CODE_CERTIFICATE=view.getId();
                if(uploadRequests.containsKey(REQUEST_CODE_CERTIFICATE))
                {
                    Call call=uploadRequests.get(REQUEST_CODE_CERTIFICATE);
                    if(call.isExecuted())
                    {
                        uploadRequests.remove(REQUEST_CODE_CERTIFICATE);
                        TextView textView=(TextView) findViewById(REQUEST_CODE_CERTIFICATE);
                        textView.setText("");
                        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_add_box_blue_grey_300_36dp, 0);
                    }else
                    {
                        uploadRequests.get(REQUEST_CODE_CERTIFICATE).cancel();
                        uploadRequests.remove(REQUEST_CODE_CERTIFICATE);
                        TextView textView=(TextView) findViewById(REQUEST_CODE_CERTIFICATE);
                        textView.setText("");
                        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_add_box_blue_grey_300_36dp, 0);
                    }

                }else {

                    showChooserDialog();


                }

            }
        });

        crbCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                code="CRB check";
                REQUEST_CODE_CERTIFICATE=view.getId();
                if(uploadRequests.containsKey(REQUEST_CODE_CERTIFICATE))
                {
                    Call call=uploadRequests.get(REQUEST_CODE_CERTIFICATE);
                    if(call.isExecuted())
                    {
                        uploadRequests.remove(REQUEST_CODE_CERTIFICATE);
                        TextView textView=(TextView) findViewById(REQUEST_CODE_CERTIFICATE);
                        textView.setText("");
                        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_add_box_blue_grey_300_36dp, 0);
                    }else
                    {
                        uploadRequests.get(REQUEST_CODE_CERTIFICATE).cancel();
                        uploadRequests.remove(REQUEST_CODE_CERTIFICATE);
                        TextView textView=(TextView) findViewById(REQUEST_CODE_CERTIFICATE);
                        textView.setText("");
                        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_add_box_blue_grey_300_36dp, 0);
                    }

                }else {

                    showChooserDialog();


                }

            }
        });
    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        if ((requestCode == 7 && resultCode == RESULT_OK) || (requestCode == 65543 && resultCode == RESULT_OK) || (requestCode == 327687 && resultCode == RESULT_OK) || (requestCode == 131079 && resultCode == RESULT_OK)) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            // getImage(bitmap);
            File f = new File(this.getCacheDir(),"temp");
            try {
                f.createNewFile();

//Convert bitmap to byte array

                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 0 /*ignored for PNG*/, bos);
                byte[] bitmapData = bos.toByteArray();

//write the bytes in file
                FileOutputStream fos = new FileOutputStream(f);

                fos.write(bitmapData);

                fos.flush();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            uploadProviderDocument("Education", f);

        }else if ((requestCode == 6 || requestCode == 65542 || requestCode == 131078 || requestCode == 393222 || requestCode == 393222 || requestCode == 262150) && resultCode == RESULT_OK) {
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


                uploadProviderDocument(code, file);


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


    private void uploadProviderDocument(String type, final File file) {
      /*  final ProgressDialog dialog = ShowConstantProgressNOTCAN(this, "", getResources().getString(R.string.registering));
        dialog.show();*/

        RequestBody fileType = RequestBody.create(MediaType.parse("text/plain"),type);
        ProgressRequestBody fileBody = new ProgressRequestBody(file, this,REQUEST_CODE_CERTIFICATE);
        MultipartBody.Part body = MultipartBody.Part.createFormData("file", file.getName(), fileBody);
        SharedPreferences preferences = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
        String providerToken = preferences.getString("provider_token", "");
        RequestBody token = RequestBody.create(MediaType.parse("text/plain"),providerToken);
        Call<Provider> call = Helper.getBotoxApiService().uploadProviderDocument(token,fileType, body);

        uploadRequests.put(REQUEST_CODE_CERTIFICATE,call);


        call.enqueue(new Callback<Provider>() {


            @Override
            public void onResponse(Call<Provider> call, Response<Provider> response) {
                // dialog.dismiss();
                int statusCode = response.code();
                if (statusCode == 200) {
                    Provider provider = response.body();
                    provider.getAccessToken();
                    TextView textView=(TextView) findViewById(REQUEST_CODE_CERTIFICATE);
                    textView.setText(file.getName());
                    textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_clear_teal_300_36dp, 0);


                } else {

                    JSONObject error;
                    String message="";
                    try {
                        error = new JSONObject(response.errorBody().string());
                        message=error.getString("message");

                    } catch (JSONException | IOException e) {
                        e.printStackTrace();
                    }

                    showError(message);


                }




            }

            @Override
            public void onFailure(Call<Provider> call, Throwable t) {
                t.toString();
                // dialog.dismiss();
            }


        });
    }


    @Override
    public void onProgressUpdate(int percentage, int requestCode) {
        TextView textView=(TextView) findViewById(requestCode);
        textView.setText(""+percentage+"%");
    }

    @Override
    public void onError() {
     System.out.print("error");
    }

    @Override
    public void onFinish() {
        System.out.print("error");
    }

    private void showChooserDialog()
    {

        AlertDialog.Builder getImageFrom = new AlertDialog.Builder(UploadDocumentSecondActivity.this);
        getImageFrom.setTitle(getResources().getString(R.string.select_image));
        final CharSequence[] opsChars = {getResources().getString(R.string.takepicture), getResources().getString(R.string.opengallery)};
        getImageFrom.setItems(opsChars, new android.content.DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {

                    String file = System.currentTimeMillis() + ".jpg";
                    File newFile = new File(file);
                    try {
                        newFile.createNewFile();
                    } catch (IOException e) {
                        e.toString();
                    }


                    if (ContextCompat.checkSelfPermission(UploadDocumentSecondActivity.this, Manifest.permission.CAMERA) ==
                            PackageManager.PERMISSION_GRANTED) {
                        intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(intent, 7);
                    } else {
                        ActivityCompat.requestPermissions(UploadDocumentSecondActivity.this, CAMERA_PERMS, CAMERA_REQUEST);
                    }


                } else if (which == 1) {
                    if (ContextCompat.checkSelfPermission(UploadDocumentSecondActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                            PackageManager.PERMISSION_GRANTED) {
                        Intent intent = new Intent();
                        intent.setType("image/*");
                        intent.setAction(Intent.ACTION_GET_CONTENT);
                        intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
                        startActivityForResult(Intent.createChooser(intent, "Open Gallery"), 6);
                    } else {
                        ActivityCompat.requestPermissions(UploadDocumentSecondActivity.this, GELLARY_PERMS, GELLARY_REQUEST);
                    }
                }

            }
        });

        getImageFrom.show();


    }
}
