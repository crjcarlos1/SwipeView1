package droid.demos.com.ejemplo1.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import droid.demos.com.ejemplo1.R;

/**
 * Created by carlos on 26/03/2018.
 */

public class Instructions3Fragment extends Fragment implements View.OnClickListener {

    private Button btnInstructions3;
    private String name,lastName;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.instructions_3_fragment,container,false);

        btnInstructions3=(Button)view.findViewById(R.id.btnInstructions3);
        btnInstructions3.setOnClickListener(this);

        return view;
    }

    public void getData(String name,String lastName)
    {
        this.name=name;
        this.lastName=lastName;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnInstructions3:
                Toast.makeText(getContext(),"enviando "+name+" "+lastName+" al servidor",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
