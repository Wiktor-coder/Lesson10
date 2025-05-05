import java.lang.IllegalArgumentException;

public class PasswordChecker {
    private Integer minLength;
    private Integer maxRepeats;

    public void setMinLength(int minLength) {
        if (minLength < 0) {
            throw new IllegalArgumentException("Минимальная длинна не может быть отрицательной");
        }
        this.minLength = minLength;
    }

    public void setMaxRepeats(int maxRepeats) {
        if (maxRepeats <= 0) {
            throw new IllegalArgumentException("Минимальное количество повторений должно быть положительным");
        }
        this.maxRepeats = maxRepeats;
    }

    public boolean verify(String password) {
        if (minLength == null || maxRepeats == null) {
            throw new IllegalArgumentException("Параметры чекера не были установлены");
        }
        if (password.length() < minLength) return false;

        int currentRepeats = 1;
        for (int i = 1; i < password.length(); i++) {
            if (password.charAt(i) == password.charAt(i - 1)) {
                currentRepeats++;
                if (currentRepeats > maxRepeats) return false;
            } else {
                currentRepeats = 1;
            }
        }
        return true;
    }
}
