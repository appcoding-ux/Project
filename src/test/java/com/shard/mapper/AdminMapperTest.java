package com.shard.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shard.domain.PageVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class AdminMapperTest {

	@Autowired
	private AdminMapper mapper;
	
	@Test
	public void listUsertest() {
		log.info(mapper.userList(new PageVO(1, mapper.userCount())));
	}
	
	@Test
	public void listItemTest() {
		log.info(mapper.itemList(new PageVO(1, mapper.itemCount())));
	}

}
