package sg.edu.ntu.singastays.exceptions;

public class AttractionNotFoundException extends RuntimeException {
    public AttractionNotFoundException(Long id) {
        super("Could not find attraction with id: " + id + ".");
    }

}
