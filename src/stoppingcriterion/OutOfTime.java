package stoppingcriterion;

import metaheuristics.StoppingCriterion;

public class OutOfTime extends StoppingCriterion {
	@Override
	public boolean shouldStop(int maxTime, int optimumFitness, int time, int fitness) {
		return time >= maxTime;
	}
}
