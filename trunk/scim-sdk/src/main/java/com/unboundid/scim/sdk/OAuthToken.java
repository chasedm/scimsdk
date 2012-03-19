/*
 * Copyright 2012 UnboundID Corp.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License (GPLv2 only)
 * or the terms of the GNU Lesser General Public License (LGPLv2.1 only)
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see <http://www.gnu.org/licenses>.
 */
package com.unboundid.scim.sdk;

/**
 * This class is a holder for OAuth token types.
 */
public class OAuthToken {
  /**
   * This enum defines the supported set of OAuth token types.
   */
  public enum Type {
    /**
     * OAuth 1.0 token type.
     */
    OAuth,
    /**
     * OAuth bearer token type.
     */
    Bearer
  }

  /**
   * The OAuth token type.
   */
  private volatile Type type;

  /**
   * The OAuth token value.
   */
  private volatile String tokenValue;

  /**
   * Constructs a fully initialized OAuthToken of the Bearer variety.
   * @param tokenValue The OAuth token value.
   */
  public OAuthToken(final String tokenValue) {
    this(Type.Bearer, tokenValue);
  }

  /**
   * Constructs a fully initialized OAuthToken.
   * @param type The token Type.
   * @param tokenValue The OAuth token value.
   */
  public OAuthToken(final Type type, final String tokenValue) {
    this.type=type;
    this.tokenValue=tokenValue;
  }

  /**
   * Returns the token type.
   * @return  Get the token type.
   */
  public Type getType() {
    return type;
  }

  /**
   * Returns the token value.
   * @return Get the token value.
   */
  public String getTokenValue() {
    return tokenValue;
  }

  /**
   * Returns a formatted representation of the token type and value for use as
   * an Authorization header value.
   * @return the token type and value in HTTP header value form.
   */
  public String getFormattedValue() {
    return getType().name() + " " + getTokenValue();
  }
}
