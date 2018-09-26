package selem.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class readtextfile {

	public static List readline(String filepath) throws IOException {
		List<wordO> wordlist = new ArrayList<wordO>();
		
		
		BufferedReader br = new BufferedReader(new FileReader(filepath));
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();
		    
		    int i = 0;
		    while (line != null) {
		    	wordO wrdtmp = new wordO();
		        
		    	if(i == 0) {
		    		wrdtmp.setName(line);
		    		i++;
		    	}
		    	else if(i == 1) {
		    		wrdtmp.setShortdes(line);
		    		i = 0;
		    	}
		    	
		    	wordlist.add(wrdtmp);
		        line = br.readLine();
		    }
		} finally {
		    br.close();
		}
		
		return wordlist;
	}
	
	public static List read3line(String filepath) throws IOException {
		List<wordO> wordlist = new ArrayList<wordO>();
		
		
		BufferedReader br = new BufferedReader(new FileReader(filepath));
		try {
		    String line = br.readLine();
		    
		    int i = 0;
		    wordO atmp = new wordO();
		    
		    while (line != null) {
		    	
		    	if(i == 0) {
		    		atmp.setName(line);
		    		i++;
		    	}
		    	else if(i == 1) {
		    		atmp.setShortdes(line);
		    		i++;
		    	}
		    	else if(i == 2) {
		    		atmp.setExample(line);
		    		wordlist.add(atmp);
		    		atmp = new wordO();
		    		i = 0;
		    	}
		        line = br.readLine();
		    }
		} finally {
		    br.close();
		}
		
		return wordlist;
	}
}
