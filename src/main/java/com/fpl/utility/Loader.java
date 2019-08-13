package com.fpl.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Loader {
	
	private List<String> englishDic = new ArrayList<String>();
	
	public Loader() {
		BufferedReader br = null;
		try (
			br = Files.newBufferedReader(Paths.get(getClass().getClassLoader().getResource("english.txt").toURI()));
			// read line by line
			String line;
			while ((line = br.readLine()) != null) {
				englishDic.add(line);
			}

		} catch (IOException | URISyntaxException e) {
			System.err.format("IOException: %s%n", e);
		} finally {
			br.close();
		}
	}

	public List<String> getEnglishDic() {
		return englishDic;
	}
	

}
