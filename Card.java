public class Card {
	//Instance variables, they are final as Cards are immutable
	private final int RANK; //stores the rank of specific Card Object
	private final int SUIT; //stores the suit of specific Card Object
	
	//Class variables
	private static final String[] RANKS = { //stores all possible names for each rank of Card.
			null, "Ace", "2", "3", "4", "5", "6", "7",
			"8", "9", "10", "Jack", "Queen", "King"};
	private static final String[] SUITS = { //stores all possible suits for Cards
			"Clubs", "Diamonds", "Hearts", "Spades"};

	/**Constructor for the Card class. */
	public Card(int rank, int suit) {
		this.RANK = rank;
		this.SUIT = suit;
	}
	
	/** toString() method for Card, returns in format "Rank of Suit". */
	public String toString() { 
		return RANKS[this.RANK] + " of " + SUITS[this.SUIT];
	} 
	
	/** getValue() returns the Blackjack card value (int). Returns 11 for Ace, as other Ace value (1) is handled in context of the game. */
	public int getValue() {
		if (this.RANK >= 10) {
			return 10;
		}
		if (this.RANK == 1) {
			return 11;
		}
		return this.RANK;
	} 
}