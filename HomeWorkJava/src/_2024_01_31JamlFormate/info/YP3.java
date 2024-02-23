package src._2024_01_31JamlFormate.info;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import src._2024_01_31JamlFormate.taski.UniversityContainer;

import java.io.FileReader;
import java.io.IOException;

public class YP3 {
    public static void main(String[] args) {

        try {
            ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
            FileReader reader = new FileReader("/Users/luibov/Desktop/proekt/HomeWorkJava/HomeWorkJava/src/resources/1.yaml");
            UniversityContainer testObject = objectMapper.readValue(reader, UniversityContainer.class);

            System.out.println(testObject.getUniversity());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

/**
 * [2 3 2]
 *
 *
 */