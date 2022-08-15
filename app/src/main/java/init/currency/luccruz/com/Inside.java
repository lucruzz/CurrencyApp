package init.currency.luccruz.com;

import static android.widget.Toast.makeText;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.net.MalformedURLException;

public class Inside extends AppCompatActivity{

    TextView textResult;
    Button btn_getBRL, btn_getUSD, btn_getEUR, btn_getBTC, btn_getCNY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside);

        btn_getBRL = findViewById(R.id.buttonBrazil);
        btn_getUSD = findViewById(R.id.buttonStates);
        btn_getEUR = findViewById(R.id.buttonEuro);
        btn_getBTC = findViewById(R.id.buttonBitcoin);
        btn_getCNY = findViewById(R.id.buttonChinese);

    }


    public void selectBrazilButton(View view) throws MalformedURLException {
        makeText(this, "Let's see the brazilian current currency!", Toast.LENGTH_LONG).show();

        Intent intent;
        intent = new Intent(Inside.this, GetInfo.class);
        intent.putExtra(MainActivity.EXTRA_MESSAGE, "USD-BRL");
        startActivity(intent);

    }

    public void selectUnitedStatesButton(View view){
        makeText(this, "Let's see the american U.S current currency!", Toast.LENGTH_LONG).show();

        Intent intent;
        intent = new Intent(Inside.this, GetInfo.class);
        intent.putExtra(MainActivity.EXTRA_MESSAGE, "BRL-USD");
        startActivity(intent);

    }

    public void selectEuroButton(View view){
        makeText(this, "Let's see the european current currency!", Toast.LENGTH_LONG).show();

        Intent intent;
        intent = new Intent(Inside.this, GetInfo.class);
        intent.putExtra(MainActivity.EXTRA_MESSAGE, "EUR-BRL");
        startActivity(intent);

    }

    public void selectBitcoinButton(View view){
        makeText(this, "Let's see the bitcoin current currency!", Toast.LENGTH_LONG).show();

        Intent intent;
        intent = new Intent(Inside.this, GetInfo.class);
        intent.putExtra(MainActivity.EXTRA_MESSAGE, "BTC-BRL");
        startActivity(intent);

    }

    public void selectChineseButton(View view){
        makeText(this, "Let's see the chinese current currency!", Toast.LENGTH_LONG).show();
        Intent intent;
        intent = new Intent(Inside.this, GetInfo.class);
        intent.putExtra(MainActivity.EXTRA_MESSAGE, "CNY-BRL");
        startActivity(intent);

    }


}