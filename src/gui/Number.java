package gui;

import javafx.scene.text.Text;

public class Number extends Text {

	private NumberType type;
	
	public Number(String num, NumberType type) {
		this.type = type;
		textProperty().set(format(num));
	}
	
	private String format(String val) {
		switch (type) {
		case FLOATING_POINT:
			return "" + Double.parseDouble(val);
		case INTEGER:
			return "" + Long.parseLong(val);
		case PERCENT:
			return "" + Double.parseDouble(val) + "%";		
		}
		return "";
	}
	
	public void set(String val) {
		textProperty().set(format(val));
	}
	
	public String get() {
		return textProperty().get();
	}
	
	public static enum NumberType {
		INTEGER,
		FLOATING_POINT,
		PERCENT;
	}
	
}
