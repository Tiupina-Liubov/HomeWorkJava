package src.jaml_31_01_24.info;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import src.jaml_31_01_24.info.TestObject;

import java.io.FileWriter;
import java.io.IOException;

public class YP2 {
    public static void main(String[] args) {

        try {
            TestObject testObject = new TestObject("Name test", 25);
            ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
            FileWriter writer = new FileWriter("out.yaml");

            objectMapper.writeValue(writer, testObject);
            writer.close();
            System.out.println("DONE!");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}