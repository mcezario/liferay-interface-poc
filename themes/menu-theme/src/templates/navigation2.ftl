<div class="container">
	<div class="row">

		<div class="col-md-9">
			<nav class="${nav_css_class}" id="navigation" role="navigation" class="nav-main__child">
				<h1 class="hide-accessible"><@liferay.language key="navigation" /></h1>

				<ul aria-label="<@liferay.language key="site-pages" />" role="menubar">
					<#list nav_items as nav_item>
						<#assign
							nav_item_layout = nav_item.getLayout()
						/>

						<#if nav_item.hasChildren()>
							<#list nav_item.getChildren() as nav_child>
								<#if currentNavMainItem?contains(nav_item.getName())>
									<li aria-selected='true' class="selected" id="layout_${nav_item.getLayoutId()}" role="presentation">
										<ul class="child-menu" role="menu">
											<li aria-selected='true' class="selected" id="layout_${nav_child.getLayoutId()}" role="presentation">
												<a aria-labelledby="layout_${nav_child.getLayoutId()}" href="${nav_child.getURL()}" ${nav_child.getTarget()}
												role="menuitem">${nav_child.getName()}</a>
											</li>
										</ul>
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
