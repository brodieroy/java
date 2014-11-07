package com.core.zipentrytest;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class LocalCompressWithZip {

    private LocalCompressWithZip() {

    }

    public static LocalCompressWithZip factoryCompressConstrctor() {

        return new LocalCompressWithZip();

    }

    public static void main(String[] args) {

        String[] fileName = { "C:/04BRODIETEST/test1.png", "C:/04BRODIETEST/test2.png" }; // 압출할
                                                                                          // 파일
                                                                                          // 경로
        // String[] fileName = {"C:/04BRODIETEST"};

        String path = "C:/05BRODIETEST/";

        File zipFile = new File(path + "test.zip");
        File dirFile = new File(path);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
        ZipOutputStream zos = null;

        try {
            zos = new ZipOutputStream(new FileOutputStream(zipFile));
            byte[] buffer = new byte[1024 * 4];

            for (String file : fileName) {

                if (new File(file).isDirectory()) {
                    continue;
                }
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
                // zos.putNextEntry(new ZipEntry(file));
                zos.putNextEntry(new ZipEntry(file.replace("C:/04BRODIETEST/", ""))); //이부분이 replace를 안해주게 되면
                zip이 빈파일로 묶이게 된다.

                int length = 0;
                while ((length = bis.read(buffer)) != -1) {
                    zos.write(buffer, 0, length);
                }

                zos.closeEntry();
                bis.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (zos != null) {
                    zos.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
