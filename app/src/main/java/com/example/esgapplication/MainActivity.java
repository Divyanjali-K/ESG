package com.example.esgapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    ImageView googlebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView Username=(TextView) findViewById(R.id.Username);
        TextView Password=(TextView) findViewById(R.id.Password);
        MaterialButton loginbtn=(MaterialButton) findViewById(R.id.loginbtn);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Username.getText().toString().equals("admin")&&Password.getText().toString().equals("admin")){
                    Toast.makeText(MainActivity.this,"LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();


                }
                else {
                    //incorrect
                    Toast.makeText(MainActivity.this,"LOGIN FAILED!!!",Toast.LENGTH_SHORT).show();
                }

            }
        });

        googlebtn=findViewById(R.id.google_btn);
        gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc= GoogleSignIn.getClient(this,gso);

        GoogleSignInAccount acct=GoogleSignIn.getLastSignedInAccount(this);
        if(acct!=null){
            navigateToSecondActivity();
        }

        googlebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
    }
    void signIn() {
        Intent signInIntent=gsc.getSignInIntent();
        startActivityForResult(signInIntent,1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1000){
            Task<GoogleSignInAccount> task= GoogleSignIn.getSignedInAccountFromIntent(data);
            try{
                task.getResult(ApiException.class);
                navigateToSecondActivity();
            }catch (ApiException e){
                Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_SHORT).show();
            }

        }

    }
    void navigateToSecondActivity(){
        finish();
        Intent intent=new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);
    }

}
