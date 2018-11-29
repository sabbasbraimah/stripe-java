package com.stripe.model;

import java.util.Map;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class LineItem extends StripeObject implements HasId {
  /** The amount, in %s. */
  Long amount;

  /**
   * Three-letter [ISO currency code](https://www.iso.org/iso-4217-currency-codes.html), in
   * lowercase. Must be a [supported currency](https://stripe.com/docs/currencies).
   */
  String currency;

  /** An arbitrary string attached to the object. Often useful for displaying to users. */
  String description;

  /** If true, discounts will apply to this line item. Always false for prorations. */
  Boolean discountable;

  /** Unique identifier for the object. */
  @Getter(onMethod = @__({@Override}))
  String id;

  String invoiceItem;

  /** Whether this is a test line item. */
  Boolean livemode;

  /**
   * Set of key-value pairs that you can attach to an object. This can be useful for storing
   * additional information about the object in a structured format. Note that for line items with
   * `type=subscription` this will reflect the metadata of the subscription that caused the line
   * item to be created.
   */
  Map<String, String> metadata;

  /** String representing the object's type. Objects of the same type share the same value. */
  String object;

  InvoiceLineItemPeriod period;

  /** The plan of the subscription, if the line item is a subscription or a proration. */
  Plan plan;

  /** Whether this is a proration. */
  Boolean proration;

  /** The quantity of the subscription, if the line item is a subscription or a proration. */
  Long quantity;

  /** The subscription that the invoice item pertains to, if any. */
  String subscription;

  /**
   * The subscription item that generated this invoice item. Left empty if the line item is not an
   * explicit result of a subscription.
   */
  String subscriptionItem;

  /**
   * A string identifying the type of the source of this line item, either an `invoiceitem` or a
   * `subscription`.
   */
  String type;
}
