package tk.larobadiale.scorekeeper;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by Ale on 26/03/2018.
 */

public class ColorDialog extends AppCompatDialogFragment {
    private int thisTag, backgroundID, hgdivID, hgcounterID, hgcountertextID, hgbuttonsID, hgbuttonstextID;
    private TextView textViewAlphaVal, textViewRedVal, textViewGreenVal, textViewBlueVal;
    private SeekBar  seekBarAlpha,     seekBarRed,     seekBarGreen,     seekBarBlue;
    private EditText editTextColor;
    private SurfaceView surfaceViewColor;

    private SharedPreferences sharedPref;
    private SharedPreferences.Editor editor;
    private OptionsActivity callerActivity;

    public void setCaller(OptionsActivity caller) {
        callerActivity = caller;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_colordialog, null);

        sharedPref = getActivity().getSharedPreferences("COLORS", Context.MODE_PRIVATE);

        builder.setView(view)
                .setTitle(R.string.pick_color)
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        callerActivity.refreshButtons();
                    }
                })
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        savePreferences(seekBarAlpha, seekBarRed, seekBarGreen, seekBarBlue);
                        callerActivity.refreshButtons();
                    }
                });

        setupVariables(view);

        return builder.create();
    }

    private void savePreferences(SeekBar Alpha, SeekBar Red, SeekBar Green, SeekBar Blue) {
        sharedPref = getActivity().getSharedPreferences("COLORS", Context.MODE_PRIVATE);
        editor = sharedPref.edit();

        int A = Alpha.getProgress();
        int R = Red.getProgress();
        int G = Green.getProgress();
        int B = Blue.getProgress();

        if (thisTag == backgroundID) {
            editor.putInt("backgroundAlphaVal", A);
            editor.putInt("backgroundRedVal", R);
            editor.putInt("backgroundGreenVal", G);
            editor.putInt("backgroundBlueVal", B);
        }
        else if (thisTag == hgdivID) {
            editor.putInt("hgdivAlphaVal", A);
            editor.putInt("hgdivRedVal", R);
            editor.putInt("hgdivGreenVal", G);
            editor.putInt("hgdivBlueVal", B);
        }
        else if (thisTag == hgcounterID) {
            editor.putInt("hgcounterAlphaVal", A);
            editor.putInt("hgcounterRedVal", R);
            editor.putInt("hgcounterGreenVal", G);
            editor.putInt("hgcounterBlueVal", B);
        }
        else if (thisTag == hgcountertextID) {
            editor.putInt("hgcountertextAlphaVal", A);
            editor.putInt("hgcountertextRedVal", R);
            editor.putInt("hgcountertextGreenVal", G);
            editor.putInt("hgcountertextBlueVal", B);
        }
        else if (thisTag == hgbuttonsID) {
            editor.putInt("hgbuttonsAlphaVal", A);
            editor.putInt("hgbuttonsRedVal", R);
            editor.putInt("hgbuttonsGreenVal", G);
            editor.putInt("hgbuttonsBlueVal", B);
        }
        else if (thisTag == hgbuttonstextID) {
            editor.putInt("hgbuttonstextAlphaVal", A);
            editor.putInt("hgbuttonstextRedVal", R);
            editor.putInt("hgbuttonstextGreenVal", G);
            editor.putInt("hgbuttonstextBlueVal", B);
        }

        editor.commit();
    }

    private void setupVariables(View view) {
        surfaceViewColor = view.findViewById(R.id.surfaceViewColor);
        editTextColor = view.findViewById(R.id.editTextColor);

        seekBarAlpha = view.findViewById(R.id.seekBarAlpha);
        seekBarRed = view.findViewById(R.id.seekBarRed);
        seekBarGreen = view.findViewById(R.id.seekBarGreen);
        seekBarBlue = view.findViewById(R.id.seekBarBlue);

        textViewAlphaVal = view.findViewById(R.id.textViewAlphaVal);
        textViewRedVal = view.findViewById(R.id.textViewRedVal);
        textViewGreenVal = view.findViewById(R.id.textViewGreenVal);
        textViewBlueVal = view.findViewById(R.id.textViewBlueVal);

        thisTag = Integer.parseInt(getTag());
        backgroundID = tk.larobadiale.scorekeeper.R.id.buttonBackground;
        hgdivID = tk.larobadiale.scorekeeper.R.id.buttonHGDiv;
        hgcounterID = tk.larobadiale.scorekeeper.R.id.buttonHGCounter;
        hgcountertextID = tk.larobadiale.scorekeeper.R.id.buttonHGCounterText;
        hgbuttonsID = tk.larobadiale.scorekeeper.R.id.buttonHGButtons;
        hgbuttonstextID = tk.larobadiale.scorekeeper.R.id.buttonHGButtonsText;

        //SETTING TO PREVIOUS VALUES
        sharedPref = getActivity().getSharedPreferences("COLORS", Context.MODE_PRIVATE);
        int alphaVal = 255, redVal = 0, greenVal = 0, blueVal = 0;

        if (thisTag == backgroundID) {
            alphaVal = sharedPref.getInt("backgroundAlphaVal", 255);
            redVal = sharedPref.getInt("backgroundRedVal", 0);
            greenVal = sharedPref.getInt("backgroundGreenVal", 0);
            blueVal = sharedPref.getInt("backgroundBlueVal", 0);
        }
        else if (thisTag == hgdivID) {
            alphaVal = sharedPref.getInt("hgdivAlphaVal", 255);
            redVal = sharedPref.getInt("hgdivRedVal", 244);
            greenVal = sharedPref.getInt("hgdivGreenVal", 239);
            blueVal = sharedPref.getInt("hgdivBlueVal", 201);
        }
        else if (thisTag == hgcounterID) {
            alphaVal = sharedPref.getInt("hgcounterAlphaVal", 255);
            redVal = sharedPref.getInt("hgcounterRedVal", 2);
            greenVal = sharedPref.getInt("hgcounterGreenVal", 108);
            blueVal = sharedPref.getInt("hgcounterBlueVal", 194);
        }
        else if (thisTag == hgcountertextID) {
            alphaVal = sharedPref.getInt("hgcountertextAlphaVal", 255);
            redVal = sharedPref.getInt("hgcountertextRedVal", 255);
            greenVal = sharedPref.getInt("hgcountertextGreenVal", 255);
            blueVal = sharedPref.getInt("hgcountertextBlueVal", 255);
        }
        else if (thisTag == hgbuttonsID) {
            alphaVal = sharedPref.getInt("hgbuttonsAlphaVal", 255);
            redVal = sharedPref.getInt("hgbuttonsRedVal", 2);
            greenVal = sharedPref.getInt("hgbuttonsGreenVal", 108);
            blueVal = sharedPref.getInt("hgbuttonsBlueVal", 194);
        }
        else if (thisTag == hgbuttonstextID) {
            alphaVal = sharedPref.getInt("hgbuttonstextAlphaVal", 255);
            redVal = sharedPref.getInt("hgbuttonstextRedVal", 255);
            greenVal = sharedPref.getInt("hgbuttonstextGreenVal", 255);
            blueVal = sharedPref.getInt("hgbuttonstextBlueVal", 255);
        }

        seekBarAlpha.setProgress(alphaVal);
        seekBarRed.setProgress(redVal);
        seekBarGreen.setProgress(greenVal);
        seekBarBlue.setProgress(blueVal);
        textViewAlphaVal.setText(seekBarAlpha.getProgress() + "");
        textViewRedVal.setText(seekBarRed.getProgress() + "");
        textViewGreenVal.setText(seekBarGreen.getProgress() + "");
        textViewBlueVal.setText(seekBarBlue.getProgress() + "");
        surfaceViewColor.setBackground(new FullColorView(seekBarAlpha.getProgress(), seekBarRed.getProgress(), seekBarGreen.getProgress(), seekBarBlue.getProgress()));
        surfaceViewColor.setAlpha(((float) seekBarAlpha.getProgress()) / 255);
        updateEditText();

        //SLIDER LISTENER
        SeekBar.OnSeekBarChangeListener listener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int val, boolean b) {
                if (seekBar == seekBarAlpha) {
                    textViewAlphaVal.setText(val + "");
                } else if (seekBar == seekBarRed) {
                    textViewRedVal.setText(val + "");
                } else if (seekBar == seekBarGreen) {
                    textViewGreenVal.setText(val + "");
                } else if (seekBar == seekBarBlue) {
                    textViewBlueVal.setText(val + "");
                }

                surfaceViewColor.setBackground(new FullColorView(seekBarAlpha.getProgress(), seekBarRed.getProgress(), seekBarGreen.getProgress(), seekBarBlue.getProgress()));
                surfaceViewColor.setAlpha(((float) seekBarAlpha.getProgress())/255);
                updateEditText();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        };

        seekBarAlpha.setOnSeekBarChangeListener(listener);
        seekBarRed.setOnSeekBarChangeListener(listener);
        seekBarGreen.setOnSeekBarChangeListener(listener);
        seekBarBlue.setOnSeekBarChangeListener(listener);

        //EDITTEXT FILTERS
        editTextColor.setFilters(new InputFilter[] {new HexadecimalInputFilter(true), new InputFilter.LengthFilter(8)});

        //SURFACE LISTENER
        surfaceViewColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateSeekBars();
            }
        });
    }

    private void updateEditText() {
        String Alpha = Integer.toHexString(seekBarAlpha.getProgress()).toUpperCase();
        String Red =   Integer.toHexString(seekBarRed.getProgress()).toUpperCase();
        String Green = Integer.toHexString(seekBarGreen.getProgress()).toUpperCase();
        String Blue =  Integer.toHexString(seekBarBlue.getProgress()).toUpperCase();

        if (Alpha.length() == 1) Alpha = "0" + Alpha;
        if (Red.length() == 1)   Red =     "0" + Red;
        if (Green.length() == 1) Green = "0" + Green;
        if (Blue.length() == 1)  Blue =   "0" + Blue;

        String out = (Alpha + Red + Green + Blue);
        editTextColor.setText(out);
    }

    private void updateSeekBars() {
        String color = editTextColor.getText().toString();
        String alpha, red, green, blue;

        try { alpha = color.substring(0, 2); }
        catch (Exception e) { alpha = "0"; }

        try { red = color.substring(2, 4); }
        catch (Exception e) { red = "0"; }

        try { green = color.substring(4, 6); }
        catch (Exception e) { green = "0"; }

        try { blue = color.substring(6, 8); }
        catch (Exception e) { blue = "0"; }



        int a = Integer.parseInt(alpha, 16);
        int r = Integer.parseInt(red, 16);
        int g = Integer.parseInt(green, 16);
        int b = Integer.parseInt(blue, 16);

        seekBarAlpha.setProgress(a);
        seekBarRed.setProgress(r);
        seekBarGreen.setProgress(g);
        seekBarBlue.setProgress(b);
    }
}
