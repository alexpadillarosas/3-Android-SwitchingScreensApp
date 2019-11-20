package com.example.android.myswitchingscreenapp;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.myswitchingscreenapp.Constants.SECOND_SCREEN_REQUEST_CODE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onGetNameClick(View view){
        //state our intention (I want to do this... )
        Intent getNameScreenIntent = new Intent(this, SecondActivity.class);


        //make a key value pair, key called callingActivity, and value is a string literal here 'MainActivity', but it can be anything
        getNameScreenIntent.putExtra("callingActivity", "MainActivity");

        //if we don't care about getting data back from second screen, kick it off like this:
        //startActivity(getNameScreenIntent);

        // or, if you're expecting results back
        // For example suppose you want to select a picture from a gallery and set is as your dp.
        // Then for these kind of purpose you use startActivityForResult().
        startActivityForResult(getNameScreenIntent, SECOND_SCREEN_REQUEST_CODE);

    }

    //right click generate and Override method

    //This is always called when the child activity closes ( you only needed if you started the Activity using startActivityForResult
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //this method gets called when the intent we kicked off is finished
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == SECOND_SCREEN_REQUEST_CODE){
            //check if result was fine, could have been cancelled, if so the result code will be RESULT_CANCELED
            if(resultCode == RESULT_OK){
                TextView usersNameMessage = findViewById(R.id.users_name_message);//this textView is in activity_main
                String nameSentBack = data.getStringExtra("UserName"); // data is where those extra values are now (which is an Intent anyway)

                usersNameMessage.setText(getString(R.string.pre_text_user_name) + " " + nameSentBack);
            }
            else if (resultCode == RESULT_CANCELED){
                Toast.makeText(this, "maybe you forgot to set the data back, check your child setResult() ", Toast.LENGTH_SHORT).show();

            }
        }else{
            Toast.makeText(this, "wrong request code come back? requestCode: " + requestCode, Toast.LENGTH_SHORT).show();
        }

    }
}
