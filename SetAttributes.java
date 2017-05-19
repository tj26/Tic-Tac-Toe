//Class to initialize game: Difficulty Level (Easy / Medium / Hard), Player (X / O)

import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.*;

public class SetAttributes {
	static int di;
	static int pl;
	public static void display() {
        String[] difficulty = {"Easy", "Medium", "Hard"};
        String[] turn = {"Player 1", "Player 2"};
        JComboBox combo1 = new JComboBox(difficulty);
        JComboBox combo2 = new JComboBox(turn);
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Select Difficulty Level:"));
        panel.add(combo1);
        panel.add(new JLabel("Choose Your Turn:"));
        panel.add(combo2);
        int result = JOptionPane.showConfirmDialog(null, panel, "Tic Tac Toe : New Game",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
        	SoundEffects s = new SoundEffects();
	    	s.SoundEffects(4);
            if(combo1.getSelectedItem().equals("Easy"))
            	di = 1;
            else if(combo1.getSelectedItem().equals("Medium"))
            	di = 4;
            else
            	di = 6;  
            if(combo2.getSelectedItem().equals("Player 1"))
            	pl = 1;
            else
            	pl = 2; 
        } else {
            System.out.println("Cancelled");
            System.exit(0);
        }
    }
	public static int retDifficulty(){
		return di;
	}
	public static int retTurn(){
		return pl;
	}
	public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                display();
            }
        });
    }
}