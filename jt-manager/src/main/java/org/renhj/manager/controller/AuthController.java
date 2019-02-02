package org.renhj.manager.controller;

import org.renhj.common.pojo.vo.Result;
import org.renhj.manager.pojo.domain.TbUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @PostMapping("/login")
    public Result doLogin(@RequestBody(required = true) TbUser user){
        System.out.println(user);
        Map<String, String> map = new HashMap<>();
        String token = String.valueOf(UUID.randomUUID());
        map.put("token", token);
        return Result.ok(map);
    }
}
