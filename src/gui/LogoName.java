package gui;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class LogoName extends Pane{

	private Text name;
	private ImageView logo;
	
	public LogoName(Image logo, String name) {
		
		this.name = new Text(name);
		this.logo = new ImageView(logo);
		
		HBox hbox = new HBox();
		hbox.getChildren().add(this.logo);
		hbox.getChildren().add(this.name);
		
		getChildren().add(hbox);
		setPadding(new Insets(2, 20, 2, 0));
	}
	
}
