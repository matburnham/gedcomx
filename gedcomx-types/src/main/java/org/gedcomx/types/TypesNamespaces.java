/**
 * Copyright 2011 Intellectual Reserve, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gedcomx.types;

import org.gedcomx.rt.Namespace;
import org.gedcomx.rt.Namespaces;

import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Ryan Heaton
 */
@XmlTransient
@Namespaces ( {
  @Namespace (
    id = "gxt",
    uri = TypesNamespaces.GEDCOMX_TYPES_NAMESPACE,
    label = "Types Namespace",
    description = "The types namespace contains the definitions of the standard set of genealogical types.",
    version = "v1"
  )
} )
public class TypesNamespaces {

  private TypesNamespaces() {}

  public static final String GEDCOMX_TYPES_NAMESPACE = "http://gedcomx.org/types/";

}