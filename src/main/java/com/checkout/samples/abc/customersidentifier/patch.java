

import com.checkout.CheckoutApi;
import com.checkout.CheckoutApiException;
import com.checkout.CheckoutArgumentException;
import com.checkout.CheckoutAuthorizationException;
import com.checkout.CheckoutSdk;
import com.checkout.Environment;
import com.checkout.common.Phone;
import com.checkout.customers.CustomerRequest;




public class patch {



        CheckoutApi api = CheckoutSdk.defaultSdk()
                .staticKeys()
                .publicKey("public_key")
                .secretKey("secret_key")
                .environment(Environment.SANDBOX) // or Environment.PRODUCTION
                .build();

        CustomerRequest request = CustomerRequest.builder()
                .email("email@docs.checkout.com")
                .name("name")
                .phone(Phone.builder().countryCode("+1").number("415 555 2671").build())
                .build();

        try {
            api.customersClient().update("customer_id", request).get();
        } catch (CheckoutApiException e) {
            // API error
            final String requestId = e.getRequestId();
            final int statusCode = e.getHttpStatusCode();
            final Map<String, Object> errorDetails = e.getErrorDetails();
        } catch (CheckoutArgumentException e) {
            // Bad arguments
        } catch (CheckoutAuthorizationException e) {
            // Invalid authorization
        }
