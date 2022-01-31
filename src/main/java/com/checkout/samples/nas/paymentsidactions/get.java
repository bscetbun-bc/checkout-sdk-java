

import com.checkout.CheckoutApiException;
import com.checkout.CheckoutArgumentException;
import com.checkout.CheckoutAuthorizationException;
import com.checkout.CheckoutSdk;
import com.checkout.Environment;
import com.checkout.four.CheckoutApi;
import com.checkout.payments.four.PaymentAction;

import java.util.List;







        CheckoutApi api = CheckoutSdk.fourSdk()
                .staticKeys()
                .publicKey("public_key")
                .secretKey("secret_key")
                .environment(Environment.SANDBOX) // or Environment.PRODUCTION
                .build();

        try {
            List<PaymentAction> response = api.paymentsClient().getPaymentActions("payment_id").get();
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


