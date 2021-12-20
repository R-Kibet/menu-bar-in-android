package com.example.clone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.clone.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //set binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        //initialize firebase
        mAuth = FirebaseAuth.getInstance();

    }

    //set  up menu bar in the application

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.menu,menu);//pass location ,file name ,menu item
        return super.onCreateOptionsMenu(menu);
    }

    //initializing menu bar options
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        //use switch statements depending on the amount of options you have to simplify

        switch (item.getItemId()) //we have set menu item so we can extract the items located in the menu
        {
            case R.id.settings:
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                break;


            case R.id.groupChat:
                Toast.makeText(this, "Group chat", Toast.LENGTH_SHORT).show();
                break;


            case R.id.logOut:
                mAuth.signOut();

                //we have to show which activity to move to after logout
                Intent intent = new Intent(MainActivity.this, SignInActivity.class);
                startActivity(intent);
                
                break;
                // without break there will be a fall case -ever option will be executed

        }
        return super.onOptionsItemSelected(item);
    }
}
