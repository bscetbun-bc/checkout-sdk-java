

import com.checkout.CheckoutApiException;
import com.checkout.CheckoutArgumentException;
import com.checkout.CheckoutAuthorizationException;
import com.checkout.CheckoutSdk;
import com.checkout.Environment;
import com.checkout.common.Phone;
import com.checkout.customers.four.CustomerRequest;
import com.checkout.four.CheckoutApi;

import java.util.Arrays;
import java.util.HashMap;



public class patch {



        CheckoutApi api = CheckoutSdk.fourSdk()
                .staticKeys()
                .publicKey("public_key")
                .secretKey("secret_key")
                .environment(Environment.SANDBOX) // or Environment.PRODUCTION
                .build();

        try {
            CustomerRequest customerRequest = CustomerRequest.builder()
                    .email("email@docs.checkout.com")
                    .name("name")
                    .phone(Phone.builder().countryCode("+1").number("4155552671").build())
                    .instruments(Arrays.asList("instrument_id_1", "instrument_id_2"))
                    .metadata(new HashMap<>())
                    .build();

            api.customersClient().update("customer_id", customerRequest).get();
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

