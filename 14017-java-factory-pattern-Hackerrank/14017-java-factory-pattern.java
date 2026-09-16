//creating the factory
            FoodFactory foodFactory = new FoodFactory();
    
            //factory instantiates an object
            Food food = foodFactory.getFood(sc.nextLine());
    
            
            System.out.println("The factory returned "+food.getClass());
            System.out.println(food.getType());
        }
        catch (Do_Not_Terminate.ExitTrappedException e) {
            System.out.println("Unsuccessful Termination!!");
        }
     }

    }
    class Do_Not_Terminate {
         
        public static class ExitTrappedException extends SecurityException {

            private static final long serialVersionUID = 1L;
        }
     
        public static void forbidExit() {
            final SecurityManager securityManager = new SecurityManager() {
                @Override
                public void checkPermission(Permission permission) {
                    if (permission.getName().contains("exitVM")) {
                        throw new ExitTrappedException();
                    }
                }
            };
            System.setSecurityManager(securityManager);
        }
    }

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna