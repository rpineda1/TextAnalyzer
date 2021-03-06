/**
 * This application reads a URL file then
 * isolates the top 20 words then prints them out in a new window
 * 
 * @author Ricardo Pineda
 * @version 1.0
 * @since 07/2/22
 */

package valencia.college.textanalyzer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

/**
 * JavaFX App
 */
public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
       // Opens and reads the url
		final String url =("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm");

		// Isolate the url to only read the poem
		Document doc = Jsoup.connect(url).get();
		Elements h1= doc.select("h1");
		Elements h3=doc.select("h3");
		Elements h4=doc.select("h4");
		Elements p=doc.select("p");

		// makes a string for the poem
		String poem = h1.text() + " " +  h3.text() + " " + h4.text() + " " + p.text();
		String[] words = poem.replaceAll("[^a-zA-Z ]", " ").toLowerCase().split("\\s+");
		List<String> wordList = Arrays.asList(words);

		/* creates a map of the words using the wordlist and assigning words a key which equals
		 * the amount of times its been used.
		 */
		Map<String, Long> map = wordList.stream()
				.collect(Collectors.groupingBy(e -> e, Collectors.counting()));


		// this orders the map and sorts it in descending order
		List<Map.Entry<String, Long>> result = map.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toList());


		// creates a list of the words in the map that are now order by greatest use to least
		String output = result.toString();

		String topwords[] = output.replaceAll("\\[|\\]|","").split("\\s+");
		List<String> foo = Arrays.asList(topwords);
		// printing the list
		System.out.println("Top 20 words in The Raven\n");
		for(int i = 0; i < 20 && i < foo.size(); i++){
			System.out.println(foo.get(i));
		}
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("primary.fxml"));
			Scene scene = new Scene(root,800,800);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
    /**
	 * the main method
	 * @param args
	 */
    public static void main(String[] args) {
        launch(args);
    }

}
