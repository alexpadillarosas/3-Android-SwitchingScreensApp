package com.example.android.myswitchingscreenapp;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent activityThatCalled = getIntent();//gets the intent that made this activity

        //get value out of passed on extras with key 'callingActivity'
        String previousActivity = activityThatCalled.getExtras().getString("callingActivity");

        TextView callingActivityMessage = (TextView) findViewById(R.id.calling_activity_info_text_view);

        callingActivityMessage.append(previousActivity); //set the textView to whatever the prev activity was called (based on what we passed in extras)


    }

    public void onSendUserName(View view){
        EditText userNameEditText = findViewById(R.id.user_name_edit_text);
        //if it doesnt work try this:  String userName = String.valueOf(usersNameET.getText());
        String userName = userNameEditText.getText().toString();

        if(userName.isEmpty()){
            Snackbar.make(view, "Input the name", Snackbar.LENGTH_SHORT).show();
            return;
        }

        Intent goingBackIntent = new Intent();

        goingBackIntent.putExtra("UserName", userName);

        //saying that when this activity ends, its under good intentions (not an error etc)
        //watch out, if you forget to set the result back your parent window will get by default
        //RESULT_CANCELED
        setResult(RESULT_OK, goingBackIntent);

        finish(); // ends the activity

    }


}
