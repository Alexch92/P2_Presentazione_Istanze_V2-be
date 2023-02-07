package it.osapulie.infrastructure.security.impl;

import java.io.IOException;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.extensions.portlet.PortletProcessingInterceptor;

public class OSApuliePortletProcessingInterceptor extends PortletProcessingInterceptor {

	private static Logger log = LoggerFactory.getLogger(OSApuliePortletProcessingInterceptor.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.extensions.portlet.PortletProcessingInterceptor#
	 * onSuccessfulAuthentication(javax.portlet.PortletRequest, javax.portlet.PortletResponse,
	 * org.springframework.security.core.Authentication)
	 */
	@Override
	protected void onSuccessfulAuthentication(PortletRequest request, PortletResponse response, Authentication authResult) throws IOException {
		super.onSuccessfulAuthentication(request, response, authResult);

		log.info("onSuccessfulAuthentication :: entered");
	}
}
