package ru.vsu.cs;

import ru.vsu.cs.kg2020.nuzhnykh_a_v.task2.graphics_impl.MyFactoryImplementation;
import ru.vsu.cs.kg2020.nuzhnykh_a_v.task2.testing.TestArcs;

public class Main {

    public static void main(String[] args) throws Exception {
        TestArcs.startTest(new MyFactoryImplementation(), TestArcs.IMG_DIFF,
                TestArcs.TEST_ARC, true, "./KG2020_G41_Task2/src/ru/vsu/cs/testarcs");
    }
}
