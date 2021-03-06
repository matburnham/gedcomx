package org.gedcomx.conclusion;

import org.gedcomx.common.*;
import org.gedcomx.source.SourceReference;
import org.gedcomx.test.RecipeTest;
import org.gedcomx.test.Snippet;
import org.gedcomx.types.FactType;
import org.gedcomx.types.RelationshipType;
import org.testng.annotations.Test;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;


/**
 * @author Ryan Heaton
 */
@Test
public class RelationshipRecipesTest extends RecipeTest {

  public void testRelationship() throws Exception {
    createRecipe("Simple Relationship")
      .withDescription("Simple example for a relationship.")
      .applicableTo(Relationship.class);

    Relationship relationship = createTestRelationship();

    Snippet snippet = new Snippet();
    Relationship relationshipThruXml = processThroughXml(relationship, snippet);
    Relationship relationshipThruJson = processThroughJson(relationship, snippet);
    addSnippet(snippet);

    verifyRelationship(relationshipThruXml);
    verifyRelationship(relationshipThruJson);
  }

  private Relationship createTestRelationship() {
    Relationship relationship = new Relationship();
    relationship.setId("CCC-CCCC");
    relationship.setKnownType(RelationshipType.Couple);

    relationship.setAttribution(new Attribution());
    relationship.getAttribution().setChangeMessage("(justification here)");
    ResourceReference contributor = new ResourceReference();
    contributor.setResource(URI.create("https://familysearch.org/platform/contributors/BCD-FGHJ"));
    relationship.getAttribution().setContributor(contributor);
    Fact fact = new Fact();
    fact.setId("123");
    fact.setKnownType(FactType.Marriage);

    fact.setDate(new Date());
    fact.getDate().setOriginal("January 6, 1759");
    fact.getDate().setFormal("+1759-01-06");

    relationship.addFact(fact);
    relationship.setPerson1(new ResourceReference());
    relationship.getPerson1().setResource(URI.create("https://familysearch.org/platform/persons/DDD-DDDD"));
    relationship.setPerson2(new ResourceReference());
    relationship.getPerson2().setResource(URI.create("https://familysearch.org/platform/persons/FFF-FFFF"));
    SourceReference sourceReference = new SourceReference();
    sourceReference.setDescriptionRef(URI.create("urn:srcDescId"));
    relationship.addSource(sourceReference);
    return relationship;
  }

  private void verifyRelationship(Relationship relationship) {
    //todo
  }

}
