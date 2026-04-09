package com.shop.shop_java.controller.p0;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/admin/extend/product_product_reply")
public class ProductReplyController {

    @GetMapping("/list")
    public Map<String, Object> getList(@RequestParam(defaultValue = "1") int page,
                                       @RequestParam(defaultValue = "10") int limit,
                                       @RequestParam(required = false) String keyword,
                                       @RequestParam(required = false) String is_reply) {
        List<Map<String, Object>> list = new ArrayList<>();
        String[] products = {"Apple iPhone 15 Pro", "华为 Mate 60 Pro", "小米 14 Ultra"};
        String[] comments = {"非常不错，运行速度快！", "拍照很清晰，颜值高", "性价比很高，推荐购买"};
        
        for(int i=0; i<5; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", i + 1);
            map.put("image", "https://img.alicdn.com/tfs/TB1X7oXzXzqK1RjSZFjXXcbOXXa-512-512.png");
            map.put("store_name", products[i % products.length]);
            map.put("user_name", "用户_" + (1000 + i));
            map.put("score", 4 + (i % 2));
            map.put("comment", comments[i % comments.length]);
            map.put("is_reply", i % 2);
            map.put("create_time", "2024-03-05 15:30:00");
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

    @DeleteMapping("/delete")
    public Map<String, Object> delete(@RequestParam Integer id) {
        Map<String, Object> res = new HashMap<>();
        res.put("code", 200);
        res.put("msg", "删除成功");
        return res;
    }
}
