package org.codehaus.jackson.format;

public enum MatchStrength {
   NO_MATCH,
   INCONCLUSIVE,
   WEAK_MATCH,
   SOLID_MATCH,
   FULL_MATCH;

   private MatchStrength() {
   }
}