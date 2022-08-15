package init.currency.luccruz.com;


import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class GetInfo extends AppCompatActivity{

    SensorManager sensorManager;
    Sensor proximitySensor;
    SensorEventListener proximitySensorListener;

    String theURL = "https://economia.awesomeapi.com.br/json/";

    TextView tv;
    TextView tv_nome;
    TextView tv_bid; // cotacao
    TextView tv_high;
    TextView tv_low;
    String moeda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_info);

        tv_nome = (TextView) findViewById(R.id.txtVariavel_NomeMoeda);
        tv_bid = (TextView) findViewById(R.id.txtVariavel_Cotacao);
        tv_high = (TextView) findViewById(R.id.txtVariavel_Maxima);
        tv_low = (TextView) findViewById(R.id.txtVariavel_Minima);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView tv1 = (TextView) findViewById(R.id.txtTituloMoeda);
        tv1.setText(message);
        moeda = message;
        theURL = theURL + message;

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        //Check if the proximity sensor is available
        if(proximitySensor == null){
            Toast.makeText(this, "Proximity sensor is not available", Toast.LENGTH_LONG).show();
            finish();
        }

        proximitySensorListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                tv = findViewById(R.id.txtTituloMoeda);
                String s = tv.getText().toString();
                if(sensorEvent.values[0] < proximitySensor.getMaximumRange()) {
                    tv.setText(moeda);
                    //doThings(theURL);
                    doThings2(theURL);
                }else{
                    tv.setText("");
                    tv_nome.setText("");
                    tv_bid.setText("");
                    tv_high.setText("");
                    tv_low.setText("");
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };

        sensorManager.registerListener(proximitySensorListener, proximitySensor, SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected void onPause(){
        super.onPause();
        sensorManager.unregisterListener(proximitySensorListener);
    }

    public void doThings(String url){
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String teste = "https://economia.awesomeapi.com.br/json/last/BRL-USD";
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, teste,
                response -> Toast.makeText(GetInfo.this, response, Toast.LENGTH_SHORT).show(), error -> Toast.makeText(GetInfo.this, "Error occurred", Toast.LENGTH_SHORT).show());

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    public void doThings2(String url){
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String teste = "https://economia.awesomeapi.com.br/json/BRL-USD";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                String nome = null;
                String bid = null;
                String high = null;
                String low = null;

                try {

                    JSONObject infoMoeda = response.getJSONObject(0);

                    nome = infoMoeda.getString("name");
                    tv_nome.setText(nome);

                    bid = infoMoeda.getString("bid");
                    tv_bid.setText(bid);

                    high = infoMoeda.getString("high");
                    tv_high.setText(high);

                    low = infoMoeda.getString("low");
                    tv_low.setText(low);


                } catch (JSONException e) {
                    e.printStackTrace();
                }


                Toast.makeText(GetInfo.this, "Success!", Toast.LENGTH_SHORT).show();



            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(GetInfo.this, "Error occurred!", Toast.LENGTH_SHORT).show();
            }
        });

        // Add the request to the RequestQueue.
        queue.add(request);
    }


}