/**
 * @author hyd 2012-11-29 下午3:32:58 
 * @version 1.0
 */
package f.rd.paths.web.security.extend.impl;

/**
 * 这个类是以前spring版本中的工具类，现在的spring security 3.1版本中不存在，由于项目需要且使用方便，故加入到项目当中。
 * <p>
 * 
 */
public interface UrlMatcher {
	
	Object compile(String paramString);

	boolean pathMatchesUrl(Object paramObject, String paramString);

	String getUniversalMatchPattern();

	boolean requiresLowerCaseUrl();

}
