package com.trafficmonkey.service;

import javax.inject.Inject;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sun.xml.internal.fastinfoset.sax.Properties;
import com.trafficmonkey.DTO.ParentChildDTO;
import com.trafficmonkey.model.ParentChildModel;
import com.trafficmonkey.repository.ParentChildRepository;
@Service
@Transactional
public class ParentChildServiceImpl implements ParentChildService {
	@Inject
	ParentChildRepository parentChildRepository;

	@Override
	public void saveParentChild(ParentChildDTO parentChild) {
		ParentChildModel parentChildModel = new ParentChildModel();
		BeanUtils.copyProperties(parentChild, parentChildModel);
	   parentChildRepository.save(parentChildModel);
	}

}
