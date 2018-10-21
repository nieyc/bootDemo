package com.github.nyc.bootDemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootDemoApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("bbc");
		list.add("cbc");
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
		String str = it.next();
		System.out.println(str);
		if(str.equals("abc")){
		  it.remove();
		}
		}
		System.out.println(list.size());
	}

}
