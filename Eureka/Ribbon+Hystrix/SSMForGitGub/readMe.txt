
1.Spring + Spring MVC + Mybatis + Maven 

2. mvc加载静态资源  

3. 多用注释少写xml

4.@Transactional 开启事务与mybatis的一级缓存

5. 开启二级缓存步骤... 
1.entity 完成序列化接口 
2.mybatis全局设置里开启二级缓存 
3.mapper文件里的方法加上useCache="true"


4. redis 做二级缓存。 
 4.1 自定义缓存类 完成Cache接口 
 4.2 自定义数据存入和取出 redis 的方式 本例中是序列化的方式
 4.3 
 	4.3.1 实体类完成serializable 接口，  
 	4.3.2 mybatis全局设置中开启二级缓存
 	 	<settings>
       		<setting name="cacheEnabled" value="true"/>
    	</settings>
 	4.3.3 mapper文件 <cache type="sch.hunnu.cache.mybatisRediCache"></cache> ，
 	4.3.4 方法里使用 useCache="true" .
