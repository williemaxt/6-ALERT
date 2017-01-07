package com.example.solutions611.ereport;


/*below are the various imports needed*/

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.design.widget.FloatingActionButton;
import android.widget.ImageView;
import android.widget.Toast;



public class page1 extends AppCompatActivity {

    /*called when the activity is crated*/
    /*these are the buttons I am going to use */
    ImageView six;
    Button sendct1;
    Button sendct3;
    Button sendHeg;
    EditText emergencyMessage;
    FloatingActionButton squadResponse;


    String pyloNum = "5702043490";
    String prytanisNum = "6109725277";
    String hegNum ="4845388885";
    String six11 ="2158245998";
    String five83 = "2672806944";
    String five84 ="4849994349";
    String five87 = "2672946036";
    String five92 ="6102171667";
    String five97="5703170648";
    String six01 ="6107045249";
    String six02 ="6105544127";
    String six04 ="6105979056";
    String six05 = "6105339648";
    String six06 = "4845971226";
    String six07 = "4849080111";
    String six08 ="2674619672";
    String six09 = "2155892648";
    String eight23="5707728612";

    String palert = "6 ALERT Pylo Needed: ";
    String pralert = "6 ALERT Prytanis Needed: ";
    String hegalert = "6 ALERT Hegemon needed: ";
    String sqalert = "6 ALERT Imediate Response button Pressed: " ;








    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);
       // get the location permissions



        /** I have to assign the the buttons and fields with a value in this section     */

       sendct1 = (Button) findViewById(R.id.pyloBtn);
        sendct3 = (Button) findViewById(R.id.prytanisBtn);
        sendHeg = (Button) findViewById(R.id.bothBtn);
        emergencyMessage =  (EditText) findViewById(R.id.messagField);
       /* injuryToggle = (Button) findViewById(R.id.toggleButton4); */
        squadResponse = (FloatingActionButton) findViewById(R.id.fightBtn);
        six = (ImageView) findViewById(R.id.six);













        squadResponse.setOnClickListener(new View.OnClickListener(){
             @Override
             public void onClick(View v){
                 String theMessage = sqalert + emergencyMessage.getText().toString()  ;
                 switchActivity() ;
               /*  sendMessage(pyloNum, theMessage);
                 sendMessage(prytanisNum, theMessage);
                 sendMessage(hegNum, theMessage);
                 sendMessage(six11, theMessage);
                 sendMessage(five83, theMessage);
                 sendMessage(five84, theMessage);
                 sendMessage(five92, theMessage);
                 sendMessage(five97, theMessage);
                 sendMessage(six01, theMessage);
                 sendMessage(six02, theMessage);
                 sendMessage(six04, theMessage);
                 sendMessage(six05, theMessage);
                 sendMessage(six06, theMessage);
                 sendMessage(six07, theMessage);
                 sendMessage(six08, theMessage);
                 sendMessage(six09, theMessage);
                 sendMessage(five87, theMessage);
                 sendMessage(eight23, theMessage);
              */












             }
         });

        /* Im setting an OnClickListener for each of these above  buttons*/
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchActivity();
            }
        });


        sendHeg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String theMessage = hegalert + emergencyMessage.getText().toString();
                String TextNumber = hegNum;
                sendMessage(TextNumber, theMessage);

            }
        });

        sendct3.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View v){
               String theMessage = pralert + emergencyMessage.getText().toString();
               String TextNumber = prytanisNum;
               sendMessage(TextNumber, theMessage);
           }
        });
        sendct1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /* when the button is clicked it will send what was typed in the message box
                * to the number declared as pyloNum*/
                String theMessage = palert + emergencyMessage.getText().toString() ;
                String TextNumber =  pyloNum;
                sendMessage(TextNumber, theMessage );
            }

        });


        }

    private void switchActivity() {
        /*Switch the activity*/
        Intent changePage = new Intent(page1.this, MapsActivity.class);
        startActivity(changePage);
    }


    /*Creates a method called sendMessage to use the two above strings called
    * theMessage and pyloTextNumber*/
    protected void sendMessage(String TextNumber,  String theMessage){

        /*the below declarations are reports indicating sent and or delivered*/
        String SENT = "Message Sent";
        String DELIVERED = "Message Delivered";

         /*this code below is called an intent. this executes the Strings declard above*/
        PendingIntent sentPI = PendingIntent.getBroadcast(this,0, new Intent(SENT), 0);
        PendingIntent deiverdPI = PendingIntent.getBroadcast(this, 0, new Intent(DELIVERED), 0);

        registerReceiver(new BroadcastReceiver()
        {
            @Override
            public void onReceive(Context context, Intent intent) {

            }

            public void onRecieve(Context arg0, Intent arg1)
            {
                switch(getResultCode())
                {
                    case Activity.RESULT_OK:
                        Toast.makeText(page1.this, "SMS Sent!", Toast.LENGTH_LONG).show();
                        break;
                    case  SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                        Toast.makeText(page1.this, "Generic Failure", Toast.LENGTH_LONG).show();
                        break;
                    case SmsManager.RESULT_ERROR_NO_SERVICE:
                        Toast.makeText(page1.this, "No Service", Toast.LENGTH_LONG).show();
                        break;
                }
            }
        }, new IntentFilter(SENT));

        registerReceiver(new BroadcastReceiver()
        {
            @Override
            public void onReceive(Context context, Intent intent) {

            }

            public void onRecieve(Context arg0, Intent arg1)
            {
                switch (getResultCode())
                {
                    case Activity.RESULT_OK:
                        Toast.makeText(getBaseContext(), "SMS Delivered!", Toast.LENGTH_LONG).show();
                        break;
                    case  Activity.RESULT_CANCELED:
                        Toast.makeText(getBaseContext(), "SMS Not Delivered", Toast.LENGTH_LONG).show();
                        break;
                }
            }
        }, new IntentFilter(DELIVERED));

        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(TextNumber, null, theMessage, sentPI, deiverdPI);}







    }




