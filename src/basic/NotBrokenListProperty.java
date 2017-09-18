package basic;

import java.util.LinkedList;
import java.util.List;

import javafx.beans.InvalidationListener;
import javafx.beans.property.Property;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class NotBrokenListProperty<L extends List<T>, T> implements Property<L> {

	private LinkedList<ChangeListener<T>> listeners = new LinkedList<>();
	private LinkedList<InvalidationListener> invalidationListeners = new LinkedList<>();
	private L list;
	
	public NotBrokenListProperty(L list) {
		
		this.list = list;
		
	}

	@Override
	public Object getBean() {
		return null;
	}

	@Override
	public String getName() {
		return "";
	}

	@Override
	public void addListener(ChangeListener changeListener) {
		listeners.add(changeListener);		
	}

	@Override
	public L getValue() {
		return list;
	}

	@Override
	public void removeListener(ChangeListener changeListener) {
		listeners.remove(changeListener);
	}

	@Override
	public void addListener(InvalidationListener invalidationListener) {
		invalidationListeners.add(invalidationListener);
	}

	@Override
	public void removeListener(InvalidationListener invalidationListener) {
		invalidationListeners.remove(invalidationListener);
	}

	@Override
	public void setValue(L list) {
		throw new UnsupportedOperationException("usupported until i figure out what to do with the listeners");
	}

	@Override
	public void bind(ObservableValue observableValue) {
		listeners.add((ov<T>, o, n)->{
			
		});
	}

	@Override
	public void bindBidirectional(Property property) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isBound() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void unbind() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unbindBidirectional(Property arg0) {
		// TODO Auto-generated method stub
		
	}

}
