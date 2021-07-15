package com.example.doctors_appointment_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public
class MainActivity extends AppCompatActivity {

    EditText name1,surname1,email1,phone1,birth1,city1;
    Button sub,retreive;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected
    void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        name1=findViewById ( R.id.name );
        surname1=findViewById ( R.id.surname );
        email1=findViewById ( R.id.email );
        phone1=findViewById ( R.id.phone);
        birth1=findViewById ( R.id.Birth);
        city1=findViewById ( R.id.city );
        sub=findViewById ( R.id.submit );
        retreive=findViewById ( R.id.appointment );


        retreive.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public
            void onClick ( View view ) {

                rootNode  = FirebaseDatabase.getInstance ( );
                reference = rootNode.getReference ( " BK" );

                Intent intent= new Intent ( MainActivity.this,recycler_.class );
                startActivity ( intent );
            }
        } );


        Calendar calendar =Calendar.getInstance ();
        final  int YEAR= calendar.get ( Calendar.YEAR );
        final  int MONTH= calendar.get ( Calendar.MONTH );
        final  int DAY = calendar.get ( Calendar.DAY_OF_MONTH);




        birth1.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public
            void onClick ( View view ) {
                DatePickerDialog datePickerDialog = new DatePickerDialog ( MainActivity.this, new DatePickerDialog.OnDateSetListener ( ) {
                    @Override
                    public
                    void onDateSet ( DatePicker datePicker , int year, int month , int day ) {

                        month=month+1;
                        String date=day+"/"+month+"/"+year;
                        birth1.setText ( date );
                    }},YEAR, MONTH, DAY);
                datePickerDialog.show ();
            }
        } );

        sub.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public
            void onClick ( View view ) {
                rootNode  = FirebaseDatabase.getInstance ( );
                reference = rootNode.getReference ( " BK" );

                // get all values
                String name    = name1.getText ( ).toString ( ).trim ( );
                String surname = surname1.getText ( ).toString ( ).trim ( );
                String email   = email1.getText ( ).toString ( ).trim ( );
                String phone   = phone1.getText ( ).toString ( ).trim ( );
                String Birth   = birth1.getText ( ).toString ( ).trim ( );
                String city    = city1.getText ( ).toString ( ).trim ( );

                //FirebaseDatabase.getInstance ().getReference ().child ( "Program" ).child ( " Africa" ).setValue ( " Mew" );
                info information= new info ( name , surname , email , phone , Birth , city );
                reference.child ( name ).setValue ( information );

                if(name.isEmpty())
                {
                    name1.setError ( "Name Required" );
                    name1.requestFocus ();

                    return;
                }

                if(email.isEmpty())
                {
                    email1.setError ( "Email Required" );
                    email1.requestFocus ();
                    return;
                }

                if(! Patterns.EMAIL_ADDRESS.matcher ( email ).matches ())
                {
                    email1.setError ( "Please enter a valid email address " );
                    email1.requestFocus ();
                    return;
                }
                if(surname.isEmpty())
                {
                    surname1.setError ( "Surname Required" );
                    surname1.requestFocus ();
                    return;
                }
                if(phone.isEmpty())
                {
                    phone1.setError ( "Phone Required" );
                    phone1.requestFocus ();
                    return;
                }
                if(Birth.isEmpty())
                {
                    birth1.setError ( "Birthday Required" );
                    birth1.requestFocus ();
                    return;
                }
                if(city.isEmpty()) {
                    city1.setError ( "City Required" );
                    city1.requestFocus ( );
                    return;

                }
                Toast.makeText ( MainActivity.this , "APPOINTMENT ADDED SUCCESSFULL" , Toast.LENGTH_SHORT ).show ( );
            }


            });
        }}