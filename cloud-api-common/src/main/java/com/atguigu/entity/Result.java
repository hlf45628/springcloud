package com.atguigu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T>{

    private String msg ;//返回信息

    private  String code ;//返回值

    private  T data;
}
