public class LabSolver {
	private static boolean firstTime = true;
	private static boolean[][] wasHere;
	
    public static void main(String[] args) {
        int width = 20;
        int height = 10;
        if (args.length > 1) {
            width = Integer.parseInt(args[0]);
            height = Integer.parseInt(args[1]);
        }
        Labyrinth l = new Lab(width,height);
        System.out.println("\nCreated a random labyrinth:");
        System.out.println(l);
        boolean success = findPath(0,0,width-1,height-1,l);
        if (success) {
            System.out.println("Solution found:");
            System.out.println(l);
        } else {
            System.out.println("Failed to find a solution. (Bug in LabSolver.java)");
        }
    }

    public static boolean findPath(int x0, int y0, int x1, int y1, Labyrinth l) {
        //System.out.println(l);
    	if (firstTime){
        	wasHere = new boolean[x1+1][y1+1];
        	for (int i = 0; i < x1+1; i++){
        		for (int j = 0; j < y1+1; j++){
        			wasHere[i][j] = false;
        		}
        	}
        	firstTime = false;
        }
		l.setMark(x0, y0, true);
        if ((x0 == x1) && (y0 == y1)) {
        	firstTime = true;
            return true;
        }
        else{
        	wasHere[x0][y0] = true;
        	if (l.canMove(Labyrinth.Direction.RIGHT, x0, y0) && !(wasHere[x0+1][y0])){
        		return findPath(x0+1,y0,x1,y1,l);
        	}
        	if (l.canMove(Labyrinth.Direction.DOWN, x0, y0) && !(wasHere[x0][y0+1])){
        		return findPath(x0,y0+1,x1,y1,l);
        	}
        	if (l.canMove(Labyrinth.Direction.UP, x0, y0) && !(wasHere[x0][y0-1])){
        		return findPath(x0,y0-1,x1,y1,l);
        	}
        	if (l.canMove(Labyrinth.Direction.LEFT, x0, y0) && !(wasHere[x0-1][y0])){
        		return findPath(x0-1,y0,x1,y1,l);
        	}
        	
        	l.setMark(x0, y0, false);
        	
        	if (l.canMove(Labyrinth.Direction.RIGHT, x0, y0) && (wasHere[x0+1][y0]) && l.getMark(x0+1, y0)){
        		return findPath((x0 + 1),y0,x1,y1,l);
        	}
        	if (l.canMove(Labyrinth.Direction.DOWN, x0, y0) && (wasHere[x0][y0+1]) && l.getMark(x0, y0+1)){
        		return findPath(x0,y0+1,x1,y1,l);
        	}
        	if (l.canMove(Labyrinth.Direction.UP, x0, y0) && (wasHere[x0][y0-1]) && l.getMark(x0, y0-1)){
        		return findPath(x0,y0-1,x1,y1,l);
        	}
        	if (l.canMove(Labyrinth.Direction.LEFT, x0, y0) && (wasHere[x0-1][y0]) && l.getMark(x0-1, y0)){
        		return findPath(x0-1,y0,x1,y1,l);
        	}
        	return false;
        	
        }
    }
    
    
}

