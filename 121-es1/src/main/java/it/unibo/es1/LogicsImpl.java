package it.unibo.es1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LogicsImpl implements Logics {

	private final List<MyButton> listOfButton = new ArrayList<>();

	public LogicsImpl(int size) {
		for(int i = 0; i < size; i++) {
			listOfButton.add(new MyButton());
		}
	}

	@Override
	public int size() {
		return this.listOfButton.size();
	}

	@Override
	public List<Integer> values() {
		return listOfButton.stream().map(MyButton::getValue).toList();
	}

	@Override
	public List<Boolean> enablings() {
		return listOfButton.stream().map(MyButton::isEnabled).toList();
	}

	@Override
	public int hit(int elem) {
		if(listOfButton.get(elem).inc() == listOfButton.size() - 1) {
			listOfButton.get(elem).setEnabled(false);
		}
		return listOfButton.get(elem).getValue();

	}

	@Override
	public String result() {
		return listOfButton.stream().map(MyButton::getValue).map(x-> Integer.toString(x)).
		collect(Collectors.joining("|", "<<", ">>"));
	}

	@Override
	public boolean toQuit() {
		return listOfButton.stream().map(MyButton::getValue).allMatch(x -> x.equals(listOfButton.get(0).getValue()));
	}

	private class MyButton {
		private int value = 0;
		private boolean isEnabled = true;

		public void setEnabled(boolean isEnabled) {
			this.isEnabled = isEnabled;
		}

		public int getValue() {
			return value;
		}

		public boolean isEnabled() {
			return isEnabled;
		}

		private int inc() {
			return this.value++;
		}
	}
}
