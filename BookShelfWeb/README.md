1.jsp el display all books
  servlet context(head first servlet and jsp 1-4章)


2. Use DriverManager and BasicDataSource to connect to Database.
    JDBC DriverManager
    BasicDataSource  (DBCP):  1.JNDI   2 connection pool(DBCP dependency)

3. Put BasicDataSource to ServletContext in the Listener write by ourselves when we start the application
   And then got the connection in the java code.



1.Servlet处理表单（表单内容为BookShelf中的一个Book的信息），保存到MySQL数据库里面（使用javax.sql.Datasource）

2.用另一个Servlet从数据库中读取所有Book的信息，再通过JSP显示出来

3.将Datasource放在自己的容器里面，以此来模拟IoC容器。将该容器放在ServletContext或者Servlet中，两者的区别是什么？

4.只使用Spring的ClasspathXmlApplicationContext来存放该Datasource，然后将其放在ServletContext中让Servlet访问。

记得频繁提交哦。