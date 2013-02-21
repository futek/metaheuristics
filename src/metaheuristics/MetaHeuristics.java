package metaheuristics;

import metaheuristics.algorithm.OnePlusOne;
import metaheuristics.fitnessfunction.LeadingOnes;
import metaheuristics.searchspace.BitString;

public class MetaHeuristics {
	public static void main(String[] args) {
		FitnessFunction<boolean[]> fitnessFunction = new LeadingOnes();
		SearchSpace searchSpace = BitString.randomBitString(128, fitnessFunction);
		Algorithm algorithm = new OnePlusOne();
		
		algorithm.run(searchSpace);
	}
}
