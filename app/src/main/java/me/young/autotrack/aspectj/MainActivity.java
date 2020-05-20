package me.young.autotrack.aspectj;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

import me.young.autotrack.aspectj.widgets.LcopHorTabView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LcopHorTabView tabView = findViewById(R.id.tab_view);
        tabView.setTitles(Arrays.asList("直选", "组三", "组六", "组八"));
    }
}
