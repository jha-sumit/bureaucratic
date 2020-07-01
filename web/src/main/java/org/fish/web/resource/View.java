package org.fish.web.resource;

/**
 * @author Sumit Jha
 */
public interface View {
    final static class FULL extends SMALL {
    }

    static class SMALL extends MINIMAL {
    }

    static class MINIMAL {
    }
}
