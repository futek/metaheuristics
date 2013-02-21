package metaheuristics.fitnessfunction;

import metaheuristics.FitnessFunction;

public class LeadingOnes implements FitnessFunction<boolean[]> {
	@Override
	public int evalutate(boolean[] string) {
		int fitness = 0;
		
		for (boolean bit : string) {
			if (bit) {
				fitness++;
			} else {
				return fitness;
			}
		}
		
		return fitness;
	}
	
	@Override
	public int optimum(boolean[] string) {
		return string.length;
	}
}
