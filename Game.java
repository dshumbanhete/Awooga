	public class Game {
	private Deck deck;
	private Dealer dealer;
	public final int PLAYER_COUNT; //unused as of now, will be important with GUI.
	private Player[] players;
	
	
	public Game(int playerCnt, int numDecks, Player[] players) {
		deck = new Deck(numDecks);
		dealer = new Dealer();
		PLAYER_COUNT = playerCnt;
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
		}
		return out;
	}
}