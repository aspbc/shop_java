package com.shop.shop_java.controller.p0;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/admin/extend/order_invoice_list")
public class OrderInvoiceController {

    @GetMapping("/list")
    public Map<String, Object> getList(@RequestParam(defaultValue = "1") int page,
                                       @RequestParam(defaultValue = "10") int limit,
                                       @RequestParam(required = false) String keyword) {
        List<Map<String, Object>> list = new ArrayList<>();
        for(int i=0; i<4; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", i + 1);
            map.put("order_id", "INV" + (30000000000L + i * 11111));
            map.put("invoice_type", i % 2 + 1);
            map.put("header_type", i % 2 + 1);
            map.put("header_name", i % 2 == 0 ? "个人" : "某某科技有限公司");
            map.put("amount", String.format("%.2f", 500.0 + i * 200));
            map.put("status", i % 2);
            map.put("create_time", "2024-04-03 11:20:00");
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
