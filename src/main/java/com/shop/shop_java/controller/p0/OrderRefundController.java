package com.shop.shop_java.controller.p0;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/admin/extend/order_refund")
public class OrderRefundController {

    @GetMapping("/list")
    public Map<String, Object> getList(@RequestParam(defaultValue = "1") int page,
                                       @RequestParam(defaultValue = "10") int limit,
                                       @RequestParam(required = false) String keyword) {
        List<Map<String, Object>> list = new ArrayList<>();
        String[] reasons = {"拍错/多拍/不想要", "缺货", "商品与描述不符", "质量问题"};
        for(int i=0; i<5; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", i + 1);
            map.put("refund_order_sn", "REF" + (10000000000L + i * 12345));
            map.put("order_id", "WX" + (20000000000L + i * 54321));
            map.put("user_name", "买家" + i);
            map.put("refund_price", String.format("%.2f", 100.0 + i * 50));
            map.put("refund_reason", reasons[i % reasons.length]);
            map.put("status", i % 3 == 0 ? 0 : (i % 3 == 1 ? 1 : -1));
            map.put("create_time", "2024-04-02 09:15:00");
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
}
