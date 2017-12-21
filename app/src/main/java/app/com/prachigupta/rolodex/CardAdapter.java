package app.com.prachigupta.rolodex;


import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
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

        holder.first.setText("First Name :"+model.getFirstName());
        holder.last.setText("Last Name :"+model.getLastName());
        holder.email.setText("Email :"+model.getEmail());
        holder.company.setText("Company :"+model.getCompany());
        holder.date.setText("Start Date :"+model.getStartDate());
        holder.bio.setText("Bio :"+model.getBio());

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
}
