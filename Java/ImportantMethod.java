package learn11_8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToLearn {

	public static void main(String[] args) {

			String d = getJustDataV8("J:/Notes/Docker.txt");
			try {
				//System.out.println(getJustDataV11("J:/Notes/Docker.txt"));
				
				testCollector();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public static String getJustDataV8(String path) {
		String data =null ;
		
		try(BufferedReader reader = new BufferedReader(new FileReader(path))){
			String line;
			while(( line = reader.readLine())!=null) {
				data+=line;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public static String getJustDataV11(String path) throws IOException {
		try(Stream<String> line = Files.lines(Paths.get(path)) ){	
			return line.collect(Collectors.joining(System.lineSeparator()));
		}
	}
	/*
	 * Collector in java 8 and 11
	 * 
	 */
	
	public static void testCollector() {
		List<Integer> numbers = List.of(1,2,3,4,5);
		List<Integer> evenNo = numbers.stream().collect( 
				Collectors.filtering(  n -> n%2 ==0  , Collectors.toList())   );
		evenNo.forEach(n -> System.out.println(n));
		//others important method flatMapping and teeing - both present in java 11
		
	}
}
