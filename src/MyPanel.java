import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MyPanel extends JPanel {
    public MyPanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
    }
    public Dimension getPreferredSize() {
        return new Dimension(1560,700);
    }
    private int x = 100;
    private int y = 100;
    private int width = 50;
    private int height = 500;
    private int step = 30;
    private int delta = 5;

    private ArrayList<Rectangle> outlist = new ArrayList<Rectangle>();
    public void setSymbols(String parm){
        String[] arr = parm.replace(",", "").split(" ");
        for (String cifra:arr) {
            switch(cifra){
                case "Z":
                    segment(1);
                    segment(8);
                    segment(5);
                    break;
                case "X":
                    segment(8);
                    segment(9);
                    break;
                case "C":
                    segment(1);
                    segment(6);
                    segment(7);
                    segment(5);
                    break;
                case "V":
                    segment(2);
                    segment(7);
                    segment(10);
                    segment(11);
                    break;
                case "L":
                    segment(5);
                    segment(6);
                    segment(7);
                    break;
                case "z":
                    segment(12);
                    segment(14);
                    segment(13);
                    break;
                case "x":
                    segment(15);
                    segment(13);
                    break;
                case "c":
                    segment(16);
                    segment(17);
                    segment(18);
                    segment(19);
                    break;
                case "v":
                    segment(20);
                    segment(21);
                    break;
                case "l":
                    segment(17);
                    segment(18);
            }
            x = x + step + width;
        }
    }
    private void segment(int number){
        switch (number){
            case 1:outlist.add(new Rectangle(x+delta, y, x+width-delta, y));
                break;
            case 2:outlist.add(new Rectangle(x+width, y+delta, x+width,y+(height/2)-delta));
                break;
            case 3:outlist.add(new Rectangle(x+delta,y+height/2, x+width-delta, y+height/2));
                break;
            case 4:outlist.add(new Rectangle(x+width, y+(height/2)+delta, x+width, y+height-delta));
                break;
            case 5:outlist.add(new Rectangle(x+delta, y+height, x+width-delta, y+height));
                break;
            case 6:outlist.add(new Rectangle(x, y+(height/2)+delta, x, y+height-delta));
                break;
            case 7:outlist.add(new Rectangle(x, y+delta, x, y+(height/2)-delta));
                break;
                // Диагональная линия для буквы Z
            case 8:
                outlist.add(new Rectangle(x+width-delta, y, x+delta, y+height));
                break;
                //Диагональная линия для буквы X
            case 9:
                outlist.add(new Rectangle(x+delta, y, x+width-delta, y+height));
                break;
                // линии для буквы V
            case 10:
                outlist.add(new Rectangle(x, y+(height)/2, x+(width/2), y+height));
                break;
            case 11:
                outlist.add(new Rectangle(x+width, y+(height/2), x+(width/2), y+height));
                break;
                // сегменты для буквы z
            case 12:
                outlist.add(new Rectangle(x, y+(height/2), x+(width/2), y+(height/2)));
                break;
            case 13:
                outlist.add(new Rectangle(x, y+height, x+(width/2), y+(height/2)));
                break;
            case 14:
                outlist.add(new Rectangle(x, y+height, x+(width/2), y+height));
                break;
                //сегменты для буквы x
            case 15:
                outlist.add(new Rectangle(x+(width/2), y+height, x, y+(height/2)));
                break;
                // сегменты для буквы c
            case 16:
                outlist.add(new Rectangle(x, y+(height/2), x+(width/2), y+(height/2)));
                break;
            case 17:
                outlist.add(new Rectangle(x, y+((3*height)/4), x, y+height));
                break;
            case 18:
                outlist.add(new Rectangle(x, y+(height/2), x, y+((3*height)/4)));
                break;
            case 19:
                outlist.add(new Rectangle(x, y+height, x+(width/2), y+height));
                break;
                // сегменты для буквы v
            case 20:
                outlist.add(new Rectangle(x, y+(height/2),x+(width/4),y+height));
                break;
            case 21:
                outlist.add(new Rectangle(x+(width/4), y+height, x+(width/2), y+height/2));
        }
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw Text
        // g.drawString("This is my custom Panel!", 10, 20);
        for (Rectangle rect:outlist) {
            g.drawLine(rect.x, rect.y, rect.width, rect.height);
        }
    }
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y =y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setStep(int step) {
        this.step = step;
    }
}
