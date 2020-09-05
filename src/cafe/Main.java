package cafe;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
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
			String line = "";
			line = br.readLine();
			String[] yearsLine = line.split(" ");

			double[] values = new double[yearsLine.length];	

			//Casting values to double
			for (int j = 0; j < values.length; j++) {
				values[j] = Double.parseDouble(yearsLine[j]);
			}

			//Sorting 
			int count = 0;
			int[] timing = new int[values.length-1];
			for (int k = values.length-1; k > 0; k--) {
				for (int j = 0; j < k; j++) {
					if(values[j] > values[j+1]) {
						double temp = values[j];
						values[j] = values[j+1];
						values[j+1] = temp;
						count++;
					}
				}
				timing[k-1] = count;
				count = 0;
			}
			double sum1 = 0;
			for (int j = 0; j < timing.length; j++) {

				sum1 += timing[j];

			}
			double total = 0;
			total = sum1 / (double)timing.length;
			
			BigDecimal formatNumber = new BigDecimal(total);
			formatNumber = formatNumber.setScale(2, RoundingMode.DOWN);
			
			String formatNumberS = formatNumber.toString(); 
			String s;
			s = formatNumberS.indexOf(".") < 0 ? formatNumberS : formatNumberS.replaceAll("0*$", "").replaceAll("\\.$", ".0");
			
			
			//output
			String output = "";
			output += s+"-";
			for (int l = 0; l < values.length-1; l++) {
				output += values[l] + " "; 
			}
			output += values[values.length-1];
			bw.write(output+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}