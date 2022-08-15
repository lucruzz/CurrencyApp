package init.currency.luccruz.com;

import android.app.ProgressDialog;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.JsonReader;
import android.widget.ProgressBar;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class GetInformation extends Thread{

    private final String url_request;
    ProgressDialog progressDialog;

    public GetInformation(String url){
        this.url_request = url;
    }

    public String getUrl_request(){
        return this.url_request;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void run(){

        try{
            URL url = new URL(getUrl_request());
            HttpURLConnection connection;
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();

            if (connection.getResponseCode() == 200) {
                InputStream responseBody = connection.getInputStream();
                try (InputStreamReader responseBodyReader = new InputStreamReader(responseBody, StandardCharsets.UTF_8)) {
                    JsonReader jsonReader = new JsonReader(responseBodyReader);

                    // Start processing a JSON object
                    jsonReader.beginObject();





                    jsonReader.close();
                }


            }

            connection.disconnect();

        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
