package com.moon.systemweb.controller;

import com.moon.systemapi.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@Api(tags={"Swagger案例"})
@RestController
@RequestMapping("/Swagger")
public class SwaggerController {


    /**
     * @ApiOperation() 用于方法；表示一个http请求的操作
     * value用于方法描述
     * notes用于提示内容
     * @ApiParam() 用于方法，参数，字段说明；表示对参数的添加元数据（说明或是否必填等）
     * name–参数名
     * value–参数说明
     * required–是否必填
     */
    @ApiOperation(value="获取用户信息get",notes="注意问题点")
    @GetMapping("/getUserInfo")
    public User getUserInfo(@ApiParam(name="id",value="用户id",required=true) Long id, @ApiParam(name="username",value="用户名") String username) {
        // userService可忽略，是业务逻辑
        User user = new User();
        user.setUserName("郭溪");
        return user;
    }

    /**z
     * @ApiModel()用于类 ；表示对类进行说明，用于参数用实体类接收
     * value–表示对象名
     * description–描述
     * 都可省略
     * @ApiModelProperty()用于方法，字段； 表示对model属性的说明或者数据操作更改
     * value–字段说明
     * name–重写属性名字
     * dataType–重写属性类型
     * required–是否必填
     * example–举例说明
     * hidden–隐藏
     */
    @ApiOperation("获取用户信息post")
    @PostMapping("/updateUserInfo")
    public User updateUserInfo(@RequestBody @ApiParam(name="用户对象",value="传入json格式",required=true) User user){

        user.setUserName("傻叉郭溪");
        return user;
    }

}
