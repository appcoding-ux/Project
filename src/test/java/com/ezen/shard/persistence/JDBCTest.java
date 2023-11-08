package com.ezen.shard.persistence;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ezen.shard.mapper.UserMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class JDBCTest {
	
	@Autowired
	private DataSource datasource;
	
	@Autowired
	private UserMapper mapper;
	
	@Test
	public void connectionTest() {
		try {
			Connection con = datasource.getConnection();
			log.info(con);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test
	public void getUserTest() {
		log.info(mapper.getUser("dodo607"));;
	}
}