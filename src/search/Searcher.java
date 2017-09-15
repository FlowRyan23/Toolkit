package search;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.TreeMap;

public class Searcher<T> {
	
	Heuristic heuristic;
	Expander<T> expander;
	
	public Searcher(Heuristic heuristic, Expander<T> expander) {
		this.expander = expander;
		this.heuristic = heuristic;
	}
	
	public LinkedList<Searchable<T>> search(Searchable<T> start, Searchable<T> dest) {
		
		TreeMap<Long, AgendaEntry> agenda = new TreeMap<>();
		Hashtable<Long, Searchable<T>> done = new Hashtable<>();
		
		AgendaEntry current = new AgendaEntry(start, new LinkedList<>());
		
		while(!current.equals(dest)) {
			for(Searchable<T> candidate: current.searchable.expand(expander)) {
				candidate.setCost(current.path.size() + heuristic.heuristic(start, candidate));
				Searchable<T> conflicting = done.get(candidate.getSearchHash());
				if(conflicting == null || conflicting.getSearchHash() <= candidate.getSearchHash()) {	//done already contains a better or equal path to candidate
					@SuppressWarnings("unchecked")
					LinkedList<Searchable<T>> candidatePath = (LinkedList<Searchable<T>>) current.path.clone();
					candidatePath.add(current.searchable);
					agenda.put(candidate.getSearchHash(), new AgendaEntry(candidate, current.path));
				}
			}
			
			current = agenda.firstEntry().getValue();
			agenda.remove(agenda.firstKey());
			done.put(current.searchable.getSearchHash(), current.searchable);
		}
		
		current.path.add(current.searchable);
		return current.path;
	}

	private class AgendaEntry {
		public Searchable<T> searchable;
		public LinkedList<Searchable<T>> path;
		
		public AgendaEntry(Searchable<T> searchable, LinkedList<Searchable<T>> path) {
			this.searchable = searchable;
			this.path = path;
		}
	}
	
}
