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
	String popped;
	int num;
	boolean permWin = false;

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
		num = Integer.parseInt(JOptionPane.showInputDialog("How many words would you like to guess?"));
		for (int i = 0; i < num; i++) {
			String word = a.readRandomLineFromFile("src/_04_HangMan/dictionary.txt");
			w = word;
			if (stack.contains(word)) {
				i = i - 1;
			} else {

				stack.push(word);
				System.out.println(word);
			}
		}
		popped = stack.pop();
		int length = popped.length();
		label.setText("_");
		for (int i = 0; i < length - 1; i++) {
			label.setText(label.getText() + "_");
			frame.pack();
		}

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
		String done = label.getText();
		if (popped.contains(s)) {
			for (int i = 0; i < popped.length(); i++) {
				if (user == popped.charAt(i)) {
					prev = label.getText();
					part1 = prev.substring(0, i);
					if (i + 1 == popped.length()) {
						part2 = "";
					} 
					
					else {
						System.out.println(i);
						part2 = prev.substring(i + 1, popped.length());
					}
					label.setText(part1 + s + part2);
					done = label.getText();
					System.out.println(popped);
				}
			}
		}

		else {
			lives = lives - 1;
		}

		if (done.contains("_")) {
			tempWin = false;
		}

		else {
			tempWin = true;
		}

		if (tempWin == true) {
			num--;
			if (num == 0) {
				permWin = true;
				JOptionPane.showMessageDialog(null, "You Won!!!!!!");
				int result = JOptionPane.showConfirmDialog(null, "Do you want to play again?", null,
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					reset();
				} else {
					System.exit(0);
				}
			}
		}

		if (tempWin == true && stack.isEmpty() == false) {
			System.out.println("reached");
			label.setText("");
			System.out.println("Reached here");
			popped = stack.pop();
			int length = popped.length();
			label.setText("_");
			for (int i = 0; i < length - 1; i++) {
				label.setText(label.getText() + "_");
				frame.pack();
				System.out.println("Frame packed");
			}

			lives = 9;
		}

		if (lives == 0) {
			JOptionPane.showMessageDialog(null, "You Lost!!!");
			int result = JOptionPane.showConfirmDialog(null, "Do you want to play again?", null,
					JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				reset();
			} else {
				System.exit(0);
			}

		}

	}

	public void reset() {
		label.setText("");
		num = Integer.parseInt(JOptionPane.showInputDialog("How many words would you like to guess?"));
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
			lives = 9;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
