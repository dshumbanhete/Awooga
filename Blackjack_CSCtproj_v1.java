import java.util.Arrays;
import javax.swing.*;
import java.util.Random;
import java.util.Scanner;
public class Blackjack_CSCtproj_v1 {
	private static String[] draw;
	private static int[] draw_p;
	private static String[][]players;
	private int winnings;
	private static int dealer=52;
	private String[] player;
	 private Blackjack_CSCtproj_v1(){
		 this.winnings=0;
		 this.player=new String[2];
	 }
	 
public static void draw_card() {
		draw_p=new int[32];
		String[] cards= {"1","2","3","4","5","6","7","8","9","10","11"};
		String[] suits= {"DCA","DCB","DCC","DCD"};
		
		//I use unicode for this version the suits can easily be mapped back to String, would need a toString method however to print the hands for each player
		for (int i = 0; i < draw.length-52; i++){
			String card_final="";
		Random random=new Random();
		int card_value=Integer.parseInt(cards[random.nextInt(0, 11)]);
		int suit=random.nextInt(0,4);
			card_final+=suits[suit]+suit;
			card_value-=1;
			int c = Integer.parseInt(card_final,16);
			card_final = "\uD83C" + (char) c;
		
		draw[i]=card_final;
		draw[i+52]=""+(card_value+1);
			//Once we have finished making our card instance, we then add it to the deck object, we could change this to be non-static by writting in a getter and a setter.
		}
		//storing the nominal card values in another object, draw_p which will be used to compute he shannon index. I use the original draw which is split 52-52 between the cards themselves and their nominal values. Keeping them in one deck object makes its slightly easier to compare the values for the game logic
		for (int rane=52;rane<draw.length;rane++) {
			draw_p[rane]=Integer.parseInt(draw[rane]);
		}
		//}while (shannon(draw_p)<3);
	System.out.println(Arrays.toString(draw));
	}
		//lets print out the draw to get a look at what our object contains
		

public static double entropy(double pi) {
	double q=pi* Math.log(pi);
	return q;
}
public static double shannon(int[] rg) {
	double ans=0;
	double[] freq=new double[52];
	for (int i=0; i<rg.length;i++) {
		int helper=rg[i+1]-rg[i];
		if (helper<0) {
			 helper+=52;
		}
		freq[helper]+=1;
	}
	for (int iu=0;iu<freq.length;iu++) {
		if (freq[iu]!=0.0) {
		freq[iu]=entropy(freq[iu]/52);
	}
	}
	
	for (int y=0;y<freq.length;y++) {
		ans+=freq[y];
	}
	ans=ans*-1;
	return ans;
}

public static boolean compare_numb(int dl, int dl2, int hand, int hand2) {
	//This is the main logic of the game, I first see if the dealer has over 21
	boolean isThing=true;
	if ((dl+dl2)>21) {
		System.out.println("You have Won!");
		isThing=true;
		Blackjack_CSCtproj_v1.setWinnings(1);
	}else {
		int dealers=dl+dl2;
		int plars=hand+hand2;
		if (plars>dealers) {
		System.out.println("You have won this round ");
		isThing= true;
		Blackjack_CSCtproj_v1.setWinnings(1);
	}else {
		System.out.println("You have won this round");
		isThing=false;
	}
}
	return isThing;
}
public static void main(String[] args) {
	draw=new String[104];
	Integer hand=2;
	Blackjack_CSCtproj_v1 blackjack_CSCtproj_v1 = new Blackjack_CSCtproj_v1();
	do {
	draw_card();
		System.out.println("The dealer has "+draw[dealer-52]+" and "+draw[dealer-51]);
		System.out.println("Would you like to (d)raw or (f)old?");
		Scanner in=new Scanner(System.in);
		String us_in=in.next();
		for (int i=1;i<5;i++) {
		if (us_in.equals("d")){
			if (compare_numb(Integer.parseInt(draw[dealer]),Integer.parseInt(draw[dealer+1]), Integer.parseInt(draw[Integer.parseInt(blackjack_CSCtproj_v1.player[1])]),Integer.parseInt(draw[Integer.parseInt(blackjack_CSCtproj_v1.player[1])+1]))==true) {
				System.out.println("You have picked "+draw[Integer.parseInt(blackjack_CSCtproj_v1.player[1])-dealer]+" and "+draw[Integer.parseInt(blackjack_CSCtproj_v1.player[1])-dealer]);
				setWinnings(1);
		}
		else {
			System.out.println("You have picked "+draw[Integer.parseInt(blackjack_CSCtproj_v1.player[1])-dealer]+" and "+draw[Integer.parseInt(blackjack_CSCtproj_v1.player[1])-dealer]);
			hand-=1;
		}
}
		hand-=1;
}} while (hand>0);
	System.out.println("Game over!");

}


public int getWinnings() {
	return this.winnings;
}

public void setPlayer(String c, int q) {
	this.player[0]=c;
	this.player[1]=""+q;
}
public static void setWinnings(int winnings) {
	winnings += winnings;
}
}
