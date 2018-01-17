package lesson12.StateDesignPattern.ConcreteState;

import lesson12.StateDesignPattern.state.State;

public class WetSate implements State {

	@Override
	public void left() {
		System.out.println("4");

	}

	@Override
	public void accelerate() {
		System.out.println("9");

	}

	@Override
	public void right() {
		System.out.println("4");

	}

	@Override
	public void applyBreak() {
		System.out.println("7");

	}

}
