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

import io.itmatic.botox.Model.Provider;
import io.itmatic.botox.R;


public class ProviderAdapter extends RecyclerView.Adapter<ProviderAdapter.ContactViewHolder> {

    private List<Provider> provider_list;
    private Context context;


    public ProviderAdapter(Context context, List<Provider> contactList) {
        this.provider_list = contactList;
        this.context=context;
    }

    @Override
    public int getItemCount() {
        return provider_list.size();
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
        Provider provider = provider_list.get(i);

        contactViewHolder.textViewProviderName.setText(provider.getFullName());
        contactViewHolder.textViewDate.setText(provider.getDob());
        Glide.with(context).load(provider.getImageUrl()).placeholder(R.drawable.ic_dummy_user).dontAnimate().into(contactViewHolder.imageViewUserImage);


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
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.provider_item_layout, viewGroup, false);

        return new ContactViewHolder(itemView);
    }

    public  class ContactViewHolder extends RecyclerView.ViewHolder {

        TextView textViewProviderName;
        TextView textViewDate;
        ImageView imageViewUserImage;

        public ContactViewHolder(View v) {
            super(v);

            textViewProviderName=(TextView) v.findViewById(R.id.txt_provider_name);
            textViewDate=(TextView) v.findViewById(R.id.txt_date);
            imageViewUserImage=(ImageView) v.findViewById(R.id.img_user_image);

        }
    }

}
