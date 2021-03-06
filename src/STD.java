import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Random;
import java.util.Vector;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.DateField;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Gauge;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.Spacer;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextBox;
import javax.microedition.lcdui.TextField;
import javax.microedition.lcdui.Ticker;
import javax.microedition.lcdui.game.Sprite;
import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;

public class STD extends Canvas implements CommandListener {

    public static Random RNG;
    public static Image I;
    public static Autorun T;
    public static Graphics G;
    public static int KC;
    public static int KP;
    public static STD THIS;

    private static Image offScreenImage;
    private static Graphics offScreenGc;

    public static int W;
    public static int H;

    public static int PX = 0;
    public static int PY = 0;

    public boolean bPressed;

    public static java.util.Hashtable gelHashtable = new java.util.Hashtable();
    private static final SprHashtable spriteHashtable = new SprHashtable();
    private static final Hashtable commandHashtable = new Hashtable();

    private static Form userForm;
    private static TextBox inputTB;
    private static Command userProceedCommand, userCancelCommand, cmd;
    public static String waitObject;
    private static int userExitStatus;
    private static List list;

    public static Player P;
    public static final float E = 2.7182817f;
    public static final float PI = 3.1415927f;
    public static final float SQRT3 = 1.7320508f;
    public static final float LOG10 = 2.3025851f;
    public static final float LOGdiv2 = -0.6931472f;
    private static final AlertType[] alertTypes;
    private static final Hashtable bodies;
    private static Random rnd;

    public static final int GAME_UP = 0x0001;
    public static final int GAME_DOWN = 0x0002;
    public static final int GAME_LEFT = 0x0004;
    public static final int GAME_RIGHT = 0x0008;
    public static final int GAME_FIRE = 0x0010;
    public static final int GAME_A = 0x0020;
    public static final int GAME_B = 0x0040;
    public static final int GAME_C = 0x0080;
    public static final int GAME_D = 0x0100;
    public static int gameActionBits = 0;

    public static float NaNf = Float.NaN;
    private static boolean pressed = false;
    private static boolean hold = false;
    private static boolean dragged = false;

    public STD() {
        super();
        setFullScreenMode(true);
        bPressed = false;
        userForm = null;
        W = getWidth();
        H = getHeight();
        offScreenImage = Image.createImage(W, H);
        offScreenGc = offScreenImage.getGraphics();
        userForm = null;
        userExitStatus = 0;
        userCancelCommand = null;
        userProceedCommand = null;
        waitObject = "X";
        THIS = STD.this;
    }

    public void sizeChanged(int w, int h) {
        W = w;
        H = h;
        repaint();
    }

    public void paint(Graphics g) {
        // g.drawImage(I, 0, 0, 20);  
        offScreenGc.drawImage(I, 0, 0, 20);
        g.drawImage(offScreenImage, 0, 0, Graphics.TOP | Graphics.LEFT);
        Enumeration spriteEnumeration = spriteHashtable.elements();

        while (spriteEnumeration.hasMoreElements()) {
            ((Sprite) spriteEnumeration.nextElement()).paint(offScreenGc);
        }

        g.drawImage(offScreenImage, 0, 0, Graphics.TOP | Graphics.LEFT);
    }

    public static int _pointPressed(int i) {
        if (pressed) {
            pressed = false;
            return 1;
        } else {
            return 0;
        }
    }

    public static int _pointDragged(int i) {
        if (dragged) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int _pointHold(int i) {
        if (hold) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int _pointX(int i) {
        return PX;
    }

    public static int _pointY(int i) {
        return PY;
    }

    public void pointerPressed(int x, int y) {
        pressed = true;
        hold = true;
        PX = x;
        PY = y;
    }

    public void pointerDragged(int x, int y) {
        pressed = false;
        dragged = true;
        hold = false;
        PX = x;
        PY = y;
    }

    public void pointerReleased(int x, int y) {
        //pressed = true;
        hold = false;
        dragged = false;

    }

    public void keyPressed(int keyCode) {
        KP = KC = keyCode;
        bPressed = true;
        switch (this.getGameAction(keyCode)) {
            case 1:
                gameActionBits = 1;
                break;
            case 2:
                gameActionBits = 4;
            case 3:
            case 4:
            case 7:
            default:
                break;
            case 5:
                gameActionBits = 8;
                break;
            case 6:
                gameActionBits = 2;
                break;
            case 8:
                gameActionBits = 16;
                break;
            case 9:
                gameActionBits = 32;
                break;
            case 10:
                gameActionBits = 64;
                break;
            case 11:
                gameActionBits = 128;
                break;
            case 12:
                gameActionBits = 256;
        }
    }

    public void keyReleased(int keyCode) {
        KP = 0;
        bPressed = false;
        gameActionBits = 0;
    }

    public static boolean equals(Object o1, Object o2) {
        if (o1 == null) {
            return o2 == null;
        }
        if (o2 == null) {
            return o1 == null;
        }
        return o1.equals(o2);
    }

    public static void _CLS() {
        int prev = G.getColor();
        G.setColor(255, 255, 255);
        _fillRect(0, 0, _getWidth(0), _getHeight(0));
        G.setColor(prev);
        xposText = 0;
        yposText = 0;
    }

    public static int _Up(int i) {
        return (gameActionBits & GAME_UP);
    }

    public static int _Down(int i) {
        return (gameActionBits & GAME_DOWN);
    }

    public static int _Left(int i) {
        return (gameActionBits & GAME_LEFT);
    }

    public static int _Right(int i) {
        return (gameActionBits & GAME_RIGHT);
    }

    public static int _Fire(int i) {
        return (gameActionBits & GAME_FIRE);
    }

    public static int _GameA(int i) {
        return (gameActionBits & GAME_A);
    }

    public static int _GameB(int i) {
        return (gameActionBits & GAME_B);
    }

    public static int _GameC(int i) {
        return (gameActionBits & GAME_C);
    }

    public static int _GameD(int i) {
        return (gameActionBits & GAME_D);
    }

    public static int _INKEY(int i) {
        return KP;
    }

    public static int _rand(int min, int max) {
        _randomize();
        return min + ((rnd.nextInt() >>> 1) % (max - min));
    }

    public static void _DelSprite(String key) {
        spriteHashtable.remove(key);
    }

    public static void _DelGel(String key) {
        gelHashtable.remove(key);
    }

    public static void _GelGrab(String name, int x, int y, int w, int h) {
        Image image = Image.createImage(w, h);
        Graphics gr = image.getGraphics();
        gr.drawImage(I, -x, -y, 20);
        gelHashtable.put(name, image);
    }

    public static int _GelWidth(String name) {
        Image var2;
        int var3;
        if ((var2 = (Image) gelHashtable.get(name)) != null) {
            var3 = var2.getWidth();
        } else {
            var3 = 0;
        }

        return var3;
    }

    public static int _GelHeight(String var1) {
        Image var2;
        int var3;
        if ((var2 = (Image) gelHashtable.get(var1)) != null) {
            var3 = var2.getHeight();
        } else {
            var3 = 0;
        }

        return var3;
    }

    public static void _ColorAlphaGel(String name, int a, int r1, int g1, int b1) {
        Image img = (Image) gelHashtable.get(name);
        if (img == null) {
            return;
        }
        int color = (0xff << 24) | (r1 << 16) | (g1 << 8) | b1;
        int w = img.getWidth();
        int h = img.getHeight();
        int length = w * h;
        int[] rgbData = new int[length];
        img.getRGB(rgbData, 0, w, 0, 0, w, h);
        int pixel, r, g, b;
        for (int k = 0; k < length; k++) {
            pixel = rgbData[k];
            if (pixel == color) {
                r = (pixel >> 16) & 0xff;
                g = (pixel >> 8) & 0xff;
                b = pixel & 0xff;
                rgbData[k] = (a << 24) | ((r << 16) | (g << 8) | b);
            }
        }
        gelHashtable.put(name, Image.createRGBImage(rgbData, w, h, true));
    }

    public static void _AlphaGel(String name, int i) {
        Image img = (Image) gelHashtable.get(name);
        if (img == null) {
            return;
        }
        int w = img.getWidth();
        int h = img.getHeight();
        int length = w * h;
        int[] rgbData = new int[length];
        img.getRGB(rgbData, 0, w, 0, 0, w, h);
        int pixel, r, g, b;
        for (int k = 0; k < length; k++) {
            pixel = rgbData[k];
            r = (pixel >> 16) & 0xff;
            g = (pixel >> 8) & 0xff;
            b = pixel & 0xff;
            rgbData[k] = (i << 24) | ((r << 16) | (g << 8) | b);
        }
        gelHashtable.put(name, Image.createRGBImage(rgbData, w, h, true));
    }

    public static void _GelLoad(String var1, String var2) {
        Image var3 = null;
        try {
            if (!var2.startsWith("file:")) {
                var3 = Image.createImage("/" + var2);
            }
            gelHashtable.put(var1, var3);
        } catch (IOException ex) {
        }
        System.gc();
    }

    public static void _DrawGel(String nameGel, int x, int y) {
        Image img = (Image) gelHashtable.get(nameGel);
        if (img != null) {
            G.drawImage(img, x, y, 20);
        }
    }

    public static void _SpriteGEL(String nameSpr, String nameGel) {
        Image img;
        if ((img = (Image) gelHashtable.get(nameGel)) != null) {
            spriteHashtable.put(nameSpr, new Sprite(img));
        } else {
            // throw new Exception(256, "Invalid GEL");
        }
    }

    public static void _SpriteMove(String var1, int var2, int var3) {
        Sprite var4;
        if ((var4 = (Sprite) spriteHashtable.get(var1)) != null) {
            var4.setPosition(var2, var3);
            //  ((Sprite) var4).paint(offScreenGc);
        } else {
            //throw new BasicError(257, "Invalid Sprite");
        }
    }

    public static int _SpriteHit(String name1, String name2) {
        Sprite spr1 = ((Sprite) spriteHashtable.get(name1));
        Sprite spr2 = ((Sprite) spriteHashtable.get(name2));
        if (spr1 != null && spr2 != null) {
            byte result = 0;
            if (spr1.collidesWith(spr2, true)) {
                result = 1;
            }
            return result;
        }
        return 0;
    }

    public static void _setFont(int fontSize) {
        Font font;
        /*
         * FACE_ {MONOSPACE|PROPORTIONAL|SYSTEM}
         * SIZE_ {SMALL|MEDIUM|LARGE}
         * STYLE_ {BOLD|ITALIC|PLAIN|UNDERLINE}
         */

        //System.out.println("fontSize = " + fontSize);
        switch (fontSize) {
            case 1:
                font = Font.getFont(Font.FACE_MONOSPACE,
                        Font.STYLE_PLAIN,
                        Font.SIZE_SMALL);
                break;
            case 2:
            default:
                font = Font.getFont(Font.FACE_MONOSPACE,
                        Font.STYLE_PLAIN,
                        Font.SIZE_MEDIUM);
                break;
            case 3:
                font = Font.getFont(Font.FACE_MONOSPACE,
                        Font.STYLE_PLAIN,
                        Font.SIZE_LARGE);
        }

        int charWidth = font.charWidth('W');
        int widthInPixels = _getWidth(0);
        int widthInChars = widthInPixels / charWidth;
        if (fontSize == 0 && widthInChars < 12) {
            //System.out.println("Auto: Changing to SMALL Font");
            font = Font.getFont(Font.FACE_MONOSPACE,
                    Font.STYLE_PLAIN,
                    Font.SIZE_SMALL);
        }
        G.setFont(font);
        offScreenGc.setFont(font);
    }

    public static String _str(int obj) {
        return String.valueOf(obj);
    }

    public static String _str(double obj) {
        return String.valueOf(obj);
    }

    public static String _str(float obj) {
        return String.valueOf(obj);
    }

    public static void _drawArc(int x, int y, int w, int h, int start, int end) {
        G.drawArc(x, y, w, h, start, end);
    }

    public static void _drawEllipse(int x, int y, int w, int h) {
        G.drawArc(x, y, w, h, 0, 360);
    }

    public static void _drawImage(Image i, int x, int y) {
        G.drawImage(i, x, y, 20);
    }

    public static void _drawLine(int x1, int y1, int x2, int y2) {
        G.drawLine(x1, y1, x2, y2);
    }

    public static void _setFont(int face, int style, int size) {
        try {
            G.setFont(Font.getFont(face, style, size));
        } catch (Throwable t) {
            G.setFont(Font.getDefaultFont());
        }
    }

    public static void _Blit(int var1, int var2, int var3, int var4, int var5, int var6) {
        int var7 = G.getClipX();
        int var8 = G.getClipY();
        int var9 = G.getClipWidth();
        int var10 = G.getClipHeight();
        offScreenGc.drawImage(I, -var1, -var2, 20);
        G.setClip(var5, var6, var3, var4);
        G.drawImage(offScreenImage, var5, var6, 20);
        G.setClip(var7, var8, var9, var10);
    }

    static int yposText = 0, xposText = 0, nlines = 0;

    public static void _print(int integ) {
        _print(integ + "");
    }

    public static void _print(double integ) {
        _print(integ + "");
    }

    public static void _print(String string) {
        string += "\n";
        int heightInPixels = _getHeight(0);
        int heightInChars = heightInPixels / G.getFont().getHeight();
        int strlen = string.length();

        int charWidth = G.getFont().charWidth('W');

        for (int i = 0; i < strlen; ++i) {
            char ch;
            if ((ch = string.charAt(i)) == '\n' || xposText + charWidth > _getWidth(0)) {

                xposText = 0;
                yposText += G.getFont().getHeight();
                if (yposText + G.getFont().getHeight() > heightInPixels) {

                    nlines = 0;

                    _Blit(0, G.getFont().getHeight(), _getWidth(0), heightInPixels - G.getFont().getHeight(), 0, 0);
                    yposText -= G.getFont().getHeight();
                    ++nlines;
                }
            }

            /*
             * Clear line if at start of line
             */
            if (xposText == 0) {
                G.setColor(0xffffff);
                G.fillRect(0, yposText, _getWidth(0), G.getFont().getHeight());
                G.setColor(0);
            }

            /*
             * Draw Character if not newline
             */
            if (ch != '\n') {
                if (i == -1) {
                    G.setColor(0);
                    G.fillRect(xposText, yposText, charWidth, G.getFont().getHeight());
                    G.setColor(0xffffff);
                } else {
                    G.setColor(0);
                }

                G.drawChar(ch, xposText + charWidth / 2, yposText, 17);
                xposText += charWidth;
            }
        }

        //return true;
    }

    public static void _setColor(int red, int green, int blue) {
        if (red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || blue > 255) {
            return;
        }
        try {
            G.setColor(red, green, blue);
        } catch (Throwable t) {
        }
    }

    public static void _setColor(int RGB) {
        try {
            G.setColor(RGB);
        } catch (Throwable t) {
        }
    }

    public static void _setClip(int x, int y, int width, int height) {
        G.setClip(x, y, width, height);
    }

    public static int _getColorRed() {
        return G.getRedComponent();
    }

    public static int _getColorGreen() {
        return G.getGreenComponent();
    }

    public static int _getColorBlue() {
        return G.getBlueComponent();
    }

    public static void _fillTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        G.fillTriangle(x1, y1, x2, y2, x3, y3);
    }

    public static void _fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
        G.fillRoundRect(x, y, width, height, arcWidth, arcHeight);
    }

    public static void _fillRect(int x, int y, int width, int height) {
        G.fillRect(x, y, width, height);
    }

    public static void _fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
        G.fillArc(x, y, width, height, startAngle, arcAngle);
    }

    public static void _fillEllipse(int x, int y, int width, int height) {
        G.fillArc(x, y, width, height, 0, 360);
    }

    public static void _drawText(String str, int x, int y) {
        G.drawString(str, x, y, 20);
    }

    public static void _drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
        G.drawRoundRect(x, y, width, height, arcWidth, arcHeight);
    }

    public static void _drawRect(int x, int y, int width, int height) {
        G.drawRect(x, y, width, height);
    }

    public static void _drawChar(char character, int x, int y, int anchor) {
        G.drawChar(character, x, y, anchor);
    }

    public static int _getColorsNum(int bom) {
        return FW.fw.display.numColors();
    }

    public static int _getHeight(int i) {
        return T.getHeight();
    }

    public static int _getWidth(int i) {
        return T.getWidth();
    }

    public static int _getImageHeight(Image im) {
        if (im == null) {
            return -1;
        }
        return im.getHeight();
    }

    public static int _getImageWidth(Image im) {
        if (im == null) {
            return -1;
        }
        return im.getWidth();
    }

    public static int _getStringHeight(String s) {
        return G.getFont().getHeight();
    }

    public static int _getStringWidth(String s) {
        return G.getFont().stringWidth(s);
    }

    public static int _isColorDisplay(int bom) {
        return (FW.fw.display.isColor()) ? 1 : 0;
    }

    public static Image _loadImage(String url) {
        try {
            return Image.createImage(url);
        } catch (IOException ex) {
        }
        return null;
    }

    public static void _plot(int x, int y) {
        G.drawLine(x, y, x, y);
    }

    public static void _repaint() {
        if (FW.display.getCurrent() != STD.THIS) {
            FW.display.setCurrent(STD.THIS);
        }
        T.repaint();
        T.serviceRepaints();
    }

    public static void _setDefaultFont() {
        G.setFont(Font.getDefaultFont());
    }

    public static int _getKeyClicked() {
        return KP;
    }

    public static int _getKeyPressed() {
        if (T.bPressed) {
            return KP;
        }
        return 0;
    }

    public static int _keyToAction(int key) {
        return T.getGameAction(key);
    }

    public static void _delay(int time) {
        try {
            Thread.sleep((long) time);
        } catch (Throwable t) {
        }
    }

    public static int _getCurrentTime() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    public static int _getDay(int time) {
        return getCalendar(time).get(5);
    }

    public static int _getHour(int time) {
        return getCalendar(time).get(11);
    }

    public static int _getMinute(int time) {
        return getCalendar(time).get(12);
    }

    public static int _getMonth(int time) {
        return getCalendar(time).get(2) + 1;
    }

    public static int _getRelativeTimeMs() {
        return (int) System.currentTimeMillis();
    }

    public static int _getSecond(int time) {
        return getCalendar(time).get(13);
    }

    public static int _getWeekDay(int time) {
        return getCalendar(time).get(7) + 1;
    }

    public static int _getYear(int time) {
        return getCalendar(time).get(1);
    }

    public static int _getYearDay(int time) {
        Calendar cal = getCalendar(time);
        int fm = 28;
        int year = cal.get(1);
        if (year % 4 == 0 && year % 400 != 0) {
            fm++;
        }
        int[] days = new int[]{31, fm, 31, 30, 31, 30, 31, 31, 30, 31};
        int month = cal.get(2);
        int yearDay = 0;
        int i = 0;
        for (; i < month; i++) {
            yearDay += days[i];
        }
        return yearDay + cal.get(5);
    }

    private static Calendar getCalendar(int time) {
        long millis = (long) time * 1000;
        Calendar cal = Calendar.getInstance();
        Date dt = new Date(millis);
        cal.setTime(dt);
        return cal;
    }

    public static float _sin(float i) {
        return (float) Math.sin((double) i);
    }

    public static float _cos(float i) {
        return (float) Math.cos((double) i);
    }

    public static float _tan(float a) {
        return (float) Math.tan((double) a);
    }

    public static float _asin(float x) {
        if ((double) x < -1.0 || (double) x > 1.0) {
            return NaNf;
        }
        if ((double) x == -1.0) {
            return -1.5707964f;
        }
        if (x == 1.0f) {
            return 1.5707964f;
        }
        return _atan(x / (float) Math.sqrt((double) (1.0f - x * x)));
    }

    public static float _acos(float x) {
        float f = _asin(x);
        if (f == NaNf) {
            return f;
        }
        return 1.5707964f - f;
    }

    public static float _atan(float x) {
        boolean signChange = false;
        boolean Invert = false;
        int sp = 0;
        if ((double) x < 0.0) {
            x = -x;
            signChange = true;
        }
        if ((double) x > 1.0) {
            x = 1.0f / x;
            Invert = true;
        }
        while (x > 0.2617994f) {
            sp++;
            float a = x + 1.7320508f;
            a = 1.0f / a;
            x *= 1.7320508f;
            x--;
            x *= a;
        }
        float x2 = x * x;
        float a = x2 + 1.4087812f;
        a = 0.5591371f / a;
        a = (float) ((double) a + 0.60310579);
        a = (float) ((double) a - (double) x2 * 0.05160454);
        for (a *= x; sp > 0; sp--) {
            a += 0.5235988f;
        }
        if (Invert) {
            a = 1.5707964f - a;
        }
        if (signChange) {
            a = -a;
        }
        return a;
    }

    public static float _atan2(float y, float x) {
        if ((double) y == 0.0 && (double) x == 0.0) {
            return 0.0f;
        }
        if ((double) x > 0.0) {
            return _atan(y / x);
        }
        if ((double) x < 0.0) {
            if ((double) y < 0.0) {
                return -(3.1415927f - _atan(y / x));
            }
            return 3.1415927f - _atan(-y / x);
        }
        if ((double) y < 0.0) {
            return -1.5707964f;
        }
        return 1.5707964f;
    }

    public static float _toRadians(float angdeg) {
        return angdeg / 180.0f * 3.1415927f;
    }

    public static float _toDegrees(float angrad) {
        return angrad * 180.0f / 3.1415927f;
    }

    public static float _exp(float x) {
        if ((double) x == 0.0) {
            return 1.0f;
        }
        float f = 1.0f;
        long d = 1;
        boolean isless = (double) x < 0.0;
        if (isless) {
            x = -x;
        }
        float k = x / (float) d;
        long i = 2;
        for (; i < 50; i++) {
            f += k;
            k = k * x / (float) i;
        }
        if (isless) {
            return 1.0f / f;
        }
        return f;
    }

    public static float _log(float x) {
        if ((double) x <= 0.0) {
            return NaNf;
        }
        if ((double) x == 1.0) {
            return 0.0f;
        }
        if ((double) x > 1.0) {
            x = 1.0f / x;
            return -log(x);
        }
        return log(x);
    }

    public static float _sqrt(float num) {
        return (float) Math.sqrt((double) num);
    }

    public static float _log10(float x) {
        return _log(x) / 2.3025851f;
    }

    public static float _pow(float x, float y) {
        if ((double) y == 0.0) {
            return 1.0f;
        }
        if ((double) y == 1.0) {
            return x;
        }
        if ((double) x == 0.0) {
            return 0.0f;
        }
        if ((double) x == 1.0) {
            return 1.0f;
        }
        long l = (long) Math.floor((double) y);
        boolean integerValue = y == (float) l;
        if (integerValue) {
            boolean neg = false;
            if ((double) y < 0.0) {
                neg = true;
            }
            float result = x;
            long i = 1;
            for (; (!neg || -l < l); i++) {
                result *= x;
            }
            if (neg) {
                return 1.0f / result;
            }
            return result;
        }
        if ((double) x > 0.0) {
            return _exp(y * _log(x));
        }
        return NaNf;
    }

    public static int _trunc(float a) {
        return (int) a;
    }

    public static float _frac(float a) {
        int i = (int) a;
        return _rabs(a - (float) i);
    }

    public static float _rabs(float a) {
        return Math.abs(a);
    }

    private static float log(float x) {
        if ((double) x <= 0.0) {
            return NaNf;
        }
        float f = 0.0f;
        int appendix = 0;
        for (; (double) x > 0.0; appendix++) {
            if (!((double) x <= 1.0)) {
                break;
            }
            x = (float) ((double) x * 2.0);
        }
        x = (float) ((double) x / 2.0);
        appendix--;
        float y1 = x - 1.0f;
        float y2 = x + 1.0f;
        float y = y1 / y2;
        float k = y;
        y2 = k * y;
        int i = 1;
        while (i < 50) {
            f += k / (float) i;
            k *= y2;
            i += 2;
        }
        f = (float) ((double) f * 2.0);
        for (i = 0; i < appendix; i++) {
            f += -0.6931472f;
        }
        return f;
    }

    public static String _left(String s, int i) {
        return s.substring(0, i);
    }

    public static String _right(String s, int i) {
        return s.substring(s.length() - i);
    }

    public static String _mid(String s, int i, int i2) {
        return s.substring(i - 1, i + i2 - 1);
    }

    public static String _copy(String s, int idx1, int idx2) {
        if (idx1 < 0) {
            idx1 = 0;
        }
        if (idx1 > s.length()) {
            return "";
        }
        if (idx2 < 0) {
            idx2 = s.length() + idx2;
        }
        if (idx2 > s.length()) {
            idx2 = s.length();
        }
        return s.substring(idx1, idx2);
    }

    public static char _getChar(String s, int idx) {
        if (idx < 0) {
            idx = s.length() + idx;
        }
        if (idx > s.length()) {
            idx = s.length() - 1;
        }
        return s.charAt(idx);
    }

    public static String _integerToString(int i) {
        return String.valueOf(i);
    }

    public static int _length(String s) {
        return s.length();
    }

    public static String _locase(String s) {
        return toLowerCase(s);
    }

    public static int _pos(String s1, String s2) {
        return s1.indexOf(s2);
    }

    public static String _setChar(String str, char c, int pos) {
        if (pos < 0) {
            pos = str.length() + pos;
        }
        if (pos > str.length()) {
            return str;
        }
        StringBuffer sb = new StringBuffer(str);
        sb.setCharAt(pos, c);
        return sb.toString();
    }

    public static int _stringToInteger(String s, int base) {
        try {
            return Integer.parseInt(s, base);
        } catch (Throwable t) {
        }
        return 0;
    }

    public static int _stringToInteger(String s) {
        try {
            return Integer.parseInt(s);
        } catch (Throwable t) {
        }
        return 0;
    }

    public static float _stringToReal(String s) {
        try {
            return Float.parseFloat(s);
        } catch (Throwable t) {
        }
        return 0.0f;
    }

    public static String _upcase(String s) {
        return toUpperCase(s);
    }

    public static String toLowerCase(String s) {
        StringBuffer sb = new StringBuffer();
        int i = 0;
        for (; i < s.length(); i++) {
            sb.append(toLowerCase(s.charAt(i)));
        }
        return sb.toString();
    }

    public static char toLowerCase(char c) {
        c = Character.toLowerCase(c);
        if (c >= 0x410 && c <= 0x42f) {
            return (char) (c + 32);
        }
        if (c == 0x401) {
            return 0x451;
        }
        return c;
    }

    public static char toUpperCase(char c) {
        c = Character.toUpperCase(c);
        if (c >= 0x430 && c <= 0x44f) {
            return (char) (c - 32);
        }
        if (c == 0x451) {
            return 0x401;
        }
        return c;
    }

    public static String toUpperCase(String s) {
        StringBuffer sb = new StringBuffer();
        int i = 0;
        for (; i < s.length(); i++) {
            sb.append(toUpperCase(s.charAt(i)));
        }
        return sb.toString();
    }

    public static void _addCommand(Command cmd) {
        FW.CD.addCommand(cmd);
        FW.LC = null;
    }

    public static int _choiceAppendString(int id, String str) {
        if (id < 0 || id > FW.F.size()) {
            return -1;
        }
        Item item = FW.F.get(id);
        if (!(item instanceof ChoiceGroup)) {
            return -1;
        }
        ChoiceGroup cg = (ChoiceGroup) item;
        FW.LC = null;
        return cg.append(str, null);
    }

    public static int _choiceAppendStringImage(int id, String str, Image im) {
        if (id < 0 || id > FW.F.size()) {
            return -1;
        }
        Item item = FW.F.get(id);
        if (!(item instanceof ChoiceGroup)) {
            return -1;
        }
        ChoiceGroup cg = (ChoiceGroup) item;
        FW.LC = null;
        return cg.append(str, im);
    }

    public static int _choiceGetSelectedIndex(int id) {
        if (id < 0 || id > FW.F.size()) {
            return -1;
        }
        Item item = FW.F.get(id);
        if (!(item instanceof ChoiceGroup)) {
            return -1;
        }
        ChoiceGroup cg = (ChoiceGroup) item;
        FW.LC = null;
        return cg.getSelectedIndex();
    }

    public static boolean _choiceIsSelected(int id, int itemId) {
        if (id < 0 || id > FW.F.size()) {
            return false;
        }
        Item item = FW.F.get(id);
        if (!(item instanceof ChoiceGroup)) {
            return false;
        }
        ChoiceGroup cg = (ChoiceGroup) item;
        FW.LC = null;
        return cg.isSelected(itemId);
    }

    public static void _clearForm() {
        FW.F.deleteAll();
        FW.LC = null;
    }

    public static Command _createCommand(String label, int type, int priority) {
        FW.LC = null;
        return new Command(label, type, priority);
    }

    public static Command _emptyCommand() {
        return null;
    }

    public static Command _selectCommand() {
        return List.SELECT_COMMAND;
    }

    public static int _formAddChoice(String label, int type) {
        FW.LC = null;
        return FW.F.append(new ChoiceGroup(label, type));
    }

    public static int _formAddGauge(String label, boolean interactive, int max, int init) {
        FW.LC = null;
        return FW.F.append(new Gauge(label, interactive, max, init));
    }

    public static int _formAddImage(Image i) {
        FW.LC = null;
        return FW.F.append(i);
    }

    public static int _formAddSpace() {
        FW.LC = null;
        return FW.F.append(new Spacer(FW.F.getWidth(), 10));
    }

    public static int _formAddString(String label) {
        FW.LC = null;
        return FW.F.append(label);
    }

    public static int _formAddTextField(String label, String init, int max, int type) {
        FW.LC = null;
        return FW.F.append(new TextField(label, init, max, type));
    }

    public static String _formGetText(int id) {
        FW.LC = null;
        if (id < 0 || id > FW.F.size()) {
            return "";
        }
        Item item = FW.F.get(id);
        if (!(item instanceof TextField)) {
            return "";
        }
        TextField tf = (TextField) item;
        return tf.getString();
    }

    public static int _formGetValue(int id) {
        FW.LC = null;
        if (id < 0 || id > FW.F.size()) {
            return -1;
        }
        Item item = FW.F.get(id);
        if (!(item instanceof Gauge)) {
            return -1;
        }
        Gauge gauge = (Gauge) item;
        return gauge.getValue();
    }

    public static void _formRemove(int id) {
        FW.LC = null;
        if (id < 0 || id > FW.F.size()) {
            return;
        }
        FW.F.delete(id);
    }

    public static void _formSetText(int id, String text) {
        FW.LC = null;
        if (id < 0 || id > FW.F.size()) {
            return;
        }
        Item item = FW.F.get(id);
        if (!(item instanceof TextField)) {
            return;
        }
        TextField tf = (TextField) item;
        tf.setString(text);
    }

    public static void _formSetValue(int id, int value) {
        FW.LC = null;
        if (id < 0 || id > FW.F.size()) {
            return;
        }
        Item item = FW.F.get(id);
        if (!(item instanceof Gauge)) {
            return;
        }
        Gauge gauge = (Gauge) item;
        gauge.setValue(value);
    }

    public static Command _getClickedCommand() {
        return FW.LC;
    }

    public static String _getTextBoxString() {
        FW.LC = null;
        if (FW.TB == null) {
            return "";
        }
        return FW.TB.getString();
    }

    public static int _menuAppendString(String s) {
        FW.LC = null;
        if (FW.L == null) {
            return -1;
        }
        return FW.L.append(s, null);
    }

    public static int _menuAppendStringImage(String s, Image i) {
        FW.LC = null;
        if (FW.L == null) {
            return -1;
        }
        return FW.L.append(s, i);
    }

    public static int _menuGetSelectedIndex() {
        FW.LC = null;
        if (FW.L == null) {
            return -1;
        }
        return FW.L.getSelectedIndex();
    }

    public static boolean _menuIsSelected(int id) {
        FW.LC = null;
        if (FW.L == null) {
            return false;
        }
        return FW.L.isSelected(id);
    }

    public static void _playAlertSound() {
        FW.LC = null;
        if (FW.A == null) {
            return;
        }
        AlertType at = FW.A.getType();
        if (at == null) {
            return;
        }
        at.playSound(FW.fw.display);
    }

    public static void _removeCommand(Command c) {
        FW.LC = null;
        FW.F.removeCommand(c);
    }

    public static void _setTicker(String label) {
        FW.LC = null;
        FW.F.setTicker(new Ticker(label));
    }

    public static void _formSetTitle(String title) {
        FW.LC = null;
        FW.F.setTitle(title);
    }

    public static void _showAlert(String title, String message, Image img, int type) {
        AlertType at;
        FW.LC = null;
        if (type < 0 || type >= alertTypes.length) {
            at = null;
        } else {
            at = alertTypes[type];
        }
        FW.A = new Alert(title, title, img, at);
        FW.A.setCommandListener(FW.fw);
        FW.fw.display.setCurrent(FW.A);
        FW.CD = FW.A;
    }

    public static void _showCanvas() {
        FW.LC = null;
        FW.fw.display.setCurrent(T);
        FW.CD = T;
    }

    public static void _showForm() {
        FW.LC = null;
        FW.fw.display.setCurrent(FW.F);
        FW.CD = FW.F;
    }

    public static void _showMenu(String title, int type) {
        FW.LC = null;
        FW.L = new List(title, type);
        FW.L.setCommandListener(FW.fw);
        FW.fw.display.setCurrent(FW.L);
        FW.CD = FW.L;
    }

    public static void _showTextBox(String title, String init, int max, int type) {
        FW.LC = null;
        FW.TB = new TextBox(title, init, max, type);
        FW.TB.setCommandListener(FW.fw);
        FW.fw.display.setCurrent(FW.TB);
        FW.CD = FW.TB;
    }

    public static int _addRecordStoreEntry(RecordStore rs, String data) {
        try {
            return rs.addRecord(data.getBytes(), 0, data.getBytes().length);
        } catch (RecordStoreException ex) {
        }
        return -1;
    }

    public static void _closeRecordStore(RecordStore rs) {
        try {
            rs.closeRecordStore();
        } catch (RecordStoreException ex) {
        }
    }

    public static void _deleteRecordStore(String name) {
        try {
            RecordStore.deleteRecordStore(name);
        } catch (RecordStoreException ex) {
        }
    }

    public static void _deleteRecordStoreEntry(RecordStore rs, int i) {
        try {
            rs.deleteRecord(i);
        } catch (RecordStoreException ex) {
        }
    }

    public static int _getRecordStoreSize(RecordStore rs) {
        try {
            return rs.getNumRecords();
        } catch (RecordStoreException ex) {
        }
        return 0;
    }

    public static RecordStore _openRecordStore(String name) {
        try {
            return RecordStore.openRecordStore(name, true);
        } catch (RecordStoreException ex) {
        }
        return null;
    }

    public static String _readRecordStoreEntry(RecordStore rs, int id) {
        try {
            return new String(rs.getRecord(id));
        } catch (RecordStoreException ex) {
        }
        return "";
    }

    public static void _addHttpBody(HttpConnection http, String body) {
        bodies.put(http, body);
    }

    public static void _addHttpHeader(HttpConnection http, String name, String value) {
        try {
            http.setRequestProperty(name, value);
        } catch (Exception ex) {
        }
    }

    public static void _closeHttp(HttpConnection http) {
        try {
            http.close();
        } catch (Exception ex) {
        }
    }

    public static String _getHttpHeader(HttpConnection http, String name) {
        try {
            return http.getHeaderField(name);
        } catch (Exception ex) {
        }
        return "";
    }

    public static String _getHttpResponse(HttpConnection http) {
        try {
            Reader r = new InputStreamReader(http.openInputStream());
            StringBuffer sb = new StringBuffer();
            char[] buf = new char[1024];
            int len;
            while ((len = r.read(buf)) > 0) {
                sb.append(buf, 0, len);
            }
            r.close();
            return sb.toString();
        } catch (Exception ex) {
        }
        return "";
    }

    public static boolean _isHttpOpen(HttpConnection http) {
        try {
            http.getLastModified();
            return true;
        } catch (Exception ex) {
        }
        return false;
    }

    public static HttpConnection _openHttp(String url) {
        try {
            return (HttpConnection) Connector.open(url);
        } catch (Exception ex) {
        }
        return null;
    }

    public static int _sendHttpMessage(HttpConnection http) {
        try {
            String body = (String) bodies.get(http);
            if (body != null) {
                Writer w = new OutputStreamWriter(http.openOutputStream());
                w.write(body);
                w.close();
            } else {
                http.openOutputStream();
            }
            return http.getResponseCode();
        } catch (Exception ex) {
        }
        return -1;
    }

    public static void _setHttpMethod(HttpConnection http, String method) {
        try {
            http.setRequestMethod(method);
        } catch (Exception ex) {
        }
    }

    public static long _getPlayerDuration() {
        if (P == null) {
            return -1L;
        }
        return P.getDuration();
    }

    public static boolean _openPlayer(String url, String mime) {
        try {
            InputStream is = T.getClass().getResourceAsStream(url);
            P = Manager.createPlayer(is, mime);
            return true;
        } catch (IOException ex) {
        } catch (MediaException ex) {
        }
        return false;
    }

    public static boolean _setLoopCount(int count) {
        if (P == null) {
            return false;
        }
        P.setLoopCount(count);
        return true;
    }

    public static boolean _startPlayer() {
        if (P == null) {
            return false;
        }
        try {
            P.start();
            return true;
        } catch (MediaException ex) {
        }
        return false;
    }

    public static void _stopPlayer() {
        try {
            P.stop();
        } catch (Exception ex) {
        }
    }

    public static void _closeResource(InputStream is) {
        try {
            is.close();
        } catch (IOException ex) {
        }
    }

    public static InputStream _openResource(String url) {
        return T.getClass().getResourceAsStream(url);
    }

    public static int _readByte(InputStream is) {
        try {
            return is.read();
        } catch (Exception ex) {
        }
        return -1;
    }

    public static String _readLine(InputStream is) {
        try {
            StringBuffer sb = new StringBuffer();
            int ch = 0;
            while ((ch = is.read()) != 10) {
                if ((ch == -1)) {
                    break;
                }
                sb.append((char) ch);
            }
            if (ch != -1 && sb.toString().length() == 0) {
                return _readLine(is);
            }
            return sb.toString();
        } catch (Exception ex) {
        }
        return "";
    }

    public static boolean _resourceAvailable(InputStream is) {
        return is != null;
    }

    public static char _chr(int ch) {
        return (char) ch;
    }

    public static String _getProperty(String key) {
        String prop = System.getProperty(key);
        if (prop == null) {
            return "";
        }
        return prop;
    }

    public static void _halt() {
        FW.fw.destroyApp(true);
    }

    public static int _isMidletPaused() {
        return FW.MP;
    }

    public static boolean _isBoolPaused() {
        return FW.MP < 0;
    }

    public static boolean _odd(int i) {
        return i % 2 == 1;
    }

    public static int _ord(char i) {
        return i;
    }

    public static int _random(int n) {
        return rnd.nextInt(n);
    }

    public static void _randomize() {
        rnd = RNG = new Random();
    }

    public void commandAction(Command command, Displayable disp) {
        System.err.println("here");
        if (inputTB != null && disp == inputTB) {
            synchronized (waitObject) {
                waitObject.notify();
            }
        } else if (userForm != null && disp == userForm) {
            userExitStatus = command == userProceedCommand ? 1 : -1;
            synchronized (waitObject) {
                waitObject.notify();
            }
        } else if (list != null && disp == list) {
            if (command == List.SELECT_COMMAND) {
                userExitStatus = list.getSelectedIndex();
            } else {
                userExitStatus = -1;
            }

            synchronized (waitObject) {
                waitObject.notify();
            }
        }
    }

    public static String _EditForm(String formTitle, String proceedText, String cancelText, String label, String defaultText, int maxLen, int mode) {
        String text = null;
        switch (mode) {
            case 0:
                mode = TextField.ANY;
                break;
            case 1:
                mode = TextField.PASSWORD;
                break;
            case 2:
                mode = TextField.NUMERIC;
                break;
            case 3:
                mode = TextField.EMAILADDR;
                break;
            case 4:
                mode = TextField.PHONENUMBER;
                break;
            case 5:
                mode = TextField.URL;
                break;
            default:
            //   throw new BasicError(BasicError.VALUE_ERROR, "type must be 0..5");
        }
        if (maxLen > 0) {
            try {
                TextField textField = new TextField(label, defaultText, maxLen, mode);
                if (UserForm(formTitle, proceedText, cancelText, textField) == 1) {
                    text = textField.getString();
                }
                return text;
            } catch (IllegalArgumentException ex) {
                //    throw new BasicError(BasicError.VALUE_ERROR, "Invalid default text");
            }
        } else {
            // throw new BasicError(BasicError.VALUE_ERROR, "Maximum length must be > 0");
        }
        return "";
    }

    public static Date _DateForm(String formTitle, String proceedText, String cancelText, String label, Date date, int mode) {
        if (mode == 1) {
            mode = DateField.DATE;
        } else if (mode == 2) {
            mode = DateField.TIME;
        } else {
            mode = DateField.DATE_TIME;
        }
        DateField dateField = new DateField(label, mode);
        if (date != null) {
            dateField.setDate(date);
        }
        if (UserForm(formTitle, proceedText, cancelText, dateField) == 1) {
            date = dateField.getDate();
        } else {
            date = null;
        }
        return date;
    }

    public static int _ChoiceForm(String formTitle, String proceedText, String cancelText, String label, String[] stringArray, int mode) {
        boolean var7 = false;
        byte var11;
        if (mode == 0) {
            var11 = 1;
        } else {
            var11 = 2;
            if (stringArray.length > 32) {
                // throw new BasicError(6, "Maximum of 32 items in a multiple choice");
            }
        }

        ChoiceGroup choiceGroup = new ChoiceGroup(label, var11, stringArray, null);
        int res;
        if (UserForm(formTitle, proceedText, cancelText, choiceGroup) == 1) {
            if (var11 == 2) {
                boolean[] var9 = new boolean[32];
                choiceGroup.getSelectedFlags(var9);
                res = 0;

                for (int var10 = 31; var10 >= 0; --var10) {
                    res <<= 1;
                    if (var9[var10]) {
                        res |= 1;
                    }
                }
            } else {
                res = choiceGroup.getSelectedIndex();
            }
        } else {
            res = -1;
        }

        return res;
    }

    public static int _GaugeForm(String var1, String var2, String var3, String var4, int var5, int var6, int var7) {
        boolean var8 = false;
        if (var5 > 0) {
            Gauge var9 = new Gauge(var4, var7 == 1, var5, var6);
            int var10;
            if (UserForm(var1, var2, var3, var9) == 1) {
                var10 = var9.getValue();
            } else {
                var10 = -1;
            }

            return var10;
        } else {
            //throw new BasicError(6, "Maximum value must be >0");
        }
        return 0;
    }

    public static int _MessageForm(String var1, String var2, String var3, String var4, String var5) {
        StringItem var6 = new StringItem(var4, var5);
        return UserForm(var1, var2, var3, var6);
    }

    public int SELECT(String var1, String[] var2) {
        boolean var3 = false;
        list = new List(var1, 3, var2, (Image[]) null);
        list.setCommandListener(this);
        FW.display.setCurrent(list);
        String var4 = waitObject;
        synchronized (waitObject) {
            try {
                this.waitObject.wait();
            } catch (Exception ex) {
            }
        }

        // this.canvas.Focus();
        // this.display.setCurrent(this.canvas);
        int var9 = userExitStatus;
        return userExitStatus;
    }

    public static void _alert(String var1, String var2, String var3, int var4, int var5) {
        Image var7 = (Image) gelHashtable.get(var3);
        AlertType var6 = AlertType.INFO;
        switch (var4) {
            case 0:
                var6 = AlertType.CONFIRMATION;
                break;
            case 1:
                var6 = AlertType.INFO;
                break;
            case 2:
                var6 = AlertType.WARNING;
                break;
            case 3:
                var6 = AlertType.ERROR;
                break;
            case 4:
                var6 = AlertType.ALARM;
                break;
            default:
            //  throw new BasicError(6, "type must be 0..4");
        }

        Alert var8 = new Alert(var1, var2, var7, var6);
        if (var5 <= 0) {
            var5 = -2;
        }

        var8.setTimeout(var5);
        FW.display.setCurrent(var8);
    }

    public void menuAdd(String command, int type, int priority) {
        if ((Command) commandHashtable.get(command) == null) {
            try {
                Command var5 = new Command(command, type, priority);
                addCommand(var5);
                setCommandListener(this);
                commandHashtable.put(command, var5);
            } catch (Exception var6) {
                // throw new BasicError(6, "Invalid Command");
            }
        }
    }

    public String menuItem() {
        String var1 = "";
        if (cmd != null) {
            var1 = cmd.getLabel();
            cmd = null;
        }

        return var1;
    }

    public void menuRemove(String command) {
        Command var2;
        if ((var2 = (Command) commandHashtable.get(command)) != null) {
            removeCommand(var2);
            commandHashtable.remove(command);
        }

    }

    public static int UserForm(String title, String proceedText, String cancelText, Item item) {
        userForm = new Form(title);
        userForm.append(item);
        if (proceedText != null) {
            userProceedCommand = new Command(proceedText, Command.OK, 1);
            userForm.addCommand(userProceedCommand);
        }

        if (cancelText != null) {
            userCancelCommand = new Command(cancelText, Command.BACK, 1);
            userForm.addCommand(userCancelCommand);
        }

        userForm.setCommandListener(STD.THIS);
        FW.display.setCurrent(userForm);
        synchronized (waitObject) {
            try {
                waitObject.wait();
            } catch (Exception ex) {
            }
        }
        return userExitStatus;
    }

    void run() {
    }

    static {
        alertTypes = new AlertType[]{AlertType.INFO, AlertType.WARNING, AlertType.ERROR, AlertType.ALARM, AlertType.CONFIRMATION};
        bodies = new Hashtable();
        rnd = RNG = new Random();
    }

}

class SprHashtable extends Vector {

    private final Vector key;

    public SprHashtable() {
        key = new Vector();
    }

    public void put(Object key, Object value) {
        int id = this.key.indexOf(key);
        if (id > -1) {
            this.key.setElementAt(key, id);
            setElementAt(value, id);
            return;
        }
        this.key.addElement(key);
        addElement(value);
    }

    public Object get(Object key) {
        int id = this.key.indexOf(key);
        if (id > -1) {
            return elementAt(id);
        }
        return null;
    }

    public boolean remove(Object key) {
        int id = this.key.indexOf(key);
        if (id > -1) {
            this.key.removeElementAt(id);
            removeElementAt(id);
        }
        return true;
    }

    public void clear() {
        key.removeAllElements();
        removeAllElements();
    }

    public Enumeration keys() {
        return key.elements();
    }
}
