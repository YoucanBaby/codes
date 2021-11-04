![image-20210224165352208](https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210224165352208.png)

# 1. 新建Servlet-Tomcat项目

## 1.1 创建项目

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210303140210537.png" alt="image-20210303140210537" style="zoom:80%;" />

## 1.2 新建java和resources文件夹

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210303140304388.png" alt="image-20210303140304388" style="zoom:80%;" />

## 1.3 添加依赖

```xml
<dependencies>
    <!-- Servlet 依赖 -->
    <!-- https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api -->
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>javax.servlet-api</artifactId>
        <version>3.1.0</version>
        <scope>provided</scope>
    </dependency>
    <!-- JSP 依赖 -->
    <!-- https://mvnrepository.com/artifact/javax.servlet.jsp/javax.servlet.jsp-api -->
    <dependency>
        <groupId>javax.servlet.jsp</groupId>
        <artifactId>javax.servlet.jsp-api</artifactId>
        <version>2.3.1</version>
        <scope>provided</scope>
    </dependency>
    <!-- JSTL表达式 依赖 -->
    <!-- https://mvnrepository.com/artifact/javax.servlet.jsp.jstl/jstl-api -->
    <dependency>
        <groupId>javax.servlet.jsp.jstl</groupId>
        <artifactId>jstl-api</artifactId>
        <version>1.2</version>
    </dependency>
    <!-- standard标签库 依赖 -->
    <!-- https://mvnrepository.com/artifact/taglibs/standard -->
    <dependency>
        <groupId>taglibs</groupId>
        <artifactId>standard</artifactId>
        <version>1.1.2</version>
    </dependency>
    <!--mysql的驱动-->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>5.1.47</version>
    </dependency>
    <!--单元测试-->
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.11</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

## 1.4 新建Servlet.java

* 继承HttpServlet

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210303141002699.png" alt="image-20210303141002699" style="zoom:80%;" />

* 重写doGet()与doPost()方法

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210303141114782.png" alt="image-20210303141114782" style="zoom:80%;" />

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210303141148859.png" alt="image-20210303141148859" style="zoom:80%;" />

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210303141212370.png" alt="image-20210303141212370" style="zoom: 80%;" />

* 创建成功的样子

```java
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
```

## 1.5 在web.xml中注册Servlet

```xml
	<!-- 注册Servlet -->
    <servlet>
        <servlet-name>Servlet</servlet-name>
        <servlet-class>com.yifang.servlet.Servlet</servlet-class>
    </servlet>
	<!-- Servlet的请求路径 -->
    <servlet-mapping>
        <servlet-name>Servlet</servlet-name>
        <url-pattern>/s</url-pattern>
    </servlet-mapping>
```

## 1.6 新建Tomcat

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210303143545007.png" alt="image-20210303143545007" style="zoom:80%;" />

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210303143608837.png" alt="image-20210303143608837" style="zoom:80%;" />

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210303143805437.png" alt="image-20210303143805437" style="zoom:80%;" />

![image-20210303143911286](https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210303143911286.png)

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210303144006947.png" alt="image-20210303144006947" style="zoom:80%;" />

## 1.7 文件结构

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210304112746234.png" alt="image-20210304112746234" style="zoom:80%;" />

# 2. 新建Servlet-Tomcat项目

## 2.1 添加Web Application

* 新建一个空项目后，再添加Web Application

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210304111606906.png" alt="image-20210304111606906" style="zoom:80%;" />

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210304111641374.png" alt="image-20210304111641374" style="zoom:80%;" />

## 2.2 添加依赖

```xml
<dependencies>
    <!-- Servlet 依赖 -->
    <!-- https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api -->
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>javax.servlet-api</artifactId>
        <version>3.1.0</version>
        <scope>provided</scope>
    </dependency>
    <!-- JSP 依赖 -->
    <!-- https://mvnrepository.com/artifact/javax.servlet.jsp/javax.servlet.jsp-api -->
    <dependency>
        <groupId>javax.servlet.jsp</groupId>
        <artifactId>javax.servlet.jsp-api</artifactId>
        <version>2.3.1</version>
        <scope>provided</scope>
    </dependency>
    <!-- JSTL表达式 依赖 -->
    <!-- https://mvnrepository.com/artifact/javax.servlet.jsp.jstl/jstl-api -->
    <dependency>
        <groupId>javax.servlet.jsp.jstl</groupId>
        <artifactId>jstl-api</artifactId>
        <version>1.2</version>
    </dependency>
    <!-- standard标签库 依赖 -->
    <!-- https://mvnrepository.com/artifact/taglibs/standard -->
    <dependency>
        <groupId>taglibs</groupId>
        <artifactId>standard</artifactId>
        <version>1.1.2</version>
    </dependency>
    <!--mysql的驱动-->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>5.1.47</version>
    </dependency>
    <!--单元测试-->
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.11</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

## 2.3 新建Tomcat

* 见1.6

## 2.4 新建Facets

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210304111912895.png" alt="image-20210304111912895" style="zoom:80%;" />

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210304111945500.png" alt="image-20210304111945500" style="zoom:80%;" />

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210304112010382.png" alt="image-20210304112010382" style="zoom:80%;" />

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210304112521590.png" alt="image-20210304112521590" style="zoom:80%;" />

## 2.5 文件结构

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210304112838434.png" alt="image-20210304112838434" style="zoom:80%;" />

# 3. SMBMS实战

## 3.1 项目搭建准备工作

smbms：supermarket bills management system，超市订单管理系统

* 基本结构

<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210305155602667.png" alt="image-20210305155602667" style="zoom:80%;" />

* 数据库的架构

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210305155656974.png" alt="image-20210305155656974" style="zoom: 80%;" />

* 添加依赖

```xml

```


* 新建javaweb项目，包含以下几个package

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210305155803866.png" alt="image-20210305155803866" style="zoom:80%;" />

## 3.2 登录功能实现

### 3.2.1 POJO

* pojo中保存的是数据库中的字段（如id，name，在java中以private保存），还有setter/getter
* pojo的解释

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210305160223692.png" alt="image-20210305160223692" style="zoom:80%;" />

* pojo中保存了ORM：表-类映射，Object Relational Mapping

* 根据数据库的字段，新建pojo下的Java类

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210305160029813.png" alt="image-20210305160029813" style="zoom:80%;" />

### 3.2.2 数据库配置文件

* 在resources下新建db.properties

<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210305161455939.png" alt="image-20210305161455939" style="zoom:80%;" />

```properties
driver=com.mysql.jdbc.Driver
url=jdbc:mysql://localhost:3306?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8&useSSL=True"
username=root
password=123456
```

### 3.2.3 DAO

* DAO 层：数据访问层，与底层 MySQL、 Oracle、 Hbase、 OB 等进行数据交互（增删改查）。 

* 在dao下创建BaseDao
* 

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210305162727353.png" alt="image-20210305162727353" style="zoom:80%;" />

* 为了得到要登录的用户，创建一个<font color='red'>接口</font>：UserDao，
* 为了实现这个接口，创建UserDaoImpl类

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210305163540171.png" alt="image-20210305163540171" style="zoom:80%;" />

Dao均采用这类设计方法

```java
public interface UserDao {
    public User getLoginUser(Connection connection,String userCode) throws Exception;
}
```

```java
public class UserDaoImpl implements UserDao{
    @Override
    public User getLoginUser(Connection connection, String userCode) throws Exception {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        User user = null;
        if(null != connection){
            String sql = "select * from smbms_user where userCode=?";
            Object[] params = {userCode};
            rs = BaseDao.execute(connection, pstm, rs, sql, params);
            if(rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserCode(rs.getString("userCode"));
                user.setUserName(rs.getString("userName"));
                user.setUserPassword(rs.getString("userPassword"));
                user.setGender(rs.getInt("gender"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setUserRole(rs.getInt("userRole"));
                user.setCreatedBy(rs.getInt("createdBy"));
                user.setCreationDate(rs.getTimestamp("creationDate"));
                user.setModifyBy(rs.getInt("modifyBy"));
                user.setModifyDate(rs.getTimestamp("modifyDate"));
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return user;
    }
}
```

### 3.2.4 Service

* Service 层：相对具体的业务逻辑服务层。  调用多个Dao层。

* 与Dao层一样，创建UserService的接口，为了实现这个接口，创建UserServiceImpl类

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210305171542427.png" alt="image-20210305171542427" style="zoom:80%;" />

```java
public interface UserService {
    public User login(String userCode, String userPassword);
}
```

```java
public class UserServiceImpl implements UserService{
    private UserDao userDao;
    public UserServiceImpl(){
        userDao = new UserDaoImpl();
    }

    @Override
    public User login(String userCode, String password) {
        Connection connection = null;
        User user = null;
        try {
            connection = BaseDao.getConnection();
            user = userDao.getLoginUser(connection, userCode);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        //匹配密码
        if(user != null){
            if(user.getUserPassword().equals(password) == false)
                user = null;
        }
        return user;
    }

    // 测试方法
    @Test
    public void test() {
        UserServiceImpl userService = new UserServiceImpl();
        User admin = userService.login("admin", "123456");
        System.out.println(admin.getUserCode());
        System.out.println(admin.getUserPassword());
    }
}
```

### 3.2.5 Servlet

* Controller，控制层（请求处理层）

遇到错误：javax.servlet.ServletException: 实例化Servlet类[com.yifang.servlet.user.LoginServlet]异常

Maven->clean->再compile和package一下

## 3.3 登录功能优化



## 3.4 修改密码

<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210306101212096.png" alt="image-20210306101212096" style="zoom:80%;" />

1. 新建数据库，保存数据

2. UserDao接口

```java
public int updatePwd(Connection connection, int id, String password) throws Exception;
```

3. UserDaoImpl实体类

```java
@Override
public int updatePwd(Connection connection, int id, String password) throws Exception {
    int flag = 0;
    PreparedStatement pstm = null;
    if(connection != null){
        String sql = "update smbms_user set userPassword= ? where id = ?";
        Object[] params = {password, id};
        flag = BaseDao.execute(connection, pstm, sql, params);
        BaseDao.closeResource(null, pstm, null);
    }
    return flag;
}
```

4. UserService接口

```java
public boolean updatePwd(int id, String userPassword);
```

5. UserServiceImpl实体类

```java
@Override
public boolean updatePwd(int id, String userPassword) {
    Connection connection = null;
    boolean flag = false;
    try {
        connection = BaseDao.getConnection();
        if (userDao.updatePwd(connection, id, userPassword) > 0) {
            flag = true;
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        BaseDao.closeResource(connection, null, null);
    }
    return flag;
}
```

6. Servlet实体类

```java
public void updatePwd (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Object userSession = req.getSession().getAttribute(Constants.USER_SESSION);
    String newpassword = req.getParameter("newpassword");
    boolean flag = false;

    if (userSession != null && StringUtils.isNullOrEmpty(newpassword) != true) {
        UserService userService = new UserServiceImpl();
        flag = userService.updatePwd(((User) userSession).getId(), newpassword);
        if (flag) {
            req.setAttribute(Constants.SYS_MESSAGE, "修改密码成功,请退出并使用新密码重新登录！");
            req.getSession().removeAttribute(Constants.USER_SESSION);//session注销
        } else {
            req.setAttribute(Constants.SYS_MESSAGE, "修改密码失败！");
        }
    } else {
        req.setAttribute(Constants.SYS_MESSAGE, "修改密码失败！");
    }
    req.getRequestDispatcher("pwdmodify.jsp").forward(req, resp);
}
```

7. 注册web.xml

```xml
<!-- 更改密码 -->
<servlet>
    <servlet-name>UpdatePwdServlet</servlet-name>
    <servlet-class>com.yifang.servlet.user.UpdatePwdServlet</servlet-class>
</servlet>
<servlet-mapping>
    <servlet-name>UpdatePwdServlet</servlet-name>
    <url-pattern>/jsp/user.do</url-pattern>
</servlet-mapping>
```

8. JSP页面

## 3.5 验证旧密码 使用Ajax



## 3.6 用户管理

思路：

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210306152121587.png" alt="image-20210306152121587" style="zoom:80%;" />

1. 导入分页的工具类

   xxx.xxx.util/PageSupport.java

2. 用户列表页面导入

   web.jsp/userlist.jsp

### 3.6.1 获取用户数量

1. UserDao

```java
public int getUserCount(Connection connection, String userName, int userRole) throws Exception;
```

2. UserDaoImpl

```java
@Override
public int getUserCount(Connection connection, String userName, int userRole) throws Exception {
    PreparedStatement pstm = null;
    ResultSet rs = null;
    int count = 0;

    if(connection != null){
        StringBuffer sql = new StringBuffer();
        sql.append("select count(1) as count from smbms_user u,smbms_role r where u.userRole = r.id");
        List<Object> list = new ArrayList<Object>();
        if(!StringUtils.isNullOrEmpty(userName)){
            sql.append(" and u.userName like ?");
            list.add("%"+userName+"%");
        }
        if(userRole > 0){
            sql.append(" and u.userRole = ?");
            list.add(userRole);
        }
        Object[] params = list.toArray();
        System.out.println("sql ----> " + sql.toString());
        rs = BaseDao.execute(connection, pstm, rs, sql.toString(), params);
        if(rs.next()){
            count = rs.getInt("count");
        }
        BaseDao.closeResource(null, pstm, rs);
    }
    return count;
}
```

3. UserService

```java
public int getUserCount(String username, int userRole);
```

4. UserServiceImpl

```java
public int getUserCount(String username, int userRole) {
    Connection connection = null;
    int count = 0;

    try {
        connection = BaseDao.getConnection();
        count = userDao.getUserCount(connection, username, userRole);
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        BaseDao.closeResource(connection, null, null);
    }
    return count;
}
```

5. 注册web.xml

### 3.6.2 获取用户列表

1. UserDao

```java
public List<User> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize)throws Exception;
```

2. UserDaoImpl

```java
@Override
public List<User> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize) throws Exception {
    PreparedStatement pstm = null;
    ResultSet rs = null;
    List<User> userList = new ArrayList<User>();
    if(connection != null){
        StringBuffer sql = new StringBuffer();
        sql.append("select u.*,r.roleName as userRoleName from smbms_user u,smbms_role r where u.userRole = r.id");
        List<Object> list = new ArrayList<Object>();
        if(!StringUtils.isNullOrEmpty(userName)){
            sql.append(" and u.userName like ?");
            list.add("%"+userName+"%");
        }
        if(userRole > 0){
            sql.append(" and u.userRole = ?");
            list.add(userRole);
        }
        sql.append(" order by creationDate DESC limit ?,?");
        currentPageNo = (currentPageNo-1)*pageSize;
        list.add(currentPageNo);
        list.add(pageSize);

        Object[] params = list.toArray();
        System.out.println("sql ----> " + sql.toString());
        rs = BaseDao.execute(connection, pstm, rs, sql.toString(), params);
        while(rs.next()){
            User _user = new User();
            _user.setId(rs.getInt("id"));
            _user.setUserCode(rs.getString("userCode"));
            _user.setUserName(rs.getString("userName"));
            _user.setGender(rs.getInt("gender"));
            _user.setBirthday(rs.getDate("birthday"));
            _user.setPhone(rs.getString("phone"));
            _user.setUserRole(rs.getInt("userRole"));
            _user.setUserRoleName(rs.getString("userRoleName"));
            userList.add(_user);
        }
        BaseDao.closeResource(null, pstm, rs);
    }
    return userList;
}
```

3. UserService

```java
public List<User> getUserList(String queryUserName, int queryUserRole, int currentPageNo, int pageSize);
```

4. UserServiceImpl

```java
@Override
public List<User> getUserList(String queryUserName, int queryUserRole, int currentPageNo, int pageSize) {
    Connection connection = null;
    List<User> userList = null;

    try {
        connection = BaseDao.getConnection();
        userList = userDao.getUserList(connection, queryUserName,queryUserRole,currentPageNo,pageSize);
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }finally{
        BaseDao.closeResource(connection, null, null);
    }
    return userList;
}
```

5. 注册web.xml

### 3.6.3 获取用户权限



### 3.6.4 显示用户

![image-20210307113720947](https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210307113720947.png)



# 4. 文件上传与下载

后面再来补吧

# 5. 邮件发送

后面再来补吧