package info.juanmendez.md.stylesandthemes;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

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
        startActivity( intent );
    }
}
