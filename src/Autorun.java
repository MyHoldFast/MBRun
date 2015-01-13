public class Autorun extends STD implements Runnable {

    static void run(int l) {
        bombom:
        while (true) {
            switch (l) {
                case 10:
                default:
                    if (_isColorDisplay(0) != 0) {
                        _print(_getColorsNum(0));
                        _repaint();
                    }
                    l = 20;
                    continue;
                case 20:
                    _delay(5000);
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

    public void R() throws Exception {
        run(-1);
    }

}
