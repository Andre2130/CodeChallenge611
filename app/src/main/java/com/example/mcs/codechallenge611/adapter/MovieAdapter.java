package com.example.mcs.codechallenge611.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mcs.codechallenge611.MainActivity;
import com.example.mcs.codechallenge611.R;
import com.example.mcs.codechallenge611.data.model.Datum;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MainActivity.MovieViewHolder>
{
    private List<Datum> mMovieList;
    private LayoutInflater mInflater;
    private Context mContext;

    public MovieAdapter(Context context)
    {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mMovieList = new ArrayList<>();
    }

    @Override
    public MainActivity.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = mInflater.inflate(R.layout.row_movie, parent, false);
        MainActivity.MovieViewHolder viewHolder = new MainActivity.MovieViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MainActivity.MovieViewHolder holder, int position)
    {
        Datum movie = mMovieList.get(position);
        System.out.println("TOKEN MAGICO onBindViewHolder");
        System.out.println("TOKEN MAGICO " + movie.toString());
        System.out.println("TOKEN MAGICO " + holder.imageView.getWidth() + "-" + holder.imageView.getHeight());
        // This is how we use Picasso to load images from the internet.
        Picasso.get()
                .load(movie.getPoster())
                .placeholder(R.color.colorAccent)
                .into(holder.imageView);

        System.out.println("TOKEN MAGICO -----------------------------------------------------------");

    }

    @Override
    public int getItemCount()
    {
        return (mMovieList == null) ? 0 : mMovieList.size();
    }

    public void setMovieList(List<Datum> movieList)
    {
        this.mMovieList.clear();
        this.mMovieList.addAll(movieList);
        // The adapter needs to know that the data has changed. If we don't call this, app will crash.
        notifyDataSetChanged();
    }

    public void setFilter(ArrayList<Datum> newList){

        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.addAll(newList);
        //setMovieList(newList);
        notifyDataSetChanged();
    }
}
