package com.skf.scheduler.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.skf.scheduler.common.Constant;
import com.skf.scheduler.entity.MysqlRequestData;
import com.skf.scheduler.entity.ResponseData;
import com.skf.scheduler.entity.SqlServerRequestData;

public class HttpUtil {

	private static Logger log = LoggerFactory.getLogger(HttpUtil.class);

	public static String jsonPost(String strURL, Map<String, Object> params) {
		StringBuffer sb = new StringBuffer();
		try {
			URL url = new URL(strURL);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.connect();
			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
			out.append(JSONObject.valueToString(params));
			out.flush();
			out.close();

			InputStream is = null;
			if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
				is = connection.getInputStream();
			} else {
				is = connection.getErrorStream();
			}

			try {
				String readLine = new String();
				BufferedReader responseReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				while ((readLine = responseReader.readLine()) != null) {
					sb.append(readLine).append("\n");
				}
				responseReader.close();
				return sb.toString();
			} catch (Exception e1) {
				log.debug(e1.getMessage());
			}

		} catch (IOException e) {
			log.error("Exception occur when send http post request!", e);
		}
		return Constant.HTTP_ERROR;
	}

	public static ResponseData jsonPost(String url, MysqlRequestData mr, SqlServerRequestData sr) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("EndFreq", sr.getEndFreq());
		params.put("SpectraLines", sr.getSpectraLines());

		if (mr.getFreqRotation() == null) {
			return null;
		}
		params.put("FreqRotation", mr.getFreqRotation());

		params.put("ScaleFactor", CalculateUtil.decimal(sr.getScaleFactor(), 8));
		params.put("RawData", CalculateUtil.getRawDataList(sr.getRawData()));

		if (Constant.COMPONENT_TYPE_BEARING == mr.getComponentType()) {
			params.put("BP", new float[] { mr.getBpfi(), mr.getBpfo(), mr.getBsf() });
		} else if (Constant.COMPONENT_TYPE_GEAR == mr.getComponentType()) {
			params.put("BP", new float[] { mr.getMachineFreq() });
		}
		params.put("BearingDangerLevel", mr.getDangerLevel());
		params.put("TotalValueDangerLevel", mr.getTotalValueDangerLevel());
		params.put("DefectFreqMonitoringRange", mr.getDefectFreqMonitoringRange());
		String ss = jsonPost(url, params);
		if (!Constant.HTTP_ERROR.equals(ss)) {
			return convert(new JSONObject(ss).toMap());
		} else {
			return null;
		}
	}

	private static ResponseData convert(Map<String, Object> map) {
		if (map != null && map.get("DefectFreqOrder") != null) {
			ResponseData resp = new ResponseData();
			resp.setDefectFreqOrder(Float.parseFloat(String.valueOf(map.get("DefectFreqOrder"))));
			resp.setENV1X(Float.parseFloat(String.valueOf(map.get("ENV1X"))));
			resp.setENV2X(Float.parseFloat(String.valueOf(map.get("ENV2X"))));
			resp.setENV3X(Float.parseFloat(String.valueOf(map.get("ENV3X"))));
			resp.setENV4X(Float.parseFloat(String.valueOf(map.get("ENV4X"))));
			resp.setENV5X(Float.parseFloat(String.valueOf(map.get("ENV5X"))));
			resp.setBearingTotalValue(Float.parseFloat(String.valueOf(map.get("BearingTotalValue"))));
			resp.setIfBearingTotalValueAlarm((int) map.get("ifBearingTotalValueAlarm"));
			resp.setScore(Float.parseFloat(String.valueOf(map.get("Score"))));
			resp.setClas(getClas((int) map.get("Class")));
			return resp;
		}
		return null;
	}

	private static String getClas(int clas) {
		switch (clas) {
		case 1:
			return Constant.CLASS_A;
		case 2:
			return Constant.CLASS_B;
		case 3:
			return Constant.CLASS_C;
		default:
			return Constant.CLASS_A;
		}
	}
}
