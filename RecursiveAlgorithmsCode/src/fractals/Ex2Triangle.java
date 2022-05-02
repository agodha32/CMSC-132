package fractals;

import java.awt.Graphics2D;
import java.awt.Polygon;

public class Ex2Triangle extends FractalCanvas {
	private static final long serialVersionUID = 1L;
	int level = 1;

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Fractal.createAndShowGUI(new Fractal(new Ex2Triangle()));
			}
		});
	}

	@Override
	void setValue(int v) {
		level = v;

	}

	@Override
	protected void paintFractal(Graphics2D g2d) {
		paintRecursion(g2d, 10, 10, Fractal.CANVAS_SIZE - 20, level);
	}

	void paintRecursion(Graphics2D g2d, double x, double y, double size, int level) {
		if (level <= 0 || size <= 1.0) {
			Polygon triangle = new Polygon(new int[] { (int) x, (int) (x + size), (int) (x + size / 2) },
					new int[] { (int) y, (int) y, (int) (y + size) }, 3);
			g2d.fill(triangle);
		} else {
			double h = size / 2;
			paintRecursion(g2d, x, y, h, level - 1);
			paintRecursion(g2d, x + h, y, h, level - 1);
			paintRecursion(g2d, x + h / 2, y + h, h, level - 1);

		}
	}
}
