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
		int count=0;
		Card[] gill=new int[15];
		Card[] fin=new int[15];
		Card[] eye=new int[22];
		for (int go=0; go<52; go++){
			if (go<=14){
				gill[go]=cards.getCard(go); //thank you for the getter Tess :}
			}else if (go>29){
				eye[go-29]=cards.getcard(go);
			}else{
				fin[go-14]=cards.getCard(go);
			}
		while(count<52){
			if (count<15){
				cards.setCards(count, gill[count]);
				count+=1;
			}else if (count>36){
				cards.setCards(count, eye[count-36]);
				count+=1;
			}else{
				cards.setcards(count, fin[count-15]);
			}
		}
	}
	
	public void dealCard(CardCollection hand) {
		hand.addCard(this.removeCard());
	}
}
