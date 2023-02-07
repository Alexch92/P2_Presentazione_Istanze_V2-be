/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package it.sincon.sanita.services;

import com.liferay.portal.NoSuchModelException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Liferay
 */
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such CFG_CategorieAbilitate")
public class NoSuchCFG_CategorieAbilitateException extends NoSuchModelException {

	public NoSuchCFG_CategorieAbilitateException() {
		super();
	}

	public NoSuchCFG_CategorieAbilitateException(String msg) {
		super(msg);
	}

	public NoSuchCFG_CategorieAbilitateException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchCFG_CategorieAbilitateException(Throwable cause) {
		super(cause);
	}

}