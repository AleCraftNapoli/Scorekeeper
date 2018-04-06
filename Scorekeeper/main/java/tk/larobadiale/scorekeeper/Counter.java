package tk.larobadiale.scorekeeper;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.constraint.ConstraintLayout;
import android.view.SurfaceView;
import android.widget.TextView;

/**
 * Created by Ale on 29/03/2018.
 */

@SuppressWarnings("WeakerAccess")
public class Counter {
    private int id, val;
    private String st1, st2;
    private SurfaceView s1, s2;
    private Color HGCounter, HGCounterText;
    private ConstraintLayout constraintLayout;
    private SharedPreferences sharedPref, sharedCol;
    private SharedPreferences.Editor editor;

    public Counter(int id, Context ctx, SurfaceView s1, SurfaceView s2, ConstraintLayout cL) {
        this.id = id;
        this.s1 = s1;
        this.s2 = s2;
        this.constraintLayout = cL;
        this.sharedPref = ctx.getSharedPreferences("COUNTERS", Context.MODE_PRIVATE);
        this.sharedCol = ctx.getSharedPreferences("COLORS", Context.MODE_PRIVATE);
        this.val = sharedPref.getInt("Val"+id,  0);
        setColors();
        reload();
    }

    public void addOne() {
        if (val >= 99) {
            val = 98;
        }
        val++;

        reload();
    }

    public void remOne() {
        if (val <= 0) {
            val = 1;
        }
        val--;

        reload();
    }

    public void reset() {
        val = 0;

        reload();
    }

    private void setColors() {
        int a, r, g, b;

        a = sharedCol.getInt("hgcounterAlphaVal", 255);
        r = sharedCol.getInt("hgcounterRedVal", 2);
        g = sharedCol.getInt("hgcounterGreenVal", 108);
        b = sharedCol.getInt("hgcounterBlueVal", 194);
        HGCounter = new Color(a, r, g, b);

        a = sharedCol.getInt("hgcountertextAlphaVal", 255);
        r = sharedCol.getInt("hgcountertextRedVal", 255);
        g = sharedCol.getInt("hgcountertextGreenVal", 255);
        b = sharedCol.getInt("hgcountertextBlueVal", 255);
        HGCounterText = new Color(a, r, g, b);
    }

    private void reload() {
        st1 = Integer.toString(((val%100) - (val%10))/10);
        st2 = Integer.toString(val%10);

        this.editor = sharedPref.edit();
        editor.putInt("Val"+id, val);
        editor.commit();

        s1.setBackground(new TextDrawer(HGCounter, s1, HGCounterText, st1));
        s2.setBackground(new TextDrawer(HGCounter, s2, HGCounterText, st2));
        if (!(sharedCol.getBoolean("digitBorder", false))) {
            constraintLayout.setBackground(new FullColorView(HGCounter.getAlpha(), HGCounter.getRed(), HGCounter.getGreen(), HGCounter.getBlue()));
        }
    }
}
