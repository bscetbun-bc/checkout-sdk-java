

import com.checkout.CheckoutApi;
import com.checkout.CheckoutApiException;
import com.checkout.CheckoutArgumentException;
import com.checkout.CheckoutAuthorizationException;
import com.checkout.CheckoutSdk;
import com.checkout.Environment;
import com.checkout.disputes.DisputeStatus;
import com.checkout.disputes.DisputesQueryFilter;
import com.checkout.disputes.DisputesQueryResponse;

import java.time.LocalDateTime;
import java.time.ZoneOffset;







        CheckoutApi api = CheckoutSdk.defaultSdk()
                .staticKeys()
                .publicKey("public_key")
                .secretKey("secret_key")
                .environment(Environment.SANDBOX) // or Environment.PRODUCTION
                .build();

        DisputesQueryFilter query = DisputesQueryFilter.builder()
                .paymentId("payment_id")
                .from(LocalDateTime.now().minusYears(2).toInstant(ZoneOffset.UTC).toString())
                .to(LocalDateTime.now().toString())
                .paymentArn("payment_arn")
                .paymentReference("payment_reference")
                .statuses(String.join(",", DisputeStatus.EVIDENCE_REQUIRED.getStatus(), DisputeStatus.ACCEPTED.getStatus()))
                .limit(10)
                .skip(5)
                .build();

        try {
            DisputesQueryResponse response = api.disputesClient().query(query).get();
        } catch (CheckoutApiException e) {
            // API error
            String requestId = e.getRequestId();
            int statusCode = e.getHttpStatusCode();
            Map<String, Object> errorDetails = e.getErrorDetails();
        } catch (CheckoutArgumentException e) {
            // Bad arguments
        } catch (CheckoutAuthorizationException e) {
            // Invalid authorization
        }

    }

}


