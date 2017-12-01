package com.example.admin.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;

import java.util.List;

import Adapter.DemoAdapter;
import Models.Item;
import Models.Owner;
import Models.SOAnswersResponse;
import Utils.RetroInterface;
import Utils.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static Utils.RetroInterface.BASE_URL;
import static android.support.v7.widget.DividerItemDecoration.*;

public class MainActivity extends AppCompatActivity {

    private RetroInterface mService;
    public List<Item> itemsarraylist;
    private RecyclerView recyclerView;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycleview);
        linearLayout=findViewById(R.id.linearlayout);
        loadAnswers();
    }
    public void loadAnswers() {
        mService =RetrofitClient.getClient(BASE_URL).create(RetroInterface.class);
        mService.getAnswers().enqueue(new Callback<SOAnswersResponse>() {
            @Override
            public void onResponse(Call<SOAnswersResponse> call, Response<SOAnswersResponse> response) {

                if(response.isSuccessful()) {
                   // mAdapter.updateAnswers(response.body().getItems());
                    Log.d("MainActivity",response.body().getHasMore().toString());
                    itemsarraylist=response.body().getItems();
//                    Item item=new Item();
//                    for (int i=0;i<itemsarraylist.size();i++) {
//                        item = itemsarraylist.get(i);
//                        String answerid = item.getOwner().getUserType().toString();
//                        Log.d("MainActivity", answerid);
//                    }

                   // Log.d("MainActivity", answerid);

                    DemoAdapter demoAdapter=new DemoAdapter(MainActivity.this,itemsarraylist);
                    RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(MainActivity.this);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(demoAdapter);
                    recyclerView.setHasFixedSize(true);


                }else {
                    int statusCode  = response.code();
                    // handle request errors depending on status code
                }
            }

            @Override
            public void onFailure(Call<SOAnswersResponse> call, Throwable t) {
               // showErrorMessage();
                Log.d("MainActivity", t.toString());

            }
        });
    }
}
