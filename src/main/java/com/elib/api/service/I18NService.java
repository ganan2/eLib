package com.elib.api.service;

import java.util.Locale;

public interface I18NService {
	public String getMessage(String messageId);
	public String getMessage(String messageId, Locale locale);
}
