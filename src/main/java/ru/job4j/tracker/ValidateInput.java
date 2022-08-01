package ru.job4j.tracker;

public class ValidateInput implements Input {

    private OutPut out;
    private Input in;

    public ValidateInput(Input in) {
        this.in = in;
    }

    public ValidateInput(OutPut out, Input in) {
        this.out = out;
        this.in = in;
    }

    @Override
    public String askStr(String question) {
        return in.askStr(question);
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = 1;
        do {
            try {
                value = in.askInt(question);
                invalid = false;
            } catch (NumberFormatException inf) {
                System.out.println("Please enter validate data again.");
            }
        } while (invalid);
        return value;
    }

}
