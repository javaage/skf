package com.skf.scheduler.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import com.skf.scheduler.common.Constant;

public class CalculateUtil {

	public static int[] getRawDataList(byte[] rawData) {
		if (rawData != null && rawData.length % 2 == 0) {
			int[] data = new int[rawData.length / 2];
			for (int i = 0, index = 0; i < rawData.length - 1; i++, index++) {
				data[index] = (int) ((rawData[i] & 0xFF) | (rawData[++i] & 0xFF) << 8);
			}
			return data;
		}
		return null;
	}

	public static byte[] getRawData(int[] rawDataList) {
		if (rawDataList != null && rawDataList.length > 0) {
			byte[] rawData = new byte[rawDataList.length * 2];
			for (int i = 0, index = 0; i < rawDataList.length - 1; i++) {
				rawData[index++] = (byte) ((rawDataList[i]) & 0xFF);
				rawData[index++] = (byte) ((rawDataList[i] >> 8) & 0xFF);
			}
			return rawData;
		}
		return null;
	}

	public static double[] getRawDataList(byte[] rawData, double scale) {
		if (rawData != null && rawData.length % 2 == 0) {
			double[] data = new double[rawData.length / 2];
			DecimalFormat df = new DecimalFormat("###############0.0000000#");
			for (int i = 0, index = 0; i < rawData.length - 1; i++, index++) {
				data[index] = new BigDecimal(df.format(((rawData[i] & 0xFF) | (rawData[++i] & 0xFF) << 8) * scale))
						.doubleValue();
			}
			return data;
		}
		return null;
	}

	public static BigDecimal decimal(double d, int digit) {
		StringBuilder sb = new StringBuilder("###############");
		if (digit > 0) {
			sb.append("0.");
			for (int i = 1; i < digit; i++) {
				sb.append("0");
			}
		}
		sb.append("#");
		DecimalFormat df = new DecimalFormat(sb.toString());
		return new BigDecimal(df.format(d));
	}

	public static BigDecimal decimal(float f, int digit) {
		StringBuilder sb = new StringBuilder("###############");
		if (digit > 0) {
			sb.append("0.");
			for (int i = 1; i < digit; i++) {
				sb.append("0");
			}
		}
		sb.append("#");
		DecimalFormat df = new DecimalFormat(sb.toString());
		return new BigDecimal(df.format(f));
	}

	public static float calculateScore(int ifAlarm, float responseValue, float requestValue) {
		float score = 100;
		if (ifAlarm == 0) {
			score = 100;
		} else if (responseValue < 2 * requestValue) {
			score = 100 - 10 * responseValue / requestValue;
		} else if (responseValue >= 5 * requestValue) {
			score = 50;
		} else {
			score = 100 - 10 * responseValue / requestValue;
		}
		return decimal(score, 2).floatValue();
	}

	public static String calculateClas(int ifAlarm, float responseValue, float requestValue) {
		if (ifAlarm == 0) {
			return Constant.CLASS_A;
		} else if (responseValue < 2 * requestValue) {
			return Constant.CLASS_B;
		} else {
			return Constant.CLASS_C;
		}
	}

}
