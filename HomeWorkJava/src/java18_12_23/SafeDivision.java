package src.java18_12_23;

import java.util.Optional;

@FunctionalInterface
public interface SafeDivision {
    Optional<Double> divide(double a,double b);
}
