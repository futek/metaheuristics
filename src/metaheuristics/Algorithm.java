package metaheuristics;

import java.util.List;

public interface Algorithm {
	public void run(SearchSpace searchSpace, FitnessFunction fitnessFunction, List<StoppingCriterion> stoppingCriteria, List<Visualizer> visualizers);
}
