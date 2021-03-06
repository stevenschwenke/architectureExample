package de.schauderhaft.architecture.example.steven.server.jettyWebSocket;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Helper {

	public static Set<String> fillDictionary() throws IOException {
		Set<String> knownWords = new HashSet<String>();
		knownWords.addAll(readFile("ressource/dictionary/altamer.0"));
		knownWords.addAll(readFile("ressource/dictionary/altamer.1"));
		knownWords.addAll(readFile("ressource/dictionary/altamer.2"));
		knownWords.addAll(readFile("ressource/dictionary/american.0"));
		knownWords.addAll(readFile("ressource/dictionary/american.1"));
		knownWords.addAll(readFile("ressource/dictionary/american.2"));
		knownWords.addAll(readFile("ressource/dictionary/british.0"));
		knownWords.addAll(readFile("ressource/dictionary/british.1"));
		knownWords.addAll(readFile("ressource/dictionary/british.2"));
		knownWords.addAll(readFile("ressource/dictionary/english.0"));
		knownWords.addAll(readFile("ressource/dictionary/english.1"));
		knownWords.addAll(readFile("ressource/dictionary/english.2"));
		knownWords.addAll(readFile("ressource/dictionary/english.3"));

		return knownWords;
	}

	private static Set<String> readFile(String path) throws IOException {
		HashSet<String> set = new HashSet<String>();
		BufferedReader br = new BufferedReader(new FileReader(new File(path)));
		String line;
		while ((line = br.readLine()) != null) {
			set.add(line);
		}
		br.close();
		return set;
	}

}
