package ua.nure.drozdyk.hospital.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.drozdyk.hospital.constant.Attributes;
import ua.nure.drozdyk.hospital.model.Account;
import ua.nure.drozdyk.hospital.service.CommonService;
import ua.nure.drozdyk.hospital.service.impl.ServiceManager;

/**
 * Web filter that checks the needs for auto login.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
@WebFilter(filterName = "AutoLoginFilter")
public class AutoLoginFilter extends BaseFilter {

	private CommonService commonService;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		commonService = ServiceManager.getInstance(filterConfig.getServletContext()).getCommonService();
	}

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if (request.getSession().getAttribute(Attributes.CURRENT_ACCOUNT) == null) {
			if (request.getCookies() != null) {
				autoLogin(request);				
			}
		}
		chain.doFilter(request, response);
	}
	
	/**
	 * Sets in session current account.
	 * 
	 * @param request HTTP.
	 */
	private void autoLogin(HttpServletRequest request) {
		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().equals(Attributes.COOKIE_FOR_AUTO_LOGIN)) {
				String rememberToken = cookie.getValue();
				Account account = commonService.findAccount(rememberToken);
				if (account != null) {
					request.getSession().setAttribute(Attributes.CURRENT_ACCOUNT, account);
				}
			}
		}		
	}
}
