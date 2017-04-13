package io.itmatic.botox.Retrofit;

import java.io.File;
import java.lang.annotation.Annotation;

import io.itmatic.botox.model.Provider;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface BotoxApiInterface {

    @Headers("Accept: application/json")
    @FormUrlEncoded
    @POST("provider/register.json")
    Call<Provider> registerProvider(@Field("firstName") String firstName, @Field("lastName") String lastName, @Field("email") String email, @Field("password") String password, @Field("phone") String phone, @Field("address") String address,@Field("zipcode") String zipcode, @Field("is_driving_licence") int isDrivingLicence, @Field("gdcno") String gdcno, @Field("gmcno") String gmcno, @Field("gdcno") String mode_of_transport,@Field("file") File file);


}