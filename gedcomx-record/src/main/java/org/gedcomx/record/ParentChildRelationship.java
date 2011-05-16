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
package org.gedcomx.record;

import org.codehaus.enunciate.XmlQNameEnumUtil;
import org.codehaus.enunciate.qname.XmlQNameEnumRef;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.id.XmlTypeIdResolver;
import org.gedcomx.types.LineageType;
import org.gedcomx.types.RelationshipType;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.namespace.QName;

/**
 * A recorded relationship between a parent and a child.
 */
@XmlRootElement
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = "@type")
@JsonTypeIdResolver (XmlTypeIdResolver.class)
public class ParentChildRelationship extends Relationship {

  private QName lineageType;

  /**
   * The lineage type.
   *
   * @return The lineage type.
   */
  @XmlAttribute
  @XmlQNameEnumRef( LineageType.class )
  public QName getLineageType() {
    return lineageType;
  }

  /**
   * The lineage type.
   *
   * @param lineageType The lineage type.
   */
  public void setLineageType(QName lineageType) {
    this.lineageType = lineageType;
  }

  /**
   * The enum referencing the known lineage type, or {@link org.gedcomx.types.LineageType#other} if not known.
   *
   * @return The enum referencing the known lineage type, or {@link org.gedcomx.types.LineageType#other} if not known.
   */
  @XmlTransient
  public LineageType getKnownLineageType() {
    return XmlQNameEnumUtil.fromQName(getLineageType(), LineageType.class);
  }

  /**
   * Set the lineage type from an enumeration of known lineage types.
   *
   * @param knownLineageType The lineage type.
   */
  public void setKnownLineageType(LineageType knownLineageType) {
    this.lineageType = XmlQNameEnumUtil.toQName(knownLineageType);
  }

  /**
   * The parent persona in the relationship.
   *
   * @return The parent persona in the relationship.
   */
  @XmlAttribute
  @XmlIDREF
  public Persona getParent() {
    return getPersona1();
  }

  /**
   * The parent persona in the relationship.
   *
   * @param parent The parent persona in the relationship.
   */
  public void setParent(Persona parent) {
    setPersona1(parent);
  }

  /**
   * The child in the relationship.
   *
   * @return The child in the relationship.
   */
  @XmlAttribute
  @XmlIDREF
  public Persona getChild() {
    return getPersona2();
  }

  /**
   * The child in the relationship.
   *
   * @param child The child in the relationship.
   */
  public void setChild(Persona child) {
    setPersona2(child);
  }

  @XmlTransient
  @Override
  public RelationshipType getKnownRelationshipType() {
    return RelationshipType.parent_child;
  }
}
