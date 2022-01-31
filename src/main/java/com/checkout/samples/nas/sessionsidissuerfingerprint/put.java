

import com.checkout.CheckoutApiException;
import com.checkout.CheckoutArgumentException;
import com.checkout.CheckoutAuthorizationException;
import com.checkout.CheckoutSdk;
import com.checkout.Environment;
import com.checkout.four.CheckoutApi;
import com.checkout.sessions.ThreeDsMethodCompletionRequest;
import com.checkout.sessions.channel.ThreeDsMethodCompletion;




public class put {



        CheckoutApi api = CheckoutSdk.fourSdk()
                .staticKeys()
                .publicKey("public_key")
                .secretKey("secret_key")
                .environment(Environment.SANDBOX) // or Environment.PRODUCTION
                .build();

        ThreeDsMethodCompletionRequest threeDsMethodCompletionRequest = ThreeDsMethodCompletionRequest.builder()
                .threeDsMethodCompletion(ThreeDsMethodCompletion.Y)
                .build();

        try {
            api.sessionsClient().update3dsMethodCompletionIndicator("session_id", threeDsMethodCompletionRequest).get();
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

