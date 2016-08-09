package com.example.workspace.iwish;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by WorkSpace on 03/08/2016.
 */
class DateDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    TextView txtDate;
    public DateDialog(View view){
        txtDate= (TextView) view;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c=Calendar.getInstance();

        int year=c.get(Calendar.YEAR);
        int month=c.get(Calendar.MONTH);
        int day=c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePicker= new DatePickerDialog(getActivity(), AlertDialog.THEME_DEVICE_DEFAULT_DARK,this,year,month,day);
        return datePicker;
    }


    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        String date= year+"-"+month+"-"+dayOfMonth;
        txtDate.setText(date);
    }
}
