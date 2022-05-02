package fractals;

import java.awt.Graphics2D;

public class Ex3CCurve extends FractalCanvas {
	private static final long serialVersionUID = 1L;
	int level = 0;

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Fractal.createAndShowGUI(new Fractal(new Ex3CCurve()));
			}
		});
	}

	@Override
	void setValue(int v) {
		level = v;

	}

	@Override
	protected void paintFractal(Graphics2D g2d) {
		int mid = Fractal.CANVAS_SIZE / 2;
		paintRecursion(g2d, mid / 2 + 10, mid, mid * 3 / 2 - 10, mid, level);
	}

	void paintRecursion(Graphics2D g2d, double x1, double y1, double x3, double y3, int level) {
		if (level <= 0) {

			g2d.drawLine((int) x1, (int) y1, (int) x3, (int) y3);
		} else {
			double x2 = (x1 + x3 + y1 - y3) / 2;
			double y2 = (x3 + y1 + y3 - x1) / 2;

			paintRecursion(g2d, x1, y1, x2, y2, level - 1);
			paintRecursion(g2d, x2, y2, x3, y3, level - 1);

		}
	}
}
