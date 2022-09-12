public class Card {
	//Instance variables, they are final as Cards are immutable
	private final int rank; //stores the rank of specific Card Object
	private final int suit; //stores the suit of specific Card Object
	
	//Class variables
	public static final String[] RANKS = { //stores all possible names for each rank of Card.
			null, "Ace", "2", "3", "4", "5", "6", "7",
			"8", "9", "10", "Jack", "Queen", "King"};
	public static final String[] SUITS = { //stores all possible suits for Cards
			"Clubs", "Diamonds", "Hearts", "Spades"};

	/**Constructor for the Card class. */
	public Card(int rank, int suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	/** toString() method for Card, returns in format "Rank of Suit". */
	public String toString() { 
		return RANKS[this.rank] + " of " + SUITS[this.suit];
	} 
	
	/** getValue() returns the Blackjack card value (int). Returns 11 for Ace, as other Ace value (1) is handled in context of the game. */
	public int getValue() {
		if (this.rank >= 10) {
			return 10;
		}
		if (this.rank == 1) {
			return 11;
		}
		return this.rank;
	} 
}