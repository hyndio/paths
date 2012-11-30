/**
 * @author hyd 2012-11-29 下午3:32:58 
 * @version 1.0
 */
package f.rd.paths.web.security.extend.impl;

/**
 * TODO
 * <p>
 * 
 */
public interface UrlMatcher {
	Object compile(String paramString);

	boolean pathMatchesUrl(Object paramObject, String paramString);

	String getUniversalMatchPattern();

	boolean requiresLowerCaseUrl();

}
