package metaheuristics;

import java.util.List;

public class Schedule {
	private final SearchSpace searchSpace;
	private final FitnessFunction fitnessFunction;
	private final Algorithm algorithm;
	private final List<StoppingCriterion> stoppingCriteria;
	private final List<Visualizer> visualizers;
	
	public Schedule(SearchSpace searchSpace, FitnessFunction fitnessFunction, Algorithm algorithm, List<StoppingCriterion> stoppingCriteria, List<Visualizer> visualizers) {
		this.searchSpace = searchSpace;
		this.fitnessFunction = fitnessFunction;
		this.algorithm = algorithm;
		this.stoppingCriteria = stoppingCriteria;
		this.visualizers = visualizers;
	}
	
	public void run() {
		algorithm.run(searchSpace, fitnessFunction, stoppingCriteria, visualizers);
	}
}


// FitnessFunction<BitString> is a FitnessFunction<SearchSpace>