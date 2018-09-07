package com.example.mk.covfefe;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class WaitActivity extends AppCompatActivity {

    NotificationCompat.Builder notification;
    MediaPlayer bg;
    public int counter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wait);

        //Background music
        bg = MediaPlayer.create(WaitActivity.this,R.raw.purpose);

        //Timer
        final TextView label = (TextView) findViewById(R.id.timerText);
        new CountDownTimer(61000,1000){
            public void onTick(long millisUntilFinish){
                label.setText(String.valueOf(counter));
                counter++;
            }

            public void onFinish() {
                addNotification();
            }
        }.start();


    }
    private void addNotification() {
        // Build notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle("Your CovFeFe is ready!")
                .setContentText("CovFeFe!");

        // Intent to show notification
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }

    public void playBG(View v) {
        bg.start();
    }
    }

