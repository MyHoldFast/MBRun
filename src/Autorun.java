public class Autorun extends STD implements Runnable {

    public static int t = 0;
    public static int x = 0;
    public static int y = 0;
    public static int zn = 0;
    public static int n = 0;
    public static int sx = 0;
    public static int sy = 0;
    public static int s2x = 0;
    public static int s2y = 0;
    public static int s3x = 0;
    public static int s3y = 0;
    public static int dx = 0;
    public static int dy = 0;
    public static int d2x = 0;
    public static int d2y = 0;
    public static int d3x = 0;
    public static int d3y = 0;
    public static int d4x = 0;
    public static int d4y = 0;
    public static int d5x = 0;
    public static int d5y = 0;
    public static int d6x = 0;
    public static int d6y = 0;
    public static int exx = 0;
    public static int exy = 0;
    public static int sold = 0;
    public static int life = 0;
    public static int lx = 0;
    public static int ly = 0;
    public static int l2x = 0;
    public static int l2y = 0;
    public static int tlx = 0;
    public static int tly = 0;
    public static int napr = 0;
    public static int ex = 0;
    public static int ext = 0;
    public static int speed = 0;
    public static int speed2 = 0;
    public static int maga = 0;
    public static int maga2 = 0;
    public static int magax = 0;
    public static int magay = 0;
    public static int record = 0;
    public static int prx = 0;
    public static int pry = 0;
    public static int pr2x = 0;
    public static int pr2y = 0;
    public static int pr3x = 0;
    public static int pr3y = 0;
    public static int f = 0;
    public static int f2 = 0;
    public static int mid = 0;
    public static int flx = 0;
    public static int fly = 0;
    public static int fl2y = 0;
    public static int sdrx = 0;
    public static int sdry = 0;
    public static int dr = 0;
    public static int oga = 0;
    public static int flm = 0;

    static void run(int l) {
        bombom:
        while (true) {
            switch (l) {
                case 5:
                default:
                    l = 2500;
                    continue;
                case 10:
///;
                    l = 20;
                    continue;
                case 20:
                    t = 0;
                    x = 40;
                    y = 150;
                    l = 30;
                    continue;
                case 30:
                    _CLS();
                    l = 40;
                    continue;
                case 40:
                    _setColor(0, 0, 0);
                    l = 50;
                    continue;
                case 50:
                    _fillRect(0, 0, 240, 320);
                    l = 60;
                    continue;
                case 60:
                    _setColor(0, 150, 190);
                    l = 70;
                    continue;
                case 70:
                    _drawRect(x, y, 150, 12);
                    l = 80;
                    continue;
                case 80:
                    _fillRect(x + 3, y + 3, t, 7);
                    l = 90;
                    continue;
                case 90:
                    t = t + 4;
                    l = 100;
                    continue;
                case 100:
                    if (t > 146) {
                        t = 145;
                        l = 200;
                    } else {
                        l = 110;
                    }
                    continue;
                case 110:
                    if (_Fire() != 0) {
                        _delay(200);
                        l = 200;
                    } else {
                        l = 120;
                    }
                    continue;
                case 120:
                    _repaint();
                    l = 130;
                    continue;
                case 130:
                    _delay(10);
                    l = 140;
                    continue;
                case 140:
                    l = 30;
                    continue;
                case 200:
///;
                    l = 210;
                    continue;
                case 210:
                    x = 10;
                    y = 193;
                    zn = 1;
                    l = 300;
                    continue;
                case 300:
                    _GelLoad("m", "menu.jpg");
                    l = 310;
                    continue;
                case 310:
                    _GelLoad("cr", "cursor.png");
                    l = 330;
                    continue;
                case 330:
                    _SpriteGEL("m", "m");
                    l = 340;
                    continue;
                case 340:
                    _SpriteGEL("cr", "cr");
                    l = 360;
                    continue;
                case 360:
                    _SpriteMove("m", 0, 0);
                    l = 370;
                    continue;
                case 370:
                    _CLS();
                    l = 380;
                    continue;
                case 380:
                    _SpriteMove("cr", x, y);
                    l = 400;
                    continue;
                case 400:
                    if (zn == 1) {
                        y = 193;
                    }
                    l = 410;
                    continue;
                case 410:
                    if (zn == 2) {
                        y = 222;
                    }
                    l = 420;
                    continue;
                case 420:
                    if (zn == 3) {
                        y = 250;
                    }
                    l = 430;
                    continue;
                case 430:
                    if (zn == 4) {
                        y = 278;
                    }
                    l = 440;
                    continue;
                case 440:
                    if (!(_INKEY() != 0)) {
                        n = 0;
                    }
                    l = 450;
                    continue;
                case 450:
                    if (_Down() != 0 && zn == 1 && n == 0) {
                        zn = 2;
                        n = 1;
                    }
                    l = 460;
                    continue;
                case 460:
                    if (_Down() != 0 && zn == 2 && n == 0) {
                        zn = 3;
                        n = 1;
                    }
                    l = 470;
                    continue;
                case 470:
                    if (_Down() != 0 && zn == 3 && n == 0) {
                        zn = 4;
                        n = 1;
                    }
                    l = 480;
                    continue;
                case 480:
                    if (_Up() != 0 && zn == 4 && n == 0) {
                        zn = 3;
                        n = 1;
                    }
                    l = 490;
                    continue;
                case 490:
                    if (_Up() != 0 && zn == 3 && n == 0) {
                        zn = 2;
                        n = 1;
                    }
                    l = 500;
                    continue;
                case 500:
                    if (_Up() != 0 && zn == 2 && n == 0) {
                        zn = 1;
                        n = 1;
                    }
                    l = 510;
                    continue;
                case 510:
                    if (_Fire() != 0 && zn == 1) {
                        _DelSprite("m");
                        _DelSprite("cr");
                        _delay(200);
                        l = 1300;
                    } else {
                        l = 520;
                    }
                    continue;
                case 520:
                    if (_Fire() != 0 && zn == 2) {
                        _DelSprite("m");
                        _DelSprite("cr");
                        _delay(200);
                        l = 700;
                    } else {
                        l = 530;
                    }
                    continue;
                case 530:
                    if (_Fire() != 0 && zn == 3) {
                        _DelSprite("m");
                        _DelSprite("cr");
                        _delay(200);
                        l = 1000;
                    } else {
                        l = 540;
                    }
                    continue;
                case 540:
                    if (_Fire() != 0 && zn == 4) {
                        _halt();
                    }
                    l = 600;
                    continue;
                case 600:
                    _repaint();
                    l = 610;
                    continue;
                case 610:
                    _delay(10);
                    l = 620;
                    continue;
                case 620:
                    l = 370;
                    continue;
                case 700:
///;
                    l = 720;
                    continue;
                case 720:
                    t = 0;
                    x = 40;
                    y = 150;
                    l = 730;
                    continue;
                case 730:
                    _CLS();
                    l = 740;
                    continue;
                case 740:
                    _setColor(0, 0, 0);
                    l = 750;
                    continue;
                case 750:
                    _fillRect(0, 0, 240, 320);
                    l = 760;
                    continue;
                case 760:
                    _setColor(0, 150, 190);
                    l = 770;
                    continue;
                case 770:
                    _drawRect(x, y, 150, 12);
                    l = 780;
                    continue;
                case 780:
                    _fillRect(x + 3, y + 3, t, 7);
                    l = 790;
                    continue;
                case 790:
                    t = t + 4;
                    l = 800;
                    continue;
                case 800:
                    if (t > 146) {
                        t = 145;
                        l = 850;
                    } else {
                        l = 810;
                    }
                    continue;
                case 810:
                    if (_Fire() != 0) {
                        _delay(200);
                        l = 850;
                    } else {
                        l = 820;
                    }
                    continue;
                case 820:
                    _repaint();
                    l = 830;
                    continue;
                case 830:
                    _delay(10);
                    l = 840;
                    continue;
                case 840:
                    l = 730;
                    continue;
                case 850:
///;
                    l = 860;
                    continue;
                case 860:
                    _CLS();
                    l = 870;
                    continue;
                case 870:
                    _GelLoad("inf", "infom.jpg");
                    l = 880;
                    continue;
                case 880:
                    _SpriteGEL("inf", "inf");
                    l = 890;
                    continue;
                case 890:
                    _SpriteMove("inf", 0, 0);
                    l = 900;
                    continue;
                case 900:
                    if (_Fire() != 0) {
                        _DelSprite("inf");
                        _delay(200);
                        l = 10;
                    } else {
                        l = 910;
                    }
                    continue;
                case 910:
                    _repaint();
                    l = 920;
                    continue;
                case 920:
                    _delay(10);
                    l = 930;
                    continue;
                case 930:
                    l = 900;
                    continue;
                case 1000:
///;
                    l = 1020;
                    continue;
                case 1020:
                    t = 0;
                    x = 40;
                    y = 150;
                    l = 1030;
                    continue;
                case 1030:
                    _CLS();
                    l = 1040;
                    continue;
                case 1040:
                    _setColor(0, 0, 0);
                    l = 1050;
                    continue;
                case 1050:
                    _fillRect(0, 0, 240, 320);
                    l = 1060;
                    continue;
                case 1060:
                    _setColor(0, 150, 190);
                    l = 1070;
                    continue;
                case 1070:
                    _drawRect(x, y, 150, 12);
                    l = 1080;
                    continue;
                case 1080:
                    _fillRect(x + 3, y + 3, t, 7);
                    l = 1090;
                    continue;
                case 1090:
                    t = t + 4;
                    l = 1100;
                    continue;
                case 1100:
                    if (t > 146) {
                        t = 145;
                        l = 1160;
                    } else {
                        l = 1110;
                    }
                    continue;
                case 1110:
                    if (_Fire() != 0) {
                        _delay(200);
                        l = 1160;
                    } else {
                        l = 1120;
                    }
                    continue;
                case 1120:
                    _repaint();
                    l = 1130;
                    continue;
                case 1130:
                    _delay(10);
                    l = 1140;
                    continue;
                case 1140:
                    l = 1030;
                    continue;
                case 1150:
///;
                    l = 1160;
                    continue;
                case 1160:
                    _CLS();
                    l = 1170;
                    continue;
                case 1170:
                    _GelLoad("ab", "about.jpg");
                    l = 1180;
                    continue;
                case 1180:
                    _SpriteGEL("ab", "ab");
                    l = 1190;
                    continue;
                case 1190:
                    _SpriteMove("ab", 0, 0);
                    l = 1200;
                    continue;
                case 1200:
                    if (_Fire() != 0) {
                        _DelSprite("ab");
                        _delay(200);
                        l = 10;
                    } else {
                        l = 1210;
                    }
                    continue;
                case 1210:
                    _repaint();
                    l = 1220;
                    continue;
                case 1220:
                    _delay(10);
                    l = 1230;
                    continue;
                case 1230:
                    l = 1160;
                    continue;
                case 1300:
///;
                    l = 1320;
                    continue;
                case 1320:
                    t = 0;
                    x = 40;
                    y = 150;
                    l = 1330;
                    continue;
                case 1330:
                    _CLS();
                    l = 1340;
                    continue;
                case 1340:
                    _setColor(0, 0, 0);
                    l = 1350;
                    continue;
                case 1350:
                    _fillRect(0, 0, 240, 320);
                    l = 1360;
                    continue;
                case 1360:
                    _setColor(0, 150, 190);
                    l = 1370;
                    continue;
                case 1370:
                    _drawRect(x, y, 150, 12);
                    l = 1380;
                    continue;
                case 1380:
                    _fillRect(x + 3, y + 3, t, 7);
                    l = 1390;
                    continue;
                case 1390:
                    t = t + 4;
                    l = 1400;
                    continue;
                case 1400:
                    if (t > 146) {
                        t = 145;
                        l = 1510;
                    } else {
                        l = 1410;
                    }
                    continue;
                case 1410:
                    if (_Fire() != 0) {
                        _delay(200);
                        l = 1510;
                    } else {
                        l = 1420;
                    }
                    continue;
                case 1420:
                    _repaint();
                    l = 1430;
                    continue;
                case 1430:
                    _delay(10);
                    l = 1440;
                    continue;
                case 1440:
                    l = 1330;
                    continue;
                case 1500:
///;
                    l = 1510;
                    continue;
                case 1510:
                    x = 100;
                    y = 285;
                    sx = 20;
                    sy = -50;
                    s2x = 130;
                    s2y = -190;
                    s3x = 200;
                    s3y = -120;
                    l = 1511;
                    continue;
                case 1511:
                    dx = 60;
                    dy = -200;
                    d2x = 100;
                    d2y = -240;
                    d3x = 160;
                    d3y = -470;
                    l = 1512;
                    continue;
                case 1512:
                    d4x = 10;
                    d4y = -500;
                    d5x = 70;
                    d5y = -540;
                    d6x = 200;
                    d6y = -600;
                    exx = -100;
                    exy = 0;
                    l = 1513;
                    continue;
                case 1513:
                    sold = 0;
                    life = 2;
                    lx = 7;
                    ly = 10;
                    l2x = 23;
                    l2y = 10;
                    t = 0;
                    l = 1514;
                    continue;
                case 1514:
                    tlx = x + 30;
                    tly = y + 5;
                    napr = 0;
                    ex = 0;
                    ext = 0;
                    speed = 2;
                    speed2 = 3;
                    maga = 0;
                    maga2 = 0;
                    magax = -70;
                    magay = 30;
                    l = 1515;
                    continue;
                case 1515:
///;
                    l = 1516;
                    continue;
                case 1516:
                    record = 0;
                    l = 1517;
                    continue;
                case 1517:
///;
                    l = 1520;
                    continue;
                case 1520:
                    _GelLoad("c", "car.png");
                    l = 1530;
                    continue;
                case 1530:
                    _GelLoad("cr", "carr.png");
                    l = 1540;
                    continue;
                case 1540:
                    _GelLoad("cl", "carl.png");
                    l = 1541;
                    continue;
                case 1541:
                    _GelLoad("crs", "carrs.png");
                    l = 1542;
                    continue;
                case 1542:
                    _GelLoad("lfs", "lefts.png");
                    l = 1543;
                    continue;
                case 1543:
                    _GelLoad("cx", "carex.png");
                    l = 1550;
                    continue;
                case 1550:
                    _GelLoad("l", "life.png");
                    l = 1560;
                    continue;
                case 1560:
                    _GelLoad("s", "sold.png");
                    l = 1561;
                    continue;
                case 1561:
                    _GelLoad("sl", "sold2.png");
                    l = 1562;
                    continue;
                case 1562:
                    _GelLoad("sr", "sold3.png");
                    l = 1563;
                    continue;
                case 1563:
                    _GelLoad("sdr", "solddr.png");
                    l = 1570;
                    continue;
                case 1570:
                    _GelLoad("ls", "lifeslot.png");
                    l = 1580;
                    continue;
                case 1580:
                    _GelLoad("d", "danger.png");
                    l = 1590;
                    continue;
                case 1590:
                    _GelLoad("pr", "par.png");
                    l = 1600;
                    continue;
                case 1600:
                    _GelLoad("bg", "bg.png");
                    l = 1601;
                    continue;
                case 1601:
                    _GelLoad("rez", "rez.png");
                    l = 1603;
                    continue;
                case 1603:
                    _GelLoad("e", "e1.png");
                    l = 1604;
                    continue;
                case 1604:
                    _GelLoad("e2", "e2.png");
                    l = 1605;
                    continue;
                case 1605:
                    _GelLoad("e3", "e3.png");
                    l = 1606;
                    continue;
                case 1606:
                    _GelLoad("e4", "e4.png");
                    l = 1608;
                    continue;
                case 1608:
                    _GelLoad("fl", "fl.png");
                    l = 1609;
                    continue;
                case 1609:
                    _GelLoad("mg", "maga.png");
                    l = 1610;
                    continue;
                case 1610:
                    _GelLoad("tl", "tl.png");
                    l = 1611;
                    continue;
                case 1611:
                    _SpriteGEL("tl", "tl");
                    l = 1612;
                    continue;
                case 1612:
                    _SpriteGEL("bg", "bg");
                    l = 1613;
                    continue;
                case 1613:
                    _SpriteGEL("rez", "rez");
                    l = 1614;
                    continue;
                case 1614:
                    _SpriteGEL("mg", "mg");
                    l = 1620;
                    continue;
                case 1620:
                    _SpriteGEL("pr", "pr");
                    l = 1621;
                    continue;
                case 1621:
                    _SpriteGEL("pr2", "pr");
                    l = 1622;
                    continue;
                case 1622:
                    _SpriteGEL("pr3", "pr");
                    l = 1630;
                    continue;
                case 1630:
                    _SpriteGEL("s", "s");
                    l = 1640;
                    continue;
                case 1640:
                    _SpriteGEL("s2", "s");
                    l = 1650;
                    continue;
                case 1650:
                    _SpriteGEL("s3", "s");
                    l = 1670;
                    continue;
                case 1670:
                    _SpriteGEL("d", "d");
                    l = 1680;
                    continue;
                case 1680:
                    _SpriteGEL("d2", "d");
                    l = 1690;
                    continue;
                case 1690:
                    _SpriteGEL("d3", "d");
                    l = 1691;
                    continue;
                case 1691:
                    _SpriteGEL("d4", "d");
                    l = 1692;
                    continue;
                case 1692:
                    _SpriteGEL("d5", "d");
                    l = 1693;
                    continue;
                case 1693:
                    _SpriteGEL("d6", "d");
                    l = 1700;
                    continue;
                case 1700:
                    _SpriteGEL("l", "l");
                    l = 1710;
                    continue;
                case 1710:
                    _SpriteGEL("l2", "l");
                    l = 1720;
                    continue;
                case 1720:
                    _SpriteGEL("ls", "ls");
                    l = 1730;
                    continue;
                case 1730:
                    _SpriteGEL("c", "c");
                    l = 1732;
                    continue;
                case 1732:
                    _SpriteGEL("fl", "fl");
                    l = 1733;
                    continue;
                case 1733:
                    _SpriteGEL("fl2", "fl");
                    l = 1735;
                    continue;
                case 1735:
                    _SpriteGEL("e", "e");
                    l = 1750;
                    continue;
                case 1750:
                    _SpriteMove("bg", 0, 0);
                    l = 1752;
                    continue;
                case 1752:
                    _SpriteMove("fl", -100, 0);
                    l = 1753;
                    continue;
                case 1753:
                    _SpriteMove("fl2", -100, 0);
                    l = 1754;
                    continue;
                case 1754:
                    _SpriteMove("rez", -300, 0);
                    l = 1760;
                    continue;
                case 1760:
                    _CLS();
                    l = 1762;
                    continue;
                case 1762:
                    if (sold > 7 && maga2 == 0) {
                        maga = 1;
                    }
                    l = 1763;
                    continue;
                case 1763:
                    if (maga == 1) {
                        magax = magax + 5;
                    }
                    l = 1764;
                    continue;
                case 1764:
                    if (magax > -20) {
                        maga2 = 1;
                        maga = 2;
                    }
                    l = 1765;
                    continue;
                case 1765:
                    if (maga == 2) {
                        magax = magax - 5;
                    }
                    l = 1766;
                    continue;
                case 1766:
                    if (maga == 2 && maga2 == 1 && magax < -70) {
                        maga = 3;
                    }
                    l = 1770;
                    continue;
                case 1770:
                    _setFont(1);
                    l = 1780;
                    continue;
                case 1780:
                    _drawText(_str(sold), 212, 14);
                    l = 1783;
                    continue;
                case 1783:
                    if (sold > 5) {
                        speed = 3;
                        speed2 = 4;
                    }
                    l = 1784;
                    continue;
                case 1784:
                    if (sold > 10) {
                        speed = 4;
                        speed2 = 5;
                    }
                    l = 1785;
                    continue;
                case 1785:
                    if (sold > 15) {
                        speed = 5;
                        speed2 = 6;
                    }
                    l = 1786;
                    continue;
                case 1786:
                    if (sold > 20) {
                        speed = 6;
                        speed2 = 7;
                    }
                    l = 1787;
                    continue;
                case 1787:
                    if (sold > 25) {
                        speed = 7;
                        speed2 = 8;
                    }
                    l = 1788;
                    continue;
                case 1788:
                    if (sold > 30) {
                        speed = 6;
                        speed2 = 9;
                    }
                    l = 1790;
                    continue;
                case 1790:
                    _SpriteMove("c", x, y);
                    l = 1791;
                    continue;
                case 1791:
                    _SpriteMove("tl", tlx, tly);
                    l = 1800;
                    continue;
                case 1800:
                    _SpriteMove("l", lx, ly);
                    l = 1810;
                    continue;
                case 1810:
                    _SpriteMove("l2", l2x, l2y);
                    l = 1820;
                    continue;
                case 1820:
                    _SpriteMove("ls", 6, 10);
                    l = 1830;
                    continue;
                case 1830:
                    _SpriteMove("pr", prx, pry);
                    l = 1831;
                    continue;
                case 1831:
                    _SpriteMove("pr2", pr2x, pr2y);
                    l = 1832;
                    continue;
                case 1832:
                    _SpriteMove("pr3", pr3x, pr3y);
                    l = 1840;
                    continue;
                case 1840:
                    _SpriteMove("s", sx, sy);
                    l = 1850;
                    continue;
                case 1850:
                    _SpriteMove("s2", s2x, s2y);
                    l = 1860;
                    continue;
                case 1860:
                    _SpriteMove("s3", s3x, s3y);
                    l = 1870;
                    continue;
                case 1870:
                    _SpriteMove("d", dx, dy);
                    l = 1880;
                    continue;
                case 1880:
                    _SpriteMove("d2", d2x, d2y);
                    l = 1890;
                    continue;
                case 1890:
                    _SpriteMove("d3", d3x, d3y);
                    l = 1891;
                    continue;
                case 1891:
                    _SpriteMove("d4", d4x, d4y);
                    l = 1892;
                    continue;
                case 1892:
                    _SpriteMove("d5", d5x, d5y);
                    l = 1893;
                    continue;
                case 1893:
                    _SpriteMove("d6", d6x, d6y);
                    l = 1894;
                    continue;
                case 1894:
                    _SpriteMove("e", exx, exy);
                    l = 1895;
                    continue;
                case 1895:
                    _SpriteMove("mg", magax, magay);
                    l = 1896;
                    continue;
                case 1896:
                    t = t + 2;
                    l = 1900;
                    continue;
                case 1900:
                    if (_Right() != 0) {
                        x = x + 3;
                        _SpriteGEL("c", "cr");
                        _SpriteMove("c", x, y);
                        tlx = x + 5;
                        tly = y + 5;
                    }
                    l = 1910;
                    continue;
                case 1910:
                    if (_Left() != 0) {
                        x = x - 3;
                        _SpriteGEL("c", "cl");
                        _SpriteMove("c", x, y);
                        tlx = x + 30;
                        tly = y + 5;
                    }
                    l = 1930;
                    continue;
                case 1930:
                    if (_Left() != 0 && x < 2) {
                        x = x + 3;
                    }
                    l = 1940;
                    continue;
                case 1940:
                    if (_Right() != 0 && x > 185) {
                        x = x - 3;
                    }
                    l = 1941;
                    continue;
                case 1941:
                    if (_Right() != 0) {
                        napr = 1;
                    }
                    l = 1942;
                    continue;
                case 1942:
                    if (_Left() != 0) {
                        napr = 2;
                    }
                    l = 1943;
                    continue;
                case 1943:
                    if (t < 10) {
                        _SpriteGEL("s", "s");
                        _SpriteMove("s", sx, sy);
                    }
                    l = 1944;
                    continue;
                case 1944:
                    if (t > 10) {
                        _SpriteGEL("s", "sr");
                        _SpriteMove("s", sx, sy);
                    }
                    l = 1945;
                    continue;
                case 1945:
                    if (t > 20) {
                        _SpriteGEL("s", "s");
                        _SpriteMove("s", sx, sy);
                    }
                    l = 1946;
                    continue;
                case 1946:
                    if (t > 30) {
                        _SpriteGEL("s", "sl");
                        _SpriteMove("s", sx, sy);
                    }
                    l = 1949;
                    continue;
                case 1949:
                    if (t > 40) {
                        t = 0;
                    }
                    l = 1950;
                    continue;
                case 1950:
                    prx = sx - 4;
                    pry = sy - 24;
                    l = 1951;
                    continue;
                case 1951:
                    pr2x = s2x - 4;
                    pr2y = s2y - 24;
                    l = 1952;
                    continue;
                case 1952:
                    pr3x = s3x - 4;
                    pr3y = s3y - 24;
                    l = 1955;
                    continue;
                case 1955:
                    if (t < 10) {
                        _SpriteGEL("s2", "s");
                        _SpriteMove("s2", s2x, s2y);
                    }
                    l = 1956;
                    continue;
                case 1956:
                    if (t > 10) {
                        _SpriteGEL("s2", "sr");
                        _SpriteMove("s2", s2x, s2y);
                    }
                    l = 1957;
                    continue;
                case 1957:
                    if (t > 20) {
                        _SpriteGEL("s2", "s");
                        _SpriteMove("s2", s2x, s2y);
                    }
                    l = 1958;
                    continue;
                case 1958:
                    if (t > 30) {
                        _SpriteGEL("s2", "sl");
                        _SpriteMove("s2", s2x, s2y);
                    }
                    l = 1960;
                    continue;
                case 1960:
                    f = 1;
                    l = 1970;
                    continue;
                case 1970:
                    f2 = 1;
                    l = 1974;
                    continue;
                case 1974:
                    if (t < 10) {
                        _SpriteGEL("s3", "s");
                        _SpriteMove("s3", s3x, s3y);
                    }
                    l = 1975;
                    continue;
                case 1975:
                    if (t > 10) {
                        _SpriteGEL("s3", "sr");
                        _SpriteMove("s3", s3x, s3y);
                    }
                    l = 1976;
                    continue;
                case 1976:
                    if (t > 20) {
                        _SpriteGEL("s3", "s");
                        _SpriteMove("s3", s3x, s3y);
                    }
                    l = 1977;
                    continue;
                case 1977:
                    if (t > 30) {
                        _SpriteGEL("s3", "sl");
                        _SpriteMove("s3", s3x, s3y);
                    }
                    l = 1980;
                    continue;
                case 1980:
                    sy = sy + speed;
                    l = 1990;
                    continue;
                case 1990:
                    s2y = s2y + speed;
                    l = 2000;
                    continue;
                case 2000:
                    s3y = s3y + speed;
                    l = 2010;
                    continue;
                case 2010:
                    dy = dy + speed2;
                    l = 2020;
                    continue;
                case 2020:
                    d2y = d2y + speed2;
                    l = 2030;
                    continue;
                case 2030:
                    d3y = d3y + speed2;
                    l = 2031;
                    continue;
                case 2031:
                    d4y = d4y + speed2;
                    l = 2032;
                    continue;
                case 2032:
                    d5y = d5y + speed2;
                    l = 2033;
                    continue;
                case 2033:
                    d6y = d6y + speed2;
                    l = 2040;
                    continue;
                case 2040:
                    if (sy > 310) {
                        sy = _rand(-50, -80);
                        sx = _rand(7, 50);
                    }
                    l = 2050;
                    continue;
                case 2050:
                    if (s2y > 310) {
                        s2y = _rand(-50, -100);
                        s2x = _rand(70, 150);
                    }
                    l = 2060;
                    continue;
                case 2060:
                    if (s3y > 310) {
                        s3y = _rand(-50, -90);
                        s3x = _rand(170, 220);
                    }
                    l = 2070;
                    continue;
                case 2070:
                    if (dy > 310) {
                        dy = _rand(-150, -180);
                        dx = _rand(7, 50);
                    }
                    l = 2080;
                    continue;
                case 2080:
                    if (d2y > 310) {
                        d2y = _rand(-150, -200);
                        d2x = _rand(70, 150);
                    }
                    l = 2090;
                    continue;
                case 2090:
                    if (d3y > 310) {
                        d3y = _rand(-150, -190);
                        d3x = _rand(170, 220);
                    }
                    l = 2091;
                    continue;
                case 2091:
                    if (d4y > 310) {
                        d4y = _rand(-150, -200);
                        d4x = _rand(7, 50);
                    }
                    l = 2092;
                    continue;
                case 2092:
                    if (d5y > 310) {
                        d5y = _rand(-150, -180);
                        d5x = _rand(70, 150);
                    }
                    l = 2093;
                    continue;
                case 2093:
                    if (d6y > 310) {
                        d6y = _rand(-150, -190);
                        d6x = _rand(170, 220);
                    }
                    l = 2100;
                    continue;
                case 2100:
                    if (_SpriteHit("s", "tl") != 0 && f == 1) {
                        sold = sold + 1;
                        f = 0;
                        sx = -100;
                    }
                    l = 2110;
                    continue;
                case 2110:
                    if (_SpriteHit("s2", "tl") != 0 && f == 1) {
                        sold = sold + 1;
                        f = 0;
                        s2x = -100;
                    }
                    l = 2120;
                    continue;
                case 2120:
                    if (_SpriteHit("s3", "tl") != 0 && f == 1) {
                        sold = sold + 1;
                        f = 0;
                        s3x = -100;
                    }
                    l = 2130;
                    continue;
                case 2130:
                    if (_SpriteHit("d", "c") != 0 && f2 == 1) {
                        life = life - 1;
                        f2 = 0;
                        dx = -100;
                        ex = 1;
                    }
                    l = 2140;
                    continue;
                case 2140:
                    if (_SpriteHit("d2", "c") != 0 && f2 == 1) {
                        life = life - 1;
                        f2 = 0;
                        d2x = -100;
                        ex = 1;
                    }
                    l = 2150;
                    continue;
                case 2150:
                    if (_SpriteHit("d3", "c") != 0 && f2 == 1) {
                        life = life - 1;
                        f2 = 0;
                        d3x = -100;
                        ex = 1;
                    }
                    l = 2151;
                    continue;
                case 2151:
                    if (_SpriteHit("d4", "c") != 0 && f2 == 1) {
                        life = life - 1;
                        f2 = 0;
                        d4x = -100;
                        ex = 1;
                    }
                    l = 2152;
                    continue;
                case 2152:
                    if (_SpriteHit("d5", "c") != 0 && f2 == 1) {
                        life = life - 1;
                        f2 = 0;
                        d5x = -100;
                        ex = 1;
                    }
                    l = 2153;
                    continue;
                case 2153:
                    if (_SpriteHit("d6", "c") != 0 && f2 == 1) {
                        life = life - 1;
                        f2 = 0;
                        d6x = -100;
                        ex = 1;
                    }
                    l = 2160;
                    continue;
                case 2160:
                    if (life == 1) {
                        l2x = -50;
                    }
                    l = 2170;
                    continue;
                case 2170:
                    if (life == 0) {
                        lx = -50;
                    }
                    l = 2180;
                    continue;
                case 2180:
                    if (_Fire() != 0) {
                        mid = 0;
                    }
                    l = 2190;
                    continue;
                case 2190:
                    if (life < 1) {
                        l = 2700;
                    } else {
                        l = 2210;
                    }
                    continue;
                case 2210:
                    if (_Down() != 0) {
                        sold = sold + 1;
                    }
                    l = 2220;
                    continue;
                case 2220:
                    if (!(_INKEY() != 0) && napr == 1) {
                        _SpriteGEL("c", "crs");
                        _SpriteMove("c", x, y);
                    }
                    l = 2221;
                    continue;
                case 2221:
                    if (!(_INKEY() != 0) && napr == 2) {
                        _SpriteGEL("c", "lfs");
                        _SpriteMove("c", x, y);
                    }
                    l = 2231;
                    continue;
                case 2231:
                    if (ex == 1) {
                        ext = ext + 5;
                    }
                    l = 2240;
                    continue;
                case 2240:
                    if (ex == 1) {
                        exx = x;
                        exy = y - 15;
                    }
                    l = 2250;
                    continue;
                case 2250:
                    if (ext > 10) {
                        _SpriteGEL("e", "e2");
                        _SpriteMove("e", exx, exy);
                    }
                    l = 2251;
                    continue;
                case 2251:
                    if (ext > 20) {
                        _SpriteGEL("e", "e3");
                        _SpriteMove("e", exx, exy);
                    }
                    l = 2252;
                    continue;
                case 2252:
                    if (ext > 30) {
                        _SpriteGEL("e", "e4");
                        _SpriteMove("e", exx, exy);
                    }
                    l = 2253;
                    continue;
                case 2253:
                    if (ext > 40) {
                        ext = 0;
                        ex = 0;
                    }
                    l = 2260;
                    continue;
                case 2260:
                    if (ex == 0) {
                        exx = -100;
                        exy = 0;
                        _SpriteGEL("e", "e");
                        _SpriteMove("e", exx, exy);
                    }
                    l = 2300;
                    continue;
                case 2300:
                    _repaint();
                    l = 2310;
                    continue;
                case 2310:
                    _delay(10);
                    l = 2320;
                    continue;
                case 2320:
                    l = 1760;
                    continue;
                case 2500:
///;
                    l = 2510;
                    continue;
                case 2510:
                    _GelLoad("spl", "splash.png");
                    l = 2513;
                    continue;
                case 2513:
                    _DrawGel("spl", 0, 0);
                    l = 2580;
                    continue;
                case 2580:
                    if (_Fire() != 0) {
                        _delay(200);
                        l = 10;
                    } else {
                        l = 2590;
                    }
                    continue;
                case 2590:
                    _repaint();
                    l = 2600;
                    continue;
                case 2600:
                    _delay(2000);
                    l = 2610;
                    continue;
                case 2610:
                    l = 10;
                    continue;
                case 2700:
///;
                    l = 2701;
                    continue;
                case 2701:
                    if (sold > record) {
                        record = sold;
                    }
                    l = 2705;
                    continue;
                case 2705:
///;
                    l = 2706;
                    continue;
                case 2706:
///;
                    l = 2707;
                    continue;
                case 2707:
///;
                    l = 2710;
                    continue;
                case 2710:
                    _DelSprite("bg");
                    _DelSprite("tl");
                    _DelSprite("l");
                    _DelSprite("l2");
                    _DelSprite("ls");
                    _DelSprite("pr");
                    _DelSprite("pr2");
                    l = 2720;
                    continue;
                case 2720:
                    _DelSprite("pr3");
                    _DelSprite("s");
                    _DelSprite("s2");
                    _DelSprite("s3");
                    _DelSprite("d");
                    _DelSprite("d2");
                    _DelSprite("d3");
                    l = 2721;
                    continue;
                case 2721:
                    _DelSprite("d4");
                    _DelSprite("d5");
                    _DelSprite("d6");
                    l = 2725;
                    continue;
                case 2725:
                    _GelLoad("sdr2", "solddr2.png");
                    l = 2726;
                    continue;
                case 2726:
                    _GelLoad("sdr3", "solddr3.png");
                    l = 2727;
                    continue;
                case 2727:
                    _GelLoad("sdr4", "solddr4.png");
                    l = 2729;
                    continue;
                case 2729:
                    _GelLoad("og", "og.png");
                    l = 2730;
                    continue;
                case 2730:
                    _GelLoad("og2", "og2.png");
                    l = 2732;
                    continue;
                case 2732:
                    _SpriteGEL("sdr", "sdr");
                    l = 2734;
                    continue;
                case 2734:
                    _SpriteGEL("og", "og");
                    l = 2735;
                    continue;
                case 2735:
                    ex = 1;
                    flx = x;
                    fly = y - 5;
                    fl2y = y - 5;
                    sdrx = x + 10;
                    sdry = y;
                    dr = 0;
                    oga = 0;
                    l = 2736;
                    continue;
                case 2736:
///;
                    l = 2738;
                    continue;
                case 2738:
///;
                    l = 2739;
                    continue;
                case 2739:
///;
                    l = 2740;
                    continue;
                case 2740:
                    _CLS();
                    l = 2745;
                    continue;
                case 2745:
                    _drawText(_str(sold), 112, 117);
                    l = 2746;
                    continue;
                case 2746:
                    _drawText(_str(record), 112, 172);
                    l = 2750;
                    continue;
                case 2750:
                    _SpriteMove("c", x, y);
                    l = 2760;
                    continue;
                case 2760:
                    _SpriteMove("e", exx, exy);
                    l = 2770;
                    continue;
                case 2770:
                    _SpriteMove("fl", flx, fly);
                    l = 2771;
                    continue;
                case 2771:
                    _SpriteMove("fl2", flx, fl2y);
                    l = 2772;
                    continue;
                case 2772:
                    _SpriteMove("rez", 0, 0);
                    l = 2773;
                    continue;
                case 2773:
                    _SpriteMove("sdr", sdrx, sdry);
                    l = 2775;
                    continue;
                case 2775:
                    sdry = sdry + 1;
                    l = 2776;
                    continue;
                case 2776:
                    flm = flm + 3;
                    l = 2777;
                    continue;
                case 2777:
                    dr = dr + 2;
                    l = 2778;
                    continue;
                case 2778:
                    oga = oga + 1;
                    l = 2780;
                    continue;
                case 2780:
                    if (ex == 1) {
                        ext = ext + 5;
                    }
                    l = 2790;
                    continue;
                case 2790:
                    if (ex == 1) {
                        exx = x;
                        exy = y - 15;
                    }
                    l = 2800;
                    continue;
                case 2800:
                    if (ext > 10) {
                        _SpriteGEL("e", "e2");
                        _SpriteMove("e", exx, exy);
                    }
                    l = 2810;
                    continue;
                case 2810:
                    if (ext > 20) {
                        _SpriteGEL("e", "e3");
                        _SpriteMove("e", exx, exy);
                    }
                    l = 2820;
                    continue;
                case 2820:
                    if (ext > 30) {
                        _SpriteGEL("e", "e4");
                        _SpriteMove("e", exx, exy);
                    }
                    l = 2830;
                    continue;
                case 2830:
                    if (ext > 40) {
                        _SpriteGEL("e", "e3");
                        _SpriteMove("e", exx, exy);
                    }
                    l = 2832;
                    continue;
                case 2832:
                    if (ext > 50) {
                        _SpriteGEL("e", "e2");
                        _SpriteMove("e", exx, exy);
                    }
                    l = 2833;
                    continue;
                case 2833:
                    if (ext > 60) {
                        ext = 0;
                        ex = 0;
                    }
                    l = 2840;
                    continue;
                case 2840:
                    if (ex == 0) {
                        exx = -100;
                        exy = 0;
                        _SpriteGEL("e", "e");
                        _SpriteMove("e", exx, exy);
                    }
                    l = 2850;
                    continue;
                case 2850:
                    if (flm > 10) {
                        fl2y = y - 5;
                    }
                    l = 2852;
                    continue;
                case 2852:
                    if (flm > 20) {
                        fl2y = y - 10;
                    }
                    l = 2853;
                    continue;
                case 2853:
                    if (flm > 20) {
                        flm = 0;
                    }
                    l = 2860;
                    continue;
                case 2860:
                    if (sdry > 299) {
                        sdry = 300;
                    }
                    l = 2870;
                    continue;
                case 2870:
                    if (dr > 50) {
                        _SpriteGEL("sdr", "sdr2");
                        _SpriteMove("sdr", sdrx, sdry);
                    }
                    l = 2871;
                    continue;
                case 2871:
                    if (dr > 80) {
                        _SpriteGEL("sdr", "sdr3");
                        _SpriteMove("sdr", sdrx, sdry);
                    }
                    l = 2873;
                    continue;
                case 2873:
                    if (dr > 80) {
                        sdrx = sdrx - 3;
                    }
                    l = 2890;
                    continue;
                case 2890:
                    if (oga > 5) {
                        oga = 0;
                    }
                    l = 2900;
                    continue;
                case 2900:
                    if (oga > 3) {
                        _SpriteGEL("og", "og2");
                        _SpriteMove("og", sdrx, sdry);
                    }
                    l = 2910;
                    continue;
                case 2910:
                    if (oga < 3) {
                        _SpriteGEL("og", "og");
                        _SpriteMove("og", sdrx, sdry);
                    }
                    l = 2950;
                    continue;
                case 2950:
                    if (_Fire() != 0) {
                        _delay(200);
                        _DelSprite("rez");
                        _DelSprite("c");
                        _DelSprite("e");
                        _DelSprite("fl");
                        _DelSprite("fl2");
                        _DelSprite("sdr");
                        _DelSprite("og");
                        _DelSprite("s");
                        l = 20;
                    } else {
                        l = 3000;
                    }
                    continue;
                case 3000:
                    _repaint();
                    l = 3010;
                    continue;
                case 3010:
                    _delay(10);
                    l = 3020;
                    continue;
                case 3020:
                    l = 2740;
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
