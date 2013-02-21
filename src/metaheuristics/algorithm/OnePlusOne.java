package metaheuristics.algorithm;

import metaheuristics.Algorithm;
import metaheuristics.SearchSpace;

public class OnePlusOne implements Algorithm {
	@Override
	public void run(SearchSpace searchSpace) {
		int iterations = 0;
		
		while (true) {
			iterations++;
			
			SearchSpace mutation = searchSpace.getMutation();
			
			int mutationFitness = mutation.fitness();
			if (mutationFitness > searchSpace.fitness()) {				
				searchSpace = mutation;
				
				System.out.println(searchSpace); // print fit mutation
				if (mutationFitness == searchSpace.optimumFitness()) { // stop criteria
					System.out.println("Iterations: " + iterations); // print iterations
					return;
				}
			}
		}
	}
	
}
