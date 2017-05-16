package io.itmatic.botox;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.itmatic.botox.Adapter.ChatAdapter;
import io.itmatic.botox.Adapter.QualificationAdapter;
import io.itmatic.botox.Common.BaseActivity;
import io.itmatic.botox.Model.Chat;
import io.itmatic.botox.Model.Education;
import io.itmatic.botox.Provider.QualificationsActivity;
import io.itmatic.botox.Retrofit.Helper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChatActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rvmessages)
    RecyclerView recyclerView;
    @BindView(R.id.help_inputMsg)
    EditText messageBox;
    @BindView(R.id.send_msg_progress)
    ProgressBar progressBar;
    @BindView(R.id.help_btnSend)
    Button send;
    @BindView(R.id.llMsgCompose)
    LinearLayout lout_send;
    Timer timer;
    ChatAdapter adapter;
    ArrayList<Chat>  chatMessages=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ButterKnife.bind(this);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.getPaddingLeft();
        mLayoutManager.setStackFromEnd(true);

        //  LinearLayoutManager llm = new LinearLayoutManager(this);//linear layout is a  subclass of layout manager
        recyclerView.setLayoutManager(mLayoutManager);

        timer=new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                getmessage(3,5);

            }
        }, 0, 10000);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (messageBox.getText().toString() == "" || messageBox.getText().toString() == null || messageBox.getText().toString().equals(null) || messageBox.getText().toString().equals("")) {

                } else {
                    send.setVisibility(View.GONE);
                    progressBar.setVisibility(View.VISIBLE);


                    Chat message = new Chat();
                    message.setMessage(messageBox.getText().toString());
                    message.setSendByMe(true);
                    message.setCreatedAt(new Date().toString());
                   // Resource.MyMessages.add(message);

                    String msg = messageBox.getText().toString();
                    messageBox.setText("");

                    sendMessages(3, 5, msg);

                }

            }

        });



    }

    private void getmessage(int id,int recipientid)
    {
        /*final ProgressDialog dialog = ShowConstantProgressNOTCAN(this, "", getResources().getString(R.string.processing));
        dialog.show();*/
        Call<ArrayList<Chat>> call = Helper.getBotoxApiService().getMessage(id,recipientid);

        call.enqueue(new Callback<ArrayList<Chat>>() {
            @Override
            public void onResponse(Call<ArrayList<Chat>> call, Response<ArrayList<Chat>> response) {

               // dialog.dismiss();
                int statusCode = response.code();
                if (statusCode == 200) {

                   chatMessages=response.body();

                    adapter=new ChatAdapter(chatMessages);
                    recyclerView.setAdapter(adapter);

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
            public void onFailure(Call<ArrayList<Chat>> call, Throwable t) {
                t.toString();
                //dialog.dismiss();
            }


        });


    }


    private void sendMessages(int id,int rid, String message)
    {

        Call<Chat> call = Helper.getBotoxApiService().sendPatientMessage(id,rid,message);

        call.enqueue(new Callback<Chat>() {
            @Override
            public void onResponse(Call<Chat> call, Response<Chat> response) {
                progressBar.setVisibility(View.GONE);
                send.setVisibility(View.VISIBLE);

                int statusCode = response.code();
                if (statusCode == 200) {

                    Chat chat=response.body();
                       chatMessages.add(chat);
                    adapter=new ChatAdapter(chatMessages);
                    recyclerView.setAdapter(adapter);

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
            public void onFailure(Call<Chat> call, Throwable t) {
             t.toString();
                progressBar.setVisibility(View.GONE);
                send.setVisibility(View.VISIBLE);

            }


        });







    }
}
