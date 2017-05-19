//Class to play against a human opponent

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HumanPlayer extends JFrame {
	JButton [][] buttons = new JButton[4][4];
	JTextField statusBar;
	GamePanel panel;
	Integer turn, count;
	GameListener listener = new GameListener();
	
	//Constructor
	public HumanPlayer()
	{	
		setLayout(new BorderLayout());
		
		panel = new GamePanel();
		add(panel,BorderLayout.CENTER);

		statusBar = new JTextField("Player 1's Turn");
		statusBar.setEditable(false);
		add(statusBar,BorderLayout.SOUTH);

		setTitle("Tic Tac Toe!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		setLocationRelativeTo(null);  
		setVisible(true);
	 }
	
	class GamePanel extends JPanel
	{
		public GamePanel()
		{
			setLayout(new GridLayout(4,4));
			turn = 1;
			count = 0;
			for(int i=0;i<4;i++)
			{
				for(int j=0;j<4;j++)   
				{
					buttons[i][j]=new JButton();
					buttons[i][j].putClientProperty("INDEX", new Integer[]{i,j});
				    buttons[i][j].putClientProperty("OWNER", 0);
				    buttons[i][j].addActionListener(listener);
				    add(buttons[i][j]);
				}
			}
		}
	}
	
	//Class to handle player moves
	class GameListener implements ActionListener
	{
		//Function to handle action performed
	    public void actionPerformed(ActionEvent e)
	    {
	    	count++;
		    JButton b=(JButton)e.getSource();
		    Integer[]index=(Integer[]) b.getClientProperty("INDEX");
		    b.putClientProperty("OWNER", turn);
		    Icon ico=new ImageIcon(turn.toString()+".png");
		    b.setIcon(ico);
		    b.setDisabledIcon(ico);
		    b.setEnabled(false);
		    b.setForeground(Color.WHITE);
		    b.setBackground(Color.WHITE);
		    boolean result=checkWinCondition(index);
		    if(result)
		    {
		    	SoundEffects s = new SoundEffects();
		    	s.SoundEffects(1);
		    	JOptionPane.showMessageDialog(null, "Player "+turn.toString()+" Wins!!");
		    	System.exit(3);
		    }
		    else
		    {
		    	if(turn==1)
		    	{
		    		SoundEffects s = new SoundEffects();
			    	s.SoundEffects(4);
		    		turn=2;
		    		statusBar.setText("Player 2's Turn");
		    	}
		    	else
			    {
		    	   SoundEffects s = new SoundEffects();
			       s.SoundEffects(4);
			       turn=1;
			       statusBar.setText("Player 1's Turn");
			    }
		     }
		     if(count==16)
		     {
		    	 SoundEffects s = new SoundEffects();
		    	 s.SoundEffects(3);
		    	 JOptionPane.showMessageDialog(null, "Match is a Draw!");
		    	 System.exit(3);
		     }
	    }
	    
	    //Function to get owner of a cell
	    Integer getOwner(JButton b)
	    {
	    	return (Integer)b.getClientProperty("OWNER");
	    }
	    
	    //Function to check win condition
	    boolean checkWinCondition(Integer [] index)
	    {
	    	Integer a=index[0];
	    	Integer b=index[1];
	    	int i;

	    	//Check row
	    	for(i=0;i<4;i++)  
	    	{
	    		if(getOwner(buttons[a][i])!=getOwner(buttons[a][b]))
	    			break;
	    	}
	    	if(i==4)
	    		return true;

		    //Check column
		    for(i=0;i<4;i++)  
		    {
		    	if(getOwner(buttons[i][b])!=getOwner(buttons[a][b]))
		    		break;
		    }
		    if(i==4)
		    	return true;

		    //Check diagonal
		    if((a==3&&b==3)||(a==0&&b==0)||(a==1&&b==1)||(a==0&&b==3)||(a==3&&b==0))
		    {
		    	//Check left diagonal
		    	for(i=0;i<4;i++)
		    		if(getOwner(buttons[i][i])!=getOwner(buttons[a][b]))
		    			break;
		    	if(i==4)
		    		return true;

		    	//Check right diagonal
		    	if((getOwner(buttons[0][3])==getOwner(buttons[a][b]))&&(getOwner(buttons[1][2])==getOwner(buttons[a][b]))&&(getOwner(buttons[3][0])==getOwner(buttons[a][b]))&&(getOwner(buttons[2][1])==getOwner(buttons[a][b])))
		    		return true;
		    }
		    return false;
	    }
	}
}