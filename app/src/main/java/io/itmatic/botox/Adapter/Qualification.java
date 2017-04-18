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


        public View getView(int position, View convertView, ViewGroup parent) {


            View v = convertView;


            if (v == null) {
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = inflater.inflate(R.layout.qualification_spinner_layout, null);
            }


            final Education ob = objects.get(position);

            if (ob != null) {

               /* final TextView rBANK=(TextView) v.findViewById(R.id.txt_bank);
                RelativeLayout rBANKLISTITEM=(RelativeLayout) v.findViewById(R.id.routbanklistitem);

                rBANK.setText(ob.getBank_name());*/
               TextView headrSpinner=(TextView) v.findViewById(R.id.text1);
                headrSpinner.setText(R.string.select_your_qualification);




            }


            return v;

        }

    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        final Education ob = objects.get(position);

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.spinner_drop_down, parent, false);

        TextView textViewQualification=(TextView) row.findViewById(R.id.txt_qualification);
        CheckBox checkBox=(CheckBox) row.findViewById(R.id.cb_qualification);

        textViewQualification.setText(ob.getDisplayName());


        return row;
    }


    }