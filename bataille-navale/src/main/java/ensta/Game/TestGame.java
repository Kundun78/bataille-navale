package ensta;

import java.util.*;
import java.lang.*;

class TestGame{
    
    public static void main( String[] args )
    {
        Board board = new Board("board");
        board.print();
        AbstractShip[] ships = new AbstractShip[5];
        ships[0] = new Destroyer();
        ships[1] = new Submarine();
        ships[2] = new Submarine();
        ships[3] = new Battleship();
        ships[4] = new Carrier();
        BattleShipsAI ai = new BattleShipsAI(board, board);
        ai.putShips(ships);
        int sunkCount;
        int[] coords = new int[2];
        Hit hit;
        do{
            hit = ai.sendHit(coords);
            System.out.print("Frappe en ");
            System.out.print((char)((int)'A' + coords[0]));
            System.out.print(coords[1]+1);
            System.out.print(" : ");
            if((hit != Hit.MISS) && (hit != Hit.STRUCK)) System.out.println(hit.toString() + " coulé.");
            else System.out.println(hit.toString());
            board.print();
            sunkCount = 0;
            for (AbstractShip s : ships){
                if(s.isSunk()) sunkCount++;
            }
            try{
                Thread.sleep(1000);
            } catch (Exception e){
                System.out.println(e);
            }
        } while(sunkCount < 5);
    }
}