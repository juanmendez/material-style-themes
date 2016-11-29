package info.juanmendez.md.befamiliar.app;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

import info.juanmendez.md.befamiliar.R;
import info.juanmendez.md.befamiliar.adapter.RecyclerAdapter;
import info.juanmendez.md.befamiliar.service.LandscapeService;

@EActivity(R.layout.activity_main)
@OptionsMenu(R.menu.main_menu)
public class MainActivity extends AppCompatActivity {

    @ViewById
    Toolbar toolbar;

    @ViewById
    RecyclerView recyclerView;

    @ViewById(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @AfterViews
    void afterViews(){

        setupToolbar();
        setupDrawer();
        setupRecyclerView();
    }

    private void setupToolbar(){
        setSupportActionBar( toolbar );
        toolbar.setTitle("Welcome!");
        toolbar.setSubtitle("Folks!");
    }

    private void setupRecyclerView(){
        RecyclerAdapter adapter = new RecyclerAdapter(this, LandscapeService.getData());
        recyclerView.setAdapter(adapter);

        LinearLayoutManager mLinearLayoutManagerVertical = new LinearLayoutManager(this); // (Context context, int spanCount)
        mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLinearLayoutManagerVertical);

        recyclerView.setItemAnimator(new DefaultItemAnimator()); // Even if we dont use it then also our items shows default animation.
    }

    private void setupDrawer(){
        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.nav_drwr_fragment);
        drawerFragment.setUpDrawer(drawerLayout, toolbar);
    }


    @OptionsItem(R.id.menu_button)
    void onMenuButton(){
        Intent intent = new Intent( this, MainButtonActivity_.class );
        startActivity( intent );
    }

    @Click(R.id.button0)
    void onButton0Clicked(){
        Intent intent = new Intent( this, SecondActivity_.class );

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ){
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
            startActivity( intent, options.toBundle() );
        }else{
            startActivity( intent );
        }
    }
}
