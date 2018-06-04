package lab11.graphs;

/**
 *  @author Josh Hug
 */
public class MazeCycles extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private int s;
    private int t;
    private boolean targetFound = false;
    private Maze maze;

    public MazeCycles(Maze m) {
        super(m);
        maze = m;
        s = maze.xyTo1D(0,0);
        distTo[s] = 0;
        edgeTo[s] = s;
    }

    @Override
    public void solve() {
        // TODO: Your code here!

    }

    // Helper methods go here
}

