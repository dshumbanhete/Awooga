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
		
		//Blackjack_CSCtproj_v1(players[0][0],Integer.parseInt(players[1][0]));
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
		}
		for (int rane=0;rane<draw_p.length;rane++) {
			draw_p[rane]=Integer.parseInt(draw[rane+52]);
		}
		//}while (shannon(draw_p)<3);
	System.out.println(Arrays.toString(draw));
	}	
		
		

		//lets print out the draw just to be sure
		

public static double entropy(double pi) {
	double q=pi* Math.log(pi);
	return q;
}
public static double shannon(int[] rg) {
	double ans=0;
	double[] freq=new double[52];
	for (int i=0; i<rg.length-1;i++) {
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
	boolean isThing=true;
	if ((hand+hand2)>21) {
		System.out.println("You have Lost!");
		isThing=false;
	}else {
		int dealers=dl+dl2;
		int plars=hand+hand2;
		if (plars<dealers) {
		System.out.println("You have lost this round ");
		isThing= false;
	}else {
		System.out.println("You have won this round");
		
		Blackjack_CSCtproj_v1.setWinnings(0);
		isThing=true;
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
