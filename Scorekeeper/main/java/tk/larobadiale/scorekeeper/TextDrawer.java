package tk.larobadiale.scorekeeper;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.SurfaceView;

/**
 * Created by Ale on 04/04/2018.
 */

public class TextDrawer extends Drawable {
    private SurfaceView surface;
    private Color bg, tx;
    private String s;

    public TextDrawer(Color bg, SurfaceView surfaceView, Color tx, String text) {
        this.surface = surfaceView;
        this.bg = bg;
        this.tx = tx;
        this.s = text;
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        Paint p = new Paint();
        p.setARGB(bg.getAlpha(), bg.getRed(), bg.getGreen(), bg.getBlue());
        p.setStyle(Paint.Style.FILL);
        canvas.drawPaint(p);
        p.setARGB(tx.getAlpha(), tx.getRed(), tx.getGreen(), tx.getBlue());
        p.setTextSize(surface.getWidth()*1.75F);
        canvas.drawText(s, 5, surface.getHeight()*0.9225F, p);
    }

    @Override
    public void setAlpha(int alpha) { }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) { }

    @Override
    public int getOpacity() { return PixelFormat.UNKNOWN; }
}
