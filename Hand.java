public class Hand extends CardCollection {
	public Hand(String name) {
            super(name);
	}

	public int handValue() {
            int value = 0;
            int hardAces = 0;
            for (int i = 0; i < super.getSize(); i++) {
                Card temp = super.getCard(i);
                value += temp.getValue();
                if (value > 21 && hardAces < aceCount()) {
                    value -= 10;
                    hardAces++;
                }
            }
            return value;
	}

	public int aceCount() {
            int cnt = 0;
            for (int i = 0; i < super.getSize(); i++) {
                if (super.getCard(i).getValue() == 11) {
        		cnt++;
		}
            }
            return cnt;
	}
}