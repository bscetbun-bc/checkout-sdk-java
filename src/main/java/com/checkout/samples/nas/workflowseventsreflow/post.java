

import com.checkout.CheckoutApiException;
import com.checkout.CheckoutArgumentException;
import com.checkout.CheckoutAuthorizationException;
import com.checkout.CheckoutSdk;
import com.checkout.Environment;
import com.checkout.four.CheckoutApi;
import com.checkout.workflows.four.reflow.ReflowByEventsRequest;
import com.checkout.workflows.four.reflow.ReflowResponse;

import java.util.Arrays;







        CheckoutApi api = CheckoutSdk.fourSdk()
                .staticKeys()
                .publicKey("public_key")
                .secretKey("secret_key")
                .environment(Environment.SANDBOX) // or Environment.PRODUCTION
                .build();

        ReflowByEventsRequest request = ReflowByEventsRequest.builder()
                .events(Arrays.asList("event_id_1", "event_id_2"))
                .workflows(Arrays.asList("workflow_id_1", "workflow_id_2"))
                .build();

        try {
            ReflowResponse response = api.workflowsClient().reflow(request).get();
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

