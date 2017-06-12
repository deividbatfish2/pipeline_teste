package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Manipulador {

	public static Properties getProp(){
		Properties props = new Properties();
		FileInputStream file;
		try {
			file = new FileInputStream(
					"src/test/resources/properties/dados.properties");
			try {
				props.load(file);
				return props;
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}

	}

}