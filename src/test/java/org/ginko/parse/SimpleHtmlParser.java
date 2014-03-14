package org.ginko.parse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;

/**
 * @author Kyia
 */
public class SimpleHtmlParser {

	private static String baseUrl = "http://www.sec.gov/";
	private static String fileName = "0000018498-14-000009-index.htm";

	public static void main(String[] args) throws Exception {
		String filePath = getFilePath();
		File input = new File(filePath);
		Document doc = Jsoup.parse(input, "UTF-8", baseUrl);

		Elements tables = doc.getElementsByTag("table");
		for (Element table : tables) {
			if (table.attr("summary").equals("Document Format Files")) {
				// That is the table
				System.out.println(table);
			}
		}
	}

	private static String getFilePath() {
		String path = new File("").getAbsolutePath();
		path += File.separator + "webroot" +
				File.separator + "data" +
				File.separator + "sec" +
				File.separator + "html" +
				File.separator + "index" +
				File.separator + "20140313" +
				File.separator + fileName;

		return path;
	}
}
