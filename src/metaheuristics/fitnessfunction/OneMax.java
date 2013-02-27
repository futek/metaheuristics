package metaheuristics.fitnessfunction;

import metaheuristics.FitnessFunction;
import metaheuristics.SearchSpace;
import metaheuristics.searchspace.BitString;

public class OneMax implements FitnessFunction {
	@Override
	public int evalutate(SearchSpace searchSpace) {
		BitString bitString = (BitString)searchSpace;
		
		int fitness = 0;
		
		boolean[] string = bitString.getString();
		
		for (boolean bit : string) {
			if (bit) {
				fitness++;
			}
		}
		
		return fitness;
	}
	
	@Override
	public int optimum(SearchSpace searchSpace) {
		BitString bitString = (BitString)searchSpace;
		
		return bitString.getLength();
	}
}
