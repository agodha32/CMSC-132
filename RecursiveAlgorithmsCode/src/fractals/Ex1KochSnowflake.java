package fractals;

import java.awt.Graphics2D;

public class Ex1KochSnowflake extends FractalCanvas {
	private static final long serialVersionUID = 1L;

	private static final int offset = 60;

	private static final int border = 100;

	int level = 0;

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Fractal.createAndShowGUI(new Fractal(new Ex1KochSnowflake()));
			}
		});
	}

	@Override
	void setValue(int v) {
		level = v;

	}

	@Override
	protected void paintFractal(Graphics2D g2d) {
		int sz = Fractal.CANVAS_SIZE - border * 2;

		paintRecursion(g2d, border + sz, border + offset, border, border + offset, level);
		paintRecursion(g2d, border + sz / 2, border + sz + offset, border + sz, border + offset, level);
		paintRecursion(g2d, border, border + offset, border + sz / 2, border + sz + offset, level);
	}

	final static double SQ = Math.sqrt(3.0) / 6;

	void paintRecursion(Graphics2D g2d, double x1, double y1, double x5, double y5, double level) {
		if (level <= 0 || Math.abs(x1 - x5) < 1.0 && Math.abs(y1 - y5) < 1.0) {
			g2d.drawLine((int) x1, (int) y1, (int) x5, (int) y5);
		} else {
			double deltaX = x5 - x1;
			double deltaY = y5 - y1;
			double x2 = x1 + deltaX / 3;
			double y2 = y1 + deltaY / 3;

			double x3 = ((x1 + x5) / 2 + SQ * (y1 - y5));
			double y3 = ((y1 + y5) / 2 + SQ * (x5 - x1));

			double x4 = x5 - deltaX / 3;
			double y4 = y5 - deltaY / 3;

			paintRecursion(g2d, x1, y1, x2, y2, level - 1);
			paintRecursion(g2d, x2, y2, x3, y3, level - 1);
			paintRecursion(g2d, x3, y3, x4, y4, level - 1);
			paintRecursion(g2d, x4, y4, x5, y5, level - 1);

		}
	}
}
