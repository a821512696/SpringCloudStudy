
1.Spring + Spring MVC + Mybatis + Maven 

2. mvc���ؾ�̬��Դ  

3. ����ע����дxml

4.@Transactional ����������mybatis��һ������

5. �����������沽��... 
1.entity ������л��ӿ� 
2.mybatisȫ�������￪���������� 
3.mapper�ļ���ķ�������useCache="true"


4. redis ���������档 
 4.1 �Զ��建���� ���Cache�ӿ� 
 4.2 �Զ������ݴ����ȡ�� redis �ķ�ʽ �����������л��ķ�ʽ
 4.3 
 	4.3.1 ʵ�������serializable �ӿڣ�  
 	4.3.2 mybatisȫ�������п�����������
 	 	<settings>
       		<setting name="cacheEnabled" value="true"/>
    	</settings>
 	4.3.3 mapper�ļ� <cache type="sch.hunnu.cache.mybatisRediCache"></cache> ��
 	4.3.4 ������ʹ�� useCache="true" .
