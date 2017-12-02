package x14331851.student.ncirl.ie.arcoapplication;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by User on 30/11/2017.
 */

public class FirebaseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);

    }
}
