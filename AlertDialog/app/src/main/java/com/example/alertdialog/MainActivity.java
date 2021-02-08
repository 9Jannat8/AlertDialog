package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button exitButton;
    private AlertDialog.Builder alertDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exitButton = findViewById(R.id.buttonId);
        exitButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        alertDialogBuilder = new AlertDialog.Builder(this);

        //for setting title
        alertDialogBuilder.setTitle(R.string.title_text);
        //for setting message
        alertDialogBuilder.setMessage(R.string.message_text);
        //for setting icon..need to download a dialog
        alertDialogBuilder.setIcon(R.drawable.ic_launcher_foreground);

        //alert dialog betito onno kono khane click korle alertDialog cole jabe na
        alertDialogBuilder.setCancelable(false);
        //for setting positive
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //exit
                finish();
            }
        });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Toast.makeText(MainActivity.this, "You have clicked on no button", Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });

        alertDialogBuilder.setNeutralButton("Cancle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "You have clicked on cancle button", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}