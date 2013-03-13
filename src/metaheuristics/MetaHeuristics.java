package metaheuristics;

import java.util.ArrayList;
import java.util.List;

import metaheuristics.algorithm.OnePlusOne;
import metaheuristics.fitnessfunction.OneMax;
import metaheuristics.searchspace.BitString;
import stoppingcriterion.OptimumReached;
import stoppingcriterion.OutOfTime;

public class MetaHeuristics {
	public static void main(String[] args) {
		// select search space
		BitString bitString = new BitString(64);
		
		// select fitness function based on search space selection
		FitnessFunction fitnessFunction = new OneMax();
//		FitnessFunction fitnessFunction = new LeadingOnes();

		// select general algorithm
		Algorithm algorithm = new OnePlusOne();
//		Algorithm algorithm = new SimulatedAnnealing(0.01, 500);

		// select stopping criteria
		List<StoppingCriterion> stoppingCriteria = new ArrayList<StoppingCriterion>();
		stoppingCriteria.add(new OptimumReached());
		stoppingCriteria.add(new OutOfTime());
		
		// select visualization based on search space selection
		List<Visualizer> visualizers = new ArrayList<Visualizer>();
//		visualizers.add(new visualizer.Onion());
		
		// create schedule
		Schedule schedule = new Schedule(bitString, fitnessFunction, algorithm, stoppingCriteria, visualizers);
		
		// run schedule
		schedule.run();
	}
}
