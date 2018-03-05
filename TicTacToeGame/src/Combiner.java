import java.awt.*;
import javax.swing.*;

public class Combiner extends JFrame {

	private static final long serialVersionUID = 1L;
	private Options optionButtons;
	private Board gameBoard;

	Combiner() {

		setLayout(new BorderLayout());	//Creating panels
		
		gameBoard = new Board();
		optionButtons = new Options();

		add(gameBoard, BorderLayout.CENTER);
		add(optionButtons, BorderLayout.SOUTH);
		
		setVisible(true);
		setSize(500, 500);
		optionButtons.SetObject(gameBoard);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
