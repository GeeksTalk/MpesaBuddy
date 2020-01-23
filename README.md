### MpesaBuddy
M-Pesa Mobile(Android) Example for GeeksTalkThursday session on 23rd,January 2020

### Introduction
Payment Processing is an integral part on developing modern apps. This repo shows how to intergrate M-Pesa Payments on your mobile app. 

At [Apps:Lab](https://appslab.co.ke/) we usually prefer payment processing to be on an API and not the mobile app itself. This means our Android Developers do not have to manually integrate the M-Pesa Payment API's or even interact with the safaricom portal itself

### Why this approach
- Secure payments- With another layer, which is the API, there is another layer of security which comes with the API, as all API are token based and there is additional security measures on API. Integrating it manually on your mobile app code comes with additional duties as you have to ensure security on your own.
- Central place for all payments that is for all clients, be it web 
- No double effort by mobile and web teams to integrate payments as payment integration is central
- Easy to intergrate in all mobile apps

### What is Retrofit?
For those new to Android, we use [Retrofit](https://square.github.io/retrofit/) to consume API's and M-Pesa case is no different. 

There is no extra magic here, just the way you can consume other API's in Android is the same way you will consume the M-Pesa API.

### Other Approaches
- Using M-Pesa SDK - [Sample Project](https://github.com/jumaallan/AndroidMPesaAPI)
- Lipa Na Mpesa Online - [Sample Project](https://github.com/safaricom/LNMOnlineAndroidSample)
