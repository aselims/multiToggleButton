package org.selimsinai.multitogglebutton;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;


/**
 * Created by ssalman on 5/5/2014.
 */
public class GoDialogFragment extends DialogFragment {


    View DialogView;
    private EditText mTime;

    private ToggleButton ta;
    private ToggleButton tb;
    private ToggleButton tc;
    private ToggleButton td;


    private String time;

    private String selected;



    public static GoDialogFragment newInstance(int title) {

        GoDialogFragment frag = new GoDialogFragment();


        Bundle args = new Bundle();
        args.putInt("name", title);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        DialogView = getActivity().getLayoutInflater().inflate(R.layout.fragment_go_dialog, null);

        ta = (ToggleButton) DialogView.findViewById(R.id.toggleButtonA);
        tb = (ToggleButton) DialogView.findViewById(R.id.toggleButtonB);
        tc = (ToggleButton) DialogView.findViewById(R.id.toggleButtonC);
        td = (ToggleButton) DialogView.findViewById(R.id.toggleButtonD);
        mTime = (EditText) DialogView.findViewById(R.id.editTextMinutes);


        ta.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {

                    tb.setChecked(false);
                    tc.setChecked(false);
                    td.setChecked(false);
                }
            }
        });

        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){

                    ta.setChecked(false);
                    tc.setChecked(false);
                    td.setChecked(false);
                }
            }
        });
        tc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    tb.setChecked(false);
                    ta.setChecked(false);
                    td.setChecked(false);
                }
            }
        });
        td.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    tb.setChecked(false);
                    tc.setChecked(false);
                    ta.setChecked(false);
                }
            }
        });



        return new AlertDialog.Builder(getActivity())
                .setView(DialogView)
                //.setIcon(R.drawable.)
                .setTitle("title")
                .setCancelable(false)
                .setPositiveButton(R.string.alert_dialog_ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(final DialogInterface dialog,
                                                int whichButton) {


                            }
                        }
                )
                .setNegativeButton(R.string.alert_dialog_cancel,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int whichButton) {

                            }
                        }
                ).create();
    }


    public String getTime() {
        if(mTime.getText() != null)
            time = String.valueOf(mTime.getText());
        return time;
    }

    public void setTime(String time) {
        this.time = time;
        mTime.setText(time);
    }

    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public void onResume() {
        super.onResume();

    }
}
