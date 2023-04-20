import java.util.LinkedList;

public class Deck {
	private LinkedList<Card> deck = new LinkedList<>();
	
	public void playTop(player player) {
		Card topCard = deck.removeFirst();
		add(topCard);
		topCard.play(player);
	}

	public void add(Card card) {
		deck.addLast(card);
	}
	
	
}
