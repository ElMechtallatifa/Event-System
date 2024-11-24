package com.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;

@SpringBootApplication
@MapperScan("com.test.mapper")
public class Demo1Application {

    public static void main(String[] args) {
        String currentWorkingDir = System.getProperty("user.dir");

        String targetPath = currentWorkingDir + File.separator + "project.sqlite";

        File file = new File(targetPath);
        if (!file.exists()) {
            try (InputStream is = Demo1Application.class.getResourceAsStream("/project.sqlite");
                 OutputStream os = new FileOutputStream(targetPath)) {

                byte[] buffer = new byte[1024];
                int length;

                while ((length = is.read(buffer)) != -1) {
                    os.write(buffer, 0, length);
                }

                System.out.println("Database file copied to " + targetPath);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        SpringApplication.run(Demo1Application.class, args);
    }

}
