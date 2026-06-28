# DecodeLabs Java Project 4 - Currency Converter Engine

## Overview
A console-based Currency Converter Engine built in Java as part of the DecodeLabs Industrial Training Kit - Batch 2026. This was an optional milestone completed to demonstrate financial precision programming.

## How It Works
The system captures source currency, target currency, and amount from the user. It converts using USD as a pivot currency, meaning any currency pair can be converted without hardcoding every possible combination. BigDecimal ensures absolute arithmetic precision throughout.

## Features
- Supports 9 currencies: USD, INR, EUR, GBP, JPY, AUD, CAD, KWD, PKR
- Cross-rate routing via USD as pivot currency
- BigDecimal with HALF_EVEN rounding for financial precision
- Security gate rejects negative and invalid amounts
- Exception handling for invalid inputs using try-catch
- Multiple conversions in a single session using do-while loop
- Clean formatted output using printf with 2 decimal places
- Exchange rate display for every conversion

## Concepts Covered
- BigDecimal for financial arithmetic precision
- Switch statements for currency routing
- do-while loop for session persistence
- Input validation and exception handling
- Cross-rate calculation logic
- Formatted output with printf

## Supported Currencies
| Code | Currency |
|------|----------|
| USD  | US Dollar |
| INR  | Indian Rupee |
| EUR  | Euro |
| GBP  | British Pound |
| JPY  | Japanese Yen |
| AUD  | Australian Dollar |
| CAD  | Canadian Dollar |
| KWD  | Kuwaiti Dinar |
| PKR  | Pakistani Rupee |

## How to Run
javac DecodeLabs_Java_P4.java

java DecodeLabs_Java_P4

## Internship Details
- Organization: DecodeLabs
- Batch: 2026
- Project: 4 of Industrial Training Kit
- Language: Java
