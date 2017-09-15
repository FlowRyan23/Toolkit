package dataHandling;

import java.util.Hashtable;

import javafx.beans.Observable;

public class InputManager {

	public static final InputManager instance = new InputManager();
	private Hashtable<String, Observable> data = new Hashtable<>();
	
	private InputManager() {}
	
	public void add(String key, Observable value) throws DuplicateKeyException {
		if(data.keySet().contains(key))
			throw new DuplicateKeyException(key);
		else
			data.put(key, value);
	}
	
	 //The argument "type" is used to avoid the need for warning-suppression in calling methods.
	@SuppressWarnings("unchecked")
	public <T> T get(String key, T type){
			return (T) data.get(key);
	}
	
}
