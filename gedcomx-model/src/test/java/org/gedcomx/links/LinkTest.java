package org.gedcomx.links;

import org.gedcomx.common.URI;
import org.testng.annotations.Test;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;

/**
 * @author Ryan Heaton
 */
@Test
public class LinkTest {

  /**
   * tests link xml
   */
  public void testLinkXml() throws Exception {
    Link link = createLink();
    link = processThroughXml(link);
    assertLink(link);
    assertEquals("rel", link.getRel());
    assertEquals("rel", link.getJsonKey());
  }

  /**
   * tests link json
   */
  public void testLinkJson() throws Exception {
    Link link = createLink();
    link = processThroughJson(link);
    assertLink(link);
  }

  private void assertLink(Link link) {
    assertEquals(URI.create("urn:link"), link.getHref());
    assertEquals("template", link.getTemplate());
    assertEquals("text/plain", link.getAccept());
    assertEquals("GET", link.getAllow());
    assertEquals("en", link.getHreflang());
    assertEquals("title", link.getTitle());
    assertEquals("application/xml", link.getType());
  }

  private Link createLink() {
    Link link = new Link();
    link.setHref(URI.create("urn:link"));
    link.setRel("rel");
    link.setTemplate("template");
    link.setAccept("text/plain");
    link.setAllow("GET");
    link.setHreflang("en");
    link.setJsonKey("rel");
    link.setTitle("title");
    link.setType("application/xml");
    return link;
  }

}
