package no.ntnu.item.prosjekt.usergui;

import no.ntnu.item.arctis.runtime.Block;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JTextArea;



public class UserGUI extends Block {
	private JFrame frame;
	private JTextArea text;

	
	public void show(java.lang.String id) {
			System.out.println("User GUI created: " +id);
		frame = new JFrame(id);
		frame.getContentPane().setLayout(new GridLayout(4,3,10,10));
		
		text = new JTextArea(4, 20);
		frame.getContentPane().add(text);
		
		Button b = new Button("Order Taxi");
		b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					sendToBlock("REQUEST", "Order Taxi");
				}
			});
		frame.getContentPane().add(b);
		
		b = new Button("Cancel");
		b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					sendToBlock("CANCEL", "Cancel");
				}
			});
		frame.getContentPane().add(b);
		
		b = new Button("Get queue number");
		b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					sendToBlock("GETQUEUENO", "Get queue number");
				}
			});
		frame.getContentPane().add(b);
		
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				sendToBlock("CLOSED");
			}
		});
		frame.setVisible(true);
		frame.pack();
	}
	
	public void hide() {
		frame.setVisible(false);
	}

	public void showString(String in) {
		text.setText(in);
	}
}