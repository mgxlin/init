package com.wancheli.init.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtil {

    public static byte[] zipFolder(File folderToZip) throws IOException {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ZipOutputStream zos = new ZipOutputStream(baos)) {
            zipFolderHelper(folderToZip, folderToZip.getName(), zos);
            zos.finish();
            return baos.toByteArray();
        }
    }

    private static void zipFolderHelper(File fileToZip, String fileName, ZipOutputStream zos) throws IOException {
        if (fileToZip.isHidden()) {
            return;
        }
        if (fileToZip.isDirectory()) {
            if (fileName.endsWith("/")) {
                zos.putNextEntry(new ZipEntry(fileName));
                zos.closeEntry();
            } else {
                zos.putNextEntry(new ZipEntry(fileName + "/"));
                zos.closeEntry();
            }
            File[] children = fileToZip.listFiles();
            for (File childFile : children) {
                zipFolderHelper(childFile, fileName + "/" + childFile.getName(), zos);
            }
            return;
        }
        try (FileInputStream fis = new FileInputStream(fileToZip)) {
            ZipEntry zipEntry = new ZipEntry(fileName);
            zos.putNextEntry(zipEntry);
            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                zos.write(bytes, 0, length);
            }
        }
    }
}
