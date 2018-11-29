package com.stripe.model;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.net.ApiResource;
import com.stripe.net.RequestOptions;
import java.util.Map;

public class SubscriptionCollection extends StripeCollection<Subscription> {
  /** Creates a new subscription on an existing customer. */
  public Subscription create(Map<String, Object> params) throws StripeException {
    return create(params, (RequestOptions) null);
  }

  /** Creates a new subscription on an existing customer. */
  public Subscription create(Map<String, Object> params, RequestOptions options)
      throws StripeException {
    String url = String.format("%s%s", Stripe.getApiBase(), this.getUrl());
    return ApiResource.request(
        ApiResource.RequestMethod.POST, url, params, Subscription.class, options);
  }

  /**
   * You can see a list of the customer’s active subscriptions. Note that the 10 most recent active
   * subscriptions are always available by default on the customer object. If you need more than
   * those 10, you can use the limit and starting_after parameters to page through additional
   * subscriptions.
   */
  public SubscriptionCollection list(Map<String, Object> params) throws StripeException {
    return list(params, (RequestOptions) null);
  }

  /**
   * You can see a list of the customer’s active subscriptions. Note that the 10 most recent active
   * subscriptions are always available by default on the customer object. If you need more than
   * those 10, you can use the limit and starting_after parameters to page through additional
   * subscriptions.
   */
  public SubscriptionCollection list(Map<String, Object> params, RequestOptions options)
      throws StripeException {
    String url = String.format("%s%s", Stripe.getApiBase(), this.getUrl());
    return ApiResource.requestCollection(url, params, SubscriptionCollection.class, options);
  }

  /** Retrieves the subscription with the given ID. */
  public Subscription retrieve(String id) throws StripeException {
    return retrieve(id, (Map<String, Object>) null, (RequestOptions) null);
  }

  /** Retrieves the subscription with the given ID. */
  public Subscription retrieve(String id, RequestOptions options) throws StripeException {
    return retrieve(id, (Map<String, Object>) null, options);
  }

  /** Retrieves the subscription with the given ID. */
  public Subscription retrieve(String id, Map<String, Object> params, RequestOptions options)
      throws StripeException {
    String url =
        String.format("%s%s", Stripe.getApiBase(), String.format("%s/%s", this.getUrl(), id));
    return ApiResource.request(
        ApiResource.RequestMethod.GET, url, params, Subscription.class, options);
  }
}
