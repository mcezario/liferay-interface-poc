<%@ include file="/init.jsp" %>

<%
    boolean noConfig = Validator.isNull(title);
%>
<div class="page-description">
	<c:choose>
    <c:when test="<%= noConfig %>">
        <p>
            <liferay-util:include page="/html/portal/portlet_not_setup.jsp" />
        </p>
    </c:when>

    <c:otherwise>
        <h1 class="page-description__title"><%= title %></h1>
        <p class="page-description__description"><%= description %></p>
        <div class="page-description__line"></div>
    </c:otherwise>
</c:choose>
</div>