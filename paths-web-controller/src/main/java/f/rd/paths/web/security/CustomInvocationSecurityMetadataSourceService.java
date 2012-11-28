/*
 * @(#) MyInvocationSecurityMetadataSourceService.java  2011-3-23 下午02:58:29
 *
 * Copyright 2011 by Sparta 
 */

package f.rd.paths.web.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;

/**
 * 最核心的地方，就是提供某个资源对应的权限定义，即getAttributes方法返回的结果。
 * 此类在初始化时，应该取到所有资源及其对应角色的定义。
 * 
 */
@Service
public class CustomInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {

	private UrlMatcher urlMatcher = new AntUrlPathMatcher();

	// 应当是资源为key， 权限为value。 资源通常为url， 权限就是那些以ROLE_为前缀的角色。 一个资源可以由多个权限来访问。
	private static Map<String, Collection<ConfigAttribute>> resourceMap = new HashMap<String, Collection<ConfigAttribute>>();

	public CustomInvocationSecurityMetadataSourceService() {
		loadResourceDefine();
	}

	@SuppressWarnings({ "unchecked" })
	private void loadResourceDefine() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:root-context.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		// 在Web服务器启动时，提取系统中的所有权限。
		String sql = "select name_ from sec_authority";
		List<String> authorityNames = session.createSQLQuery(sql).list();
		// 循环查找权限对应对的资源
		for (String authority : authorityNames) {
			ConfigAttribute ca = new SecurityConfig(authority);
			/**
			 * select r.string_ from sec_auth_reso j
					left join sec_resource r on j.reso_ = r.id_
					left join sec_authority a on j.auth_=a.id_
					where a.name_='';
			 */
			List<String> resourceNames = session.createSQLQuery(
							"select r.string_ from sec_auth_reso j "
									+ "left join sec_resource r on j.reso_ = r.id_ "
									+ "left join sec_authority a on j.auth_=a.id_ "
									+ "where a.name_='"
									+ authority + "'").list();

			for (String resource : resourceNames) {
				/*
				 * 判断资源文件和权限的对应关系，如果已经存在相关的资源url，则要通过该url为key提取出权限集合，将权限增加到权限集合中。
				 * sparta
				 */
				if (resourceMap.containsKey(resource)) {
					Collection<ConfigAttribute> value = resourceMap.get(resource);
					value.add(ca);
					resourceMap.put(resource, value);
				} else {
					Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
					atts.add(ca);
					resourceMap.put(resource, atts);
				}
			}
		}
	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	// 根据URL，找到相关的权限配置。
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		// object 是一个URL，被用户请求的url。
		String url = ((FilterInvocation) object).getRequestUrl();
        int firstQuestionMarkIndex = url.indexOf("?");
        if (firstQuestionMarkIndex != -1) {
            url = url.substring(0, firstQuestionMarkIndex);
        }
		Iterator<String> ite = resourceMap.keySet().iterator();
		while (ite.hasNext()) {
			String resURL = ite.next();
			if (urlMatcher.pathMatchesUrl(url, resURL)) {
				return resourceMap.get(resURL);
			}
		}
		return null;
	}

	public boolean supports(Class<?> arg0) {
		return true;
	}

}
