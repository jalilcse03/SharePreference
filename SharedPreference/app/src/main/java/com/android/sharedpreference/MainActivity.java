package com.android.sharedpreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText userEt,passEt;
    TextView userTv,passTv;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userEt=(EditText)findViewById(R.id.userEt);
        passEt=(EditText)findViewById(R.id.passEt);
        userTv=(TextView)findViewById(R.id.userTv);
        passTv=(TextView)findViewById(R.id.passTv);

        sharedPreferences=getSharedPreferences("login",0);
        editor=sharedPreferences.edit();

    }

    public void save(View view){
        if(userEt.getText().toString().length()>0 &&passEt.getText().toString().length()>0 )
        {
            editor.putString("name",userEt.getText().toString());
            editor.putString("pass",passEt.getText().toString());
            editor.commit();
            userEt.getText().clear();
            passEt.getText().clear();
        }
        else{
            Toast.makeText(MainActivity.this,"Input Empty",Toast.LENGTH_SHORT).show();
        }
    }

    public void retrive(View view){
        String name=sharedPreferences.getString("name","Name is Empty");
        String password=sharedPreferences.getString("pass","Password is Empty");
        userTv.setText(name);
        passTv.setText(password);
    }

    public void delete(View view){
        editor.remove("name");
        editor.remove("pass");
        editor.commit();
    }

}
