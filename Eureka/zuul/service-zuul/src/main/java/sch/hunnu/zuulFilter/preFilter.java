package sch.hunnu.zuulFilter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;


@Component
public class preFilter extends ZuulFilter{
	
	private Logger log = LoggerFactory.getLogger(preFilter.class);
	
	/**
	 * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
	pre：路由之前
	routing：路由之时
	post： 路由之后
	error：发送错误调用
	 */
	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	/**
	 * run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
	 */
	@Override
	public Object run() throws ZuulException {
			System.out.println("开始过滤");
			RequestContext context = RequestContext.getCurrentContext();
			
			HttpServletRequest request = context.getRequest();
			
			HttpServletResponse response = context.getResponse();
		
			if(request.getParameter("names")==null){
				
				context.setSendZuulResponse(false);			//不继续执行zuul原先的服务
				context.setResponseStatusCode(401);				
				
				//response.getOutputStream().close();
				try {
					response.getWriter().write("Hello World!");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		 
			
			
					System.out.println("url = "+request.getRequestURL());
					log.info(" \n没有name参数！\n");
					return null;
				}
				
			log.info(" \n有name参数！\n");

			//System.out.println();
		return null;
	}

	/**
	 * shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
	 */
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	
	/**
	 * filterOrder：过滤的顺序
	 */
	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}


}
