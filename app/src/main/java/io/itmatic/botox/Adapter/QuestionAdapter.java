package io.itmatic.botox.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

import io.itmatic.botox.Common.BaseActivity;
import io.itmatic.botox.Model.Education;
import io.itmatic.botox.Model.Question;
import io.itmatic.botox.R;


public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ContactViewHolder> {

        private List<Question> questions_list;
        private  Context context;


        public QuestionAdapter(List<Question> contactList) {
            this.questions_list = contactList;
        }

        @Override
        public int getItemCount() {
            return questions_list.size();
        }

     /* View.OnClickListener getClickListener(final int position) {
            return new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // ((MainActivity) getActivity()).replaceFragment(new MapViewFragment());

                    if(.isChecked())
                    {
                        education_list.get(position).setSelectCourse(true);
                    }else {
                        education_list.get(position).setSelectCourse(false);
                    }


                }
            };
        }*/


        @Override
        public void onBindViewHolder(final ContactViewHolder contactViewHolder, final int i) {
            Question ci = questions_list.get(i);
            contactViewHolder.textViewQuestion.setText(ci.getQuestion());

            contactViewHolder.checkBoxYes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(contactViewHolder.checkBoxYes.isChecked())
                    {
                        if(contactViewHolder.checkBoxNo.isChecked()) {
                            contactViewHolder.checkBoxNo.setChecked(false);
                            questions_list.get(i).setYes(true);
                            questions_list.get(i).setNo(false);
                        }else
                        {
                            questions_list.get(i).setYes(true);
                            questions_list.get(i).setNo(false);
                        }
                    }
                    else{
                        if(!contactViewHolder.checkBoxNo.isChecked()) {
                            contactViewHolder.checkBoxNo.setChecked(true);
                            questions_list.get(i).setYes(false);
                            questions_list.get(i).setNo(true);
                        }
                        else
                        {
                            questions_list.get(i).setYes(false);
                            questions_list.get(i).setNo(true);
                        }
                    }



                }
            });

            contactViewHolder.checkBoxNo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    if(contactViewHolder.checkBoxNo.isChecked())
                    {
                        if(contactViewHolder.checkBoxYes.isChecked()) {
                            contactViewHolder.checkBoxYes.setChecked(false);
                            questions_list.get(i).setNo(true);
                            questions_list.get(i).setYes(false);
                        }else
                        {
                            questions_list.get(i).setNo(true);
                            questions_list.get(i).setYes(false);
                        }
                    }
                    else{
                        if(!contactViewHolder.checkBoxYes.isChecked()) {
                            contactViewHolder.checkBoxYes.setChecked(true);
                            questions_list.get(i).setNo(false);
                            questions_list.get(i).setYes(true);
                        }
                        else
                        {
                            questions_list.get(i).setNo(false);
                            questions_list.get(i).setYes(true);
                        }
                    }

                }
            });

         /*   contactViewHolder.checkBoxNo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(contactViewHolder.checkBoxNo.isChecked())
                    {
                        questions_list.get(i).setNo(true);
                    }
                    else{
                        questions_list.get(i).setNo(true);
                    }



                }
            });*/










        }

        @Override
        public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.question_layout, viewGroup, false);

            return new ContactViewHolder(itemView);
        }

        public  class ContactViewHolder extends RecyclerView.ViewHolder {
            private TextView textViewQuestion;
            private CheckBox checkBoxYes;
            private CheckBox checkBoxNo;


            public ContactViewHolder(View v) {
                super(v);
                textViewQuestion=(TextView) v.findViewById(R.id.txt_question);
                checkBoxYes=(CheckBox) v.findViewById(R.id.cb_yes);
                checkBoxNo=(CheckBox) v.findViewById(R.id.cb_no);

            }
        }

    }
