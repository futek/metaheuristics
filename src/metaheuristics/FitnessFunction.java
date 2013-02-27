package metaheuristics;

public interface FitnessFunction {
	public int evalutate(SearchSpace searchSpace);
	public int optimum(SearchSpace searchSpace);
}