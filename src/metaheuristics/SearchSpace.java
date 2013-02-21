package metaheuristics;

public interface SearchSpace {
	public SearchSpace getMutation();
	public int fitness();
	public int optimumFitness();
}
