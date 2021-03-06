package info.juanmendez.md.stylesandthemes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;


/**
 * Created by Juan Mendez on 11/7/2016.
 * www.juanmendez.info
 * contact@juanmendez.info
 */
@EActivity(R.layout.activity_button)
@OptionsMenu(R.menu.main_menu)
public class MainButtonActivity extends AppCompatActivity {

    @OptionsItem(R.id.menu_main)
    void onMenuMain(){
        Intent intent = new Intent( this, MainActivity_.class );
        startActivity( intent );
    }
}
