package com.karl.apacheshiro.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description TODO
 * @Date 2020/4/19 10:35
 * @Created karl xie
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyResponse {
    private static final long serialVersionUID = -2L;
    private String status;
    private String message;
}
