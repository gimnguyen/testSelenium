package selem.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class newtest {

	public static void main(String[] args) throws ClassNotFoundException {
		//			connecttomysql.connmysql("aaa","aa","aaa","aa","aa","aa","aa");
//					try {
//						connecttomysql.connmysql("aaa","aa","aaa","aa","aa","aa","aa");
//					} catch (InstantiationException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					} catch (IllegalAccessException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
		
		
				System.setProperty(
						"webdriver.chrome.driver",
						"D:/chromedriver/chromedriver.exe");

				WebDriver webDriver = new ChromeDriver();

				// Setting the browser size
//				webDriver.manage().window().setSize(new Dimension(1024, 768));
				
				String baseUrl = "https://dictionary.cambridge.org/dictionary/english/";
				
				try {
					List<wordO> wordlist = new ArrayList<wordO>();
					wordlist = 	readtextfile.read3line("C:\\Users\\quangnv12\\eclipse-workspace\\test\\src\\data\\wordlist.txt");
					
					for (wordO indwO : wordlist) {
						
						System.out.println("name: " + indwO.getName().trim());
						
						webDriver.navigate().to(baseUrl + indwO.getName().trim());
						
						// Type in the search-field: "WebDriver"
						List<WebElement> wtype = new ArrayList<WebElement>();
						wtype = webDriver.findElements(By.className("pos"));
						
						
						List<WebElement> spelling = new ArrayList<WebElement>();
						spelling = webDriver.findElements(By.className("ipa"));
						
						List<WebElement> audio = new ArrayList<WebElement>();
						audio = webDriver.findElements(By.className("audio_play_button"));
						
						List<WebElement> example = new ArrayList<WebElement>();
						example = webDriver.findElements(By.className("eg"));
						
						indwO.setWtype(wtype.get(0).getText());
						indwO.setSpelling(spelling.get(0).getText());
						indwO.setMp3url(audio.get(1).getAttribute("data-src-mp3"));
						indwO.setOggurl(audio.get(1).getAttribute("data-src-ogg"));
//						indwO.setExample(example.get(0).getText());
						
						System.out.println("aaa: " + indwO.getSpelling());
						
						try {
							connecttomysql.connmysql(indwO.getName(), indwO.getMp3url(), indwO.getOggurl(), indwO.getSpelling(), indwO.getWtype(), indwO.getShortdes(), indwO.getExample());
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InstantiationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}

					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				// Waiting a little bit before closing
//				Thread.sleep(7000);

				// Closing the browser and webdriver
				webDriver.close();
				webDriver.quit();

	}

}

