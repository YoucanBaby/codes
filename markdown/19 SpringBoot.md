# 1. 注解开发
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
|                     @Mapper                      |                                                              |
|                      @Scope                      |                       作用域，一般不用                       |
|                     @Aspect                      |                             切面                             |
| <font color='red'>@RequestMapping("path")</font> |                        增，删，改，查                        |
|                  @GetMapping()                   |                              查                              |
|                  @PostMapping()                  |                          增，删，改                          |
|  <font color='red'>@RequestParam("参数")</font>  |                                                              |
|      <font color='red'>@ResponseBody</font>      |             返回String，而不是.html网页（视图）              |
|  <font color='red'>@PathVariable("xxx")</font>   |                                                              |
|                @RestController()                 |     @RestController() = @Controller() + @ResponseBody()      |
|                                                  |                                                              |

区别如下下：

 @GetMapping用于将HTTP get请求映射到特定处理程序的方法注解
具体来说，@GetMapping是一个组合注解，是@RequestMapping(method = RequestMethod.GET)的缩写。

@PostMapping用于将HTTP post请求映射到特定处理程序的方法注解
具体来说，@PostMapping是一个组合注解，是@RequestMapping(method = RequestMethod.POST)的缩写



# 2. thymeleaf

## 2.1 thymeleaf接管静态资源

* 所有页面的静态资源都需要使用thymeleaf，一般修改`href`和`img`

1. 导入thymeleaf模板

```html
<html lang="en" xmlns:th="http://www.thymeleaf.org">
```

2. `href`，随便举个例子，使用@{本地路径}

```html
<link th:href="@{/css/bootstrap.min.css}" rel="stylesheet">
```

3. `img`，随便举个例子，使用@{本地路径}

```html
<img class="mb-4" th:src="@{/img/bootstrap-solid.svg}" alt="" width="72" height="72">
```

## 2.2 thymeleaf语法

* Simple expressions:
  * 变量: <font color='red'>${...}</font>
  * Selection Variable Expressions: ***{...}**
  * Message Expressions: **#{...}**
  * Link URL Expressions: <font color='red'>@{...}</font>
  * Fragment Expressions: **~{...}**  

# 3. 搭建项目

* i18n = internationalization，国际化，实现中英页面切换