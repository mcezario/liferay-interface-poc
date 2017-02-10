<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="com.teste.page.description.portlet.configuration.PageDescriptionConfiguration" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<%
PageDescriptionConfiguration configuration =
        (PageDescriptionConfiguration)
        renderRequest.getAttribute(PageDescriptionConfiguration.class.getName());

    String title = StringPool.BLANK;
    String description = StringPool.BLANK;

    if (Validator.isNotNull(configuration)) {
    	title = portletPreferences.getValue("title", configuration.title());
    	
    	description = portletPreferences.getValue("description", configuration.description());
    }
%>