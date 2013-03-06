package metaheuristics;

import java.util.List;

public abstract class StoppingCriterion {
	public static boolean shouldStop(List<StoppingCriterion> stoppingCriteria, int maxTime, int optimumFitness, int time, int fitness) {
		for (StoppingCriterion stoppingCriterion : stoppingCriteria) {
			if (stoppingCriterion.shouldStop(maxTime, optimumFitness, time, fitness)) {
				return true;
			}
		}
		
		return false;
	}
	
	public abstract boolean shouldStop(int maxTime, int optimumFitness, int time, int fitness);
}
