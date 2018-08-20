package droid.demos.com.ejemplo1.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import droid.demos.com.ejemplo1.R;
import droid.demos.com.ejemplo1.views.MainActivity;

/**
 * Created by carlos on 26/03/2018.
 */

public class Instructions1Fragment extends Fragment implements View.OnClickListener {

    private Switch switch1;
    private Button btnInstructions1;
    private EditText edtName,edtLastName;
    private OnSendDataToInstructions2 onSendDataToInstructions2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.instructions_1_fragment,container,false);

        btnInstructions1=(Button)view.findViewById(R.id.btnInstructions1);
        edtLastName=(EditText)view.findViewById(R.id.edtLastName);
        edtName=(EditText)view.findViewById(R.id.edtName);
        switch1=(Switch)view.findViewById(R.id.switch1);
        btnInstructions1.setOnClickListener(this);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    Toast.makeText(getContext(),"checked",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getContext(),"not checked",Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnInstructions1:
                goToInstrcutions2();
                break;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onSendDataToInstructions2=(OnSendDataToInstructions2)context;
    }

    private void goToInstrcutions2()
    {
        MainActivity.viewPager.setCurrentItem(getItem(1),true);
        String name=edtName.getText().toString();
        String lastName=edtLastName.getText().toString();
        onSendDataToInstructions2.sendData(name,lastName);
    }

    private int getItem(int i)
    {
        return MainActivity.viewPager.getCurrentItem()+i;
    }

    public interface OnSendDataToInstructions2
    {
        public void sendData(String name,String lastName);
    }

}
