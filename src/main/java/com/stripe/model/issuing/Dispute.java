package com.stripe.model.issuing;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.ExpandableField;
import com.stripe.model.HasId;
import com.stripe.model.IssuingDisputeEvidence;
import com.stripe.model.MetadataStore;
import com.stripe.net.ApiResource;
import com.stripe.net.RequestOptions;
import java.util.Map;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Dispute extends ApiResource implements HasId, MetadataStore<Dispute> {
  /**
   * Disputed amount. Usually the amount of the `disputed_transaction`, but can differ (usually
   * because of currency fluctuation or because only part of the order is disputed).
   */
  Long amount;

  /** Time at which the object was created. Measured in seconds since the Unix epoch. */
  Long created;

  /** The currency the `disputed_transaction` was made in. */
  String currency;

  /** The transaction being disputed. */
  @Getter(lombok.AccessLevel.NONE)
  @Setter(lombok.AccessLevel.NONE)
  ExpandableField<Transaction> disputedTransaction;

  IssuingDisputeEvidence evidence;

  /** Unique identifier for the object. */
  @Getter(onMethod = @__({@Override}))
  String id;

  /**
   * Has the value `true` if the object exists in live mode or the value `false` if the object
   * exists in test mode.
   */
  Boolean livemode;

  /**
   * Set of key-value pairs that you can attach to an object. This can be useful for storing
   * additional information about the object in a structured format. Individual keys can be unset by
   * posting an empty value to them. All keys can be unset by posting an empty value to `metadata`.
   */
  @Getter(onMethod = @__({@Override}))
  Map<String, String> metadata;

  /** String representing the object's type. Objects of the same type share the same value. */
  String object;

  /** Reason for this dispute. One of `other` or `fraudulent`. */
  String reason;

  /** Current status of dispute. One of `unsubmitted`, `under_review`, `won`, or `lost`. */
  String status;

  /** Get id of expandable `disputedTransaction` object. */
  public String getDisputedTransaction() {
    return (this.disputedTransaction != null) ? this.disputedTransaction.getId() : null;
  }

  public void setDisputedTransaction(String id) {
    this.disputedTransaction = ApiResource.setExpandableFieldId(id, this.disputedTransaction);
  }

  /** Get expanded `disputedTransaction`. */
  public Transaction getDisputedTransactionObject() {
    return (this.disputedTransaction != null) ? this.disputedTransaction.getExpanded() : null;
  }

  public void setDisputedTransactionObject(Transaction expandableObject) {
    this.disputedTransaction =
        new ExpandableField<Transaction>(expandableObject.getId(), expandableObject);
  }

  /** Creates an Issuing <code>Dispute</code> object. */
  public static Dispute create(Map<String, Object> params) throws StripeException {
    return create(params, (RequestOptions) null);
  }

  /** Creates an Issuing <code>Dispute</code> object. */
  public static Dispute create(Map<String, Object> params, RequestOptions options)
      throws StripeException {
    String url = String.format("%s%s", Stripe.getApiBase(), "/v1/issuing/disputes");
    return request(ApiResource.RequestMethod.POST, url, params, Dispute.class, options);
  }

  /**
   * Returns a list of Issuing <code>Dispute</code> objects. The objects are sorted in descending
   * order by creation date, with the most recently created object appearing first.
   */
  public static DisputeCollection list(Map<String, Object> params) throws StripeException {
    return list(params, (RequestOptions) null);
  }

  /**
   * Returns a list of Issuing <code>Dispute</code> objects. The objects are sorted in descending
   * order by creation date, with the most recently created object appearing first.
   */
  public static DisputeCollection list(Map<String, Object> params, RequestOptions options)
      throws StripeException {
    String url = String.format("%s%s", Stripe.getApiBase(), "/v1/issuing/disputes");
    return requestCollection(url, params, DisputeCollection.class, options);
  }

  /** Retrieves an Issuing <code>Dispute</code> object. */
  public static Dispute retrieve(String dispute) throws StripeException {
    return retrieve(dispute, (Map<String, Object>) null, (RequestOptions) null);
  }

  /** Retrieves an Issuing <code>Dispute</code> object. */
  public static Dispute retrieve(String dispute, RequestOptions options) throws StripeException {
    return retrieve(dispute, (Map<String, Object>) null, options);
  }

  /** Retrieves an Issuing <code>Dispute</code> object. */
  public static Dispute retrieve(String dispute, Map<String, Object> params, RequestOptions options)
      throws StripeException {
    String url =
        String.format(
            "%s%s", Stripe.getApiBase(), String.format("/v1/issuing/disputes/%s", dispute));
    return request(ApiResource.RequestMethod.GET, url, params, Dispute.class, options);
  }

  /**
   * Updates the specified Issuing <code>Dispute</code> object by setting the values of the
   * parameters passed. Any parameters not provided will be left unchanged.
   */
  public Dispute update(Map<String, Object> params) throws StripeException {
    return update(params, (RequestOptions) null);
  }

  /**
   * Updates the specified Issuing <code>Dispute</code> object by setting the values of the
   * parameters passed. Any parameters not provided will be left unchanged.
   */
  public Dispute update(Map<String, Object> params, RequestOptions options) throws StripeException {
    String url =
        String.format(
            "%s%s", Stripe.getApiBase(), String.format("/v1/issuing/disputes/%s", this.getId()));
    return request(ApiResource.RequestMethod.POST, url, params, Dispute.class, options);
  }
}
