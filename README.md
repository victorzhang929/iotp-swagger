必备知识：RESTful架构

# RESTful

* 一个架构符合REST（Resources-Representation-State Transfer）原则，就称为RESTful架构。

## 什么是RESTful架构？

1. 每个URI代表一种资源；
2. 客户端和服务器之间，传递资源的某种表现层；
3. 客户端通过HTTP METHOD(GET、POST、PUT、DELETE)对服务器资源进行操作，实现表现层状态转换。

## RESTful架构设计误区

* 最常见设计错误是URI包含动词。因为“资源”表示一种实体，应该为名词，URI不应该有动词，动词应该放在HTTP协议中。
  * GET（SELECT）：从服务器中去除资源（一项或多项）；
  * POST（CREATE）：在服务器中新建一个资源；
  * PUT（UPDATE）：在服务器中更新资源（客户端提供改变后的完整资源）；
  * PATCH（UPDATE）：在服务器中更新资源（客户端提供改变的属性）。较少使用，一般使用PUT通用。
  * DELETE（DELETE）：从服务器中删除资源。
* 另一种设计误区是URI中加入版本号。不同的版本可以理解为同一种资源的不同表现形式，所以应该采用同一个URI。版本号可以在HTTP请求头信息的Accept字段中进行区分。注：github采用的就是将版本号放到URL中，方便直观，所以风格问题不必过于拘泥其教条，可根据团队成员素养定制风格。

## RESTful架构过滤信息

如果记录数量很多，服务器不可能将它们一次返回给用户，API需要提供参数过滤返回结果。下面是一些常见参数：

* ?limite=10 指定返回记录的数量
* ?offset=10 指定返回记录的开始位置
* ?page=2&per_page=100 指定第几页，以及每页的记录数
* ?sortby=name&order=asc 指定返回结果按照哪个属性排序，以及排序顺序
* ?user_type_id=1 指定筛选提交

## 服务器响应部分

* 返回信息中不要返回纯文本。API返回的数据格式不应该是纯文本而应该是JSON对象，因为这样才能返回标准的结构化数据，所以服务器回应的HTTP头的Content-Type属性设为application/json。客户端请求时，也要明确告诉服务器可以接受JSON格式，即请求HTTP头的ACCEPT属性也要设成application/json。
* 发生错误时，不要返回200状态码。错误的做法是即使发生错误也返回了200状态码，把错误信息放在数据体里面，这样的话，只有解析数据体以后才能得知操作失败。
