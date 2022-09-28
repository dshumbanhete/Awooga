//THIS WHOLE CLASS IS TEMPORARY AND FOR TESTING PURPOSES ONLY!!

public class TempMain {
	public static void main(String[] args) {
		Player p1 = new Player("Tessa");
		Player p2 = new Player("Dean");
		Player p3 = new Player("Jameo");
		Player p4 = new Player("Nicky");
		
		Player[] players = new Player[] {p1,p2,p3,p4};
		Game game = new Game(4, 1, players);
		
		//System.out.println(deck.toString());
		System.out.println(game.playersToString());
		
		System.out.println("\n\n");
		
/* 		deck.dealCard(d.getHand());
		deck.dealCard(p1.getHand());
		deck.dealCard(p1.getHand());
		deck.dealCard(p2.getHand());
		deck.dealCard(p2.getHand());
		deck.dealCard(p3.getHand());
		deck.dealCard(p3.getHand());
		deck.dealCard(p4.getHand());
		deck.dealCard(p4.getHand());
		deck.dealCard(d.getHand()); */
		
		Game.firstDeal();
		
		System.out.println(deck.toString());
		System.out.println(game.playersToString());
		
	}
}