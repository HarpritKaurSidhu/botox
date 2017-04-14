package io.itmatic.botox.Retrofit;

import java.io.File;
import java.lang.annotation.Annotation;

import io.itmatic.botox.model.Provider;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface BotoxApiInterface {

    @Headers("Accept: application/json")
    @Multipart
    @POST("provider/register.json")
    Call<Provider> registerProvider(@Part("firstName") RequestBody firstName, @Part("lastName") RequestBody lastName, @Part("email") RequestBody email, @Part("password") RequestBody password, @Part("phone") RequestBody phone, @Part("address") RequestBody  address,@Part("zipcode") RequestBody zipcode, @Part("is_driving_licence") RequestBody  isDrivingLicence, @Part("gdcno") RequestBody gdcno, @Part("gmcno") RequestBody  gmcno, @Part("mode_of_transport") RequestBody  modeoftransport,@Part MultipartBody.Part image );

    @Headers("Accept: application/json")
    @FormUrlEncoded
    @POST("provider/login.json")
    Call<Provider> loginProvider(@Field("email") String email, @Field("password") String password);

}