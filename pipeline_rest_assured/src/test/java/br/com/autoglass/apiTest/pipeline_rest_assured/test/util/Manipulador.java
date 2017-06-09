package br.com.autoglass.apiTest.pipeline_rest_assured.test.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Manipulador {

	public static Properties getProp() throws IOException {
		Properties props = new Properties();
		FileInputStream file = new FileInputStream(
				"./properties/dados.properties");
		props.load(file);
		return props;

	}

}