package io.itmatic.botox.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import io.itmatic.botox.BotoxApplication;
import io.itmatic.botox.Model.Provider;
import io.itmatic.botox.Provider.ProviderProfileActivity;
import io.itmatic.botox.R;


public class BookProviderAdapter extends RecyclerView.Adapter<BookProviderAdapter.ContactViewHolder> {

    private List<Provider> provider_list;
    private Context context;


    public BookProviderAdapter(Context context, List<Provider> contactList) {
        this.provider_list = contactList;
        this.context=context;
    }

    @Override
    public int getItemCount() {
        return provider_list.size();
    }

    View.OnClickListener getClickListener(final int position) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BotoxApplication.selectedProvider=provider_list.get(position);
                Intent intent=new Intent(context, ProviderProfileActivity.class);
                context.startActivity(intent);




            }
        };
    }


    @Override
    public void onBindViewHolder(ContactViewHolder contactViewHolder,final int i) {
        Provider provider = provider_list.get(i);

        contactViewHolder.textViewProviderName.setText(provider.getFullName());
        contactViewHolder.ratingBar.setRating(provider.getAverageRating());
        contactViewHolder.linearLayout.setOnClickListener(getClickListener(i));
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
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.provider_list, viewGroup, false);

        return new ContactViewHolder(itemView);
    }

    public  class ContactViewHolder extends RecyclerView.ViewHolder {

        TextView textViewProviderName;
        RatingBar ratingBar;
        ImageView imageViewUserImage;
        LinearLayout linearLayout;

        public ContactViewHolder(View v) {
            super(v);

            textViewProviderName=(TextView) v.findViewById(R.id.txt_provider_name);
            ratingBar=(RatingBar) v.findViewById(R.id.ratingbar);
            imageViewUserImage=(ImageView) v.findViewById(R.id.img_user_image);
            linearLayout=(LinearLayout) v.findViewById(R.id.lout_provider);

        }
    }

}
