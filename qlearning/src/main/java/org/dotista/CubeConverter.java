package org.dotista;


import java.util.function.Function;

import static org.dotista.Constants.ATOM_HEIGHT;
import static org.dotista.Constants.ATOM_WIDTH;

public class CubeConverter implements Function<Atom, Cube> {

    @Override
    public Cube apply(Atom atom) {
        return new Cube(atom.getX(), atom.getY(), ATOM_WIDTH, ATOM_HEIGHT);
    }
}
