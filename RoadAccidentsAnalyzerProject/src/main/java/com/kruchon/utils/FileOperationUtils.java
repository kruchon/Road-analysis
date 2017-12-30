package com.kruchon.utils;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class FileOperationUtils {

    public static void downloadUsingStream(String urlStr, String file) throws IOException{
        URL url = new URL(urlStr);
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        FileOutputStream fis = new FileOutputStream(file);
        byte[] buffer = new byte[1024];
        int count=0;
        while((count = bis.read(buffer,0,1024)) != -1)
        {
            fis.write(buffer, 0, count);
        }
        fis.close();
        bis.close();
    }

    public static void downloadUsingNIO(String urlStr, String file) throws IOException {
        URL url = new URL(urlStr);
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream(file);
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        fos.close();
        rbc.close();
    }

    public static void unpack(String path, String dir_to) throws IOException {
        ZipFile zip = new ZipFile(path);
        Enumeration entries = zip.entries();
        LinkedList<ZipEntry> zfiles = new LinkedList<ZipEntry>();
        while (entries.hasMoreElements()) {
            ZipEntry entry = (ZipEntry) entries.nextElement();
            if (entry.isDirectory()) {
                new File(dir_to+"/"+entry.getName()).mkdir();
            } else {
                zfiles.add(entry);
            }
        }
        for (ZipEntry entry : zfiles) {
            InputStream in = zip.getInputStream(entry);
            OutputStream out = new FileOutputStream(dir_to+"/"+entry.getName());
            byte[] buffer = new byte[1024];
            int len;
            while ((len = in.read(buffer)) >= 0)
                out.write(buffer, 0, len);
            in.close();
            out.close();
        }
        zip.close();
    }
}
