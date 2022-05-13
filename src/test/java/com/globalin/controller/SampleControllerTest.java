package com.globalin.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.globalin.domain.Ticket;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
//Controller 테스트입니다.
@WebAppConfiguration
//설정파일위치
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class SampleControllerTest {
	
	//web전용 설정 불러오기
	@Autowired
	private WebApplicationContext ctx;
	//테스트 할때는 가짜MVC 패턴을 만들어주는 MOCK MVC
	private MockMvc mockMvc;
	
	//테스트 시작전에 항상 실행될 메소드
	@Before
	public void setup() {
		//가짜 mvc 객체 만들어주기
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	@Test
	public void test() throws Exception {
		Ticket ticket = new Ticket();
		
		ticket.setBno(123);
		ticket.setOwner("admin");
		ticket.setGarde("aaa");
		
		String jsonStr = new Gson().toJson(ticket);
		System.out.println(jsonStr);
		
		mockMvc.perform(
				post("/sample/ticket")
				.contentType(MediaType.APPLICATION_JSON) //요청의 타입이 json
				.content(jsonStr))
				.andExpect(status().is(200)); //그 결과가 200일 것이라 기대
				
	}
}
