package com.example.kaiso.parentchildapp;

import org.json.JSONArray;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.Firebase;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static android.R.layout.simple_list_item_1;

public class ParentActivity4 extends AppCompatActivity {
    public String json_urld = "https://turntotech.firebaseio.com/digitalleash/kaison4.json";

    JSONObject jsonObject = new JSONObject();
    List<String> items;
    String name = "robert";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent3);
        Firebase.setAndroidContext(this);
        final Firebase myFirebaseRef = new Firebase("https://parentchild-6751b.firebaseio.com/");

        final EditText latitude = (EditText) findViewById(R.id.editText2);
        final EditText longitude = (EditText) findViewById(R.id.editText3);


    }
//    private void postData(String uri, Str
    private String requestData() {

        RequestPackage p = new RequestPackage();
        p.setMethod("GET");
        p.setUri("https://parentchild-6751b.firebaseio.com/users.json");
        p.setParam("latitude", "50");
        //p.setParam("price", "13.95");

        MyTask task = new MyTask();
        try {
            //System.out.println(task.execute(p).get());
            items = Arrays.asList(task.execute(p).get().split("\""));
            System.out.println(items.get(1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void postData2() {

        RequestPackage p = new RequestPackage();
        //p.setMethod("PUT");
        p.setMethod("PUT");
        EditText hello = (EditText) findViewById(R.id.editText);
       // p.setUri("https://parentchild-6751b.firebaseio.com/users/"+ items.get(1) +"/user/"+ name +".json");
        p.setUri("https://parentchild-6751b.firebaseio.com/users/"+ hello.getText() +".json");
        p.setParam("long", "20");
        p.setParam("lat", "30");

        // p.setParam("latitude", lat);
        //p.setParam("longitude", lon);
        //p.setParam("radius", lon);

        MyTask task = new MyTask();
        task.execute(p);
        //return task.execute(p);
    }

    private class MyTask extends AsyncTask<RequestPackage, String, String> {


        @Override
        protected String doInBackground(RequestPackage... params) {
            String content = HttpManager.getData(params[0]);
            System.out.println(content);
            return content;
        }
        protected void onPostExecute(String result) {

            try {



            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }






    public void buttonClicked1(View view){
        Firebase.setAndroidContext(this);
        Firebase myFirebaseRef = new Firebase("https://parentchild-6751b.firebaseio.com/");

        EditText latitude = (EditText) findViewById(R.id.editText2);
        EditText longitude = (EditText) findViewById(R.id.editText3);



        //postData("https://parentchild-6751b.firebaseio.com/users.json",latitude.getText().toString(), longitude.getText().toString());
        //requestData();
        postData2();

        //requestData2();
    }

}
