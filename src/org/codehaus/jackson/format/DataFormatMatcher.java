package org.codehaus.jackson.format;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.io.IOContext;
import org.codehaus.jackson.io.MergedStream;

public class DataFormatMatcher {
   protected final InputStream _originalStream;
   protected final byte[] _bufferedData;
   protected final int _bufferedLength;
   protected final JsonFactory _match;
   protected final MatchStrength _matchStrength;

   protected DataFormatMatcher(InputStream in, byte[] buffered, int bufferedLength, JsonFactory match, MatchStrength strength) {
      this._originalStream = in;
      this._bufferedData = buffered;
      this._bufferedLength = bufferedLength;
      this._match = match;
      this._matchStrength = strength;
   }

   public boolean hasMatch() {
      return this._match != null;
   }

   public MatchStrength getMatchStrength() {
      return this._matchStrength == null ? MatchStrength.INCONCLUSIVE : this._matchStrength;
   }

   public JsonFactory getMatch() {
      return this._match;
   }

   public String getMatchedFormatName() {
      return this._match.getFormatName();
   }

   public JsonParser createParserWithMatch() throws IOException {
      if (this._match == null) {
         return null;
      } else {
         return this._originalStream == null ? this._match.createJsonParser(this._bufferedData, 0, this._bufferedLength) : this._match.createJsonParser(this.getDataStream());
      }
   }

   public InputStream getDataStream() {
      return (InputStream)(this._originalStream == null ? new ByteArrayInputStream(this._bufferedData, 0, this._bufferedLength) : new MergedStream((IOContext)null, this._originalStream, this._bufferedData, 0, this._bufferedLength));
   }
}
