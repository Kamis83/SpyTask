package pl.kamis83.spy2.handlers;

abstract class BaseCommandHandler implements CommmandHandler {
    @Override
    public boolean supports(String name) {
        return getCommandName().equals(name);
    }

    protected abstract String getCommandName();

}
