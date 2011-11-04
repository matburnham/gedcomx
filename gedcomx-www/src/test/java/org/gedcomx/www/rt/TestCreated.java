package org.gedcomx.www.rt;

import com.sun.jersey.core.header.OutBoundHeaders;
import org.testng.annotations.Test;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertSame;
import static org.testng.AssertJUnit.fail;

/**
 * @author Ryan Heaton
 */
@Test
public class TestCreated {

  public void testCreated() throws Exception {
    final Object entity = new Object();
    final OutBoundHeaders map = new OutBoundHeaders();
    Created created = new Created(new Response() {
      @Override
      public Object getEntity() {
        return entity;
      }

      @Override
      public int getStatus() {
        return Status.CREATED.getStatusCode();
      }

      @Override
      public MultivaluedMap<String, Object> getMetadata() {
        return map;
      }
    });

    assertEquals(Response.Status.CREATED.getStatusCode(), created.getStatus());
    assertSame(entity, created.getEntity());
    assertSame(map, created.getMetadata());

    try {
      new Created(new Response() {
        @Override
        public Object getEntity() {
          return entity;
        }

        @Override
        public int getStatus() {
          return Status.OK.getStatusCode();
        }

        @Override
        public MultivaluedMap<String, Object> getMetadata() {
          return map;
        }
      });
      fail();
    }
    catch (IllegalArgumentException a) {
      //fall though...
    }
  }

}