package io.itmatic.botox.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

import io.itmatic.botox.Model.Education;
import io.itmatic.botox.R;



public class Qualification extends RecyclerView.Adapter<Qualification.ContactViewHolder> { // recycledapter is a type of adapter  it also include recycle

        private List<Education> education_list;


        public Qualification(List<Education> contactList) {
            this.education_list = contactList;
        }

        @Override
        public int getItemCount() {
            return education_list.size();
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
        public void onBindViewHolder(ContactViewHolder contactViewHolder,final int i) {
            Education ci = education_list.get(i);

            contactViewHolder.textViewQualification.setText(ci.getTitle());

             contactViewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                 @Override
                 public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                     if(b)
                     {
                         education_list.get(i).setSelectCourse(true);
                     }else
                     {
                         education_list.get(i).setSelectCourse(true);
                     }

                 }
             });



            //set a category name on largeplayer






        }

        @Override
        public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.qualification_layout, viewGroup, false);

            return new ContactViewHolder(itemView);
        }

        public  class ContactViewHolder extends RecyclerView.ViewHolder {
            private TextView textViewQualification;
            private CheckBox checkBox;


            public ContactViewHolder(View v) {
                super(v);
                textViewQualification=(TextView) v.findViewById(R.id.txt_qualification);
                checkBox=(CheckBox) v.findViewById(R.id.cb_qualification);


            }
        }

    }
