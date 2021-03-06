package com.wx.pay.wx_demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

/**
 * @author feileniao
 * @date 2021/8/9
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户基本信息")
public class User {
    @ApiModelProperty("姓名")
    @Size(max = 20)
    private String name;
    @Max(150)
    @Min(1)
    private Integer age;
    @NotNull
    private String address;
    @Pattern(regexp = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$")
    private String email;
}
