/**
 * @author hyd 2012-11-29 下午3:34:10 
 * @version 1.0
 */
package f.rd.paths.web.security.extend.impl;

import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

/**
 * 这个类是以前spring版本中的工具类，现在的spring security 3.1版本中不存在，由于项目需要且使用方便，故加入到项目当中。
 * <p>
 * 
 */
public class AntUrlPathMatcher implements UrlMatcher {

	private boolean requiresLowerCaseUrl;
	private PathMatcher pathMatcher;

	public AntUrlPathMatcher() {
		this(true);
	}

	public AntUrlPathMatcher(boolean requiresLowerCaseUrl) {
		this.requiresLowerCaseUrl = true;
		this.pathMatcher = new AntPathMatcher();

		this.requiresLowerCaseUrl = requiresLowerCaseUrl;
	}

	public Object compile(String path) {
		if (this.requiresLowerCaseUrl) {
			return path.toLowerCase();
		}

		return path;
	}

	public void setRequiresLowerCaseUrl(boolean requiresLowerCaseUrl) {
		this.requiresLowerCaseUrl = requiresLowerCaseUrl;
	}

	public boolean pathMatchesUrl(Object path, String url) {
		if (("/**".equals(path)) || ("**".equals(path))) {
			return true;
		}
		return this.pathMatcher.match((String) path, url);
	}

	public String getUniversalMatchPattern() {
		return "/**";
	}

	public boolean requiresLowerCaseUrl() {
		return this.requiresLowerCaseUrl;
	}

	public String toString() {
		return super.getClass().getName() + "[requiresLowerCase='"
				+ this.requiresLowerCaseUrl + "']";
	}

}
