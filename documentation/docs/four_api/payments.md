---
id: payments
title: Payments
---

The full list of request body parameters and possible outcomes can be found [here](https://api-reference.checkout.com/preview/crusoe/#tag/Payments).

Most operations support the option to pass an `idempotencyKey`.

## Request a payment or payout

Send a payment or payout.

```java
RequestCardSource source = RequestCardSource.builder().build(); // other sources are also supported
RequestIndividualSender sender = RequestIndividualSender.builder().build(); // other sender types are also supported
PaymentRequest request = Payments.card(source).individualSender(sender).build();

//or PaymentRequest request = Payments.card(source).individualSender(sender).build();

PaymentResponse response = api.paymentsClient().requestPayment(request).get();
```

```java
RequestCurrencyAccountSource source = RequestCurrencyAccountSource.builder().build(); // other sources are also supported
RequestCorporateSender sender = RequestCorporateSender.builder().build(); // other sender types are also supported
PayoutRequest request = Payouts.account(source).corporateSender(sender).build();

PayoutResponse response = api.paymentsClient().requestPayout(request).get();
```

## Get payment details

Returns the details of the payment with the specified identifier string.

```java
PaymentResponse response = api.paymentsClient().getPayment(id).get();
```

## Get payment actions

Returns all the actions associated with a payment ordered by processing date in descending order (latest first).

```java
List<PaymentAction> response = api.paymentsClient().getPaymentActions(paymentId).get();
```

## Capture a payment

Captures a payment if supported by the payment method.

```java
CaptureRequest captureRequest = CaptureRequest.builder()
    .reference()
    .metadata()
    .build();

CaptureResponse response = api.paymentsClient().capturePayment(paymentId, captureRequest).get();
```
## Refund a payment

Refunds a payment if supported by the payment method.

```java
RefundRequest refundRequest = RefundRequest.builder()
    .reference(UUID.randomUUID().toString())
    .build();

RefundResponse response = api.paymentsClient().refundPayment(paymentId, refundRequest).get();
```
## Void a payment 

Voids a payment if supported by the payment method.

```java
VoidRequest voidRequest = VoidRequest.builder()
    .reference(UUID.randomUUID().toString())
    .build();

VoidResponse response = api.paymentsClient().voidPayment(paymentId, voidRequest).get();
```

