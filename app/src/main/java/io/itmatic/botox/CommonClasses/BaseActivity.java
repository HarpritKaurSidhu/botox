package io.itmatic.botox.CommonClasses;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;

public class BaseActivity extends ActionBarActivity {

    public static ProgressDialog ShowConstantProgressNOTCAN(Context context, String Title, String Message) {
        ProgressDialog dialog = new ProgressDialog(context);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMax(100);
        dialog.setIndeterminate(false);
        if (Title.equals(null) || Title.equals("")) {

        } else {
            dialog.setTitle(Title);
        }
        dialog.setMessage(Message);
        dialog.setCancelable(false);
        return dialog;
    }


    public void showerror(String error) {
        new AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage(error)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                    }
                })

                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }


    public void addInSharedPrefrences(String token) {
        SharedPreferences.Editor editor = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE).edit();
        editor.putString("token", token);
        editor.apply();
    }
}