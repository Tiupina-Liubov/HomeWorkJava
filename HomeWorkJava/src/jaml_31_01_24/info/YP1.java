package src.jaml_31_01_24.info;//package org.example._2024_31_01;
//
//import org.yaml.snakeyaml.Yaml;
//
//import java.io.InputStream;
//import java.util.Map;
//
//public class YP1 {
//    public static void main(String[] args) {
//        Yaml yaml = new Yaml();
//
//        InputStream inputStream = YP1.class
//                .getClassLoader()
//                .getResourceAsStream("application.yml");
//
//        if (inputStream == null) {
//            System.out.println("Can't read the file");
//            return;
//        }
//
//        try {
//            Map<String, Object> map = yaml.load(inputStream);
//            for (Map.Entry<String, Object> entry : map.entrySet()) {
//                System.out.println(entry.getKey() + " : " + entry.getValue());
//            }
//        } catch (Exception e) {
//            System.out.println("Can't parse the file");
//        }
//    }
//}