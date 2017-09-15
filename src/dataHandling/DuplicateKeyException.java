package dataHandling;

public class DuplicateKeyException extends Exception {

	private static final long serialVersionUID = 5095645634603288115L;

	public DuplicateKeyException(String key) {
		super("Key \"" + key + "\" is already used");
	}
	
}
