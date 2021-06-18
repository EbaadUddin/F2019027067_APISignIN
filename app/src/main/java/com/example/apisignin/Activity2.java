package com.example.apisignin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class Activity2 extends AppCompatActivity
{
GoogleSignInClient mGoogleSignInClient;
Button btn;
TextView name,id,email;
    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(Activity2.this,"sign out ",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        name=findViewById(R.id.name);
        id=findViewById(R.id.id);
        email=findViewById(R.id.email);
        btn=findViewById(R.id.button);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient= GoogleSignIn.getClient(this,gso);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null)
        {
            String personName = acct.getDisplayName();
            //String personGivenName = acct.getGivenName();
            //String personFamilyName = acct.getFamilyName();
            String personEmail = acct.getEmail();
            String personId = acct.getId();
            //Uri personPhoto = acct.getPhotoUrl();
            name.setText(personName);
            id.setText(personEmail);
            email.setText(personEmail);
        }
    }
}