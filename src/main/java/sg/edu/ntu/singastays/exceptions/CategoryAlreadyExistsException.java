package sg.edu.ntu.singastays.exceptions;

public class CategoryAlreadyExistsException extends RuntimeException {
    public CategoryAlreadyExistsException(String name) {
        super("Category: " + name + " already exists.");
    }
}
