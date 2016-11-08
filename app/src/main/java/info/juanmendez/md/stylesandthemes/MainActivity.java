package info.juanmendez.md.stylesandthemes;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById(R.id.textView5)
    TextView txtGradient;

    @AfterViews
    void afterViews(){
        LinearGradient lg = new LinearGradient(0, 0, txtGradient.getTextSize(), 0, Color.GREEN, Color.RED, Shader.TileMode.MIRROR );
        txtGradient.getPaint().setShader( lg );
    }
}
