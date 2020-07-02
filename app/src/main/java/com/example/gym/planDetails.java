package com.example.gym;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class planDetails extends DialogFragment {

    public interface  PassplanInterface{
        void  Getplan(plan plan);
    }

    private PassplanInterface passplanInterface;

    private Spinner spinner;
    private Button BtnDISMISS,BtnADD;
    private TextView TrnNme;
    private EditText minutes;


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View v =getActivity().getLayoutInflater()
                .inflate(R.layout.dialog_plan,null);
        initViews(v);
        AlertDialog.Builder builder =new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle("Dialog");
        Bundle bundle =getArguments();
        if (null !=bundle){
            final Model m = bundle.getParcelable("key");
            if (null != m){
                TrnNme.setText(m.getTitle());
                BtnDISMISS.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dismiss();
                    }
                });
                  BtnADD.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View v) {
                          String day =spinner.getSelectedItem().toString();
                          int minute = Integer.valueOf(minutes.getText().toString());
                          plan plan = new plan(minute,day,m,false);

                          try {
                              passplanInterface =(PassplanInterface)getActivity();
                              passplanInterface.Getplan(plan);
                              dismiss();
                          }catch (ClassCastException e){
                              e.printStackTrace();
                              dismiss();
                          }

                      }
                  });
            }
        }

        return builder.create();

    }
    private void initViews(View v){
        spinner =v.findViewById(R.id.spinner);
       BtnADD =v.findViewById(R.id.Add);
        BtnDISMISS =v.findViewById(R.id.Dismiss);
        TrnNme =v.findViewById(R.id.txtTrainingName);
       minutes =v.findViewById(R.id.minutes);

    }
}
