package com.skf.alarm.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.skf.alarm.common.Constant;
import com.skf.alarm.mapper.AlarmMapper;
import com.skf.alarm.model.Alarm;
import com.skf.alarm.model.AlarmCount;
import com.skf.alarm.model.AlarmDetailRequest;
import com.skf.alarm.model.AlarmPoint;
import com.skf.alarm.model.AlarmQueryRequest;
import com.skf.alarm.model.AlarmRequest;
import com.skf.alarm.model.DropDownList;
import com.skf.alarm.model.Leaf;
import com.skf.alarm.model.Node;
import com.skf.alarm.service.AlarmService;
import com.skf.alarm.util.CalculateUtil;

/**
 * @author P0088589
 *
 */
@Service
public class AlarmServiceImpl implements AlarmService {

	private static Logger log = LoggerFactory.getLogger(AlarmServiceImpl.class);

	@Autowired
	private AlarmMapper mapper;

	@Override
	public List<AlarmCount> getAlarmCounts(String userCode) {
		List<AlarmCount> list = new ArrayList<AlarmCount>();
		list.add(createAlarmCount(Constant.ALARM_STATUS_UNPROCESSED, Constant.ALARM_UNPROCESSED_TAB,
				Constant.ALARM_UNPROCESSED_STATUS, userCode, Constant.ALARM_STATUS_UNPROCESSED));
		list.add(createAlarmCount(Constant.ALARM_STATUS_PROCESSING, Constant.ALARM_PROCESSING_TAB,
				Constant.ALARM_PROCESSING_STATUS, userCode, Constant.ALARM_STATUS_PROCESSING));
		list.add(createAlarmCount(Constant.ALARM_STATUS_PROCESSED, Constant.ALARM_PROCESSED_TAB,
				Constant.ALARM_PROCESSED_STATUS, userCode, Constant.ALARM_STATUS_PROCESSED));
		return list;
	}

	private AlarmCount createAlarmCount(int id, String name, String status, String userCode, int warningType) {
		AlarmQueryRequest query = new AlarmQueryRequest();
		query.setUserCode(userCode);
		query.setSelectDevice(Constant.SELECTION_ALL);
		query.setSelectSensor(Constant.SELECTION_ALL);
		query.setSelectStatus(Constant.SELECTION_ALL);
		query.setWarningType(warningType);
		AlarmCount alarmCount = new AlarmCount();
		alarmCount.setId(id);
		alarmCount.setName(name);
		alarmCount.setStatus(status);
		try {
			alarmCount.setTotal(mapper.getAlarmCount(query));
		} catch (Exception e) {
			alarmCount.setTotal(0);
			log.debug(e.getMessage());
		}
		return alarmCount;
	}

	@Override
	public DropDownList getDropDownList(String userCode) {
		DropDownList datas = new DropDownList();
		List<Leaf> status = new ArrayList<Leaf>();
		status.add(new Leaf(Constant.CLASS_ALL, Constant.CLASS_ALL));
		status.add(new Leaf(Constant.CLASS_A, Constant.CLASS_A));
		status.add(new Leaf(Constant.CLASS_B, Constant.CLASS_B));
		status.add(new Leaf(Constant.CLASS_C, Constant.CLASS_C));
		datas.setStatus(status);
		try {
			datas.setDevice(mapper.getDevice(userCode));
		} catch (Exception e) {
			List<Node> device = new ArrayList<Node>();
			List<Leaf> data = new ArrayList<Leaf>();
			data.add(new Leaf(Constant.CLASS_ALL, Constant.CLASS_ALL));
			Node node = new Node(Constant.CLASS_ALL, Constant.CLASS_ALL, data);
			device.add(node);
			datas.setDevice(device);
			log.debug(e.getMessage());
		}
		return datas;
	}

	@Override
	public Map<String, Object> getAlarms(AlarmQueryRequest query) {
		Map<String, Object> result = new HashMap<String, Object>();
		query.setCountLine(Constant.ALARM_PAGE_SIZE);
		try {
			int count = mapper.getAlarmCount(query);
			if (count == 0) {
				result.put("totalPageNum", 0);
				result.put("tableList", new ArrayList<Alarm>());
				return result;
			}
			int totalPageNum = 0;
			if (count % Constant.ALARM_PAGE_SIZE == 0) {
				totalPageNum = count / Constant.ALARM_PAGE_SIZE;
			} else {
				totalPageNum = count / Constant.ALARM_PAGE_SIZE + 1;
			}
			if (query.getCurrentPageNum() <= 0) {
				query.setCurrentPageNum(1);
			}
			if (totalPageNum < query.getCurrentPageNum()) {
				query.setCurrentPageNum(totalPageNum);
			}
			query.setStartLine((query.getCurrentPageNum() - 1) * Constant.ALARM_PAGE_SIZE);
			query.setCountLine(Constant.ALARM_PAGE_SIZE);
			if ("status".equals(query.getSortByRowType())) {
				query.setSortByRowType("CLASS");
			} else if ("score".equals(query.getSortByRowType())) {
				query.setSortByRowType("SCORE");
			} else if ("alarmTime".equals(query.getSortByRowType())) {
				query.setSortByRowType("ALRM_TIME");
			} else {
				query.setSortByRowType(null);
			}
			result.put("totalPageNum", totalPageNum);
			result.put("tableList", mapper.getAlarms(query));
		} catch (Exception e) {
			result.put("totalPageNum", 0);
			result.put("tableList", new ArrayList<Alarm>());
			log.debug(e.getMessage());
		}
		return result;
	}

	@Override
	public Map<String, Object> getAlarmDetail(AlarmDetailRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			String schema = mapper.getSchema(request.getRowId());
			int countPoint = mapper.getCountAlarmPoint(schema, request);
			int freq = 1;
			if (countPoint > Constant.COUNT_POINT) {
				freq = countPoint % Constant.COUNT_POINT == 0 ? countPoint / Constant.COUNT_POINT
						: countPoint / Constant.COUNT_POINT + 1;
			}
			Map<String, Object> description = new HashMap<String, Object>();
			Map<String, Object> lineChart = new HashMap<String, Object>();
			Map<String, Object> spectrogram = new HashMap<String, Object>();
			List<AlarmPoint> tpoints = mapper.getTrendPoints(schema, freq, request);
			List<AlarmPoint> dpoint = mapper.getALarmPoint(request.getRowId());
			AlarmPoint current = CollectionUtils.isEmpty(dpoint) ? null : dpoint.get(0);

			if (current != null) {
				result.put("dangerAmountLevel", current.getTotalValueDangerLevel());
				result.put("dangerLevel", current.getDangerLevel());
				spectrogram.put("spectrogramTab", getSpectrogramTab(current));
			} else {
				result.put("dangerAmountLevel", 0);
				result.put("dangerLevel", 0);
				spectrogram.put("spectrogramTab", getSpectrogramTab(current));
			}
			
			if (current != null && current.getTime() != null) {
				description.put("val1", CalculateUtil.decimal(current.getValue(), 4));
				description.put("val2", CalculateUtil.decimal(current.getValue() / current.getLevel(), 2));
				description.put("val3", current.getBpType());
			} else {
				description.put("val1", 0);
				description.put("val2", 0);
				description.put("val3", "");
			}

			if (!CollectionUtils.isEmpty(tpoints)) {
				long[] times = new long[tpoints.size()];
				float[] values = new float[tpoints.size()];
				boolean resetFlg = false;
				for (int i = 0; i < tpoints.size(); i++) {
					if (current != null && !resetFlg && current.getTime() != null
							&& tpoints.get(i).getTime().compareTo(current.getTime()) >= 0
							&& tpoints.get(0).getTime().compareTo(current.getTime()) <= 0) {
						times[i] = current.getTime().getTime();
						values[i] = CalculateUtil.decimal(current.getValue(), 4).floatValue();
						lineChart.put("markPointCoord", new Object[] { times[i], values[i] });
						resetFlg = true;
					} else {
						times[i] = tpoints.get(i).getTime().getTime();
						values[i] = CalculateUtil.decimal(tpoints.get(i).getValue(), 4).floatValue();
					}
				}
				lineChart.put("xAxisData", times);
				lineChart.put("yAxisData", values);
				if (!resetFlg) {
					current = tpoints.get(tpoints.size() - 1);
					lineChart.put("markPointCoord",
							new Object[] { times[tpoints.size() - 1], values[tpoints.size() - 1] });
				}
			}
			List<AlarmPoint> fpoints = mapper.getFreqData(schema, current.getTime(), request.getRowId());
			if (!CollectionUtils.isEmpty(fpoints)) {
				spectrogram.put("defectFreqOrder", CalculateUtil.decimal(fpoints.get(0).getDefectFreqOrder(), 2));
				spectrogram.put("xAxisMax", fpoints.get(0).getEndFreq());
				spectrogram.put("yAxisData", CalculateUtil.getRawDataList(fpoints.get(0).getRawData()));
			} else {
				spectrogram.put("defectFreqOrder", 0);
				spectrogram.put("xAxisMax", 0);
				spectrogram.put("yAxisData", new Object[0]);
			}
			result.put("description", description);
			result.put("lineChart", lineChart);
			result.put("spectrogram", spectrogram);
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
		return result;
	}

	private List<Map<String, Object>> getSpectrogramTab(AlarmPoint current) {
		List<Map<String, Object>> spectrogramTab = new ArrayList<Map<String, Object>>();
		Map<String, Object> map0 = new HashMap<String, Object>();
		map0.put("id", 0);
		map0.put("name", Constant.ALARM_DETAIL_PANEL_TAB1);
		map0.put("value", current != null && current.getBpfi() != null ? current.getBpfi() : 0);
		spectrogramTab.add(map0);
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("id", 1);
		map1.put("name", Constant.ALARM_DETAIL_PANEL_TAB2);
		map1.put("value", current != null && current.getBpfo() != null ? current.getBpfo() : 0);
		spectrogramTab.add(map1);
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("id", 2);
		map2.put("name", Constant.ALARM_DETAIL_PANEL_TAB3);
		map2.put("value", current != null && current.getBsf() != null ? current.getBsf() : 0);
		spectrogramTab.add(map2);
		return spectrogramTab;
	}

	@Override
	public Map<String, Object> getFreqData(AlarmRequest request) {
		Map<String, Object> spectrogram = new HashMap<String, Object>();
		try {
			String schema = mapper.getSchema(request.getRowId());
			List<AlarmPoint> fpoints = mapper.getFreqData(schema, new Date(request.getMarkPointVal()),
					request.getRowId());
			if (!CollectionUtils.isEmpty(fpoints)) {
				spectrogram.put("defectFreqOrder", CalculateUtil.decimal(fpoints.get(0).getDefectFreqOrder(), 2));
				spectrogram.put("xAxisMax", fpoints.get(0).getEndFreq());
				spectrogram.put("yAxisData", CalculateUtil.getRawDataList(fpoints.get(0).getRawData()));
			} else {
				spectrogram.put("defectFreqOrder", 0);
				spectrogram.put("xAxisMax", 0);
				spectrogram.put("yAxisData", new Object[0]);
			}
		} catch (Exception e) {
			spectrogram.put("defectFreqOrder", 0);
			spectrogram.put("xAxisMax", 0);
			spectrogram.put("yAxisData", new Object[0]);
			log.debug(e.getMessage());
		}
		return spectrogram;
	}

	@Override
	public void updateAlarmStatus(String componentCode, int alarmType, int status) {
		mapper.updateAlarmStatus(componentCode, alarmType, status);
	}

	@Override
	public void removeAlarm(String componentCode, int alarmType) {
		mapper.deleteAlarm(componentCode, alarmType);
	}

}
