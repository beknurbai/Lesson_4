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


public class FirstFragment extends Fragment {

    private RecyclerView recyclerView;
    private Adapter adapter;
    private OnItemClickListener listener;
    private ArrayList<TitleModel> model;

    public FirstFragment(OnItemClickListener listener) {
        this.listener = listener;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        setData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initRecyclerView();
    }

    private void initRecyclerView() {
        adapter = new Adapter(model, listener);
        recyclerView.setAdapter(adapter);
    }

    private void setData() {
        model = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            model.add(new TitleModel("Title" + i, 0));
        }
    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.recycler);
    }

}