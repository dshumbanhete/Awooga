import javax.swing.JOptionPane;

public class TempMain {
	public static void main(String[] args) {
		//JOptionPane.showMessageDialog(null, "code: 6969)", 0);
		Deck deck = new Deck(1);
		System.out.println(deck.toString());
		
		Player p1 = new Player("Tessa");
		System.out.println(p1.getHand().toString());
		
		System.out.println("\n\n");
		
		deck.dealCard(p1.getHand());
		deck.dealCard(p1.getHand());
		deck.dealCard(p1.getHand());
		deck.dealCard(p1.getHand());
		deck.dealCard(p1.getHand());
		
		System.out.println(deck.toString());
		System.out.println(p1.getHand().toString());
	}
}
