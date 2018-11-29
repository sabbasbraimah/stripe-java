package com.stripe.model;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.net.ApiResource;
import com.stripe.net.RequestOptions;
import java.util.Map;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Refund extends ApiResource implements BalanceTransactionSource, MetadataStore<Refund> {
  /** Amount, in %s. */
  Long amount;

  /** Balance transaction that describes the impact on your account balance. */
  @Getter(lombok.AccessLevel.NONE)
  @Setter(lombok.AccessLevel.NONE)
  ExpandableField<BalanceTransaction> balanceTransaction;

  /** ID of the charge that was refunded. */
  @Getter(lombok.AccessLevel.NONE)
  @Setter(lombok.AccessLevel.NONE)
  ExpandableField<Charge> charge;

  /** Time at which the object was created. Measured in seconds since the Unix epoch. */
  Long created;

  /**
   * Three-letter [ISO currency code](https://www.iso.org/iso-4217-currency-codes.html), in
   * lowercase. Must be a [supported currency](https://stripe.com/docs/currencies).
   */
  String currency;

  /**
   * If the refund failed, this balance transaction describes the adjustment made on your account
   * balance that reverses the initial balance transaction.
   */
  @Getter(lombok.AccessLevel.NONE)
  @Setter(lombok.AccessLevel.NONE)
  ExpandableField<BalanceTransaction> failureBalanceTransaction;

  /**
   * If the refund failed, the reason for refund failure if known. Possible values are
   * `lost_or_stolen_card`, `expired_or_canceled_card`, or `unknown`.
   */
  String failureReason;

  /** Unique identifier for the object. */
  @Getter(onMethod = @__({@Override}))
  String id;

  /**
   * Set of key-value pairs that you can attach to an object. This can be useful for storing
   * additional information about the object in a structured format.
   */
  @Getter(onMethod = @__({@Override}))
  Map<String, String> metadata;

  /** String representing the object's type. Objects of the same type share the same value. */
  String object;

  /**
   * Reason for the refund. If set, possible values are `duplicate`, `fraudulent`, and
   * `requested_by_customer`.
   */
  String reason;

  /** This is the transaction number that appears on email receipts sent for this refund. */
  String receiptNumber;

  /**
   * The transfer reversal that is associated with the refund. Only present if the charge came from
   * another Stripe account. See the Connect documentation for details.
   */
  @Getter(lombok.AccessLevel.NONE)
  @Setter(lombok.AccessLevel.NONE)
  ExpandableField<TransferReversal> sourceTransferReversal;

  /**
   * Status of the refund. For credit card refunds, this can be `succeeded` or `failed`. For other
   * types of refunds, it can be `pending`, `succeeded`, `failed`, or `canceled`. Refer to our
   * [refunds](/docs/refunds#failed-refunds) documentation for more details.
   */
  String status;

  /**
   * If the accompanying transfer was reversed, the transfer reversal object. Only applicable if the
   * charge was created using the destination parameter.
   */
  @Getter(lombok.AccessLevel.NONE)
  @Setter(lombok.AccessLevel.NONE)
  ExpandableField<TransferReversal> transferReversal;

  /** Get id of expandable `balanceTransaction` object. */
  public String getBalanceTransaction() {
    return (this.balanceTransaction != null) ? this.balanceTransaction.getId() : null;
  }

  public void setBalanceTransaction(String id) {
    this.balanceTransaction = ApiResource.setExpandableFieldId(id, this.balanceTransaction);
  }

  /** Get expanded `balanceTransaction`. */
  public BalanceTransaction getBalanceTransactionObject() {
    return (this.balanceTransaction != null) ? this.balanceTransaction.getExpanded() : null;
  }

  public void setBalanceTransactionObject(BalanceTransaction expandableObject) {
    this.balanceTransaction =
        new ExpandableField<BalanceTransaction>(expandableObject.getId(), expandableObject);
  }

  /** Get id of expandable `charge` object. */
  public String getCharge() {
    return (this.charge != null) ? this.charge.getId() : null;
  }

  public void setCharge(String id) {
    this.charge = ApiResource.setExpandableFieldId(id, this.charge);
  }

  /** Get expanded `charge`. */
  public Charge getChargeObject() {
    return (this.charge != null) ? this.charge.getExpanded() : null;
  }

  public void setChargeObject(Charge expandableObject) {
    this.charge = new ExpandableField<Charge>(expandableObject.getId(), expandableObject);
  }

  /** Get id of expandable `failureBalanceTransaction` object. */
  public String getFailureBalanceTransaction() {
    return (this.failureBalanceTransaction != null) ? this.failureBalanceTransaction.getId() : null;
  }

  public void setFailureBalanceTransaction(String id) {
    this.failureBalanceTransaction =
        ApiResource.setExpandableFieldId(id, this.failureBalanceTransaction);
  }

  /** Get expanded `failureBalanceTransaction`. */
  public BalanceTransaction getFailureBalanceTransactionObject() {
    return (this.failureBalanceTransaction != null)
        ? this.failureBalanceTransaction.getExpanded()
        : null;
  }

  public void setFailureBalanceTransactionObject(BalanceTransaction expandableObject) {
    this.failureBalanceTransaction =
        new ExpandableField<BalanceTransaction>(expandableObject.getId(), expandableObject);
  }

  /** Get id of expandable `sourceTransferReversal` object. */
  public String getSourceTransferReversal() {
    return (this.sourceTransferReversal != null) ? this.sourceTransferReversal.getId() : null;
  }

  public void setSourceTransferReversal(String id) {
    this.sourceTransferReversal = ApiResource.setExpandableFieldId(id, this.sourceTransferReversal);
  }

  /** Get expanded `sourceTransferReversal`. */
  public TransferReversal getSourceTransferReversalObject() {
    return (this.sourceTransferReversal != null) ? this.sourceTransferReversal.getExpanded() : null;
  }

  public void setSourceTransferReversalObject(TransferReversal expandableObject) {
    this.sourceTransferReversal =
        new ExpandableField<TransferReversal>(expandableObject.getId(), expandableObject);
  }

  /** Get id of expandable `transferReversal` object. */
  public String getTransferReversal() {
    return (this.transferReversal != null) ? this.transferReversal.getId() : null;
  }

  public void setTransferReversal(String id) {
    this.transferReversal = ApiResource.setExpandableFieldId(id, this.transferReversal);
  }

  /** Get expanded `transferReversal`. */
  public TransferReversal getTransferReversalObject() {
    return (this.transferReversal != null) ? this.transferReversal.getExpanded() : null;
  }

  public void setTransferReversalObject(TransferReversal expandableObject) {
    this.transferReversal =
        new ExpandableField<TransferReversal>(expandableObject.getId(), expandableObject);
  }

  /** Create a refund. */
  public static Refund create(Map<String, Object> params) throws StripeException {
    return create(params, (RequestOptions) null);
  }

  /** Create a refund. */
  public static Refund create(Map<String, Object> params, RequestOptions options)
      throws StripeException {
    String url = String.format("%s%s", Stripe.getApiBase(), "/v1/refunds");
    return request(ApiResource.RequestMethod.POST, url, params, Refund.class, options);
  }

  /**
   * Returns a list of all refunds you’ve previously created. The refunds are returned in sorted
   * order, with the most recent refunds appearing first. For convenience, the 10 most recent
   * refunds are always available by default on the charge object.
   */
  public static RefundCollection list(Map<String, Object> params) throws StripeException {
    return list(params, (RequestOptions) null);
  }

  /**
   * Returns a list of all refunds you’ve previously created. The refunds are returned in sorted
   * order, with the most recent refunds appearing first. For convenience, the 10 most recent
   * refunds are always available by default on the charge object.
   */
  public static RefundCollection list(Map<String, Object> params, RequestOptions options)
      throws StripeException {
    String url = String.format("%s%s", Stripe.getApiBase(), "/v1/refunds");
    return requestCollection(url, params, RefundCollection.class, options);
  }

  /** Retrieves the details of an existing refund. */
  public static Refund retrieve(String refund) throws StripeException {
    return retrieve(refund, (Map<String, Object>) null, (RequestOptions) null);
  }

  /** Retrieves the details of an existing refund. */
  public static Refund retrieve(String refund, RequestOptions options) throws StripeException {
    return retrieve(refund, (Map<String, Object>) null, options);
  }

  /** Retrieves the details of an existing refund. */
  public static Refund retrieve(String refund, Map<String, Object> params, RequestOptions options)
      throws StripeException {
    String url =
        String.format("%s%s", Stripe.getApiBase(), String.format("/v1/refunds/%s", refund));
    return request(ApiResource.RequestMethod.GET, url, params, Refund.class, options);
  }

  /**
   * Updates the specified refund by setting the values of the parameters passed. Any parameters not
   * provided will be left unchanged.
   *
   * <p>This request only accepts <code>metadata</code> as an argument.
   */
  public Refund update(Map<String, Object> params) throws StripeException {
    return update(params, (RequestOptions) null);
  }

  /**
   * Updates the specified refund by setting the values of the parameters passed. Any parameters not
   * provided will be left unchanged.
   *
   * <p>This request only accepts <code>metadata</code> as an argument.
   */
  public Refund update(Map<String, Object> params, RequestOptions options) throws StripeException {
    String url =
        String.format("%s%s", Stripe.getApiBase(), String.format("/v1/refunds/%s", this.getId()));
    return request(ApiResource.RequestMethod.POST, url, params, Refund.class, options);
  }
}
