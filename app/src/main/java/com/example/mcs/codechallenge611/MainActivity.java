package com.example.mcs.codechallenge611;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mcs.codechallenge611.adapter.MovieAdapter;
import com.example.mcs.codechallenge611.data.model.Data;
import com.example.mcs.codechallenge611.data.remote.MovieService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.mcs.codechallenge611.data.remote.ApiUtils.getMovieService;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MovieAdapter mMovieAdapter;
    private MovieService mMovieService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMovieService = getMovieService();

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mMovieAdapter = new MovieAdapter(this);
        mRecyclerView.setAdapter(mMovieAdapter);

        mMovieService.getData().enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                mMovieAdapter.setMovieList(response.body().getData());
                System.out.println("TOKEN MAGICO <" + response.toString() + ">");
                //TODO ADD WHAT YOU WANT TO DO HERE
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                System.out.println("TOKEN MAGICO <" + t.toString() + ">");
                //TODO ADD WHAT YOU WANT IN CASE OF FAILURE
            }
        });

    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView imageView;
        public TextView title;
        public MovieViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            // title = itemView.findViewById(R.id.);
        }
    }
}
