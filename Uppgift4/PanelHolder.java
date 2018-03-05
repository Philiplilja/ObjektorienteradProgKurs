import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PanelHolder extends JFrame implements ActionListener {

		private static final long serialVersionUID = 1L;

		private JLabel label;
		private JButton button1;
		private JButton button2;
		private JButton button3;
		private JButton button4;
		private JPanel panel;
		
		
		Cart shoppingCart = new Cart();
		
		public PanelHolder(){
			
			super("The Simple Shop");
			this.setLayout(new FlowLayout());
			label = new JLabel();
			
			//All buttons. Creates and implements
			button1 = new JButton("Buy bicycle");
			button2 = new JButton("Buy flashlight");
			button3 = new JButton("Buy bag");
			button4 = new JButton("Clear Cart");
			
			//Calling the actions
			button1.addActionListener(this);
			button2.addActionListener(this);
			button3.addActionListener(this);
			button4.addActionListener(this);
			
			panel = new JPanel();
			panel.setLayout(new BorderLayout());

			this.add(label);
			this.add(button1);
			this.add(button2);
			this.add(button3);
			this.add(button4);
			this.add(panel);
			this.setSize(600, 400);
			
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		}
		
		//Actions when button is clicked
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource() == this.button1) {
				label.setText("[Bicycle]");
		}	
			if(e.getSource() == this.button2) {
				label.setText("[Flashlight]");
		}	
			if(e.getSource() == this.button3) {
				label.setText("[Bag]");
		}
			if(e.getSource() == this.button4) {
				shoppingCart.empty();
				label.setText("");
		}
	}
}
