package Worker;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WorkerSystem {
	public static void main(String[] args) {
		JFrame frame = new JFrame("JTable to Text File Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 400);

		// Column names for the JTable
		String[] columnNames = {"이름", "근무지", "군번", "기수", "책임지역"};

		// Sample data for the JTable
		Object[][] data = {
				{"홍길동", "4444부대", "00-79999999", "병 제 462기", "제1활주로, 제2연병장"}
		};

		// Create a table model and set it to a JTable
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		JTable table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);

		// Create a button to save the JTable data to a text file
		JButton saveButton = new JButton("Save to TXT");
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Call the method to save data to a text file
				saveTableDataToTxt(table);
			}
		});

		// Layout components in the frame
		frame.setLayout(new BorderLayout());
		frame.add(scrollPane, BorderLayout.CENTER);
		frame.add(saveButton, BorderLayout.SOUTH);

		frame.setVisible(true);
	}

	private static void saveTableDataToTxt(JTable table) {
		// Choose a file to save the data
		JFileChooser fileChooser = new JFileChooser();
		int option = fileChooser.showSaveDialog(null);
		if (option == JFileChooser.APPROVE_OPTION) {
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(fileChooser.getSelectedFile() + ".txt"));

				// Write column headers
				for (int i = 0; i < table.getColumnCount(); i++) {
					writer.write(table.getColumnName(i) + "\t");
				}
				writer.write("\n");

				// Write table data
				for (int i = 0; i < table.getRowCount(); i++) {
					for (int j = 0; j < table.getColumnCount(); j++) {
						writer.write(table.getValueAt(i, j).toString() + "\t");
					}
					writer.write("\n");
				}

				writer.close();
				JOptionPane.showMessageDialog(null, "Data saved successfully!");

			} catch (IOException ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error saving data: " + ex.getMessage());
			}
		}
	}
}
