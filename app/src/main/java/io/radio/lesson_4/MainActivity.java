package io.radio.lesson_4;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import io.radio.lesson_4.fragments.FirstFragment;
import io.radio.lesson_4.fragments.SecondFragment;
import io.radio.lesson_4.fragments.ThirdFragment;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.container, new FirstFragment(this)).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.container_2, new SecondFragment()).commit();
    }

    @Override
    public void onItemClick(String title) {
        Log.e("ololo", "onItemClick: " );
        getSupportFragmentManager().beginTransaction().remove(new SecondFragment()).commit();
    }
}