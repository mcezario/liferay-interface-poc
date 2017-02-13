package com.teste.page.description.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.teste.page.description.portlet.configuration.PageDescriptionConfiguration;

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
    configurationPid = PageDescriptionPortlet.PORTLET_CONFIG_ID,
    immediate = true,
    property = {
        "com.liferay.portlet.display-category=category.sample",
        "com.liferay.portlet.instanceable=true",
        "javax.portlet.security-role-ref=power-user,user",
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.init-param.view-template=/view.jsp",
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.name=" + PageDescriptionPortlet.PORTLET_NAME,
        "javax.portlet.display-name=" + PageDescriptionPortlet.PORTLET_DISPLAY_NAME
    },
    service = Portlet.class
)
public class PageDescriptionPortlet extends MVCPortlet {
	
		public static final String PORTLET_NAME = "com_teste_page_description_portlet_PageDescription";
		public static final String PORTLET_DISPLAY_NAME = "Page Description";
		public static final String PORTLET_CONFIG_ID = "com.teste.page.description.portlet.configuration.PageDescriptionConfiguration";

		private volatile PageDescriptionConfiguration config;
        
        @Activate
        @Modified
        protected void activate(Map<Object, Object> properties) {
        	config = Configurable.createConfigurable(
                		PageDescriptionConfiguration.class, properties);
        }
        
        @Override
        public void doView(RenderRequest renderRequest,
                RenderResponse renderResponse) throws IOException, PortletException {

                renderRequest.setAttribute(
                		PageDescriptionConfiguration.class.getName(),
                		config);

                super.doView(renderRequest, renderResponse);
        }
        
}