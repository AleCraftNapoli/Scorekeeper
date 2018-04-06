package tk.larobadiale.scorekeeper;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

public class ScorekeeperActivity extends AppCompatActivity {
    private Counter counter1, counter2;
    private SurfaceView s1, s2, s3, s4;
    private SharedPreferences sharedPref;
    private Button b1, b2, b3, b4, br1, br2;
    private ConstraintLayout constraintLayoutBackground, constraintLayoutHGDiv1, constraintLayoutHGDiv2, constraintLayoutCounter1, constraintLayoutCounter2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scorekeeper);

        sharedPref = getSharedPreferences("COLORS", Context.MODE_PRIVATE);

        s1 = findViewById(R.id.surfaceViewHGCounter1);
        s2 = findViewById(R.id.surfaceViewHGCounter2);
        s3 = findViewById(R.id.surfaceViewHGCounter3);
        s4 = findViewById(R.id.surfaceViewHGCounter4);
        constraintLayoutBackground = findViewById(R.id.constraintLayoutBackground);
        constraintLayoutHGDiv1 = findViewById(R.id.constraintLayoutHGDiv1);
        constraintLayoutHGDiv2 = findViewById(R.id.constraintLayoutHGDiv2);
        constraintLayoutCounter1 = findViewById(R.id.constraintLayoutCounter1);
        constraintLayoutCounter2 = findViewById(R.id.constraintLayoutCounter2);
        b1 = findViewById(R.id.buttonHGButton1);
        b2 = findViewById(R.id.buttonHGButton2);
        b3 = findViewById(R.id.buttonHGButton3);
        b4 = findViewById(R.id.buttonHGButton4);
        br1 = findViewById(R.id.buttonReset1);
        br2 = findViewById(R.id.buttonReset2);

        counter1 = new Counter(1, getApplicationContext(), s1, s2, constraintLayoutCounter1);
        counter2 = new Counter(2, getApplicationContext(), s3, s4, constraintLayoutCounter2);

        setColors();
        hideStatusNavigationBar(new View(getApplicationContext()));
    }

    public void hideStatusNavigationBar(View decorView) {
        decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION  |
                View.SYSTEM_UI_FLAG_FULLSCREEN  |
                View.SYSTEM_UI_FLAG_IMMERSIVE);
    }

    public void onCounterClick(View view) {
        switch (view.getId()) {
            case R.id.buttonHGButton1: counter1.addOne();
                break;
            case R.id.buttonHGButton2: counter1.remOne();
                break;
            case R.id.buttonHGButton3: counter2.addOne();
                break;
            case R.id.buttonHGButton4: counter2.remOne();
                break;
            case R.id.buttonReset1:    counter1.reset();
                break;
            case R.id.buttonReset2:    counter2.reset();
                break;
        }
    }

    public void setColors() {
        int a, r, g, b;

        // BACKGROUND
        a = sharedPref.getInt("backgroundAlphaVal", 255);
        r = sharedPref.getInt("backgroundRedVal",     0);
        g = sharedPref.getInt("backgroundGreenVal",   0);
        b = sharedPref.getInt("backgroundBlueVal",    0);
        constraintLayoutBackground.setBackground(new FullColorView(a, r, g, b));

        // HG DIV
        a = sharedPref.getInt("hgdivAlphaVal", 255);
        r = sharedPref.getInt("hgdivRedVal", 244);
        g = sharedPref.getInt("hgdivGreenVal", 239);
        b = sharedPref.getInt("hgdivBlueVal", 201);
        constraintLayoutHGDiv1.setBackground(new FullColorView(a, r, g, b));
        constraintLayoutHGDiv2.setBackground(new FullColorView(a, r, g, b));

        // HG BUTTONS
        a = sharedPref.getInt("hgbuttonsAlphaVal", 255);
        r = sharedPref.getInt("hgbuttonsRedVal", 2);
        g = sharedPref.getInt("hgbuttonsGreenVal", 108);
        b = sharedPref.getInt("hgbuttonsBlueVal", 194);
        b1.setBackground (new RoundButton(a, r, g, b, b1 ));
        b2.setBackground (new RoundButton(a, r, g, b, b2 ));
        b3.setBackground (new RoundButton(a, r, g, b, b3 ));
        b4.setBackground (new RoundButton(a, r, g, b, b4 ));
        br1.setBackground(new RoundButton(a, r, g, b, br1));
        br2.setBackground(new RoundButton(a, r, g, b, br2));

        // HG BUTTONS TEXT
        a = sharedPref.getInt("hgbuttonstextAlphaVal", 255);
        r = sharedPref.getInt("hgbuttonstextRedVal", 255);
        g = sharedPref.getInt("hgbuttonstextGreenVal", 255);
        b = sharedPref.getInt("hgbuttonstextBlueVal", 255);
        String alpha = Integer.toHexString(a);
        if (alpha.length() == 1) alpha = "0"+alpha;
        String red = Integer.toHexString(r);
        if (red.length() == 1) red = "0"+red;
        String green = Integer.toHexString(g);
        if (green.length() == 1) green = "0"+green;
        String blue = Integer.toHexString(b);
        if (blue.length() == 1) blue = "0"+blue;
        String color = "#" + alpha + red + green + blue;

        b1.setTextColor (android.graphics.Color.parseColor(color));
        b2.setTextColor (android.graphics.Color.parseColor(color));
        b3.setTextColor (android.graphics.Color.parseColor(color));
        b4.setTextColor (android.graphics.Color.parseColor(color));
        br1.setTextColor(android.graphics.Color.parseColor(color));
        br2.setTextColor(android.graphics.Color.parseColor(color));
    }
}
