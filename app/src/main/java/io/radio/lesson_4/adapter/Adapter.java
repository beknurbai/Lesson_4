package io.radio.lesson_4.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import io.radio.lesson_4.OnItemClickListener;
import io.radio.lesson_4.R;
import io.radio.lesson_4.models.TitleModel;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {


    private final int FIRST_TYPE = 0;
    private final int SECOND_TYPE = 1;
    private ArrayList<TitleModel> list = new ArrayList<>();
    private OnItemClickListener listener;

    public Adapter(ArrayList<TitleModel> list, OnItemClickListener listener) {
        this.list = list;
        this.listener = listener;
    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == FIRST_TYPE) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false));
        } else {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_2, parent, false));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).getType() == 1) {
            return FIRST_TYPE;
        } else {
            return SECOND_TYPE;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(list.get(position), listener);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.title);
        }

        public void onBind(TitleModel title, OnItemClickListener listener) {
            textView.setText(title.getTitle());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.e("ololo", "onClick: ");
                    listener.onItemClick(title.getTitle());
                }
            });
        }
    }
}
