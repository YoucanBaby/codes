[toc]

## 1. Java知识点

JDK: Java Development Kit

JRE: Java Runtime Environment

JVM: Java Virtual Machine

* 不用浮点数，用Bigdecimal比较更好
* 包(package)的本质就是文件夹，一般利用公司域名倒置作为包名

### 1.1 常量

* final int MAX_VALUE = 10;

### 1.2 命名规范

1. 见名知意，不要使用拼音命名
2. **变量，方法**：驼峰命名，首字母小写
3. **类**：驼峰命名，首字母大写
4. **常量**：大写 + 下划线

### 1.3 运算符

<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210202104852980.png" alt="image-20210202104852980" style="zoom:80%;" />

---
## 2. Java输入流

```java
Scanner scanner = new Scanner(System.in);
if (scanner.hasNext()) {
    String str = scanner.next();
    System.out.println("输出的内容" + str);
}
scanner.close();   // IO流如果不关闭的话，会一直占用资源
```

<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210131233315236.png" alt="image-20210131233315236" style="zoom:67%;" />

* scanner.hasNext()，识别空格，以空格作为分割

* scanner.hasNextLine()，识别回车，以回车作为分割

---

## 3. 增强for循环（for-each）

```java
int[] nums = {10, 20, 30, 40};
for (int x: nums) {
    System.out.print)(x);
}
```

---

* 原子性：一个方法（函数）只完成一个功能

---

## 4. 可变参数

* 传递的参数的长度未知

<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210201092540682.png" alt="image-20210201092540682"  />

<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210201092438301.png" alt="image-20210201092438301"  />![image-20210201092459289](../../AppData/Roaming/Typora/typora-user-images/image-20210201092459289.png)

![image-20210201092600262](../../AppData/Roaming/Typora/typora-user-images/image-20210201092600262.png)

---

## 5. 递归

* 阶乘

```java
public class test1 {

    public static void main(String[] args) {
        int n = 5;
        System.out.print(factorial(n));
    }

    private static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
```

![image-20210201093215338](../../AppData/Roaming/Typora/typora-user-images/image-20210201093215338.png)

1. 边界条件：n == 1
2. 前阶段
3. 返回：n * factorial(n)

---

## 6. Arrays

```java
import java.util.Arrays;
```

| 方法                         | 注释                     |
| ---------------------------- | ------------------------ |
| Arrays.asList(a);            | 转列表                   |
| Arrays.binarySearch(a, 100); | 二分查找                 |
| Arrays.equals(a, b);         | 两个数组是否相等         |
| Arrays.fill(a, 100);         | 数组a中每个值都赋值为100 |
| Arrays.sort(a);              | 排序                     |
| Arrays.toString(a);          | 转String                 |
|                              |                          |
|                              |                          |
|                              |                          |
|                              |                          |
|                              |                          |


---

## 7. 稀疏数组

![image-20210201100847419](../../AppData/Roaming/Typora/typora-user-images/image-20210201100847419.png)

* 稀疏数组的第一行存储原始数组的行、列、非0值的个数。

---

## 8. 面向对象编程

* OOP：Object Oriented Programming，面向对象编程

* OO：Object Oriented，面向对象

> 面向对象的本质就是：以类的方式组织代码，以对象的形式封装数据。

* 三大特性：<font color='red'>封装，继承，多态</font>
* 类，是抽象的，是一个模板。对象，是一个具体的实例。
* 先有类后有对象，类是对象的模板
* 类里面有**属性**和**方法**

---

### 8.1 对this的理解

* this是指Student类里的东西

<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210201105921135.png" alt="image-20210201105921135"  />

---

### 8.2 构造器Constructor

* 构造器是函数，函数名称与class的名称相同

```java
public class Student {

    String name;
    int age;
	
    public Student () {

    }
    
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

* 实例化，初始化

![image-20210201111359892](../../AppData/Roaming/Typora/typora-user-images/image-20210201111359892.png)

---

### 8.3 创建对象内存分析

<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210201112033837.png" alt="image-20210201112033837" style="zoom: 67%;" />

<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210201112057028.png" alt="image-20210201112057028" style="zoom: 80%;" />

---

### 8.4 封装

* 属性私有，get/set

---

### 8.5 继承

#### 8.5.1 extends

* Java中的继承关键字是"**extends**"，它是类和类之间的一种关系，**子类是父类的扩展**，子类 is a 父类

* **Java中只有单继承**，没有多继承，即一个儿子只能由一个爸爸，一个爸爸可以有多个儿子。但可以多接口。

* 除了继承之外，类和类之间的关系还有依赖、组合、聚合等

#### 8.5.2 super

* 关键字"**super**"调用父类的构造器，但是必须放在第一个
* "**super**"只能出现在子类的方法or构造方法中
* "**super.属性**"调用父类属性，"**super.方法**"调用父类方法

---

### 8.6 重写    @Override

需要有继承关系，子类重写父类的方法

1. 方法名必须相同
2. 参数列表必须相同
3. 修饰符：范围可以扩大但不能缩小，public > protected > default > private
4. 抛出的异常：范围可以被缩小，但是不能扩大

为什么需要重写：父类的功能，子类不一定需要，也不一定满足

---

### 8.7 多态

![image-20210201140832503](../../AppData/Roaming/Typora/typora-user-images/image-20210201140832503.png)

**多态的定义**：同一个方法可以根据发送对象的不同而采用多种不同的行为方式	

多态存在条件：

1. 有继承关系
2. 子类重写父类方法
3. 父类引用指向子类对象

多态是方法的多态，属性没有多态

父类和子类，有联系，但类型转换异常！ClassCastException!

---

### 8.8 Object类

* Object类是Java `java.lang`包下的核心类，**Object类是所有类的父类**，何一个类时候如果没有明确的继承一个父类的话，那么它就是Object的子类；

Object类的方法：

**1. clone()**

保护方法，实现对象的浅复制，只有实现了`Cloneable`接口才可以调用该方法，否则抛出CloneNotSupportedException异常。

**2. getClass()**

final方法，返回Class类型的对象，反射来获取对象。

**3. toString()**

该方法用得比较多，一般子类都有覆盖，来获取对象的信息。

**4. finalize()**

该方法用于释放资源。因为无法确定该方法什么时候被调用，很少使用。

**5. equals()**

比较对象的内容是否相等

**6. hashCode()**

该方法用于哈希查找，重写了equals方法一般都要重写hashCode方法。这个方法在一些具有哈希功能的Collection中用到。

**7. wait()**

wait方法就是使当前线程等待该对象的锁，当前线程必须是该对象的拥有者，也就是具有该对象的锁。wait()方法一直等待，直到获得锁或者被中断。wait(long timeout)设定一个超时间隔，如果在规定时间内没有获得锁就返回。

调用该方法后当前线程进入睡眠状态，直到以下事件发生。

1. 其他线程调用了该对象的notify方法。
2. 其他线程调用了该对象的notifyAll方法。
3. 其他线程调用了interrupt中断该线程。
4. 时间间隔到了。

此时该线程就可以被调度了，如果是被中断的话就抛出一个InterruptedException异常。

**8. notify()**

该方法唤醒在该对象上等待的某个线程。

**9. notifyAll()**

该方法唤醒在该对象上等待的所有线程。

---

### 8.9 instanceof和类型转换

```java
// 如果x是y的父类则返回true；反之，返回false
System.out.print(x instanceof y);
```

* 子类转父类，向上转型
* 父类转子类，向下转型，强制转换

---

### 8.10 static

<font color='red'> static方便在没有创建对象的情况下来进行调用（方法/变量） </font>

static可以修饰:

1. 方法
  
2. 成员变量（属性）
  
3. 代码块（不能出现在方法内部）

注:
1. 独立于类
2. 在类加载的时候执行，只执行一次
3. 修饰的方法只在调用时执行

---

### 8.11 抽象类 abstract

1. 不能new这个抽象类，只能靠子类去实现它
2. 抽象类中可以写普通的方法
3. 抽象方法必须在抽象类中

* 抽象类可以有构造方法、函数、静态方法

---

### 8.12 接口 interface

抽象类在IDEA中的小图标有两道竖杠

* 约束
* <font color='red'>implements</font>可以实现多个接口，实现了接口的类 的类必须要重写 (<font color='red'>@Override</font>) 接口中的方法
* 接口不能被实例化，接口中没有构造方法

---

### 8.13 内部类

* 一个类里面创建另外一个类

<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210201165510581.png" alt="image-20210201165510581" style="zoom: 67%;" />

![image-20210201165743396](../../AppData/Roaming/Typora/typora-user-images/image-20210201165743396.png)

* 一个java类中可以有多个class类，但只能有一个public class类

---

## 9. 异常 

### 9.1 Error 与 Exception

* 所有的错误 (<font color='red'>Error</font>) 和异常 (<font color='orange'>Exception</font>) 都在 <font color='cornflowerblue'>java.lang.Throwable </font>中

<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210201171806313.png" alt="image-20210201171806313" style="zoom: 80%;" />

![image-20210201172306807](../../AppData/Roaming/Typora/typora-user-images/image-20210201172306807.png)

<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210201172043965.png" alt="image-20210201172043965" style="zoom:80%;" />

---

### 9.2 抛出并捕获异常

```java
public static void main(String[] args) {

    int a = 1;
    int b = 0;

    try {   // try监控区域
        System.out.println(a / b);
    }catch (ArithmeticException e) {    // catch(想要捕获的异常类型) 捕获异常
        System.out.println("程序出现异常，变量0不能为0！");
    }finally {      // 处理善后工作, 最后一定会执行！
        System.out.println("fianlly");
    }
}
```

![image-20210201173717642](../../AppData/Roaming/Typora/typora-user-images/image-20210201173717642.png)

---

* 假设要捕获多个异常，要从小到大

```java
// 假设要捕获多个异常，要从小到大
public static void main(String[] args) {

    int a = 1;
    int b = 0;

    // 假设要捕获多个异常，要从小到大
    try {   // try监控区域
        System.out.println(a / b);
    }catch (Error e) {    // catch 捕获异常
        System.out.println("Error!");
    }catch (Exception e) {
        System.out.println("Exception");
    }catch (Throwable t) {
        System.out.println("Throwable");
    }finally {      // 处理善后工作
        System.out.println("fianlly");
    }
}
```

---

* 抛出异常

```java
public void test () throws ArithmeticException {	// 方法抛出异常
    if (true) {
        throw new ArithmeticException();	// 手动抛出异常
    }
}
```

## 10. 其他

一个class里只能有一个public class

