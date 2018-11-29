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
public class Transfer extends ApiResource
    implements BalanceTransactionSource, MetadataStore<Transfer> {
  /** Amount in %s to be transferred. */
  Long amount;

  /**
   * Amount in %s reversed (can be less than the amount attribute on the transfer if a partial
   * reversal was issued).
   */
  Long amountReversed;

  /** Balance transaction that describes the impact of this transfer on your account balance. */
  @Getter(lombok.AccessLevel.NONE)
  @Setter(lombok.AccessLevel.NONE)
  ExpandableField<BalanceTransaction> balanceTransaction;

  /** Time that this record of the transfer was first created. */
  Long created;

  /**
   * Three-letter [ISO currency code](https://www.iso.org/iso-4217-currency-codes.html), in
   * lowercase. Must be a [supported currency](https://stripe.com/docs/currencies).
   */
  String currency;

  /** An arbitrary string attached to the object. Often useful for displaying to users. */
  String description;

  /** ID of the Stripe account the transfer was sent to. */
  @Getter(lombok.AccessLevel.NONE)
  @Setter(lombok.AccessLevel.NONE)
  ExpandableField<Account> destination;

  /**
   * If the destination is a Stripe account, this will be the ID of the payment that the destination
   * account received for the transfer.
   */
  @Getter(lombok.AccessLevel.NONE)
  @Setter(lombok.AccessLevel.NONE)
  ExpandableField<Charge> destinationPayment;

  /** Unique identifier for the object. */
  @Getter(onMethod = @__({@Override}))
  String id;

  /**
   * Has the value `true` if the object exists in live mode or the value `false` if the object
   * exists in test mode.
   */
  Boolean livemode;

  /**
   * A set of key/value pairs that you can attach to a transfer object. It can be useful for storing
   * additional information about the transfer in a structured format.
   */
  @Getter(onMethod = @__({@Override}))
  Map<String, String> metadata;

  /** String representing the object's type. Objects of the same type share the same value. */
  String object;

  /** A list of reversals that have been applied to the transfer. */
  TransferReversalCollection reversals;

  /**
   * Whether the transfer has been fully reversed. If the transfer is only partially reversed, this
   * attribute will still be false.
   */
  Boolean reversed;

  /**
   * ID of the charge or payment that was used to fund the transfer. If null, the transfer was
   * funded from the available balance.
   */
  @Getter(lombok.AccessLevel.NONE)
  @Setter(lombok.AccessLevel.NONE)
  ExpandableField<Charge> sourceTransaction;

  /**
   * The source balance this transfer came from. One of `card`, `bank_account`, or `alipay_account`.
   */
  String sourceType;

  /**
   * A string that identifies this transaction as part of a group. See the [Connect
   * documentation](/docs/connect/charges-transfers#grouping-transactions) for details.
   */
  String transferGroup;

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

  /** Get id of expandable `destination` object. */
  public String getDestination() {
    return (this.destination != null) ? this.destination.getId() : null;
  }

  public void setDestination(String id) {
    this.destination = ApiResource.setExpandableFieldId(id, this.destination);
  }

  /** Get expanded `destination`. */
  public Account getDestinationObject() {
    return (this.destination != null) ? this.destination.getExpanded() : null;
  }

  public void setDestinationObject(Account expandableObject) {
    this.destination = new ExpandableField<Account>(expandableObject.getId(), expandableObject);
  }

  /** Get id of expandable `destinationPayment` object. */
  public String getDestinationPayment() {
    return (this.destinationPayment != null) ? this.destinationPayment.getId() : null;
  }

  public void setDestinationPayment(String id) {
    this.destinationPayment = ApiResource.setExpandableFieldId(id, this.destinationPayment);
  }

  /** Get expanded `destinationPayment`. */
  public Charge getDestinationPaymentObject() {
    return (this.destinationPayment != null) ? this.destinationPayment.getExpanded() : null;
  }

  public void setDestinationPaymentObject(Charge expandableObject) {
    this.destinationPayment =
        new ExpandableField<Charge>(expandableObject.getId(), expandableObject);
  }

  /** Get id of expandable `sourceTransaction` object. */
  public String getSourceTransaction() {
    return (this.sourceTransaction != null) ? this.sourceTransaction.getId() : null;
  }

  public void setSourceTransaction(String id) {
    this.sourceTransaction = ApiResource.setExpandableFieldId(id, this.sourceTransaction);
  }

  /** Get expanded `sourceTransaction`. */
  public Charge getSourceTransactionObject() {
    return (this.sourceTransaction != null) ? this.sourceTransaction.getExpanded() : null;
  }

  public void setSourceTransactionObject(Charge expandableObject) {
    this.sourceTransaction =
        new ExpandableField<Charge>(expandableObject.getId(), expandableObject);
  }

  /**
   * To send funds from your Stripe account to a connected account, you create a new transfer
   * object. Your <a href="#balance">Stripe balance</a> must be able to cover the transfer amount,
   * or you’ll receive an “Insufficient Funds” error.
   */
  public static Transfer create(Map<String, Object> params) throws StripeException {
    return create(params, (RequestOptions) null);
  }

  /**
   * To send funds from your Stripe account to a connected account, you create a new transfer
   * object. Your <a href="#balance">Stripe balance</a> must be able to cover the transfer amount,
   * or you’ll receive an “Insufficient Funds” error.
   */
  public static Transfer create(Map<String, Object> params, RequestOptions options)
      throws StripeException {
    String url = String.format("%s%s", Stripe.getApiBase(), "/v1/transfers");
    return request(ApiResource.RequestMethod.POST, url, params, Transfer.class, options);
  }

  /**
   * Returns a list of existing transfers sent to connected accounts. The transfers are returned in
   * sorted order, with the most recently created transfers appearing first.
   */
  public static TransferCollection list(Map<String, Object> params) throws StripeException {
    return list(params, (RequestOptions) null);
  }

  /**
   * Returns a list of existing transfers sent to connected accounts. The transfers are returned in
   * sorted order, with the most recently created transfers appearing first.
   */
  public static TransferCollection list(Map<String, Object> params, RequestOptions options)
      throws StripeException {
    String url = String.format("%s%s", Stripe.getApiBase(), "/v1/transfers");
    return requestCollection(url, params, TransferCollection.class, options);
  }

  /**
   * Retrieves the details of an existing transfer. Supply the unique transfer ID from either a
   * transfer creation request or the transfer list, and Stripe will return the corresponding
   * transfer information.
   */
  public static Transfer retrieve(String transfer) throws StripeException {
    return retrieve(transfer, (Map<String, Object>) null, (RequestOptions) null);
  }

  /**
   * Retrieves the details of an existing transfer. Supply the unique transfer ID from either a
   * transfer creation request or the transfer list, and Stripe will return the corresponding
   * transfer information.
   */
  public static Transfer retrieve(String transfer, RequestOptions options) throws StripeException {
    return retrieve(transfer, (Map<String, Object>) null, options);
  }

  /**
   * Retrieves the details of an existing transfer. Supply the unique transfer ID from either a
   * transfer creation request or the transfer list, and Stripe will return the corresponding
   * transfer information.
   */
  public static Transfer retrieve(
      String transfer, Map<String, Object> params, RequestOptions options) throws StripeException {
    String url =
        String.format("%s%s", Stripe.getApiBase(), String.format("/v1/transfers/%s", transfer));
    return request(ApiResource.RequestMethod.GET, url, params, Transfer.class, options);
  }

  /**
   * Updates the specified transfer by setting the values of the parameters passed. Any parameters
   * not provided will be left unchanged.
   *
   * <p>This request accepts only metadata as an argument.
   */
  public Transfer update(Map<String, Object> params) throws StripeException {
    return update(params, (RequestOptions) null);
  }

  /**
   * Updates the specified transfer by setting the values of the parameters passed. Any parameters
   * not provided will be left unchanged.
   *
   * <p>This request accepts only metadata as an argument.
   */
  public Transfer update(Map<String, Object> params, RequestOptions options)
      throws StripeException {
    String url =
        String.format("%s%s", Stripe.getApiBase(), String.format("/v1/transfers/%s", this.getId()));
    return request(ApiResource.RequestMethod.POST, url, params, Transfer.class, options);
  }
}
