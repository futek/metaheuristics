package metaheuristics.searchspace;

import java.util.Arrays;
import java.util.Random;

import metaheuristics.SearchSpace;

public class BitString implements SearchSpace {
	private static Random random = new Random();
	
	public final boolean[] string;
	
	public BitString(int length) {
		string = new boolean[length];
		
		for (int i = 0; i < string.length; i++) {
			string[i] = random.nextBoolean();
		}
	}
	
	public BitString(boolean[] string) {
		this.string = string;
	}
	
	public boolean[] getString() {
		return string; // aliasing..
	}
	
	public int getLength() {
		return string.length;
	}
	
	@Override
	public SearchSpace localMutation() {
		boolean[] mutation = Arrays.copyOf(string, string.length);
		
		int i = random.nextInt(mutation.length);
		mutation[i] = !string[i];
		
		return new BitString(mutation);
	}
	
	@Override
	public SearchSpace globalMutation() {
		boolean[] mutation = new boolean[string.length];
		double probability = 1.0 / string.length;
		
		for (int i = 0; i < mutation.length; i++) {
			if (random.nextDouble() < probability) {
				mutation[i] = !string[i];
			} else {
				mutation[i] = string[i];
			}
		}
		
		return new BitString(mutation);
	}
	
	@Override
	public SearchSpace constructMutation(double[] pheromone) {
		boolean[] mutation = new boolean[string.length];
		
		for (int i = 0; i < mutation.length; i++) {
			mutation[i] = random.nextDouble() < pheromone[i];
		}
		
		return new BitString(mutation);
	}
	
	@Override
	public String toString() {
		String result = "";
		
		for (boolean bit : string) {
			result += (bit ? "1" : "0");
		}
		
		return result;
	}
}
