package com.fpl.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Loader {
	
	private List englishDic = new ArrayList();
	
	public Loader() {
		BufferedReader br = null;
		try {
			br = Files.newBufferedReader(Paths.get(getClass().getClassLoader().getResource("english.txt").toURI()));
			// read line by line
			String line;
			while ((line = br.readLine()) != null) {
				englishDic.add(line);
			}

		} catch (URISyntaxException e) {
			System.err.format("IOException: %s%n", e);
		} catch (IOException e) {
			System.err.format("IOException: %s%n", e);
		}
	}

	public List<String> getEnglishDic() {
		return englishDic;
	}
	

}
