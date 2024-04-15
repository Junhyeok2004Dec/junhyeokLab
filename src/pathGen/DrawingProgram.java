package pathGen;


import javax.swing.*;

public class DrawingProgram {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Drawing Program");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new DrawingPanel());
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}