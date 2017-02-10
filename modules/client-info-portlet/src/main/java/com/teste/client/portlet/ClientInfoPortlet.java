package com.teste.client.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.teste.client.portlet.configuration.ClientInfoConfiguration;

import java.io.IOException;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import aQute.bnd.annotation.metatype.Configurable;

@Component(
    configurationPid =
    "com.liferay.docs.exampleconfig.configuration.ExampleConfiguration",
    immediate = true,
    property = {
        "com.liferay.portlet.display-category=category.sample",
        "com.liferay.portlet.instanceable=true",
        "javax.portlet.security-role-ref=power-user,user",
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.init-param.view-template=/view.jsp",
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.name=" + ClientInfoPortlet.PORTLET_NAME,
        "javax.portlet.display-name=" + ClientInfoPortlet.PORTLET_DISPLAY_NAME
    },
    service = Portlet.class
)
public class ClientInfoPortlet extends MVCPortlet {
	
		public static final String PORTLET_NAME = "com_teste_client_portlet_ClientInfo";
		public static final String PORTLET_DISPLAY_NAME = "Client Info";
		public static final String PORTLET_CONFIG_ID = "com.teste.client.portlet.configuration.ClientInfoConfiguration";

		private volatile ClientInfoConfiguration config;
        
        @Activate
        @Modified
        protected void activate(Map<Object, Object> properties) {
        	config = Configurable.createConfigurable(
                		ClientInfoConfiguration.class, properties);
        }
        
        @Override
        public void doView(RenderRequest renderRequest,
                RenderResponse renderResponse) throws IOException, PortletException {

                renderRequest.setAttribute(
                		ClientInfoConfiguration.class.getName(),
                		config);

                super.doView(renderRequest, renderResponse);
        }
        
}