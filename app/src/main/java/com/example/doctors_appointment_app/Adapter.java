package com.example.doctors_appointment_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public
class Adapter extends FirebaseRecyclerAdapter<info,Adapter.myViewHolder> {


    public
    Adapter ( @NonNull FirebaseRecyclerOptions<info> options ) {
        super ( options );
    }

    @Override
    public
    myViewHolder onCreateViewHolder ( @NonNull ViewGroup parent , int viewType ) {
       View v = LayoutInflater.from ( parent.getContext () ).inflate ( R.layout.design,parent,false );
       return  new myViewHolder ( v );
    }
    @NonNull
    @Override
    protected
    void onBindViewHolder ( @NonNull myViewHolder holder , int position , @NonNull info model ) {
    holder.name2.setText ( model.getName ());
    holder.surname2.setText ( model.getSurname ());
    holder.email2.setText ( model.getEmail ( ));
    holder.phone2.setText ( model.getPhone ());
    holder.city2.setText ( model.getCity ());
    holder.birth2.setText ( model.getBirthday ());
    }
   public class myViewHolder extends RecyclerView.ViewHolder{
        TextView name2,surname2,email2,phone2,birth2,city2;
        public
        myViewHolder ( @NonNull View itemView ) {
            super ( itemView );
            name2=itemView.findViewById ( R.id.name3 );
            surname2=itemView.findViewById ( R.id.surname3 );
            phone2=itemView.findViewById ( R.id.phone3);
            birth2=itemView.findViewById ( R.id.birth3 );
            city2=itemView.findViewById ( R.id.city3);
            email2=itemView.findViewById ( R.id.email3 );

        }


    }
}
