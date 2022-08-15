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

    ///ExecutorService executorService = Executors.newFixedThreadPool(5);
    public static final String EXTRA_MESSAGE = "init.currency.luccruz.com.EXTRA_MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("WrongViewCast")
    public void selectLoginButton(View view){

        TextView username = findViewById(R.id.txtUser);
        //String user = (String) username.getText();
        //username.setText("");

        TextView password = findViewById(R.id.txtPassword);
        //String pass = (String) password.getText();
        //password.setText("");

        Intent intent = new Intent(MainActivity.this, Inside.class);
        startActivity(intent);
        alert("Welcome!");

        /*if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin") ){
            Intent intent = new Intent(MainActivity.this, Inside.class);
            startActivity(intent);
            alert("Welcome!");
        }else{
            username.setText(null);
            password.setText(null);
            alert("Password or user invalid!");
        }*/
    }

    public void alert(String message){

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

    }
}