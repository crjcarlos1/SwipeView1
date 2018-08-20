package droid.demos.com.ejemplo1.views;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import droid.demos.com.ejemplo1.R;
import droid.demos.com.ejemplo1.adapters.AdapterViewPager;
import droid.demos.com.ejemplo1.fragments.Instructions1Fragment;
import droid.demos.com.ejemplo1.fragments.Instructions2Fragment;
import droid.demos.com.ejemplo1.fragments.Instructions3Fragment;

public class MainActivity extends AppCompatActivity implements Instructions1Fragment.OnSendDataToInstructions2,
        Instructions2Fragment.OnSendDataInstructions3Listener {

    private AdapterViewPager adapterViewPager;
    public static ViewPager viewPager;

    private List<Fragment> listFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewPagerConteiner);

        listFragments = new ArrayList<>();
        listFragments.add(new Instructions1Fragment());
        listFragments.add(new Instructions2Fragment());
        listFragments.add(new Instructions3Fragment());

        adapterViewPager = new AdapterViewPager(getSupportFragmentManager(), listFragments);
        viewPager.setAdapter(adapterViewPager);

        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

    }

    @Override
    public void sendData(String name, String lastName) {
        Log.e("TAG", ":NAME: " + name + " LASTNAME: " + lastName);
        Instructions2Fragment instructions2Fragment = (Instructions2Fragment) adapterViewPager.getItem(1);
        if (instructions2Fragment != null) {
            instructions2Fragment.getData(name, lastName);
        } else {
            Toast.makeText(MainActivity.this, "Ocurrio un error al enviar los datos", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onSendDataInstructions3(String name, String lastName) {
        Instructions3Fragment instructions3Fragment = (Instructions3Fragment) adapterViewPager.getItem(2);
        if (instructions3Fragment != null) {
            instructions3Fragment.getData(name, lastName);
        } else {
            Toast.makeText(MainActivity.this, "Ocurrio un error al enviar los datos", Toast.LENGTH_LONG).show();
        }
    }
}
