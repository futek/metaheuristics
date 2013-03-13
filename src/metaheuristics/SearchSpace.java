package metaheuristics;

public interface SearchSpace {
	public SearchSpace localMutation();
	public SearchSpace globalMutation();
	public SearchSpace constructMutation(double[] pheromone);
}
