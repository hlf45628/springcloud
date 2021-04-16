package com.atguigu.test;

import com.atguigu.Payment8001;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Payment8001.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Test {

   @Resource
   TestRestTemplate restTemplate;



   @org.junit.Test
   public  void test(){
       for(int i=0;i<=100;i++){
           String result = restTemplate.getForObject("http://localhost:8001/payment/read/timeout?id=-1", String.class);
           System.out.println(result);
       }
       String result = restTemplate.getForObject("http://localhost:8001/payment/read/timeout?id=1", String.class);
       System.out.println(result);
   }

}
