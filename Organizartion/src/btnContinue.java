import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class btnContinue extends Main implements ActionListener {

	static String name[] = new String[500];

	static String number[] = new String[5];

	public void actionPerformed(ActionEvent event) {

		if (event.getSource() == btn1) {
			btn1.setVisible(false);
			btn2.setVisible(false);

			btn1();
		}

		if (event.getSource() == btn2) {
			btn1.setVisible(false);
			btn2.setVisible(false);

			btn2();
		}

	}

	void btn1() {
		JOptionPane
				.showMessageDialog(
						null,
						"This database is designed to be a contact list. Simply add the person's name and phone number. Type in 'stop' to stop adding new contacts.");

		for (int i = 0; i < 5; i++) {

			name[i] = JOptionPane.showInputDialog(null,
					"What is the name of the person?");

			if (name[i].equalsIgnoreCase("stop")) {
				name[i] = " ";
				break;

			}
			number[i] = JOptionPane.showInputDialog(null, "Add the number");

			JOptionPane.showMessageDialog(null, name[i] + " " + number[i]);

		}

	}

	void btn2() {
		
		JTable table2;
		//setLayout(new FlowLayout());
		String [] columns ={"Names","Hair","nails", "kjn"};
		Object [][] data={
				{"r","d","d"},
				{"d","d","t"},
				{"r","d","d"},
				{"d","d","t"},
				{"r","d","d"},
				{"d","d","t"}
		};
		
		table2=new JTable(data,columns);
			table2.setPreferredScrollableViewportSize(new Dimension(400,500));
			table2.setFillsViewportHeight(true);
			
			JScrollPane scollPane=new JScrollPane(table2);
			f.add(scollPane);
		}
		
	}

