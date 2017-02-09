<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>


<%@ page import="com.liferay.docs.exampleconfig.configuration.ExampleConfiguration" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>

<%@ include file="/init.jsp" %>

<%= welcomeTitle %>
<%
    ExampleConfiguration exampleConfiguration =
        (ExampleConfiguration)
        renderRequest.getAttribute(ExampleConfiguration.class.getName());

    String favoriteColor = StringPool.BLANK;

    if (Validator.isNotNull(exampleConfiguration)) {
        favoriteColor =
            portletPreferences.getValue(
                "favoriteColor", exampleConfiguration.favoriteColor());
    }
%>

<%
    boolean noConfig = Validator.isNull(favoriteColor);
%>

<c:choose>
    <c:when test="<%= noConfig %>">
        <p>
            Please select use the portlet configuration to select a favorite color.
        </p>
    </c:when>

    <c:otherwise>
        <p style="color: <%= favoriteColor %>">
            Favorite color: <%= favoriteColor %>!
        </p>
    </c:otherwise>
</c:choose>