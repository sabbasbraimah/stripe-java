package com.stripe.model;

import com.stripe.net.ApiResource;
import java.util.Map;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class RecipientTransfer extends ApiResource implements BalanceTransactionSource {
  /** Amount (in %s) to be transferred to your bank account. */
  Long amount;

  /**
   * Amount in %s reversed (can be less than the amount attribute on the transfer if a partial
   * reversal was issued).
   */
  Long amountReversed;

  @Getter(lombok.AccessLevel.NONE)
  @Setter(lombok.AccessLevel.NONE)
  ExpandableField<ApplicationFee> applicationFee;

  /**
   * Returns `true` if the payout was created by an [automated payout
   * schedule](/docs/payouts#payout-schedule), and `false` if it was [requested
   * manually](https://stripe.com/docs/payouts#manual-payouts).
   */
  Boolean automatic;

  /** Balance transaction that describes the impact of this transfer on your account balance. */
  @Getter(lombok.AccessLevel.NONE)
  @Setter(lombok.AccessLevel.NONE)
  ExpandableField<BalanceTransaction> balanceTransaction;

  /** Time at which the object was created. Measured in seconds since the Unix epoch. */
  Long created;

  /**
   * Three-letter [ISO currency code](https://www.iso.org/iso-4217-currency-codes.html), in
   * lowercase. Must be a [supported currency](https://stripe.com/docs/currencies).
   */
  String currency;

  /**
   * Date the transfer is scheduled to arrive in the bank. This factors in delays like weekends or
   * bank holidays.
   */
  Long date;

  /** Internal-only description of the transfer. */
  String description;

  /** ID of the bank account, card, or Stripe account the transfer was sent to. */
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

  /**
   * Error code explaining reason for transfer failure if available. See [Types of transfer
   * failures](/docs/api#transfer_failures) for a list of failure codes.
   */
  String failureCode;

  /** Message to user further explaining reason for transfer failure if available. */
  String failureMessage;

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
   * additional information about the object in a structured format.
   */
  Map<String, String> metadata;

  /**
   * The method used to send this transfer, which can be `standard` or `instant`. `instant` is only
   * supported for transfers to debit cards. (See [Instant payouts for
   * marketplaces](/blog/instant-payouts-for-marketplaces) for more information.)
   */
  String method;

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
   * ID of the charge (or other transaction) that was used to fund the transfer. If null, the
   * transfer was funded from the available balance.
   */
  @Getter(lombok.AccessLevel.NONE)
  @Setter(lombok.AccessLevel.NONE)
  ExpandableField<Charge> sourceTransaction;

  /**
   * The source balance this transfer came from. One of `card`, `bank_account`, or `alipay_account`.
   */
  String sourceType;

  /** Extra information about a transfer to be displayed on the user's bank statement. */
  String statementDescriptor;

  /**
   * Current status of the transfer (`paid`, `pending`, `in_transit`, `canceled` or `failed`). A
   * transfer will be `pending` until it is submitted to the bank, at which point it becomes
   * `in_transit`. It will then change to `paid` if the transaction goes through. If it does not go
   * through successfully, its status will change to `failed` or `canceled`.
   */
  String status;

  /**
   * A string that identifies this transaction as part of a group. See the [Connect
   * documentation](/docs/connect/charges-transfers#grouping-transactions) for details.
   */
  String transferGroup;

  /** Can be `card`, `bank_account`, or `stripe_account`. */
  String type;

  /** Get id of expandable `applicationFee` object. */
  public String getApplicationFee() {
    return (this.applicationFee != null) ? this.applicationFee.getId() : null;
  }

  public void setApplicationFee(String id) {
    this.applicationFee = ApiResource.setExpandableFieldId(id, this.applicationFee);
  }

  /** Get expanded `applicationFee`. */
  public ApplicationFee getApplicationFeeObject() {
    return (this.applicationFee != null) ? this.applicationFee.getExpanded() : null;
  }

  public void setApplicationFeeObject(ApplicationFee expandableObject) {
    this.applicationFee =
        new ExpandableField<ApplicationFee>(expandableObject.getId(), expandableObject);
  }

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
}
