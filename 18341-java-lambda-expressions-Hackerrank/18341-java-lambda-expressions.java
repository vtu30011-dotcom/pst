
public PerformOperation isOdd() { 
        return (n) -> n % 2 != 0; }
        public PerformOperation isPrime() {
             return (n) -> {
                 if (n < 2) { 
                    return false; }
                    for (int i = 2; i * i <= n; i++) { 
                        if (n % i == 0) { 
                            return false;
                             } 
                             } 
                             return true;
                              }; 
                              }
                              public PerformOperation isPalindrome() {
                                 return (n) -> { 
                                    int original = n; 
                                    int reverse = 0;
                                    while (n > 0) { 
                                        int digit = n % 10; 
                                        reverse = reverse * 10 + digit; 
                                        n /= 10; 
                                        }
                                        return original == reverse; 
                                        };
                                         } 
                                         }


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna