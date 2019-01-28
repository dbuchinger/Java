import java.util.*;
import java.io.*;

public class Chatbot{
    private static String filename = "./WARC201709_wid.txt";
    private static int wordTypes = 4700;
    private static ArrayList<Integer> readCorpus(){
        ArrayList<Integer> corpus = new ArrayList<Integer>();
        try{
            File f = new File(filename);
            Scanner sc = new Scanner(f);
            while(sc.hasNext()){
                if(sc.hasNextInt()){
                    int i = sc.nextInt();
                    corpus.add(i);
                }
                else{
                    sc.next();
                }
            }
        }
        catch(FileNotFoundException ex){
            System.out.println("File Not Found.");
        }
        return corpus;
    }
    static public void main(String[] args){
        ArrayList<Integer> corpus = readCorpus();
		int flag = Integer.valueOf(args[0]);
        
        if(flag == 100){
			int w = Integer.valueOf(args[1]);
            int count = 0;
            // counts occurrences of w in corpus
            for (int i = 0; i < corpus.size(); i++) {
            	if (w == corpus.get(i)) {
            		count++;
            	}
            }
            
            System.out.println(count);
            System.out.println(String.format("%.7f",count/(double)corpus.size()));
        }
        else if(flag == 200){
            int n1 = Integer.valueOf(args[1]);
            int n2 = Integer.valueOf(args[2]);
            int count = 0;
            double p = 0;
            double r = ((double)(n1)) / ((double)(n2));  // "random" number
            double[] previous = {0, 0, 0};
            List<double[]> bounds = new ArrayList<double[]>();  // stores arrays of w's and their
            													// upper and lower bounds
            
            // count is incremented for every occurrence of w
            for (int i = 0; i < wordTypes; i++) {
            	count = 0;
            	double[] arr = {0, 0, 0};
            	for (int j = 0; j < corpus.size(); j++) {
            		if (i == corpus.get(j)) {
            			count++;
            		}
            	}
            	
            	// p is probability of count in corpus
            	p = count/(double)corpus.size();
            	if (i == 0) {
            		arr[0] = i;
            		arr[1] = 0;
            		arr[2] = p;
            	}
            	else {
            		previous = bounds.get(i-1);
            		arr[0] = i;
            		arr[1] = previous[2];
            		arr[2] = previous[2] + p;
            	}
            	if (p != 0) {
            		bounds.add(arr);
            	}
            }
            
            // output
            for (int i = 0; i < bounds.size(); i++) {
            	double[] check = bounds.get(i);
            	if ((r >= check[1]) && (r <= check[2])) {
            		for (int j = 0; j < check.length; j++) {
            			if (j == 0) {
            				System.out.println(String.format("%.0f",check[j]));
            			}
            			else {
            				System.out.println(String.format("%.7f",check[j]));
            			}
            		}
            	}
            }
        }
        else if(flag == 300){
            int h = Integer.valueOf(args[1]);
            int w = Integer.valueOf(args[2]);
            int count = 0;
            ArrayList<Integer> words_after_h = new ArrayList<Integer>();
            for (int i = 0; i < corpus.size(); i++) {
            	if (h == corpus.get(i)) {
            		words_after_h.add(corpus.get(i + 1));
            	}
            }
            for (int i = 0; i < corpus.size(); i++) {
            	if (h == corpus.get(i)) {
            		if ((i + 1) < corpus.size()) {
            			if ((corpus.get(i + 1)) == w) {
            				count++;
            			}
            		}
            	}
            }

            //output
            System.out.println(count);
            System.out.println(words_after_h.size());
            System.out.println(String.format("%.7f",count/(double)words_after_h.size()));
        }
        else if(flag == 400){
            int n1 = Integer.valueOf(args[1]);
            int n2 = Integer.valueOf(args[2]);
            int h = Integer.valueOf(args[3]);
            int count = 0;
            int hCount = 0;
            double p = 0;
            double r = ((double)(n1)) / ((double)(n2));
            double[] previous = {0, 0, 0};
            List<double[]> bounds = new ArrayList<double[]>();
            
            for (int i = 0; i < corpus.size(); i++) {
            	if (h == corpus.get(i)) {
            		hCount++;
            	}
            }
            for (int i = 0; i < wordTypes; i++) {
            	count = 0;
            	double[] arr = {0, 0, 0};
            	for (int j = 0; j < corpus.size(); j++) {
            		if ((i == corpus.get(j)) && (j != 0)) {
            			if (corpus.get(j - 1) == h) {
            				count++;
            			}
            		}
            	}
            	p = ((double)(count)) / ((double)(hCount));
            
            	if (bounds.size() == 0) {
            		arr[0] = i;
            		arr[1] = 0;
            		arr[2] = p;
            	}
            	else {
            		previous = bounds.get(bounds.size() - 1);
            		arr[0] = i;
            		arr[1] = previous[2];
            		arr[2] = previous[2] + p;
            	}
            	if (p != 0) {
            		bounds.add(arr);
            	}
            }
            for (int i = 0; i < bounds.size(); i++) {
            	double[] check = bounds.get(i);
            	if ((r >= check[1]) && (r <= check[2])) {
            		for (int j = 0; j < check.length; j++) {
            			if (j == 0) {
            				System.out.println(String.format("%.0f",check[j]));
            			}
            			else {
            				System.out.println(String.format("%.7f",check[j]));
            			}
            		}
            	}
            }
            
        }
        else if(flag == 500){
            int h1 = Integer.valueOf(args[1]);
            int h2 = Integer.valueOf(args[2]);
            int w = Integer.valueOf(args[3]);
            int count = 0;
            ArrayList<Integer> words_after_h1h2 = new ArrayList<Integer>();
            
            for (int i = 0; i < corpus.size(); i++) {
            	if ((h2 == corpus.get(i)) && (i > 0)) {
            		if ((h1 == corpus.get(i - 1)) && (i < (corpus.size() - 1))) {
            			words_after_h1h2.add(corpus.get(i + 1));
            		}
            	}
            }
            for (int j = 0; j < corpus.size(); j++) {
            	if ((w == corpus.get(j)) && (j > 1)) {
            		if ((corpus.get(j - 2) == h1) && (corpus.get(j - 1) == h2)) {
            			count++;
            		}
            	}
            }
            //output 
            System.out.println(count);
            System.out.println(words_after_h1h2.size());
            if(words_after_h1h2.size() == 0)
                System.out.println("undefined");
            else
                System.out.println(String.format("%.7f",count/(double)words_after_h1h2.size()));
        }
        else if(flag == 600){
            int n1 = Integer.valueOf(args[1]);
            int n2 = Integer.valueOf(args[2]);
            int h1 = Integer.valueOf(args[3]);
            int h2 = Integer.valueOf(args[4]);
            int count = 0;
            int hCount = 0;
            double p = 0;
            double r = ((double)(n1)) / ((double)(n2));
            double[] previous = {0, 0, 0};
            List<double[]> bounds = new ArrayList<double[]>();
            
            for (int i = 0; i < corpus.size(); i++) {
            	if ((h2 == corpus.get(i)) && (i > 0)) {
            		if ((h1 == corpus.get(i - 1)) && (i < (corpus.size() - 1))) {
            			hCount++;
            		}
            	}
            }
            for (int i = 0; i < wordTypes; i++) {
            	count = 0;
            	double[] arr = {0, 0, 0};
            	for (int j = 0; j < corpus.size(); j++) {
            		if ((i == corpus.get(j)) && (j != 0)) {
            			if ((corpus.get(j - 1) == h2) && (corpus.get(j - 2) == h1)) {
            				count++;
            			}
            		}
            	}
            	p = ((double)(count)) / ((double)(hCount));
            
            	if (bounds.size() == 0) {
            		arr[0] = i;
            		arr[1] = 0;
            		arr[2] = p;
            	}
            	else {
            		previous = bounds.get(bounds.size() - 1);
            		arr[0] = i;
            		arr[1] = previous[2];
            		arr[2] = previous[2] + p;
            	}
            	if (p != 0) {
            		bounds.add(arr);
            	}
            }
            for (int i = 0; i < bounds.size(); i++) {
            	double[] check = bounds.get(i);
            	if ((r >= check[1]) && (r <= check[2])) {
            		for (int j = 0; j < check.length; j++) {
            			if (j == 0) {
            				System.out.println(String.format("%.0f",check[j]));
            			}
            			else {
            				System.out.println(String.format("%.7f",check[j]));
            			}
            		}
            	}
            }
            System.out.println("undefined");
        }
        else if(flag == 700){
            int seed = Integer.valueOf(args[1]);
            int t = Integer.valueOf(args[2]);
            int h1=0,h2=0;

            Random rng = new Random();
            if (seed != -1) rng.setSeed(seed);

            if(t == 0){
                // TODO Generate first word using r
                double r = rng.nextDouble();
                double[] previous = {0, 0, 0};
                int count = 0;
                double p = 0;
                List<double[]> bounds = new ArrayList<double[]>();  // stores arrays of w's and their
                													// upper and lower bounds
                
                // count is incremented for every occurrence of w
                for (int i = 0; i < wordTypes; i++) {
                	count = 0;
                	double[] arr = {0, 0, 0};
                	for (int j = 0; j < corpus.size(); j++) {
                		if (i == corpus.get(j)) {
                			count++;
                		}
                	}
                	
                	// p is probability of count in corpus
                	p = (double)(count)/(double)corpus.size();
                	if (i == 0) {
                		arr[0] = i;
                		arr[1] = 0;
                		arr[2] = p;
                	}
                	else {
                		previous = bounds.get(i-1);
                		arr[0] = i;
                		arr[1] = previous[2];
                		arr[2] = previous[2] + p;
                	}
                	if (p != 0) {
                		bounds.add(arr);
                	}
                }
                
                for (int i = 0; i < bounds.size(); i++) {
                	double[] check = bounds.get(i);
                	if ((r >= check[1]) && (r <= check[2])) {
                		h1 = (int) check[0];
                	}
                }
                System.out.println(h1);
                if(h1 == 9 || h1 == 10 || h1 == 12){
                    return;
                }
                
                // TODO Generate second word using r
                r = rng.nextDouble();
                count = 0;
                int hCount = 0;
                p = 0;
                for (int i = 0; i < previous.length; i++) {
                	previous[i] = 0;
                }
                List<double[]> bounds2 = new ArrayList<double[]>();
                
                for (int i = 0; i < corpus.size(); i++) {
                	if (h1 == corpus.get(i)) {
                		hCount++;
                	}
                }
                for (int i = 0; i < wordTypes; i++) {
                	count = 0;
                	double[] arr = {0, 0, 0};
                	for (int j = 0; j < corpus.size(); j++) {
                		if ((i == corpus.get(j)) && (j != 0)) {
                			if (corpus.get(j - 1) == h1) {
                				count++;
                			}
                		}
                	}
                	p = ((double)(count)) / ((double)(hCount));
                
                	if (bounds2.size() == 0) {
                		arr[0] = i;
                		arr[1] = 0;
                		arr[2] = p;
                	}
                	else {
                		previous = bounds2.get(bounds2.size() - 1);
                		arr[0] = i;
                		arr[1] = previous[2];
                		arr[2] = previous[2] + p;
                	}
                	if (p != 0) {
                		bounds2.add(arr);
                	}
                }
                for (int i = 0; i < bounds2.size(); i++) {
                	double[] check = bounds2.get(i);
                	if ((r >= check[1]) && (r <= check[2])) {
                		h2 = (int) check[0];
                	}
                }
                System.out.println(h2);
            }
            else if(t == 1){
                h1 = Integer.valueOf(args[3]);
                // TODO Generate second word using r
                double r = rng.nextDouble();
                int count = 0;
                int hCount = 0;
                double p = 0;
                double[] previous = {0, 0, 0};
                List<double[]> bounds = new ArrayList<double[]>();
                
                for (int i = 0; i < corpus.size(); i++) {
                	if (h1 == corpus.get(i)) {
                		hCount++;
                	}
                }
                for (int i = 0; i < wordTypes; i++) {
                	count = 0;
                	double[] arr = {0, 0, 0};
                	for (int j = 0; j < corpus.size(); j++) {
                		if ((i == corpus.get(j)) && (j != 0)) {
                			if (corpus.get(j - 1) == h1) {
                				count++;
                			}
                		}
                	}
                	p = ((double)(count)) / ((double)(hCount));
                
                	if (bounds.size() == 0) {
                		arr[0] = i;
                		arr[1] = 0;
                		arr[2] = p;
                	}
                	else {
                		previous = bounds.get(bounds.size() - 1);
                		arr[0] = i;
                		arr[1] = previous[2];
                		arr[2] = previous[2] + p;
                	}
                	if (p != 0) {
                		bounds.add(arr);
                	}
                }
                for (int i = 0; i < bounds.size(); i++) {
                	double[] check = bounds.get(i);
                	if ((r >= check[1]) && (r <= check[2])) {
                		h2 = (int) check[0];
                	}
                }
                System.out.println(h2);
            }
            else if(t == 2){
                h1 = Integer.valueOf(args[3]);
                h2 = Integer.valueOf(args[4]);
            }

            while(h2 != 9 && h2 != 10 && h2 != 12){
                double r = rng.nextDouble();
                int w  = 0;
                int count = 0;
                int hCount = 0;
                double p = 0;
                double[] previous = {0, 0, 0};
                List<double[]> bounds = new ArrayList<double[]>();
                
                for (int i = 0; i < corpus.size(); i++) {
                	if ((h2 == corpus.get(i)) && (i > 0)) {
                		if ((h1 == corpus.get(i - 1)) && (i < (corpus.size() - 1))) {
                			hCount++;
                		}
                	}
                }
                for (int i = 0; i < wordTypes; i++) {
                	count = 0;
                	double[] arr = {0, 0, 0};
                	for (int j = 0; j < corpus.size(); j++) {
                		if ((i == corpus.get(j)) && (j != 0)) {
                			if ((corpus.get(j - 1) == h2) && (corpus.get(j - 2) == h1)) {
                				count++;
                			}
                		}
                	}
                	p = ((double)(count)) / ((double)(hCount));
                
                	if (bounds.size() == 0) {
                		arr[0] = i;
                		arr[1] = 0;
                		arr[2] = p;
                	}
                	else {
                		previous = bounds.get(bounds.size() - 1);
                		arr[0] = i;
                		arr[1] = previous[2];
                		arr[2] = previous[2] + p;
                	}
                	if (p != 0) {
                		bounds.add(arr);
                	}
                }
                for (int i = 0; i < bounds.size(); i++) {
                	double[] check = bounds.get(i);
                	if ((r >= check[1]) && (r <= check[2])) {
                		w = (int) check[0];
                	}
                }
                System.out.println(w);
                h1 = h2;
                h2 = w;
            }
        }

        return;
    }
}