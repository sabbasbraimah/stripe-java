package com.stripe.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class OrderShipping extends StripeObject {
  Address address;

  /** The delivery service that shipped a physical product, such as Fedex, UPS, USPS, etc. */
  String carrier;

  /** Recipient name. */
  String name;

  /** Recipient phone (including extension). */
  String phone;

  /**
   * The tracking number for a physical product, obtained from the delivery service. If multiple
   * tracking numbers were generated for this purchase, please separate them with commas.
   */
  String trackingNumber;
}
