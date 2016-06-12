package com.restaurant.chaersi.multithreaddownload;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Chaersi on 16/6/1.
 */
public class DownloadAdapter extends RecyclerView.Adapter<DownloadAdapter.DownItemViewHolder>{

    private Context context;
    private ArrayList<HashMap<String,String>> downloadUrlArr;
    public DownloadAdapter(Context context,ArrayList<HashMap<String,String>> downloadUrlArr){
        this.context=context;
        this.downloadUrlArr=downloadUrlArr;
    }

    @Override
    public DownItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new DownItemViewHolder(v);
    }


    @Override
    public void onBindViewHolder(DownItemViewHolder holder, int position) {
        HashMap<String,String>item=downloadUrlArr.get(position);
        holder.nameView.setText(item.get("name"));
        if (item.get("type").equals("a")) {
            holder.typeView.setText("应用");
        }else{
            holder.typeView.setText("MP3");
        }

        if(item.get("pro")!=null){
            holder.percentBar.setProgress(Integer.parseInt(item.get("pro")));
        }else{
            holder.percentBar.setProgress(0);
        }
        holder.percentView.setText(item.get("finished")!=null?item.get("finished"):"0M/0M");

        holder.position=position;
    }

    @Override
    public int getItemCount() {
        return downloadUrlArr == null ? 0 : downloadUrlArr.size();
    }

    public static class DownItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public int position;
        public RelativeLayout parentLayout;

        public Button startBtn;
        public TextView nameView;
        public TextView typeView;
        public TextView percentView;
        public ProgressBar percentBar;

        public DownItemViewHolder(View itemView) {
            super(itemView);
            startBtn= (Button) itemView.findViewById(R.id.startBtn);
            nameView= (TextView) itemView.findViewById(R.id.nameView);
            typeView= (TextView) itemView.findViewById(R.id.typeView);
            percentView= (TextView) itemView.findViewById(R.id.percentView);
            percentBar= (ProgressBar) itemView.findViewById(R.id.progressBar);

            startBtn.setOnClickListener(this);

            parentLayout= (RelativeLayout) itemView.findViewById(R.id.parentLayout);
            parentLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.startBtn:
                    if (null != listener) {
                        listener.onButtonListener(position);
                    }
                    break;
                case R.id.parentLayout:
                    if(null!=listener){
                        listener.onItemClickListener(position);
                    }
                    break;
            }
        }
    }

    private static RecyclerAdapterListener listener;
    public void addItemListener(RecyclerAdapterListener listener){
        this.listener=listener;
    }

}
