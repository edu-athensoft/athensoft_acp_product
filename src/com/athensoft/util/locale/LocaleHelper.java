package com.athensoft.util.locale;

import java.util.Locale;

import org.junit.experimental.theories.Theories;
import org.springframework.context.i18n.LocaleContextHolder;

import com.athensoft.ecomm.item.entity.ItemProductStatus;

public class LocaleHelper{
	
	  public static String getLocaleStr() {
		  Locale locale = LocaleContextHolder.getLocale();  
		  String localeStr=(locale.getLanguage()+"_"+locale.getCountry());
		  localeStr =localToLangNo(localeStr);
		  return localeStr;
		  
	}
	  public static String localToLangNo(String localStr){
			switch(localStr){
			case "en_US": 
				localStr="1033";
				break;
			case "fr_CA": 
				localStr="3084";
				break;
			case "zh_CN": 
				localStr="2052";
				break;
			default: 
				break;
	  }
			  return localStr;
	  }
}
