package com.stripe.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class SourceTransaction extends StripeObject implements HasId {
  SourceTypeAchCreditTransfer achCreditTransfer;

  SourceTypeAchDebit achDebit;

  SourceTypeAlipay alipay;

  /**
   * A positive integer in the smallest currency unit (that is, 100 cents for $1.00, or 1 for ¥1,
   * Japanese Yen being a zero-decimal currency) representing the amount your customer has pushed to
   * the receiver.
   */
  Long amount;

  SourceTypeBancontact bancontact;

  SourceTypeCard card;

  SourceTypeCardPresent cardPresent;

  /** Time at which the object was created. Measured in seconds since the Unix epoch. */
  Long created;

  /**
   * Three-letter [ISO currency code](https://www.iso.org/iso-4217-currency-codes.html), in
   * lowercase. Must be a [supported currency](https://stripe.com/docs/currencies).
   */
  String currency;

  SourceTypeEps eps;

  SourceTypeGiropay giropay;

  /** Unique identifier for the object. */
  @Getter(onMethod = @__({@Override}))
  String id;

  SourceTypeIdeal ideal;

  /**
   * Has the value `true` if the object exists in live mode or the value `false` if the object
   * exists in test mode.
   */
  Boolean livemode;

  SourceTypeMultibanco multibanco;

  /** String representing the object's type. Objects of the same type share the same value. */
  String object;

  SourceTypeP24 p24;

  SourceTypePaperCheck paperCheck;

  SourceTypeSepaCreditTransfer sepaCreditTransfer;

  SourceTypeSepaDebit sepaDebit;

  SourceTypeSofort sofort;

  /** The ID of the source this transaction is attached to. */
  String source;

  /** The status of the transaction, one of `succeeded`, `pending`, or `failed`. */
  String status;

  SourceTypeThreeDSecure threeDSecure;

  /** The type of source this transaction is attached to. */
  String type;
}
