/*
 * Copyright 2013 Vladimir Rudev
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ru.crazyproger.plugins.webtoper.component.dom.schema;

import com.intellij.util.xml.Attribute;
import com.intellij.util.xml.DomElement;
import com.intellij.util.xml.GenericAttributeValue;
import com.intellij.util.xml.GenericDomValue;
import com.intellij.util.xml.SubTag;
import ru.crazyproger.plugins.webtoper.component.dom.schema.pseudo.ClassAttributeContainer;
import ru.crazyproger.plugins.webtoper.component.dom.schema.pseudo.CustomChildrenContainer;
import ru.crazyproger.plugins.webtoper.component.dom.schema.pseudo.DomIconable;

public interface Precondition extends CustomChildrenContainer, ClassAttributeContainer, DomElement, DomIconable {
    @SubTag("role")
    String getRoles();

    @SubTag("argument")
    String getArguments(); // todo #WT-37

    @SubTag
    GenericDomValue<Boolean> isReversePrecondition(); // todo #WT-36

    @SubTag
    GenericDomValue<String> getComponent();

    @Attribute("onexecutiononly")
    GenericAttributeValue<Boolean> isOnExecutionOnly();
}
