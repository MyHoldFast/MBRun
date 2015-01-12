public class Autorun extends STD implements Runnable {

    public static int x = 0;
    public static int y = 0;

    static void run(int l) {
        bombom:
        while (true) {
            switch (l) {
                case 10:
                default:
                    x = 0;
                    y = 0;
                    l = 15;
                    continue;
                case 15:
                    _setColor(255, 0, 0);
                    l = 20;
                    continue;
                case 20:
                    _drawText("Hello", x, y);
                    _repaint();
                    l = 30;
                    continue;
                case 30:
                    if (_Up() != 0) {
                        y = y - 2;
                        _CLS();
                        l = 20;
                    } else {
                        l = 40;
                    }
                    continue;
                case 40:
                    if (_Down() != 0) {
                        y = y + 2;
                        _CLS();
                        l = 20;
                    } else {
                        l = 50;
                    }
                    continue;
                case 50:
                    if (_Left() != 0) {
                        x = x - 2;
                        _CLS();
                        l = 20;
                    } else {
                        l = 60;
                    }
                    continue;
                case 60:
                    if (_Right() != 0) {
                        x = x + 2;
                        _CLS();
                        l = 20;
                    } else {
                        l = 70;
                    }
                    continue;
                case 70:
                    _delay(10);
                    l = 30;
                    continue;
            }
        }
    }

    public Autorun() {
        super();
    }

    public void run() {
        try {
            R();
        } catch (Exception ex) {
        }
    }

    public static void R() throws Exception {
        run(-1);
    }

}
