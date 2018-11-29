package com.stripe.model.sigma;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.File;
import com.stripe.model.HasId;
import com.stripe.net.ApiResource;
import com.stripe.net.RequestOptions;
import java.util.Map;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class ScheduledQueryRun extends ApiResource implements HasId {
  /** Time at which the object was created. Measured in seconds since the Unix epoch. */
  Long created;

  /** When the query was run, Sigma contained a snapshot of your Stripe data at this time. */
  Long dataLoadTime;

  /** If the query run was not succeesful, this field contains information about the failure. */
  Map<String, Object> error;

  /** The file object representing the results of the query. */
  File file;

  /** Unique identifier for the object. */
  @Getter(onMethod = @__({@Override}))
  String id;

  /**
   * Has the value `true` if the object exists in live mode or the value `false` if the object
   * exists in test mode.
   */
  Boolean livemode;

  /** String representing the object's type. Objects of the same type share the same value. */
  String object;

  /** Time at which the result expires and is no longer available for download. */
  Long resultAvailableUntil;

  /** SQL for the query. */
  String sql;

  /**
   * The query's execution status, which will be `completed` for successful runs, and `canceled`,
   * `failed`, or `timed_out` otherwise.
   */
  String status;

  /** Title of the query. */
  String title;

  /** Returns a list of scheduled query runs. */
  public static ScheduledQueryRunCollection list(Map<String, Object> params)
      throws StripeException {
    return list(params, (RequestOptions) null);
  }

  /** Returns a list of scheduled query runs. */
  public static ScheduledQueryRunCollection list(Map<String, Object> params, RequestOptions options)
      throws StripeException {
    String url = String.format("%s%s", Stripe.getApiBase(), "/v1/sigma/scheduled_query_runs");
    return requestCollection(url, params, ScheduledQueryRunCollection.class, options);
  }

  /** Retrieves the details of an scheduled query run. */
  public static ScheduledQueryRun retrieve(String scheduledQueryRun) throws StripeException {
    return retrieve(scheduledQueryRun, (Map<String, Object>) null, (RequestOptions) null);
  }

  /** Retrieves the details of an scheduled query run. */
  public static ScheduledQueryRun retrieve(String scheduledQueryRun, RequestOptions options)
      throws StripeException {
    return retrieve(scheduledQueryRun, (Map<String, Object>) null, options);
  }

  /** Retrieves the details of an scheduled query run. */
  public static ScheduledQueryRun retrieve(
      String scheduledQueryRun, Map<String, Object> params, RequestOptions options)
      throws StripeException {
    String url =
        String.format(
            "%s%s",
            Stripe.getApiBase(),
            String.format("/v1/sigma/scheduled_query_runs/%s", scheduledQueryRun));
    return request(ApiResource.RequestMethod.GET, url, params, ScheduledQueryRun.class, options);
  }
}
