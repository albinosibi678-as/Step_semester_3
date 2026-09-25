public class LibraryIsbnValidator {
    public static String normalizeCode(String raw) {
        String trimmed = raw.trim();
        String publisherCode = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);
        return publisherCode + rest;
    }

    public static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        String publisherCode = code.substring(0, 3);
        String body = code.substring(3);

        for (int i = 0; i < publisherCode.length(); i++) {
            if (!Character.isLetter(publisherCode.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 0; i < body.length(); i++) {
            if (!Character.isDigit(body.charAt(i))) {
                return "Invalid: remaining characters must be digits";
            }
        }

        String year = body.substring(0, 4);
        String catalog = body.substring(4);

        StringBuilder formatted = new StringBuilder();
        formatted.append("[").append(publisherCode).append("] YEAR: ");
        formatted.append(year).append(" | CATALOG: ").append(catalog);

        return formatted.toString();
    }

    public static void main(String[] args) {
        String normalized1 = normalizeCode(" pen2026004251 ");
        System.out.println(validateAndFormat(normalized1));

        System.out.println(validateAndFormat("12N2026004251"));
    }
}