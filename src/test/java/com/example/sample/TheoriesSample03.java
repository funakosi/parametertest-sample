package com.example.sample;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

@RunWith(Theories.class)
public class TheoriesSample03 {

	@SuppressWarnings("unchecked")
    @DataPoints
    public static Fixture[] getParams() {
		CsvMapper mapper = new CsvMapper();
		CsvSchema schema = mapper.schemaFor(Fixture.class).withHeader();
		//パラメータファイル取得
		String paramFilePath = System.getProperty("parameter_file");
		Path path = Paths.get(paramFilePath);
		try (BufferedReader src = Files.newBufferedReader(path)) {
			MappingIterator<Fixture> it = mapper.readerFor(Fixture.class).with(schema).readValues(src);
			List<Fixture> list = new ArrayList<Fixture>();
			while (it.hasNextValue()) {
				Fixture f = it.nextValue();
				list.add(f);
			}
			return list.toArray(new Fixture[list.size()]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

    @Theory
    public void add(Fixture p) throws Exception {
    	System.out.println("x:"+p.getX()+",y:"+p.getY()+",expected:"+p.getExpected());
        assertThat(p.getX() + p.getY(), is(p.getExpected()));
    }
}
