package io.itmatic.botox.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import io.itmatic.botox.Model.Patient;
import io.itmatic.botox.R;


public class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.ContactViewHolder> {

        private List<Patient> patient_list;
        private Context context;


        public PatientAdapter(Context context, List<Patient> contactList) {
            this.patient_list = contactList;
            this.context=context;
        }

        @Override
        public int getItemCount() {
            return patient_list.size();
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
            Patient patient = patient_list.get(i);

            contactViewHolder.textViewPatientName.setText(patient.getFullName());
            contactViewHolder.textViewDate.setText(patient.getDob());
            Glide.with(context).load(patient.getImageUrl()).placeholder(R.drawable.ic_dummy_user).dontAnimate().into(contactViewHolder.imageViewUserImage);


           /* contactViewHolder.textViewQualification.setText(.getTitle());

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

*/

            //set a category name on largeplayer






        }

        @Override
        public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.patient_item_layout, viewGroup, false);

            return new ContactViewHolder(itemView);
        }

        public  class ContactViewHolder extends RecyclerView.ViewHolder {

            TextView textViewPatientName;
            TextView textViewDate;
            ImageView imageViewUserImage;

            public ContactViewHolder(View v) {
                super(v);

                   textViewPatientName=(TextView) v.findViewById(R.id.txt_patient_name);
                   textViewDate=(TextView) v.findViewById(R.id.txt_date);
                   imageViewUserImage=(ImageView) v.findViewById(R.id.img_user_image);

            }
        }

    }
