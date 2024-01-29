package src._2024_01_29;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class FileSearcher {
    public static void main(String[] args) {
        List<File> list = new ArrayList<>(10_000);
        String rootPath = "D:\\";
        long time = System.currentTimeMillis();
        getFiles(new File(rootPath), list);

        System.out.println("*************" + (System.currentTimeMillis() - time) + "*********************");

        for (File f : list) {
            System.out.println(f.getAbsolutePath());
        }
    }

    private static void getFiles(File rootFile, List<File> fileList) {
        if (rootFile.isDirectory()) {
            System.out.println("Searching..... ... .. . " + rootFile.getAbsolutePath());
            File[] directoryFiles = rootFile.listFiles();
            if (directoryFiles != null) {
                for (File file : directoryFiles) {
                    if (file.isDirectory()) {
                        getFiles(file, fileList);
                    } else {
                        if (file.getName().toLowerCase().endsWith(".pdf")) {
                            fileList.add(file);
                        }
                    }
                }
            }
        } else {
            if (rootFile.getName().toLowerCase().endsWith(".pdf")) {
                fileList.add(rootFile);
            }
        }
    }

    private static void getFilesOS(File rootFile, List<File> fileList) {
        Path rootPath = rootFile.toPath();

        try {
            Files.walkFileTree(rootPath, new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
                    if (rootFile.getName().toLowerCase().endsWith(".mp3")) {
                        fileList.add(file.toFile());
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) {
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
