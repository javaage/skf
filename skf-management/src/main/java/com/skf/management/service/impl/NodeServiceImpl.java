package com.skf.management.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.skf.management.service.NodeService;
import com.skf.management.sqlservermapper.NodeMapper;

@Service
public class NodeServiceImpl implements NodeService {

//	@Autowired
//	@Qualifier("sqlserversession")
//	private SqlSession sqlSession;

	@Override
	public List<Integer> getLeafNodes(String schemaName) {
//		NodeMapper nodeMapper = sqlSession.getMapper(NodeMapper.class);
//		
//		return nodeMapper.getLeafNodes("");
		return null;
	}
}
