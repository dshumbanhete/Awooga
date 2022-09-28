import java.util.ArrayList;

public class CardCollection {
	private String name; //name of this collection of cards. ie "Deck", or "Player 1's hand"
	private ArrayList<Card> cards; //List of cards in the collection. The "Deck" collection starts with all the cards, and cards are distributed from there.
	
	/** Constructor for the CardCollection class */
	public CardCollection(String name) {
		this.name = name;
		this.cards = new ArrayList<Card>();
	}
	
	/** toString() returns a String that contains the name of the CardCollection and information about each Card in it on a new line.*/
	public String toString() {
		String out = this.name + ":\n";
		for (int i = 0; i < cardCount(); i++) {
			out += "\t" + getCard(i).toString() + "\n";
		}
		return out;
	}
	
	/** addCard() takes a Card object as a parameter and adds it to the CardCollection */
	public void addCard(Card card) {
		this.cards.add(card);
	}
	
	/** removeCard() removes the top Card from the CardCollection. It also returns the Card that it removed, therefore this method is used when dealing Cards from the deck to a Hand.*/
	public Card removeCard() {
		return this.cards.remove(0);
	}
	
	/** cardCount() returns the number of Cards in the CardCollection. It is used after every game cycle to ensure that the total amount of Cards in the game remains constant, as an error check. */
	public int cardCount() {
		return this.cards.size();
	}
	
	/** getCard() returns a Card at the given index. Used in conjuntion with cardCount() and Card.getValue() to calculate the total value of a Hand.*/
	public Card getCard(int i) {
		return this.cards.get(i);
	}
	
	/** setCard() sets a Card in the cards ArrayList at a specified index*/
	public void setCard(int indx, Card card){
		this.cards.set(indx, card);
	}
	
	/** getName() is an accessor method that returns the value of the name attribute of the given CardCollection instance */ 
	public String getName() {
		return this.name;
	}
}
