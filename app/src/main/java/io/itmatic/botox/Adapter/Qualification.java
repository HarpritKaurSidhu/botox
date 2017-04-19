package io.itmatic.botox.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import io.itmatic.botox.R;
import io.itmatic.botox.model.Education;


public class Qualification extends ArrayAdapter<Education> {

        // declaring our ArrayList of items
        private List<Education> objects;


        public Qualification(Context context, int textViewResourceId, List<Education> objects) {
            super(context, textViewResourceId, objects);
            this.objects = objects;
        }


        public View getView(final int position, View convertView, ViewGroup parent) {


            View v = convertView;


            if (v == null) {
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = inflater.inflate(R.layout.qualification_layout, null);
            }


            final Education ob = objects.get(position);

            if (ob != null) {

               /* final TextView rBANK=(TextView) v.findViewById(R.id.txt_bank);
                RelativeLayout rBANKLISTITEM=(RelativeLayout) v.findViewById(R.id.routbanklistitem);

                rBANK.setText(ob.getBank_name());*/
                TextView textViewQualification=(TextView) v.findViewById(R.id.txt_qualification);
                final CheckBox checkBox=(CheckBox) v.findViewById(R.id.cb_qualification);

                 checkBox.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View view) {
                         if(checkBox.isChecked())
                         {
                             objects.get(position).setSelectCourse(true);
                         }else {
                             objects.get(position).setSelectCourse(false);
                         }

                     }
                 });

                textViewQualification.setText(ob.getTitle());





            }


            return v;

        }



    }