package metaheuristics.algorithm;

import java.util.List;

import metaheuristics.Algorithm;
import metaheuristics.FitnessFunction;
import metaheuristics.SearchSpace;
import metaheuristics.StoppingCriterion;
import metaheuristics.Visualizer;

public class OnePlusOne implements Algorithm {
	@Override
	public void run(SearchSpace searchSpace, FitnessFunction fitnessFunction, List<StoppingCriterion> stoppingCriteria, List<Visualizer> visualizers) {
		int iterations = 0;
		
		while (true) {
			iterations++;
			
			SearchSpace mutation = searchSpace.globalMutation();
			int mutationFitness = fitnessFunction.evalutate(mutation);
			
			if (mutationFitness > fitnessFunction.evalutate(searchSpace)) {
				searchSpace = mutation;
				
				//System.out.println(searchSpace); // print fit mutation
				if (mutationFitness == fitnessFunction.optimum(searchSpace)) { // stop criteria
					System.out.println("Iterations: " + iterations); // print iterations
					return;
				}
			}
		}
	}
	
}
