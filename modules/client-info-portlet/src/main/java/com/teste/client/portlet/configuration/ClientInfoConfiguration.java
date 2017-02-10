package com.teste.client.portlet.configuration;

import com.teste.client.portlet.ClientInfoPortlet;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id = ClientInfoPortlet.PORTLET_CONFIG_ID)
public interface ClientInfoConfiguration {

    @Meta.AD(required = false)
    public String editPasswordURL();

}