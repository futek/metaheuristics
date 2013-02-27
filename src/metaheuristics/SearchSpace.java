package metaheuristics;

public interface SearchSpace {
	public SearchSpace localMutation();
	public SearchSpace globalMutation();
}
