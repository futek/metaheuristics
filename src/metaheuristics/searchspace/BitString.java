package metaheuristics.searchspace;

import java.util.Random;

import metaheuristics.FitnessFunction;
import metaheuristics.SearchSpace;

public class BitString implements SearchSpace {
	private static Random random = new Random();
	
	private final boolean[] string;
	private final double mutationProbability;
	private final FitnessFunction<boolean[]> fitnessFunction;
	
	public static BitString randomBitString(int length, FitnessFunction<boolean[]> fitnessFunction) {
		boolean[] string = new boolean[length];
		
		for (int i = 0; i < string.length; i++) {
			string[i] = random.nextBoolean();
		}
		
		return new BitString(string, fitnessFunction);
	}
	
	public BitString(boolean[] string, FitnessFunction<boolean[]> fitnessFunction) {
		this.string = string;
		this.fitnessFunction = fitnessFunction;
		
		mutationProbability = 1.0 / string.length;
	}
	
	@Override
	public SearchSpace getMutation() {
		boolean[] mutation = new boolean[string.length];
		
		for (int i = 0; i < mutation.length; i++) {
			if (random.nextDouble() < mutationProbability) {
				mutation[i] = !string[i];
			} else {
				mutation[i] = string[i];
			}
		}
		
		return new BitString(mutation, fitnessFunction);
	}

	@Override
	public int fitness() {
		return fitnessFunction.evalutate(string);
	}
	
	public int optimumFitness() {
		return fitnessFunction.optimum(string);
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
