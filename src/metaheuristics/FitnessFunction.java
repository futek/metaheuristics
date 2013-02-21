package metaheuristics;

public interface FitnessFunction<T> {
	public int evalutate(T state);
	public int optimum(T state);
}
