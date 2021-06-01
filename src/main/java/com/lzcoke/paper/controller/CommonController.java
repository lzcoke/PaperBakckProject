package com.lzcoke.paper.controller;

import com.lzcoke.paper.utils.result.ResultUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ApiOperation(value = "公共请求", hidden = true)
public class CommonController {

    @RequestMapping("/500")
    public ResultUtils getNull() {
        return ResultUtils.error("请重新登录账户！");
    }
}
