package search;

import java.util.LinkedList;

public class Searchable<T> {

	private T value;
	private long searchHash;
	private Hasher hasher;
	
	public Searchable(T value, Hasher hasher) {
		this.value = value;
		this.hasher = hasher;
	}

	public LinkedList<Searchable<T>> expand(Expander<T> expander) {
		T[] expansionValues = expander.expand(value);
		LinkedList<Searchable<T>> expansion = new LinkedList<>();
		for(T t: expansionValues)
			expansion.add(new Searchable<T>(t, hasher));
		return expansion;
	}
	
	public void setCost(int cost) {
		searchHash = cost;
		searchHash <<= 32;
		searchHash += value.hashCode();
	}
	
	public long getSearchHash() {
		return searchHash;
	}
	
}
