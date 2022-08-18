package init.currency.luccruz.com;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    @SuppressLint("WrongViewCast")
    public void selectRegister(View view){

        TextView tv_name = findViewById(R.id.editTxtNameRegister);
        TextView tv_email = findViewById(R.id.editTxtEmailRegister);
        TextView tv_user = findViewById(R.id.editTxtUserRegister);
        TextView tv_pass = findViewById(R.id.editTxtPasswordRegister);
        TextView tv_pass_again = findViewById(R.id.editTxtPasswordAgainRegister);

        boolean check = false;

        if(tv_email.getText().toString().equals("") || tv_user.getText().toString().equals("") ||
                    tv_name.getText().toString().equals("") || tv_pass.getText().toString().equals("")
                        || tv_pass_again.getText().toString().equals("")){
            Toast.makeText(this, "Please, fill all fields!", Toast.LENGTH_LONG).show();
            return;
        }

        String s1 = tv_pass.getText().toString();
        String s2 = tv_pass_again.getText().toString();

        if( !s1.equals(s2) ){
            Toast.makeText(this, "Passwords doens't match! Please type again!", Toast.LENGTH_LONG).show();
            return;
        }

        Intent intent = new Intent(Register.this, Inside.class);
        startActivity(intent);

    }


}