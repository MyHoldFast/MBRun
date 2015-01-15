public class Autorun extends STD implements Runnable {

    public static String[] a;
    
    static void run(int l) {
        breaks:
        while (true) {
            switch (l) {
                case 40:
                default:
                  //  a = new String[9];
                    if (_pointPressed(0) != 0) {
                        l = 100;

                    } else {
                        l = 60;
                    }
                    continue;
                case 60:
               //  System.out.print(a);
                    if (_pointHold(0) != 0) {
                        l = 110;

                    } else {
                        l = 80;
                    }
                    continue;
                case 80:
                    if (_pointDragged(0) != 0) {
                        l = 120;

                    } else {
                        l = 90;
                    }
                    continue;
                case 90:
                    l = 40;

                    continue;
                case 100:
                    _CLS();
                    _drawText("Clicked at " + _str(_pointX(0)) + ":" + _str(_pointY(0)), 0, 0);
                    _repaint();
                    l = 40;

                    continue;
                case 110:
                    _CLS();
                    _drawText("Hold at " + _str(_pointX(0)) + ":" + _str(_pointY(0)), 0, 0);
                    _repaint();
                    l = 40;

                    continue;
                case 120:
                    _CLS();
                    _drawText("Dragged to " + _str(_pointX(0)) + ":" + _str(_pointY(0)), 0, 0);
                    _repaint();
                    l = 40;

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
