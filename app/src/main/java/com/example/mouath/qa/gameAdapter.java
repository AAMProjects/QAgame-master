package com.example.mouath.qa;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class gameAdapter extends RecyclerView.Adapter<gameAdapter.ViewHolder>{
    private List<String> Qlist = new ArrayList<String>();

    public gameAdapter(){}
    public gameAdapter(List<String> myDataset) {
        Qlist = myDataset;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private TextView Question;
        private CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            Question =  (TextView)itemView.findViewById(R.id.Question);
            cardView = (CardView)itemView.findViewById(R.id.card);
        }
    }

    @Override
    public gameAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        ViewHolder holder = new ViewHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String Ques= Qlist.get(position);
        holder.Question.setText(Ques);
    }

    public void removeTopItem(String po) {
        Qlist.remove(po);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return Qlist.size();
    }
}
