package com.teste.page.description.portlet.configuration;

import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;
import com.teste.page.description.portlet.PageDescriptionPortlet;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;

import aQute.bnd.annotation.metatype.Configurable;

@Component(
    configurationPid = PageDescriptionPortlet.PORTLET_CONFIG_ID,
    configurationPolicy = ConfigurationPolicy.OPTIONAL,
    immediate = true,
    property = {"javax.portlet.name=" + PageDescriptionPortlet.PORTLET_NAME},
    service = ConfigurationAction.class
)
public class PageDescriptionConfigurationAction extends DefaultConfigurationAction {

	private volatile PageDescriptionConfiguration config;
    
    @Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
    	config = Configurable.createConfigurable(
            		PageDescriptionConfiguration.class, properties);
    }
    
    @Override
    public void processAction(
            PortletConfig portletConfig, ActionRequest actionRequest,
            ActionResponse actionResponse)
        throws Exception {

        setPreference(actionRequest, "title", ParamUtil.getString(actionRequest, "title"));
        setPreference(actionRequest, "description", ParamUtil.getString(actionRequest, "description"));

        super.processAction(portletConfig, actionRequest, actionResponse);
    }

    @Override
    public void include(
        PortletConfig portletConfig, HttpServletRequest httpServletRequest,
        HttpServletResponse httpServletResponse) throws Exception {

    	config = Configurable.createConfigurable(
                PageDescriptionConfiguration.class, new HashMap<>());
    	
        httpServletRequest.setAttribute(
        		PageDescriptionConfiguration.class.getName(),
            config);

        super.include(portletConfig, httpServletRequest, httpServletResponse);
    }

}