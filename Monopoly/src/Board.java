/*import java.util.ArrayList;

public class Board {
	
	PropertyJsonReader property = new PropertyJsonReader();
	
	public Square[] board = new Square[40];
	public Deck communityChest = new Deck();
	public Deck chance = new Deck();
	public Jail jail;
	public ArrayList<player> players;
	
	public Board(Jail jail, ArrayList<player> players){
        this.jail = jail;
        this.players = players;
	
	
	 
	 
	 for(int c = 0; c < 16; c++){
         communityChest.add(createCommunityChestCard(c));
         chance.add(createChanceCard(c));}
	}
	
	public Square getSquareAt(int position){
        return board[position];
    }
	
	public Square getCurrentSquare(player player){
        return getSquareAt(player.getPosition());
    }
	
	private Square createSquare(int position) {
		switch (position) {		
		case 1: 
			return new Square("GO");
		case 2:
		
			

		default: return null;
		}
			
			
		
			
			
		}
		
	
}*/
