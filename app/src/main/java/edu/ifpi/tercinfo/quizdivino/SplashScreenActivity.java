package edu.ifpi.tercinfo.quizdivino;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SplashScreenActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        if((getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE)!= 0){
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {


                    Intent intent = new Intent(SplashScreenActivity.this, DebugActivity.class);
                    startActivity(intent);
                }
            }, 3000);
        }else{
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    int data = 0;

                    Calendar calendar  = Calendar.getInstance();
                    SimpleDateFormat mdFormart = new SimpleDateFormat("dd/MM/yyyy");
                    String strDate = mdFormart.format(calendar.getTime());
                    if(strDate.equals("18/12/2018")){
                        data = 1;
                    }else if(strDate.equals("19/12/2018")){
                        data = 2;
                    }else if (strDate.equals("20/12/2018")){
                        data = 3;
                    }
                    if(data != 0){
                        Intent intent = new Intent(SplashScreenActivity.this, StartActivity.class);
                        intent.putExtra("dia", data);
                        startActivity(intent);
                    }else{
                        Intent intent = new Intent(SplashScreenActivity.this, WaitActivity.class);
                        startActivity(intent);
                    }

                }
            }, 3000);

        }
    }
}
