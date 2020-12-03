import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class GuessGame extends JFrame {
	private JTextField textGuess;
	private     JLabel lblOutput;								//label for too high/too low for  output
	private int randomNo;                               //the no we are trying to guess
	private int triesLeft=7;
	//private JLabel randomnoLabel;
	public void checkGuess()                                                   //function to check the guess is high/low or correct 
	{
			
		String guessText=textGuess.getText();
			String message ="";
		
			try
			{
					int guess=Integer.parseInt(guessText);
				if(guess<=100 && guess>0)
				{
					
					triesLeft--;
					if(guess > randomNo)
					{
						message=guess+" was too high !You have  "+triesLeft+  " tries left ";
						lblOutput.setText(message);
					}
					else	if(guess < randomNo)
					{
						message=guess+" was too low ! You have "+triesLeft+  "  tries left ";
						lblOutput.setText(message);
					}
					else
					{
						message=guess+ " was right  , You   WIN  . Let's play again ! ";
						lblOutput.setText(message);
						newGame();
					}
					if(triesLeft==0)
					{
						lblOutput.setText("No attempts left .You lose .Let's Play again ");
						
						javax.swing.JOptionPane.showConfirmDialog(null, "You are out of tries ,The no was "+randomNo+" .Play again ");
						
						newGame();
					}
					
					
				}
				
				else
				{
					message="WARNING !! Enter no only in between 1 to 100. ";
					lblOutput.setText(message);
				}	
			}
	catch(Exception e)
	{
				lblOutput.setText("Enter a whole number between 1 and 100");
	}
	finally
	{
	textGuess.requestFocus();
		textGuess.selectAll();
	}
			}
	public void newGame() 														//method to create random no 1 .....100
	{
		randomNo=(int)(Math.random()*100+1);
	//	 randomnoLabel.setText("Random no is "+randomNo);
		triesLeft=7;
	}
	
	public GuessGame() {
		getContentPane().setBackground(new Color(255, 153, 51));
		setBackground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setForeground(UIManager.getColor("ToolBar.dockingForeground"));
		getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("Hi-LO Guessing Game");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(0, 0, 434, 31);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel);
		
		JButton btnGuess = new JButton("GUESS");
		btnGuess.setForeground(new Color(0, 0, 0));
		btnGuess.setBackground(new Color(230, 230, 250));
		btnGuess.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnGuess.setBounds(143, 132, 178, 31);
		getContentPane().add(btnGuess);
		
		lblOutput = new JLabel("Enter a number above.You have 7 tries  !");
		lblOutput.setFont(new Font("Mongolian Baiti", Font.BOLD, 15));
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(32, 174, 369, 76);
		getContentPane().add(lblOutput);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 153));
		panel.setForeground(Color.BLACK);
		panel.setBounds(32, 60, 369, 38);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Guess a number between 1 to 100");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblNewLabel_1.setBounds(25, 11, 251, 19);
		panel.add(lblNewLabel_1);
		
		textGuess = new JTextField();
		textGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			checkGuess();
			}
		});
		textGuess.setHorizontalAlignment(SwingConstants.CENTER);
		textGuess.setColumns(10);
		textGuess.setBounds(286, 11, 60, 20);
		panel.add(textGuess);
		
	/*	 randomnoLabel = new JLabel("");
		randomnoLabel.setBounds(10, 42, 118, 14);
		getContentPane().add(randomnoLabel);
	*/
		}

	public static void main(String[] args){
	
		GuessGame obj=new GuessGame();
		obj.newGame();
		obj.setSize(new Dimension(500,330));
		obj.setVisible(true);
		
	}
}
