package sistema;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter file full path: ");
		String path = sc.next();
		
		Map<String, Integer> candidates = new HashMap<>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
			String candidate = br.readLine();
			while(candidate != null) {
				String[] fields = candidate.split(",");
				String name = fields[0];
				int votes = Integer.parseInt(fields[1]);
				if (candidates.containsKey(name)) {
					votes += candidates.get(name);
				}
				candidates.put(name, votes);
				candidate = br.readLine();
			}
			
			for (String names : candidates.keySet()) {
				System.out.println(names + ": " + candidates.get(names));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
		
		
		
		
		
	}

}
