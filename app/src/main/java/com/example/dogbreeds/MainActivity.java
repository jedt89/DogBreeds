package com.example.dogbreeds;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dogbreeds.api.ApiClient;
import com.example.dogbreeds.api.ApiInterface;
import com.example.dogbreeds.model.DataModel;
import com.example.dogbreeds.ui.DataAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRecyclerView();
        getAllBreeds();
        getImgBreed();
    }

    ApiInterface service = ApiClient.getRetrofit().create(ApiInterface.class);

    public void getAllBreeds() {
        //Llamada para traer datos
        Call<ArrayList<DataModel>> call = service.getListBreed();
        call.enqueue(new Callback<ArrayList<DataModel>>() {
            @Override
            public void onResponse(Call<ArrayList<DataModel>> call, Response<ArrayList<DataModel>> response) {
                if (response.isSuccessful()) {
                    ArrayList<DataModel> all = response.body();
                    recyclerView.setAdapter(adapter);
                }
            }
            @Override
            public void onFailure(Call<ArrayList<DataModel>> call, Throwable t) {
                Log.e("failure", t.getLocalizedMessage());
            }
        });
    }

    public void getImgBreed() {
        Call<DataModel> callImg = service.getImgRandom();
        callImg.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                if (response.isSuccessful()) {
                    DataModel img = response.body();
                    // recyclerView.setAdapter(adapter);
                }
            }
            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {
                Log.e("failure", t.getLocalizedMessage());
            }
        });
    }

    //Seteo de adaptador RecyclerView
    private void setRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2, RecyclerView.VERTICAL, false));
        adapter = new DataAdapter();
    }
}


