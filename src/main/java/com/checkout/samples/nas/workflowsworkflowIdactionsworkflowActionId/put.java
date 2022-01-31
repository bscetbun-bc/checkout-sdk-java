

import com.checkout.CheckoutApiException;
import com.checkout.CheckoutArgumentException;
import com.checkout.CheckoutAuthorizationException;
import com.checkout.CheckoutSdk;
import com.checkout.Environment;
import com.checkout.four.CheckoutApi;
import com.checkout.workflows.four.actions.WebhookSignature;
import com.checkout.workflows.four.actions.request.WebhookWorkflowActionRequest;

import java.util.HashMap;



public class put {



        CheckoutApi api = CheckoutSdk.fourSdk()
                .staticKeys()
                .publicKey("public_key")
                .secretKey("secret_key")
                .environment(Environment.SANDBOX) // or Environment.PRODUCTION
                .build();

        WebhookWorkflowActionRequest request = WebhookWorkflowActionRequest.builder()
                .signature(WebhookSignature.builder().key("8V8x0dLK%AyD*DNS8JJr").method("HMACSHA256").build())
                .headers(new HashMap<>())
                .url("https://docs.checkout.com/fail")
                .build();

        try {
            api.workflowsClient().updateWorkflowAction("workflow_id", "action_id", request).get();
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

