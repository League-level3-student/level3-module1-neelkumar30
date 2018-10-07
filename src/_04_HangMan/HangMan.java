package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener {
	Utilities a = new Utilities();
	Stack<String> stack = new Stack<String>();
	JLabel label = new JLabel();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	String w;
	int lives = 10;
	boolean tempWin = false;
	boolean officialWin;
	String popped;

	public static void main(String[] args) {
		HangMan run = new HangMan();
		run.MakeStuff();
	}

	void MakeStuff() {
		frame.add(panel);
		panel.add(label);
		frame.setVisible(true);
		frame.addKeyListener(this);
		frame.pack();
		int num = Integer.parseInt(JOptionPane.showInputDialog("How many words would you like to guess?"));
		for (int i = 0; i < num; i++) {
			String word = a.readRandomLineFromFile("src/_04_HangMan/dictionary.txt");
			w = word;
			if (stack.contains(word)) {
				i = i - 1;
			} else {

				stack.push(word);
			}
		}
		popped = stack.pop();
		int length = popped.length();
		label.setText("_");
		for (int i = 0; i < length - 1; i++) {
			label.setText(label.getText() + "_");
			frame.pack();
		}

		// if(lives == 0) {
		// JOptionPane
		// }

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		char user = e.getKeyChar();
		String s = "";
		s += user;
		String prev = "";
		String part1;
		String part2;
		String done = "";
		if (w.contains(s)) {
			int index = w.indexOf(user);
			for (int i = 0; i < w.length(); i++) {
				if (user == w.charAt(i)) {
					prev = label.getText();
					part1 = prev.substring(0, i - 1);
					part2 = prev.substring(i + 1, w.length() - 1);
					label.setText(part1 + w + part2);
					done = label.getText();
				}
			}
		}
				
		else {
			lives = lives - 1;
		}
		
		if(done.contains("_")){
			tempWin = false;
		}
		
		else {
			tempWin = true;
		}
		
		if(tempWin == true) {
			popped = stack.pop();
			int length = popped.length();
			label.setText("_");
			for (int i = 0; i < length - 1; i++) {
				label.setText(label.getText() + "_");
				frame.pack();
				tempWin = false;
			}
		}
		if(lives == 0) {
			JOptionPane.showMessageDialog(null, "You Lost!!!");
			int result = JOptionPane.showConfirmDialog(null, 
					   "Do you want to play again?",null, JOptionPane.YES_NO_OPTION);
					if(result == JOptionPane.YES_OPTION) {
					    reset();
					} 
					else {
						System.exit(0);
					}

		}
		
		if(tempWin == true && stack.isEmpty()) {
			JOptionPane.showMessageDialog(null, "You Won!!!!!!");
			int result = JOptionPane.showConfirmDialog(null, 
					   "Do you want to play again?",null, JOptionPane.YES_NO_OPTION);
					if(result == JOptionPane.YES_OPTION) {
					    reset();
					} 
					else {
						System.exit(0);
					}

		}
		
	}

	public void reset() {
		System.exit(0);
		HangMan run = new HangMan();
		run.MakeStuff();
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
