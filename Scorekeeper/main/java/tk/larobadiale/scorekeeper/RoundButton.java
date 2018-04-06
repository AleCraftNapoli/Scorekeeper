package tk.larobadiale.scorekeeper;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.Button;

/**
 * Created by Ale on 04/04/2018.
 */


public class RoundButton extends Drawable {
    private int alpha, red, green, blue;
    private Button button;

    public RoundButton(int a, int r, int g, int b, Button btn) {
        alpha = a;
        red = r;
        green = g;
        blue = b;
        button = btn;
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        Paint paint = new Paint();
        paint.setARGB(alpha, red, green, blue);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(button.getWidth()/2, button.getHeight()/2, button.getWidth()/2, paint);
    }

    @Override
    public void setAlpha(int alpha) { }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) { }

    @Override
    public int getOpacity() { return PixelFormat.UNKNOWN; }
}
