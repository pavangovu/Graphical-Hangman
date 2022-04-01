/*
 * @author Brooke
 * 
 * Start screen for the graphical Hangman game.
 * At present, the title and level difficulty buttons have been implemented visually,
 * but the layout is incorrect and the buttons currently do not function.
 * 
 * To add: 
 * - Button functionality to access game states
 * - Correct formatting for layout
 * - "How to play" button and screen
 * 
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class startScreen {

	private static void createFrame() {
		
		final Color backgroundColor = new Color(18, 159, 155);
		final Color buttonColor = new Color(120, 120, 120);
		
		// Create window with 1080 x 800 resolution
		JFrame frame = new JFrame("Hangman");
		frame.setPreferredSize(new Dimension(1080, 800));
		frame.getContentPane().setBackground(backgroundColor);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Title at center of screen
		JLabel title = new JLabel("H_NGM_N");
		title.setFont(new java.awt.Font("Tahoma", Font.BOLD, 84));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setVerticalAlignment(SwingConstants.CENTER);

		// Create level selection buttons
		JLabel selection = new JLabel("Select Level");
		title.setFont(new java.awt.Font("Tahoma", Font.BOLD, 72));
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(backgroundColor);

		JButton easy = new JButton("Easy");
		Border border = new LineBorder(Color.BLACK, 4, true);
		easy.setBorder(border);
		easy.setPreferredSize(new Dimension(150, 100));
		easy.setFont(new java.awt.Font("Tahoma", Font.BOLD, 24));
		easy.setBackground(buttonColor);

		JButton medium = new JButton("Medium");
		medium.setPreferredSize(new Dimension(150, 100));
		medium.setBorder(border);
		medium.setPreferredSize(new Dimension(150, 100));
		medium.setFont(new java.awt.Font("Tahoma", Font.BOLD, 24));
		medium.setBackground(buttonColor);

		JButton hard = new JButton("Hard");
		hard.setPreferredSize(new Dimension(150, 100));
		hard.setBorder(border);
		hard.setPreferredSize(new Dimension(150, 100));
		hard.setFont(new java.awt.Font("Tahoma", Font.BOLD, 24));
		hard.setBackground(buttonColor);

		// Create panel for button level selection
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBackground(backgroundColor);
		
		// Layout control to create a gap between each button
		BorderLayout layout = new BorderLayout();
		layout.setHgap(10);
		layout.setVgap(10);

		buttonsPanel.setLayout(layout);
		buttonsPanel.add(easy, BorderLayout.LINE_START);
		buttonsPanel.add(medium, BorderLayout.CENTER);
		buttonsPanel.add(hard, BorderLayout.LINE_END);

		// Add components to the frame
		frame.add(title, BorderLayout.NORTH);
		frame.add(selection, BorderLayout.SOUTH);
		frame.add(buttonsPanel, BorderLayout.CENTER);

		// Display the window
		frame.pack();
		frame.setVisible(true);
	}

	// Create and show the title screen
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createFrame();
			}
		});
	}
}
