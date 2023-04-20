
public abstract class Card {
	
	String text;
	
	public Card(String text) {
		this.text = text;
	}
	
	public abstract void doAction(player player);
	
	public void play(player player) {
		doAction(player);
	}

}

class CollectCard extends Card{
	public Integer amount;
	
	public CollectCard(int amount, String text){
        super(createCollectMessage(amount, text));
        this.amount = amount;}
	
	
	protected static String createCollectMessage(int amount, String text){
        String collectMessage = text + ". Collect $" + amount;
        String payMessage = text + ". Pay $" + -amount;
        return (amount > 0) ? collectMessage : payMessage;
    }
	
	
	public void doAction(player player) {
		player.addMoney(player, amount);
	}
        

	
     
	
	}
	
	
	
