package tk.larobadiale.scorekeeper;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class OptionsActivity extends AppCompatActivity {

    private int backgroundAlphaVal, backgroundRedVal, backgroundGreenVal, backgroundBlueVal;
    private int hgdivAlphaVal, hgdivRedVal, hgdivGreenVal, hgdivBlueVal;
    private int hgcounterAlphaVal, hgcounterRedVal, hgcounterGreenVal, hgcounterBlueVal;
    private int hgcountertextAlphaVal, hgcountertextRedVal, hgcountertextGreenVal, hgcountertextBlueVal;
    private int hgbuttonsAlphaVal, hgbuttonsRedVal, hgbuttonsGreenVal, hgbuttonsBlueVal;
    private int hgbuttonstextAlphaVal, hgbuttonstextRedVal, hgbuttonstextGreenVal, hgbuttonstextBlueVal;

    private Button buttonBackground, buttonHGDiv, buttonHGCounter, buttonHGCounterText, buttonHGButtons, buttonHGButtonsText;
//    private Switch switchHGDigitBorder;
    private SharedPreferences sharedPref;
    private OptionsActivity activityThis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        activityThis = this;

        buttonBackground = findViewById(R.id.buttonBackground);
        buttonHGDiv = findViewById(R.id.buttonHGDiv);
        buttonHGCounter = findViewById(R.id.buttonHGCounter);
        buttonHGCounterText = findViewById(R.id.buttonHGCounterText);
        buttonHGButtons = findViewById(R.id.buttonHGButtons);
        buttonHGButtonsText = findViewById(R.id.buttonHGButtonsText);
//        switchHGDigitBorder = findViewById(R.id.switchHGDigitBorder);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String refID = Integer.toString(view.getId());
                ColorDialog c = new ColorDialog();
                c.setCaller(activityThis);
                c.show(getSupportFragmentManager(), refID);
            }
        };

        buttonBackground.setOnClickListener(listener);
        buttonHGDiv.setOnClickListener(listener);
        buttonHGCounter.setOnClickListener(listener);
        buttonHGCounterText.setOnClickListener(listener);
        buttonHGButtons.setOnClickListener(listener);
        buttonHGButtonsText.setOnClickListener(listener);

//        switchHGDigitBorder.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SharedPreferences.Editor editor = sharedPref.edit();
//                editor.putBoolean("digitBorder", switchHGDigitBorder.isChecked());
//                editor.commit();
//            }
//        });

        refreshButtons();
    }

    public void refreshButtons() {
        sharedPref = getApplicationContext().getSharedPreferences("COLORS", Context.MODE_PRIVATE);

        backgroundAlphaVal =    sharedPref.getInt("backgroundAlphaVal",   255);
        backgroundRedVal =      sharedPref.getInt("backgroundRedVal",       0);
        backgroundGreenVal =    sharedPref.getInt("backgroundGreenVal",     0);
        backgroundBlueVal =     sharedPref.getInt("backgroundBlueVal",      0);
        hgdivAlphaVal =         sharedPref.getInt("hgdivAlphaVal",        255);
        hgdivRedVal =           sharedPref.getInt("hgdivRedVal",          244);
        hgdivGreenVal =         sharedPref.getInt("hgdivGreenVal",        239);
        hgdivBlueVal =          sharedPref.getInt("hgdivBlueVal",         201);
        hgcounterAlphaVal =     sharedPref.getInt("hgcounterAlphaVal",    255);
        hgcounterRedVal =       sharedPref.getInt("hgcounterRedVal",        2);
        hgcounterGreenVal =     sharedPref.getInt("hgcounterGreenVal",    108);
        hgcounterBlueVal =      sharedPref.getInt("hgcounterBlueVal",     194);
        hgcountertextAlphaVal = sharedPref.getInt("hgcountertextAlphaVal",255);
        hgcountertextRedVal =   sharedPref.getInt("hgcountertextRedVal",  255);
        hgcountertextGreenVal = sharedPref.getInt("hgcountertextGreenVal",255);
        hgcountertextBlueVal =  sharedPref.getInt("hgcountertextBlueVal", 255);
        hgbuttonsAlphaVal =     sharedPref.getInt("hgbuttonsAlphaVal",    255);
        hgbuttonsRedVal =       sharedPref.getInt("hgbuttonsRedVal",        2);
        hgbuttonsGreenVal =     sharedPref.getInt("hgbuttonsGreenVal",    108);
        hgbuttonsBlueVal =      sharedPref.getInt("hgbuttonsBlueVal",     194);
        hgbuttonstextAlphaVal = sharedPref.getInt("hgbuttonstextAlphaVal",255);
        hgbuttonstextRedVal =   sharedPref.getInt("hgbuttonstextRedVal",  255);
        hgbuttonstextGreenVal = sharedPref.getInt("hgbuttonstextGreenVal",255);
        hgbuttonstextBlueVal =  sharedPref.getInt("hgbuttonstextBlueVal", 255);


        buttonBackground.setBackground   (new FullColorView(backgroundAlphaVal,    backgroundRedVal,    backgroundGreenVal,    backgroundBlueVal    ));
        buttonHGDiv.setBackground        (new FullColorView(hgdivAlphaVal,         hgdivRedVal,         hgdivGreenVal,         hgdivBlueVal         ));
        buttonHGCounter.setBackground    (new FullColorView(hgcounterAlphaVal,     hgcounterRedVal,     hgcounterGreenVal,     hgcounterBlueVal     ));
        buttonHGCounterText.setBackground(new FullColorView(hgcountertextAlphaVal, hgcountertextRedVal, hgcountertextGreenVal, hgcountertextBlueVal ));
        buttonHGButtons.setBackground    (new FullColorView(hgbuttonsAlphaVal,     hgbuttonsRedVal,     hgbuttonsGreenVal,     hgbuttonsBlueVal     ));
        buttonHGButtonsText.setBackground(new FullColorView(hgbuttonstextAlphaVal, hgbuttonstextRedVal, hgbuttonstextGreenVal, hgbuttonstextBlueVal ));
//        switchHGDigitBorder.setChecked   (sharedPref.getBoolean("digitBorder", false));
    }
}
