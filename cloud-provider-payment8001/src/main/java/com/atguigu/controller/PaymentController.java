package com.atguigu.controller;

import com.atguigu.entity.Payment;
import com.atguigu.entity.Result;
import com.atguigu.service.PaymentService;
import com.atguigu.vo.reqvo.PaymentCreateReqVo;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping("/payment")
@DefaultProperties(defaultFallback ="payment_Global_FallbackMethod")
public class PaymentController {

    @Value("${server.port}")
    public String serverPort;

    @Autowired
    private PaymentService paymentService;

    @RequestMapping(value = "/getElementById",method = RequestMethod.GET)
    public Result<Payment> getElementById(@RequestParam(value ="id") int id){
        return  new Result<>("查询成功","200",paymentService.queryPaymentById(id));
    };
    @RequestMapping(value ="/create",method = RequestMethod.POST)
    @HystrixCommand
    public Result createPayment(@RequestBody PaymentCreateReqVo req){
        int result=paymentService.createPayment(req);
        if(result>0){
            return new Result("200","创建成功", null);
        }else {
            System.out.println(111);
            return  new Result("333","创建失败",null);
        }
    }

    /**
     * 服务熔断
     * @return
     * @throws Exception
     */
    @GetMapping("/read/timeout")
    @HystrixCommand(fallbackMethod = "payment_Global_FallbackMethod",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
    })
    public String readTimeOut(@RequestParam("id") int id) throws Exception {
       if(id<0){
           throw new RuntimeException("id不能为负数");
       }
       String msg= paymentService.paymentInfo_timeout();
       return  msg;
    }


    public  String payment_Global_FallbackMethod(@RequestParam("id") int id){
        return "Global异常处理信息，请稍后再试，/(ㄒoㄒ)/-->"+id;
    }
}
