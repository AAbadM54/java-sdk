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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The **options** object defines which items to crawl from the source system.
 */
public class SourceOptions extends GenericModel {

  private List<SourceOptionsFolder> folders;
  private List<SourceOptionsObject> objects;
  @SerializedName("site_collections")
  private List<SourceOptionsSiteColl> siteCollections;
  private List<SourceOptionsWebCrawl> urls;
  private List<SourceOptionsBuckets> buckets;
  @SerializedName("crawl_all_buckets")
  private Boolean crawlAllBuckets;

  /**
   * Gets the folders.
   *
   * Array of folders to crawl from the Box source. Only valid, and required, when the **type** field of the **source**
   * object is set to `box`.
   *
   * @return the folders
   */
  public List<SourceOptionsFolder> getFolders() {
    return folders;
  }

  /**
   * Gets the objects.
   *
   * Array of Salesforce document object types to crawl from the Salesforce source. Only valid, and required, when the
   * **type** field of the **source** object is set to `salesforce`.
   *
   * @return the objects
   */
  public List<SourceOptionsObject> getObjects() {
    return objects;
  }

  /**
   * Gets the siteCollections.
   *
   * Array of Microsoft SharePointoint Online site collections to crawl from the SharePoint source. Only valid and
   * required when the **type** field of the **source** object is set to `sharepoint`.
   *
   * @return the siteCollections
   */
  public List<SourceOptionsSiteColl> getSiteCollections() {
    return siteCollections;
  }

  /**
   * Gets the urls.
   *
   * Array of Web page URLs to begin crawling the web from. Only valid and required when the **type** field of the
   * **source** object is set to `web_crawl`.
   *
   * @return the urls
   */
  public List<SourceOptionsWebCrawl> getUrls() {
    return urls;
  }

  /**
   * Gets the buckets.
   *
   * Array of cloud object store buckets to begin crawling. Only valid and required when the **type** field of the
   * **source** object is set to `cloud_object_store`, and the **crawl_all_buckets** field is `false` or not specified.
   *
   * @return the buckets
   */
  public List<SourceOptionsBuckets> getBuckets() {
    return buckets;
  }

  /**
   * Gets the crawlAllBuckets.
   *
   * When `true`, all buckets in the specified cloud object store are crawled. If set to `true`, the **buckets** array
   * must not be specified.
   *
   * @return the crawlAllBuckets
   */
  public Boolean isCrawlAllBuckets() {
    return crawlAllBuckets;
  }

  /**
   * Sets the folders.
   *
   * @param folders the new folders
   */
  public void setFolders(final List<SourceOptionsFolder> folders) {
    this.folders = folders;
  }

  /**
   * Sets the objects.
   *
   * @param objects the new objects
   */
  public void setObjects(final List<SourceOptionsObject> objects) {
    this.objects = objects;
  }

  /**
   * Sets the siteCollections.
   *
   * @param siteCollections the new siteCollections
   */
  public void setSiteCollections(final List<SourceOptionsSiteColl> siteCollections) {
    this.siteCollections = siteCollections;
  }

  /**
   * Sets the urls.
   *
   * @param urls the new urls
   */
  public void setUrls(final List<SourceOptionsWebCrawl> urls) {
    this.urls = urls;
  }

  /**
   * Sets the buckets.
   *
   * @param buckets the new buckets
   */
  public void setBuckets(final List<SourceOptionsBuckets> buckets) {
    this.buckets = buckets;
  }

  /**
   * Sets the crawlAllBuckets.
   *
   * @param crawlAllBuckets the new crawlAllBuckets
   */
  public void setCrawlAllBuckets(final Boolean crawlAllBuckets) {
    this.crawlAllBuckets = crawlAllBuckets;
  }
}
