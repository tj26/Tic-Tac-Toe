//Class to select opponent: Computer / Human

import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.*;

public class SelectPlayer {
	static int pl;
	public static void display() {
        String[] player = {"Computer", "Human"};
        JComboBox combo1 = new JComboBox(player);
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Select Opponent:"));
        panel.add(combo1);
        int result = JOptionPane.showConfirmDialog(null, panel, "Tic Tac Toe : New Game",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
        	SoundEffects s = new SoundEffects();
	    	s.SoundEffects(4);
            if(combo1.getSelectedItem().equals("Computer"))
            	pl = 1;
            else
            	pl = 2;
            
        } else {
            System.out.println("Cancelled");
            System.exit(0);
        }
    }
	public static int retPlayer(){
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