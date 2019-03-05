/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.watson.developer_cloud.compare_comply.v1.model;

import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A party and its corresponding role, including address and contact information if identified.
 */
public class Parties extends GenericModel {

  /**
   * A string that identifies the importance of the party.
   */
  public interface Importance {
    /** Primary. */
    String PRIMARY = "Primary";
    /** Unknown. */
    String UNKNOWN = "Unknown";
  }

  private String party;
  private String importance;
  private String role;
  private List<Address> addresses;
  private List<Contact> contacts;

  /**
   * Gets the party.
   *
   * A string identifying the party.
   *
   * @return the party
   */
  public String getParty() {
    return party;
  }

  /**
   * Gets the importance.
   *
   * A string that identifies the importance of the party.
   *
   * @return the importance
   */
  public String getImportance() {
    return importance;
  }

  /**
   * Gets the role.
   *
   * A string identifying the party's role.
   *
   * @return the role
   */
  public String getRole() {
    return role;
  }

  /**
   * Gets the addresses.
   *
   * List of the party's address or addresses.
   *
   * @return the addresses
   */
  public List<Address> getAddresses() {
    return addresses;
  }

  /**
   * Gets the contacts.
   *
   * List of the names and roles of contacts identified in the input document.
   *
   * @return the contacts
   */
  public List<Contact> getContacts() {
    return contacts;
  }
}
