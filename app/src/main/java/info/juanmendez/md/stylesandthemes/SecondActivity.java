package info.juanmendez.md.stylesandthemes;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;


/**
 * Created by Juan Mendez on 11/8/2016.
 * www.juanmendez.info
 * contact@juanmendez.info
 */

@EActivity(R.layout.second_activity)
public class SecondActivity extends AppCompatActivity {

    @AfterViews
    void afterViews(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Explode explode = new Explode();
            explode.setDuration(1000);
            getWindow().setEnterTransition(explode);
        }
    }
}
