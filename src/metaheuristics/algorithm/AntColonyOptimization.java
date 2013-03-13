package metaheuristics.algorithm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import metaheuristics.Algorithm;
import metaheuristics.FitnessFunction;
import metaheuristics.SearchSpace;
import metaheuristics.StoppingCriterion;
import metaheuristics.Visualizer;
import metaheuristics.searchspace.BitString;

class Edge {
	private final int u;
	private final int v;
	
	Edge(int u, int v) {
		this.u = u;
		this.v = v;
	}
}

public class AntColonyOptimization implements Algorithm {
	private static final Random random = new Random();

	int[] path = null;
	private final double rho;
	private final Map<Edge, Double> tau = new HashMap<Edge, Double>();
	
	
	public AntColonyOptimization(double rho) {
		this.rho = rho;
		
	}
	
	private int[] successors (int v) {
		
		if(v % 3 == 0) {
			return new int[] {v+1,v+2};
		}else if((v-1) % 3 == 0 ){
			return new int[] {v+2};
		}
		return new int[] {v+1};
	}

	private int[] construct(int[][] constructionGraph, double tau) {
		double probability = 0.5;
		int v = 0;
		int i = 0;
		while (true) {
		
			int[] nonVisited = successors(v);
			
			if(v > 3*64 + 1) {
				break;
			}
			
			if(probability > Math.random()) {
				nonVisited = successors(v+1);
			}else{
				nonVisited = successors(v+2);
			}
			path[i] = nonVisited[i];
			i++;
		
		}
		return path;
		
		
	}
	

	@Override
	public void run(SearchSpace searchSpace, FitnessFunction fitnessFunction, List<StoppingCriterion> stoppingCriteria, List<Visualizer> visualizers) {
		int optimumFitness = fitnessFunction.optimum(searchSpace);
		BitString bitString = (BitString) searchSpace;
		int n = bitString.getLength();
		
		for(int i = 0; i <= 3*(n-1); i =+ 3) {
			tau.put(new Edge(i, i+1), (1/2.0));
			tau.put(new Edge(i, i+2), (1/2.0));
			tau.put(new Edge(i+1, i+3), (1/2.0));
			tau.put(new Edge(i+2, i+3), (1/2.0));
		}
		
		while (true) {
			for(int i=0; i<path.length; i++) {
				
			}
			
			int[] xStar = path;
			
			//update pheromones
			
			while (true) {
//				int[] x = construct();
			}
			
		}
	}
	
}
