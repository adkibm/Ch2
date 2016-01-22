package com.hackathon.cheherlock.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import java.io.InputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hackathon.cheherlock.interfaces.IWebConnected;
import com.hackathon.cheherlock.interfaces.ParseJSONtoSBO;
import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyVision;
import com.ibm.watson.developer_cloud.alchemy.v1.model.ImageFaces;
import com.squareup.okhttp.HttpUrl;

/**
 * Created by Ravinder Nath Kamra on 8/1/2015.
 */
public class WebCallerAPI {

    private String callUrl;
    private ParseJSONtoSBO parseStrategy;
    private IWebConnected webconnectedActivity;

    public void setURT(String url)
    {
        callUrl = url;
    }

    public void setParseStrategy(ParseJSONtoSBO parseStrategy)
    {
     this.parseStrategy = parseStrategy;
    }

    public void setConnectedActivity(IWebConnected wca)
    {
        webconnectedActivity = wca;
    }

    public void call() {
        new WebCall().execute();
    }
    public String readJSONFeed(String URL) {

        String filename = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/unnamed.jpg";
        // Toast.makeText(getBaseContext(), "After This", Toast.LENGTH_LONG).show();
        AlchemyVision service = new AlchemyVision();
        service.setApiKey("2173e3efe1737940c3e8a6c878cd0d522f765fa8");
        ImageFaces faces = service.recognizeFaces( HttpUrl.parse(URL).url(), true);
        String response = faces.toString();
        return response;
    }


    private class WebCall extends AsyncTask
            <String, Void, String> {
        protected String doInBackground(String... urls) {
            return readJSONFeed(callUrl);
        }

        protected void onPostExecute(String result) {
            try {
                  webconnectedActivity.setView( parseStrategy.parseJSON(result));
            } catch (Exception e) {
                Log.d("ReadWeatherJSONFeedTask", e.getLocalizedMessage());
            }
        }
    }

}
