public class Task8_ValidationMethod {

    public static void main(String[] args) {

        // Validation method
        System.out.println("validateEmployeeCode(\"EMP-FIN-2042\") -> " + validateEmployeeCode("EMP-FIN-2042"));
        System.out.println("validateEmployeeCode(\"ABC-HR-12A4\") -> " + validateEmployeeCode("ABC-HR-12A4"));
    }

    public static boolean validateEmployeeCode(String code) {
        if (code == null){
            return false;
        }
        boolean starts = code.startsWith("EMP");
        boolean containsDash = code.contains("-");
        if (code.length() < 4) {
            return false;
        }

        String last4 = code.substring(code.length() - 4);

        boolean last4Digits = false;
        try{
            int digits = Integer.parseInt(last4);

            if(digits >= 1000 && digits <= 9999){
                last4Digits = true;
            }

        } catch (Exception e) {}

        boolean ends = code.endsWith(last4);

        return starts && containsDash && last4Digits && ends;
    }
}
