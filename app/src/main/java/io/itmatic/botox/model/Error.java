package io.itmatic.botox.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Response;

/**
 * Created by Manoj on 4/14/2017.
 */

public class Error {

    private String code;
    private String message;

    public Error(String err)
    {


    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
