public class Converter {

    final static double STEP_TO_KM = 0.00075;
    final static double STEP_TO_KKAL = 0.05;

    double kilometers(int step) {
        return step * STEP_TO_KM;
    }

    double kiloKal(int step) {
        return step * STEP_TO_KKAL;
    }

}