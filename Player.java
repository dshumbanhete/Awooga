public class Player {
	private String name;
	private Hand hand;
        private boolean isBust;
	
	public Player(String name) {
            this.name = name;
            this.hand = new Hand(name + "'s hand");
            this.isBust = false;
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
        
        /** accessor for isBust attribute */
        public boolean isBust() {
            return isBust;
        }
        
        /** combo getter and setter for isBust attribute */
        public boolean checkBust() {
            if (this.hand.handValue() > 21) {
                this.isBust = true;
            }
            return this.isBust;
        }
}