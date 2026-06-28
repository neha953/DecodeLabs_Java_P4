import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class DecodeLabs_Java_P4 {

    // Predefined exchange rates (USD as base)
    static double getExchangeRate(String currency) {
        switch (currency) {
            case "USD": return 1.0;
            case "INR": return 83.50;
            case "EUR": return 0.92;
            case "GBP": return 0.79;
            case "JPY": return 149.50;
            case "AUD": return 1.53;
            case "CAD": return 1.36;
            case "KWD": return 0.31;
            case "PKR": return 278.50;
            default:    return -1;
        }
    }

    // Convert via USD pivot
    static BigDecimal convert(String from, String to, BigDecimal amount) {
        double fromRate = getExchangeRate(from);
        double toRate   = getExchangeRate(to);

        BigDecimal inUSD  = amount.divide(BigDecimal.valueOf(fromRate), 10, RoundingMode.HALF_EVEN);
        BigDecimal result = inUSD.multiply(BigDecimal.valueOf(toRate));
        return result.setScale(2, RoundingMode.HALF_EVEN);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println("  DECODELABS CURRENCY CONVERTER ENGINE   ");
        System.out.println("==========================================");

        String[] currencies = {"USD", "INR", "EUR", "GBP", "JPY", "AUD", "CAD", "KWD", "PKR"};

        boolean running = true;

        do {
            // Display currency menu
            System.out.println("\nAvailable Currencies:");
            for (int i = 0; i < currencies.length; i++) {
                System.out.println("  " + (i + 1) + ". " + currencies[i]);
            }

            // Select source currency
            int fromChoice = 0;
            while (true) {
                System.out.print("\nSelect SOURCE currency (1-9): ");
                try {
                    fromChoice = Integer.parseInt(sc.nextLine());
                    if (fromChoice >= 1 && fromChoice <= 9) break;
                    System.out.println("Invalid! Enter 1 to 9.");
                } catch (Exception e) {
                    System.out.println("Invalid input! Numbers only.");
                }
            }

            // Select target currency
            int toChoice = 0;
            while (true) {
                System.out.print("Select TARGET currency (1-9): ");
                try {
                    toChoice = Integer.parseInt(sc.nextLine());
                    if (toChoice >= 1 && toChoice <= 9) break;
                    System.out.println("Invalid! Enter 1 to 9.");
                } catch (Exception e) {
                    System.out.println("Invalid input! Numbers only.");
                }
            }

            String fromCurrency = currencies[fromChoice - 1];
            String toCurrency   = currencies[toChoice - 1];

            // Get amount - Security Gate
            BigDecimal amount = BigDecimal.ZERO;
            while (true) {
                System.out.print("Enter amount in " + fromCurrency + ": ");
                try {
                    amount = new BigDecimal(sc.nextLine());
                    if (amount.compareTo(BigDecimal.ZERO) <= 0) {
                        System.out.println("Invalid! Amount must be greater than 0.");
                        continue;
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid input! Enter a valid number.");
                }
            }

            // Convert
            BigDecimal result = convert(fromCurrency, toCurrency, amount);

            // Display result
            System.out.println("\n==========================================");
            System.out.println("           CONVERSION RESULT             ");
            System.out.println("==========================================");
            System.out.printf("  From   : %s %,.2f%n", fromCurrency, amount);
            System.out.printf("  To     : %s %,.2f%n", toCurrency, result);
            System.out.printf("  Rate   : 1 %s = %.4f %s%n",
                fromCurrency,
                getExchangeRate(toCurrency) / getExchangeRate(fromCurrency),
                toCurrency);
            System.out.println("==========================================");

            // Convert again
            System.out.print("\nConvert again? (Y/N): ");
            String again = sc.nextLine().trim().toUpperCase();
            running = again.equals("Y");

        } while (running);

        System.out.println("\nThank you for using DecodeLabs Currency Converter!");
        sc.close();
    }
}