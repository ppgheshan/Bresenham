import javax.swing.*;
import java.awt.*;

public class Bresenham extends JFrame {
    public Bresenham() {
        setTitle("Bresenham's Circle Algorithm");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g) {
        super.paint(g);
        int xc = 250, yc = 250;
		for(int i = 0; i<100;i=i+20){
			int radius = 100+i;
			drawCircleBresenham(g, xc, yc, radius);
		}
        //int radius = 100;
        //drawCircleBresenham(g, xc, yc, radius);
    }

    public void drawCircleBresenham(Graphics g, int xc, int yc, int r) {
        int x = 0;
        int y = r;
        int d = 3 - 2 * r;
        while (x <= y) {
            plotCirclePoints(g, xc, yc, x, y);
            x++;
            if (d < 0) {
                d = d + 4 * x + 6;
            } else {
                y--;
                d = d + 4 * (x - y) + 10;
            }
        }
    }

    private void plotCirclePoints(Graphics g, int xc, int yc, int x, int y) {
        g.drawLine(xc + x, yc + y, xc + x, yc + y);
        g.drawLine(xc - x, yc + y, xc - x, yc + y);
        g.drawLine(xc + x, yc - y, xc + x, yc - y);
        g.drawLine(xc - x, yc - y, xc - x, yc - y);
        g.drawLine(xc + y, yc + x, xc + y, yc + x);
        g.drawLine(xc - y, yc + x, xc - y, yc + x);
        g.drawLine(xc + y, yc - x, xc + y, yc - x);
        g.drawLine(xc - y, yc - x, xc - y, yc - x);
    }

    public static void main(String[] args) {
        Bresenham frame = new Bresenham();
        frame.setVisible(true);
    }
}