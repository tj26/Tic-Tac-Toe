//Class to implement Alpha Beta Search for the AI component

public class Search {
	 int value;
	 Integer[] move = new Integer[2];
	 int depth;
	 int difficulty;
	 int visited[][] = new int[4][4]; 
	 int state[][] = new int[4][4]; 
	 int maxPruning;
	 int minPruning;
	 int cuttOffOccured;
	 int numNodes=0;
	 int depth2=0;
	 //Function to set difficulty level
	 public void setDifficulty(int difficulty)
	 {	
		 this.difficulty = difficulty;		
	 }

	 //Function to set current state
	 public void setState(int s[][])
	 {
		 state = s;	
	 }

	 //Main Evaluation function
	 public int eval(int state[][])
	 {
		 int x1 = 0,x2 = 0,x3 = 0;
		 int o1 = 0,o2 = 0,o3 = 0;
		 int eval = 0;
		 int countx = 0,counto = 0;
	
		 //Number of X's in rows
		 for(int i=0;i<4;i++)
		 {	
			 countx = 0;
			 for(int j=0;j<4;j++)
			 {
				 if(state[i][j] == 2)
					 countx++;
				 if(state[i][j] == 1)
				 {
					 countx = 0;
					 break;
				 }
			 }
			 switch(countx)
			 {
			 	case 0:
			 		break;
				case 1:
					x1++;
					break;
				case 2:
					x2++;
					break;
				case 3:
					x3++;
					break;
				default:
					break;
			 }
		 }
		 
		//Number of X's in column
		for(int i=0;i<4;i++)
		{	
			countx = 0;
			for(int j=0;j<4;j++)
	    	{
				if(state[j][i] == 2)
					countx++;
				if(state[j][i] == 1)
		    	{
					countx = 0;
					break;
			    }
	    	}
			switch(countx)
			{
				case 0:
					break;
				case 1:
					x1++;
					break;
				case 2:
					x2++;
					break;
				case 3:
					x3++;
					break;
				default:
					break;
			}
		}
	
		//Number of O's in rows
		counto = 0;
		for(int i=0;i<4;i++)
		{	
			counto = 0;
			for(int j=0;j<4;j++)
	    	{
		   	 	if(state[i][j] == 1)
		   	 		counto++;
		   	 	if(state[i][j] == 2)
			    {
					counto = 0;
					break;
				}
	    	}
			switch(counto)
			{
				case 0:
					break;
				case 1:
					o1++;
					break;
				case 2:
					o2++;
					break;
				case 3:
					o3++;
					break;
				default:
					break;
			}
		}
			
		//Number of O's in columns
		counto = 0;
		for(int i=0;i<4;i++)
		{	
			counto = 0;
			for(int j=0;j<4;j++)
		    {
				if(state[j][i] == 1)
					counto++;
				if(state[j][i] == 2)
			    {
					counto = 0;
					break;
				}
		    }
			switch(counto)
			{
				case 0:
					break;
				case 1:
					o1++;
					break;
				case 2:
					o2++;
					break;
				case 3:
					o3++;
					break;
				default:
					break;
			}
		}
		
		//Number of X's in right diagonal
		countx = 0;
		for(int i=0;i< 4;i++)
		{
			if(state[i][i] == 2)
				countx++;
			if(state[i][i] == 1)
			{
				countx = 0;
				break;
			}
		}
		switch(countx)
		{
			case 0:
				break;
			case 1:
				x1++;
				break;
			case 2:
				x2++;
				break;
			case 3:
				x3++;
				break;
			default:
				break;
		}
			
		//Number of O's in right diagonal
		counto = 0;
		for(int i =0;i< 4;i++)
		{
			if(state[i][i] == 1)
				counto++;
			if(state[i][i] == 2)
			{
				counto = 0;
				break;
			}
		}
		switch(counto)
		{
			case 0:
				break;
			case 1:
				o1++;
				break;
			case 2:
				o2++;
				break;
			case 3:
				o3++;
				break;
			default:
				break;
		}
			
		//Number of X's in left diagonal
		countx = 0;
		int j = 3;
		for(int i=0;i<4;i++)
		{
			if(state[i][j] == 2)
				countx++;
			if(state[i][j] == 1)
			{
				countx = 0;					
				break;
			}	
			j--;
		}
		switch(countx)
		{
			case 0:
				break;
			case 1:
				x1++;
				break;
			case 2:
				x2++;
				break;
			case 3:
				x3++;
				break;
			default:
				break;
		}
			
		//Number of O's in left diagonal
		counto = 0;
		j = 3;
		for(int i=0;i<4;i++)
		{   
			if(state[i][j] == 1)
				counto++;
			if(state[i][j] == 2)
			{
				counto = 0;
				break;
			}
			j--;
		}
		switch(counto)
		{
			case 0:
				break;
			case 1:
				o1++;
				break;
			case 2:
				o2++;
				break;
			case 3:
				o3++;
				break;
			default:
				break;
		}
		
		if(difficulty == 1)
		{
		eval = 3*x2 + x1 - (3*o2 +o1); //for easy level
		}
		else
		{
		eval = 6*x3 + 3*x2 + x1 - (6*o3 + 3*o2 + o1);
		}
	
		return eval;
	 }

	 //Alpha Beta Search function
	 public Integer[] AlphaBetaSearch(int a[][])
	 { 
		 visited = a; 
		 value = MaxValue(visited,-1000,1000);
		 return move;
     }
	 
	 //Max-value function
	 public int MaxValue(int v[][],int alpha,int beta)
	 {
		 if(depth2 < getDepth(v))
		 {
			 depth2 = getDepth(v);
		 }
		 int move1[] = new int [2];
		 move1[0] = -1;
		 move1[1] = -1;
    	 int [][] visited  =v;
    	 int vl;
    	 if(hasMaxWon(visited))	//Max Player won
		 {
    		 return 1000;
		 }
	    	
		 if(hasMinWon(visited)) //Min Player won
		 {	
			 return -1000;
		 }
		
		 if(!hasMaxWon(visited) && !hasMinWon(visited) && draw(visited)) //Draw
    	 {
    		 return 0;
    	 }
		 
		
    	 if(cutOffTest(visited)) //Cut off occurred.
    	 {
    		 cuttOffOccured++;
    		 vl = eval(visited);
    		 return vl;
    	 }
    	 int temp;
    	
    	 vl = Integer.MIN_VALUE;
    	 temp = vl;
    	 for(int i =0;i<4;i++)
         {
    		 for(int j=0;j<4;j++)
    		 {
    			 if(visited[i][j] == 0 )
    			 {
    				 visited[i][j] = 2;	
    				 numNodes++;
    				 vl = Math.max(vl, MinValue(visited,alpha,beta));	  
    				 visited[i][j]=0;
    				 if(vl> alpha)
    				 {
    					 alpha = vl;
    				     move1[0] = i;
    				     move1[1] = j;
    				 }
    				 if(alpha >= beta)
    				 {   maxPruning++;
    					 break;  
    				 }
    			 }
    		 }
    	 }
    		    	
         if(move1[1] != -1)
         {
        	 move[0] = move1[0];
        	 move[1] = move1[1];
         }
         return alpha;   
	 } 
	 
	 //Min-value function
     public int MinValue(int v[][],int alpha,int beta)
     {
    	 if(depth2 < getDepth(v))
		 {
			 depth2 = getDepth(v);
		 }
    	 int move1[] = new int[2];
    	 move1[0] = -1;
    	 move1[1] = -1;
    		
    	 int [][] visited =v;
    	 int temp,vl;
    	 if(hasMaxWon(visited))
    	 {	 
    		 return 1000;  
		 }
		  
    	 if(hasMinWon(visited))
    	 {
    		 return -1000;
    	 }
				
		 if(!hasMaxWon(visited) && !hasMinWon(visited) && draw(visited))
		 {
			 return 0;
		 }
    	
		 
    	 if(cutOffTest(visited))
	     {
    		 cuttOffOccured++;
    		 vl = eval(visited);
    		 return vl;
	     }
    		 
    	 vl =  Integer.MAX_VALUE;
    	 temp = vl;
    	 for(int i =0;i<4;i++)
    	 {
    		 for(int j=0;j<4;j++)
    		 {
    			 if(visited[i][j] == 0 )
    			 {
    				 visited[i][j] = 1; 
    				 numNodes++;
    				 vl = Math.min(vl, MaxValue(visited,alpha,beta));
    				 visited[i][j] = 0;
    				 if(vl<beta)
    				 {
				    	 beta = vl;
				    	 move1[0] = i;
				    	 move1[1] = j;
    				 }
    				 if(alpha >= beta)
    				 {	 
    					 minPruning++;
    					 break;
    				 }
    				 }
    			 }	 
    		 
    	 }
    		    	
    	 if(move1[1]!=-1)
		 {
    		 move[0] = move1[0];
    		 move[1] = move1[1];
		 }
		 return beta;    
     }

     //Function to check if a draw occured.
     public boolean draw(int state[][])
     {
    	 int c = 0;
    	 for(int i=0;i<4;i++)
    	 {
    		 for(int j=0;j<4;j++)
    		 {
    			 if(state[i][j]!=0)
    				 c++;
    		 }
    	 }
    	 if(c == 16)
    	 {
    		 return true;
    	 }
    	 return false;
     }

     //Calculate depth of a node
     public int getDepth(int visited[][])
     {
    	int depth2 =0;
	     for(int i =0; i<4;i++)
	     {
	    	 for(int j=0;j<4;j++)
	    	 {
	    		 if(visited[i][j] != state[i][j])
	    			 depth2++;
	    	 }
	     }
	    	return depth2;
     }
     
     //Function to check for cut-off
     public boolean cutOffTest(int visited[][])
     {
    	 depth = 0;
	     for(int i =0; i<4;i++)
	     {
	    	 for(int j=0;j<4;j++)
	    	 {
	    		 if(visited[i][j] != state[i][j])
	    			 depth++;
	    	 }
	     }
	    	
	     if(depth == difficulty)
	    	 return true;
	     else
	    	 return false;
     }
	
     //Function to check if max player has won
	 boolean hasMaxWon(int s[][])
	 {   	
		 int countx = 0;
		 for(int i=0;i<4;i++)
		 {	
			 countx = 0;
			 for(int j=0;j<4;j++)
		     {
				 if(s[i][j] == 2)
					 countx++;
				 if(s[i][j] == 1)
				 {
					countx = 0;
					break;
				 }
		     }
			 if(countx == 4)
				 return true;
		 }
	     countx = 0;
	     for(int i=0;i<4;i++)
		 {	
	    	 countx = 0;
			 for(int j=0;j<4;j++)
		     {
				 if(s[j][i] == 2)
					 countx++;
				 if(s[j][i] == 1)
			     {
					countx = 0;
					break;
				 }
		     }
			 if(countx == 4)
				 return true;
		 }
	    	
	     countx = 0;
		 for(int i=0;i< 4;i++)
		 {
			 if(s[i][i] == 2)
				 countx++;
			 if(s[i][i] == 1)
			 {
				 countx = 0;
				 break;
			 }
		 }
		 if(countx == 4)
			 return true;
		
		 countx = 0;
		 int j = 3;
		 for(int i=0;i<4;i++)
		 {
			 if(s[i][j] == 2)
				 countx++;
			 if(s[i][j] == 1)
			 {
				 countx=0;
				 break;
			 }
			 j--;
		 }
			
		 if(countx == 4)
			 return true;
		 return false;    			
	 }
	    
	 //Function to check if min player has won
	 boolean hasMinWon(int s[][])
	 {   
		 int counto = 0;
	     for(int i=0;i<4;i++)
		 	{	
	    	 	counto = 0;
	    	 	for(int j=0;j<4;j++)
		    	{
	    	 		if(s[i][j] == 1)
	    	 			counto++;
	    	 		if(s[i][j] == 2)
			    	{
	    	 			counto = 0;
	    	 			break;
				    }
		    	}
	    	 	if(counto == 4)
	    	 		return true;
			}
	     
	    	counto = 0;
	    
	    	for(int i=0;i<4;i++)
			{	
	    		counto = 0;
	    		for(int j=0;j<4;j++)
		    	{
			   	 	if(s[j][i] == 1)
			   	 		counto++;
			   	 	if(s[j][i] == 2)
			   	 	{
			   	 		counto = 0;
			   	 		break;
				    }
		    	}
	    		if(counto == 4)
	    			return true;
			}
	    	
	    	counto = 0;
			
	    	for(int i=0;i< 4;i++)
			{
				if(s[i][i] == 1)
					counto++;
				if(s[i][i] == 2)
				{
					counto = 0;
					break;
				}
			}
			if(counto == 4)
				return true;
			
			counto = 0;
			
			int j = 3;
			for(int i=0;i<4;i++)
			{
				if(s[i][j] == 1)
					counto++;
				if(s[i][j] == 2)
				{
					counto = 0;
					break;
				}
				j--;
			}
			if(counto == 4)
				return true;		    	
			return false;    			
	 }
	 //Print statistics of the game.
	 void printStatistics()
	 {
		 System.out.println("====================================================");
		 System.out.println("Number of times cut-off occured                : " + cuttOffOccured);
		 System.out.println("Maximum depth of game tree reached             : " + depth2);
		 System.out.println("Total number of nodes generated                : " + (numNodes+1));
		 System.out.println("Number of times pruning occured in MAX function: " + maxPruning);
		 System.out.println("Number of times pruning occured in MIN function: " + minPruning);
		 System.out.println("====================================================");
		 System.out.println();
	 }
	 //Second evaluation function
	 public int eval2(int state[][])
	 {
		 int x1 = 0,x2 = 0,x3 = 0,x0=0;
		 int o1 = 0,o2 = 0,o3 = 0,o0=0;
		 int eval = 0;
		 int countx = 0,counto = 0;
	
		 //Number of X's in rows
		 for(int i=0;i<4;i++)
		 {	
			 countx = 0;
			 for(int j=0;j<4;j++)
			 {
				 if(state[i][j] == 2)
					 countx++;
				 if(state[i][j] == 1)
				 {
					 countx = 0;
					 break;
				 }
			 }
			 switch(countx)
			 {
			 	case 0:
			 		break;
				case 1:
					x1++;
					break;
				case 2:
					x2++;
					break;
				case 3:
					x3++;
					break;
				default:
					break;
			 }
		 }
		 
		//Number of X's in column
		for(int i=0;i<4;i++)
		{	
			countx = 0;
			for(int j=0;j<4;j++)
	    	{
				if(state[j][i] == 2)
					countx++;
				if(state[j][i] == 1)
		    	{
					countx = 0;
					break;
			    }
	    	}
			switch(countx)
			{
				case 0:
					break;
				case 1:
					x1++;
					break;
				case 2:
					x2++;
					break;
				case 3:
					x3++;
					break;
				default:
					break;
			}
		}
	
		//Number of O's in rows
		counto = 0;
		for(int i=0;i<4;i++)
		{	
			counto = 0;
			for(int j=0;j<4;j++)
	    	{
		   	 	if(state[i][j] == 1)
		   	 		counto++;
		   	 	if(state[i][j] == 2)
			    {
					counto = 0;
					break;
				}
	    	}
			switch(counto)
			{
				case 0:
					break;
				case 1:
					o1++;
					break;
				case 2:
					o2++;
					break;
				case 3:
					o3++;
					break;
				default:
					break;
			}
		}
			
		//Number of O's in columns
		counto = 0;
		for(int i=0;i<4;i++)
		{	
			counto = 0;
			for(int j=0;j<4;j++)
		    {
				if(state[j][i] == 1)
					counto++;
				if(state[j][i] == 2)
			    {
					counto = 0;
					break;
				}
		    }
			switch(counto)
			{
				case 0:
					break;
				case 1:
					o1++;
					break;
				case 2:
					o2++;
					break;
				case 3:
					o3++;
					break;
				default:
					break;
			}
		}
		
		//Number of X's in right diagonal
		countx = 0;
		for(int i=0;i< 4;i++)
		{
			if(state[i][i] == 2)
				countx++;
			if(state[i][i] == 1)
			{
				countx = 0;
				break;
			}
		}
		switch(countx)
		{
			case 0:
				break;
			case 1:
				x1++;
				break;
			case 2:
				x2++;
				break;
			case 3:
				x3++;
				break;
			default:
				break;
		}
			
		//Number of O's in right diagonal
		counto = 0;
		for(int i =0;i< 4;i++)
		{
			if(state[i][i] == 1)
				counto++;
			if(state[i][i] == 2)
			{
				counto = 0;
				break;
			}
		}
		switch(counto)
		{
			case 0:
				break;
			case 1:
				o1++;
				break;
			case 2:
				o2++;
				break;
			case 3:
				o3++;
				break;
			default:
				break;
		}
			
		//Number of X's in left diagonal
		countx = 0;
		int j = 3;
		for(int i=0;i<4;i++)
		{
			if(state[i][j] == 2)
				countx++;
			if(state[i][j] == 1)
			{
				countx = 0;					
				break;
			}	
			j--;
		}
		switch(countx)
		{
			case 0:
				break;
			case 1:
				x1++;
				break;
			case 2:
				x2++;
				break;
			case 3:
				x3++;
				break;
			default:
				break;
		}
			
		//Number of O's in left diagonal
		counto = 0;
		j = 3;
		for(int i=0;i<4;i++)
		{   
			if(state[i][j] == 1)
				counto++;
			if(state[i][j] == 2)
			{
				counto = 0;
				break;
			}
			j--;
		}
		switch(counto)
		{
			case 0:
				break;
			case 1:
				o1++;
				break;
			case 2:
				o2++;
				break;
			case 3:
				o3++;
				break;
			default:
				break;
		}
		//count empty rows
		int row=0;
		for(int i= 0;i<4;i++)
		{	row=0;
			for(j=0;j<4;j++)
			{
				if(state[i][j] ==0)
				{
					row++;
				}
				
			}
			if(row == 4)
			{
				x0++;
				o0++;
			}
		}
		//count empty columns
		int column =0;
		for(int i=0;i<4;i++)
		{	column =0;
			for(j=0;j<4;j++)
			{
				if(state[j][i] ==0)
				{
					column++;
				}
			}
			if(column ==4)
			{
				x0++;
				o0++;
			}
		}
		
		//check empty right diagonal
		int rdiag = 0;
		for(int i =0;i< 4;i++)
		{
			if(state[i][i] == 0)
				rdiag++;
			}
			if(rdiag ==4)
			{
				x0++;
				o0++;
			}
		
		//check empty left diagonal
			 j = 3;
			 int ldiag=0;
			for(int i=0;i<4;i++)
			{
				if(state[i][j] == 0)
					ldiag++;
				
				j--;
			}
			if(ldiag ==4)
			{
				o0++;
				x0++;
			}
			
			if(difficulty == 1)
			{
			eval = 3*x2 + x1 - (3*o2 +o1); //easy level
			}
			else
			{
			eval = 16*x3+8*x2+4*x1+ 2*x0 -(16*o3+8*o2+4*o1);
			}	
		return eval;
	 }
	 
}