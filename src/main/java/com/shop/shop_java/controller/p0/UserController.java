package com.shop.shop_java.controller.p0;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.shop_java.entity.SysUser;
import com.shop.shop_java.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/extend/user_list")
public class UserController {

    @Autowired
    private SysUserMapper sysUserMapper;

    @GetMapping("/list")
    public Map<String, Object> getList(@RequestParam(defaultValue = "1") int page,
                                       @RequestParam(defaultValue = "10") int limit,
                                       @RequestParam(required = false) String keyword,
                                       @RequestParam(required = false) String level) {
        
        Page<SysUser> pageParam = new Page<>(page, limit);
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        
        if (keyword != null && !keyword.isEmpty()) {
            queryWrapper.and(wrapper -> 
                wrapper.like(SysUser::getNickname, keyword)
                       .or()
                       .like(SysUser::getPhone, keyword)
            );
        }
        
        if (level != null && !level.isEmpty()) {
            if ("0".equals(level)) {
                queryWrapper.eq(SysUser::getLevelName, "普通用户");
            } else if ("1".equals(level)) {
                queryWrapper.eq(SysUser::getLevelName, "VIP会员");
            }
        }
        
        queryWrapper.orderByDesc(SysUser::getCreateTime);
        
        sysUserMapper.selectPage(pageParam, queryWrapper);

        Map<String, Object> data = new HashMap<>();
        data.put("records", pageParam.getRecords());
        data.put("total", pageParam.getTotal());
        
        Map<String, Object> res = new HashMap<>();
        res.put("code", 200);
        res.put("msg", "success");
        res.put("data", data);
        return res;
    }

    @PostMapping("/add")
    public Map<String, Object> add(@RequestBody SysUser sysUser) {
        sysUserMapper.insert(sysUser);
        Map<String, Object> res = new HashMap<>();
        res.put("code", 200);
        res.put("msg", "添加成功");
        return res;
    }

    @PutMapping("/update")
    public Map<String, Object> update(@RequestBody SysUser sysUser) {
        sysUserMapper.updateById(sysUser);
        Map<String, Object> res = new HashMap<>();
        res.put("code", 200);
        res.put("msg", "修改成功");
        return res;
    }

    @DeleteMapping("/delete")
    public Map<String, Object> delete(@RequestParam Integer id) {
        sysUserMapper.deleteById(id);
        Map<String, Object> res = new HashMap<>();
        res.put("code", 200);
        res.put("msg", "删除成功");
        return res;
    }
}
