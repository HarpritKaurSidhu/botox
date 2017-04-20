package io.itmatic.botox.Provider;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.isseiaoki.simplecropview.CropImageView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.itmatic.botox.Common.BaseActivity;
import io.itmatic.botox.Common.RealPathUtil;
import io.itmatic.botox.Common.Resource;
import io.itmatic.botox.R;
import io.itmatic.botox.Retrofit.Helper;
import io.itmatic.botox.Model.Provider;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.basgeekball.awesomevalidation.ValidationStyle.BASIC;

public class SignUpAsDoctorActivity extends BaseActivity {


    @BindView(R.id.edt_first_name)
    EditText firstName;
    @BindView(R.id.edt_last_name)
    EditText lastName;
    @BindView(R.id.edt_email)
    EditText email;
    @BindView(R.id.edt_password)
    EditText password;
    @BindView(R.id.edt_address)
    EditText address;
    @BindView(R.id.edt_mode_of_transport)
    EditText modeOfTransport;
    @BindView(R.id.edt_gdcno)
    EditText gdcno;
    @BindView(R.id.edt_gmcno)
    EditText gmcno;
    @BindView(R.id.edt_phone)
    EditText phone;
    @BindView(R.id.edt_zipcode)
    EditText zipcode;
    @BindView(R.id.btn_next)
    Button next;
    @BindView(R.id.sw_driving_licence)
    Switch isDrivingLicence;
    @BindView(R.id.img_user)
    ImageView userImage;
    @BindView(R.id.txt_user_image)
    TextView uploadImage;
    @BindView(R.id.cropImageView)
    CropImageView cropImageView;
    @BindView(R.id.btn_ok)
    Button selectOk;
    Bitmap croppedBitmap;
    Intent intent;
    int driverSwitch = 0;
    String[] CAMERA_PERMS = {Manifest.permission.CAMERA};
    int CAMERA_REQUEST = 1337;
    final int GELLARY_REQUEST = 1340;
    String[] GELLARY_PERMS = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    File file = null;
    private AwesomeValidation mAwesomeValidation=new AwesomeValidation(BASIC);;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_as_doctor);
        ButterKnife.bind(this);
        cropImageView.setCropMode(CropImageView.CropMode.CIRCLE);
        cropImageView.setVisibility(View.GONE);

   /*     setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.sign_up_as_doctor));
*/

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               checkValidity();
           /*   if (mAwesomeValidation.validate()) {

                    if(file==null)
                    {
                        buildDialog(R.style.DialogTheme, getResources().getString(R.string.selectimage));
                    }else
                    {
                        registerProvider();
                    }


                }*/

             Intent intent = new Intent(SignUpAsDoctorActivity.this, QualificationsActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();

            }
        });

        selectOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                croppedBitmap = (cropImageView.getCroppedBitmap());

                file = new File(getCacheDir(), "temp");
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }

//Convert bitmap to byte array

                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                croppedBitmap.compress(Bitmap.CompressFormat.PNG, 0, bos);
                byte[] bitmapdata = bos.toByteArray();

//write the bytes in file
                FileOutputStream fos = null;
                try {
                    fos = new FileOutputStream(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    fos.write(bitmapdata);
                    fos.flush();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                userImage.setImageBitmap(croppedBitmap);
                cropImageView.setVisibility(View.GONE);
                selectOk.setVisibility(View.GONE);

            }
        });

        uploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder getImageFrom = new AlertDialog.Builder(SignUpAsDoctorActivity.this);
                getImageFrom.setTitle(getResources().getString(R.string.selectimage));
                final CharSequence[] opsChars = {getResources().getString(R.string.takepicture), getResources().getString(R.string.opengallery)};
                getImageFrom.setItems(opsChars, new android.content.DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (which == 0) {

                            String file = System.currentTimeMillis() + ".jpg";
                            File newfile = new File(file);
                            try {
                                newfile.createNewFile();
                            } catch (IOException e) {
                                e.toString();
                            }

                            Uri outputFileUri = Uri.fromFile(newfile);
                            if (ContextCompat.checkSelfPermission(SignUpAsDoctorActivity.this, Manifest.permission.CAMERA) ==
                                    PackageManager.PERMISSION_GRANTED) {
                                intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(intent, 7);
                            } else {
                                ActivityCompat.requestPermissions(SignUpAsDoctorActivity.this, CAMERA_PERMS, CAMERA_REQUEST);
                            }


                        } else if (which == 1) {
                            if (ContextCompat.checkSelfPermission(SignUpAsDoctorActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                                    PackageManager.PERMISSION_GRANTED) {
                                Intent intent = new Intent();
                                intent.setType("image/*");
                                intent.setAction(Intent.ACTION_GET_CONTENT);
                                intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
                                startActivityForResult(Intent.createChooser(intent, "Open Gallery"), 6);
                            } else {
                                ActivityCompat.requestPermissions(SignUpAsDoctorActivity.this, GELLARY_PERMS, GELLARY_REQUEST);
                            }
                        }

                    }
                });

                getImageFrom.show();


            }
        });
    }


    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {

        if ((requestCode == 7 && resultCode == RESULT_OK) || (requestCode == 65543 && resultCode == RESULT_OK) || (requestCode == 327687 && resultCode == RESULT_OK) || (requestCode == 131079 && resultCode == RESULT_OK)) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            getImage(bitmap);

        } else if ((requestCode == 6 || requestCode == 65542 || requestCode == 131078 || requestCode == 393222 || requestCode == 393222 || requestCode == 262150) && resultCode == RESULT_OK) {
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
                Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());

                getImage(bitmap);


            }

        }
    }


    @Override
    public void onBackPressed() {


        if (cropImageView.getVisibility() == View.VISIBLE) {
            cropImageView.setVisibility(View.GONE);
            selectOk.setVisibility(View.GONE);
        } else {
            finish();
        }
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

    public void  checkValidity() {
        mAwesomeValidation.addValidation(this, R.id.edt_first_name, "[a-zA-Z\\s]+", R.string.enter_first_name);
        mAwesomeValidation.addValidation(this, R.id.edt_last_name, "[a-zA-Z\\s]+", R.string.enter_last_name);
        mAwesomeValidation.addValidation(this, R.id.edt_email, Patterns.EMAIL_ADDRESS, R.string.enter_valid_email);
        mAwesomeValidation.addValidation(this, R.id.edt_phone, RegexTemplate.TELEPHONE, R.string.enter_phone_number);
        mAwesomeValidation.addValidation(this, R.id.edt_zipcode, "\\d+", R.string.enter_zipcode);
        mAwesomeValidation.addValidation(this, R.id.edt_password, "[0-9a-zA-Z]+",R.string.enter_valid_password);
        mAwesomeValidation.addValidation(this, R.id.edt_address, "[0-9a-zA-Z #,-]+", R.string.enter_address);
        mAwesomeValidation.addValidation(this, R.id.edt_mode_of_transport,"[0-9a-zA-Z]+", R.string.enter_mode_of_transport);
        mAwesomeValidation.addValidation(this, R.id.edt_gdcno, "[0-9a-zA-Z]+", R.string.enter_gdcno);
        mAwesomeValidation.addValidation(this, R.id.edt_gmcno, "[0-9a-zA-Z]+", R.string.enter_gmcno);

    }


    private void registerProvider() {
        final ProgressDialog dialog = ShowConstantProgressNOTCAN(this, "", getResources().getString(R.string.registering));
        dialog.show();
        RequestBody fname = RequestBody.create(MediaType.parse("text/plain"), firstName.getText().toString());
        RequestBody lname = RequestBody.create(MediaType.parse("text/plain"), lastName.getText().toString());
        RequestBody mail = RequestBody.create(MediaType.parse("text/plain"), email.getText().toString());
        RequestBody pass = RequestBody.create(MediaType.parse("text/plain"), password.getText().toString());
        RequestBody mobile = RequestBody.create(MediaType.parse("text/plain"), phone.getText().toString());
        RequestBody zip = RequestBody.create(MediaType.parse("text/plain"), zipcode.getText().toString());
        RequestBody add = RequestBody.create(MediaType.parse("text/plain"), address.getText().toString());

        int licence = 0;
        if (isDrivingLicence.isChecked()) {
            licence = 1;
        } else {
            licence = 0;
        }
        RequestBody lice = RequestBody.create(MediaType.parse("text/plain"), String.valueOf(licence));
        RequestBody gd = RequestBody.create(MediaType.parse("text/plain"), gdcno.getText().toString());
        RequestBody gm = RequestBody.create(MediaType.parse("text/plain"), gmcno.getText().toString());
        RequestBody mode = RequestBody.create(MediaType.parse("text/plain"), modeOfTransport.getText().toString());
        RequestBody reqFile = RequestBody.create(MediaType.parse("image/*"), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("file", file.getName(), reqFile);

        Call<Provider> call = Helper.getBotoxApiService().registerProvider(fname, lname, mail, pass, mobile, add, zip, lice, gd, gm, mode, body);
        call.enqueue(new Callback<Provider>() {


            @Override
            public void onResponse(Call<Provider> call, Response<Provider> response) {
                dialog.dismiss();
                int statusCode = response.code();
                if (statusCode == 200) {
                    Provider provider = response.body();

                    Resource.providerToken = provider.getAccessToken();

                    addProviderTokenInSharedPreferences(Resource.providerToken);

                    Intent intent = new Intent(SignUpAsDoctorActivity.this, QualificationsActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();

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

    private void getImage(Bitmap bitmap) {


        cropImageView.setVisibility(View.VISIBLE);
        cropImageView.setImageBitmap(bitmap);
        selectOk.setVisibility(View.VISIBLE);
    }


}