
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


public class HelloWorld {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		MaxentTagger tagger = new MaxentTagger("taggers\\english-bidirectional-distsim.tagger");
		ArrayList<String[] > al = new ArrayList<String[] >(); 
		List<String> results = new ArrayList<String>();
		
		//Change directoryPath to an absolute path towards a specific folder that you would like to go through, such as 
		String directoryPath = "C:\\Users\\TestUser\\Desktop\\Folder";
		
		directoryPath += "\\";
		File[] files = new File(directoryPath).listFiles();
		//If this pathname does not denote a directory, then listFiles() returns null. 
		for (File file : files) {
		    if (file.isFile()) {
		        results.add(file.getName());
		    }
		}
		for(int i = 0; i < results.size(); i++) {
			al.add(getProject(directoryPath + results.get(i)));
		}
		
		for (int j = 0; j < results.size(); j++){
			System.out.println(results.get(j));
		}
		
		//Now, we have all of the data, now what we have to do is go through all of the sentences in the data and find the average amount of words
		//that are specific POS
		
		//Activate the tagger by doing tagger.tagString(string);
		//Output is to a string, printable, with formatting like "This/DT is/VBZ sample/NN text/NN"
		
		int wordCount = 0;
		
		int lastIndex = 0, noun = 0, coordinatingConjunction = 0, cardinalNumber = 0, determiner = 0, existentialThere = 0, foreignWord = 0;
		int subordinatingConjunction = 0, subordinator = 0, adjective = 0, comparativeAdjective = 0, superlativeAdjective = 0, listMarker = 0, modal = 0;
		int nounPlural = 0, nounProper = 0, nounPluralProper = 0, predeterminer = 0, posessiveEnding = 0, personalPronoun = 0, possessivePronoun = 0, adverb = 0;
		int comparativeAdverb = 0, superlativeAdverb = 0, particle = 0, punctiation = 0, symbol = 0, infinitiveTo = 0, interjection = 0, verbBeBase = 0;
		int verbBePast = 0, verbBePresentPart = 0, verbBePastPart = 0, verbBePresnon3d = 0, verbBePres3d = 0, whDeterminer = 0, whPronoun = 0;
		int possesiveWhPronoun = 0, whAdverb = 0, comma = 0, predicatePronoun = 0;
		ArrayList<String[] > ar = new ArrayList<String[] >();
		ArrayList<String[] > ARR = new ArrayList<String[] >();
		for (int k = 0; k < al.size(); k++) {
			String sampleString = al.get(k)[1];
			sampleString += ".";
			System.out.println("Tagging started");
			String taggedSampleString = "";
			try {
				taggedSampleString = tagger.tagString(sampleString);
			} catch (OutOfMemoryError e) {
				e.printStackTrace();
				System.out.println("Error occured during initial tagging: skipping...");
				k++;
				sampleString = al.get(k)[1];
				sampleString += ".";
				taggedSampleString = tagger.tagString(sampleString);
			}
			System.out.println("Tagging finished");
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/,",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/,".length());
			    	comma ++;
			        lastIndex += "/,".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("//",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "//".length());
			        lastIndex += "//".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/-",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/-".length());
			        lastIndex += "/-".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/:",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/:".length());
			        lastIndex += "/:".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/(",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/(".length());
			        lastIndex += "/(".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/)",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/)".length());
			        lastIndex += "/)".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/_",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/_".length());
			        lastIndex += "/_".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/&",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/&".length());
			        lastIndex += "/&".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/$",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/$".length());
			        lastIndex += "/$".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/;",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/;".length());
			        lastIndex += "/;".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/.",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/.".length());
			        lastIndex += "/.".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/. ",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/. ".length());
			        lastIndex += "/. ".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/`",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/`".length());
			    	lastIndex += "/`".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/``",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/``".length());
			    	lastIndex += "/``".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/'",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/'".length());
			    	lastIndex += "/'".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/''",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/''".length());
			    	lastIndex += "/''".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/\"\"",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/\"\"".length());
			    	lastIndex += "/\"\"".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/\"",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/\"".length());
			    	lastIndex += "/\"".length();
			    }
			}
			System.out.println("Done with punctiation");
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/NNS",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/NNS".length());
			    	nounPlural ++;
			    	wordCount ++;
			        lastIndex += "/NNS".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/NN",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/NN".length());
			    	noun ++;
			    	wordCount ++;
			        lastIndex += "/NN".length();
			    }
			}
			System.out.println("Nouns done.");
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/CC",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/CC".length());
			    	coordinatingConjunction ++;
			    	wordCount ++;
			        lastIndex += "/CC".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/CD",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/CD".length());
			    	cardinalNumber ++;
			    	wordCount ++;
			        lastIndex += "/CD".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/DT",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/DT".length());
			    	determiner ++;
			    	wordCount ++;
			        lastIndex += "/DT".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/EX",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/EX".length());
			    	existentialThere ++;
			    	wordCount ++;
			        lastIndex += "/EX".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/FW",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/FW".length());
			    	foreignWord ++;
			    	wordCount ++;
			        lastIndex += "/FW".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/IN/that",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/IN/that".length());
			    	subordinator ++;
			    	wordCount ++;
			        lastIndex += "/IN/that".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/IN",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/IN".length());
			    	subordinatingConjunction ++;
			    	wordCount ++;
			        lastIndex += "/IN".length();
			    }
			}
			System.out.println("Extraneous stuff done.");
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/JJR",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/JJR".length());
			    	comparativeAdjective ++;
			    	wordCount ++;
			        lastIndex += "/JJR".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/JJS",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/JJS".length());
			    	superlativeAdjective ++;
			    	wordCount ++;
			        lastIndex += "/JJS".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/JJ",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/JJ".length());
			    	adjective ++;
			    	wordCount ++;
			        lastIndex += "/JJ".length();
			    }
			}
			System.out.println("Adjectives done.");
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/LS",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/LS".length());
			    	listMarker ++;
			    	wordCount ++;
			        lastIndex += "/LS".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/MD",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/MD".length());
			    	modal ++;
			    	wordCount ++;
			        lastIndex += "/MD".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/NPS",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/NPS".length());
			    	nounPluralProper ++;
			    	wordCount ++;
			        lastIndex += "/NPS".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/NP",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/NP".length());
			    	nounProper ++;
			    	wordCount ++;
			        lastIndex += "/NP".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/PDT",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/PDT".length());
			    	predeterminer ++;
			    	wordCount ++;
			        lastIndex += "/PDT".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/POS",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/POS".length());
			    	posessiveEnding ++;
			    	wordCount ++;
			        lastIndex += "/POS".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/PPZ",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/PPZ".length());
			    	possessivePronoun ++;
			    	wordCount ++;
			        lastIndex += "/PPZ".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/PP",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/PP".length());
			    	personalPronoun ++;
			    	wordCount ++;
			        lastIndex += "/PP".length();
			    }
			}
			System.out.println("Pronouns done.");
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/RBR",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/RBR".length());
			    	comparativeAdverb ++;
			    	wordCount ++;
			        lastIndex += "/RBR".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/RBS",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/RBS".length());
			    	superlativeAdverb ++;
			    	wordCount ++;
			        lastIndex += "/RBS".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/RB",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/RB".length());
			    	adverb ++;
			    	wordCount ++;
			        lastIndex += "/RB".length();
			    }
			}
			System.out.println("Adverbs done.");
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/RP",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/RP".length());
			    	particle ++;
			    	wordCount ++;
			        lastIndex += "/RP".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/SENT",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/SENT".length());
			    	punctiation ++;
			    	wordCount ++;
			        lastIndex += "/SENT".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/SYM",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/SYM".length());
			    	symbol ++;
			    	wordCount ++;
			        lastIndex += "/SYM".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/TO",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/TO".length());
			    	infinitiveTo ++;
			    	wordCount ++;
			        lastIndex += "/TO".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/UH",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/UH".length());
			    	interjection ++;
			    	wordCount ++;
			        lastIndex += "/UH".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/VBD",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/VBD".length());
			    	verbBePast ++;
			    	wordCount ++;
			        lastIndex += "/VBD".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/VBG",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/VBG".length());
			    	verbBePresentPart ++;
			    	wordCount ++;
			        lastIndex += "/VBG".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/VBN",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/VBN".length());
			    	verbBePastPart ++;
			    	wordCount ++;
			        lastIndex += "/VBN".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/VBP",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/VBP".length());
			    	verbBePresnon3d ++;
			    	wordCount ++;
			        lastIndex += "/VBP".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/VBZ",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/VBZ".length());
			    	verbBePres3d ++;
			    	wordCount ++;
			        lastIndex += "/VBZ".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/VB",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/VB".length());
			    	verbBeBase ++;
			    	wordCount ++;
			        lastIndex += "/VB".length();
			    }
			}
			System.out.println("Verbs are done.");
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/WDT",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/WDT".length());
			    	whDeterminer ++;
			    	wordCount ++;
			        lastIndex += "/WDT".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/WP$",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/WP$".length());
			    	possesiveWhPronoun ++;
			    	wordCount ++;
			        lastIndex += "/WP$".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/WP",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/WP".length());
			    	whPronoun ++;
			    	wordCount ++;
			        lastIndex += "/WP".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/WRB",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/WRB".length());
			    	whAdverb ++;
			    	wordCount ++;
			        lastIndex += "/WRB".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/PRP$",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/PRP$".length());
			        possessivePronoun ++;
			        wordCount ++;
			    	lastIndex += "/PRP$".length();
			    }
			}
			lastIndex = 0;
			while(lastIndex != -1){
			    lastIndex = taggedSampleString.indexOf("/PRP",lastIndex);
			    if(lastIndex != -1){
			    	taggedSampleString = taggedSampleString.substring(0, lastIndex) + taggedSampleString.substring(lastIndex + "/PRP".length());
			        predicatePronoun ++;
			        wordCount ++;
			    	lastIndex += "/PRP".length();
			    }
			}
			System.out.println("Done with cutting");
			int testIndex = 0;
			while (testIndex != -1) {
				testIndex = taggedSampleString.indexOf("/", testIndex);
				int spaceIndex = taggedSampleString.indexOf(" ", testIndex);
				//System.out.println(testIndex);
				if (testIndex != -1) {
					String check = taggedSampleString.substring(testIndex, spaceIndex);
					check.trim();
					
					if (check.length() > 2){
						if (check == "/NN" || check == "/FW" || check == "/CD" || check == "/RB" || check == "/NNP" || check == "/PRP" || check == "/PRP$" || check == "/DT") {
							System.out.println("Previous value added");
							if (check == "/NN") {
								noun ++;
							} else if (check == "/FW") {
								foreignWord ++;
							} else if (check == "/CD") {
								cardinalNumber ++;
							} else if (check == "/RB") {
								adverb ++;
							} else if (check == "/NNP") {
								nounProper ++;
							} else if (check == "/PRP") {
								predicatePronoun ++;
							} else if (check == "/PRP$") {
								possessivePronoun ++;
							} else if (check == "/DT") {
								determiner ++;
							}
						} else {
							System.out.println("New value added");
							for (int j = 0; j < ar.size(); j++) {
								if (check == ar.get(j)[0]) {
									ar.get(j)[1] = Integer.toString((Integer.parseInt(ar.get(j)[1]) + 1));
								} else {
									ar.get(j)[0] = check;
									ar.get(j)[1] = "0";
								}
							}
						}
					}
					
					testIndex += check.length();
				}
			}
			
			String[] pingas = new String[38];
			pingas[0] = Integer.toString(noun);
			pingas[1] = Integer.toString(coordinatingConjunction);
			pingas[2] = Integer.toString(cardinalNumber);
			pingas[3] = Integer.toString(determiner);
			pingas[4] = Integer.toString(existentialThere);
			pingas[5] = Integer.toString(foreignWord);
			pingas[6] = Integer.toString(subordinatingConjunction);
			pingas[7] = Integer.toString(subordinator);
			pingas[8] = Integer.toString(adjective);
			pingas[9] = Integer.toString(comparativeAdjective);
			pingas[10] = Integer.toString(superlativeAdjective);
			pingas[11] = Integer.toString(listMarker);
			pingas[12] = Integer.toString(modal);
			pingas[13] = Integer.toString(nounPlural);
			pingas[14] = Integer.toString(nounProper);
			pingas[15] = Integer.toString(nounPluralProper);
			pingas[16] = Integer.toString(predeterminer);
			pingas[17] = Integer.toString(posessiveEnding);
			pingas[18] = Integer.toString(personalPronoun);
			pingas[19] = Integer.toString(possessivePronoun);
			pingas[20] = Integer.toString(adverb);
			pingas[21] = Integer.toString(comparativeAdverb);
			pingas[22] = Integer.toString(superlativeAdverb);
			pingas[23] = Integer.toString(particle);
			pingas[24] = Integer.toString(infinitiveTo);
			pingas[25] = Integer.toString(interjection);
			pingas[26] = Integer.toString(verbBeBase);
			pingas[27] = Integer.toString(verbBePast);
			pingas[28] = Integer.toString(verbBePresentPart);
			pingas[29] = Integer.toString(verbBePastPart);
			pingas[30] = Integer.toString(verbBePresnon3d);
			pingas[31] = Integer.toString(verbBePres3d);
			pingas[32] = Integer.toString(whDeterminer);
			pingas[33] = Integer.toString(whPronoun);
			pingas[34] = Integer.toString(possesiveWhPronoun);
			pingas[35] = Integer.toString(whAdverb);
			pingas[36] = Integer.toString(predicatePronoun);
			pingas[37] = al.get(k)[0];
			
			noun = 0;
			coordinatingConjunction = 0;
			cardinalNumber = 0;
			determiner = 0;
			existentialThere = 0;
			foreignWord = 0;
			subordinatingConjunction = 0;
			subordinator = 0;
			adjective = 0;
			comparativeAdjective = 0;
			superlativeAdjective = 0;
			listMarker = 0;
			modal = 0;
			nounPlural = 0;
			nounProper = 0;
			nounPluralProper = 0;
			predeterminer = 0;
			posessiveEnding = 0;
			personalPronoun = 0;
			possessivePronoun = 0;
			adverb = 0;
			comparativeAdverb = 0;
			superlativeAdverb = 0;
			particle = 0;
			punctiation = 0;
			symbol = 0;
			infinitiveTo = 0;
			interjection = 0;
			verbBeBase = 0;
			verbBePast = 0;
			verbBePresentPart = 0;
			verbBePastPart = 0;
			verbBePresnon3d = 0;
			verbBePres3d = 0;
			whDeterminer = 0;
			whPronoun = 0;
			possesiveWhPronoun = 0;
			whAdverb = 0;
			comma = 0;
			predicatePronoun = 0;
			
			ARR.add(pingas);
			System.out.println(pingas[37]);
			//awenfioajweiofjaiowejfioawjeiofjawe
			System.out.println("Done with " + (k+1) + "/" + al.size() + " texts.");
		}
		
		System.out.println("Scanning done");
		System.out.println("Word Count: " + wordCount);
		System.out.println("Analytics:");
		System.out.println("--------------------------");
		System.out.println("Adjectives:");
		System.out.println("Base Adjectives: " + adjective);
		System.out.println("Comparative Adjectives: " + comparativeAdjective);
		System.out.println("Superlative Adjectives: " + superlativeAdjective);
		System.out.println("--------------------------");
		System.out.println("Nouns:");
		System.out.println("Base Nouns: " + noun);
		System.out.println("Plural Nouns: " + nounPlural);
		System.out.println("Singular Proper Nouns: " + nounProper);
		System.out.println("Plural Proper Nouns: " + nounPluralProper);
		System.out.println("--------------------------");
		System.out.println("Pronouns:");
		System.out.println("Personal Pronouns: " + personalPronoun);
		System.out.println("Possessive Pronouns: " + possessivePronoun);
		System.out.println("Wh-Pronouns: " + whPronoun);
		System.out.println("Possessive Wh-Pronouns: " + possesiveWhPronoun);
		System.out.println("Predicate Pronouns: " + predicatePronoun);
		System.out.println("--------------------------");
		System.out.println("Adverbs:");
		System.out.println("Base Adverbs: " + adverb);
		System.out.println("Comparative Adverbs: " + comparativeAdverb);
		System.out.println("Superlative Adverbs: " + superlativeAdverb);
		System.out.println("Wh-Adverbs: " + whAdverb);
		System.out.println("--------------------------");
		System.out.println("Verbs:");
		System.out.println("Base Verb: " + verbBeBase);
		System.out.println("Verb Past Tense: " + verbBePast);
		System.out.println("Verb Past Participle: " + verbBePastPart);
		System.out.println("Verb Present Participle: " + verbBePresentPart);
		System.out.println("Verb Present Non-3d: " + verbBePresnon3d);
		System.out.println("Verb Present 3d: " + verbBePres3d);
		System.out.println("--------------------------");
		System.out.println("Misc:");
		System.out.println("Coodinating Conjunctions: " + coordinatingConjunction);
		System.out.println("Cardinal Numbers: " + cardinalNumber);
		System.out.println("Determiners: " + determiner);
		System.out.println("Existential Theres: " + existentialThere);
		System.out.println("Foreign Words: " + foreignWord);
		System.out.println("Subordinating Conjunctions: " + subordinatingConjunction);
		System.out.println("That as a Subordinator: " + subordinator);
		System.out.println("List Markers: " + listMarker);
		System.out.println("Modals: " + modal);
		System.out.println("Predeterminers: " + predeterminer);
		System.out.println("Possessive Endings: " + posessiveEnding);
		System.out.println("Particles: " + particle);
		System.out.println("Punctuations: " + punctiation);
		System.out.println("Symbols: " + symbol);
		System.out.println("Infinitive To: " + infinitiveTo);
		System.out.println("Interjections: " + interjection);
		System.out.println("Wh-Determiner: " + whDeterminer);
		System.out.println("Commas: " + comma);
		//FOR THE MISCELLANEOUS TAGS
		for(int i = 0; i < ar.size(); i++) {
			System.out.println(ar.get(i)[0]);
			System.out.println(ar.get(i)[1]);
		}
		
		try {			
			//Last thing to make this work on your computer, change the line below towards a specific .csv file
			FileWriter csvWriter = new FileWriter("\\Users\\TestUser\\Desktop\\Folder\\NewResults.csv");			
			for (int i = 0; i < ARR.size(); i++) {
				for (int j = 0; j < ARR.get(i).length; j++) {
					csvWriter.append(ARR.get(i)[j]);
					if (j != ARR.get(i).length-1) {
						csvWriter.append(", ");
					}
				}
				csvWriter.append("\n");
			}
			
			csvWriter.flush();
			csvWriter.close();
		} catch (Exception e) {
			System.out.println(e + "ERROR IN WRITING FILE.");
		}
	}
	
	public static String[] getProject(String filePath) {
		String everything = "";
		String[] arr = new String[3];
		try(BufferedReader br = new BufferedReader(new FileReader(filePath, StandardCharsets.UTF_8))) {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    everything = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error with bufferedreader");
		}
		
		try {
			everything = everything.substring(everything.indexOf("***"), everything.indexOf("*** END"));
		} catch (Exception e) {
			try{
				everything = everything.substring(everything.indexOf("***"), everything.indexOf("***END"));
			} catch (Exception g) {
				try {
					everything = everything.substring(everything.indexOf("***"), everything.indexOf("This file should be named"));
				} catch (Exception f) {
					everything = everything;
					f.printStackTrace();
				}
			}
		}
		int total = everything.length();
		
		arr[0] = filePath;
		arr[1] = everything;
		arr[2] = Integer.toString(total);
		
		return arr;
	}
}