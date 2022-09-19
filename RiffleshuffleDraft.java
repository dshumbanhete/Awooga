import java.util.Random;

    public class RiffleshuffleDraft{

        public static void main(String[] args) {
        int[] cards=new int[52];
        int[] diffs= new int[52];
        //int i=0;
        
        System.out.println("");
        System.out.println("");
        

        for (int i=0; i<52; i++){
            cards[i]=i;
            //i++;
            }
        
        System.out.println("");
        System.out.println("");
        System.out.println("Unshuffled cards follow: ");
        for (int j=0; j<52; j++){
            System.out.print(cards[j]+", ");
            }

        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("Shuffled cards follow: ");

        Random rand = new Random();
        int k=51;
        while ( k>0){
            int nums = rand.nextInt(k);
            if (nums==k){;}

            else{
                int x=cards[nums];
                int y=cards[k];
                cards[nums]=y;
                cards[k]=x;
                diffs[k]=Math.abs(x-y);
                }
            k=k-1;
            }
            for (int l=0; l<52; l++){
                System.out.print(cards[l]+", ");
                //System.out.print(diffs[l]+", ");
            int pi=0;
            double p=0.0;
            double pp=0.0;
            for (int o=0; o<52; o++){
                for (int m=0; m<52; m++){
                    for (int n=0; n<52; n++){
                        if (diffs[n]==diffs[m]){
                            pi++;
                            }
                        }
                    
                    
                p=pi/52;
            

            //for (int m=0; m<52; m++){
                //diffs[i] =

            
                }
            }
            }
        }
    }

