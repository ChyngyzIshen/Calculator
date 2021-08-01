package chyngyz.sharshekeev.calculator;

public class Roman extends Calculable {

    private String roman_value1;
    private String roman_value2;
    private int roman_value1_int;
    private int roman_value2_int;
    private int result_int;
    private String sign = "";
    private String result_string;
    private final String[] roman_letters_9 = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    Roman(String value1, String value2) {
        this.roman_value1 = value1;
        this.roman_value2 = value2;
        this.roman_value1_int = convert_to_int(roman_value1);
        this.roman_value2_int = convert_to_int(roman_value2);
    }

    private String convertResultToRoman(int n, int remain) {
        remain = n % 10;
        if (remain != 0) {
            try {
                return convertResultToRoman(n - remain, 0) + roman_letters_9[remain - 1];
            } catch (ArrayIndexOutOfBoundsException e) {
                sign = "-";
                return convertResultToRoman(n - remain, 0) + roman_letters_9[(remain + 1) * -1];
            }
        }
        if (n > 0){
            n = n - 10;
            return convertResultToRoman(n, 0) + "X";
        }else if (n < 0){
            n = n + 10;
            return convertResultToRoman(n, 0) + "X";
        }else{
            return sign;
        }
    }


    @Override
    public void addition() {
        result_int = roman_value1_int + roman_value2_int;
        result_string = convertResultToRoman(result_int, result_int);
    }

    @Override
    public void subtraction() {
        result_int = roman_value1_int - roman_value2_int;
        result_string = convertResultToRoman(result_int, result_int);
    }

    @Override
    public void multiple() {
        result_int = roman_value1_int * roman_value2_int;
        result_string = convertResultToRoman(result_int, result_int);
    }

    @Override
    public void division() {
        try{
            result_int = roman_value1_int / roman_value2_int;
            result_string = convertResultToRoman(result_int, result_int);
        }catch (ArithmeticException e){
            System.out.print("Invalid input");
            return;
        }

    }

    @Override
    public int getResult() {
        return result_int;
    }

    @Override
    public String getStringResult() {
        return result_string;
    }

    private int convert_to_int(String roman_value) {
        char[] value_char = roman_value.toCharArray();
        int[] values_int = new int[value_char.length];
        for (int i = 0; i < value_char.length; i++) {
            switch (value_char[i]) {
                case 'I':
                    values_int[i] = 1;
                    break;
                case 'V':
                    values_int[i] = 5;
                    break;
                case 'X':
                    values_int[i] = 10;
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
        }

        int result = values_int[0];
        for (int i = 0; i < values_int.length && values_int.length > i + 1; i++) {
            if (values_int[i] >= values_int[i+1]) {
                result += values_int[i+1];
            } else if (values_int[i] < values_int[i+1]) {
                result = result + values_int[i+1] - 2;
            }
        }
        return result;
    }

}
