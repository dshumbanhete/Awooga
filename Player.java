public class Player {
	private String name;
	private Hand hand;
	
	public Player(String name) {
		this.name = name;
		this.hand = new Hand(name + "'s hand");
	}
	
	public Hand getHand() {
		return this.hand;
	}
}