# StudyRecord

## 2020.4.15

学习HTML的常用标签

## 2020.4.16

学习CSS的属性和选择器

## 2020.4.17

1. 学习JavaScript的5大原始数据类型（number、string、boolean、null、undefined）和基本运算符

2. JavaScript的特殊语法

3. JavaScript流程控制（跟Java差不多，switch有点变化）、<script></script>标签内可以用跟<body></body>不一样的特殊的语法，body标签内使用HTML, 而script标签用JavaScript（类似Java）
## 2020.4.18

疑惑点：

​	var fun3=function() 、var fun3=new Function()  比  function fun3（） 要慢一步，同一种创建方式似乎不按代	码顺序进行，像是直接浏览全局，找到最后定义的那个。

​	var fun3=function() 、var fun3=new Function() 两者之间就是按照代码顺序。

​	总结：function fun3（）这种创建方式先于其他两种方式被找到，并且找到的是最后定义的那个。然后回到代	码开始的地方，按顺序来。

1.  学习JavaScript的对象：Function、Array、Date、Math、RegExp、Global
2. DOM简单学习
3. 事件简单学习

## 2020.4.19 (p61-p72)

1. BOM的三个主要对象：Window、Location、History，包括他们的方法、属性
2. Document、Element、Node对象
## 2020.4.20 (p73-p80)

1. 学习了HTML的DOM，InnerHTML、样式控制
2. 学习了常见事件，键盘、鼠标
3. 学习了3个案例（常见的表单校验）

## 2020.4.21 (p81-p99)

1. 了解BootStrap
2. 学习使用BootStrap下的CSS全局样式、JS插件、响应式布局
3. BootStrap菜鸟使用需要有3文件（js、css、font）以及一些必要的资源引入。
4. 入门xml，了解xml的组成：文档声明等
5. 了解xml的两种约束：dtd、schema，要求做到能简单地读懂约束文档。

## 2020.4.22 (p100-p107)

1. 学习了xml的解析器：Jsoup
2. 快速入门Jsoup
3. **学习Jsoup对象的使用：Document、Elements、Element**
4. **学习两种快速查询方法：selector选择器、XPath**

## 2020.4.23 (p108-p123)

1. 学习tomcat、Servlet
2. 学习tomcat服务器的相关配置，在IDEA上的配置
3. 了解tomcat的基本内容
4. 学习Servlet，快速入门，以及5个抽象方法
5. 了解IDEA与tomcat的相关配置关系。！！！

## 2020.4.26 (p124-141、p539-p541)

1. Servlet的继承关系，重点学习HTTPServlet ( 包含doGet、doPost )
2. 学习Servlet的注解 （@WebServlet 的路径定义，多层、后缀名）
3. 学习了HTTP的请求消息数据格式（🔺）：请求行、请求头、请求空行、请求体
4. 请求request的继承关系，获取请求消息的各种方法（🔺）、学习请求转发（🔺）、数据共享（🔺）、ServletContext（*）
5. JDBC快速入门
   url配置：jdbc:mysql:// ip: mysql端口号/ 数据库 ？serverTimezone=UTC&useSSL=true

## 2020.4.27 (p542-p568)

1. JDBC的快速入门：（1）驱动、（2）连接、（3)sql语句、（4）执行对象Statement & PreparedStatement 、（5）处理结果、（6)释放资源       共六步

2. 结果有两种：executeUpdate（增删改，返回影响行数）、executeQuery（查询，返回一个结果集，结果集的next()判断是否当前行有数据，getXxx( 参数 ) 方法按照数据库定义数据时的类型Xxx选择，参数是列名或者列数 ），两个方法需要传入 sql 语句。

3. 工具类 简化 代码操作

4. Statement 会出现 sql 注入问题，而 PreparedStatement 不会，以后都用 PreparedStatement 。用 PreparedStatement 特别要注意，需要先传入 sql 语句 ；where条件中的数值统一用 “ ？”代替，并且注意用 setXxx(问号序号，问号赋值内容)  ；处理结果 executeUpdate 、executeQuery就不需要传入 sql 。

5. 事务： （1）开启：setAutoCommit(false)； （2）提交： commit();  和  rollback()；

   - 都是用 Connection对象调用。

6. 三种连接池（DataSource）：

   - （**）C3P0（ComboPooledDataSource直接创对象，DataSource类型接收）

     - C3P0依赖：两个 jar 包   +  配置文件 **c3p0-config.xml**

   - （*）Druid（DruidDataSourceFactory 调用 createDataSource (Properties对象) ，DataSource类型接收）：

     - Druid依赖：一个 jar 包   +  配置文件  **jdbc.properties**
     - 需要加载配置文件：Properties对象. load ( Xxx .class .getClassLoader() .getResourceAsStream( **jdbc.properties** ) )

   - （🔺）Spring JDBC（JdbcTemplate 调用 DataSource对象，JdbcTemplate类型接收）

     - Spring JDBC依赖：五个 jar 包   +  C3P0 或 Druid 的 DataSource 对象
     - **总结就是，六个 jar 包  +  Druid需要的 jdbc.properties 配置文件, 创建一个 DataSource 给 Spring JDBC 用就行了 （Druid好用，而且需要的东西更少）**

     - 处理结果：
       1. update(sql，按顺序对sql中的问号赋值)：返回影响行数
       2. queryForMap(sql，按顺序对sql中的问号赋值)：放回符合 sql 的有且仅有的一个元组，为Map，输出：列名=值
       3. queryForList(sql，【按顺序对sql中的问号赋值】)：返回符合sql的所有元组，每个元组为Map，并用List一个个添加
       4. query(sql，new BeanPropertyRowMapper<范式>( .class文件) )：将数据库中的数据包装成类对象，返回 List 集合
       5. queryForObject(sql，Xxx.class)：Xxx似乎是影响返回值的，Long、Double、Interger 这些包装类，通常用于聚合函数

## 2020.4.28 (p709-p714)

1. 做了一个案例，主要分析一下设计逻辑🔺，以及一些编码规范，创建包之类的

2. BeanUtils工具类（apache）：populate(JavaBean , Map) 将Map里的键值对封装到JavaBean封装类中

## 2020.4.29  (p715-p725)

1. 学习Response的状态码
2. 是否路径需要加 虚拟目录 的问题
3. 重定向（🔺）与转发的区别：共3个
4. 字符流、字节流。

## 2020.4.30 (p726-p736)

1. 案例：验证码

2. ServletContext（与服务器通信）的三大功能：

   - 获取MIME：主要是为请求头里的 content-type 设置值

   - 域对象：占内存，实现了对整个web程序的资源共享

   - 获取文本服务区路径（🔺），也就是tomcat里的项目路径，out / artifacts 下。对应的关系如下：

     ​	**工作空间**					**tomcat项目空间**

     ​		web								war

      web / WEB-INF			war / WEB-INF

     ​		 src					war / WEB-INF / classes

3. 案例：文件下载

   - 请求头 content-disposition 设置为 attachment 就是 下载
   - 对文件名包含中文的解决：不同浏览器不同解决方法，关键是请求头 user-agent 的值，采用工具类实现

## 2020.5.1 (p737-p747)

1. Cookie 的快速入门
2. Cookie的原理，第一次请求 会拿到 服务器 的响应头 set-cookie。第二次请求会带着 请求头 cookie（对set-cookie做不知名的操作） 访问服务器
   - Cookie 同名，响应头set-cookie 有，但是 请求头 cookie 却被覆盖！！
3. Cookie 的细节：
   1. 一次发送多个Cookie，response.addCookie()
   2. Cookie的保存时间：setMaxAge(int seconds) ，默认负数
      - 正数：将Cookie数据写到硬盘的文件中持久化存储。Cookie存活时间，时间到后，Cookie文件自动失效
      - 负数：浏览器关闭，Cookie数据被销毁
      - 零：当前 删除Cookie信息
   3. Cookie 在 tomcat 8 后 能存储中文，但不能存储 特殊符号，如空格这些。。。若想存储 特殊符号，建议用URLURL编码存储（URLEncoder.encode() ），URL解码解析（URLDecoder.decode() ）
   4. Cookie 共享：
      - 默认情况下cookie不能共享
      - setPath(String path)：设置cookie的获取范围。默认情况下，设置当前的虚拟目录，将path设置为 " / "，则是整个tomcat范围
      - 不同tomcat：setDomain(String path):如果设置一级域名相同，那么多个服务器之间cookie可以共享。如setDomain(".baidu.com"),那么 tieba.baidu.com 和 news.baidu.com 中cookie可以共享

## 2020.5.2 (p748-p775)

1. JSP定义 Java 代码的三种方式： <% 代码 %>、<%!  代码 %>、<%=  代码 %>

2. JSP 本质 是一个 Servlet

3. 输出到页面：**response.getWrite() 最先执行，其他的（out、html标签）按 从上到下 的顺序**

4. session 快速入门

5. session 的获取（HttpSession）、设置、获取、删除 键值，session 依赖于 cookie

6. session 的 3大细节：

   1. 默认情况下，客户端关闭，两次获取的 session 不一样

      若想解决上述问题，因为依赖 cookie ，可以用 cookie 建一个 JSESSIONID，设置 cookie 的存活时间即可。

   2.  客户端不关闭，反而关闭服务器，是不可能获得一样的session，但是也没必要，只要数据不丢失。

      tomcat 本地服务器能做到session的 钝化、活化实现，在 IDEA 上不能实现。

   3. session 的销毁时机：

      1. 服务器关闭
      2. 自杀  invalidate()
      3. 修改配置文件 默认失效时间

7. session与Cookie的区别：

   - session存储数据在服务器端，Cookie在客户端

   - session没有数据大小限制，Cookie有

   - session数据安全，Cookie相对于不安全

8. 验证码案例

9. JSP三指令：

   - page：导包、配置JSP页面
   - include：导入资源文件，可以连接资源共同执行
   - taglib：导入外部资源（例如外部资源：拓展标签。。）

10. 九大内置对象：pageContext、request、session、ServletContext、response、out、page、exception、config

11. MVC开发模式：Model、View、Controller

12. EL表达式（JSP中）：${ 表达式 }

    - 在page指令中指定 isELIgnored = “true”，忽略当前页面内所有 EL；\ ${表达式}，忽略单个
    - 支持 算术运算、比较运算、逻辑运算、空运算（empty）
    - 获取值：${ 域名.键名 }
    - 域名：范围从小到大：pageScope、requestScope、sessionScope、applicationScope；$ { 键名 }省略域名则从小到达找是否有该键名
    - List：$ { 域名称.键名 [ 索引下标 ] }
    - Map：${域名称.键名.key名称}
    - **其实键名（key名），都可以理解为 属性。就是那个Getter and Setter 去掉set、get，首字母小写后留下的 属性。**

13. 隐式对象：EL有11个，了解 pageContext（嗯，跟JSP九大内置对象中那个一样），这个EL的 pageContext 可以过去其他八个内置对象

    例子：${ pageContext.request.contextPath }：动态获取虚拟目录

    解析：pageContext中有个 getRequest() , 而 request对象有个 getContextPath()，所以，这都是 "属性"

## 2020.5.3 (p776-p86)

1. 学习JSTL，导入标签库 <%@taglib prefix="c" uri=" http://java.sun.com/jsp/jstl/core " %>

2. 学习JSTL的三个常用标签：if、choose、forEach

   1. <c : if test="boolean表达式"> 操作 <c : if>

   2. <c :choose>
          <c :when test="boolean表达式">输出< /c : when>

      ​    ......

      ​	<c :otherwise>输出</c :otherwise>
      < /c : choose>

   3. <c:forEach begin="开始" end="结束" var="临时变量" step="步长" varStatus="s"> 操作 </c :forEach>

      <c:forEach items="引用容器对象" var="临时变量" varStatus="s"> 操作 </c :forEach>

3. 三层架构思想：

   1. 界面层(表示层)：用户看的得界面。用户可以通过界面上的组件和服务器进行交互
   2. 业务逻辑层：处理业务逻辑的。
   3. 数据访问层：操作数据存储文件。

4. 用户信息案例（🔺）
