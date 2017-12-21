package app.com.prachigupta.rolodex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<CardModel> cardModels;
    RecyclerView recyclerView;
    LinearLayoutManager manager;
    CardAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUp();





    }

    public void setUp(){
        cardModels = new ArrayList<>();

        recyclerView  =(RecyclerView)findViewById(R.id.recyclerView);
        manager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(manager);

        adapter = new CardAdapter(cardModels,this);
        recyclerView.setAdapter(adapter);

        JSONArray jsonArray = readFromFile();
        Log.d("Debug",jsonArray.toString());

        cardModels.addAll(CardModel.fromJsonArray(jsonArray));
        adapter.notifyDataSetChanged();
        Log.d("Debug",cardModels.toString());
    }

    /* creating Json array
    Reference https://www.codementor.io/tips/1304827783/reading-json-file-from-assets-in-android-*/

    public JSONArray readFromFile(){

        String json = null;
        JSONArray jsonArray = null;
        try {
            InputStream is = getAssets().open("CardData.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            Log.d("Debug",json);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        try {

            jsonArray = new JSONArray(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonArray;
    }
}
