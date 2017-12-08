package com.example.kkavalireddy.collapsingtoolbarexample;

        import android.animation.LayoutTransition;
        import android.graphics.Bitmap;
        import android.graphics.BitmapFactory;
        import android.graphics.Color;
        import android.os.Build;
        import android.os.Bundle;
        import android.support.annotation.RequiresApi;
        import android.support.design.widget.CollapsingToolbarLayout;
        import android.support.design.widget.FloatingActionButton;
        import android.support.design.widget.Snackbar;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.graphics.Palette;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.support.v7.widget.Toolbar;
        import android.transition.Transition;
        import android.view.View;
        import android.view.Menu;
        import android.view.MenuItem;

        import java.util.ArrayList;
        import java.util.List;

        import it.michelelacorte.scrollableappbar.ScrollableAppBar;

public class MainActivity extends AppCompatActivity {
    ScrollableAppBar appBarLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        appBarLayout = (ScrollableAppBar)findViewById(R.id.appbar);
        collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsingToolbarLayout);

        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.background);
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onGenerated(Palette palette) {

                int color = getResources().getColor(R.color.colorPrimaryDark);
                int color1 = getResources().getColor(R.color.colorAccent);
                collapsingToolbarLayout.setContentScrimColor(color);
                collapsingToolbarLayout.setStatusBarScrimColor(color1);
                collapsingToolbarLayout.setBackgroundColor(color1);
                collapsingToolbarLayout.setExpandedTitleColor(color1);
                LayoutTransition transition = new LayoutTransition();
                transition.enableTransitionType(LayoutTransition.CHANGE_APPEARING);
                collapsingToolbarLayout.setLayoutTransition(transition);

                collapsingToolbarLayout.setCollapsedTitleTextColor(Color.RED);
                collapsingToolbarLayout.setHorizontalScrollBarEnabled(true);
            }
        });
        appBarLayout.collapseToolbar();
    }
}
