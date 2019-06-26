package com.gj.web;

import com.gj.service.CustomService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Gjing
 **/
@RestController
public class CustomController {
    @Resource
    private CustomService customService;

    @PostMapping("/custom")
    @ApiOperation(value = "添加用户", httpMethod = "POST")
    @ApiImplicitParam(name = "customName", value = "用户名", required = true, dataType = "String", paramType = "Query")
    public ResponseEntity insertCustom(String customName) {
        Boolean insertCustom = customService.insertCustom(customName);
        if (insertCustom) {
            return ResponseEntity.ok("New successful");
        }
        return ResponseEntity.ok("Add failed, user already exists");
    }

    @GetMapping("/custom/{custom-id}")
    @ApiOperation(value = "查询指定用户", httpMethod = "GET")
    public ResponseEntity getCustom(@PathVariable("custom-id") Integer customId) {
        return ResponseEntity.ok(customService.getCustom(customId));
    }

    @DeleteMapping("/custom")
    @ApiOperation(value = "删除指定用户", httpMethod = "DELETE")
    @ApiImplicitParam(name = "customId", value = "用户id", required = true, dataType = "int", paramType = "Query")
    public ResponseEntity deleteCustom(Integer customId) {
        customService.deleteCustom(customId);
        return ResponseEntity.ok("Delete successful");
    }
}
