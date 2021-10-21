package ru.dataart.academy.java;

public class ReverseInteger {
    /**
     * @param inputNumber - any integer value
     * @return - inputNumber in reversed order
     * Example: 1234 -> 4321
     * -23 -> -32
     * 120 -> 21
     * -2,147,483,648 -> exception and error message
     * If result (number in reversed order) is out of int range [-2,147,483,648,  2,147,483,647] throw custom
     * unchecked exception. In main method (Main class) if exception happened output message with problem to user.
     */
    public int reverse(int inputNumber) {
        String inputNumberStr = String.valueOf(inputNumber);
        boolean isNegative = inputNumber < 0;
        if (isNegative) {
            inputNumberStr = inputNumberStr.replace("-", "");
        }

        StringBuilder builder = new StringBuilder(inputNumberStr);
        builder.reverse();
        String reversedNumber = builder.toString();

        while (reversedNumber.startsWith("0") && reversedNumber.length() != 1) {
            reversedNumber = reversedNumber.substring(1);
        }

        try {
            int result = Integer.parseInt(reversedNumber);
            return isNegative ? result * (-1) : result;
        } catch (Exception e) {
            throw new IllegalStateException("The entered value when flipped will be higher than the maximum int value");
        }
    }
}
