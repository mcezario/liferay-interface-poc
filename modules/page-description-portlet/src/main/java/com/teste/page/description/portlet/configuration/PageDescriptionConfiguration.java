package com.teste.page.description.portlet.configuration;

import com.teste.page.description.portlet.PageDescriptionPortlet;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id = PageDescriptionPortlet.PORTLET_CONFIG_ID)
public interface PageDescriptionConfiguration {

    @Meta.AD(required = false)
    public String title();
    
    @Meta.AD(required = false)
    public String description();

}
