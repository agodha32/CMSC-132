package fractals;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Fractal extends JPanel {
	private static final long serialVersionUID = 1L;
	static final int CANVAS_SIZE = 600;

	Fractal(final FractalCanvas canvas) {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setOpaque(true);
		// Create the label.
		JLabel sliderLabel = new JLabel("Recursive depth", JLabel.CENTER);
		sliderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		// Create the slider.
		final JSlider recursiveDepth = new JSlider(JSlider.HORIZONTAL, 0, 15, 1);
		recursiveDepth.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				canvas.setValue((int) recursiveDepth.getValue());
				repaint();
			}
		});

		// Turn on labels at major tick marks.
		recursiveDepth.setMajorTickSpacing(5);
		recursiveDepth.setMinorTickSpacing(1);
		recursiveDepth.setPaintTicks(true);
		recursiveDepth.setPaintLabels(true);
		recursiveDepth.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		recursiveDepth.setValue(0);

		canvas.setPreferredSize(new Dimension(CANVAS_SIZE, CANVAS_SIZE));
		canvas.setBorder(BorderFactory.createLineBorder(Color.blue, 2));
		canvas.setBackground(Color.white);
		canvas.setValue(0);
		add(canvas);

		add(sliderLabel);
		add(recursiveDepth);

	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be invoked
	 * from the event-dispatching thread.
	 */
	public static void createAndShowGUI(Fractal f) {
		// Make sure we have nice window decorations.
		JFrame.setDefaultLookAndFeelDecorated(true);

		// Create and set up the window.
		JFrame frame = new JFrame("Fractal demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.
		frame.setContentPane(f);

		// Display the window.
		frame.pack();
		frame.setVisible(true);

	}

}
