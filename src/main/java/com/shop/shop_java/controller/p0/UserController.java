package com.shop.shop_java.controller.p0;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/admin/extend/user_list")
public class UserController {

    @GetMapping("/list")
    public Map<String, Object> getList(@RequestParam(defaultValue = "1") int page,
                                       @RequestParam(defaultValue = "10") int limit,
                                       @RequestParam(required = false) String keyword,
                                       @RequestParam(required = false) Integer level) {
        List<Map<String, Object>> list = new ArrayList<>();
        String[] names = {"路飞", "索隆", "娜美", "乌索普", "山治", "乔巴", "罗宾"};
        for(int i=0; i<10; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", i + 1);
            map.put("avatar", "https://img.alicdn.com/tfs/TB1V2eOrKSSMeJjSZFsXXcXhpXa-130-130.png");
            map.put("nickname", names[i % names.length] + i);
            map.put("phone", "1380013800" + i);
            map.put("level_name", i % 3 == 0 ? "VIP会员" : "普通用户");
            map.put("balance", String.format("%.2f", Math.random() * 1000));
            map.put("integral", (int)(Math.random() * 5000));
            map.put("status", 1);
            map.put("create_time", "2024-04-01 12:00:00");
            list.add(map);
        }
        Map<String, Object> data = new HashMap<>();
        data.put("records", list);
        data.put("total", 50);
        
        Map<String, Object> res = new HashMap<>();
        res.put("code", 200);
        res.put("msg", "success");
        res.put("data", data);
        return res;
    }

    @PostMapping("/add")
    public Map<String, Object> add(@RequestBody Map<String, Object> params) {
        Map<String, Object> res = new HashMap<>();
        res.put("code", 200);
        res.put("msg", "添加成功");
        return res;
    }

    @PutMapping("/update")
    public Map<String, Object> update(@RequestBody Map<String, Object> params) {
        Map<String, Object> res = new HashMap<>();
        res.put("code", 200);
        res.put("msg", "修改成功");
        return res;
    }

    @DeleteMapping("/delete")
    public Map<String, Object> delete(@RequestParam Integer id) {
        Map<String, Object> res = new HashMap<>();
        res.put("code", 200);
        res.put("msg", "删除成功");
        return res;
    }
}
