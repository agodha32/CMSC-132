package fractals;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

abstract class FractalCanvas extends JPanel {
	private static final long serialVersionUID = 1L;

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g.create();
		paintFractal(g2d);

		g2d.dispose(); // clean up
	}

	abstract void setValue(int v);

	abstract protected void paintFractal(Graphics2D g2d);
}
