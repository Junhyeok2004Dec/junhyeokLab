package Worker;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;



public class WorkerSystem_2
{
	public static void main(String[] args) {
		JFrame frame = new JFrame("JTable to Text File Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 400);

		// Column names for the JTable
		String[] columnNames = {"이름", "근무지", "군번", "기수", "책임지역"};

		// Create a table model and set it to a JTable
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		JTable table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);

		// Panel for input fields
		JPanel inputPanel = new JPanel(new GridLayout(5, 2));

		JTextField nameField = new JTextField();
		JTextField workplaceField = new JTextField();
		JTextField militaryIdField = new JTextField();
		JTextField classField = new JTextField();
		JTextField responsibilityField = new JTextField();

		inputPanel.add(new JLabel("이름:"));
		inputPanel.add(nameField);
		inputPanel.add(new JLabel("근무지:"));
		inputPanel.add(workplaceField);
		inputPanel.add(new JLabel("군번:"));
		inputPanel.add(militaryIdField);
		inputPanel.add(new JLabel("기수:"));
		inputPanel.add(classField);
		inputPanel.add(new JLabel("책임지역:"));
		inputPanel.add(responsibilityField);

		// Button to add new row to the JTable
		JButton addButton = new JButton("추가");
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String workplace = workplaceField.getText();
				String militaryId = militaryIdField.getText();
				String classInfo = classField.getText();
				String responsibility = responsibilityField.getText();

				// Add a new row to the table
				model.addRow(new Object[]{name, workplace, militaryId, classInfo, responsibility});

				// Clear the input fields
				nameField.setText("");
				workplaceField.setText("");
				militaryIdField.setText("");
				classField.setText("");
				responsibilityField.setText("");
			}
		});

		// Button to save the JTable data to a text file
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

		JPanel southPanel = new JPanel();
		southPanel.add(addButton);
		southPanel.add(saveButton);
		frame.add(southPanel, BorderLayout.SOUTH);
		frame.add(inputPanel, BorderLayout.NORTH);

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
