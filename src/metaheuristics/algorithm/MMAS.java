package metaheuristics.algorithm;

import java.util.List;

import metaheuristics.Algorithm;
import metaheuristics.FitnessFunction;
import metaheuristics.SearchSpace;
import metaheuristics.StoppingCriterion;
import metaheuristics.Visualizer;
import metaheuristics.searchspace.BitString;

public class MMAS implements Algorithm {
	private double rho;
	private double[] pheromone;
	
	public MMAS(double rho) {
		this.rho = rho;
	}
	
	private void updatePheromones(BitString bitString) {
		boolean[] string = bitString.getString();
		double tauMin = 1.0 / bitString.getLength();
		double tauMax = 1.0 - 1.0 / bitString.getLength();
		
		for (int i = 0; i < pheromone.length; i++) {
			if (string[i]) {
				pheromone[i] = Math.min((1.0 - rho) * pheromone[i] + rho, tauMax);
			} else {
				pheromone[i] = Math.max((1.0 - rho) * pheromone[i], tauMin);
			}
		}
	}
	
	public void run(SearchSpace searchSpace, FitnessFunction fitnessFunction, List<StoppingCriterion> stoppingCriteria, List<Visualizer> visualizers) {
		BitString bitString = (BitString)searchSpace; // assume bitstrings for now
		int optimumFitness = fitnessFunction.optimum(bitString);
		
		pheromone = new double[bitString.getLength()];
		BitString xStar = (BitString)bitString.constructMutation(pheromone);
		int xStarFitness = fitnessFunction.evalutate(xStar);
		
		updatePheromones(xStar);
		
		int iterations = 0;
		
		while (true) {
			iterations++;
			
			BitString x = (BitString)bitString.constructMutation(pheromone);
			int xFitness = fitnessFunction.evalutate(x);
			
			if (xFitness >= xStarFitness) {
				System.out.println(x.toString());
				xStar = x;
				xStarFitness = xFitness;
			}
			
			updatePheromones(xStar);
			
			if (StoppingCriterion.shouldStop(stoppingCriteria, 100000, optimumFitness, iterations, xStarFitness)) {
				System.out.println("Iterations: " + iterations);
				break;				
			}
		}
	}
}
