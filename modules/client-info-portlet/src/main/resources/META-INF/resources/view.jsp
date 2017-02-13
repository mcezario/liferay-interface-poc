<%@ include file="/init.jsp" %>

<%
    boolean noConfig = Validator.isNull(editPasswordURL);
%>
<div class="client-info">
	<c:choose>
    <c:when test="<%= noConfig %>">
        <p>
            <liferay-util:include page="/html/portal/portlet_not_setup.jsp" />
        </p>
    </c:when>

    <c:otherwise>
        <p class="client-info__name">augusto p de assis</p>
        <p class="client-info__cpf">CPF: 272.345.765-87</p>
        <p class="client-info__birthdate">Data de nasc.: 18/05/77</p>
        <p class="client-info__edit-password-link">
            <a href="<%= editPasswordURL %>">Editar senha de acesso</a>
        </p>
    </c:otherwise>
</c:choose>
</div>