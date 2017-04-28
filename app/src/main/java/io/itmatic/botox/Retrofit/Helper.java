package io.itmatic.botox.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hardeep on 14/03/17.
 */

public class Helper {

    public static BotoxApiInterface getBotoxApiService() {
        Retrofit retrofit = new Retrofit.Builder()

                .baseUrl("http://192.168.8.20:8080/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BotoxApiInterface BotoxApiService = retrofit.create(BotoxApiInterface.class);
        return BotoxApiService;
    }

}