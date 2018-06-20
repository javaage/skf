package com.skf.management.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.skf.management.model.NodeElement;
import com.skf.management.service.NodeService;
import com.skf.management.sqlservermapper.NodeMapper;

@Service
public class NodeServiceImpl implements NodeService {

	@Autowired
	@Qualifier("sqlserversession")
	private SqlSessionTemplate sqlSession;

	@Override
	public List<Integer> getLeafNodes(String schema) {
		NodeMapper nodeMapper = sqlSession.getMapper(NodeMapper.class);
		Map<String,String> map = new HashMap<String,String>();
		map.put("schema", schema);
		return nodeMapper.getLeafNodes(map);
	}
	
	@Override
	public List<String> getNodeDatabase(){
		List<String> listString = new ArrayList<String>();
		NodeMapper nodeMapper = sqlSession.getMapper(NodeMapper.class);
		
		List<String> databases = nodeMapper.getDatabases();
		
		for(String schema : databases){
			try{
				Map<String,String> map = new HashMap<String,String>();
				map.put("schema", schema);
				int count = nodeMapper.getNodeCount(map);
				if(count > 0){
					listString.add(schema);
				}
			}catch(Exception exp){
				
			}
			
		}
		return listString;
	}

	@Override
	public List<NodeElement> getNodeElements(String schema) {
		NodeMapper nodeMapper = sqlSession.getMapper(NodeMapper.class);
		Map<String,String> map = new HashMap<String,String>();
		map.put("schema",schema);
		List<Integer> ids =  nodeMapper.getLeafNodes(map);
		List<NodeElement> elements = new ArrayList<NodeElement>();
		for(int i=0;i<ids.size();i++){
			NodeElement element = nodeMapper.getNodeNameTree(ids.get(i), schema);
			elements.add(element);
		}
		return elements;
	}

	@Override
	public float getNodeValue(String schema, int idNode) {
		NodeMapper nodeMapper = sqlSession.getMapper(NodeMapper.class);
		Float result = nodeMapper.getNodeValue(idNode, schema);
//		if(result==null)
//			return 0;
//		else
		return result;
	}
}
