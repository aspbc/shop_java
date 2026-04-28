import re

file_path = "/workspace/shop_java/src/main/java/com/shop/shop_java/controller/StoreProductController.java"

with open(file_path, "r", encoding="utf-8") as f:
    content = f.read()

# 1. Add class comment
content = content.replace(
    "@RestController\n@RequestMapping(\"/api/admin/store/product\")",
    "/**\n * 商品管理控制器\n * 提供后台商品列表、分类状态统计及操作等功能\n */\n@RestController\n@RequestMapping(\"/api/admin/store/product\")"
)

# 2. Add method comment for list
list_comment = """    /**
     * 获取商品分页列表
     * 核心逻辑：基于前端传入的 `type` 参数，结合多重字段状态（如是否删除、审核状态、库存等）返回对应分类数据。
     *
     * @param page        当前页码
     * @param limit       每页条数
     * @param keyword     商品搜索关键词（名称/关键字/ID）
     * @param type        商品状态分类页签（1=销售中, 2=仓库中, 4=已售罄, 5=库存预警, 6=回收站, 0=待审核, -1=审核未通过, -2=强制下架）
     * @param cateId      商品分类ID
     * @param productType 商品类型
     * @param priceMin    最低售价
     * @param priceMax    最高售价
     * @param salesMin    最低销量
     * @param salesMax    最高销量
     * @return 分页列表数据
     */
    @GetMapping("/list")"""
content = content.replace("    @GetMapping(\"/list\")", list_comment)

# 3. Add method comment for type_header
header_comment = """    /**
     * 获取商品各分类(Tab)状态数量统计
     * 针对所有 `type` 的查询，提取公共搜索条件以保证筛选时所有页签数值准确联动。
     *
     * @return 包含各分类对应数量的 Map (如：selling: 10, warehouse: 5...)
     */
    @GetMapping("/type_header")"""
content = content.replace("    @GetMapping(\"/type_header\")", header_comment)

# 4. Add more inline comments in `baseWrapper`
baseWrapper_comment = """        // 提取公共过滤条件构造器 (公用搜索条件：关键词、分类、价格范围、销量范围等)
        // 这样在计算各个状态数量时，都会自动叠加这些搜索限制
        java.util.function.Supplier<LambdaQueryWrapper<StoreProduct>> baseWrapper = () -> {"""
content = content.replace("        // Helper to create base wrapper with common filters\n        java.util.function.Supplier<LambdaQueryWrapper<StoreProduct>> baseWrapper = () -> {", baseWrapper_comment)

# 5. Add inline comments inside `list`'s type if-else
type_comment_old = """        if (type != null) {
            if (type == 6) {
                wrapper.eq(StoreProduct::getIsDel, 1);
            } else {
                wrapper.eq(StoreProduct::getIsDel, 0);
                if (type == 1) {
                    wrapper.eq(StoreProduct::getIsShow, 1).eq(StoreProduct::getIsVerify, 1);
                } else if (type == 2) {
                    wrapper.eq(StoreProduct::getIsShow, 0).eq(StoreProduct::getIsVerify, 1);
                } else if (type == 4) {
                    wrapper.eq(StoreProduct::getIsVerify, 1).and(w -> w.eq(StoreProduct::getIsSold, 1).or().le(StoreProduct::getStock, 0));
                } else if (type == 5) {
                    wrapper.eq(StoreProduct::getIsShow, 1).eq(StoreProduct::getIsVerify, 1).eq(StoreProduct::getIsPolice, 1).gt(StoreProduct::getStock, 0);
                } else if (type == 0) {
                    wrapper.eq(StoreProduct::getIsVerify, 0);
                } else if (type == -1) {
                    wrapper.eq(StoreProduct::getIsVerify, -1);
                } else if (type == -2) {
                    wrapper.eq(StoreProduct::getIsVerify, -2);
                }
            }
        } else {
            wrapper.eq(StoreProduct::getIsDel, 0);
        }"""

type_comment_new = """        // 根据状态类型(type)动态追加底层数据库状态字段的过滤条件
        // 实现了与 PHP 原版 100% 相同的组合查询逻辑
        if (type != null) {
            if (type == 6) {
                // 回收站：仅过滤被删除的 (is_del = 1)
                wrapper.eq(StoreProduct::getIsDel, 1);
            } else {
                // 非回收站：过滤未被删除的
                wrapper.eq(StoreProduct::getIsDel, 0);
                if (type == 1) {
                    // 销售中：已上架 (is_show=1) 且 审核通过 (is_verify=1)
                    wrapper.eq(StoreProduct::getIsShow, 1).eq(StoreProduct::getIsVerify, 1);
                } else if (type == 2) {
                    // 仓库中(下架)：已下架 (is_show=0) 且 审核通过
                    wrapper.eq(StoreProduct::getIsShow, 0).eq(StoreProduct::getIsVerify, 1);
                } else if (type == 4) {
                    // 已售罄：审核通过 且 (标记售罄(is_sold=1) 或 真实库存<=0)
                    wrapper.eq(StoreProduct::getIsVerify, 1).and(w -> w.eq(StoreProduct::getIsSold, 1).or().le(StoreProduct::getStock, 0));
                } else if (type == 5) {
                    // 库存预警：已上架、审核通过、触发预警标记(is_police=1) 且 真实库存>0
                    wrapper.eq(StoreProduct::getIsShow, 1).eq(StoreProduct::getIsVerify, 1).eq(StoreProduct::getIsPolice, 1).gt(StoreProduct::getStock, 0);
                } else if (type == 0) {
                    // 待审核：审核状态为待定(is_verify=0)
                    wrapper.eq(StoreProduct::getIsVerify, 0);
                } else if (type == -1) {
                    // 审核未通过
                    wrapper.eq(StoreProduct::getIsVerify, -1);
                } else if (type == -2) {
                    // 强制下架
                    wrapper.eq(StoreProduct::getIsVerify, -2);
                }
            }
        } else {
            // 默认查未被删除的商品
            wrapper.eq(StoreProduct::getIsDel, 0);
        }"""
content = content.replace(type_comment_old, type_comment_new)

with open(file_path, "w", encoding="utf-8") as f:
    f.write(content)
