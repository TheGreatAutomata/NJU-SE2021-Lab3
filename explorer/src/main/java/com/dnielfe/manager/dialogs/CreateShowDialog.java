package com.dnielfe.manager.dialogs;

//import static android.provider.AlarmClock.EXTRA_MESSAGE;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.dnielfe.manager.MyShowActivity;
import com.dnielfe.manager.R;
import com.dnielfe.manager.adapters.BrowserTabsAdapter;
import com.dnielfe.manager.utils.SimpleUtils;

import java.io.File;

public final class CreateShowDialog extends DialogFragment {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Activity a = getActivity();

        // Set an EditText view to get user input
        final EditText inputf = new EditText(a);
        inputf.setHint("Enter here");

        final AlertDialog.Builder b = new AlertDialog.Builder(a);
        b.setTitle("Show whatever you write");
        //b.setMessage(R.string.createmsg);
        b.setView(inputf);
        b.setPositiveButton("Show",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = inputf.getText().toString();
                        String location = BrowserTabsAdapter.getCurrentBrowserFragment().mCurrentPath;
                        boolean success = (name.length() >= 1);

                        if (success) {
                            Activity mActivity = getActivity();
//                            final AppCompatActivity dialog_temp = new MyShowActivity();
                            Intent intent = new Intent(mActivity, MyShowActivity.class);
                            intent.putExtra(EXTRA_MESSAGE, name);
                            startActivity(intent);
                        }
                        else
                            Toast.makeText(a,
                                    "None!!!",
                                    Toast.LENGTH_SHORT).show();

                        dialog.dismiss();
                    }
                });
        b.setNegativeButton(R.string.cancel,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        return b.create();
    }
}
