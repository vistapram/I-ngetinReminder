package id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ImageView;

/**
 * Created by Vistapram on 2016-11-20.
 */

public class About extends AppCompatActivity {

    ImageView imageView;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.about);

        imageView = (ImageView) findViewById(R.id.imageView2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    }
}
