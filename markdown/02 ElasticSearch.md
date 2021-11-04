[toc]

# 1. 背景

**[Lucene](https://zh.wikipedia.org/wiki/Lucene)** 是一套信息检索工具包（jar包），不包含搜索引擎系统。包含：索引结构，排序，搜索规则...

**[ElasticSearch](https://zh.wikipedia.org/wiki/Elasticsearch)** 基于 **Lucene库** 做了一些封装和增强，是一个**分布式全文搜索引擎**（全文搜索、结构化搜索、分析），可以通过简单的[RESTful API](https://zh.wikipedia.org/wiki/表现层状态转换)来隐藏Lucene的复杂性，从而让全局搜索变得更简单。

# 2.ElasticSearch安装

- JDK1.8，最低要求

[ElasticSearch下载](https://www.elastic.co/cn/downloads/elasticsearch)

[ElasticSearch Head 插件下载](https://github.com/mobz/elasticsearch-head)

[ElasticSearch IK分词器下载pei](https://github.com/medcl/elasticsearch-analysis-ik)

> bin 启动文件
>
> config 配置文件
>
> ​    log4j2.properties 日志配置文件
>
> ​    jvm.options     java 虚拟机相关配置
>
> ​    elasticsearch.yml     elasticsearch 的配置文件！默认9200端口 

- ES默认端口<font color='red'>9200</font>，API调用默认9300

[Logstash下载](https://www.elastic.co/cn/downloads/logstash)

* Logstash默认端口5044

[Kibana下载](https://www.elastic.co/cn/downloads/kibana)

* Kibana默认端口<font color='red'>5601</font>

head当作数据展示的工具，所有的查询都在Kibana里做

> ELK的关系

![image-20210202111407763](../../AppData/Roaming/Typora/typora-user-images/image-20210202111407763.png)

# 3. ES核心概念 

1. 索引
2. 类型（mapping）
3. 文档（documents）

| Relational DB    | ElasticSearch            |
| ---------------- | ------------------------ |
| 数据库(database) | 索引(indices)            |
| 表(tables)       | 类型(types)，8.0以后弃用 |
| 行(rows)         | 文档(documents)          |
| 字段(columns)    | fields                   |

* 物理设计：ES在后台把**每个索引划分成多个分片**，每个分片可以在集群中的不同服务器间迁移
* 逻辑设计：索引一篇文档时，通过顺序找到它：**索引** 👉 **类型** 👉 **文档ID**

<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210202140016187.png" alt="image-20210202140016187" style="zoom:80%;" />

4. 分片：倒排索引（inverted index）

* 常规索引是文档到关键词的映射：文档 ——> 关键词
* 倒排索引是关键词到文档的映射：关键词 ——> 文档

这样只要有关键词，立马就能找到她在那个文档里出现过，剩下的事就是把它揪出来了

# 4. ElasticSearch启动

|     应用      |                           打开方式                           |
| :-----------: | :----------------------------------------------------------: |
| ElasticSearch |                    打开elasticsearch.bat                     |
|   head插件    | 在E:/EssentialSoftware/Elasticsearch-Head下执行grunt server  |
|   Logstash    | 在E:/EssentialSoftware/Logstash-7.7.0/bin下执行logstash -f logstash.conf |
|    Kibana     |                        打开kibana.bat                        |

1. 开发工具使用Kibana，http://localhost:5601

<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210202112609086.png" alt="image-20210202112609086" style="zoom: 67%;" />

# 5. ik分词器

[ik分词器下载](https://github.com/medcl/elasticsearch-analysis-ik)

## 5.1 ik_max_word 和 ik_smart

- **ik_max_word**: 会将文本做**最细粒度的拆分**，比如会将“中华人民共和国国歌”拆分为“中华人民共和国,中华人民,中华,华人,人民共和国,人民,人,民,共和国,共和,和,国国,国歌”，会穷尽各种可能的组合，适合 Term Query；
<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210202144350789.png" alt="image-20210202144350789" style="zoom:80%;" />
- **ik_smart**: 会做**最粗粒度的拆分**，比如会将“中华人民共和国国歌”拆分为“中华人民共和国,国歌”，适合 Phrase Query。
<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210202144329833.png" alt="image-20210202144329833" style="zoom:80%;" />

## 5.2 查看ES下安装的插件

![image-20210202142345783](../../AppData/Roaming/Typora/typora-user-images/image-20210202142345783.png)

## 5.3 添加自己的字典

1. 在 E:\EssentialSoftware\Elasticsearch-7.7.0\plugins\ik\config 路径下新建**mydir.dic**
2. 在mydir.dic里写入自己的词语

![image-20210202151221057](../../AppData/Roaming/Typora/typora-user-images/image-20210202151221057.png)
3. 打开路径：E:\EssentialSoftware\Elasticsearch-7.7.0\plugins\ik\config\\**IKAnalyzer.cfg.xml** ，在指定位置写入**mydir.dic**

<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210202151446221.png" alt="image-20210202151446221" style="zoom:80%;" />

4. 重启ES

# 6. Rest风格

一种**软件架构风格**，不是硬性的标准。它主要用于客户端和服务器端交互类的软件。基于这个风格设计的软件可以更简洁，更有层次，更易于实现缓存等机制。

* <font color='red'>基本的Rest命令</font>：

|             method              |                       url                       |                   description                   |
| :-----------------------------: | :---------------------------------------------: | :---------------------------------------------: |
|  <font color='red'>PUT</font>   |     localhost:9200/索引名称/类型名称/文档id     | <font color='red'>创建文档</font>（指定文档id） |
|              POST               |        localhost:9200/索引名称/类型名称         |             创建文档（随机文档id）              |
|  <font color='red'>POST</font>  | localhost:9200/索引名称/类型名称/文档id/_update |        <font color='red'>修改文档</font>        |
| <font color='red'>DELETE</font> |     localhost:9200/索引名称/类型名称/文档id     |        <font color='red'>删除文档</font>        |
|  <font color='red'>GET</font>   |     localhost:9200/索引名称/类型名称/文档id     |        <font color='red'>查询文档</font>        |
|              POST               | localhost:9200/索引名称/类型名称/文档id/_search |              查询文档中的所有数据               |

## 6.1 关于文档的操作

### 6.1.1 创建一个文档 PUT

```
PUT /test1/type1/doc1 
{
  "name": "大海的对面都是敌人",
  "age": 3
}
```

<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210202154537832.png" alt="image-20210202154537832" style="zoom:80%;" />

![image-20210202154614962](../../AppData/Roaming/Typora/typora-user-images/image-20210202154614962.png) 

### 6.1.2 查询文档 GET

<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210202163252192.png" alt="image-20210202163252192" style="zoom:80%;" />

<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210202163303461.png" alt="image-20210202163303461" style="zoom:80%;" />

* 如果自己的文档字段没有指定，那么 ES 就会配置默认的字段类型

> 通过<font color='red'>GET _cat/命令</font>，可获得 ES 的很多信息

```java
GET _cat/health
GET _cat/indices
```

![image-20210202164011544](../../AppData/Roaming/Typora/typora-user-images/image-20210202164011544.png)

### 6.1.3 修改文档 POST

```
POST /test1/type1/doc1/_update
{
  "doc": {
    "name": "但是我也要去"
  }
}
```

![image-20210202164528951](../../AppData/Roaming/Typora/typora-user-images/image-20210202164528951.png)

![image-20210202164550104](../../AppData/Roaming/Typora/typora-user-images/image-20210202164550104.png)

### 6.1.4 查询文档

```
GET test1/type1/_search?q=name:一舫
```

![image-20210203101117432](../../AppData/Roaming/Typora/typora-user-images/image-20210203101117432.png) 

### 6.1.5 花式查询文档

#### 6.1.5.1 查询

* 查询文档中带“但是我”的字段

```
GET test1/type1/_search
{
  "query": {
    "match": {
      "name": "但是我"
    }
  }
}
```

![image-20210203101539629](../../AppData/Roaming/Typora/typora-user-images/image-20210203101539629.png)

#### 6.1.5.2 过滤字段

* 过滤掉"age"这个字段

```
GET test1/type1/_search
{
  "query": {
    "match": {
      "name": "舫"
    }
  }, 
  "_source": ["age"]
}
```

![image-20210203104014702](../../AppData/Roaming/Typora/typora-user-images/image-20210203104014702.png)

#### 6.1.5.3 排序字段

* 对"age"字段，用降序方式进行排序

```
GET test1/type1/_search
{
  "query": {
    "match": {
      "name": "舫"
    }
  }, 
  "sort": [
    {
      "age": {
        "order": "desc"
      }
    }
  ]
}
```

<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210203104616610.png" alt="image-20210203104616610" style="zoom:80%;" />

#### 6.1.5.4 分页查询

* "from"从第几个数据开始，"size"返回多少条数据（单页面的数据）

```
GET test1/type1/_search
{
  "query": {
    "match": {
      "name": "舫"
    }
  }, 
  "sort": [
    {
      "age": {
        "order": "desc"
      }
    }
  ],
  "from": 0,
  "size": 2
}
```

<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210203111514449.png" alt="image-20210203111514449" style="zoom:80%;" />

#### 6.1.5.5 布尔值查询

* must（相当于and）

```
GET test1/type1/_search
{
  "query": {
    "bool": {
      "must": [
        {
          "match": {
            "name": "舫"
          }
        },
        {
          "match": {
            "age": 23
          }
        }
      ]
    }
  }, 
  "sort": [
    {
      "age": {
        "order": "desc"
      }
    }
  ],
  "from": 0,
  "size": 2
}
```

<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210203112646841.png" alt="image-20210203112646841" style="zoom:67%;" />

* should（相当于or）

```
GET test1/type1/_search
{
  "query": {
    "bool": {
      "should": [
        {
          "match": {
            "name": "舫"
          }
        },
        {
          "match": {
            "age": 23
          }
        }
      ]
    }
  }, 
  "sort": [
    {
      "age": {
        "order": "desc"
      }
    }
  ],
  "from": 0,
  "size": 2
}
```

<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210203112958776.png" alt="image-20210203112958776" style="zoom:80%;" />

* must_not（相等于not）

```
GET test1/type1/_search
{
  "query": {
    "bool": {
      "must_not": [
        {
          "match": {
            "name": "舫"
          }
        }
      ]
    }
  }, 
  "sort": [
    {
      "age": {
        "order": "desc"
      }
    }
  ],
  "from": 0,
  "size": 2
}
```

<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210203113257998.png" alt="image-20210203113257998" style="zoom:80%;" />

#### 6.1.5.6 高级过滤字段

```
GET test1/type1/_search
{
  "query": {
    "bool": {
      "must_not": [
        {
          "match": {
            "name": "舫"
          }
        }
      ], 
      "filter": {
        "range": {
          "age": {
            "gte": 10,
            "lte": 30
          }
        }
      }
    }
  }
}
```

<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210203140950939.png" alt="image-20210203140950939" style="zoom:80%;" />

#### 6.1.5.7 短语查询

```
GET /test1/_search
{
  "query": {
    "match": {
      "hobby": "自由 跑步"
    }
  }
}
```

![image-20210203152129268](../../AppData/Roaming/Typora/typora-user-images/image-20210203152129268.png)

#### 6.1.5.8 精确查询



## 6.2 常见的数据类型

<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210202154811236.png" alt="image-20210202154811236" style="zoom:80%;" />

## 6.3 关于索引的操作

### 6.3.1 创建一个索引

```
PUT /test2
{
  "mappings": {
    "properties": {
      "name": {
        "type": "text"
      },
      "age": {
        "type": "long"
      },
      "birthday": {
        "type": "date"
      }
    }
  }
}
```

<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210202155244882.png" alt="image-20210202155244882" style="zoom:80%;" />

<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210202155409434.png" alt="image-20210202155409434" style="zoom:80%;" />



# 7. ES 在 Spring Boot 中创建索引与文档

## 7.1 官方文档

[ES官方文档](https://www.elastic.co/guide/en/elasticsearch/client/java-rest/7.7/java-rest-high-getting-started-initialization.html)

![image-20210207152034810](../../AppData/Roaming/Typora/typora-user-images/image-20210207152034810.png)

![image-20210207152952925](../../AppData/Roaming/Typora/typora-user-images/image-20210207152952925.png)

![image-20210207153425627](../../AppData/Roaming/Typora/typora-user-images/image-20210207153425627.png)

## 7.2 配置基本项目依赖

1. 新建项目，选择导入的依赖

![image-20210207154133243](../../AppData/Roaming/Typora/typora-user-images/image-20210207154133243.png)

2. 配置ES的依赖

```xml
<properties>
        <java.version>1.8</java.version>
        <!-- 这里SpringBoot默认配置的版本不匹配，我们需要自己配置版本！我这里使用7.7.0 -->
        <elasticsearch.version>7.7.0</elasticsearch.version>
</properties>
```

![image-20210207154507069](../../AppData/Roaming/Typora/typora-user-images/image-20210207154507069.png)

4. 我们编写一个配置类，提供这个bean来进行操作  

```java
package com.example.esdemo.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticSearchClientConfig {

    @Bean
    public RestHighLevelClient restHighLevelClient() {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, "http")));
        return client;
    }
}
```

## 7.3  常用方法

所需要的头文件和包

```java
package com.example.esdemo;

import com.alibaba.fastjson.JSON;
import com.example.esdemo.pojo.User;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class EsDemoApplicationTests {
    
    @Autowired
    @Qualifier("restHighLevelClient")
    RestHighLevelClient client;
}
```

### 7.3.1 创建索引

```java
@Test
void testGreateIndex() throws IOException {
    // 1、创建索引请求
    CreateIndexRequest request = new CreateIndexRequest("yifang_index");
    // 2、客户端执行请求 IndicesClient，请求后获得响应
    CreateIndexResponse createIndexResponse =
        client.indices().create(request, RequestOptions.DEFAULT);
    System.out.println(createIndexResponse);
}
```

### 7.3.2 获取索引

```java
@Test
void testExistIndex() throws IOException {
    GetIndexRequest request = new GetIndexRequest("yifang_index");
    boolean exists =
        client.indices().exists(request, RequestOptions.DEFAULT);
    System.out.println(exists);
}
```

### 7.3.3 删除索引

```java
@Test
void testDeleteIndex() throws IOException {
    DeleteIndexRequest request = new DeleteIndexRequest("yifang_index");
    AcknowledgedResponse delete =
        client.indices().delete(request, RequestOptions.DEFAULT);
    System.out.println(delete.isAcknowledged());
}
```

### 在POJO下创建User类

```java
package com.example.esdemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@Component
@NoArgsConstructor
public class User {
    private String name;
    private int age;
}
```

### 7.3.4 添加文档

```java
@Test
void testAddDocment() throws IOException {
    // 创建对象
    User user = new User("xuyifang", 22);
    // 创建请求
    IndexRequest request = new IndexRequest("yifang_index");

    // 规则
    request.id("1");
    request.timeout("1s");

    // 将我们的数据放入请求   json
    request.source(JSON.toJSONString(user), XContentType.JSON);

    // 客户端发送请求
    IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
    System.out.println(indexResponse.toString());
    System.out.println(indexResponse.status());
}
```

### 7.3.5 获取文档信息，判断文档是否存在

```java
@Test
void testIsExist() throws IOException {
    GetRequest getRequest = new GetRequest("yifang_index", "1");
    // 不获取返回的 _source 的上下文
    getRequest.fetchSourceContext(new FetchSourceContext(false));
    getRequest.storedFields("_none_");
    // 判断文档是否存在
    boolean exists = client.exists(getRequest, RequestOptions.DEFAULT);	
    System.out.println(exists);
}
```

### 7.3.6 更新文档信息

```java
@Test
void testUpdateDocment() throws IOException {
    UpdateRequest updateRequest = new UpdateRequest("yifang_index", "1");
    updateRequest.timeout("1s");

    User user = new User("xuyifang", 22);
    updateRequest.doc(JSON.toJSONString(user), XContentType.JSON);

    UpdateResponse updateResponse = client.update(updateRequest, RequestOptions.DEFAULT);
    System.out.println(updateResponse.status());
}
```

### 7.3.7 删除文档信息

```java
@Test
void testDeleteDocment() throws IOException {
    DeleteRequest deleteRequest = new DeleteRequest("yifang_index", "1");	// index, id
    deleteRequest.timeout("1s");

    DeleteResponse deleteResponse = client.delete(deleteRequest, RequestOptions.DEFAULT);
    System.out.println(deleteResponse.status());
}
```

### 7.3.8 批量插入文档信息

```java
@Test
void testBulkDocment() throws IOException {
    BulkRequest bulkRequest = new BulkRequest();
    bulkRequest.timeout("10s");

    ArrayList<User> userArrayList = new ArrayList<>();
    userArrayList.add(new User("Java 为什么搜不出来", 123));
    userArrayList.add(new User("Java 我真的搞不懂", 23));
    userArrayList.add(new User("Java 我真的搞不懂啊啊啊啊", 233));
    userArrayList.add(new User("Java 终于能搜出来了", 253));

   // 批处理请求，生成指定的id
    //        for (int i = 0; i < userArrayList.size(); i++) {
    //            bulkRequest.add(
    //                    new IndexRequest("yifang_index")
    //                    .id("" + (i+1))
    //                    .source(JSON.toJSONString(userArrayList.get(i)), XContentType.JSON)
    //            );
    //        }

    // 不指定id会生成随机的id
    for (int i = 0; i < userArrayList.size(); i++) {
        bulkRequest.add(
            new IndexRequest("yifang_index")
            .source(JSON.toJSONString(userArrayList.get(i)), XContentType.JSON)
        );
    }

    BulkResponse bulkResponse = client.bulk(bulkRequest, RequestOptions.DEFAULT);
    System.out.println(bulkResponse.hasFailures());     // 返回false，代表成功
}
```

### 7.3.9 查询文档

```java
@Test
void testSearchDocment() throws IOException {
    SearchRequest searchRequest = new SearchRequest("yifang_index");
    // 构建搜索条件
    SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
	
    // 精准匹配
    TermQueryBuilder queryBuilder = QueryBuilders.termQuery("name", "java");
    searchSourceBuilder.query(queryBuilder);
    searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
    // 多项精准匹配
    // TermsQueryBuilder termsQueryBuilder = QueryBuilders.termsQuery("name", "java", "ava");
    // 匹配所有
	// MatchAllQueryBuilder queryBuilder = QueryBuilders.matchAllQuery();
    // 匹配一部分
    // MatchQueryBuilder queryBuilder = QueryBuilders.matchQuery("name", "java");
    // 模糊匹配
    // FuzzyQueryBuilder queryBuilder = QueryBuilders.fuzzyQuery("name", "java");
    // 模糊匹配（不知有何区别）
    // WildcardQueryBuilder queryBuilder = QueryBuilders.wildcardQuery("name", "*av*");

    searchRequest.source(searchSourceBuilder);
    SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
    System.out.println(JSON.toJSONString(searchResponse.getHits()));
    System.out.println("=======================================================");

    for (SearchHit documentFields: searchResponse.getHits().getHits()){
        System.out.println(JSON.toJSONString(documentFields.getSourceAsMap()));
    }
}
```

# 8. 项目实战

## 8.1 初始化项目

1. 启动 ES 和 ES head 服务，见第4章
2. 使用springboot快速构建服务，比之前多个Thymeleaf

![image-20210207164503631](../../AppData/Roaming/Typora/typora-user-images/image-20210207164503631.png)

3. 修改依赖 `pom.xml`

```xml
<properties>
    <java.version>1.8</java.version>
    <!-- 修改elasticsearch的版本 -->
    <elasticsearch.version>7.7.0</elasticsearch.version>
</properties>

<dependencies>
    <!-- jSoup解析网页 -->
    <dependency>
        <groupId>org.jsoup</groupId>
        <artifactId>jsoup</artifactId>
        <version>1.10.2</version>
    </dependency>
	<!-- fastjson -->
    <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>fastjson</artifactId>
        <version>1.2.38</version>
    </dependency>
<dependencies>
```

4. 配置 `application.properties` 

```properties
server.port=9090
# 关闭 thymeleaf 的缓存
spring.thymeleaf.cache=false
```

5. 导入前端素材

```html
<html xmlns:th="http://www.thymeleaf.org">
```

6. 编写IndexController进行跳转测试  

```java
package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    // http://localhost:9090/ 与 http://localhost:9090/index 都能访问
    @GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }
}
```

## 8.2 Jsoup

1. 在 `pom.xml` 中导入 Jsoup依赖

```xml
<!-- jSoup解析网页 -->
<dependency>
    <groupId>org.jsoup</groupId>
    <artifactId>jsoup</artifactId>
    <version>1.10.2</version>
</dependency>
```

2. 编写一个工具类 `HtmlParseUtil.java` 

```java
package com.example.utils;

import com.example.pojo.Content;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

@Component
public class HtmlParseUtil {

    public ArrayList<Content> parseJD(String keywords) throws IOException {
        String key = URLEncoder.encode(keywords, "utf-8");
        String url = "https://search.jd.com/Search?keyword=" + key;

        Document document = Jsoup.parse(new URL(url), 30000);
        Element element = document.getElementById("J_goodsList");
        Elements elements = element.getElementsByTag("li");

        ArrayList<Content> goodsList = new ArrayList<>();

        for (Element el: elements) {
            String img = el.getElementsByTag("img").eq(0).attr("data-lazy-img");
            String price = el.getElementsByClass("p-price").eq(0).text();
            String title = el.getElementsByClass("p-name").eq(0).text();
            Content content = new Content();
            content.setImg(img);
            content.setPrice(price);
            content.setTitle(title);
            goodsList.add(content);
        }
        return goodsList;
    }
}
```

3. 封装一个实体类 `Content.java` 保存爬取下来的数据  

```java
package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Content {
    private String img;
    private String price;
    private String title;
    // 可以自己添加属性
}
```

## 8.3 业务编写

1. 导入 `ElasticsearchClientConfig.java` 配置类  

```java
package com.example.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticSearchClientConfig {

    @Bean
    public RestHighLevelClient restHighLevelClient() {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, "http")));
        return client;
    }
}
```

2. 编写业务 `ContentService.java`

```java
package com.example.service;

import com.alibaba.fastjson.JSON;
import com.example.pojo.Content;
import com.example.utils.HtmlParseUtil;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class ContentService {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    // 1、解析数据放入 es 索引中
    public Boolean parseContent(String keywords) throws IOException {
        List<Content> contents = new HtmlParseUtil().parseJD(keywords);
        // 把查询到的数据放入 es 中
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("2m");

        for (int i = 0; i < contents.size(); i++) {
            bulkRequest.add(
                    new IndexRequest("jd_goods")
                    .source(JSON.toJSONString(contents.get(i)), XContentType.JSON)
            );
        }

        BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        return !bulk.hasFailures();
    }

    // 2、获取这些数据实现搜索功能
    public List<Map<String, Object>> searchPage(String keyword, int pageNo, int pageSize) throws IOException {
        if (pageNo <= 1) {
            pageNo = 1;
        }

        // 条件搜索
        SearchRequest searchRequest = new SearchRequest("jd_goods");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        // 分页
        searchSourceBuilder.from(pageNo);
        searchSourceBuilder.size(pageSize);

        // 精准匹配
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("title", keyword);
        searchSourceBuilder.query(termQueryBuilder);
        searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

        // 执行搜索
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        // 解析结果
        ArrayList<Map<String, Object>> list = new ArrayList<>();
        for (SearchHit documentFields: searchResponse.getHits().getHits()) {
            list.add(documentFields.getSourceAsMap());
        }
        return list;
    }
}
```

3.  `Controller.java` 

```java
package com.example.controller;

import com.example.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class ContentController {

    @Autowired
    private ContentService contentService;
	
    // http://localhost:9090/parse/java
    @GetMapping("/parse/{keyword}")
    public boolean parse (@PathVariable("keyword") String keyword) throws IOException {
        return contentService.parseContent(keyword);
    }
	
    // http://localhost:9090/search/java/1/10
    @GetMapping("/search/{keyword}/{pageNo}/{pageSize}")
    public List<Map<String, Object>> search(@PathVariable("keyword") String keyword,
                                            @PathVariable("pageNo") int pageNo,
                                            @PathVariable("pageSize") int pageSize) throws IOException {

        return contentService.searchPage(keyword, pageNo, pageSize);
    }
}

```

## 8.4 前端逻辑

`index.html`

1. 导入vue和axios的依赖，这里导入后无法识别，重启IDEA就好了

```html
<script th:src="@{/js/axios.min.js}"></script>
<script th:src="@{/js/vue.min.js}"></script>
```

2. 初始化Vue对象，给外层div绑定app对象！  

```html
<script>

    new Vue({
        el:'#app',
        data:{
            keyword: '',    // 搜索的关键字
            results: []     // 搜索的结果
        }
    })
    
</script>
```

3. 绑定搜索框及相关事件

<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210208193048622.png" alt="image-20210208193048622" style="zoom:80%;" />

4. 编写方法，获取后端传递的数据  

```html
<script>

    new Vue({
        el:'#app',
        data:{
            keyword: '',    // 搜索的关键字
            results: []     // 搜索的结果
        },
        methods:{
            searchKey() {
                var keyword = this.keyword;
                console.log(keyword);
                // 对接后端的接口
                axios.get('search/' + keyword + "/1/50").then(response=>{
                    console.log(response);
                    this.results = response.data;       // 绑定数据！
                })
            }
        }
    })

</script>
```

5. 渲染解析回来的数据！  

<img src="../../AppData/Roaming/Typora/typora-user-images/image-20210208193901643.png" alt="image-20210208193901643" style="zoom:80%;" />

## 8.5 搜索高亮

1. 编写业务类，处理高亮字段   

`ContentService.java` 

```java
// 3、获取这些数据实现搜索高亮功能
public List<Map<String, Object>> searchHighlightPage(String keyword, int pageNo, int pageSize) throws IOException {
    if (pageNo <= 1) {
        pageNo = 1;
    }

    // 条件搜索
    SearchRequest searchRequest = new SearchRequest("jd_goods");
    SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

    // 分页
    searchSourceBuilder.from(pageNo);
    searchSourceBuilder.size(pageSize);

    // 精准匹配
    TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("title", keyword);
    searchSourceBuilder.query(termQueryBuilder);
    searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

    // 高亮
    HighlightBuilder highlightBuilder = new HighlightBuilder();
    highlightBuilder.field("title");
    highlightBuilder.requireFieldMatch(false);
    highlightBuilder.preTags("<span style='color:red'>");
    highlightBuilder.postTags("</span>");
    searchSourceBuilder.highlighter(highlightBuilder);

    // 执行搜索
    searchRequest.source(searchSourceBuilder);
    SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

    // 解析结果
    ArrayList<Map<String, Object>> list = new ArrayList<>();

    for (SearchHit hit: searchResponse.getHits().getHits()) {

        // 解析高亮的字段
        Map<String, HighlightField> highlightFields = hit.getHighlightFields();
        HighlightField title = highlightFields.get("title");
        Map<String, Object> sourceAsMap = hit.getSourceAsMap();     // 原来的结果

        // 将原来的字段替换成我们的高亮字段即可
        if (title != null) {
            Text[] fragments = title.fragments();
            String newTitle = "";
            for (Text text : fragments) {
                newTitle += text;
            }
            sourceAsMap.put("title", newTitle);     // 原来的字段替换成我们的高亮字段
        }
        list.add(sourceAsMap);
    }
    return list;
}
```

2. controller

 `ContentController.java` 

```java
@GetMapping("/search/{keyword}/{pageNo}/{pageSize}")
public List<Map<String, Object>> search(@PathVariable("keyword") String keyword,
                                        @PathVariable("pageNo") int pageNo,
                                        @PathVariable("pageSize") int pageSize) throws IOException {

    return contentService.searchHighlightPage(keyword, pageNo, pageSize);
}
```

3. vue解析html

`index.html`

```html
<!--标题-->
<p class="productTitle">
    <a v-html="result.title"></a>
</p>
```

4. 最终效果

![image-20210208205244090](../../AppData/Roaming/Typora/typora-user-images/image-20210208205244090.png)