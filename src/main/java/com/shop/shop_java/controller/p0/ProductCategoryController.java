package com.shop.shop_java.controller.p0;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/admin/extend/product_product_classify")
public class ProductCategoryController {

    @GetMapping("/list")
    public Map<String, Object> getList(@RequestParam(defaultValue = "1") int page,
                                       @RequestParam(defaultValue = "10") int limit,
                                       @RequestParam(required = false) String keyword) {
        List<Map<String, Object>> list = new ArrayList<>();
        String[] names = {"手机数码", "电脑办公", "家用电器", "服装服饰", "美妆护肤", "运动户外"};
        for(int i=0; i<names.length; i++) {
            if (keyword != null && !keyword.isEmpty() && !names[i].contains(keyword)) continue;
            Map<String, Object> map = new HashMap<>();
            map.put("id", i + 1);
            map.put("pic", "https://img.alicdn.com/tfs/TB1X7oXzXzqK1RjSZFjXXcbOXXa-512-512.png");
            map.put("cate_name", names[i]);
            map.put("sort", 100 - i);
            map.put("is_show", 1);
            map.put("create_time", "2024-01-10 10:00:00");
            list.add(map);
        }
        Map<String, Object> data = new HashMap<>();
        data.put("records", list);
        data.put("total", list.size());
        
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
