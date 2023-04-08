package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.textview);

        spinner = findViewById(R.id.spinner);
        List<User> userList = new ArrayList<>();
        User user1 = new User("john", 20, "jhon@gmail.com");
        userList.add(user1);
        User user2 = new User("lili", 30, "lili@gmail.com");
        userList.add(user2);
        User user3 = new User("jims", 25, "jims@gmail.com");
        userList.add(user3);
        User user4 = new User("jenny", 27, "jenny@gmail.com");
        userList.add(user4);

        ArrayAdapter<User> adapter = new ArrayAdapter<User>(this, android.R.layout.simple_spinner_item, userList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                User user = (User) adapterView.getSelectedItem();
                displayUserData(user);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });


    }
    public void getselecteduser(View v){
       User user = (User) spinner.getSelectedItem();
       displayUserData(user);
    }
    private  void displayUserData(User user){
        String name = user.getName();
        int age = user.getAge();
        String mail = user.getEmail();

       String userData = "Name :"+name+"\nage: "+age+"\n email :" +mail;
       text.setText(userData);

    }
}
