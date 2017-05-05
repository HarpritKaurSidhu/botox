package io.itmatic.botox.Retrofit;

import java.util.ArrayList;
import java.util.List;

import io.itmatic.botox.Model.Area;
import io.itmatic.botox.Model.Education;
import io.itmatic.botox.Model.Patient;

import io.itmatic.botox.Model.Provider;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface BotoxApiInterface {

    @Headers("Accept: application/json")
    @Multipart
    @POST("provider/register.json")
    Call<Provider> registerProvider(@Part("firstName") RequestBody firstName, @Part("lastName") RequestBody lastName, @Part("email") RequestBody email, @Part("password") RequestBody password, @Part("phone") RequestBody phone, @Part("address") RequestBody  address, @Part("zipcode") RequestBody zipcode, @Part("is_driving_licence") RequestBody  isDrivingLicence, @Part("gdcno") RequestBody gdcno, @Part("gmcno") RequestBody  gmcno, @Part("mode_of_transport") RequestBody  modeOfTransport, @Part MultipartBody.Part image );

    @Headers("Accept: application/json")
    @FormUrlEncoded
    @POST("provider/login.json")
    Call<Provider> loginProvider(@Field("email") String email, @Field("password") String password);

    @Headers("Accept: application/json")
    @FormUrlEncoded
    @POST("user/reset.json")
    Call<String> resetProviderPassword(@Field("email") String email);

    @Headers("Accept: application/json")
    @FormUrlEncoded
    @POST("near/by/provider.json")
    Call<List<Provider>> getAvailableProvider(@Field("post_code") String postcode,@Field("date") String date,@Field("time") String time);
    @Headers("Accept: application/json")
    @FormUrlEncoded
    @POST("user/login.json")
    Call<Patient> loginPatient(@Field("email") String email, @Field("password") String password);

    @Headers("Accept: application/json")
    @FormUrlEncoded
    @POST("near/by/provider.json")
    Call<List<Provider>> setPostCode(@Field("post_code") String postcode, @Field("token") String token);


    @GET("provider/profile.json")
    Call<Provider> providerProfile(@Query("token") String token);

    @GET("area/all.json")
    Call<List<Area>> getPatientArea();


    @GET("user/profile.json")
    Call<Patient> patientProfile(@Query("token") String token);

    @GET("provider/all/qualification/list.json")
    Call<ArrayList<Education>> qualificationList();


    @Headers("Accept: application/json")
    @FormUrlEncoded
    @POST("provider/education.json")
    Call<Provider> setQualification(@Field("token") String token,@Field("education") String education);

    @Headers("Accept: application/json")
    @FormUrlEncoded
    @POST(" provider/work/conditions.json")
    Call<Provider> setWorkingTime(@Field("token") String token,@Field("schedule") String schedule);

    @Headers("Accept: application/json")
    @Multipart
    @POST("provider/document/uploads.json")
    Call<Provider> uploadProviderDocument(@Part("token") RequestBody token,@Part("type") RequestBody type,@Part MultipartBody.Part file );


    @Headers("Accept: application/json")
    @Multipart
    @POST("user/register.json")
    Call<Patient> registerPatient(@Part("firstName") RequestBody firstName, @Part("lastName") RequestBody lastName, @Part("email") RequestBody email, @Part("password") RequestBody password,@Part("dob") RequestBody dob, @Part("address") RequestBody  address, @Part("phone") RequestBody phone, @Part("notes") RequestBody  notes,@Part MultipartBody.Part image );





}