public class Game {
	private Deck deck;
	private Dealer dealer;
	public final int PLAYER_COUNT; //unused as of now, will be important with GUI.
	private Player[] players;
	
	
	public Game(int numDecks, Player[] players) {
		deck = new Deck(numDecks);
		deck.shuffle();
		dealer = new Dealer();
		PLAYER_COUNT = players.length;
		this.players = players;
	}
	
	public void firstDeal() { //test public
		deck.dealCard(dealer.getHand()); //dealer's first card
		for (int i = 0; i < PLAYER_COUNT; i++) {
			deck.dealCard(players[i].getHand()); //each player gets 2 cards
			deck.dealCard(players[i].getHand());
		}
		deck.dealCard(dealer.getHand()); //dealer's second card
	}
	
	public String playersToString() {
		String out = dealer.toString();
		for (int i = 0; i < this.PLAYER_COUNT; i++) {
			out += "\n" + this.players[i] ;
			out += "\t= " + this.players[i].getHand().handValue();
		}
		return out;
	}
        
        /** accessor method for Players */
        public Player getPlayer(int idx) {
            if (idx < players.length) {
                return players[idx];
            }
            return null;
        }
        
        /** accessor for dealer attribute */
        public Dealer getDealer() {
            return this.dealer;
        }
	
	/** accessor method for deck attribute */
	public Deck getDeck() {
		return this.deck;
	}
}