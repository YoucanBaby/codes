# 1. 使用注解开发

* MVC：
  * Model：dao，service，作用：取得表单数据，调用业务逻辑，转向指定的页面
  * View：jsp，作用：业务逻辑，保存数据的状态
  * Controller：servlet，作用：显示页面
* MVC主要作用是降低了视图与业务逻辑间的双向偶合。
* MVC不是一种设计模式，**MVC是一种架构模式**。当然不同的MVC存在差异  

## 1.1 @RequestMapping()

```java
@Controller
@RequestMapping("/example")
public class TestController {
    
    @RequestMapping(value="/test1")
    public String test() {
    	return "/test.jsp";
    }
}
```

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210315205058865.png" alt="image-20210315205058865" style="zoom:80%;" />

## 1.2 转发与重定向

```java
@Controller
public class ResultSpringMVC {
    @RequestMapping("/example/test1")
    public String test1() {
    	// 转发一
        return "/index.jsp";	
    }
    
    @RequestMapping("/example/test2")
    public String test2() {
        // 转发二
        return "forward:/index.jsp";
    } 
    
    @RequestMapping("/example/test3")
    public String test3() {
    	// 重定向
    	return "redirect:/index.jsp";
    }
}
```

## 1.3 传参数

* @RequestParam("参数")

```java
@RequestMapping("/example")
public String hello(@RequestParam("username") String name){
    System.out.println(name);
    return "/test.jsp";
}
```

提交数据: localhost:8080/example?name=yifang

## 1.4 @ResponseBody

不会走视图解析器，会直接返回一个字符串

## 1.5 @PathVariable()

@PathVariable("path")配合@RequestMapping()使用

```java
@RequestMapping(value="/{path}", method=RequestMethod.POST)
@ResponseBody
public void test(Model model, @PathVariable("path") String path) {
   // 一系列操作
}
```

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210318144453561.png" alt="image-20210318144453561" style="zoom:80%;" />

## 1.6 @RestController()

* @RestController() = @Controller() + @ResponseBody()

