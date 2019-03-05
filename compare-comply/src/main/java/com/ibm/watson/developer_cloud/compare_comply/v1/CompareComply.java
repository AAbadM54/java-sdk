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
package com.ibm.watson.developer_cloud.compare_comply.v1;

import com.google.gson.JsonObject;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.service.WatsonService;
import com.ibm.cloud.sdk.core.service.security.IamOptions;
import com.ibm.cloud.sdk.core.util.GsonSingleton;
import com.ibm.cloud.sdk.core.util.RequestUtils;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import com.ibm.cloud.sdk.core.util.Validator;
import com.ibm.watson.developer_cloud.compare_comply.v1.model.AddFeedbackOptions;
import com.ibm.watson.developer_cloud.compare_comply.v1.model.BatchStatus;
import com.ibm.watson.developer_cloud.compare_comply.v1.model.Batches;
import com.ibm.watson.developer_cloud.compare_comply.v1.model.ClassifyElementsOptions;
import com.ibm.watson.developer_cloud.compare_comply.v1.model.ClassifyReturn;
import com.ibm.watson.developer_cloud.compare_comply.v1.model.CompareDocumentsOptions;
import com.ibm.watson.developer_cloud.compare_comply.v1.model.CompareReturn;
import com.ibm.watson.developer_cloud.compare_comply.v1.model.ConvertToHtmlOptions;
import com.ibm.watson.developer_cloud.compare_comply.v1.model.CreateBatchOptions;
import com.ibm.watson.developer_cloud.compare_comply.v1.model.DeleteFeedbackOptions;
import com.ibm.watson.developer_cloud.compare_comply.v1.model.ExtractTablesOptions;
import com.ibm.watson.developer_cloud.compare_comply.v1.model.FeedbackList;
import com.ibm.watson.developer_cloud.compare_comply.v1.model.FeedbackReturn;
import com.ibm.watson.developer_cloud.compare_comply.v1.model.GetBatchOptions;
import com.ibm.watson.developer_cloud.compare_comply.v1.model.GetFeedback;
import com.ibm.watson.developer_cloud.compare_comply.v1.model.GetFeedbackOptions;
import com.ibm.watson.developer_cloud.compare_comply.v1.model.HTMLReturn;
import com.ibm.watson.developer_cloud.compare_comply.v1.model.ListBatchesOptions;
import com.ibm.watson.developer_cloud.compare_comply.v1.model.ListFeedbackOptions;
import com.ibm.watson.developer_cloud.compare_comply.v1.model.TableReturn;
import com.ibm.watson.developer_cloud.compare_comply.v1.model.UpdateBatchOptions;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * IBM Watson&trade; Compare and Comply analyzes governing documents to provide details about critical aspects of the
 * documents.
 *
 * @version v1
 * @see <a href="http://www.ibm.com/watson/developercloud/compare-comply.html">Compare Comply</a>
 */
public class CompareComply extends WatsonService {

  private static final String SERVICE_NAME = "compare_comply";
  private static final String URL = "https://gateway.watsonplatform.net/compare-comply/api";

  private String versionDate;

  /**
   * Instantiates a new `CompareComply`.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value will keep your API
   *          calls from failing when the service introduces breaking changes.
   */
  public CompareComply(String versionDate) {
    super(SERVICE_NAME);
    if ((getEndPoint() == null) || getEndPoint().isEmpty()) {
      setEndPoint(URL);
    }

    Validator.isTrue((versionDate != null) && !versionDate.isEmpty(), "version cannot be null.");

    this.versionDate = versionDate;
  }

  /**
   * Instantiates a new `CompareComply` with IAM. Note that if the access token is specified in the
   * iamOptions, you accept responsibility for managing the access token yourself. You must set a new access token
   * before this
   * one expires or after receiving a 401 error from the service. Failing to do so will result in authentication errors
   * after this token expires.
   *
   * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value will keep your API
   *          calls from failing when the service introduces breaking changes.
   * @param iamOptions the options for authenticating through IAM
   */
  public CompareComply(String versionDate, IamOptions iamOptions) {
    this(versionDate);
    setIamCredentials(iamOptions);
  }

  /**
   * Convert file to HTML.
   *
   * Convert an uploaded file to HTML.
   *
   * @param convertToHtmlOptions the {@link ConvertToHtmlOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link HTMLReturn}
   */
  public ServiceCall<HTMLReturn> convertToHtml(ConvertToHtmlOptions convertToHtmlOptions) {
    Validator.notNull(convertToHtmlOptions, "convertToHtmlOptions cannot be null");
    String[] pathSegments = { "v1/html_conversion" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    builder.query(VERSION, versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=compare-comply;service_version=v1;operation_id=convertToHtml");
    if (convertToHtmlOptions.modelId() != null) {
      builder.query("model_id", convertToHtmlOptions.modelId());
    }
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    RequestBody fileBody = RequestUtils.inputStreamBody(convertToHtmlOptions.file(), convertToHtmlOptions
        .fileContentType());
    multipartBuilder.addFormDataPart("file", convertToHtmlOptions.filename(), fileBody);
    builder.body(multipartBuilder.build());
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(HTMLReturn.class));
  }

  /**
   * Classify the elements of a document.
   *
   * Analyze an uploaded file's structural and semantic elements.
   *
   * @param classifyElementsOptions the {@link ClassifyElementsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link ClassifyReturn}
   */
  public ServiceCall<ClassifyReturn> classifyElements(ClassifyElementsOptions classifyElementsOptions) {
    Validator.notNull(classifyElementsOptions, "classifyElementsOptions cannot be null");
    String[] pathSegments = { "v1/element_classification" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    builder.query(VERSION, versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=compare-comply;service_version=v1;operation_id=classifyElements");
    if (classifyElementsOptions.modelId() != null) {
      builder.query("model_id", classifyElementsOptions.modelId());
    }
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    RequestBody fileBody = RequestUtils.inputStreamBody(classifyElementsOptions.file(), classifyElementsOptions
        .fileContentType());
    multipartBuilder.addFormDataPart("file", classifyElementsOptions.filename(), fileBody);
    builder.body(multipartBuilder.build());
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(ClassifyReturn.class));
  }

  /**
   * Extract a document's tables.
   *
   * Extract and analyze an uploaded file's tables.
   *
   * @param extractTablesOptions the {@link ExtractTablesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link TableReturn}
   */
  public ServiceCall<TableReturn> extractTables(ExtractTablesOptions extractTablesOptions) {
    Validator.notNull(extractTablesOptions, "extractTablesOptions cannot be null");
    String[] pathSegments = { "v1/tables" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    builder.query(VERSION, versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=compare-comply;service_version=v1;operation_id=extractTables");
    if (extractTablesOptions.modelId() != null) {
      builder.query("model_id", extractTablesOptions.modelId());
    }
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    RequestBody fileBody = RequestUtils.inputStreamBody(extractTablesOptions.file(), extractTablesOptions
        .fileContentType());
    multipartBuilder.addFormDataPart("file", extractTablesOptions.filename(), fileBody);
    builder.body(multipartBuilder.build());
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(TableReturn.class));
  }

  /**
   * Compare two documents.
   *
   * Compare two uploaded input files. Uploaded files must be in the same file format.
   *
   * @param compareDocumentsOptions the {@link CompareDocumentsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link CompareReturn}
   */
  public ServiceCall<CompareReturn> compareDocuments(CompareDocumentsOptions compareDocumentsOptions) {
    Validator.notNull(compareDocumentsOptions, "compareDocumentsOptions cannot be null");
    String[] pathSegments = { "v1/comparison" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    builder.query(VERSION, versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=compare-comply;service_version=v1;operation_id=compareDocuments");
    if (compareDocumentsOptions.file1Label() != null) {
      builder.query("file_1_label", compareDocumentsOptions.file1Label());
    }
    if (compareDocumentsOptions.file2Label() != null) {
      builder.query("file_2_label", compareDocumentsOptions.file2Label());
    }
    if (compareDocumentsOptions.modelId() != null) {
      builder.query("model_id", compareDocumentsOptions.modelId());
    }
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    RequestBody file1Body = RequestUtils.inputStreamBody(compareDocumentsOptions.file1(), compareDocumentsOptions
        .file1ContentType());
    multipartBuilder.addFormDataPart("file_1", compareDocumentsOptions.file1Filename(), file1Body);
    RequestBody file2Body = RequestUtils.inputStreamBody(compareDocumentsOptions.file2(), compareDocumentsOptions
        .file2ContentType());
    multipartBuilder.addFormDataPart("file_2", compareDocumentsOptions.file2Filename(), file2Body);
    builder.body(multipartBuilder.build());
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(CompareReturn.class));
  }

  /**
   * Add feedback.
   *
   * Adds feedback in the form of _labels_ from a subject-matter expert (SME) to a governing document.
   * **Important:** Feedback is not immediately incorporated into the training model, nor is it guaranteed to be
   * incorporated at a later date. Instead, submitted feedback is used to suggest future updates to the training model.
   *
   * @param addFeedbackOptions the {@link AddFeedbackOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link FeedbackReturn}
   */
  public ServiceCall<FeedbackReturn> addFeedback(AddFeedbackOptions addFeedbackOptions) {
    Validator.notNull(addFeedbackOptions, "addFeedbackOptions cannot be null");
    String[] pathSegments = { "v1/feedback" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    builder.query(VERSION, versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=compare-comply;service_version=v1;operation_id=addFeedback");
    final JsonObject contentJson = new JsonObject();
    if (addFeedbackOptions.userId() != null) {
      contentJson.addProperty("user_id", addFeedbackOptions.userId());
    }
    if (addFeedbackOptions.comment() != null) {
      contentJson.addProperty("comment", addFeedbackOptions.comment());
    }
    contentJson.add("feedback_data", GsonSingleton.getGson().toJsonTree(addFeedbackOptions.feedbackData()));
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(FeedbackReturn.class));
  }

  /**
   * Deletes a specified feedback entry.
   *
   * @param deleteFeedbackOptions the {@link DeleteFeedbackOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> deleteFeedback(DeleteFeedbackOptions deleteFeedbackOptions) {
    Validator.notNull(deleteFeedbackOptions, "deleteFeedbackOptions cannot be null");
    String[] pathSegments = { "v1/feedback" };
    String[] pathParameters = { deleteFeedbackOptions.feedbackId() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query(VERSION, versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=compare-comply;service_version=v1;operation_id=deleteFeedback");
    if (deleteFeedbackOptions.modelId() != null) {
      builder.query("model_id", deleteFeedbackOptions.modelId());
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

  /**
   * List a specified feedback entry.
   *
   * @param getFeedbackOptions the {@link GetFeedbackOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link GetFeedback}
   */
  public ServiceCall<GetFeedback> getFeedback(GetFeedbackOptions getFeedbackOptions) {
    Validator.notNull(getFeedbackOptions, "getFeedbackOptions cannot be null");
    String[] pathSegments = { "v1/feedback" };
    String[] pathParameters = { getFeedbackOptions.feedbackId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query(VERSION, versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=compare-comply;service_version=v1;operation_id=getFeedback");
    if (getFeedbackOptions.modelId() != null) {
      builder.query("model_id", getFeedbackOptions.modelId());
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(GetFeedback.class));
  }

  /**
   * List the feedback in documents.
   *
   * @param listFeedbackOptions the {@link ListFeedbackOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link FeedbackList}
   */
  public ServiceCall<FeedbackList> listFeedback(ListFeedbackOptions listFeedbackOptions) {
    String[] pathSegments = { "v1/feedback" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    builder.query(VERSION, versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=compare-comply;service_version=v1;operation_id=listFeedback");
    if (listFeedbackOptions != null) {
      if (listFeedbackOptions.feedbackType() != null) {
        builder.query("feedback_type", listFeedbackOptions.feedbackType());
      }
      if (listFeedbackOptions.before() != null) {
        builder.query("before", String.valueOf(listFeedbackOptions.before()));
      }
      if (listFeedbackOptions.after() != null) {
        builder.query("after", String.valueOf(listFeedbackOptions.after()));
      }
      if (listFeedbackOptions.documentTitle() != null) {
        builder.query("document_title", listFeedbackOptions.documentTitle());
      }
      if (listFeedbackOptions.modelId() != null) {
        builder.query("model_id", listFeedbackOptions.modelId());
      }
      if (listFeedbackOptions.modelVersion() != null) {
        builder.query("model_version", listFeedbackOptions.modelVersion());
      }
      if (listFeedbackOptions.categoryRemoved() != null) {
        builder.query("category_removed", listFeedbackOptions.categoryRemoved());
      }
      if (listFeedbackOptions.categoryAdded() != null) {
        builder.query("category_added", listFeedbackOptions.categoryAdded());
      }
      if (listFeedbackOptions.categoryNotChanged() != null) {
        builder.query("category_not_changed", listFeedbackOptions.categoryNotChanged());
      }
      if (listFeedbackOptions.typeRemoved() != null) {
        builder.query("type_removed", listFeedbackOptions.typeRemoved());
      }
      if (listFeedbackOptions.typeAdded() != null) {
        builder.query("type_added", listFeedbackOptions.typeAdded());
      }
      if (listFeedbackOptions.typeNotChanged() != null) {
        builder.query("type_not_changed", listFeedbackOptions.typeNotChanged());
      }
      if (listFeedbackOptions.pageLimit() != null) {
        builder.query("page_limit", String.valueOf(listFeedbackOptions.pageLimit()));
      }
      if (listFeedbackOptions.cursor() != null) {
        builder.query("cursor", listFeedbackOptions.cursor());
      }
      if (listFeedbackOptions.sort() != null) {
        builder.query("sort", listFeedbackOptions.sort());
      }
      if (listFeedbackOptions.includeTotal() != null) {
        builder.query("include_total", String.valueOf(listFeedbackOptions.includeTotal()));
      }
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(FeedbackList.class));
  }

  /**
   * List the feedback in documents.
   *
   * @return a {@link ServiceCall} with a response type of {@link FeedbackList}
   */
  public ServiceCall<FeedbackList> listFeedback() {
    return listFeedback(null);
  }

  /**
   * Submit a batch-processing request.
   *
   * Run Compare and Comply methods over a collection of input documents.
   * **Important:** Batch processing requires the use of the [IBM Cloud Object Storage
   * service](https://cloud.ibm.com/docs/services/cloud-object-storage/about-cos.html#about-ibm-cloud-object-storage).
   * The use of IBM Cloud Object Storage with Compare and Comply is discussed at [Using batch
   * processing](https://cloud.ibm.com/docs/services/compare-comply/batching.html#before-you-batch).
   *
   * @param createBatchOptions the {@link CreateBatchOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link BatchStatus}
   */
  public ServiceCall<BatchStatus> createBatch(CreateBatchOptions createBatchOptions) {
    Validator.notNull(createBatchOptions, "createBatchOptions cannot be null");
    String[] pathSegments = { "v1/batches" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    builder.query(VERSION, versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=compare-comply;service_version=v1;operation_id=createBatch");
    builder.query("function", createBatchOptions.function());
    if (createBatchOptions.modelId() != null) {
      builder.query("model_id", createBatchOptions.modelId());
    }
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    RequestBody inputCredentialsFileBody = RequestUtils.inputStreamBody(createBatchOptions.inputCredentialsFile(),
        "application/json");
    multipartBuilder.addFormDataPart("input_credentials_file", createBatchOptions.inputCredentialsFilename(),
        inputCredentialsFileBody);
    multipartBuilder.addFormDataPart("input_bucket_location", createBatchOptions.inputBucketLocation());
    multipartBuilder.addFormDataPart("input_bucket_name", createBatchOptions.inputBucketName());
    RequestBody outputCredentialsFileBody = RequestUtils.inputStreamBody(createBatchOptions.outputCredentialsFile(),
        "application/json");
    multipartBuilder.addFormDataPart("output_credentials_file", createBatchOptions.outputCredentialsFilename(),
        outputCredentialsFileBody);
    multipartBuilder.addFormDataPart("output_bucket_location", createBatchOptions.outputBucketLocation());
    multipartBuilder.addFormDataPart("output_bucket_name", createBatchOptions.outputBucketName());
    builder.body(multipartBuilder.build());
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(BatchStatus.class));
  }

  /**
   * Get information about a specific batch-processing request.
   *
   * Get information about a batch-processing request with a specified ID.
   *
   * @param getBatchOptions the {@link GetBatchOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link BatchStatus}
   */
  public ServiceCall<BatchStatus> getBatch(GetBatchOptions getBatchOptions) {
    Validator.notNull(getBatchOptions, "getBatchOptions cannot be null");
    String[] pathSegments = { "v1/batches" };
    String[] pathParameters = { getBatchOptions.batchId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query(VERSION, versionDate);
    builder.header("X-IBMCloud-SDK-Analytics", "service_name=compare-comply;service_version=v1;operation_id=getBatch");
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(BatchStatus.class));
  }

  /**
   * List submitted batch-processing jobs.
   *
   * List the batch-processing jobs submitted by users.
   *
   * @param listBatchesOptions the {@link ListBatchesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Batches}
   */
  public ServiceCall<Batches> listBatches(ListBatchesOptions listBatchesOptions) {
    String[] pathSegments = { "v1/batches" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
    builder.query(VERSION, versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=compare-comply;service_version=v1;operation_id=listBatches");
    if (listBatchesOptions != null) {
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Batches.class));
  }

  /**
   * List submitted batch-processing jobs.
   *
   * List the batch-processing jobs submitted by users.
   *
   * @return a {@link ServiceCall} with a response type of {@link Batches}
   */
  public ServiceCall<Batches> listBatches() {
    return listBatches(null);
  }

  /**
   * Update a pending or active batch-processing request.
   *
   * Update a pending or active batch-processing request. You can rescan the input bucket to check for new documents or
   * cancel a request.
   *
   * @param updateBatchOptions the {@link UpdateBatchOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link BatchStatus}
   */
  public ServiceCall<BatchStatus> updateBatch(UpdateBatchOptions updateBatchOptions) {
    Validator.notNull(updateBatchOptions, "updateBatchOptions cannot be null");
    String[] pathSegments = { "v1/batches" };
    String[] pathParameters = { updateBatchOptions.batchId() };
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments,
        pathParameters));
    builder.query(VERSION, versionDate);
    builder.header("X-IBMCloud-SDK-Analytics",
        "service_name=compare-comply;service_version=v1;operation_id=updateBatch");
    builder.query("action", updateBatchOptions.action());
    if (updateBatchOptions.modelId() != null) {
      builder.query("model_id", updateBatchOptions.modelId());
    }
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(BatchStatus.class));
  }

}
