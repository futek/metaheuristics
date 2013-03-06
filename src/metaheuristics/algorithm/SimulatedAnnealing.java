package metaheuristics.algorithm;

import java.util.List;
import java.util.Random;

import metaheuristics.Algorithm;
import metaheuristics.FitnessFunction;
import metaheuristics.SearchSpace;
import metaheuristics.StoppingCriterion;
import metaheuristics.Visualizer;

public class SimulatedAnnealing implements Algorithm {
	private static final Random random = new Random();

	private final double initialTemperature;
	private final int maxTime;
	
	public SimulatedAnnealing(double initialTemperature, int maxTime) {
		this.initialTemperature = initialTemperature;
		this.maxTime = maxTime;
	}
	
	private double temperature(double time) {
		return initialTemperature - time * (initialTemperature / maxTime);
	}
	
	private double alpha(double time) {
		return Math.exp(1.0 / temperature(time));
	}

	@Override
	public void run(SearchSpace searchSpace, FitnessFunction fitnessFunction, List<StoppingCriterion> stoppingCriteria, List<Visualizer> visualizers) {
		int time = 0;
		int optimumFitness = fitnessFunction.optimum(searchSpace);
		
		while (true) {
			SearchSpace mutation = searchSpace.localMutation();

			int searchSpaceFitness = fitnessFunction.evalutate(searchSpace);

			int mutationFitness = fitnessFunction.evalutate(mutation);

			double probality = Math.min(1.0, Math.pow(alpha(time), mutationFitness - searchSpaceFitness));

			if (random.nextDouble() < probality) {
				searchSpace = mutation;
				System.out.println(searchSpace);
			}
			
			time++;
			
			if (searchSpaceFitness == optimumFitness) {
				System.out.println("optimum reached in time " + time);
				break;
			} else if (time >= maxTime) {
				System.out.println("out of time");
				break;
			}
		}
	}
	
}
