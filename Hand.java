public class Hand extends CardCollection {
	public Hand(String name) {
		super(name);
	}

	public int handValue() {
		int value = 0;
		for (int i = 0; i < super.getSize(); i++) {
			Card temp = super.getCard(i);
			value += temp.getValue();
			if (value > 21 && temp.getValue() == 11) {
				value -= 10;
			}
		}
		return value;
	}

	/* public boolean hasAce() {
		for (int i = 0; i < super.getSize(); i++) {
			if (super.getCard(i).getValue() == 11) {
				return true;
			}
		}
		return false;
	} */
}