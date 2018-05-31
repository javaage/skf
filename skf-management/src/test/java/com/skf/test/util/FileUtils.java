package com.skf.test.util;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileUtils {

	public static byte[] getBytes(String filePath) {
		byte[] buffer = null;
		File file = new File(filePath);
		FileInputStream fis = null;
		ByteArrayOutputStream bos = null;
		try {
			fis = new FileInputStream(file);
			bos = new ByteArrayOutputStream();
			byte[] b = new byte[1024];
			int n;
			while ((n = fis.read(b)) != -1) {
				bos.write(b, 0, n);
			}
			buffer = bos.toByteArray();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (null != bos) {
					bos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return buffer;
	}

	public static void bytesToFile(byte[] buffer, final String filePath) {
		File file = new File(filePath);
		OutputStream output = null;
		BufferedOutputStream bufferedOutput = null;
		try {
			output = new FileOutputStream(file);
			bufferedOutput = new BufferedOutputStream(output);
			bufferedOutput.write(buffer);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != bufferedOutput) {
					bufferedOutput.close();
				}
				if (null != output) {
					output.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
