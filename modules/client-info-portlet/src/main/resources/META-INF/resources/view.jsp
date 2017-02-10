<%@ include file="/init.jsp" %>

<%
    boolean noConfig = Validator.isNull(editPasswordURL);
%>

<c:choose>
    <c:when test="<%= noConfig %>">
        <p>
            <liferay-util:include page="/html/portal/portlet_not_setup.jsp" />
        </p>
    </c:when>

    <c:otherwise>
        <p>Client: José</p>
        <p>Conta: 87723-321</p>
        <p>
            <a href="<%= editPasswordURL %>">Editar senha de acesso</a>
        </p>
    </c:otherwise>
</c:choose>