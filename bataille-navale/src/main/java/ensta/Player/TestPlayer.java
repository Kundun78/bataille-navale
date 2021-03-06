package ensta;

import java.util.*;

class TestPlayer{
    
    public static void main( String[] args )
    {
        Board myBoard = new Board("myBoard", 10);
        List<AbstractShip> ships = new ArrayList<AbstractShip>();
        ships.add(new Destroyer());
        ships.add(new Submarine());
        ships.add(new Submarine());
        ships.add(new Battleship());
        ships.add(new Carrier());
        Player myPlayer = new Player(myBoard, myBoard, ships);
        myPlayer.putShips();
        int coords[] = new int[2];
        myPlayer.sendHit(coords);
        myBoard.print();
    }
}