package valencia.college.textanalyzer;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PrimaryController {

    @FXML
    Label nameLabel;
	static Label staticLabel;

	public void applicationButtonClicked() {
		String foo = "Top 20 words in The Raven\r\n"
				+ "\r\n"
				+ "the=57,\r\n"
				+ "and=38,\r\n"
				+ "i=32,\r\n"
				+ "my=24,\r\n"
				+ "of=22,\r\n"
				+ "that=18,\r\n"
				+ "this=16,\r\n"
				+ "a=15,\r\n"
				+ "door=14,\r\n"
				+ "is=11,\r\n"
				+ "raven=11,\r\n"
				+ "nevermore=11,\r\n"
				+ "chamber=11,\r\n"
				+ "bird=10,\r\n"
				+ "on=10,\r\n"
				+ "me=9,\r\n"
				+ "at=8,\r\n"
				+ "with=8,\r\n"
				+ "or=8,\r\n"
				+ "then=8," ;
		nameLabel.setText(foo);
	}
}
