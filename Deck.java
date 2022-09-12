public class Deck extends CardCollection {
	private int numDecks;
	
	public Deck(int n) {
		super("Deck");
		this.numDecks = n;
		populate();
	}
	
	private void populate() {
		for (int d = 0; d < numDecks; d++) { //d = deck
			for (int s = 0; s < 4; s++) { //s = suit
				for (int r = 1; r <= 13; r++) { //r = rank
					addCard(new Card(r,s)); 
				}
			}
		}	
	}
	
	public void riffleShuffle() {
		
	}
	
	public void dealCard(CardCollection hand) {
		hand.addCard(this.removeCard());
	}
}