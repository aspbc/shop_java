# shop_java（后端服务）

本项目为商城后端服务，基于 Spring Boot + MyBatis-Plus。

## 环境要求

- JDK：1.8（见 [pom.xml](file:///workspace/shop_java/pom.xml#L16-L20)）
- Maven：建议 3.8+
- MySQL/MariaDB：8.x / 10.x 均可

## 配置说明

默认配置文件为 [application.yml](file:///workspace/shop_java/src/main/resources/application.yml)：

- 后端端口：`8081`
- 数据库：`jdbc:mysql://localhost:3306/shop_db`
- 数据库用户：`shop_user`
- 数据库密码：`shop_pass`

如需改成本地自己的数据库账号/密码，请修改上述配置。

## 数据库初始化

项目提供了初始化 SQL：

- 表结构：[schema.sql](file:///workspace/shop_java/src/main/resources/schema.sql)
- 初始化数据：[data.sql](file:///workspace/shop_java/src/main/resources/data.sql)

示例（以本机 MySQL/MariaDB 为例）：

```bash
mysql -uroot -p -e "CREATE DATABASE IF NOT EXISTS shop_db DEFAULT CHARACTER SET utf8mb4;"
mysql -uroot -p shop_db < src/main/resources/schema.sql
mysql -uroot -p shop_db < src/main/resources/data.sql
```

## 启动方式

### 方式一：Maven 启动（推荐）

```bash
mvn spring-boot:run
```

### 方式二：打包后运行

```bash
mvn clean package -DskipTests
java -jar target/*.jar
```

启动后访问地址：

- 后端服务：http://localhost:8081/
- 接口基地址（示例）：http://localhost:8081/api/admin/

