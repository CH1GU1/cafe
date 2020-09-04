package cafe;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {



	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


		//reading input
		int n; 
		n = Integer.parseInt(br.readLine()); 

		for(int i=1; i<=n; i++) { 

			//Read Line
			String line = br.readLine();
			String[] yearsLine = line.split(" ");

			double[] values = new double[yearsLine.length];	

			//Casting values to double
			for (int j = 0; j < values.length; j++) {
				values[j] = Double.parseDouble(yearsLine[j]);
			}

			//Sorting 
			for (int k = values.length-1; k > 0; k--) {
				for (int j = 0; j < k; j++) {
					if(values[j] > values[j+1]) {
						double temp = values[j];
						values[j] = values[j+1];
						values[j+1] = temp;
					}
				}
			}

			//output
			String output = "";
			for (int l = 0; l < values.length; l++) {
				output += values[l] + " "; 
			}
			bw.write(output);
			bw.flush();
		}
	}
}
