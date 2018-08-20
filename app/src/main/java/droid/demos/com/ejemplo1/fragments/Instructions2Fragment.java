package droid.demos.com.ejemplo1.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import droid.demos.com.ejemplo1.R;
import droid.demos.com.ejemplo1.views.MainActivity;

/**
 * Created by carlos on 26/03/2018.
 */

public class Instructions2Fragment extends Fragment implements View.OnClickListener {

    private Button btnBack2, btnNext2;
    private TextView txvResultInstructions2;
    private OnSendDataInstructions3Listener onSendDataInstructions3Listener;

    private String name,lastName;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.instructions_2_fragment, container, false);

        btnBack2 = (Button) view.findViewById(R.id.btnBack2);
        btnNext2 = (Button) view.findViewById(R.id.btnNext2);
        txvResultInstructions2=(TextView)view.findViewById(R.id.txvRestuInstructions2);
        btnBack2.setOnClickListener(this);
        btnNext2.setOnClickListener(this);

        return view;
    }

    public void getData(String name, String lastName) {
        Log.e("TAG", "NAME_RECEIVER: " + name + " LASTNAME_RECEIVER: " + lastName);
        this.name=name;
        this.lastName=lastName;
        txvResultInstructions2.setText("Name: "+name+"\nLastNmae: "+lastName);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnBack2:
                goToInstructions1Fragment();
                break;
            case R.id.btnNext2:
                goToInstrcutions3();
                break;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onSendDataInstructions3Listener=(OnSendDataInstructions3Listener)context;
    }

    private void goToInstructions1Fragment() {
        MainActivity.viewPager.setCurrentItem(getItem(1), true);
    }

    private int getItem(int i) {
        return MainActivity.viewPager.getCurrentItem() - i;
    }

    private void goToInstrcutions3()
    {
        MainActivity.viewPager.setCurrentItem(getItemNext(2),true);
        onSendDataInstructions3Listener.onSendDataInstructions3(name,lastName);
    }

    private int getItemNext(int i)
    {
        return MainActivity.viewPager.getCurrentItem()+i;
    }

    public interface OnSendDataInstructions3Listener
    {
        public void onSendDataInstructions3(String name,String lastName);
    }

}
