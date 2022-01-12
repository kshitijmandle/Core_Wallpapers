package com.learn.corewallpapers.adapters;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

import com.learn.corewallpapers.R;

public class CustumLoader {
    Activity activity;
    AlertDialog dialog;
    public CustumLoader(Activity myactivity){
        activity = myactivity;

    }
    public void startload(){
          AlertDialog.Builder builder = new AlertDialog.Builder(activity);
          LayoutInflater inflater = activity.getLayoutInflater();
          builder.setView(inflater.inflate(R.layout.custumloader,null));
          builder.setCancelable(false);
          dialog = builder.create();
          dialog.show();

    }
    public void dissmissdialog(){
        dialog.dismiss();
    }

}
