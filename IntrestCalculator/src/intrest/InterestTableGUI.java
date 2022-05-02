package intrest;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class InterestTableGUI extends Application {

	TextField ogAmount, iRate;
	TextArea displayArea;
	Slider slider;

	@Override
	public void start(Stage mainStage) {

		int sceneWidth = 475;
		int sceneHeight = 350;
		int verSpaceBetweenNodes = 8;
		int horSpaceBetweenNodes = 8;
		int paneBorderTop = 20;
		int paneBorderRight = 20;
		int paneBorderBottom = 20;
		int paneBorderLeft = 20;

		/* Setting pane properties */
		FlowPane fieldsPane = new FlowPane();
		fieldsPane.setHgap(horSpaceBetweenNodes);
		fieldsPane.setVgap(verSpaceBetweenNodes);
		fieldsPane.setPadding(new Insets(paneBorderTop, paneBorderRight, 
				paneBorderBottom, paneBorderLeft));

		displayArea = new TextArea();
		displayArea.setEditable(false);

		fieldsPane.getChildren().add(displayArea);

		/* Adding scroll pane to text area */
		ScrollPane scrollPane = new ScrollPane(displayArea);

		/* Adding GUI elements */
		Label originalAmount = new Label("Original Amount: ");
		ogAmount = new TextField();
		fieldsPane.getChildren().addAll(originalAmount, ogAmount);

		Label intrestRate = new Label("Intrest Rate: ");
		iRate = new TextField();
		fieldsPane.getChildren().addAll(intrestRate, iRate);

		// slider

		slider = new Slider();
		Label numYears = new Label("Number of Years: ");
		slider = new Slider();
		slider.setMin(1);
		slider.setMax(25);
		slider.setValue(1);
		slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);
		slider.setMajorTickUnit(5);
		slider.setBlockIncrement(1);
		fieldsPane.getChildren().addAll(numYears, slider);

		Button button = new Button("Simple Intrest");
		Button buttonOne = new Button("Compound Intrest");
		Button buttonTwo = new Button("Simple and Compound Intrest");

		fieldsPane.getChildren().add(button);
		fieldsPane.getChildren().add(buttonOne);
		fieldsPane.getChildren().add(buttonTwo);

		button.setOnAction(new ButtonListener());

		buttonOne.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {

				double principal = getPrincipal();
				double rate = getRate();
				double years = getYears();

				displayArea.setText(IntrestCalculator.compoundInterestTable(
						principal, rate, years));

			}

		});

		buttonTwo.setOnAction(e -> {

			double OriginalAmount = getPrincipal();
			double ratePercentage = getRate();
			double years = getYears();

			String toReturn = "Original Amount: " + OriginalAmount + ", Rate: " + ratePercentage
					+ "\n Year, Simple Intrest --> Compound Interest Amount";

			for (int row = 1; years >= row; row++) {

				toReturn += "\n" + row + " --> " + 
				IntrestCalculator.simpleInterest(OriginalAmount, ratePercentage,
						row) + " --> " + IntrestCalculator.compoundInterest(
								OriginalAmount, ratePercentage, row);

			}

			displayArea.setText(toReturn);

		});

		/* Adding to BorderPane */
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(fieldsPane);
		borderPane.setCenter(scrollPane);

		/* Display the stage */
		Scene scene = new Scene(borderPane, sceneWidth, sceneHeight);
		mainStage.setTitle("Intrest Calculator");
		mainStage.setScene(scene);
		mainStage.show();
	}

	private double getPrincipal() {

		return Double.parseDouble(ogAmount.getText());

	}

	private double getRate() {

		return Double.parseDouble(iRate.getText());

	}

	private double getYears() {

		return slider.getValue();
	}

	/**
	 * Non-anonymous inner class for simple interest actionListener
	 */

	private class ButtonListener implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent e) {

			double principal = getPrincipal();
			double rate = getRate();
			double years = getYears();

			displayArea.setText(IntrestCalculator.simpleInterestTable(principal,
					rate, years));

		}
	}

	public static void main(String[] args) {

		Application.launch(args);

	}

}
