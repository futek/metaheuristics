package metaheuristics.fitnessfunction;

import metaheuristics.FitnessFunction;

public class OneMax implements FitnessFunction<boolean[]> {
	@Override
	public int evalutate(boolean[] string) {
		int fitness = 0;
		
		for (boolean bit : string) {
			if (bit) {
				fitness++;
			}
		}
		
		return fitness;
	}
	
	@Override
	public int optimum(boolean[] string) {
		return string.length;
	}
}
