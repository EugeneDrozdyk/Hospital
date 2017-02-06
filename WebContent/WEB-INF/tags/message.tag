<%@tag import="java.util.ResourceBundle"%>
<%@tag import="java.util.Locale"%>
<%@ tag language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<%@ attribute name="key" required="true" %>

<%
	Locale locale = request.getLocale();
	ResourceBundle bundle = ResourceBundle.getBundle("translation", locale);
	String value = bundle.getString(key);
%>

<%=value%>