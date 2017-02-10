package com.teste.client.portlet.configuration;

import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;
import com.teste.client.portlet.ClientInfoPortlet;

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
    configurationPid = ClientInfoPortlet.PORTLET_CONFIG_ID,
    configurationPolicy = ConfigurationPolicy.OPTIONAL,
    immediate = true,
    property = {"javax.portlet.name=" + ClientInfoPortlet.PORTLET_NAME},
    service = ConfigurationAction.class
)
public class ClientInfoConfigurationAction extends DefaultConfigurationAction {

	private volatile ClientInfoConfiguration config;
    
    @Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
    	config = Configurable.createConfigurable(
            		ClientInfoConfiguration.class, properties);
    }
    
    @Override
    public void processAction(
            PortletConfig portletConfig, ActionRequest actionRequest,
            ActionResponse actionResponse)
        throws Exception {

        String favoriteColor = ParamUtil.getString(actionRequest, "editPasswordURL");
        setPreference(actionRequest, "editPasswordURL", favoriteColor);

        super.processAction(portletConfig, actionRequest, actionResponse);
    }

    @Override
    public void include(
        PortletConfig portletConfig, HttpServletRequest httpServletRequest,
        HttpServletResponse httpServletResponse) throws Exception {

    	config = Configurable.createConfigurable(
                ClientInfoConfiguration.class, new HashMap<>());
    	
        httpServletRequest.setAttribute(
        		ClientInfoConfiguration.class.getName(),
            config);

        super.include(portletConfig, httpServletRequest, httpServletResponse);
    }

}