package metaheuristics.algorithm;

import java.util.List;
import java.util.Random;

import metaheuristics.Algorithm;
import metaheuristics.FitnessFunction;
import metaheuristics.SearchSpace;
import metaheuristics.StoppingCriterion;
import metaheuristics.Visualizer;
import metaheuristics.searchspace.BitString;

public class SimulatedAnnealing implements Algorithm {
	private static final Random random = new Random();
	
	private int kmax;
	private int emax;
	
	public SimulatedAnnealing(int kmax, int emax) {
		this.kmax = kmax;
		this.emax = emax;
	}
	
	private double temperature(double timeSpent) {
		return (1.0 - timeSpent) * kmax + 1.0;
	}
	
	private double P(int e, int enew, double T) {
		if (enew < e) {
			return 1.0;
		} else {
			return Math.exp(-(enew - e) / T);
		}
	}

	@Override
	public void run(SearchSpace searchSpace, FitnessFunction fitnessFunction, List<StoppingCriterion> stoppingCriteria, List<Visualizer> visualizers) {
		int kmax = 1000;
		int emax = fitnessFunction.optimum(searchSpace);
		
		SearchSpace s = searchSpace;
		int e = fitnessFunction.evalutate(searchSpace);
		
		SearchSpace sbest = s;
		int ebest = e;
		
		int k = 0;
		
		while (k < kmax && e > emax) {
			double T = temperature((double)k / kmax);
			SearchSpace snew = s.localMutation();
			int enew = fitnessFunction.evalutate(snew);
			
			if (P(e, enew, T) > random.nextDouble()) {
				s = snew;
				e = enew;
			}
			
			if (enew > e) {
				sbest = snew;
				ebest = enew;
			}
			
			k++;
		}
		
		System.out.println("sbest = " + sbest);
		System.out.println("ebest = " + ebest);
		
//		int t = 0;
//		
//		while (true) {
//			SearchSpace mutation = searchSpace.localMutation();
//			
//			int searchSpaceFitness = fitnessFunction.evalutate(searchSpace);
//			
//			// hardcoded stopping criterion
//			if (searchSpaceFitness == fitnessFunction.optimum(searchSpace)) {
//				System.out.println("optimum reached! (t = " + t + ")");
//				break;
//			}
//			
//			double probability = Math.min(1.0, Math.pow(alpha(t), searchSpaceFitness - fitnessFunction.evalutate(mutation)));
//			
//			if (random.nextDouble() < probability) {
//				System.out.println(searchSpace); // print mutation
//				searchSpace = mutation;
//			}
//			
//			t++;
//		}
	}
	
}
