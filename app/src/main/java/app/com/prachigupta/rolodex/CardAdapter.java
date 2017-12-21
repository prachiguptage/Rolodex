package app.com.prachigupta.rolodex;


import android.content.Context;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CardAdapter  extends RecyclerView.Adapter<CardAdapter.CardViewHolder>{

    List <CardModel> cardModels;
    Context context;


    public CardAdapter (List<CardModel> carModels, Context context){

        this.cardModels = carModels;
        this.context = context;

    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_layout,parent,false);
        CardViewHolder holder = new CardViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {

        CardModel model = cardModels.get(position);

        String source = "<b>First Name</b> :"+model.getFirstName();
        if (Build.VERSION.SDK_INT >= 24) {
            holder.first.setText(Html.fromHtml(source,1)); // for 24 api and more
        } else {
            holder.first.setText(Html.fromHtml(source)); // or for older api
        }

        source = "<b>Last Name</b> :"+model.getLastName();
        if (Build.VERSION.SDK_INT >= 24) {
            holder.last.setText(Html.fromHtml(source,1)); // for 24 api and more
        } else {
            holder.last.setText(Html.fromHtml(source)); // or for older api
        }


        source = "<b>Email</b> :"+model.getEmail();
        if (Build.VERSION.SDK_INT >= 24) {
            holder.email.setText(Html.fromHtml(source,1)); // for 24 api and more
        } else {
            holder.email.setText(Html.fromHtml(source)); // or for older api
        }

        source = "<b>Company</b> :"+model.getCompany();
        if (Build.VERSION.SDK_INT >= 24) {
            holder.company.setText(Html.fromHtml(source,1)); // for 24 api and more
        } else {
            holder.company.setText(Html.fromHtml(source)); // or for older api
        }

        source = "<b>Start Date </b> :"+model.getStartDate();
        if (Build.VERSION.SDK_INT >= 24) {
            holder.date.setText(Html.fromHtml(source,1)); // for 24 api and more
        } else {
            holder.date.setText(Html.fromHtml(source)); // or for older api
        }

        source = "<b>Bio</b> :"+formatString(model.getBio());
        if (Build.VERSION.SDK_INT >= 24) {
            holder.bio.setText(Html.fromHtml(source,1)); // for 24 api and more
        } else {
            holder.bio.setText(Html.fromHtml(source)); // or for older api
        }


        String avatar = model.getAvatar();

        Picasso.with(context).load(avatar).into(holder.avatar);

    }

    @Override
    public int getItemCount() {
        return cardModels.size();
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView first;
        TextView last;
        TextView company;
        TextView  email;
        TextView date;
        TextView bio;
        ImageView avatar;

        CardViewHolder(View itemView){
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.cardView);
            first =(TextView)itemView.findViewById(R.id.first);
            last =(TextView)itemView.findViewById(R.id.last);
            email =(TextView)itemView.findViewById(R.id.email);
            company =(TextView)itemView.findViewById(R.id.company);
            date =(TextView)itemView.findViewById(R.id.date);
            bio =(TextView)itemView.findViewById(R.id.bio);
            avatar = (ImageView)itemView.findViewById(R.id.avatar);

        }
    }

    private String formatString(String s) {



        boolean boldFlag = true;

        boolean italicsFlg = true;

        char[] stringArray = s.toCharArray();

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < stringArray.length; i++) {



            if(stringArray[i] == '*'){

                if(boldFlag){

                    builder.append("<b>");



                }

                else{

                    builder.append("</b>");

                }

                boldFlag = !boldFlag;

            }



            else if(stringArray[i] == '_'){

                if(italicsFlg){

                    builder.append("<i>");



                }

                else{

                    builder.append("</i>");

                }

                italicsFlg = !italicsFlg;

            }

            else{

                builder.append(stringArray[i]);

            }

        }

        return builder.toString();

    }
}
