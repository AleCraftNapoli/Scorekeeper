package tk.larobadiale.scorekeeper;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by Ale on 28/03/2018.
 */

@SuppressWarnings("WeakerAccess")
public class FullColorView extends Drawable {
    private int alpha, red, green, blue;

    public FullColorView(int a, int r, int g, int b) {
        alpha = a;
        red = r;
        green = g;
        blue = b;
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        canvas.drawARGB(alpha, red, green, blue);
    }

    @Override
    public void setAlpha(int i) { }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) { }

    @Override
    public int getOpacity() {
        return PixelFormat.UNKNOWN;
    }
}
