package sg.edu.ntu.singastays.exceptions;

public class InteractionNotFoundException extends RuntimeException  {
    public InteractionNotFoundException(Long id) {
        super("Unable to find interactions with id: "+ id + ",");
    }
}
