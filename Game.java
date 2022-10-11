import javax.swing.JOptionPane;

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
                firstDeal();
	}
	
        /** the initial deal done at the beginning of each game */
	private void firstDeal() { 
		deck.dealCard(dealer.getHand()); //dealer's first card
		for (int i = 0; i < PLAYER_COUNT; i++) {
			deck.dealCard(players[i].getHand()); //each player gets 2 cards
			deck.dealCard(players[i].getHand());
		}
                // the dealer's second hand is drawn at the end of the round, unlike reality. With a perfect shuffle this makes no difference logistically.
	}
	
	public String playersToString() {
		String out = dealer.toString();
		for (int i = 0; i < this.PLAYER_COUNT; i++) {
			out += "\n" + this.players[i] ;
			out += "\t= " + this.players[i].getHand().handValue();
		}
		return out;
	}
        
        /** accessor method for individual players */
        public Player getPlayer(int idx) {
            if (idx < players.length) {
                return players[idx];
            }
            return null;
        }
        
        /** accessor method for players array attribute (unused for now) */
        public Player[] getPlayers() {
            return players;
        }
        
        /** accessor for dealer attribute */
        public Dealer getDealer() {
            return this.dealer;
        }
	
	/** accessor method for deck attribute */
	public Deck getDeck() {
		return this.deck;
	}
        
        public void endGame(boolean dealerBust) {
            String result = "END OF ROUND RESULTS:\n\n";
            int dealerVal = dealer.getHand().handValue();
            if (dealerBust) {
                result += "THE DEALER BUSTED WITH " + dealerVal + "!!\n\n";
                for (Player current : players) {
                    if (current.checkBusted()) {
                        result += current.getName() + " lost due to bust!!\n";
                    } else {
                        result += current.getName() + " wins by default!!\n";
                    }
                }
            } else {
                result += "The Dealer had " + dealerVal + "\n\n";
                for (Player current : players) {
                    int currVal = current.getHand().handValue();
                    if (current.checkBusted()) {
                        result += current.getName() + " busted with " + currVal + "!!\n";
                    } else {
                        int dealVal = dealer.getHand().handValue();
                        if (currVal < dealVal) {
                            result += current.getName() + " lost with " + currVal + "!!\n";
                        } else if (currVal > dealVal) {
                            result += current.getName() + " won with " + currVal + "!!\n";
                        } else {
                            result += current.getName() + " draws with the dealer!!\n";
                        }
                    }
                }
            }
            
            JOptionPane.showMessageDialog(null, result);
        }
}