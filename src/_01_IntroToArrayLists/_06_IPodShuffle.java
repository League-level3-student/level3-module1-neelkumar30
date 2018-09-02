package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements ActionListener{
	Song current;
	Song prev;
	JFrame frame;
	JPanel panel;
	JButton button1;
	JButton button2;
	ArrayList <Song> songs = new ArrayList <Song>();
	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.
				Song song1 = new Song("Something Just Like This.mp3");
				Song song2 = new Song("demo.mp3");
				Song song3 =  new Song ("Whatever it Takes.mp3");
				songs.add(song1);
				songs.add(song2);
				songs.add(song3);
				
		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */
		
	}
	
	void makeStuff() {
		frame = new JFrame();
		panel = new JPanel();
		button1 = new JButton();
		frame.add(panel);
		panel.add(button1);
		frame.setVisible(true);
		button1.setText("Surprise me");
		button1.addActionListener(this);
		frame.pack();
		
	}
	public static void main(String[] args) {
		_06_IPodShuffle iPod = new _06_IPodShuffle();
		iPod.makeStuff();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Random r = new Random();
		int ran = r.nextInt(3);
		if(e.getSource() == button1) {
			if(current == null) {
				current = songs.get(ran);
				current.play();
			}
			else {
				current.stop();
				current = songs.get(ran);
				current.play();
			}
		
			System.out.println(ran);
		}
	}
	
}