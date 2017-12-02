package x14331851.student.ncirl.ie.arcoapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LogoScreenActivity extends AppCompatActivity {
    private static final int DELAY_MILLISECONDS = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo_screen);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(LogoScreenActivity.this, SignUp.class);
                startActivity(i);
                finish();
            }
        }, DELAY_MILLISECONDS);

    }
}
