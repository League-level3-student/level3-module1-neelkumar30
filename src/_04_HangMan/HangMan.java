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
			if(stack.contains(word)) {
				i = i-1;
			}
			else {
				
				stack.push(word);
			}
		}
		String popped = stack.pop();
		int length = popped.length();
		label.setText("_");	
		for (int i = 0; i < length-1; i++) {
			label.setText(label.getText() + "_");
			frame.pack();
		}
		
//		if(lives == 0) {
//			JOptionPane
//		}
		
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
		if(w.contains(s)) {
			int index = w.indexOf(user);
			label.add(user, index);
			label.remove(index + 1);
		}
		
		else {
			lives = lives -1;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
