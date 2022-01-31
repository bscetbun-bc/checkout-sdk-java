

import com.checkout.CheckoutSdk;
import com.checkout.Environment;
import com.checkout.four.CheckoutApi;





        // In order to use OAuth the SDK needs to be instantiated as follows:
        CheckoutApi api = CheckoutSdk.fourSdk()
                .oAuth()
                .clientCredentials("client_id", "client_secret")
                .environment(Environment.SANDBOX) // or Environment.PRODUCTION
                .build();

    }

}