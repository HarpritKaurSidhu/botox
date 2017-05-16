package io.itmatic.botox.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import io.itmatic.botox.Model.Chat;
import io.itmatic.botox.R;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ContactViewHolder> { // recycledapter is a type of adapter  it also include recycle


        private ArrayList<Chat> chatList;
    private boolean chooselayout=false;

        // private List<SongDetail> songdet;

        public ChatAdapter(ArrayList<Chat> contactList) {
            this.chatList = contactList;
        }


        @Override
        public int getItemCount() {

            return chatList.size();
        }




    @Override
        public void onBindViewHolder(ContactViewHolder contactViewHolder, final int i) {


            Chat message = chatList.get(i);
            if (chooselayout == true) {

                contactViewHolder.message.setText(message.getMessage().trim());
            } else {


                contactViewHolder.responsemessage.setText(message.getMessage().trim());

            }

        }

        @Override
        public int getItemViewType(int position) {

            if (chatList.get(position).isSendByMe()) {
              chooselayout=true;

                return 0;

            }

            chooselayout=false;
            return 1;
        }

        @Override
        public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

            View itemView;
            if (viewType == 0) {
                itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sendermessagelayout, viewGroup, false);
                chooselayout = true;
                // TextView sender=(TextView) itemView.findViewById(R.id.sendermessage);


            } else {


                itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.receivermessagelayout, viewGroup, false);
                chooselayout = false;
            }
            return new ContactViewHolder(itemView);


        }

        public class ContactViewHolder extends RecyclerView.ViewHolder {

            private TextView message, responsemessage;

            public ContactViewHolder(View v) {
                super(v);
                if (chooselayout == true) {
                    // cardviewlayout = (CardView) v.findViewById(R.id.send_query_card);
                    message = (TextView) v.findViewById(R.id.sendermessage);
                } else {

                    //  responsecardviewlayout = (CardView) v.findViewById(R.id.response_query_card);
                    responsemessage = (TextView) v.findViewById(R.id.receivermessage);

                }
            }
        }
    }