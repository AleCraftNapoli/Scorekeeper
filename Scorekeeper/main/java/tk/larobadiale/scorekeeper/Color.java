package tk.larobadiale.scorekeeper;

/**
 * Created by Ale on 04/04/2018.
 */

public class Color {
    private int alpha, red, green, blue;

    public Color(int A, int R, int G, int B) {
        this.alpha = A;
        this.red = R;
        this.green = G;
        this.blue = B;
    }

    public void setAlpha(int alpha) { this.alpha = alpha; }
    public int getAlpha()           { return alpha; }

    public void setRed(int red)     { this.red = red; }
    public int getRed()             { return red; }

    public void setGreen(int green) { this.green = green; }
    public int getGreen()           { return green; }

    public void setBlue(int blue)   { this.blue = blue; }
    public int getBlue()            { return blue; }
}
