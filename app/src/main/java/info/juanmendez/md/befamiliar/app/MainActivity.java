package info.juanmendez.md.befamiliar.app;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

import info.juanmendez.md.befamiliar.R;

@EActivity(R.layout.activity_main)
@OptionsMenu(R.menu.main_menu)
public class MainActivity extends AppCompatActivity {

    @ViewById(R.id.textView5)
    TextView txtGradient;

    @AfterViews
    void afterViews(){
        LinearGradient lg = new LinearGradient(0, 0, txtGradient.getTextSize(), 0, Color.GREEN, Color.RED, Shader.TileMode.MIRROR );
        txtGradient.getPaint().setShader( lg );
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
