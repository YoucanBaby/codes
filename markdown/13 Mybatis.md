# 1. Mybatis 项目构建

1. 新建数据库

```sql
CREATE DATABASE `mybatis`;
USE `mybatis`;
DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
 `id` INT(20) NOT NULL,
 `name` VARCHAR(30) DEFAULT NULL,
 `pwd` VARCHAR(30) DEFAULT NULL,
 PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO `user`(`id`,`name`,`pwd`) VALUES 
(1,'yifang','123456'),
(2,'xiaoma','123456'),
(3,'root','123456');
```

<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210308152649245.png" alt="image-20210308152649245" style="zoom:80%;" />

2. 导入依赖

```xml
<!-- MySQL -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.16</version>
</dependency>
<!-- Mybatis -->
<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.4.6</version>
</dependency>
<!-- Junit -->
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.13</version>
    <scope>test</scope>
</dependency>
```

3. 配置resources，避免资源导出失败

```xml
<!--在build中配置resources，来防止我们资源导出失败的问题-->
<build>
    <resources>
        <resource>
            <directory>src/main/resources</directory>
            <includes>
                <include>**/*.properties</include>
                <include>**/*.xml</include>
            </includes>
            <filtering>true</filtering>
        </resource>
        <resource>
            <directory>src/main/java</directory>
            <includes>
                <include>**/*.properties</include>
                <include>**/*.xml</include>
            </includes>
            <filtering>true</filtering>
        </resource>
    </resources>
</build>
```

4. 编写核心配置文件mybatis-config.xml

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210308152739667.png" alt="image-20210308152739667" style="zoom:80%;" />


```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
"http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/mybatis?useUnicode=true&amp;characterEncoding=utf-8&amp;serverTimezone=UTC&amp;useSSL=false"/>
                <property name="username" value="root"/>
                <property name="password" value="123456"/>
            </dataSource>
        </environment>
    </environments>
    <mappers>
        <mapper resource="com/yifang/mapper/UserMapper.xml"/>
    </mappers>
</configuration>
```

5. 编写mybatis工具类

<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210308152321719.png" alt="image-20210308152321719" style="zoom: 80%;" />

```Java
public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //获取SqlSession连接
    public static SqlSession getSession(){
        return sqlSessionFactory.openSession();
    }
}
```

6. 创建实体类User

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210308153006936.png" alt="image-20210308153006936" style="zoom:80%;" />

```java
public class User {
    
    private int id; //id
    private String name; //姓名
    private String pwd; //密码
    
    //构造,有参,无参
    //set/get
    //toString()
}
```

7. 编写UserMapper接口类  

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210308154035676.png" alt="image-20210308154035676" style="zoom:80%;" />

```java
public interface UserMapper {
    List<User> selectUser();
}
```

8. 编写UserMapper.xml配置文件（代替以往的UserDaoImpl.java）

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210308154242259.png" alt="image-20210308154242259" style="zoom:80%;" />

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!-- 绑定一个对应的Dao/Mapper接口 -->
<mapper namespace="com.yifang.dao.UserMapper">
    <!-- SQL查询语句 -->
    <select id="selectUser" resultType="com.yifang.pojo.User">
        select * from user
    </select>
</mapper>
```

9. 在mybatis-config.xml中注册UserMapper.xml

<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210308155636025.png" alt="image-20210308155636025" style="zoom:80%;" />

```xml
<mappers>
    <mapper resource="com/yifang/dao/UserMapper.xml"></mapper>
</mappers>
```

问题：[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platfor

Maven 打包时有标题中警告，需要在pom.xml文件中添加
`<properties><project.build.sourceEncoding>UTF-8</project.build.sourceEncoding></properties>`

10. 创建test类

```java
public class test {
    @Test
    public void selectUser() {
        SqlSession session = null;
        try {
            session = MybatisUtils.getSession();

            UserMapper mapper = session.getMapper(UserMapper.class);
            List<User> users = mapper.selectUser();
            for (User user: users){
                System.out.println(user.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
```

<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210308170150773.png" alt="image-20210308170150773" style="zoom:80%;" />

# 2. CRUD

* crud：增加(Create)、检索(Retrieve)、更新(Update)和删除(Delete)-

1. UserMapper接口类

<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210308194805606.png" alt="image-20210308194805606" style="zoom: 80%;" />

```java
public interface UserMapper {

    // 添加用户（增）
    int addUser(User user);

    // 删除用户（删）
    int deleteUser(int id);

    // 修改用户（改）
    int updateUser(User user);

    // 列出所有用户（查）
    List<User> getUserList();

    // 根据ID查询所有用户（查）
    User getUserById(int id);
}
```

2. UserMapper.xml

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210308194945810.png" alt="image-20210308194945810" style="zoom:80%;" />

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.yifang.mapper.UserMapper">
    <insert id="addUser" parameterType="com.yifang.pojo.User">
        insert into user (id, name, pwd) values (#{id}, #{name}, #{pwd});
    </insert>

    <delete id="deleteUser" parameterType="com.yifang.pojo.User">
        delete from user where id = #{id};
    </delete>

    <update id="updateUser" parameterType="com.yifang.pojo.User">
        update user set name=#{name},pwd=#{pwd} where id = #{id};
    </update>

    <select id="getUserList" resultType="com.yifang.pojo.User">
        select * from user;
    </select>

    <select id="getUserById" parameterType="int" resultType="com.yifang.pojo.User">
        select * from user where id = #{id};
    </select>
</mapper>
```

3. test测试类

<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210308195138236.png" alt="image-20210308195138236" style="zoom:80%;" />


```java
public class test {
    // 增删改查需要提交事务
    @Test
    public void addUser() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        
        mapper.addUser(new User(4, "Elen", "123456"));

        session.commit();   // 提交事务
        session.close();
    }

    @Test
    public void deleteUser() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        mapper.deleteUser(4);

        session.commit();   // 提交事务
        session.close();
    }

    @Test
    public void updateUser() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        mapper.updateUser(new User(4, "Mikasa", "123456"));

        session.commit();   // 提交事务
        session.close();
    }

    @Test
    public void getUserList() {
        SqlSession session = MybatisUtils.getSession();

        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.getUserList();
        for (User user: users){
            System.out.println(user.toString());
        }
        session.close();
    }

    @Test
    public void getUserById() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
        session.close();
    }
}
```

4. 万能Map

* UserMapper接口

```java
int addUser2(Map<String, Object> map);
```

* UserMapper.xml

```xml
<insert id="addUser2" parameterType="map">
    insert into user (id, name, pwd) values (#{id}, #{name}, #{pwd});
</insert>
```

* Test测试类

```java
@Test
public void addUser2() {
    SqlSession session = MybatisUtils.getSession();
    UserMapper mapper = session.getMapper(UserMapper.class);

    Map<String, Object> map = new HashMap<>();
    map.put("id", 6);
    map.put("name", "Mikasa");
    map.put("pwd", "123456");

    mapper.addUser2(map);
    session.commit();   // 提交事务
    session.close();
}
```

<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210309083916586.png" alt="image-20210309083916586" style="zoom:80%;" />

5. 模糊查询

* UserMapper接口

```java
List<User> getUserByName(String value);
```

* UserMapper.xml

```xml
<select id="getUserByName" resultType="com.yifang.pojo.User">
    select * from user where name like "%"#{value}"%";
</select>
```

* Test测试类

```java
@Test
public void getUserByName() {
    SqlSession session = MybatisUtils.getSession();
    UserMapper mapper = session.getMapper(UserMapper.class);

    List<User> users = mapper.getUserByName("i");
    for (User user: users){
        System.out.println(user.toString());
    }
    session.close();
}
```

<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210309090713122.png" alt="image-20210309090713122" style="zoom:80%;" />

# 3. 配置解析

## 3.1 引入外部配置文件（properties）

1. 新建外部配置文件（数据库的配置文件）db.properties

<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210309093311276.png" alt="image-20210309093311276" style="zoom:80%;" />

```properties
driver=com.mysql.cj.jdbc.Driver
url=jdbc:mysql://localhost:3306/mybatis?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC&useSSL=false
username=root
password=123456
```

2. 修改mybatis-config.xml

```xml
<!-- 引入外部配置文件 -->
<properties resource="db.properties"/>

<environments default="development">
    <environment id="development">
        <transactionManager type="JDBC"/>
        <dataSource type="POOLED">
            <property name="driver" value="${driver}"/>
            <property name="url" value="${url}"/>
            <property name="username" value="${username}"/>
            <property name="password" value="${password}"/>
        </dataSource>
    </environment>
</environments>
```

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210309093716033.png" alt="image-20210309093716033" style="zoom:80%;" />

## 3.2 配置别名（typeAliases）

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210309100259264.png" alt="image-20210309100259264" style="zoom:80%;" />

```xml
<!-- 可以给实体类起别名 -->
<typeAliases>
    <package name="com.yifang.pojo"/>
</typeAliases>
```



<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210309095735796.png" alt="image-20210309095735796" style="zoom:80%;" />

* resultType中的名称默认是`com.yifang.pojo`下 Java Bean 的名称，官方推荐首字母小写（大写也能识别）

* 可以通过添加注解@Alias("别名")，更改别名

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210309100340766.png" alt="image-20210309100340766" style="zoom:80%;" />

**Java 类型对应的别名**

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210309152853611.png" alt="image-20210309152853611" style="zoom:80%;" />

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210309152904184.png" alt="image-20210309152904184" style="zoom:80%;" />

## 3.3 映射器（Mapper）

* Mapper：定义映射SQL语句文件 ，即告诉 MyBatis 到哪里去找到这些语句  

```xml
<mappers>
    <mapper resource="com/yifang/mapper/UserMapper.xml"/>
</mappers>
```
<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210309102754319.png" alt="image-20210309102754319" style="zoom:80%;" />

`UserMapper.xml`

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210309102841730.png" alt="image-20210309102841730" style="zoom:80%;" />



# 4. 解决属性名和字段名不一致的问题 （ResultMap）

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210309111416812.png" alt="image-20210309111416812" style="zoom:80%;" />

* 如果表user中的字段pwd，不叫pwd，改为password，而在Mybatis中我们想使用pwd字段，这时候就得使用ResultMap

在`UserMapper.xml`中使用ResultMap

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210309111815886.png" alt="image-20210309111815886" style="zoom:80%;" />

```xml
<select id="getUserByIdMap" resultMap="UserMap">
    select * from user where name like "%"#{value}"%";
</select>

<resultMap id="UserMap" type="User">
    <result column="pwd" property="password"/>
</resultMap>
```

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210309112643833.png" alt="image-20210309112643833" style="zoom:80%;" />

# 5. 实现分页

## 5.1 日志工厂

对于以往的开发过程，我们会经常使用到debug模式来调节，跟踪我们的代码执行过程。但是现在使用
Mybatis是基于接口，配置文件的源代码执行过程。因此，我们必须选择日志工具来作为我们开发，调
节程序的工具。

Mybatis内置的日志工厂提供日志功能，具体的日志实现有以下几种工具：

* SLF4J
* Apache Commons Logging
* Log4j 2
* <font color='red'>Log4j</font> （掌握）
* <font color='red'>STDOUT_LOGGING</font> （掌握）
* JDK logging  

```xml
<settings>
    <setting name="logImpl" value="STDOUT_LOGGING"/>
</settings>
```

<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210309143111606.png" alt="image-20210309143111606" style="zoom:80%;" />

输出：

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210309143129836.png" alt="image-20210309143129836" style="zoom:80%;" />

## 5.2 log4j

* log4j是Apache的一个开源项目
* 通过使用log4j，我们可以控制日志信息输送的目的地：控制台，文本，GUI组件....
* 我们也可以控制每一条日志的输出格式；  

使用步骤：

1. 导入log4j的依赖

```xml
<!-- https://mvnrepository.com/artifact/log4j/log4j -->
<dependency>
    <groupId>log4j</groupId>
    <artifactId>log4j</artifactId>
    <version>1.2.17</version>
</dependency>
```

2. 编写配置文件`log4j.properties`

<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210309145243661.png" alt="image-20210309145243661" style="zoom:80%;" />

```properties
#将等级为DEBUG的日志信息输出到console和file这两个目的地，console和file的定义在下面的代码
log4j.rootLogger=DEBUG,console,file

#控制台输出的相关设置
log4j.appender.console = org.apache.log4j.ConsoleAppender
log4j.appender.console.Target = System.out
log4j.appender.console.Threshold=DEBUG
log4j.appender.console.layout = org.apache.log4j.PatternLayout
log4j.appender.console.layout.ConversionPattern=[%c]-%m%n

#文件输出的相关设置
log4j.appender.file = org.apache.log4j.RollingFileAppender
log4j.appender.file.File=./log/kuang.log
log4j.appender.file.MaxFileSize=10mb
log4j.appender.file.Threshold=DEBUG
log4j.appender.file.layout=org.apache.log4j.PatternLayout
log4j.appender.file.layout.ConversionPattern=[%p][%d{yy-MM-dd}][%c]%m%n

#日志输出级别
log4j.logger.org.mybatis=DEBUG
log4j.logger.java.sql=DEBUG
log4j.logger.java.sql.Statement=DEBUG
log4j.logger.java.sql.ResultSet=DEBUG
log4j.logger.java.sql.PreparedStatement=DEBUG
```

3. 在`mybatis-config.xml`中修改setting设置

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210309145421475.png" alt="image-20210309145421475" style="zoom:80%;" />

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210309145519110.png" alt="image-20210309145519110" style="zoom:80%;" />

```xml
<settings>
    <setting name="logImpl" value="log4j"/>
</settings>
```

4. 在`test`类中使用Log4j进行输出！  

```java
//注意导包：org.apache.log4j.Logger
static Logger logger = Logger.getLogger(test.class);

@Test
public void getUserByName2() {
    logger.info("info：进入selectUser方法");
    logger.debug("debug：进入selectUser方法");
    logger.error("error: 进入selectUser方法");
    SqlSession session = MybatisUtils.getSession();
    UserMapper mapper = session.getMapper(UserMapper.class);
    List<User> users = mapper.getUserByName("i");
    for (User user: users){
        System.out.println(user);
    }
    session.close();
}
```

结果输出：

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210309150105354.png" alt="image-20210309150105354" style="zoom:80%;" />

## 5.3 limit实现分页

**使用limit实现分页**

```sql
#语法
SELECT * FROM table LIMIT stratIndex，pageSize
SELECT * FROM table LIMIT 5,10; // 检索记录行 6-15  

#如果只给定一个参数，它表示返回最大的记录行数目：
SELECT * FROM table LIMIT 5; //检索前 5 个记录行
#换句话说，LIMIT n 等价于 LIMIT 0,n。
```

**在Mybatis中使用limit实现分页**

1. `UserMapper`接口

```java
// 选择全部用户实现分页（查）
List<User> selectUser(Map<String,Integer> map);
```

2. `UserMapper.xml`

```xml
<select id="selectUser" parameterType="map" resultType="user">
    select * from user limit #{startIndex},#{pageSize}
</select>
```

3. `test`类

```java
//分页查询 , 两个参数startIndex , pageSize
@Test
public void testSelectUser() {
    SqlSession session = MybatisUtils.getSession();
    UserMapper mapper = session.getMapper(UserMapper.class);
    int currentPage = 2;    // 第几页
    int pageSize = 2;       // 每页显示几个
    Map<String,Integer> map = new HashMap<String,Integer>();
    map.put("startIndex", (currentPage-1)*pageSize);
    map.put("pageSize", pageSize);
    List<User> users = mapper.selectUser(map);
    for (User user: users){
        System.out.println(user);
    }
    session.close();
}
```

输出结果：

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210309153717658.png" alt="image-20210309153717658" style="zoom:80%;" />

## 5.4 PageHelper  

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210309154528784.png" alt="image-20210309154528784" style="zoom: 50%;" />

万一哪一天用到了呢

https://pagehelper.github.io/

# 6. Mybatis执行流程

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210309164337125.png" alt="image-20210309164337125" style="zoom:80%;" />

# 6. 注解开发

* sql 类型主要分成 :  
  * @select ()
  * @update ()
  * @Insert ()
  * @delete ()  

**【注意】**利用注解开发就不需要`mapper.xml`映射文件了 .  

## 6.1 查（注解）

1. 在`mybatis-config.xml`（核心配置文件）中注入  `com.yifang.mapper.UserMapper`

```xml
<!-- 使用class绑定接口 -->
<mappers>
    <mapper class="com.yifang.mapper.UserMapper"/>
</mappers>
```

2. 在`UserMapper接口`中添加注解  

```java
// 查询所有用户
@Select("select * from user")
List<User> getAllUser();
```

3. `test`类

```java
@Test
public void testGetAllUser() {
    SqlSession session = MybatisUtils.getSession();
    // 本质上利用了jvm的动态代理机制
    UserMapper mapper = session.getMapper(UserMapper.class);
    List<User> users = mapper.getAllUser();
    for (User user : users){
        System.out.println(user);
    }
    session.close();
}
```

## 6.2 Mybatis自动提交事务

在`MybatisUtils`下修改

<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210309171959564.png" alt="image-20210309171959564" style="zoom:80%;" />

```java
public static SqlSession getSession(){
    return sqlSessionFactory.openSession(true);
}
```

## 6.3 增删改

### 6.3.1 增

```java
// 添加一个用户
@Insert("insert into user(id,name,pwd) values (#{id},#{name},#{pwd})")
int addUser(User user);
```

```java
@Test
public void addUser() {
    SqlSession session = MybatisUtils.getSession();
    UserMapper mapper = session.getMapper(UserMapper.class);
    mapper.addUser(new User(6, "Armin", "123456"));
    session.close();
}
```

### 6.3.2 删

<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210310090814920.png" alt="image-20210310090814920" style="zoom:80%;" />

```java
// 删除用户
@Delete("delete from user where id=#{id}")
int delete(@Param("id") int id);
```

```java
@Test
public void deleteUser() {
    SqlSession session = MybatisUtils.getSession();
    UserMapper mapper = session.getMapper(UserMapper.class);
    mapper.delete(6);
    session.close();
}
```

### 6.3.3 改

```java
// 更新用户
@Update("update user set name=#{name}, pwd=#{pwd} where id=#{id}")
int updateUser(User user);
```

```java
@Test
public void updateUser() {
    SqlSession session = MybatisUtils.getSession();
    UserMapper mapper = session.getMapper(UserMapper.class);
    mapper.updateUser(new User(6, "Ymir", "123456"));
    session.close();
}
```

* 参数有**int**，**String** 等Java内置类的时候加入 **@Param("内容")** 

## 6.4 Lombok插件使用

* Lombok用于简化pojo处的代码，代码简洁，但降低了代码的可读性

1. 添加Lombok依赖

```xml
<!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.12</version>
    <scope>provided</scope>
</dependency>
```

2. **@Data**

```java
@Data
```

* 使用**@Data**会自动生成  无参构造器，get/set，equals，hashCode，toString

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210310093538629.png" alt="image-20210310093538629" style="zoom:80%;" />

3. **@AllArgsConstructor**

```java
@AllArgsConstructor
```

* 使用**@AllArgsConstructor**会自动生成 有参构造器

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210310094322315.png" alt="image-20210310094322315" style="zoom:80%;" />

4. **@NoArgsConstructor**

```java
@NoArgsConstructor
```

* 使用**NoArgsConstructor**会自动生成 无参构造器

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210310094224683.png" alt="image-20210310094224683" style="zoom:80%;" />

5. 也可以自己写构造器，并不冲突

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210310094434957.png" alt="image-20210310094434957" style="zoom:80%;" />

# 7. 多对一的处理

1. 新建多对一的表：teacher和student

```sql
USE `mybatis`;
DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
 `id` INT(10) NOT NULL,
 `name` VARCHAR(30) DEFAULT NULL,
 PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO teacher(`id`, `name`) VALUES (1, 'yifang');

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
 `id` INT(10) NOT NULL,
 `name` VARCHAR(30) DEFAULT NULL,
 `tid` INT(10) DEFAULT NULL,
 PRIMARY KEY (`id`),
 KEY `fktid` (`tid`),
 CONSTRAINT `fktid` FOREIGN KEY (`tid`) REFERENCES `teacher` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO `student` (`id`, `name`, `tid`) VALUES 
(1, 'Elen', 1),
(2, 'Mikasa', 1),
(3, 'Armin', 1),
(4, 'Ymir', 1),
(5, 'Reiner', 1);
```

设计teacher对应多个student

<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210310103443699.png" alt="image-20210310103443699" style="zoom:80%;" />

2. 在`pojo`下新建对应的Java Bean

<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210310104357575.png" alt="image-20210310104357575" style="zoom:80%;" />

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    private int id;
    private String name;
}
```

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    private String name;
    private int tid;
}
```

3. 编写对应的Mapper接口

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210310105018218.png" alt="image-20210310105018218" style="zoom:80%;" />

4. 新建对应的Mapper.xml（不一定会使用，但也要写，以备不时之需）

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210310105057706.png" alt="image-20210310105057706" style="zoom:80%;" />

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.yifang.dao.TeacherMapper">

</mapper>
```

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.yifang.dao.StudentMapper">

</mapper>
```

# 8. 一对多的处理

# 9. 动态SQL

* 什么是动态SQL：动态SQL指的是**根据不同的查询条件 , 生成不同的Sql语句.**  

* 动态SQL关键字：
* \-------------------------------
  \- if
  \- choose (when, otherwise)
  \- trim (where, set)
  \- foreach
  \-------------------------------  

## 9.1 搭建环境

新建一个数据库表：blog
字段：id，title，author，create_time，views  

```sql
USE `mybatis`;
DROP TABLE IF EXISTS `blog`;

CREATE TABLE `blog` (
`id` VARCHAR(50) NOT NULL COMMENT '博客id',
`title` VARCHAR(100) NOT NULL COMMENT '博客标题',
`author` VARCHAR(30) NOT NULL COMMENT '博客作者',
`create_time` DATETIME NOT NULL COMMENT '创建时间',
`views` INT(30) NOT NULL COMMENT '浏览量'
) ENGINE=INNODB DEFAULT CHARSET=utf8
```

<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210311090111835.png" alt="image-20210311090111835" style="zoom:80%;" />

1. 创建`IdUtils`工具类

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210311090347398.png" alt="image-20210311090347398" style="zoom:80%;" />

```java
public class IdUtils {
    public static String genId() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
```

2. 编写`Blog` Java Bean

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210311090452663.png" alt="image-20210311090452663" style="zoom:80%;" />

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    private String id;
    private String title;
    private String author;
    private Date createTime;
    private int views;
}
```

3. mybatis-config.xml

* 下划线驼峰自动转换

```java
<settings>
    <setting name="logImpl" value="log4j"/>
    <setting name="mapUnderscoreToCamelCase" value="true"/>
</settings>
```

4. `BlogMapper.java` 与 `BlogMapper.xml`

```java
public interface BlogMapper {
}
```

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.yifang.dao.BlogMapper">

</mapper>
```

6. 初始化数据

`BlogMapper.java`

```java
//新增一个博客
int addBlog(Blog blog);
```

`BlogMapper.xml`

```xml
<insert id="addBlog" parameterType="blog">
    insert into blog (id, title, author, create_time, views)
    values (#{id},#{title},#{author},#{createTime},#{views});
</insert>
```

`初始化博客`方法  

```java
@Test
public void addInitBlog(){
    SqlSession session = MybatisUtils.getSession();
    BlogMapper mapper = session.getMapper(BlogMapper.class);
    Blog blog = new Blog();
    blog.setId(IdUtils.genId());
    blog.setTitle("Mybatis如此简单");
    blog.setAuthor("yifang");
    blog.setCreateTime(new Date());
    blog.setViews(9999);
    mapper.addBlog(blog);

    blog.setId(IdUtils.genId());
    blog.setTitle("Java如此简单");
    blog.setAuthor("yifang");
    blog.setCreateTime(new Date());
    blog.setViews(41241);
    mapper.addBlog(blog);

    blog.setId(IdUtils.genId());
    blog.setTitle("Spring如此简单");
    blog.setAuthor("yifang");
    blog.setCreateTime(new Date());
    blog.setViews(412412);
    mapper.addBlog(blog);

    blog.setId(IdUtils.genId());
    blog.setTitle("微服务如此简单");
    blog.setAuthor("yifang");
    blog.setCreateTime(new Date());
    blog.setViews(4894);
    mapper.addBlog(blog);

    session.close();
}
```

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210311091617010.png" alt="image-20210311091617010" style="zoom:80%;" />

## 9.2 if

`BlogMapper.java`

```java
List<Blog> queryBlogIf(Map map);
```

`BlogMapper.xml`

```xml
<select id="queryBlogIf" parameterType="map" resultType="blog">
    select * from blog
    <where>
        <if test="title != null">
            title = #{title}
        </if>
        <if test="author != null">
            and author = #{author}
        </if>
    </where>
</select>
```

`test`测试类

```java
@Test
public void testQueryBlogIf(){
    SqlSession session = MybatisUtils.getSession();
    BlogMapper mapper = session.getMapper(BlogMapper.class);

    HashMap<String, String> map = new HashMap<String, String>();
    // map.put("title","Mybatis如此简单");
    map.put("author","yifang");

    List<Blog> blogs = mapper.queryBlogIf(map);
    System.out.println(blogs);
    session.close();
}
```

## 9.3 where

* **where** 元素知道**只有在一个以上的if条件有值的情况下才去插入“WHERE”子句**。而且，若最后的内容是“AND”或“OR”开头的，where 元素也知道如何将他们去除。  

见9.2的例子

## 9.4 set

* **用于动态更新语句**的解决方案叫做 **set**。set 元素可以被用于动态包含需要更新的列，而舍去其他的 。

`BlogMapper.java`

```java
int updateBlog(Map map);
```

`BlogMapper.xml`

```xml
<update id="updateBlog" parameterType="map">
    update blog
    <set>
        <if test="title != null">
            title = #{title},
        </if>
        <if test="author != null">
            author = #{author}
        </if>
    </set>
    where id = #{id};
</update>
```

`test`测试类

```java
@Test
public void testUpdateBlog(){
    SqlSession session = MybatisUtils.getSession();
    BlogMapper mapper = session.getMapper(BlogMapper.class);
    HashMap<String, String> map = new HashMap<String, String>();
    map.put("title","动态SQL");
    map.put("author","yifang");
    map.put("id","7ab145b0cf8f4b10a4a080d009c495b5");
    mapper.updateBlog(map);
    session.close();
}
```

## 9.5 choose  

* 有些时候，**我们不想用到所有的条件语句，而只想从中择其一二**。针对这种情况，MyBatis 提供了 **choose** 元素，**它有点像 Java 中的switch 语句**。  

`BlogMapper.java`

```java
List<Blog> queryBlogChoose(Map map);
```

`BlogMapper.xml`

```xml
<select id="queryBlogChoose" parameterType="map" resultType="blog">
    select * from blog
    <where>
        <choose>
            <when test="title != null">
                title = #{title}
            </when>
            <when test="author != null">
                and author = #{author}
            </when>
            <otherwise>
                and views = #{views}
            </otherwise>
        </choose>
    </where>
</select>
```

`test`测试类

```java
@Test
public void testQueryBlogChoose(){
    SqlSession session = MybatisUtils.getSession();
    BlogMapper mapper = session.getMapper(BlogMapper.class);
    HashMap<String, Object> map = new HashMap<String, Object>();
    map.put("title","Java如此简单");
    map.put("author","yifang");
    map.put("views",9999);
    List<Blog> blogs = mapper.queryBlogChoose(map);
    System.out.println(blogs);
    session.close();
}
```

## 9.6 SQL片段

提取SQL片段：

```xml
<sql id="if-title-author">
    <if test="title != null">
        title = #{title}
    </if>
    <if test="author != null">
        and author = #{author}
    </if>
</sql>
```

引用SQL片段：

```xml
<select id="queryBlogIf" parameterType="map" resultType="blog">
    select * from blog
    <where>
    	<!-- 引用 sql 片段，如果refid 指定的不在本文件中，那么需要在前面加上 namespace-->
    <include refid="if-title-author"></include>
    	<!-- 在这里还可以引用其他的 sql 片段 -->
    </where>
</select>
```

注意：①、最好基于 单表来定义 sql 片段，提高片段的可重用性
②、在 sql 片段中不要包括 where  

## 9.7 foreach

动态 SQL 的另外一个常用的必要操作是需要对一个集合进行遍历，通常是在构建 IN 条件语句的时候  

`BlogMapper.java`

```java
List<Blog> queryBlogForeach(Map map);
```

`BlogMapper.xml`

```xml
<select id="queryBlogForeach" parameterType="map" resultType="blog">
    select * from blog
    <where>
        <!--
        collection:指定输入对象中的集合属性
        item:每次遍历生成的对象
        open:开始遍历时的拼接字符串
        close:结束时拼接的字符串
        separator:遍历对象之间需要拼接的字符串
        select * from blog where 1=1 and (id=1 or id=2 or id=3)
        -->
        <foreach collection="ids" item="id" open="and (" close=")" separator="or">
            id=#{id}
        </foreach>
    </where>
</select>
```

`test`测试类

```java
@Test
public void testQueryBlogForeach(){
    SqlSession session = MybatisUtils.getSession();
    BlogMapper mapper = session.getMapper(BlogMapper.class);
    HashMap map = new HashMap();
    List<Integer> ids = new ArrayList<Integer>();
    ids.add(1);
    ids.add(2);
    ids.add(3);
    map.put("ids",ids);
    List<Blog> blogs = mapper.queryBlogForeach(map);
    System.out.println(blogs);
    session.close();
}
```

小结：其实动态 sql 语句的编写往往就是一个拼接的问题，为了保证拼接准确，我们最好首先要写原生
的 sql 语句出来，然后在通过 mybatis 动态sql 对照着改，防止出错。多在实践中使用才是熟练掌握它
的技巧  

# 10. 缓存（了解）

## 10.1 简介

1. 什么是缓存 [ **Cache** ]？
   * 存在内存中的临时数据。
   * 将用户经常查询的数据放在缓存（内存）中，用户去查询数据就不用从磁盘上(关系型数据库
     数据文件)查询，从缓存中查询，从而提高查询效率，解决了高并发系统的性能问题。

2. 为什么使用缓存？
   * 减少和数据库的交互次数，减少系统开销，提高系统效率。
   
3. 什么样的数据能使用缓存？
   * 经常查询并且不经常改变的数据。  	

## 10.2 Mybatis缓存
* MyBatis包含一个非常强大的查询缓存特性，它可以非常方便地定制和配置缓存。缓存可以极大的
  提升查询效率。
* MyBatis系统中默认定义了两级缓存：**一级缓存**和**二级缓存**
  * 默认情况下，只有一级缓存开启。（SqlSession级别的缓存，也称为本地缓存）
  * 二级缓存需要手动开启和配置，他是基于namespace级别的缓存。
  * 为了提高扩展性，MyBatis定义了缓存接口Cache。我们可以通过实现Cache接口来自定义二
    级缓存  

## 10.3 一级缓存
* 一级缓存也叫本地缓存：
  * 与数据库同一次会话期间查询到的数据会放在本地缓存中。
  * 以后如果需要获取相同的数据，直接从缓存中拿，没必须再去查询数据库；  

## 10.4 一级缓存失效的四种情况  

* 一级缓存是SqlSession级别的缓存，是一直开启的，我们关闭不了它；
* 一级缓存失效情况：没有使用到当前的一级缓存，效果就是，还需要再向数据库中发起一次查询请
  求！  

1. sqlSession不同  
   * 每个sqlSession中的缓存相互独立

2. sqlSession相同，查询条件不同  

3. sqlSession相同，两次查询之间执行了增删改操作  

4. sqlSession相同，手动清除一级缓存  

```java
@Test
public void testQueryUserById(){
    SqlSession session = MybatisUtils.getSession();
    UserMapper mapper = session.getMapper(UserMapper.class);
    
    mapper.操作1();
    
    session.clearCache();	//手动清除缓存
    
    mapper.操作2();

    session.close();
}
```

## 10.5 二级缓存

* 二级缓存也叫全局缓存，一级缓存作用域太低了，所以诞生了二级缓存
* 基于namespace级别的缓存，一个名称空间，对应一个二级缓存；
* 工作机制
  * 一个会话查询一条数据，这个数据就会被放在当前会话的一级缓存中；
  * 如果当前会话关闭了，这个会话对应的一级缓存就没了；但是我们想要的是，会话关闭了，一
    级缓存中的数据被保存到二级缓存中；
  * 新的会话查询信息，就可以从二级缓存中获取内容；
  * 不同的mapper查出的数据会放在自己对应的缓存（map）中；  

### 10.5.1 使用步骤

1. 在`mybatis-config.xml`中开启全局缓存

```xml
<setting name="cacheEnabled" value="true"/>
```

2. 在`xxxMapper.xml`中配置二级缓存  

```xml
<cache/>

<cache
       eviction="FIFO"
       flushInterval="60000"
       size="512"
       readOnly="true"/>
```

3. 类所有的实体类先实现序列化（**Serializable**）接口  

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog implements Serializable {
    private String id;
    private String title;
    private String author;
    private Date createTime;
    private int views;
}
```

### 10.5.2 结论

* 只要开启了二级缓存，我们在同一个Mapper中的查询，可以在二级缓存中拿到数据
* 查出的数据都会被默认先放在一级缓存中
* 只有会话提交或者关闭以后，一级缓存中的数据才会转到二级缓存中  

## 10.6 Mybatis缓存原理

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210311112252049.png" style="zoom:80%;" />

## 10.7 EhCache

* 看看就行，缓存更多使用Redis

* Ehcache是一种广泛使用的java分布式缓存，用于通用缓存；  

1. `pom.xml`

```xml
<!-- https://mvnrepository.com/artifact/org.mybatis.caches/mybatis-ehcache -->
<dependency>
    <groupId>org.mybatis.caches</groupId>
    <artifactId>mybatis-ehcache</artifactId>
    <version>1.2.1</version>
</dependency>
```

2. `xxxMapper.xml`

```xml
<cache
    type="org.mybatis.caches.ehcache.EhcacheCache"
    eviction="FIFO"
    flushInterval="60000"
    size="512"
    readOnly="true"/>
```

3. `ehcache.xml`

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210311152659130.png" alt="image-20210311152659130" style="zoom:80%;" />

```xml
<?xml version="1.0" encoding="UTF-8"?>
<ehcache xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:noNamespaceSchemaLocation="http://ehcache.org/ehcache.xsd"
         updateCheck="false">
    <!--
    diskStore：为缓存路径，ehcache分为内存和磁盘两级，此属性定义磁盘的缓存位
    置。参数解释如下：
    user.home – 用户主目录
    user.dir – 用户当前工作目录
    java.io.tmpdir – 默认临时文件路径
    -->
    <diskStore path="./tmpdir/Tmp_EhCache"/>
    <defaultCache
            eternal="false"
            maxElementsInMemory="10000"
            overflowToDisk="false"
            diskPersistent="false"
            timeToIdleSeconds="1800"
            timeToLiveSeconds="259200"
            memoryStoreEvictionPolicy="LRU"/>
    <cache
            name="cloud_user"
            eternal="false"
            maxElementsInMemory="5000"
            overflowToDisk="false"
            diskPersistent="false"
            timeToIdleSeconds="1800"
            timeToLiveSeconds="1800"
            memoryStoreEvictionPolicy="LRU"/>
</ehcache>
```



# 11. 总结

1. `pom.xml`

```xml
<properties>
    <maven.compiler.source>8</maven.compiler.source>
    <maven.compiler.target>8</maven.compiler.target>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
</properties>

<dependencies>
    <!-- MySQL -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.16</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis</artifactId>
        <version>3.4.5</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/log4j/log4j -->
    <dependency>
        <groupId>log4j</groupId>
        <artifactId>log4j</artifactId>
        <version>1.2.17</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.12</version>
        <scope>provided</scope>
    </dependency>
    <!-- Junit -->
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13</version>
        <scope>test</scope>
    </dependency>
</dependencies>

<!--在build中配置resources，来防止我们资源导出失败的问题-->
<build>
    <resources>
        <resource>
            <directory>src/main/resources</directory>
            <includes>
                <include>**/*.properties</include>
                <include>**/*.xml</include>
            </includes>
            <filtering>true</filtering>
        </resource>
        <resource>
            <directory>src/main/java</directory>
            <includes>
                <include>**/*.properties</include>
                <include>**/*.xml</include>
            </includes>
            <filtering>true</filtering>
        </resource>
    </resources>
</build>
```

