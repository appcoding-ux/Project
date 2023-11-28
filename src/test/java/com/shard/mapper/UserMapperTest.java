package com.shard.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shard.domain.ShardMemberVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class UserMapperTest {
	
	@Autowired
	private UserMapper mapper;

	@Test
	public void InsertUserTest() {
		for(int i = 1; i <= 50; i++) {
			ShardMemberVO vo = ShardMemberVO.builder()
					.userId("userId"+i)
					.userPwd("userPwd"+i)
					.userName("userName"+i)
					.email("email"+i+"@gmail.com")
					.phone("010-12"+i+"-1234")
					.dob("2000-11-25")
					.build();
			mapper.insertUser(vo);
		}
							
	}

}
