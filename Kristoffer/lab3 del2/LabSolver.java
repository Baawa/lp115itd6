public class LabSolver {
	
	static boolean[][] hasBeen = new boolean [1][1];
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
    	//is this labyrinth a new labyrinth? if yes, then make a new matrix and set width and height as labyrinth
    	if(!l.getMark(0, 0))hasBeen = new boolean[l.getWidth()][l.getHeight()];
    	l.setMark(x0, y0, true);
    	//checks if we're on the end coordinates?
    	if((x0 == x1) && (y0 == y1)) {
    		return true;
        }
    	//is it possible to move in any new direction? if yes, then move
        if(l.canMove(Labyrinth.Direction.RIGHT, x0, y0) && !l.getMark(x0+1, y0) && !hasBeen[x0+1][y0]){
        	return findPath(x0+1, y0, x1, y1, l);
    	}if(l.canMove(Labyrinth.Direction.DOWN, x0, y0) && !l.getMark(x0, y0+1)&& !hasBeen[x0][y0+1]){;
    		return findPath(x0, y0+1, x1, y1, l);
    	}if(l.canMove(Labyrinth.Direction.UP, x0, y0) && !l.getMark(x0, y0-1)&& !hasBeen[x0][y0-1]){
    		return findPath(x0, y0-1, x1, y1, l);
    	}if(l.canMove(Labyrinth.Direction.LEFT, x0, y0) && !l.getMark(x0-1,y0)&& !hasBeen[x0-1][y0]){
    		return findPath(x0-1, y0, x1, y1, l);
    	}
    	//else go back one step and set hasBeen true for this coordinates
    	l.setMark(x0,y0,false);
    	hasBeen[x0][y0]=true;
    	if(l.getMark(x0+1, y0) && l.canMove(Labyrinth.Direction.RIGHT, x0, y0)){
    		return findPath(x0+1, y0, x1, y1, l);
        }if(l.getMark(x0, y0+1) && l.canMove(Labyrinth.Direction.DOWN, x0, y0)){
        	return findPath(x0, y0+1, x1, y1, l);
       	}if(l.getMark(x0, y0-1) && l.canMove(Labyrinth.Direction.UP, x0, y0)){
       		return findPath(x0, y0-1, x1, y1, l);
       	}if(l.getMark(x0-1,y0) && l.canMove(Labyrinth.Direction.LEFT, x0, y0)){
       		return findPath(x0-1, y0, x1, y1, l);
       	}
        return false;
    }
}
