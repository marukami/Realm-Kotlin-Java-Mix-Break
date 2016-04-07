package au.com.tilbrook.mixedlang;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.fab)       FloatingActionButton fab;
    @Bind(R.id.textField) TextView             textView;

    @OnClick(R.id.fab)
    public void onFabClick(final View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
            .setAction("Action", null)
            .show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final RealmConfiguration realmConfig = new RealmConfiguration.Builder(this)
            .deleteRealmIfMigrationNeeded()
            .build();
        final Realm realm = Realm.getInstance(realmConfig);
        CatModel cat = realm.where(CatModel.class)
            .findFirst();

        if(cat == null) {
            cat = new CatModel();
            cat.setName("Cat");
            cat.setAge(1);
            realm.beginTransaction();
            cat = realm.copyToRealmOrUpdate(cat);
            realm.commitTransaction();
        } else {
            realm.beginTransaction();
            cat.setAge(cat.getAge() + 1);
            cat = realm.copyToRealmOrUpdate(cat);
            realm.commitTransaction();
        }

        final String text = String.format(
            "Hello World! %s aged %d welcomes you",
            cat.getName(),
            cat.getAge()
        );
        textView.setText(text);

        realm.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
