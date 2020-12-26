package ru.vsu.cs.kg2020.nuzhnykh_a_v.task2.graphics_impl;

import ru.vsu.cs.kg2020.nuzhnykh_a_v.task2.PieDrawer;
import ru.vsu.cs.kg2020.nuzhnykh_a_v.task2.PixelDrawer;
import ru.vsu.cs.kg2020.nuzhnykh_a_v.task2.graphics_impl.arc.ArcDrawerFactoryByPixelDrawer;
import ru.vsu.cs.kg2020.nuzhnykh_a_v.task2.graphics_impl.pie.PieDrawerFactoryByPixelDrawer;

public class MyFactoryImplementation extends PrimitivesFactoryWithDefaultGraphicsImplementation {
    @Override
    protected ArcDrawerFactoryByPixelDrawer getCustomArcDrawerFactory() {
        return new ArcDrawerFactoryByPixelDrawer() {
            @Override
            public ru.vsu.cs.kg2020.nuzhnykh_a_v.task2.ArcDrawer createInstance(ru.vsu.cs.kg2020.nuzhnykh_a_v.task2.PixelDrawer pd) {
                return new BresenhamArcDrawer(pd);
            }
        };
    }

    @Override
    protected PieDrawerFactoryByPixelDrawer getCustomPieDrawerFactory() {
        return new PieDrawerFactoryByPixelDrawer() {
            @Override
            public PieDrawer createInstance(PixelDrawer pd) {
                return new BresenhamPieDrawer(pd);
            }
        };
    }
}