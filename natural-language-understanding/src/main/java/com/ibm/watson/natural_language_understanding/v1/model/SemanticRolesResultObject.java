/*
 * (C) Copyright IBM Corp. 2019.
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
package com.ibm.watson.natural_language_understanding.v1.model;

import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The extracted object from the sentence.
 */
public class SemanticRolesResultObject extends GenericModel {

  private String text;
  private List<SemanticRolesKeyword> keywords;

  /**
   * Gets the text.
   *
   * Object text.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Gets the keywords.
   *
   * An array of extracted keywords.
   *
   * @return the keywords
   */
  public List<SemanticRolesKeyword> getKeywords() {
    return keywords;
  }
}
