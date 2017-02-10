<div class="container">
	<div class="row">

		<div class="submenu__container">
			<nav class="${nav_css_class}" id="navigation" role="navigation">
				<h1 class="hide-accessible"><@liferay.language key="navigation" /></h1>

				<ul aria-label="<@liferay.language key="site-pages" />" role="menubar" class="nav-main__child">
					<#list nav_items as nav_item>
						<#assign
							nav_item_layout = nav_item.getLayout()
						/>

						<#if nav_item.hasChildren()>
							<#list nav_item.getChildren() as nav_child>
								<#if currentNavMainItem?contains(nav_item.getName())>
									<li aria-selected='true' class="nav-main__child-item selected" id="layout_${nav_item.getLayoutId()}" role="presentation">
										<a class="nav-main__child-item-link" aria-labelledby="layout_${nav_child.getLayoutId()}" href="${nav_child.getURL()}" ${nav_child.getTarget()}
										role="menuitem">${nav_child.getName()}</a>
									</li>
								</#if>
							</#list>
						</#if>
					</#list>
				</ul>
			</nav>
		</div>

		<div class="col-md-3 visible-md visible-lg">
			<@liferay_portlet["runtime"]
			instanceId="bannerContextMenu"
			portletProviderAction=portletProviderAction.VIEW
			portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet" />
			${freeMarkerPortletPreferences.reset()}
		</div>
	</div>
</div>
