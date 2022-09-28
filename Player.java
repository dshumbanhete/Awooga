public class Player {
	private String name;
	private Hand hand;
	
	public Player(String name) {
		this.name = name;
		this.hand = new Hand(name + "'s hand");
	}
	
	public String toString() {
		return this.name + ":\n\n - " + this.hand.toString();
	}
	
	public Hand getHand() {
		return this.hand;
	}
}