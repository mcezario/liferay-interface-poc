package com.liferay.docs.exampleconfig.action;

import com.liferay.docs.exampleconfig.configuration.ExampleConfiguration;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.Dictionary;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Reference;

@Component(
    configurationPid = "com.liferay.docs.exampleconfig.configuration.ExampleConfiguration",
    configurationPolicy = ConfigurationPolicy.OPTIONAL,
    immediate = true,
    property = {
        "javax.portlet.name=com_liferay_docs_exampleconfig_portlet_ExampleConfigPortlet"
    },
    service = ConfigurationAction.class
)
public class ExampleConfigurationAction extends DefaultConfigurationAction {

	@Override
	public String getJspPath(HttpServletRequest request) {
		return "/configuration.jsp";
	}

	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		String favoriteColor = ParamUtil.getString(actionRequest, "favoriteColor");
		setPreference(actionRequest, "favoriteColor", favoriteColor);

			Dictionary<String, Object> properties = new HashMapDictionary<>();
			
			ExampleConfiguration configurable = 
				ConfigurableUtil.createConfigurable(ExampleConfiguration.class, properties);
			
			configurable.favoriteColor();
			
		super.processAction(portletConfig, actionRequest, actionResponse);
	}

	@Override
	@Reference(target = "(osgi.web.symbolicname=client-info-portlet)", unbind = "-")
	public void setServletContext(ServletContext servletContext) {
		super.setServletContext(servletContext);
	}
}