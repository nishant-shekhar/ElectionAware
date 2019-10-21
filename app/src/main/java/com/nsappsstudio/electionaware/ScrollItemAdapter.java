package com.nsappsstudio.electionaware;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ScrollItemAdapter extends RecyclerView.Adapter<ScrollItemAdapter.ViewHolderClass> {
    public List<ScrollItem> scrollItems;
    public Context context;

    public ScrollItemAdapter(List<ScrollItem> scrollItems, Context context) {
        this.scrollItems = scrollItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.scroll_item,parent,false);
        return new ViewHolderClass(view);    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderClass holder, int position) {
        ScrollItem scrollItem=scrollItems.get(position);
        holder.topic.setText(scrollItem.getTopic());


    }

    @Override
    public int getItemCount() {
        return scrollItems.size();
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder {
        public TextView topic;
        public ImageView bg;

        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            topic=itemView.findViewById(R.id.si_topic);
            bg=itemView.findViewById(R.id.si_bg_image);
        }
    }
}
