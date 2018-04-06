package tk.larobadiale.scorekeeper;

import android.text.InputFilter;
import android.text.Spanned;

/**
 * Created by Pratik Sharma (https://stackoverflow.com/a/14212734).
 */

@SuppressWarnings("WeakerAccess")
public class DecimalInputFilter implements InputFilter {

    private int min, max;

    public DecimalInputFilter(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        try {
            int input = Integer.parseInt(dest.toString() + source.toString());
            if (isInRange(min, max, input))
                return null;
        } catch (NumberFormatException nfe) { }
        return "";
    }

    private boolean isInRange(int a, int b, int c) {
        return b > a ? c >= a && c <= b : c >= b && c <= a;
    }
}