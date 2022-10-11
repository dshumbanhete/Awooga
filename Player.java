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
        
        public String getName() {
            return name;
        }
        
        /** combo getter and setter for noPlay attribute, based on if the Player has busted */
        public boolean checkBusted() {
            if (this.hand.handValue() > 21) {
                return true;
            }
            return false;
        }
}