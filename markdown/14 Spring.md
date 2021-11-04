# 1. Spring简介

* Spring是一个轻量级的**控制反转(IoC，Inversion of Control)**和**面向切面(AOP，Aspect-Oriented Programming)**的框架

* Spring 7大模块

![img](https://images2017.cnblogs.com/blog/1219227/201709/1219227-20170930225010356-45057485.gif)

* **控制反转 (IoC，Inversion of Control)**，是一种设计思想，**DI (Dependency Injection, 依赖注入)** 是实现IoC的一种方法，也有人认为DI只是IoC的另一种说法。没有IoC的程序中 , 我们使用面向对象编程 , 对象的创建与对象间的依赖关系完全硬编码在程序中，对象的创建由程序自己控制，控制反转后将对象的创建转移给第三方，个人认为所谓控制反转就是：获得依赖对象的方式反转了。  

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210313154057931.png" alt="image-20210313154057931" style="zoom:80%;" />

* **IoC是Spring框架的核心内容**，使用多种方式完美的实现了IoC，可以使用XML配置，也可以使用注解，新版本的Spring也可以零配置实现IoC

* Spring容器在初始化时先读取配置文件，根据配置文件或元数据创建与组织对象存入容器中，程序使用时再从Ioc容器中取出需要的对象。  

# 2. 使用.xml开发

## 2.1 Hello Spring

1. `pom.xml`

```xml
<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.3.4</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-jdbc</artifactId>
    <version>5.3.4</version>
</dependency>
```

2. 新建一个`pojo`

```java
public class Hello {
    private String hello;
    
    // get/set, toString
}
```

3. `beans.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">
	
    // id在context.getBean(id)中使用
    <bean id="Hello" class="com.yifang.pojo.Hello">
        <property name="hello" value="Spring"/>		// name对应pojo中的private String hello
    </bean>

</beans>
```

4. 测试

```java
public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Hello hello = (Hello) context.getBean("Hello");
        System.out.println(hello.toString());
    }
}
```

5. 一些思考

* Hello 对象是谁创建的 ? 【 hello 对象是由Spring创建的 】  

* Hello 对象的属性是怎么设置的 ? 【hello 对象的属性是由Spring容器设置的 】  

* 控制反转：
  * 控制 : 谁来控制对象的创建 , 传统应用程序的对象是由程序本身控制创建的 , 使用Spring后 , 对象是
    由Spring来创建的  
  * 反转 : 程序本身不创建对象 , 而变成被动的接收对象 .  

* 依赖注入 : 就是利用set方法来进行注入的.  

## 2.2 IOC创建对象

### 2.2.1 通过无参构造创建

1. `pom.xml`

```java
public class User {
    private String name;
    public User() {
    	System.out.println("user无参构造方法");
    }
    // setter/getter, toString
}
```

2. `beans.xml`

```java
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="http://www.springframework.org/schema/beans
            http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="user" class="com.yifang.pojo.User">
    	<property name="name" value="yifang"/>
    </bean>
</beans>
```


### 2.2.2 通过有参构造创建

1. `pom.xml`

```java
public class User {
    private String name;
    public User(String name) {
        this.name = name;
    	System.out.println("user有参构造方法");
    }
    // setter/getter, toString
}
```

2. `beans.xml`

```java
<!-- 根据参数名字设置 -->
<bean id="user" class="com.yifang.pojo.User">
	<!-- name指参数名 -->
    <constructor-arg name="name" value="yifang"/>
</bean>
```

* 结论：在配置文件加载的时候。其中管理的对象都已经初始化了！  

## 2.3 .xml的一些配置

### 2.3.1 别名

* alias 设置别名 , 为bean设置别名 , 可以设置多个别名  

```xml
<!--设置别名：在获取Bean的时候可以使用别名获取-->
<alias name="user" alias="userNewName"/>
```

### 2.3.2 Bean的配置

```java
<!--bean就是java对象,由Spring创建和管理-->
<!--
    id 是bean的标识符, 要唯一, 如果没有配置id, name就是默认标识符
    如果配置id, 又配置了name, 那么name是别名
    name可以设置多个别名,可以用逗号, 分号, 空格隔开
    如果不配置id和name,可以根据applicationContext.getBean(.class)获取对象;
    class是bean的全限定名=包名+类名
-->
<bean id="user" name="user user2 user3" class="com.yifang.pojo.User">
    <property name="name" value="Spring"/>
</bean>
```

### 2.3.3 import  

```xml
<import resource="{path}/beans.xml"/>
<import resource="beans.xml"/>
```

# 3. AOP

## 4.1 什么是AOP

* **AOP（Aspect Oriented Programming）**意为：**面向切面编程**，通过预编译方式和运行期动态代理实现程序功能的统一维护的一种技术。**AOP是OOP的延续**，是软件开发中的一个热点，也是Spring框架中的一个重要内容，是函数式编程的一种衍生范型。利用AOP可以对业务逻辑的各个部分进行隔离，从而**使得业务逻辑各部分之间的耦合度降低**，提高程序的可重用性，同时提高了开发的效率。  

## 4.2 Aop在Spring中的作用  

**提供声明式事务；允许用户自定义切面**  

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210314163354792.png" alt="image-20210314163354792" style="zoom:80%;" />

## 4.3 使用Spring实现AOP

1. `pom.xml`

```xml
<!-- https://mvnrepository.com/artifact/org.aspectj/aspectjweaver -->
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjweaver</artifactId>
    <version>1.9.6</version>
</dependency>
```

2. `applicationContext.xml`

```xml
<bean id="annotationPointcut" class="com.yifang.config.AnnotationPointcut"/>
<aop:aspectj-autoproxy/>
```

* \<aop:aspectj-autoproxy/>说明:

```xml
通过AOP命名空间的<aop:aspectj-autoproxy />声明自动为Spring容器中那些配置@aspectJ切面的bean创建代理，织入切面。当然，Spring 在内部依旧采用AnnotationAwareAspectJAutoProxyCreator进行自动代理的创建工作，但具体实现的细节已经被<aop:aspectj-autoproxy />隐藏起来了

<aop:aspectj-autoproxy />有一个proxy-target-class属性，默认为false，表示使用jdk动态代理织入增强，当配为<aop:aspectj-autoproxy poxy-target-class="true"/>时，表示使用CGLib动态代理技术织入增强。不过即使proxy-target-class设置为false，如果目标类没有声明接口，则Spring将自动使用CGLib动态代理。
```

3. `Test.java`

```java
package com.yifang.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AnnotationPointcut {
    
    @Before("execution(* com.yifang.service.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("---------方法执行前---------");
    } 
    
    @After("execution(* com.yifang.service.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("---------方法执行后---------");
    } 
    
    @Around("execution(* com.yifang.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("环绕前");
        System.out.println("签名:"+jp.getSignature());
        // 执行目标方法proceed
        Object proceed = jp.proceed();
        System.out.println("环绕后");
        System.out.println(proceed);
    }
}
```


# 4. 使用注解开发

1. `pom.xml`

```xml
<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.3.4</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-jdbc</artifactId>
    <version>5.3.4</version>
</dependency>
```

2. `applicationContext.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns:context="http://www.springframework.org/schema/context"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">
    
    <!--指定要扫描的包，这个包下的注解就会生效-->
    <context:component-scan base-package="com.yifang"/>
    <context:annotation-config/>
    
</beans>
```

3. 注解开发

|                       注解                       |                             说明                             |
| :----------------------------------------------: | :----------------------------------------------------------: |
|     <font color='red'>@Configuration</font>      | 该类等价 与XML中配置beans，相当于Ioc容器，它的某个方法头上如果注册了@Bean，就会作为这个Spring容器中的Bean，与xml中配置的bean意思一样。 |
|       <font color='red'>@Autowired</font>        | 通过类型自动装配，如果要允许null 值，可以设置它的required属性为false，如：@Autowired(required=false) |
| <font color='red'>@Qualifier(value="xxx")</font> |                配合@Autowired使用，装配上属性                |
|                    @Nullable                     |                      这个字段可以为null                      |
|                    @Resource                     |                    通过名字、类型自动装配                    |
|                  @Value("xxx")                   |                       给这个元素赋初值                       |
|       <font color='red'>@Component</font>        | @Component，@Controller，@Service，@Repository 四种注解的意思是一样的，如果不知道是Controller还是Service还是Repository，就用Component |
|       <font color='red'>@Controller</font>       |                     web层，表现层的注解                      |
|        <font color='red'>@Service</font>         |                   service层，业务层的注解                    |
|       <font color='red'>@Repository</font>       |                     dao层，持久层的注解                      |
|                      @Scope                      |                       作用域，一般不用                       |
|                     @Aspect                      |                             切面                             |
|                                                  |                                                              |
|                                                  |                                                              |

# 5. Spring + Mybatis

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

    <!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-webmvc</artifactId>
        <version>5.3.4</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-jdbc</artifactId>
        <version>5.3.4</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/org.aspectj/aspectjweaver -->
    <dependency>
        <groupId>org.aspectj</groupId>
        <artifactId>aspectjweaver</artifactId>
        <version>1.9.6</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring -->
    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis-spring</artifactId>
        <version>2.0.6</version>
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

* 事务的四个属性ACID

1. 原子性（atomicity）
   * 事务是原子性操作，由一系列动作组成，事务的原子性确保动作要么全部完成，要么完全不起
     作用  

2. 一致性（consistency）  
   * 一旦所有事务动作完成，事务就要被提交。数据和资源处于一种满足业务规则的一致性状态中  

3. 隔离性（isolation）
   * 可能多个事务会同时处理相同的数据，因此每个事务都应该与其他事务隔离开来，防止数据损
     坏  

4. 持久性（durability）  
   * 事务一旦完成，无论系统发生什么错误，结果都不会受到影响。通常情况下，事务的结果被写
     到持久化存储器中  