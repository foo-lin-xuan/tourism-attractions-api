package sg.edu.ntu.singastays.exceptions;

public class DeleteNonEmptyCategoryException extends RuntimeException {
    public DeleteNonEmptyCategoryException(Long id) {
        super("Category with id: " + id
                + " should not be associated with any attractions before deletion. Remove attraction(s) from category before deleting.");
    }
}
