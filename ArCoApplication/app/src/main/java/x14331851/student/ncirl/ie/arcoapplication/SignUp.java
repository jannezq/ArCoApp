package x14331851.student.ncirl.ie.arcoapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;




public class SignUp extends AppCompatActivity {

    EditText inputEmail, inputPass;
    Button btnSignUp;
    FirebaseAuth fireAuth;
    String myEmail, myPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getWindow().setBackgroundDrawableResource(R.drawable.background);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);



        fireAuth = FirebaseAuth.getInstance();

        inputEmail = findViewById(R.id.emailText);
        inputPass = findViewById(R.id.passwordText);
        btnSignUp = findViewById(R.id.signupBtn);

        myEmail = inputEmail.getText().toString();
        myPassword = inputPass.getText().toString();

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myEmail = inputEmail.getText().toString();
                myPassword = inputPass.getText().toString();

                CreateNewUser();

            }
        });

    }

    //Creating the User using email and password
    //This is just for the user to sign up - Username, location, small Bio, Profile picture and banner
    //will be in profile setting~
    private void CreateNewUser () {

        fireAuth.createUserWithEmailAndPassword(myEmail, myPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    Intent homeIntent = new Intent(SignUp.this, MainActivity.class);
                    startActivity(homeIntent);
                } else {
                    Toast.makeText(SignUp.this, "Registration failed!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

}
