package init.currency.luccruz.com;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "init.currency.luccruz.com.EXTRA_MESSAGE";
    //private Toast backToast;
    //private int counterExit = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("WrongViewCast")
    public void selectLoginButton(View view){

        TextView username = findViewById(R.id.txtUser);
        TextView password = findViewById(R.id.txtPassword);

        if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin") ){
            password.setText("");
            Intent intent = new Intent(MainActivity.this, Inside.class);
            startActivity(intent);
            alert("Welcome!");
        }else{
            alert("Password or user invalid!");
        }
    }

    @SuppressLint("WrongViewCast")
    public void selectRegister(View view){

        Intent intent = new Intent(MainActivity.this, Register.class);
        startActivity(intent);

    }

    public void alert(String message){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    /*
    @Override
    public void onBackPressed(){
        counterExit +=1;
        if(counterExit == 2){
            super.onBackPressed();
        }else{
            Toast.makeText(this, "Press return again to exit!", Toast.LENGTH_SHORT).show();
        }
    }*/


}