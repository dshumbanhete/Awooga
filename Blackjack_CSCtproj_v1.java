import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Blackjack_CSCtproj_v1 {
	public static String[] draw;
	public static int[] draw_p;
	private static int winnings;
	
public static void draw_card() {
		draw_p=new int[32];
		String[] cards= {"1","2","3","4","5","6","7","8","9","10","11"};
		String[] suits= {"DCA","DCB","DCC","DCD"};
		
		for (int i = 0; i < draw.length-52; i++){
			String card_final="";
		Random random=new Random();
		int ten_neg= random.nextInt(0,1);
		int card_value=Integer.parseInt(cards[random.nextInt(0, 11)]);
		
		int suit=random.nextInt(0,4);
		if (card_value==1) {
			card_final+=suits[suit]+suit;
			card_value-=1;
			int c = Integer.parseInt(card_final,16);
			card_final = "\uD83C" + (char) c;
			
		}else if(card_value==11) {
			card_final=suits[suit]+suit;
			card_value-=1;
			int c = Integer.parseInt(card_final,16);
			card_final = "\uD83C" + (char) c;
		}
		else if (card_value==10&ten_neg==0){
			card_final+=suits[suit]+suit;
			int c = Integer.parseInt(card_final,16);
			card_final = "\uD83C" + (char) c;
			
		}else if (card_value==10&ten_neg==1) {
			card_final+=suits[suit]+suit;
			int c = Integer.parseInt(card_final,16);
			card_final = "\uD83C" + (char) c;
		
		}else{
			card_final+=suits[suit]+suit;
			int c = Integer.parseInt(card_final,16);
			card_final = "\uD83C" + (char) c;
		}
		
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
		setWinnings(getWinnings() + 1);
		isThing=true;
	}
}
	return isThing;
}
public static void main(String[] args) {
	draw=new String[104];
	final Integer dealer=52;
	final Integer player1=56;
	final Integer player2=60;
	final Integer player3=64;
	final Integer player4=68;
	Integer hand=2;
	setWinnings(0);
	
	do {
	draw_card();
		System.out.println("The dealer has "+draw[dealer-52]+" and "+draw[dealer-51]);
		System.out.println("Would you like to (d)raw or (f)old?");
		Scanner in=new Scanner(System.in);
		String us_in=in.next();
		if (us_in.equals("d")){
			if (compare_numb(Integer.parseInt(draw[dealer]),Integer.parseInt(draw[dealer+1]), Integer.parseInt(draw[player1]),Integer.parseInt(draw[player1+1]))==true) {
				System.out.println("You have picked "+draw[player1-52]+" and "+draw[player1-51]);
				setWinnings(getWinnings() + 1);
		}
		else {
			System.out.println("You have picked "+draw[player1-52]+" and "+draw[player1-51]);
			hand-=1;
		}
}
		hand-=1;
} while (hand>0);
	System.out.println("Game over!");
}


public static int getWinnings() {
	return winnings;
}


public static void setWinnings(int winnings) {
	Blackjack_CSCtproj_v1.winnings = winnings;
}
}
