package com.example.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class ReadCSV {

	@Test
	public void ResdCSVTest() {
		CsvMapper mapper = new CsvMapper();
		CsvSchema schema = mapper.schemaFor(Fixture.class).withHeader();
		Path path = Paths.get("C:\\work\\param.csv");
		try (BufferedReader src = Files.newBufferedReader(path)) {
			MappingIterator<Fixture> it = mapper.readerFor(Fixture.class).with(schema).readValues(src);
			while (it.hasNextValue()) {
				Fixture f = it.nextValue();
				System.out.println(f.getX()+"+"+f.getY()+"="+f.getExpected());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
