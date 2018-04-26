package com.example.mouath.qa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import swipeable.com.layoutmanager.OnItemSwiped;
import swipeable.com.layoutmanager.SwipeableLayoutManager;
import swipeable.com.layoutmanager.SwipeableTouchHelperCallback;
import swipeable.com.layoutmanager.touchelper.ItemTouchHelper;

public class GameActivity extends AppCompatActivity {
    private List<String> Qlist = new ArrayList<String>();
    private RecyclerView recyclerView;
    private gameAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.MainTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Qlist.add("Abdullah");
        Qlist.add("Mouath");
        Qlist.add("Abdulrahman");
        Qlist.add("Abdullah");
        Qlist.add("Mouath");
        Qlist.add("Abdulrahman");
        Qlist.add("Abdullah");
        Qlist.add("Mouath");
        Qlist.add("Abdulrahman");
        Collections.shuffle(Qlist);


        recyclerView = (RecyclerView) findViewById(R.id.ReGame);
        recyclerView.setLayoutManager(new SwipeableLayoutManager());

        adapter = new gameAdapter(Qlist);
        recyclerView.setAdapter(adapter);

        adapter = new gameAdapter();
        SwipeableTouchHelperCallback swipeableTouchHelperCallback = new SwipeableTouchHelperCallback(new OnItemSwiped() {
            @Override
            public void onItemSwiped() {
                adapter.removeTopItem(Qlist.get(0));

            }

            @Override
            public void onItemSwipedLeft() {

            }

            @Override
            public void onItemSwipedRight() {

            }
        });

        swipeable.com.layoutmanager.touchelper.ItemTouchHelper touchelper = new  swipeable.com.layoutmanager.touchelper.ItemTouchHelper(swipeableTouchHelperCallback);
        touchelper.attachToRecyclerView(recyclerView);
    }
}
