package io.radio.lesson_4.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import io.radio.lesson_4.OnItemClickListener;
import io.radio.lesson_4.R;
import io.radio.lesson_4.adapter.Adapter;
import io.radio.lesson_4.models.TitleModel;

public class SecondFragment extends Fragment implements OnItemClickListener {

    private RecyclerView recyclerView;
    private Adapter adapter;
    private ArrayList<TitleModel> model;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        setData();
        initRecyclerView();
    }

    private void initRecyclerView() {
        adapter = new Adapter(model, this);
        recyclerView.setAdapter(adapter);
    }

    private void setData() {
        model = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            model.add(new TitleModel("Second " + i, 1));
        }
    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.recycler);
    }

    @Override
    public void onItemClick(String title) {
        Toast.makeText(getContext(), title, Toast.LENGTH_SHORT).show();
    }
}