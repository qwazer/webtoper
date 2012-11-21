package ru.crazyproger.plugins.webtoper.nls.parser;

import com.intellij.lang.properties.parsing.PropertiesElementTypes;
import com.intellij.psi.stubs.IStubElementType;

/**
 * @author crazyproger
 */
public interface NlsElementTypes extends PropertiesElementTypes{
    IStubElementType INCLUDES_LIST = new NlsIncludesListStubElementType();

//    IStubElementType NLS_FILE = new  ;
}