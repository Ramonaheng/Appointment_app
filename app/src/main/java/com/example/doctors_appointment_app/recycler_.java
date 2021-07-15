package com.example.doctors_appointment_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public
class recycler_ extends AppCompatActivity {
    RecyclerView recview1;
    Adapter adapter;

    @Override
    protected
    void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        recview1 = findViewById ( R.id.recview );
        recview1.setLayoutManager ( new LinearLayoutManager ( this ) );
        setContentView ( R.layout.activity_recycler_ );
        FirebaseRecyclerOptions<info> options =
                new FirebaseRecyclerOptions.Builder<info>()
                        .setQuery( FirebaseDatabase.getInstance ().getReference ("Patients"),info.class )
                        .build();
        adapter=new Adapter ( options );
        recview1.setAdapter ( adapter );
        }

        @Override
        protected void onStart() {
            super.onStart();
            adapter.startListening();
        }

        @Override
        protected void onStop() {
        super.onStop();
        adapter.stopListening();


    }
}