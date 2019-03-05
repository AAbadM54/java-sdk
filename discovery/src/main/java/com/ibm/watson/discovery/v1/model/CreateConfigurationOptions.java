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
package com.ibm.watson.discovery.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.cloud.sdk.core.util.Validator;

/**
 * The createConfiguration options.
 */
public class CreateConfigurationOptions extends GenericModel {

  private String environmentId;
  private String name;
  private String description;
  private Conversions conversions;
  private List<Enrichment> enrichments;
  private List<NormalizationOperation> normalizations;
  private Source source;

  /**
   * Builder.
   */
  public static class Builder {
    private String environmentId;
    private String name;
    private String description;
    private Conversions conversions;
    private List<Enrichment> enrichments;
    private List<NormalizationOperation> normalizations;
    private Source source;

    private Builder(CreateConfigurationOptions createConfigurationOptions) {
      environmentId = createConfigurationOptions.environmentId;
      name = createConfigurationOptions.name;
      description = createConfigurationOptions.description;
      conversions = createConfigurationOptions.conversions;
      enrichments = createConfigurationOptions.enrichments;
      normalizations = createConfigurationOptions.normalizations;
      source = createConfigurationOptions.source;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param environmentId the environmentId
     */
    public Builder(String environmentId) {
      this.environmentId = environmentId;
    }

    /**
     * Builds a CreateConfigurationOptions.
     *
     * @return the createConfigurationOptions
     */
    public CreateConfigurationOptions build() {
      return new CreateConfigurationOptions(this);
    }

    /**
     * Adds an enrichments to enrichments.
     *
     * @param enrichments the new enrichments
     * @return the CreateConfigurationOptions builder
     */
    public Builder addEnrichments(Enrichment enrichments) {
      Validator.notNull(enrichments, "enrichments cannot be null");
      if (this.enrichments == null) {
        this.enrichments = new ArrayList<Enrichment>();
      }
      this.enrichments.add(enrichments);
      return this;
    }

    /**
     * Adds an normalizations to normalizations.
     *
     * @param normalizations the new normalizations
     * @return the CreateConfigurationOptions builder
     */
    public Builder addNormalizations(NormalizationOperation normalizations) {
      Validator.notNull(normalizations, "normalizations cannot be null");
      if (this.normalizations == null) {
        this.normalizations = new ArrayList<NormalizationOperation>();
      }
      this.normalizations.add(normalizations);
      return this;
    }

    /**
     * Set the environmentId.
     *
     * @param environmentId the environmentId
     * @return the CreateConfigurationOptions builder
     */
    public Builder environmentId(String environmentId) {
      this.environmentId = environmentId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateConfigurationOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CreateConfigurationOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the conversions.
     *
     * @param conversions the conversions
     * @return the CreateConfigurationOptions builder
     */
    public Builder conversions(Conversions conversions) {
      this.conversions = conversions;
      return this;
    }

    /**
     * Set the enrichments.
     * Existing enrichments will be replaced.
     *
     * @param enrichments the enrichments
     * @return the CreateConfigurationOptions builder
     */
    public Builder enrichments(List<Enrichment> enrichments) {
      this.enrichments = enrichments;
      return this;
    }

    /**
     * Set the normalizations.
     * Existing normalizations will be replaced.
     *
     * @param normalizations the normalizations
     * @return the CreateConfigurationOptions builder
     */
    public Builder normalizations(List<NormalizationOperation> normalizations) {
      this.normalizations = normalizations;
      return this;
    }

    /**
     * Set the source.
     *
     * @param source the source
     * @return the CreateConfigurationOptions builder
     */
    public Builder source(Source source) {
      this.source = source;
      return this;
    }

    /**
     * Set the configuration.
     *
     * @param configuration the configuration
     * @return the CreateConfigurationOptions builder
     */
    public Builder configuration(Configuration configuration) {
      this.name = configuration.getName();
      this.description = configuration.getDescription();
      this.conversions = configuration.getConversions();
      this.enrichments = configuration.getEnrichments();
      this.normalizations = configuration.getNormalizations();
      this.source = configuration.getSource();
      return this;
    }
  }

  private CreateConfigurationOptions(Builder builder) {
    Validator.notEmpty(builder.environmentId, "environmentId cannot be empty");
    environmentId = builder.environmentId;
    name = builder.name;
    description = builder.description;
    conversions = builder.conversions;
    enrichments = builder.enrichments;
    normalizations = builder.normalizations;
    source = builder.source;
  }

  /**
   * New builder.
   *
   * @return a CreateConfigurationOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the environmentId.
   *
   * The ID of the environment.
   *
   * @return the environmentId
   */
  public String environmentId() {
    return environmentId;
  }

  /**
   * Gets the name.
   *
   * The name of the configuration.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * The description of the configuration, if available.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the conversions.
   *
   * Document conversion settings.
   *
   * @return the conversions
   */
  public Conversions conversions() {
    return conversions;
  }

  /**
   * Gets the enrichments.
   *
   * An array of document enrichment settings for the configuration.
   *
   * @return the enrichments
   */
  public List<Enrichment> enrichments() {
    return enrichments;
  }

  /**
   * Gets the normalizations.
   *
   * Defines operations that can be used to transform the final output JSON into a normalized form. Operations are
   * executed in the order that they appear in the array.
   *
   * @return the normalizations
   */
  public List<NormalizationOperation> normalizations() {
    return normalizations;
  }

  /**
   * Gets the source.
   *
   * Object containing source parameters for the configuration.
   *
   * @return the source
   */
  public Source source() {
    return source;
  }
}
