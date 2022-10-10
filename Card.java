public class Card {
	//Instance variables, they are final as Cards are immutable
	private final int RANK; //stores the rank of specific Card Object
	private final int SUIT; //stores the suit of specific Card Object
	
	//Class variables
	private static final String[] RANKS = { //stores all possible names for each rank of Card.
			null, "Ace", "2", "3", "4", "5", "6", "7",
			"8", "9", "10", "Jack", "Queen", "King"};
	private static final String[] SUITS = { //stores all possible suits for Cards
			"Spades", "Hearts", "Diamonds", "Clubs"};

	/** Constructor for the Card class. */
	public Card(int rank, int suit) {
		this.RANK = rank;
		this.SUIT = suit;
	}
        
        /** getter for RANK attribute */
        public int getRank() {
            return this.RANK;
        }
        
        /** getter for SUIT attribute */
        public int getSuit() {
            return this.SUIT;
        }
	
	/** toString() method for Card, returns in format "Rank of Suit". */
	public String toString() { 
            return RANKS[this.RANK] + " of " + SUITS[this.SUIT];
	} 
        
        /** returns the UNICODE form of the current card. */
        public String toUnicodeString() {
            int fixedRank = RANK;
            if (fixedRank > 11) { //This is because the UNICODE card characters have an extra card between Jack and Queen, for some reason.
                fixedRank++;
            }
            return "\uD83C" + (char)(Integer.parseInt(("DC" + //unicode formatting for cards and conversion of card hexes (below) to decimal via Integer.parseInt
					//Hex values for each card
					Integer.toHexString(10 + SUIT).toUpperCase() + //governs the suit
					Integer.toHexString(fixedRank).toUpperCase()) //governs the face value
					,16)); //closure of Integer.parseInt call from above
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