<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title} - ${company_name}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />

	<@liferay_util["include"] page=top_head_include />
</head>

<body class="${css_class}">

<@liferay_ui["quick-access"] contentId="#main-content" />

<@liferay_util["include"] page=body_top_include />

<@liferay.control_menu />

<#if has_navigation && is_setup_complete>
	<#include "${full_templates_path}/navigation.ftl" />
</#if>

<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron">
  <div class="container">
  	<#if has_navigation && is_setup_complete>
		<#include "${full_templates_path}/navigation2.ftl" />
	</#if>	
  </div>
</div>

<div class="container-fluid" id="wrapper">
	<section id="content">
		<h1 class="hide-accessible">${the_title}</h1>

		<nav id="breadcrumbs">
			<@liferay.breadcrumbs />
		</nav>

		<#if selectable>
			<@liferay_util["include"] page=content_include />
		<#else>
			${portletDisplay.recycle()}

			${portletDisplay.setTitle(the_title)}

			<@liferay_theme["wrap-portlet"] page="portlet.ftl">
				<@liferay_util["include"] page=content_include />
			</@>
		</#if>
	</section>

	<footer id="footer" role="contentinfo">
		<p class="powered-by">
			<@liferay.language key="powered-by" /> <a href="http://www.liferay.com" rel="external">Liferay</a>
		</p>
	</footer>
</div>

<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include />

<!-- inject:js -->
<!-- endinject -->




<#assign VOID = freeMarkerPortletPreferences.setValue("portletSetupPortletDecoratorId", "31915") />
<#assign theme_groupID = htmlUtil.escape(theme_display.getCompanyGroupId()?string) />
<#assign VOID = freeMarkerPortletPreferences.setValue("groupId", '${group_id}') />
<#assign VOID = freeMarkerPortletPreferences.setValue("articleId", "31915") />


<@liferay_portlet["runtime"]
instanceId="footerContent"
portletProviderAction=portletProviderAction.VIEW
portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet" />
${freeMarkerPortletPreferences.reset()}        

</body>

</html>