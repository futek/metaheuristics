package metaheuristics.stoppingcriterion;

import metaheuristics.StoppingCriterion;

public class OptimumReached extends StoppingCriterion {
	@Override
	public boolean shouldStop(int maxTime, int optimumFitness, int time, int fitness) {
		return fitness >= optimumFitness;
	}
}
