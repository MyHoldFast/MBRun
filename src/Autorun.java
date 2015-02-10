public class Autorun extends STD implements Runnable {

  static void run(int l) {
        breaks:
        while (true) {
            switch (l) {
                case 0:
                default:
                    _GelLoad("i","icon.png");
                    
               l = 10;
                    continue;
                case 10:
                _alert("ололо","ололо","i",0,2000);
                    _delay(5000);
                    
                    _halt();
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
