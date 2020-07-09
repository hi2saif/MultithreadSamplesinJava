package ThreadMainApplication;

import java.math.BigInteger;



//Code for using Join

public class BigIntegerCalculation {
    public BigInteger calculateResult(BigInteger base1,
                                      BigInteger power1,
                                      BigInteger base2,
                                      BigInteger power2) {

        BigInteger result;
        PowerCalculate thread1 = new PowerCalculate(base1, power1);
        PowerCalculate thread2 = new PowerCalculate(base2, power2);

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        result = thread1.getResult().add(thread2.getResult());
        return result;
    }

    private static class PowerCalculate extends Thread {

        private BigInteger result = BigInteger.ONE;
        private BigInteger base;
        private BigInteger power;

        PowerCalculate(BigInteger base1,
                       BigInteger power1) {

            this.base = base1;
            this.power = power1;
        }

        @Override
        public void run() {
            result = BigInteger.ONE;

            for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
                result = result.multiply(base);
            }
        }

        public BigInteger getResult() {
            return result;
        }
    }
    }

