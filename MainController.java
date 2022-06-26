package application;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {

	@FXML
	Label nameLabel;
	static Label staticLabel;


	public static void main(String[] args) throws Exception{

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
	}
	public void applicationButtonClicked(String string) {
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
