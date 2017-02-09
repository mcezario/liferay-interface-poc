<nav class="navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse ${nav_css_class}" id="navigation" role="navigation">
	<h1 class="hide-accessible"><@liferay.language key="navigation" /></h1>
	
	<a class="${logo_css_class} navbar-brand"  href="${site_default_url}" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
		<img alt="${logo_description}" height="${site_logo_height}" src="${site_logo}" width="${site_logo_width}" />
	</a>
	
	<div class="collapse navbar-collapse" id="navbarsExampleDefault">
		<ul class="navbar-nav mr-auto" aria-label="<@liferay.language key="site-pages" />" role="menubar">
			<#list nav_items as nav_item>
				<#assign
					nav_item_attr_has_popup = ""
					nav_item_attr_selected = ""
					nav_item_css_class = ""
					nav_item_layout = nav_item.getLayout()
				/>
	
				<#if nav_item.isSelected()>
					<#assign
						nav_item_attr_has_popup = "aria-haspopup='true'"
						nav_item_attr_selected = "aria-selected='true'"
						nav_item_css_class = "selected"
					/>
				</#if>
	
				<li ${nav_item_attr_selected} class="nav-item ${nav_item_css_class}" id="layout_${nav_item.getLayoutId()}" role="presentation">
					<a class="nav-link" aria-labelledby="layout_${nav_item.getLayoutId()}" ${nav_item_attr_has_popup} href="${nav_item.getURL()}" ${nav_item.getTarget()} role="menuitem"><span><@liferay_theme["layout-icon"] layout=nav_item_layout /> ${nav_item.getName()}</span></a>
				</li>
			</#list>
			<#if !is_signed_in>
				<link class="nav-item"><a class="nav-link" data-redirect="${is_login_redirect_required?string}" href="${sign_in_url}" id="sign-in" rel="nofollow">${sign_in_text}</a></li>
			</#if>
			
		</ul>
	</div>
</nav>



