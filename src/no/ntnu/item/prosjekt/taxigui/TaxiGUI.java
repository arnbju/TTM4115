package no.ntnu.item.prosjekt.taxigui;

import no.ntnu.item.arctis.runtime.Block;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import no.ntnu.item.arctis.runtime.Block;

public class TaxiGUI extends Block {
private JFrame frame;
	private JTextArea text;
	private JTextArea state;
	private final static String[] BUTTONS = {"LOGON", "LOGOFF", "FREE", "BUSY", "ACCEPT"};

	public void show(java.lang.String id) {
	System.out.println("creating GUI: " + id);
		frame = new JFrame(id);
		frame.getContentPane().setLayout(new GridLayout(4,3,10,10));
		
		
		text = new JTextArea(4, 20);
		frame.getContentPane().add(text);
		
		state = new JTextArea(1, 20);
		frame.getContentPane().add(state);
	
		for(final String d: BUTTONS) {
			Button b = new Button(d);
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					sendToBlock(d, d);
				}
			});
			frame.getContentPane().add(b);
		}
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				sendToBlock("CLOSED");
			}
		});
		frame.setVisible(true);
		frame.pack();
	}

	public void showString(java.lang.String in) {
		text.setText(in);
	}

	public void showState(java.lang.String in) {
		state.setText(in);
	}
}