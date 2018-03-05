import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PanelHolder extends JFrame implements ActionListener, CartListener {

		private static final long serialVersionUID = 1L;
		
		private JLabel itemLabel;
		private JLabel costLabel;
		private JLabel feedbackLabel;
		private JButton button1;
		private JButton button2;
		private JButton button3;
		private JButton button4;
		
		private JPanel buttonPanel;
		private JPanel cartPanel;
		private JPanel itemPanel;
		private JPanel costPanel;
		private JPanel feedbackPanel;
		
		private Cart shoppingCart = new Cart();
		
		public PanelHolder(){
			
			super("The Simple Shop");
			
			shoppingCart.addListener(this);
			
			//All buttons. Creates and implements
			button1 = new JButton("Buy bicycle");
			button1.setBounds(73, 5, 114, 35);
			button2 = new JButton("Buy flashlight");
			button2.setBounds(192, 5, 130, 35);
			button3 = new JButton("Buy bag");
			button3.setBounds(327, 5, 93, 35);
			button4 = new JButton("Clear Cart");
			button4.setBounds(425, 5, 106, 35);
			
			//Calling the actions
			button1.addActionListener(this);
			button2.addActionListener(this);
			button3.addActionListener(this);
			button4.addActionListener(this);
			
			//creating button panel
			buttonPanel = new JPanel();
			buttonPanel.setBackground(Color.GRAY);
			buttonPanel.setBounds(548, 27, 22, -20);
			buttonPanel.setLayout(new BorderLayout());
			getContentPane().setLayout(null);
			getContentPane().add(button1);
			getContentPane().add(button2);
			getContentPane().add(button3);
			getContentPane().add(button4);
			getContentPane().add(buttonPanel);
			
			//creating cartPanel
			cartPanel = new JPanel();
			cartPanel.setBounds(6, 72, 588, 233);
			cartPanel.setBackground(Color.WHITE);
			getContentPane().add(cartPanel);
			cartPanel.setLayout(new FlowLayout());
			
			//creating itemPanel
			itemPanel = new JPanel();
			itemPanel.setBounds(6, 46, 588, 25);
			itemPanel.setBackground(Color.CYAN);
			getContentPane().add(itemPanel);
			itemPanel.setLayout(null);
			
			//creating itemLabel
			itemLabel = new JLabel("The number of items in cart is " + shoppingCart.countItem());
			itemLabel.setBounds(6, 6, 576, 16);
			itemPanel.add(itemLabel);
			
			//creating costPanel
			costPanel = new JPanel();
			costPanel.setBounds(6, 306, 588, 25);
			costPanel.setBackground(Color.CYAN);
			getContentPane().add(costPanel);
			costPanel.setLayout(null);
			
			//creating label costLabel
			costLabel = new JLabel("The total cost of the cart is " + " kr");
			costLabel.setBounds(6, 6, 576, 16);
			costPanel.add(costLabel);
			
			//creating feedbackPanel
			feedbackPanel = new JPanel();
			feedbackPanel.setBounds(6, 333, 588, 35);
			getContentPane().add(feedbackPanel);
			this.setSize(600, 400);
			
			//creating feedbackLabel
			feedbackLabel = new JLabel();
			feedbackPanel.add(feedbackLabel);
			
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}

		private void updateCartPanel(){
			//update cart
			cartPanel.removeAll();
			for(Item item : shoppingCart.totalCart()){
				cartPanel.add(new JLabel(item.getName()));
			}
			cartPanel.updateUI();
			//counting items
			itemLabel.setText("The number of items in cart is " + shoppingCart.countItem());
			//giving feedback on total cost
			int tc = shoppingCart.totalCost();
			costLabel.setText("The total cost of the cart is " + tc + " kr");
		}
		
		//Actions when button is clicked
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource() == this.button1) {
				shoppingCart.addItem(new Bicycle());
		}	
			if(e.getSource() == this.button2) {
				shoppingCart.addItem(new Flashlight());
		}	
			if(e.getSource() == this.button3) {
				shoppingCart.addItem(new Bag());
		}
			if(e.getSource() == this.button4) {
				//clearing cart
				shoppingCart.empty();
				

		}
	}

		@Override
		public void onAddItem(Item item) {
			feedbackLabel.setText(item.getName() +" with cost " + item.getValue() + " is being added to the cart");
			updateCartPanel();
			
		}

		@Override
		public void onClear() {
			//giving feedback from clearing
			feedbackLabel.setText("All items are being removed from the cart");
			updateCartPanel();
			
		}
}
